package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG176 extends TecnicaGeneral {

	public TecnicaG176(CategoriaTecnica categoriaTecnica) {
		super(
				"G176", 
				"Mantener el �rea intermitente suficientemente peque�o.", 
				"El prop�sito de esta t�cnica es proporcionar una manera f�cil de superar el criterio de �xito para las cosas que se encienden pero son peque�as. Si usted tiene algo que parpadea m�s de 3 veces en un segundo per�odo de un (por lo tanto G19 no se puede utilizar), pero el �rea que est� parpadeando es inferior al 25% de los 10 grados de campo visual (que representa el �rea central de la visi�n en el ojo), entonces pasar�a autom�ticamente. El d�cimo grado de campo visual representa el �rea central de la visi�n en el ojo. Esta zona est� muy llena de sensores visuales. El parpadeo en esta �rea se transmiten a la corteza visual. Para aquellos con fotosensibilidad, la intermitencia de la actividad en la corteza visual puede causar convulsiones. Parpadeando en otras �reas del ojo (que tienen un n�mero mucho menor sensores) tiene un efecto mucho menor en la corteza. Por lo tanto, el foco �nicamente en los 10 grados de la visi�n central.", 
				categoriaTecnica);
	}

	/**
	 * 1.  Verificar que s�lo un �rea de la pantalla parpadea en cualquier momento.
	 * 2.  Verificar que el contenido de parpadear encajar�a en un contenedor contiguo cuya �rea es menor que la peque�a zona segura.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDestellosPorDebajoUmbralLimite = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Destellos por debajo del umbral l�mite", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que s�lo un �rea de la pantalla parpadea en cualquier momento.",
				"Haz que el contenido destelleante ocupe un espacio peque�o. El mayor tama�o aceptable es de 21 p�xeles cuadrados en una pantalla de 1024 por 768.");
		comprobacionDestellosPorDebajoUmbralLimite.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDestellosPorDebajoUmbralLimite);
		return resultadoEvaluacionTecnica;
	}

}