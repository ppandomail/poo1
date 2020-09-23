package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH42 extends TecnicaHTML {

	public TecnicaH42(CategoriaTecnica categoriaTecnica) {
		super(
				"H42",
				"Usar h1-h6 para identificar los t�tulos",
				"El prop�sito de esta t�cnica es el uso de las marcas de encabezados en HTML y XHTML para proporcionar c�digo sem�ntico en los encabezados del contenido. Los elementos de encabezados (h1, h2, h3, h4, h5 y h6) permitir�n a las ayudas t�cnicas presentar el encabezado de un texto a los usuarios. Un lector de pantalla puede reconocer el c�digo y anunciar el texto como encabezado con su nivel y proporcionar alg�n otro indicador auditivo. Los lectores de pantalla tambi�n son capaces de navegar por las marcas de encabezados, algo que para los usuarios puede ser una manera eficaz de encontrar m�s r�pidamente el contenido de inter�s. Las ayudas t�cnicas que alteran la presentaci�n visual del autor tambi�n ser�n capaces de proporcionar una presentaci�n visual alternativa para los encabezados.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que heading markup se utiliza cuando el contenido es un encabezado.
	 * 2. Verificar que heading markup no se utiliza cuando el contenido no es un encabezado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH1 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h1\".",
				"Verificar que heading markup se utiliza cuando el contenido es un encabezado.",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: los elementos \"h1-h6\" para identificar encabezados.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH2 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h2\".",
				"Verificar que heading markup se utiliza cuando el contenido es un encabezado.",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: los elementos \"h1-h6\" para identificar encabezados.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH3 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h3\".",
				"Verificar que heading markup se utiliza cuando el contenido es un encabezado.",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: los elementos \"h1-h6\" para identificar encabezados.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH4 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h4\".",
				"Verificar que heading markup se utiliza cuando el contenido es un encabezado.",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: los elementos \"h1-h6\" para identificar encabezados.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH5 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h5\".",
				"Verificar que heading markup se utiliza cuando el contenido es un encabezado.",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: los elementos \"h1-h6\" para identificar encabezados.");
		Integer [] cantidades = new Integer[] {0, 0, 0, 0, 0, 0};
		cantidades[0] = this.getParseador().getElementos(HTMLElementName.H1).size();
		cantidades[1] = this.getParseador().getElementos(HTMLElementName.H2).size();
		cantidades[2] = this.getParseador().getElementos(HTMLElementName.H3).size();
		cantidades[3] = this.getParseador().getElementos(HTMLElementName.H4).size();
		cantidades[4] = this.getParseador().getElementos(HTMLElementName.H5).size();
		cantidades[5] = this.getParseador().getElementos(HTMLElementName.H6).size();
		if ((cantidades[0] == 0) && ((cantidades[1] > 0) || (cantidades[2] > 0) || (cantidades[3] > 0) || (cantidades[4] > 0) || (cantidades[5] > 0)))
			comprobacionInexistenciaElementoH1.procesar();
		if ((cantidades[1] == 0) && ((cantidades[2] > 0) || (cantidades[3] > 0) || (cantidades[4] > 0) || (cantidades[5] > 0)))
			comprobacionInexistenciaElementoH2.procesar();
		if ((cantidades[2] == 0) && ((cantidades[3] > 0) || (cantidades[4] > 0) || (cantidades[5] > 0)))
			comprobacionInexistenciaElementoH3.procesar();
		if ((cantidades[3] == 0) && ((cantidades[4] > 0) || (cantidades[5] > 0)))
			comprobacionInexistenciaElementoH4.procesar();
		if ((cantidades[4] == 0) && (cantidades[5] > 0))
			comprobacionInexistenciaElementoH5.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInexistenciaElementoH1);	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInexistenciaElementoH2);	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInexistenciaElementoH3);	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInexistenciaElementoH4);	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInexistenciaElementoH5);	
		return resultadoEvaluacionTecnica;
	}

}