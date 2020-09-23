package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG19 extends TecnicaGeneral {

	public TecnicaG19(CategoriaTecnica categoriaTecnica) {
		super(
				"G19",
				"Asegurar que ning�n componente del contenido parpadea m�s de tres veces en un periodo de 1 segundo.",
				"El objetivo de esta t�cnica es evitar parpadear a �rates� que son conocidos por causar convulsiones si los destellos son luminosas y lo suficientemente grande. Debido a que algunos usuarios pueden estar usando ampliadores de pantalla, esta t�cnica limita el parpadeo del contenido tama�o a no m�s de tres destellos en cualquier per�odo de 1 segundo.", 
				categoriaTecnica);
	}

	/**
	 * 1.	Verificar que no hay m�s de tres destellos durante cualquier periodo de 1 segundo. 
	 * 2.	Si hay tres destellos, verificar que el estado de la luz / oscuridad al final del periodo de 1 segundo es el mismo que al principio.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDestellosPorDebajoUmbralLimite = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Destellos por debajo del umbral l�mite.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Si hay tres destellos, verificar que el estado de la luz / oscuridad al final del periodo de 1 segundo es el mismo que al principio.",
				"Aseg�rate que ning�n componente del contenido destellea m�s de 3 veces por segundo.");
		comprobacionDestellosPorDebajoUmbralLimite.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDestellosPorDebajoUmbralLimite);
		return resultadoEvaluacionTecnica;
	}

}