package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.StartTagType;

public class TecnicaH88 extends TecnicaHTML {

	public TecnicaH88(CategoriaTecnica categoriaTecnica) {
		super(
				"H88",
				"Usar HTML de acuerdo con la especificaci�n.", 
				"Existe distintos tipos de documentos HTML y todos ellos se encuentran definidos en sus respectivas especificaciones, pero tambi�n est�n definidos en un lenguaje comprensible por las m�quinas que especifica la estructura correcta, elementos y atributos de un tipo de HTML. Tal definici�n se denomina \"Document Type Definition\" (Definici�n del Tipo de Documento) que se suele llamar, para abreviar, \"Doctype\" o \"DTD\". Las herramientas que procesan los documentos HTML como, por ejemplo, los navegadores web, necesitan conocer la DTD que utilizan los documentos. Por este motivo es que cada documento (X)HTML necesita, al principio, una declaraci�n DTD con la cual la interpretaci�n (y, como resultado, la representaci�n) del documento ser� no s�lo m�s r�pida sino tambi�n consistente y libre de cualquier error que causar�a un documento sin doctype.",
				categoriaTecnica);
	}

	/**
	 *
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaSinDefinicionTipoDocumento = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"P�gina sin definici�n del tipo de documento.",
				"Verificar que la p�gina define el tipo de documento HTML.",
				"Elige el est�ndar que desees (HTML, XHTML, XML, ...), pero sigue su especificaci�n.");
		if (this.getParseador().getEtiquetasInicio(StartTagType.DOCTYPE_DECLARATION).isEmpty()) 
			comprobacionPaginaSinDefinicionTipoDocumento.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaSinDefinicionTipoDocumento);
		return resultadoEvaluacionTecnica;
	}

}