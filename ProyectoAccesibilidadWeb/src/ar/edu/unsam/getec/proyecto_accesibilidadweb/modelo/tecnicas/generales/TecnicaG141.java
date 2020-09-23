package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG141 extends TecnicaGeneral {

	public TecnicaG141(CategoriaTecnica categoriaTecnica) {
		super(
				"G141", 
				"Organizar una p�gina usando encabezados.", 
				"El objetivo de esta t�cnica es la de garantizar que los art�culos tienen encabezamientos que los identifican. Criterio 1.3.1 requiere que los encabezados de estar marcados de modo que pueden ser identificados mediante programaci�n. En HTML, esto se podr�a hacer uso de los elementos de encabezado HTML (h1 , h2 , h3 , h4 , h5 , h6). �stos permiten que las aplicaciones de usuario para identificar autom�ticamente los encabezados de secci�n . Otras tecnolog�as utilizan otras t�cnicas para la identificaci�n de las cabeceras. Para facilitar la navegaci�n y la comprensi�n de la estructura general del documento, los autores deben utilizar las partidas que est�n anidados correctamente (por ejemplo, h1 seguido de h2 , h2 seguido de h2 o h3 , h3 seguido de h3 o h4 , etc.).", 
				categoriaTecnica);
	}

	/**
	 * 1. Examinar una p�gina con contenido organizado en secciones.
	 * 2. Verificar que existe un encabezado para cada secci�n.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExistenciaEncabezadoParaCadaSeccion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Existencia de encabezados para cada secci�n.", 
				TipoResultadoEvaluacion.MANUAL,
				"Examinar una p�gina con contenido organizado en secciones: Verificar que existe un encabezado para cada secci�n.",
				"Comunica la informaci�n y sus relaciones mediante la estructura de la p�gina web: los elementos \"h1-h6\" para identificar encabezados.");
		comprobacionExistenciaEncabezadoParaCadaSeccion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExistenciaEncabezadoParaCadaSeccion);
		return resultadoEvaluacionTecnica;
	}

}