package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG187 extends TecnicaGeneral {

	public TecnicaG187(CategoriaTecnica categoriaTecnica) {
		super(
				"G187",
				"El uso de una tecnolog�a para incluir el contenido parpadeante que puede ser desactivada a trav�s del agente de usuario.",
				"El objetivo de esta t�cnica es la de asegurar que el contenido destellante se puede desactivar utilizando caracter�sticas de agente usuario. Los agentes usuario permiten a los usuarios detener la animaci�n de contenidos en determinadas tecnolog�as. Cuando el usuario activa esta caracter�stica, toda la animaci�n, incluyendo destellos, se detiene. Esta caracter�stica puede ser proporcionada ya sea a trav�s de controles interactivos que se ajusten a las WCAG o a trav�s de atajos de teclado documentados. La forma m�s com�n para los usuarios detener la animaci�n es pulsar la tecla \"escape\". Mientras que no hay procesos que tienen prioridad en la cola de eventos para un uso de esa tecla, esto se toma como un comando para detener la animaci�n de movimiento o contenido destellante. Tecnolog�as que se conoce que funcione generalmente incluyen: Intercambio de formato grafico (GIF), Gr�ficos Animados de redes port�tiles (APNG)", 
				categoriaTecnica);
	}

	/**
	 * 1. Cargar una p�gina que incluya contenido destellante.
	 * 2. Activar el comando de detenci�n de animaciones en el navegador (usualmente la tecla �Escape�).
	 * 3. Verificar que los destellos se hayan detenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoEnMovimientoParpadeante = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido en movimiento o parpadeante.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los destellos se hayan detenido cuando se activa el comando de detenci�n de animaciones en el navegador.",
				"Si usas una tecnolog�a para incluir contenido parpadeante, el usuario puede apagarlo a trav�s del agente de usuario.");
		comprobacionContenidoEnMovimientoParpadeante.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoEnMovimientoParpadeante);
		return resultadoEvaluacionTecnica;
	}

}