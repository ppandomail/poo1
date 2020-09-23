package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG192 extends TecnicaGeneral {

	public TecnicaG192(CategoriaTecnica categoriaTecnica) {
		super(
				"G192", 
				"Totalmente conforme a las especificaciones.", 
				"Cuando se utilizan lenguajes de marcado de una manera que se ajuste plenamente a sus especificaciones, todos los requisitos en 4.1.1 se cumplen. Por lo tanto, mientras plenamente conforme a las especificaciones no est� obligado a cumplir con las WCAG 2.0, es una buena pr�ctica y es suficiente para cumplir con los Criterios 4.1.1.", 
				categoriaTecnica);
	}

	/**
	 * 1 . Verificar que todas las tecnolog�as se utilizan de acuerdo con las especificaciones.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionUsoTecnologiasDeAcuerdoConEspecificaciones = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Todas las tecnolog�as se utilizan de acuerdo con las especificaciones.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todas las tecnolog�as se utilizan de acuerdo con las especificaciones.",
				"Valida la p�gina web y aseg�rate que cumplen completamente las especificaciones.");
		comprobacionUsoTecnologiasDeAcuerdoConEspecificaciones.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionUsoTecnologiasDeAcuerdoConEspecificaciones);
		return resultadoEvaluacionTecnica;
	}

}