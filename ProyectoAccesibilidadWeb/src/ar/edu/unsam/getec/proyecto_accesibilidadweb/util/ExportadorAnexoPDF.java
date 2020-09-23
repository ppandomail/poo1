package ar.edu.unsam.getec.proyecto_accesibilidadweb.util;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionCriterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;

public class ExportadorAnexoPDF {
	
	private String archivoSalida;
	private String recurso;
	private String fechaHora;
	private Document documento;
	private List<ResultadoEvaluacionPrincipio> resultado;
	private static final String PAUTAS = "WCAG 2.0";
	private static final String NIVEL_ACCESIBILIDAD = "A" + " " + "(umbral: " + Constantes.PUNTAJE_UMBRAL + " puntos)";
	private static final String TECNOLOGIAS_VERIFICADAS = "HTML y CSS";

	public ExportadorAnexoPDF(String recurso, List<ResultadoEvaluacionPrincipio> resultados, File file) throws Exception {
		String archivoSalida = file.getPath();
		this.setArchivoSalida(archivoSalida);
		this.setRecurso(recurso);
		this.setFechaHora(new SimpleDateFormat().format(new Date()));
		this.setDocumento(new Document());
		this.setResultado(resultados);
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
		this.getDocumento().add(new Paragraph("Pautas Aplicadas: " + ExportadorAnexoPDF.PAUTAS));
		this.getDocumento().add(new Paragraph("Nivel Accesibilidad: " + ExportadorAnexoPDF.NIVEL_ACCESIBILIDAD));
		this.getDocumento().add(new Paragraph("Tecnologías Verificadas: " + ExportadorAnexoPDF.TECNOLOGIAS_VERIFICADAS));
		this.getDocumento().add(new Paragraph(" "));
	}

	private void exportarDetalle() throws Exception {
		int puntosTotal = 0;
		PdfPTable tabla = new PdfPTable(5);
		tabla.setWidthPercentage(100);
		float[] medidaCeldas = {2.f, 3.0f, 4.5f, 0.5f, 0.5f};
		tabla.setWidths(medidaCeldas);
		Font font = new Font();
		font.setColor(BaseColor.WHITE);
		PdfPCell celdaGris = new PdfPCell();
		celdaGris.setBackgroundColor(BaseColor.GRAY);
		celdaGris.setPhrase(new Paragraph("Principios", font));
		tabla.addCell(celdaGris);
		celdaGris.setPhrase(new Paragraph("Pautas", font));
		tabla.addCell(celdaGris);
		celdaGris.setPhrase(new Paragraph("Criterios de Conformidad", font));
		tabla.addCell(celdaGris);

		PdfPCell celdaNegra = new PdfPCell();
		celdaNegra.setBackgroundColor(BaseColor.BLACK);
		celdaNegra.setPhrase(new Paragraph("sub", font));
		tabla.addCell(celdaNegra);
		celdaNegra.setPhrase(new Paragraph(" A ", font));
		tabla.addCell(celdaNegra);

		celdaGris.setPhrase(new Paragraph(""));
		celdaNegra.setPhrase(new Paragraph(""));

		String l1 = "";
		String l2 = "";

		PdfPCell celdaBordeArribaIzquerda = new PdfPCell();
		celdaBordeArribaIzquerda.setBorder(Rectangle.NO_BORDER);
		celdaBordeArribaIzquerda.setBorder(Rectangle.TOP + Rectangle.LEFT);

		PdfPCell celdaBordeIzquierdaDerecha = new PdfPCell();
		celdaBordeIzquierdaDerecha.setBorder(Rectangle.NO_BORDER);
		celdaBordeIzquierdaDerecha.setBorder(Rectangle.LEFT + Rectangle.RIGHT);

		PdfPCell celdaBordeArribaIzquierdaDerecha = new PdfPCell();
		celdaBordeArribaIzquierdaDerecha.setBorder(Rectangle.NO_BORDER);
		celdaBordeArribaIzquierdaDerecha.setBorder(Rectangle.TOP + Rectangle.LEFT + Rectangle.RIGHT);
		celdaBordeArribaIzquierdaDerecha.setPhrase(new Paragraph(""));

		PdfPCell celdaAlineacionDerecha = new PdfPCell();
		celdaAlineacionDerecha.setHorizontalAlignment(Element.ALIGN_RIGHT);

		for (ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio : this.getResultado()) {
			for (ResultadoEvaluacionPauta resultadoEvaluacionPauta : resultadoEvaluacionPrincipio.getResultadoEvaluacionPautas()) {
				for (ResultadoEvaluacionCriterio resultadoEvaluacionCriterio : resultadoEvaluacionPauta.getResultadoEvaluacionCriterios()) {
					if (l1.equals(resultadoEvaluacionPrincipio.toString()))
						tabla.addCell(celdaBordeIzquierdaDerecha);
					else {
						celdaBordeArribaIzquierdaDerecha.setPhrase(new Paragraph(resultadoEvaluacionPrincipio.getPrincipio().toString()	+ " " + resultadoEvaluacionPrincipio.getPrincipio().getNombre()));
						tabla.addCell(celdaBordeArribaIzquierdaDerecha);
					}
					if (l2.equals(resultadoEvaluacionPauta.toString()))
						tabla.addCell(celdaBordeIzquierdaDerecha);
					else {
						celdaBordeArribaIzquierdaDerecha.setPhrase(new Paragraph(resultadoEvaluacionPauta.getPauta().toString() + " " + resultadoEvaluacionPauta.getPauta().getNombre()));
						tabla.addCell(celdaBordeArribaIzquierdaDerecha);
					}
					tabla.addCell(resultadoEvaluacionCriterio.getCriterio().toString() + " " + resultadoEvaluacionCriterio.getCriterio().getNombre());
					tabla.addCell(" ");
					celdaAlineacionDerecha.setPhrase(new Phrase(String.valueOf(resultadoEvaluacionCriterio.getPuntosPorCriterio())));
					tabla.addCell(celdaAlineacionDerecha);

					l1 = resultadoEvaluacionPrincipio.toString();
					l2 = resultadoEvaluacionPauta.toString();
				}
			}
			tabla.addCell(celdaBordeIzquierdaDerecha);
			tabla.addCell(celdaGris);
			tabla.addCell("subtotal");

			celdaAlineacionDerecha.setPhrase(new Phrase(String.valueOf(resultadoEvaluacionPrincipio.getCantidadPautasOKPorPrincipio() * 4)));
			tabla.addCell(celdaAlineacionDerecha);
			celdaAlineacionDerecha.setPhrase(new Phrase(String.valueOf(resultadoEvaluacionPrincipio.getCantidadPautasOKPorPrincipio() * 4)));
			tabla.addCell(celdaAlineacionDerecha);
			puntosTotal += resultadoEvaluacionPrincipio.getCantidadPautasOKPorPrincipio();
		}
		tabla.addCell(celdaNegra);
		tabla.addCell(celdaNegra);
		tabla.addCell("TOTAL");
		celdaAlineacionDerecha.setPhrase(new Phrase(String.valueOf(puntosTotal * 4)));
		tabla.addCell(celdaAlineacionDerecha);
		tabla.addCell(celdaBordeArribaIzquerda);
		this.getDocumento().add(tabla);
		this.getDocumento().add(new Paragraph(""));
		this.getDocumento().add(new Paragraph("Información expuesta conforme el modelo del Anexo II de Disposición 2/2014 de la ONTI.", FontFactory.getFont(FontFactory.TIMES_ITALIC, 8)));
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

}
