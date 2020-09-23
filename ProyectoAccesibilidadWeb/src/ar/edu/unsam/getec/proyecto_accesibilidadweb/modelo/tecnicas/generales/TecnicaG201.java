package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG201 extends TecnicaGeneral {

	public TecnicaG201(CategoriaTecnica categoriaTecnica) {
		super(
				"G201", 
				"Dar a los usuarios avanzados de alerta cuando se abre una nueva ventana.", 
				"El objetivo de esta t�cnica es proporcionar una advertencia antes de abrir autom�ticamente una nueva ventana o pesta�a. La apertura de nuevas ventanas de forma autom�tica cuando un enlace se activa puede ser desorientador para personas que tienen dificultades para percibir el contenido visual, y para algunas personas con discapacidades cognitivas, si no son advertidas de antemano. Proporcionar una advertencia permite al usuario decidir si quieren dejar la ventana actual, y la advertencia le ayudar� a encontrar su camino de regreso, si deciden que les gustar�a ir a la nueva ventana. Se les ayudar� a entender que el bot�n \"atr�s\" no va a funcionar y que tienen que volver a la �ltima ventana que ten�an abierta, con el fin de encontrar su ubicaci�n anterior.",
				categoriaTecnica);
	}

	/**
	 * Para cada enlace que se abre autom�ticamente en una nueva ventana o pesta�a cuando un cambio de contexto es iniciado por una petici�n del usuario:
	 * 1. Verificar que haya una advertencia sobre que se habla en la tecnolog�a de asistencia de este enlace que se abre en una nueva ventana.
	 * 2. Verificar que hay una advertencia visual en el texto que este enlace se abre en una nueva ventana.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlertaCuandoSeAbreNuevaVentana = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Alerta antes de abrir autom�ticamente una nueva ventana o pesta�a.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada enlace que se abre autom�ticamente en una nueva ventana o pesta�a cuando un cambio de contexto es iniciado por una petici�n del usuario: Verificar que hay una advertencia visual en el texto que este enlace se abre en una nueva ventana.",
				"Avisa siempre a los usuarios cuando se van a abrir nuevas ventanas.");
		comprobacionAlertaCuandoSeAbreNuevaVentana.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlertaCuandoSeAbreNuevaVentana);
		return resultadoEvaluacionTecnica;
	}

}