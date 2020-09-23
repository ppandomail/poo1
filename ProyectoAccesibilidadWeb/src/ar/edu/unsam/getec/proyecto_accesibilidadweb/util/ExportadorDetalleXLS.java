package ar.edu.unsam.getec.proyecto_accesibilidadweb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionCriterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.Orientation;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExportadorDetalleXLS {
	
	private String archivoSalida;
	private String recurso;
	private String fechaHora;
	private WritableWorkbook workBook;
	private WritableSheet writableSheet;
	private WritableCellFormat writableCellFormatBoldUnderline;
	private WritableCellFormat writableCellFormatTimes;
	private List<ResultadoEvaluacionPrincipio> resultado;
	private static final String PAUTAS = "WCAG 2.0";
	private static final String NIVEL_ACCESIBILIDAD = "A" + " " + "(umbral: " + Constantes.PUNTAJE_UMBRAL + " puntos)";
	private static final String TECNOLOGIAS_VERIFICADAS = "HTML y CSS";

	public ExportadorDetalleXLS(String recurso, List<ResultadoEvaluacionPrincipio> resultados, File file) throws Exception {
		String archivoSalida = file.getPath();
		this.setArchivoSalida(archivoSalida);
		this.setRecurso(recurso);
		this.setFechaHora(new SimpleDateFormat().format(new Date()));
		WorkbookSettings wbSettings = new WorkbookSettings();
		wbSettings.setLocale(new Locale("es", "ES"));
		this.setWorkBook(Workbook.createWorkbook(file, wbSettings));
		this.getWorkBook().createSheet("Reporte", 0);
		this.setWritableSheet(this.getWorkBook().getSheet(0));
		this.setWritableCellFormatBoldUnderline(new WritableCellFormat(new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD, Boolean.FALSE, UnderlineStyle.SINGLE)));
		this.getWritableCellFormatBoldUnderline().setWrap(Boolean.FALSE);
		this.setWritableCellFormatTimes(new WritableCellFormat(new WritableFont(WritableFont.TIMES, 10)));
		this.getWritableCellFormatTimes().setWrap(Boolean.FALSE);
		this.setResultado(resultados);
	}

	public void exportar() throws Exception {
		this.exportarCabecera();
		this.exportarDetalle();
		this.exportarResultadosPorCriterio();
		this.getWorkBook().write();
		this.getWorkBook().close();
	}

	private void exportarCabecera() throws Exception {
		for (Integer i = 0; i <= 13; i++)
			this.getWritableSheet().setColumnView(i, 3);
		this.getWritableSheet().addCell(new Label(0, 0, "Información de Análisis de Accesibilidad Web", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Label(0, 1, "Recurso:", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Label(7, 1, this.getRecurso(), this.getWritableCellFormatTimes()));
		this.getWritableSheet().addCell(new Label(0, 2, "Fecha:", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Label(7, 2, this.getFechaHora(), this.getWritableCellFormatTimes()));
		this.getWritableSheet().addCell(new Label(0, 3, "Pautas Aplicadas:", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Label(7, 3, ExportadorDetalleXLS.PAUTAS, this.getWritableCellFormatTimes()));
		this.getWritableSheet().addCell(new Label(0, 4, "Nivel Accesibilidad:", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Label(7, 4, ExportadorDetalleXLS.NIVEL_ACCESIBILIDAD, this.getWritableCellFormatTimes()));
		this.getWritableSheet().addCell(new Label(0, 5, "Tecnologías Verificadas:", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Label(7, 5, ExportadorDetalleXLS.TECNOLOGIAS_VERIFICADAS, this.getWritableCellFormatTimes()));
	}

	private void exportarDetalle() throws Exception {
		Integer filaPrincipio = 10;
		Integer filaPauta = 10;
		Integer filaCriterio = 10;
		Integer filaTecnica = 10;
		Integer filaTecnicaItem = 10;
		Integer filaLinea = 10;

		this.getWritableSheet().addCell(new Label(2, 8, "Puntajes", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Label(7, 8, "WCAG 2.0", this.getWritableCellFormatBoldUnderline()));

		WritableCellFormat writableCellFormatOrientationStackedPrincipio = new WritableCellFormat();
		writableCellFormatOrientationStackedPrincipio.setOrientation(Orientation.STACKED);
		writableCellFormatOrientationStackedPrincipio.setBackground(Colour.SKY_BLUE);

		WritableCellFormat writableCellFormatOrientationStackedPauta = new WritableCellFormat();
		writableCellFormatOrientationStackedPauta.setOrientation(Orientation.STACKED);
		writableCellFormatOrientationStackedPauta.setBackground(Colour.LIGHT_TURQUOISE);

		WritableCellFormat writableCellFormatOrientationStackedCriterio = new WritableCellFormat();
		writableCellFormatOrientationStackedCriterio.setOrientation(Orientation.STACKED);
		writableCellFormatOrientationStackedCriterio.setBackground(Colour.LIGHT_GREEN);

		WritableCellFormat writableCellFormatOrientationStackedTecnica = new WritableCellFormat();
		writableCellFormatOrientationStackedTecnica.setOrientation(Orientation.STACKED);
		writableCellFormatOrientationStackedTecnica.setBackground(Colour.TAN);

		WritableCellFormat writableCellFormatOrientationStackedTecnicaItem = new WritableCellFormat();
		writableCellFormatOrientationStackedTecnicaItem.setOrientation(Orientation.STACKED);
		writableCellFormatOrientationStackedTecnicaItem.setBackground(Colour.VERY_LIGHT_YELLOW);

		this.getWritableSheet().addCell(new Label(0, 9, "VERIFICACIONES", writableCellFormatOrientationStackedTecnicaItem));
		this.getWritableSheet().addCell(new Label(1, 9, "TECNICAS", writableCellFormatOrientationStackedTecnica));
		this.getWritableSheet().addCell(new Label(2, 9, "CRITERIOS", writableCellFormatOrientationStackedCriterio));
		this.getWritableSheet().addCell(new Label(3, 9, "PAUTAS", writableCellFormatOrientationStackedPauta));
		this.getWritableSheet().addCell(new Label(4, 9, "PRINCIPIOS", writableCellFormatOrientationStackedPrincipio));

		this.getWritableSheet().addCell(new Label(7, 9, "PRINCIPIOS", writableCellFormatOrientationStackedPrincipio));
		this.getWritableSheet().addCell(new Label(8, 9, "PAUTAS", writableCellFormatOrientationStackedPauta));
		this.getWritableSheet().addCell(new Label(9, 9, "CRITERIOS", writableCellFormatOrientationStackedCriterio));
		this.getWritableSheet().addCell(new Label(10, 9, "TECNICAS", writableCellFormatOrientationStackedTecnica));
		this.getWritableSheet().addCell(new Label(11, 9, "VERIFICACIONES", writableCellFormatOrientationStackedTecnicaItem));

		for (ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio : this.getResultado()) {
			this.getWritableSheet().addCell(new Label(7, filaPrincipio, resultadoEvaluacionPrincipio.getPrincipio().toString()	+ " " + resultadoEvaluacionPrincipio.getPrincipio().getNombre(), this.getWritableCellFormatTimes()));
			filaPrincipio++;
			filaPauta = filaPrincipio;
			for (ResultadoEvaluacionPauta resultadoEvaluacionPauta : resultadoEvaluacionPrincipio.getResultadoEvaluacionPautas()) {
				this.getWritableSheet().addCell(new Label(8, filaPauta, resultadoEvaluacionPauta.getPauta().toString() + " " + resultadoEvaluacionPauta.getPauta().getNombre(), this.getWritableCellFormatTimes())); 
				filaPauta++;
				filaCriterio = filaPauta;
				for (ResultadoEvaluacionCriterio resultadoEvaluacionCriterio : resultadoEvaluacionPauta.getResultadoEvaluacionCriterios()) {
					this.getWritableSheet().addCell(new Label(9, filaCriterio, resultadoEvaluacionCriterio.getCriterio().toString() + " " + resultadoEvaluacionCriterio.getCriterio().getNombre(), this.getWritableCellFormatTimes())); 
					filaCriterio++;
					filaTecnica = filaCriterio;
					for (ResultadoEvaluacionTecnica resultadoEvaluacionTecnica : resultadoEvaluacionCriterio.getResultadoEvaluacionTecnicas()) {
						this.getWritableSheet().addCell(new Label(10, filaTecnica, resultadoEvaluacionTecnica.getTecnica().toString() + " " + resultadoEvaluacionTecnica.getTecnica().getNombre(), this.getWritableCellFormatTimes()));  
						filaTecnica++;
						filaTecnicaItem = filaTecnica;
						for (ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem : resultadoEvaluacionTecnica.getResultadoEvaluacionTecnicaItems()) {
							this.getWritableSheet().addImage(new WritableImage(11, filaTecnicaItem, 1, 1, this.getFile(resultadoEvaluacionTecnicaItem.getTipoResultadoEvaluacion().getRepresentacionPathImagen())));
							this.getWritableSheet().addCell(new Label(12, filaTecnicaItem, resultadoEvaluacionTecnicaItem.getNombre(), this.getWritableCellFormatTimes()));
							filaTecnicaItem++;

							this.getWritableSheet().addImage(new WritableImage(11, filaTecnicaItem, 1, 1, this.getFile(Constantes.PATH_IMAGE_VERIFICACION)));
							this.getWritableSheet().addCell(new Label(12, filaTecnicaItem, resultadoEvaluacionTecnicaItem.getDescripcion(), this.getWritableCellFormatTimes()));
							filaTecnicaItem++;

							this.getWritableSheet().addImage(new WritableImage(11, filaTecnicaItem, 1, 1, this.getFile(Constantes.PATH_IMAGE_RECOMENDACION)));
							this.getWritableSheet().addCell(new Label(12, filaTecnicaItem, resultadoEvaluacionTecnicaItem.getRecomendacion(), this.getWritableCellFormatTimes()));
							filaTecnicaItem++;

							filaLinea = filaTecnicaItem;
							for (String linea : resultadoEvaluacionTecnicaItem.getLineas()) {
								this.getWritableSheet().addCell(new Label(13, filaLinea, Utilidades.truncarLineaHasta(linea, 1000), this.getWritableCellFormatTimes()));
								filaLinea++;
							}
							//NOTE: Si hay error y la técnica es suficiente => 0
							if (resultadoEvaluacionTecnicaItem.isErrorTipoResultadoEvaluacion() && (resultadoEvaluacionTecnica.getTecnica().isCategoriaTecnicaSuficiente()))
								this.getWritableSheet().addCell(new Number(0, filaTecnicaItem-3, 0, this.getWritableCellFormatTimes()));
							else
								this.getWritableSheet().addCell(new Number(0, filaTecnicaItem-3, 1, this.getWritableCellFormatTimes()));
							filaTecnicaItem = filaLinea;
						}
						this.getWritableSheet().addCell(new Formula(1, filaTecnica-1, "SI(SUMA(A" + (filaTecnica+1) + ":A" + filaTecnicaItem + ")=" + resultadoEvaluacionTecnica.getResultadoEvaluacionTecnicaItems().size() + ",1,0)"));
						filaTecnica = filaTecnicaItem;	
					}
					this.getWritableSheet().addCell(new Formula(2, filaCriterio-1, "SI(SUMA(B" + (filaCriterio+1) + ":B" + filaTecnica + ")=" + resultadoEvaluacionCriterio.getResultadoEvaluacionTecnicas().size() + ",4,0)"));
					filaCriterio = filaTecnica;
				}
				this.getWritableSheet().addCell(new Formula(3, filaPauta-1, "SUMA(C" + (filaPauta+1) + ":C" + filaCriterio + ")"));
				filaPauta = filaCriterio;
			}
			this.getWritableSheet().addCell(new Formula(4, filaPrincipio-1, "SUMA(D" + (filaPrincipio+1) + ":D" + filaPauta + ")"));
			filaPrincipio = filaPauta;
		}
		this.getWritableSheet().addCell(new Label(0, filaPrincipio+1, "TOTAL: ", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Formula(4, filaPrincipio+1, "SUMA(E11:E" + filaPrincipio + ")", this.getWritableCellFormatBoldUnderline()));
		this.getWritableSheet().addCell(new Formula(5, filaPrincipio+1, "SI(SUMA(E11:E" + filaPrincipio + ")>=" + Constantes.PUNTAJE_UMBRAL + ",\"" + Constantes.MENSAJE_ACCESIBLE + "\",\"" + Constantes.MENSAJE_NO_ACCESIBLE + "\")" , this.getWritableCellFormatBoldUnderline()));
	}

	private File getFile(String path) throws Exception {
		URL res = getClass().getResource(path);
		if (res.toString().startsWith("file:/C:")) 
			return new File(res.getFile());
		InputStream input = getClass().getResourceAsStream(path);
		File file = File.createTempFile(new Date().getTime()+"", ".png");
		OutputStream out = new FileOutputStream(file);
		int read;
		byte[] bytes = new byte[1024];
		while ((read = input.read(bytes)) != -1) 
			out.write(bytes, 0, read);
		out.flush();
		out.close();
		input.close();
		file.deleteOnExit();
		return file;
	}
	
	private void exportarResultadosPorCriterio() throws Exception { 
		this.getWorkBook().createSheet("Resultados por Criterio", 1);
		WritableSheet writableSheet = this.getWorkBook().getSheet(1);
		
		WritableCellFormat writableCellFormatAlignmetCENTRE = new WritableCellFormat(new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD, Boolean.FALSE, UnderlineStyle.NO_UNDERLINE));
		writableCellFormatAlignmetCENTRE.setAlignment(Alignment.CENTRE);
		
		WritableCellFormat writableCellFormatITALICAlignmetCENTRE = new WritableCellFormat(new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD, Boolean.TRUE, UnderlineStyle.NO_UNDERLINE));
		writableCellFormatITALICAlignmetCENTRE.setAlignment(Alignment.CENTRE);
		
		WritableCellFormat writableCellFormatAlignmetRIGHT = new WritableCellFormat(new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD, Boolean.FALSE, UnderlineStyle.NO_UNDERLINE));
		writableCellFormatAlignmetRIGHT.setAlignment(Alignment.RIGHT);
		
		
		writableSheet.addCell(new Label(0, 3, "Fecha eval: ", writableCellFormatAlignmetCENTRE));
		writableSheet.addCell(new Label(0, 4, "Hora eval: ", writableCellFormatAlignmetCENTRE));
		
		writableSheet.addCell(new Label(1, 3, " " + this.getFechaHora().split(" ")[0], this.getWritableCellFormatTimes()));
		writableSheet.addCell(new Label(1, 4, " " + this.getFechaHora().split(" ")[1], this.getWritableCellFormatTimes()));
				
		writableSheet.addCell(new Label(2, 2, "Problemas", writableCellFormatAlignmetRIGHT));
		writableSheet.addCell(new Label(2, 3, "Advert.", writableCellFormatAlignmetRIGHT));
		writableSheet.addCell(new Label(2, 4, "No Verif.", writableCellFormatAlignmetRIGHT));
		
		Integer columna = 3;
		Integer cantidadCriteriosFallidos = 0;
		LinkedList<String> criteriosConformidadFallidos = new LinkedList<>();
		
		for (ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio : this.getResultado()) 
			for (ResultadoEvaluacionPauta resultadoEvaluacionPauta : resultadoEvaluacionPrincipio.getResultadoEvaluacionPautas()) 
				for (ResultadoEvaluacionCriterio resultadoEvaluacionCriterio : resultadoEvaluacionPauta.getResultadoEvaluacionCriterios()) {
					writableSheet.addCell(new Label(columna, 0, resultadoEvaluacionCriterio.getCriterio().toString(), writableCellFormatITALICAlignmetCENTRE));
					writableSheet.mergeCells(columna, 0, columna+1, 0);
					writableSheet.addCell(new Label(columna, 1, "S", writableCellFormatITALICAlignmetCENTRE));
					writableSheet.addCell(new Number(columna, 2, resultadoEvaluacionCriterio.getCantidadErrorPorCriterioTecnicasSuficiente(), this.getWritableCellFormatTimes())); 
					if (resultadoEvaluacionCriterio.getCantidadErrorPorCriterioTecnicasSuficiente() > 0) {
						cantidadCriteriosFallidos++;
						criteriosConformidadFallidos.add(resultadoEvaluacionCriterio.getCriterio().toString());
					}	
					writableSheet.addCell(new Number(columna, 3, resultadoEvaluacionCriterio.getCantidadManualPorCriterioTecnicasSuficiente(), this.getWritableCellFormatTimes())); 
					writableSheet.addCell(new Number(columna, 4, resultadoEvaluacionCriterio.getCantidadImposiblePorCriterioTecnicasSuficiente(), this.getWritableCellFormatTimes())); 
					columna++;
					writableSheet.addCell(new Label(columna, 1, "R", writableCellFormatITALICAlignmetCENTRE));
					writableSheet.addCell(new Number(columna, 2, resultadoEvaluacionCriterio.getCantidadErrorPorCriterioTecnicasRecomendable(), this.getWritableCellFormatTimes())); 
					writableSheet.addCell(new Number(columna, 3, resultadoEvaluacionCriterio.getCantidadManualPorCriterioTecnicasRecomendable(), this.getWritableCellFormatTimes())); 
					writableSheet.addCell(new Number(columna, 4, resultadoEvaluacionCriterio.getCantidadImposiblePorCriterioTecnicasRecomendable(), this.getWritableCellFormatTimes())); 
					columna++;
				}
		if (columna != 3) {
			writableSheet.addCell(new Label(columna, 0, "TOTAL", writableCellFormatAlignmetCENTRE));
			writableSheet.mergeCells(columna, 0, columna, 1);
			String [] nombreColumnas = new String [] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", 
													 "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM", "AN", "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AW", "AX", "AY", "AZ",
													 "BA", "BB", "BC", "BD"};
			writableSheet.addCell(new Formula(columna, 2, "SUMA(D3:" + nombreColumnas[columna-1] + "3)", this.getWritableCellFormatTimes()));
			writableSheet.addCell(new Formula(columna, 3, "SUMA(D4:" + nombreColumnas[columna-1] + "4)", this.getWritableCellFormatTimes()));
			writableSheet.addCell(new Formula(columna, 4, "SUMA(D5:" + nombreColumnas[columna-1] + "5)", this.getWritableCellFormatTimes()));
		}
		
		writableSheet.addCell(new Label(0, 6, "Han fallado " + cantidadCriteriosFallidos + " Criterios de Conformidad:", this.getWritableCellFormatTimes()));
		Integer fila = 6;
		for (String criterioConformidadFallido : criteriosConformidadFallidos) {
			writableSheet.addCell(new Label(4, fila, criterioConformidadFallido, writableCellFormatAlignmetCENTRE));
			fila++;
		}
	}

	public String getArchivoSalida() {
		return this.archivoSalida;
	}

	public void setArchivoSalida(String archivoSalida) {
		this.archivoSalida = archivoSalida;
	}

	public String getRecurso() {
		return this.recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public WritableWorkbook getWorkBook() {
		return this.workBook;
	}

	public void setWorkBook(WritableWorkbook workBook) {
		this.workBook = workBook;
	}

	public WritableSheet getWritableSheet() {
		return this.writableSheet;
	}

	public void setWritableSheet(WritableSheet writableSheet) {
		this.writableSheet = writableSheet;
	}

	public WritableCellFormat getWritableCellFormatBoldUnderline() {
		return this.writableCellFormatBoldUnderline;
	}

	public void setWritableCellFormatBoldUnderline(WritableCellFormat writableCellFormatBoldUnderline) {
		this.writableCellFormatBoldUnderline = writableCellFormatBoldUnderline;
	}

	public WritableCellFormat getWritableCellFormatTimes() {
		return this.writableCellFormatTimes;
	}

	public void setWritableCellFormatTimes(WritableCellFormat writableCellFormatTimes) {
		this.writableCellFormatTimes = writableCellFormatTimes;
	}

	public List<ResultadoEvaluacionPrincipio> getResultado() {
		return this.resultado;
	}

	public void setResultado(List<ResultadoEvaluacionPrincipio> resultado) {
		this.resultado = resultado;
	}

}
