package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG69 extends TecnicaGeneral {

	public TecnicaG69(CategoriaTecnica categoriaTecnica) {
		super(
				"G69", 
				"Proporcionar una alternativa para los medios basados en tiempo.", 
				"El prop�sito de esta t�cnica es proporcionar una forma alternativa accesible de presentar la informaci�n en una presentaci�n de medios sincronizados. En una presentaci�n de medios sincronizados, la informaci�n es presentada en una variedad de maneras, incluyendo: di�logo, sonidos (naturales y artificiales), el ajuste y el fondo, las acciones y expresiones de las personas, animales, etc., texto o gr�ficos, y m�s.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ver la presentaci�n multimedia sincronizada mientras se hace referencia a la alternativa de la media basada en el tiempo.
	 * 2. Verificar que el di�logo en los medios alternativos para basados en el tiempo coincide con el di�logo en la presentaci�n multimedia sincronizada.
	 * 3. Verificar que los medios alternativos basados en el tiempo tienen descripciones de sonidos.
	 * 4. Verificar que los medios alternativos basados en el tiempo tienen descripciones del entorno y los cambios de configuraci�n.
	 * 5. Verificar que medios alternativos basados en el tiempo tienen descripciones de acciones y expresiones de los 'actores' (personas, animales, etc.).
	 * 6. Si las versiones alternativas est�n en una p�gina separada, verificar la disponibilidad de links para permitir al usuario llegar a las otras versiones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaMediosBasadosEnTiempo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa para los medios basados en tiempo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los medios alternativos basados en el tiempo tienen descripciones de sonidos, del entorno y cambios de configuraci�n, descripciones de acciones y expresiones de los \"actores\".",
				"Ofrece alternativas para los medios tempodependientes.");
		comprobacionAlternativaMediosBasadosEnTiempo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaMediosBasadosEnTiempo);
		return resultadoEvaluacionTecnica;
	}

}