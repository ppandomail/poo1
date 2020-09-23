package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG133 extends TecnicaGeneral {

	public TecnicaG133(CategoriaTecnica categoriaTecnica) {
		super(
				"G133",
				"Poveer una casilla de verificaci�n en la primer p�gina de un formulario de m�ltiples partes que permita que los usuarios soliciten un tiempo l�mite de sesi�n m�s extenso o ning�n tiempo l�mite de sesi�n.",
				"El objetivo de esta t�cnica es reducir al m�nimo el riesgo de que los usuarios con discapacidad pierdan su trabajo, proporcionando una casilla para solicitar tiempo adicional para completar formularios de varios ejemplares. La casilla de verificaci�n puede permitir al usuario solicitar una cantidad espec�fica de tiempo adicional (por ejemplo 15 minutos) o una extensi�n indefinida. (Tenga en cuenta que lo que permite una extensi�n indefinida ser�a inapropiado si se pone en peligro la privacidad del usuario o la seguridad de la red.).", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que la p�gina Web incluya una casilla de verificaci�n para solicitar tiempo adicional para completar el formulario.
	 * 2. Verificar que si la casilla de verificaci�n esta tildada, se provea tiempo adicional para completar el formulario.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLimiteTiempoSesion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"L�mite de tiempo de sesi�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la p�gina Web incluya una casilla de verificaci�n para solicitar tiempo adicional para completar el formulario.",
				"Si hay un l�mite de tiempo de sesi�n: Ofrece un mecanismo en la primera p�gina de un formulario que se distribuye en varias p�ginas que permita a los usuarios solicitar un mayor l�mite de tiempo o eliminarlo. Ofrece un mecanismo que permita a los usuarios anular el l�mite de tiempo.");
		comprobacionLimiteTiempoSesion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLimiteTiempoSesion);
		return resultadoEvaluacionTecnica;
	}

}