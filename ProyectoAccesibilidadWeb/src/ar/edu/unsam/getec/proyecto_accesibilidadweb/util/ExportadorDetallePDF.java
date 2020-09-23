package ar.edu.unsam.getec.proyecto_accesibilidadweb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionCriterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;

public class ExportadorDetallePDF {
	
	private String archivoSalida;
	private String recurso;
	private String fechaHora;
	private Document documento;
	private List<ResultadoEvaluacionPrincipio> resultado;
	private String codigoHTML;
	private static final String PAUTAS = "WCAG 2.0";
	private static final String NIVEL_ACCESIBILIDAD = "A" + " " + "(umbral: " + Constantes.PUNTAJE_UMBRAL + " puntos)";
	private static final String TECNOLOGIAS_VERIFICADAS = "HTML y CSS";

	public ExportadorDetallePDF(String recurso, List<ResultadoEvaluacionPrincipio> resultados, String codigoHTML, File file) throws Exception {
		String archivoSalida = file.getPath();
		this.setArchivoSalida(archivoSalida);
		this.setRecurso(recurso);
		this.setFechaHora(new SimpleDateFormat().format(new Date()));
		this.setDocumento(new Document());
		this.setResultado(resultados);
		this.setCodigoHTML(codigoHTML);
		this.getDocumento().setPageSize(PageSize.A4);
		PdfWriter.getInstance(documento, new FileOutputStream(this.getArchivoSalida())).setInitialLeading(5);
		this.getDocumento().open();
	}

	public void exportar() throws Exception {
		this.exportarCabecera();
		this.exportarDetalle();
		this.getDocumento().close();
	}

	private void exportarCabecera() throws Exception {
		this.getDocumento().add(new Paragraph("Información de Análisis de Accesibilidad Web"));
		this.getDocumento().add(new Paragraph(" "));
		this.getDocumento().add(new LineSeparator());
		this.getDocumento().add(new Paragraph("Recurso: " + this.getRecurso()));
		this.getDocumento().add(new Paragraph("Fecha: " + this.getFechaHora()));
		this.getDocumento().add(new Paragraph("Pautas Aplicadas: " + ExportadorDetallePDF.PAUTAS));
		this.getDocumento().add(new Paragraph("Nivel Accesibilidad: " + ExportadorDetallePDF.NIVEL_ACCESIBILIDAD));
		this.getDocumento().add(new Paragraph("Tecnologías Verificadas: " + ExportadorDetallePDF.TECNOLOGIAS_VERIFICADAS));
		this.getDocumento().add(new Paragraph(" "));
	}

