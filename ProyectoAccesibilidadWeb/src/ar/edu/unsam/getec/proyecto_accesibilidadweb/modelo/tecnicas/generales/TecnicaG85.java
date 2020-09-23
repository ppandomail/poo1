package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG85 extends TecnicaGeneral {

	public TecnicaG85(CategoriaTecnica categoriaTecnica) {
		super(
				"G85",
				"Proporcionar una descripci�n de texto cuando la entrada del usuario se encuentra fuera del formato o valores requeridos.",
				"El objetivo de esta t�cnica es proporcionar ayuda en la correcci�n de errores de entrada, donde la informaci�n suministrada por el usuario no se acepta. Cuando los usuarios introducen los datos de entrada que se valida y se detectan errores de entrada, se proporciona informaci�n sobre la naturaleza y la ubicaci�n del error de entrada de texto para que los usuarios puedan identificar el problema. Un m�todo consiste en utilizar la validaci�n del lado del cliente y proporcionar un cuadro de di�logo de alerta que describe el error inmediatamente cuando los usuarios introducen datos no v�lidos en el campo. Otro enfoque, el uso de la validaci�n del lado del servidor, es volver a mostrar el formulario (incluyendo los datos introducidos anteriormente), y una descripci�n de texto en la parte superior de la p�gina que indica el hecho de que hubo un error, se describe la naturaleza del problema y proporciona maneras de localizar f�cilmente el campo (s) con un problema.", 
				categoriaTecnica);
	}

	/**
	 * 1. Llenar un formulario, introducir deliberadamente la entrada del usuario que est� fuera del formato o valores requeridos.
	 * 2. Verificar que se proporciona una descripci�n de texto que identifica el campo en el error y proporciona informaci�n sobre la naturaleza de la entrada inv�lida y c�mo solucionarlo.
	 * 3. Verificar que los otros datos introducidos previamente por el usuario se volver� a mostrar, a menos que los datos est�n en un campo relacionado con la seguridad, donde no ser�a adecuado para retener los datos para volver a la pantalla (por ejemplo, una contrase�a).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionIdentifiqueValoresConFormatosEspeciales = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Identifique los valores que deben indicarse con formatos especiales.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que se proporciona una descripci�n de texto que identifica el campo en el error y proporciona informaci�n sobre la naturaleza de la entrada inv�lida y c�mo solucionarlo.",
				"Avisa al usuario con un mensaje de texto explicando el error.");
		comprobacionIdentifiqueValoresConFormatosEspeciales.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionIdentifiqueValoresConFormatosEspeciales);
		return resultadoEvaluacionTecnica;
	}

}