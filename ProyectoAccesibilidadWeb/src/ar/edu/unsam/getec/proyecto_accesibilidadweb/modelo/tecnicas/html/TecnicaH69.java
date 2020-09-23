package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH69 extends TecnicaHTML {

	public TecnicaH69(CategoriaTecnica categoriaTecnica) {
		super(
				"H69",
				"Proporcionar elementos de encabezado al comienzo de cada secci�n del contenido.", 
				"El objetivo de esta t�cnica es usar encabezados de secci�n para transmitir la estructura del contenido. Los encabezados se pueden utilizar: 1) Para indicar comienzo del contenido principal. 2) Para marcar los encabezados de secci�n dentro del �rea de contenido principal. 3) Para demarcar las diferentes secciones de navegaci�n como parte superior o la navegaci�n principal, hacia la izquierda o la navegaci�n secundaria y la navegaci�n de pie de p�gina. 4) Para marcar las im�genes del texto que son usadas como encabezados. 5) Para permitir a los usuarios la capacidad de navegar una p�gina por secciones o saltar secciones de bloques de informaci�n repetidas.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que cada secci�n de la p�gina empieza con un encabezado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH1 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h1\".", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que cada secci�n de la p�gina empieza con un encabezado.",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan con elementos de encabezados al inicio de cada secci�n de contenido.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH2 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h2\".", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que cada secci�n de la p�gina empieza con un encabezado.",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan con elementos de encabezados al inicio de cada secci�n de contenido.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH3 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h3\".", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que cada secci�n de la p�gina empieza con un encabezado.",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan con elementos de encabezados al inicio de cada secci�n de contenido.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH4 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h4\".", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que cada secci�n de la p�gina empieza con un encabezado.",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan con elementos de encabezados al inicio de cada secci�n de contenido.");
		ResultadoEvaluacionTecnicaItem comprobacionInexistenciaElementoH5 = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Inexistencia del elemento \"h5\".", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que cada secci�n de la p�gina empieza con un encabezado.",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan con elementos de encabezados al inicio de cada secci�n de contenido.");
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