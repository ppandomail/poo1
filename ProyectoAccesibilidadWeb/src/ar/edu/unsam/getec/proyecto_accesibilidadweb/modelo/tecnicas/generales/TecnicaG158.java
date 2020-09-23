package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG158 extends TecnicaGeneral {

	public TecnicaG158(CategoriaTecnica categoriaTecnica) {
		super(
				"G158",
				"Proporcionar una alternativa para los medios de comunicaci�n basada en el tiempo para el contenido de s�lo audio.",
				"El prop�sito de esta t�cnica es proporcionar una forma alternativa accesible de representar la informaci�n en una presentaci�n de s�lo audio. En una presentaci�n de s�lo audio, la informaci�n se presenta en una variedad de maneras, incluyendo el di�logo y sonidos (tanto naturales y artificiales). Con el fin de presentar la misma informaci�n en forma accesible, esta t�cnica implica la creaci�n de un documento que cuenta la misma historia y presenta la misma informaci�n que el contenido de solo audio pregrabado. En esta t�cnica, el documento sirve una larga descripci�n por el contenido e incluye la totalidad del di�logo importante y as� como descripciones de los sonidos de fondo, etc., que son parte de la historia.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ver el contenido de s�lo audio mientras se hace referencia a la alternativa de los medios alternativos basados en el tiempo.
	 * 2. Verificar que el di�logo en la transcripci�n coincide con el di�logo y la informaci�n presentada en la presentaci�n de s�lo audio.
	 * 3. Si el audio incluye m�ltiples voces, verificar que la transcripci�n identifica qui�n est� hablando de todo di�logo.
	 * 4. Verificar que al menos una de las siguientes situaciones es verdadera:
	 * 	a. La transcripci�n en s� se puede determinar mediante programaci�n de la del texto alternativo para el contenido de s�lo audio.
	 * 	b. La transcripci�n se refiere al texto alternativo mediante programaci�n determinada por el contenido de s�lo audio.
	 * 5. Si las versiones alternativas est�n en una p�gina separada, verificar la disponibilidad de enlaces para permitir al usuario llegar a las otras versiones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaSoloAudio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa para los medios de comunicaci�n basada en el tiempo para el contenido de s�lo audio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la transcripci�n en s� se puede determinar mediante programaci�n de la del texto alternativo para el contenido de s�lo audio o la transcripci�n se refiere al texto alternativo mediante programaci�n determinada por el contenido de s�lo audio.",
				"Si el contenido es sonido solo grabado, ofrece una alternativa que presente la misma informaci�n.");
		comprobacionAlternativaSoloAudio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaSoloAudio);
		return resultadoEvaluacionTecnica;
	}

}