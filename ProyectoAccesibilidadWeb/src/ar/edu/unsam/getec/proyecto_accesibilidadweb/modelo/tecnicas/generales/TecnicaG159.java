package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG159 extends TecnicaGeneral {

	public TecnicaG159(CategoriaTecnica categoriaTecnica) {
		super(
				"G159",
				"Proporcionar una alternativa para los medios de comunicaci�n basados en el tiempo para el contenido de solo video.",
				"El prop�sito de esta t�cnica es proporcionar una forma alternativa accesible de presentar la informaci�n en una presentaci�n de s�lo v�deo. En una presentaci�n de s�lo v�deo, la informaci�n se presenta en una variedad de maneras, incluyendo la animaci�n, texto o gr�ficos, el ajuste y el fondo, las acciones y expresiones de las personas, animales, etc. Con el fin de presentar la misma informaci�n en forma accesible, esta t�cnica consiste en la creaci�n de un documento que cuenta la misma historia y presenta la misma informaci�n que el contenido de s�lo v�deo pregrabado. En esta t�cnica, el documento sirve como una larga descripci�n de los contenidos e incluye toda la informaci�n importante, as� como descripciones de paisajes, acciones, expresiones, etc., que forman parte de la presentaci�n. Si se utiliza un screenplay para el contenido de s�lo v�deo para crear el contenido, en primer lugar, esto puede ser un buen punto de partida. En la producci�n y edici�n, sin embargo, la versi�n final a menudo var�a un poco del screenplay. Para utilizar el screenplay, que tendr�a que ser corregido para que coincida con la forma final editada de la presentaci�n de s�lo v�deo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ver el contenido de s�lo v�deo mientras se hace referencia a los medios alternativos basados en el tiempo.
	 * 2. Verificar que la informaci�n en la transcripci�n incluye la misma informaci�n que se encuentra en la presentaci�n de s�lo v�deo.
	 * 3. Si el v�deo incluye varias personas o personajes, verificar que la transcripci�n identifica qu� persona o personaje est� asociada con cada acci�n descrita.
	 * 4. Verificar que al menos una de las siguientes situaciones sea verdadera:
	 * 	a. La transcripci�n s� se puede determinar mediante programaci�n del texto alternativo para el contenido de s�lo v�deo.
	 * 	b. La transcripci�n se refiere al texto alternativo mediante programaci�n determinada por el contenido de s�lo v�deo.
	 * 5. Si las versiones alternativas est�n en una p�gina separada, verificar la disponibilidad de enlaces para permitir al usuario llegar a las otras versiones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaSoloVideo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa para los medios de comunicaci�n basados en el tiempo para el contenido de s�lo video.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la transcripci�n en s� se puede determinar mediante programaci�n  del texto alternativo para el contenido de s�lo video  o la transcripci�n se refiere al texto alternativo mediante programaci�n determinada por el contenido de s�lo video.",
				"Si el contenido es v�deo solo grabado, ofrece una alternativa que presente la misma informaci�n.");
		comprobacionAlternativaSoloVideo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaSoloVideo);
		return resultadoEvaluacionTecnica;
	}

}