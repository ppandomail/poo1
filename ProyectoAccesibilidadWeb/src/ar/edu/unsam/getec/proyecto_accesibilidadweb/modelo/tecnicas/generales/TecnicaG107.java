package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG107 extends TecnicaGeneral {

	public TecnicaG107(CategoriaTecnica categoriaTecnica) {
		super(
				"G107",
				"El uso de \"activar\" en lugar de \"enfoque\" como desencadenante de cambios de contexto.", 
				"El objetivo de esta t�cnica es proporcionar un m�todo para la activaci�n de cosas que son predecibles por el usuario. Los usuarios con discapacidades cognitivas y las personas que utilizan lectores de pantalla o ampliadores de pantalla pueden ser confundidos por un evento inesperado, como el env�o de formularios autom�tico o activaci�n de una funci�n que causa un cambio de contexto. Con esta t�cnica, todos los cambios de contexto se activar�an s�lo mediante una acci�n espec�fica por parte del usuario. Adem�s, que la acci�n sea una de las cosas que pueda causar cambios en el contexto, como hacer clic en un enlace o pulsando un bot�n de env�o. Las acciones que simplemente sean mover el foco a un elemento no causar�an un cambio de contexto.",
				categoriaTecnica);
	}

	/**
	 * 1. El uso de un teclado, haciendo foco a trav�s de todos los contenidos.
	 * 2. Verificar que no haya cambios en el contexto que puede ocurrir cuando cualquier componente recibe el foco.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCambioContenidosConOnfocus = new ResultadoEvaluacionTecnicaItem(
				Tipologia.SCRIPTS, 
				"Cambio de contenidos con el evento \"onfocus\".", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que no haya cambios en el contexto que puede ocurrir cuando cualquier componente recibe el foco.",
				"Usa \"activate\" en lugar de \"focus\" como disparadores de cambios de contexto. Observa que se habla de cambios de contexto, no de cambios de contenido.");
		ResultadoEvaluacionTecnicaItem comprobacionAperturaVentanaAlCambiarElFoco = new ResultadoEvaluacionTecnicaItem(
				Tipologia.SCRIPTS, 
				"Apertura de ventana al cambiar el foco.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que no haya cambios en el contexto que puede ocurrir cuando cualquier componente recibe el foco.",
				"Abre ventanas nuevas s�lo cuando sea la mejor alternativa y avisa siempre a los usuarios. No abras una ventana nueva tan pronto como cargue la p�gina.");
		comprobacionCambioContenidosConOnfocus.procesar();
		comprobacionAperturaVentanaAlCambiarElFoco.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCambioContenidosConOnfocus);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAperturaVentanaAlCambiarElFoco);
		return resultadoEvaluacionTecnica;
	}

}