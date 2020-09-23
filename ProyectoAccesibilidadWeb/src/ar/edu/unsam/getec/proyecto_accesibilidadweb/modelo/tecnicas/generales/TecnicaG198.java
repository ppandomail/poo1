package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG198 extends TecnicaGeneral {

	public TecnicaG198(CategoriaTecnica categoriaTecnica) {
		super(
				"G198", 
				"Proporcionar una forma para que el usuario active el l�mite de tiempo libre.", 
				"El objetivo de esta t�cnica es proveer un mecanismo para personas que no pueden completar las tareas dentro de un plazo determinado para desactivar el l�mite de tiempo. Es esencial que el mecanismo para desactivar el l�mite de tiempo pueda completarse sin un l�mite de tiempo en s� mismo y antes de que el tiempo l�mite de la p�gina expire. Para ello - el mecanismo debe estar disponible en o cerca de la parte superior de la p�gina de modo que se puede encontrar de forma r�pida y activado por personas con una diversidad de discapacidades.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que existe un mecanismo para desactivar cualquier l�mite de tiempo cerca de la parte superior de la p�gina.
	 * 2. Verificar que el l�mite de tiempo para la p�gina es lo suficientemente largo para que un usuario pueda navegar f�cilmente al mecanismo, incluso si son 10 veces m�s lentos que la mayor�a de los usuarios.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLimiteTiempoSesion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"L�mite de tiempo de sesi�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe un mecanismo para desactivar cualquier l�mite de tiempo cerca de la parte superior de la p�gina.",
				"Si hay un l�mite de tiempo de sesi�n: Ofrece un mecanismo en la primera p�gina de un formulario que se distribuye en varias p�ginas que permita a los usuarios solicitar un mayor l�mite de tiempo o eliminarlo. Ofrece un mecanismo que permita a los usuarios");
		ResultadoEvaluacionTecnicaItem comprobacionLimiteTiempoControladoPorScript = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"L�mite de tiempo controlado mediante un script.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe un mecanismo para desactivar cualquier l�mite de tiempo cerca de la parte superior de la p�gina.",
				"Si el l�mite de tiempo es controlado por la programaci�n de la p�gina: Ofrece un mecanismo que permita a los usuarios anular el l�mite de tiempo.");
		ResultadoEvaluacionTecnicaItem comprobacionLecturaTextosEnMovimiento = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Lectura de textos en movimiento.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe un mecanismo para desactivar cualquier l�mite de tiempo cerca de la parte superior de la p�gina.",
				"Si hay un l�mite de tiempo para leer los contenidos: Permite al usuario pausar el contenido y volver a reproducirlo desde donde fue parado.");
		comprobacionLimiteTiempoSesion.procesar();
		comprobacionLimiteTiempoControladoPorScript.procesar();
		comprobacionLecturaTextosEnMovimiento.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLimiteTiempoSesion);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLimiteTiempoControladoPorScript);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLecturaTextosEnMovimiento);
		return resultadoEvaluacionTecnica;
	}

}