package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG191 extends TecnicaGeneral {

	public TecnicaG191(CategoriaTecnica categoriaTecnica) {
		super(
				"G191",
				"Proporcionar un enlace, bot�n u otro mecanismo que vuelve a cargar la p�gina sin ning�n contenido parpadeante.",
				"Esta es una t�cnica general para permitir que las personas que no pueden utilizar una p�gina con contenido parpadeante puedan apagar el parpadeo. Conformidad Requisito 1 permite p�ginas alternativas para ser utilizadas para satisfacer conformidad. Esta t�cnica es un ejemplo de este enfoque se aplica a los criterios de �xito 2.2.2. Es importante que la p�gina sin contenido parpadeante contenga toda la informaci�n que apareci� en la p�gina con contenido parpadeante.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que existe un mecanismo para recargar la p�gina para desactivar el parpadeo.
	 * 2. Verificar que la p�gina a cargar no tiene parpadeo.
	 * 3. Verificar que la p�gina a cargar tiene toda la informaci�n y funcionalidad de la p�gina original.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoEnMovimientoOParpadeante = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido en movimiento o parpadeante.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la p�gina a cargar no tiene parpadeo.",
				"Ofrece un mecanismo para recargar la p�gina sin contenidos parpadeantes.");
		comprobacionContenidoEnMovimientoOParpadeante.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoEnMovimientoOParpadeante);
		return resultadoEvaluacionTecnica;
	}

}