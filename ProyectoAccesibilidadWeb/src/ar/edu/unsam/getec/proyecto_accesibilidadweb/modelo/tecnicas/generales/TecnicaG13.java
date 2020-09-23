package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG13 extends TecnicaGeneral {

	public TecnicaG13(CategoriaTecnica categoriaTecnica) {
		super(
				"G13", 
				"Describir lo que va a pasar antes de que un cambio en un control de formulario cause una modificaci�n en el contexto que se haya producido.", 
				"El objetivo de esta t�cnica es proporcionar informaci�n a los usuarios acerca de lo que suceder� cuando se produzca un cambio en un control de formulario de resultados a un cambio de contexto. Debido a que  cambiar el valor de un control de formulario no suele ocasionar en un cambio de contexto, es importante que los autores proporcionen instrucciones que hacen que el usuario est� consciente del comportamiento de antemano. Siempre que sea posible, es una buena idea para asociar mediante programaci�n las instrucciones que describen el cambio con el propio control de formulario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Localizar el contenido que al cambiar la configuraci�n de una forma de control de resultados en un cambio de contexto.
	 * 2. Verificar que una explicaci�n de lo que suceder� cuando se cambia el control est� disponible antes de la activaci�n de los controles.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionExplicacionSucederaCuandoCambiaControl = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Explicaci�n de lo que suceder� cuando se cambia el control.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que una explicaci�n de lo que suceder� cuando se cambia el control est� disponible antes de la activaci�n de los controles.",
				"Si un cambio en un control de formulario causa un cambio de contexto, describe antes qu� suceder�.");
		comprobacionExplicacionSucederaCuandoCambiaControl.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionExplicacionSucederaCuandoCambiaControl);
		return resultadoEvaluacionTecnica;
	}

}