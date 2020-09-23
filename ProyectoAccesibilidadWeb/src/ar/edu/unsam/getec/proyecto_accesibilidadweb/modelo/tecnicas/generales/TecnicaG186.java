package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG186 extends TecnicaGeneral {

	public TecnicaG186(CategoriaTecnica categoriaTecnica) {
		super(
				"G186",
				"El uso de un control en la p�gina Web que deje de moverse, parpadeando, o auto-actualizaci�n de contenidos.",
				"El objetivo de esta t�cnica es proporcionar al usuario un control que permite que el contenido deje de moverse o de parpadear. Dado que el control se encuentra en la p�gina web, el propio control cumple con el nivel adecuado de conformidad WCAG por ejemplo, tiene un contraste adecuado, que tiene un nombre que lo identifica, es el teclado accesible. El control es o bien en la parte superior de la p�gina o adyacente al movimiento de los contenidos. Un solo control puede detener todo movimiento de los contenidos o parpadeos en la p�gina, o puede haber controles separados para partes separadas del contenido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que hay un control de la p�gina web para detener el movimiento.
	 * 2. Activar el control. 
	 * 3. Verificar que el movimiento, parpadeo o la actualizaci�n autom�tica se ha detenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoEnMovimientoOParpadeante = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido en movimiento o parpadeante.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el movimiento, parpadeo o la actualizaci�n autom�tica se ha detenido cuando se activa el control de la p�gina web para detener el movimiento.",
				"Ofrece un mecanismo que detenga el movimiento, el parpadeo o el refresco del contenido.");
		comprobacionContenidoEnMovimientoOParpadeante.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoEnMovimientoOParpadeante);
		return resultadoEvaluacionTecnica;
	}

}