package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG139 extends TecnicaGeneral {

	public TecnicaG139(CategoriaTecnica categoriaTecnica) {
		super(
				"G139", 
				"La creaci�n de un mecanismo que permite a los usuarios saltar a errores.", 
				"El objetivo de esta t�cnica es ayudar a los usuarios a encontrar los errores de entrada, donde la informaci�n suministrada por el usuario no se acepta. Esto incluye los campos con la informaci�n faltante y campos con informaci�n incorrecta requerido. Cuando los usuarios introducen los datos de entrada que se comprueba y se detectan errores de entrada, se proporciona un enlace a ese error, de modo que el usuario no tiene que buscarlo. Un m�todo consiste en utilizar validaci�n del lado del servidor, y para volver a visualizar la forma (incluyendo los datos introducidos anteriormente), y una descripci�n de texto en la parte superior de la p�gina que indica el hecho de que hubo un error de entrada, describe la naturaleza de el problema, y proporciona un v�nculo el campo (s) con un problema.",
				categoriaTecnica);
	}

	/**
	 * 1. Llenar un formulario, dejando deliberadamente un campo requerido (obligatorio) un blanco y hacer un error de entrada en otro campo y enviar el formulario.
	 * 2. Verifique que se proporciona un mensaje de texto que identifica el campo que falta datos requeridos.
	 * 3. Verifique que se proporciona un mensaje de texto que identifica el campo con el error de entrada.
	 * 4. Verifique que hay un enlace para cada campo que falta de datos necesarios del mensaje de datos que faltan.
	 * 5. Verifique que hay un enlace a la lista de errores desde el mensaje de error.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMensajeError = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Mensaje de texto por datos requeridos o err�neos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verifique que se proporciona un mensaje de texto que identifica el campo que falta datos requeridos y/o el campo con el error de entrada.",
				"Si hay varios errores, vuelve a mostrar el formulario con un resumen de los errores y ofrece un mecanismo para que los usuarios puedan saltar de uno a otro.");
		comprobacionMensajeError.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMensajeError);
		return resultadoEvaluacionTecnica;
	}

}