package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG84 extends TecnicaGeneral {

	public TecnicaG84(CategoriaTecnica categoriaTecnica) {
		super(
				"G84",
				"Proporcionar una descripci�n de texto cuando el usuario proporciona informaci�n que no est� en la lista de valores permitidos.",
				"Cuando los usuarios introducen de entrada que se valida y se detectan errores, la naturaleza del error necesita ser descrito para el usuario de manera que pueden acceder. Un m�todo consiste en presentar un cuadro de di�logo de alerta que describe los campos con errores cuando el usuario intenta enviar el formulario. Otro enfoque, si la validaci�n se realiza por el servidor, es devolver la forma (con los datos del usuario todav�a en los campos) y una descripci�n de texto en la parte superior de la p�gina que indica el hecho de que hab�a un problema de validaci�n, describe la naturaleza del problema, y proporciona maneras de localizar el campo (s) con un problema f�cilmente. La parte \"en el texto\" del Criterio de relieve que no es suficiente simplemente para indicar que un campo tiene un error al poner un asterisco en la etiqueta o girando la etiqueta roja. Una descripci�n textual del problema debe ser proporcionada. Cuando la entrada debe ser una de un conjunto de valores permitidos, la descripci�n de texto debe indicar este hecho. Se debe incluir la lista de valores si es posible, o sugerir el valor permitido que m�s se asemeja al valor introducido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Introducir datos no v�lidos en un campo de formulario.
	 * 2. Verificar que la informaci�n se proporciona en el texto sobre el problema.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionIdentifiqueValoresConFormatosEspeciales = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Identifique los valores que deben indicarse con formatos especiales.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que la informaci�n se proporciona en el texto sobre el problema tras introducir datos no v�lidos en campo de formulario.",
				"Advierte de los errores en el momento que el usuario introduzca la informaci�n y enfatiza visualmente los errores donde sucedan.");
		comprobacionIdentifiqueValoresConFormatosEspeciales.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionIdentifiqueValoresConFormatosEspeciales);
		return resultadoEvaluacionTecnica;
	}

}