package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG83 extends TecnicaGeneral {

	public TecnicaG83(CategoriaTecnica categoriaTecnica) {
		super(
				"G83",
				"Proporcionar descripciones de texto para identificar los campos requeridos que no se completaron.",
				"El objetivo de esta t�cnica es notificar al usuario cuando un campo que debe ser completado no se ha completado. Cuando los usuarios no proporcionan ning�n dato para campos de formulario obligatorios, la informaci�n se proporciona en el texto para que los usuarios puedan identificar qu� campos fueron omitidos. Un m�todo consiste en utilizar la validaci�n del lado del cliente y proporcionar un cuadro de di�logo de alerta para identificar los campos obligatorios que fueron omitidos. Otro enfoque, el uso de la validaci�n del lado del servidor, es volver a mostrar el formulario (incluyendo los datos introducidos anteriormente), ya sea con una descripci�n textual en la ubicaci�n del campo obligatorio omitido, o una descripci�n textual que identifique los campos obligatorios omitidos.", 
				categoriaTecnica);
	}

	/**
	 * 1. Llenar un formulario, dejando deliberadamente uno o m�s campos en blanco requeridos (obligatorios), y enviarlo.
	 * 2. Verificar que se proporciona una descripci�n textual que identifica el o los campo(s) obligatorio(s) que no se completaron.
	 * 3. Verificar que los otros datos introducidos previamente por el usuario se volver�n a mostrar, a menos que los datos est�n en un campo relacionado con la seguridad, donde no ser�a adecuado retener los datos para volver a la pantalla (por ejemplo, una contrase�a).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionValoresErroneosEnFormularios = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Identifique los valores err�neos en formularios. ", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que se proporciona una descripci�n textual que identifica el o los campo(s) obligatorio(s) que no se completaron.",
				"Si el usuario no ha rellenado los campos obligatorios de un formulario: Identifica los campos que no han sido completados y avisa al usuario con un mensaje de texto explicando el error.");
		comprobacionValoresErroneosEnFormularios.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionValoresErroneosEnFormularios);
		return resultadoEvaluacionTecnica;
	}

}