package ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaHTML;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH90 extends TecnicaHTML {

	public TecnicaH90(CategoriaTecnica categoriaTecnica) {
		super(
				"H90",
				"Indicar los controles de formulario que es obligatorio rellenar.",
				"El objetivo de esta t�cnica es proporcionar una clara indicaci�n de que un control espec�fico del formulario en una aplicaci�n Web o formulario es requerido para la presentaci�n de los datos con �xito. Un s�mbolo o texto indicando que el control es requerido est� programaticamente asociado con el campo al usar el elemento label o legend para grupos de controles asociados a trav�s de fieldset. Si un s�mbolo es usado, el usuario es informado de su significado antes del primer uso.",
				categoriaTecnica);
	}

	/**
	 * 1. Por cada control de formulario requerido, verificar que el estado requerido est� indicado en el label o legend del control del formulario.
	 * 2. Por cada indicador de estado requerido que no se proporciona en el texto, verificar que el significado del indicador es explicado antes del control del formulario que lo usa.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEstadoRequerido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Controles de formulario no indican estado requerido.", 
				TipoResultadoEvaluacion.MANUAL,
				"Por cada control de formulario requerido, verificar que el estado requerido est� indicado en el \"label\" o \"legend\" del control del formulario.",
				"Ofrece etiquetas \"label\" descriptivas para identificar los campos obligatorios con texto.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) 
				comprobacionEstadoRequerido.procesar(elementoINPUT);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEstadoRequerido);
		return resultadoEvaluacionTecnica;
	}

}