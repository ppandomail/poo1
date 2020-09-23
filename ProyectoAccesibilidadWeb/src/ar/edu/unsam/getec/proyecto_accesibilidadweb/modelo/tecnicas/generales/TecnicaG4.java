package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG4 extends TecnicaGeneral {

	public TecnicaG4(CategoriaTecnica categoriaTecnica) {
		super(
				"G4", 
				"Permitir pausar el contenido y reanudado donde fue pausado.", 
				"El objetivo de esta t�cnica es proveer una forma de pausar movimiento de scroll  del contenido. Si el usuario necesita pausar el movimiento, para reducir la distracci�n o tener tiempo de leer el mismo, pueden hacerlo, y luego continuar con el mismo cuando sea necesario. El mecanismo provisto por el control interactivo de las WCAG o mediante atajos del teclado. Si los atajos de teclado son usados, los mismos quedan documentados.", 
				categoriaTecnica);
	}

	/**
	 * 1. Usar los mecanismos provistos en la pagina Web o el agente usuario para pausar el movimiento de scroll.
	 * 2. Verificar que el movimiento o el scrolling haya cesado y no vuelva a iniciarse por si mismo.
	 * 3. Usar el mecanismo provisto para reiniciar el movimiento del contenido.
	 * 4. Verificar que el movimiento o scrolling se haya reanudado desde el punto donde se detuvo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLecturaTextosMovimiento = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Lectura de textos en movimiento.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el movimiento o scrolling haya cesado cuando se lo pausa.",
				"Si hay un l�mite de tiempo para leer los contenidos: Permite al usuario pausar el contenido y volver a reproducirlo desde donde fue parado.");
		ResultadoEvaluacionTecnicaItem comprobacionContenidoEnMovimientoParpadeante = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido en movimiento o parpadeante.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el movimiento o scrolling se haya reanudado desde el punto donde se detuvo.",
				"Si hay un l�mite de tiempo para leer los contenidos: Permite al usuario pausar el contenido y volver a reproducirlo desde donde fue parado.");
		comprobacionLecturaTextosMovimiento.procesar();
		comprobacionContenidoEnMovimientoParpadeante.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLecturaTextosMovimiento);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoEnMovimientoParpadeante);
		return resultadoEvaluacionTecnica;
	}

}