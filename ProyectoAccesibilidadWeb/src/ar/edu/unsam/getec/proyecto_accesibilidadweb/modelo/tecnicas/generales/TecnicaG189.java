package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG189 extends TecnicaGeneral {

	public TecnicaG189(CategoriaTecnica categoriaTecnica) {
		super(
				"G189",
				"Proporcionar un control casi al principio de la p�gina Web que cambia el texto del enlace.", 
				"El objetivo de esta t�cnica es proporcionar al usuario un control cerca del comienzo de la p�gina que lleva al usuario a una versi�n alternativa conforme a la p�gina Web en el que el texto del enlace solo es suficiente para determinar su prop�sito fuera del contexto. Algunos usuarios prefieren tener enlaces que son aut�nomos, donde no hay necesidad de explorar el contexto del enlace. Otros usuarios encuentran inclu�da la informaci�n del contexto en cada enlace para evitar repeticiones y reducir su capacidad de utilizar un sitio. Entre los usuarios de la tecnolog�a se encuentran la retroalimentaci�n al grupo de trabajo sobre la que es preferible que sea dividida. Esta t�cnica permite a los usuarios elegir el m�todo que funciona mejor para ellos. Los usuarios que necesitan o prefieren m�s largo y completo el texto del enlace utilizan esta versi�n. Si el control para cambiar a la versi�n alternativa es un enlace, debe ser siempre posible entender el prop�sito del control directamente de su texto de enlace. Esta t�cnica ofrece la versi�n alternativa de la vista de la p�gina actual. Tambi�n es posible, y en algunos casos ser�a aconsejable, guardar esta preferencia en un perfil de cookies o del lado del servidor del usuario, de modo que s�lo los usuarios tendr�an que hacer la selecci�n una vez por sitio y ser�n autom�ticamente llevados a su versi�n preferida.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que hay un control casi al principio de la p�gina Web para cambiar el texto del v�nculo.
	 * 2. Activar el control.
	 * 3. Verificar que todos los enlaces en la p�gina Web resultante tienen texto del enlace que describe su prop�sito.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionControlCambiaTextoDelEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Control que cambia el texto del enlace.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todos los enlaces en la p�gina Web resultante tienen texto del enlace que describe su prop�sito cuando se activa el control para cambiar el texto del v�nculo.",
				"Permite al usuario elegir enlaces cortos o largos mediante un control junto al inicio de la p�gina web que cambie el texto de los enlaces o una programaci�n que cambie el texto de los enlaces.");
		comprobacionControlCambiaTextoDelEnlace.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlCambiaTextoDelEnlace);
		return resultadoEvaluacionTecnica;
	}

}