	private void exportarDetalle() throws Exception {
		PdfPTable tabla = new PdfPTable(1);
		tabla.setWidthPercentage(100);

		Font fontPrincipio = new Font(FontFamily.TIMES_ROMAN, 12.0f, Font.BOLD);
		Font fontPauta = new Font(FontFamily.TIMES_ROMAN, 11.0f, Font.BOLD);
		Font fontCriterio = new Font(FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD);
		Font fontTecnica = new Font(FontFamily.TIMES_ROMAN, 9.0f, Font.BOLD);
		Font fontTecnicaItem = new Font(FontFamily.TIMES_ROMAN, 8.0f, Font.BOLD);
		Font fontLineaHTML = new Font(FontFamily.TIMES_ROMAN, 7.0f, Font.ITALIC);

		PdfPCell celdaPrincipio = new PdfPCell();
		celdaPrincipio.setBackgroundColor(new BaseColor(Constantes.COLOR_PRINCIPIO.getRojo(), Constantes.COLOR_PRINCIPIO.getVerde(), Constantes.COLOR_PRINCIPIO.getAzul()));

		PdfPCell celdaPauta = new PdfPCell();
		celdaPauta.setBackgroundColor(new BaseColor(Constantes.COLOR_PAUTA.getRojo(), Constantes.COLOR_PAUTA.getVerde(), Constantes.COLOR_PAUTA.getAzul()));

		PdfPCell celdaCriterio = new PdfPCell();
		celdaCriterio.setBackgroundColor(new BaseColor(Constantes.COLOR_CRITERIO.getRojo(), Constantes.COLOR_CRITERIO.getVerde(), Constantes.COLOR_CRITERIO.getAzul()));

		PdfPCell celdaTecnica = new PdfPCell();
		celdaTecnica.setBackgroundColor(new BaseColor(Constantes.COLOR_TECNICA.getRojo(), Constantes.COLOR_TECNICA.getVerde(), Constantes.COLOR_TECNICA.getAzul()));

		PdfPCell celdaTecnicaItem = new PdfPCell();
		celdaTecnicaItem.setBackgroundColor(new BaseColor(Constantes.COLOR_TECNICA_ITEM.getRojo(), Constantes.COLOR_TECNICA_ITEM.getVerde(), Constantes.COLOR_TECNICA_ITEM.getAzul()));

		for (ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio : this.getResultado()) {
			celdaPrincipio.setPhrase(new Paragraph(resultadoEvaluacionPrincipio.getPrincipio().toString()	+ " " + resultadoEvaluacionPrincipio.getPrincipio().getNombre(), fontPrincipio));
			tabla.addCell(celdaPrincipio);
			for (ResultadoEvaluacionPauta resultadoEvaluacionPauta : resultadoEvaluacionPrincipio.getResultadoEvaluacionPautas()) {
				celdaPauta.setPhrase(new Paragraph(resultadoEvaluacionPauta.getPauta().toString() + " " + resultadoEvaluacionPauta.getPauta().getNombre(), fontPauta));
				tabla.addCell(celdaPauta);
				for (ResultadoEvaluacionCriterio resultadoEvaluacionCriterio : resultadoEvaluacionPauta.getResultadoEvaluacionCriterios()) {
					celdaCriterio.setPhrase(new Paragraph(resultadoEvaluacionCriterio.getCriterio().toString() + " " + resultadoEvaluacionCriterio.getCriterio().getNombre(), fontCriterio));
					tabla.addCell(celdaCriterio);
					for (ResultadoEvaluacionTecnica resultadoEvaluacionTecnica : resultadoEvaluacionCriterio.getResultadoEvaluacionTecnicas()) {
						celdaTecnica.setPhrase(new Paragraph(resultadoEvaluacionTecnica.getTecnica().toString() + " " + resultadoEvaluacionTecnica.getTecnica().getNombre(), fontTecnica));
						tabla.addCell(celdaTecnica);
						for (ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem : resultadoEvaluacionTecnica.getResultadoEvaluacionTecnicaItems()) {
							float[] medidaCeldas = {0.2f, 9.8f};

							PdfPTable tablaItemComprobacion = new PdfPTable(2);
							tablaItemComprobacion.setWidths(medidaCeldas);
							celdaTecnicaItem.setImage(Image.getInstance(this.getClass().getResource(resultadoEvaluacionTecnicaItem.getTipoResultadoEvaluacion().getRepresentacionPathImagen())));
							tablaItemComprobacion.addCell(celdaTecnicaItem);
							celdaTecnicaItem.setPhrase(new Paragraph(resultadoEvaluacionTecnicaItem.getNombre(), fontTecnicaItem));
							tablaItemComprobacion.addCell(celdaTecnicaItem);
							tabla.addCell(tablaItemComprobacion);

							PdfPTable tablaItemVerificacion = new PdfPTable(2);
							tablaItemVerificacion.setWidths(medidaCeldas);
							celdaTecnicaItem.setImage(Image.getInstance(this.getClass().getResource(Constantes.PATH_IMAGE_VERIFICACION)));
							tablaItemVerificacion.addCell(celdaTecnicaItem);
							celdaTecnicaItem.setPhrase(new Paragraph(resultadoEvaluacionTecnicaItem.getDescripcion(), fontTecnicaItem));
							tablaItemVerificacion.addCell(celdaTecnicaItem);
							tabla.addCell(tablaItemVerificacion);

							PdfPTable tablaItemRecomendacion = new PdfPTable(2);
							tablaItemRecomendacion.setWidths(medidaCeldas);
							celdaTecnicaItem.setImage(Image.getInstance(this.getClass().getResource(Constantes.PATH_IMAGE_RECOMENDACION)));
							tablaItemRecomendacion.addCell(celdaTecnicaItem);
							celdaTecnicaItem.setPhrase(new Paragraph(resultadoEvaluacionTecnicaItem.getRecomendacion(), fontTecnicaItem));
							tablaItemRecomendacion.addCell(celdaTecnicaItem);
							tabla.addCell(tablaItemRecomendacion);

							for (String linea : resultadoEvaluacionTecnicaItem.getLineas()) {
								tabla.addCell(new Paragraph(linea, fontLineaHTML));
							}
						}
					}
				}
			}
		}	
		this.getDocumento().add(tabla);
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

	public Document getDocumento() {
		return this.documento;
	}

	public void setDocumento(Document documento) {
		this.documento = documento;
	}

	public List<ResultadoEvaluacionPrincipio> getResultado() {
		return this.resultado;
	}

	public void setResultado(List<ResultadoEvaluacionPrincipio> resultado) {
		this.resultado = resultado;
	}

	public String getCodigoHTML() {
		return this.codigoHTML;
	}

	public void setCodigoHTML(String codigoHTML) {
		this.codigoHTML = codigoHTML;
	}	

}