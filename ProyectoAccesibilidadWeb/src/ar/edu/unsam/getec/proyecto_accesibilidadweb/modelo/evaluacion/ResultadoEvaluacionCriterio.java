package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Constantes;

public class ResultadoEvaluacionCriterio {
	
	private static final Integer PUNTAJE_CRITERIO_OK = Constantes.PUNTAJE_CRITERIO_OK;
	private static final Integer PUNTAJE_CRITERIO_ERROR = Constantes.PUNTAJE_CRITERIO_ERROR;
	private Criterio criterio;
	private List<ResultadoEvaluacionTecnica> resultadoEvaluacionTecnicas;

	public ResultadoEvaluacionCriterio(Criterio criterio) {
		this.setCriterio(criterio);
		this.setResultadoEvaluacionTecnicas(new LinkedList<ResultadoEvaluacionTecnica>());
	}

	public void agregarResultadoEvaluacionTecnica(ResultadoEvaluacionTecnica resultadoEvaluacionTecnica) {
		this.getResultadoEvaluacionTecnicas().add(resultadoEvaluacionTecnica);
	}

	public boolean isOKResultadoEvaluacionCriterio() {
		if (this.getResultadoEvaluacionTecnicas().size() == 0)
			return Boolean.TRUE;
		for (ResultadoEvaluacionTecnica resultadoEvaluacionTecnica : this.getResultadoEvaluacionTecnicas())
			if (!resultadoEvaluacionTecnica.isOKResultadoEvaluacionTecnica())
				return Boolean.FALSE;
		return true;
	}

	public Integer getPuntosPorCriterio() {
		return this.isOKResultadoEvaluacionCriterio() ? ResultadoEvaluacionCriterio.PUNTAJE_CRITERIO_OK : ResultadoEvaluacionCriterio.PUNTAJE_CRITERIO_ERROR;
	}

	public Integer getCantidadOKPorCriterio() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.OK);
	}

	public Integer getCantidadErrorPorCriterio() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.ERROR);
	}
	
	public Integer getCantidadErrorPorCriterioTecnicasSuficiente() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.ERROR, CategoriaTecnica.SUFICIENTE);
	}
	
	public Integer getCantidadErrorPorCriterioTecnicasRecomendable() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.ERROR, CategoriaTecnica.RECOMENDABLE);
	}

	public Integer getCantidadManualPorCriterio() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.MANUAL);
	}
	
	public Integer getCantidadManualPorCriterioTecnicasSuficiente() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.MANUAL, CategoriaTecnica.SUFICIENTE);
	}
	
	public Integer getCantidadManualPorCriterioTecnicasRecomendable() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.MANUAL, CategoriaTecnica.RECOMENDABLE);
	}

	public Integer getCantidadImposiblePorCriterio() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.IMPOSIBLE);
	}
	
	public Integer getCantidadImposiblePorCriterioTecnicasSuficiente() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.IMPOSIBLE, CategoriaTecnica.SUFICIENTE);
	}
	
	public Integer getCantidadImposiblePorCriterioTecnicasRecomendable() {
		return this.getCantidadPorCriterio(TipoResultadoEvaluacion.IMPOSIBLE, CategoriaTecnica.RECOMENDABLE);
	}

	private Integer getCantidadPorCriterio(TipoResultadoEvaluacion tipoResultadoEvaluacion) {
		Integer cantidad = 0;
		for (ResultadoEvaluacionTecnica resultadoEvaluacionTecnica : this.getResultadoEvaluacionTecnicas())
			switch(tipoResultadoEvaluacion.getRepresentacionNumerica()) {
			case 1: cantidad += resultadoEvaluacionTecnica.getCantidadOKPorTecnica(); break;
			case 2: cantidad += resultadoEvaluacionTecnica.getCantidadErrorPorTecnica(); break;
			case 3: cantidad += resultadoEvaluacionTecnica.getCantidadManualPorTecnica(); break;
			case 4: cantidad += resultadoEvaluacionTecnica.getCantidadImposiblePorTecnica(); break;
			}
		return cantidad;
	}

	private Integer getCantidadPorCriterio(TipoResultadoEvaluacion tipoResultadoEvaluacion, CategoriaTecnica categoriaTecnica) {
		Integer cantidad = 0;
		for (ResultadoEvaluacionTecnica resultadoEvaluacionTecnica : this.getResultadoEvaluacionTecnicas())
			if (resultadoEvaluacionTecnica.getTecnica().getCategoriaTecnica().getRepresentacionNumerica().equals(categoriaTecnica.getRepresentacionNumerica()))
				switch(tipoResultadoEvaluacion.getRepresentacionNumerica()) {
				case 1: cantidad += resultadoEvaluacionTecnica.getCantidadOKPorTecnica(); break;
				case 2: cantidad += resultadoEvaluacionTecnica.getCantidadErrorPorTecnica(); break;
				case 3: cantidad += resultadoEvaluacionTecnica.getCantidadManualPorTecnica(); break;
				case 4: cantidad += resultadoEvaluacionTecnica.getCantidadImposiblePorTecnica(); break;
				}
		return cantidad;
	}

	public Criterio getCriterio() {
		return this.criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public List<ResultadoEvaluacionTecnica> getResultadoEvaluacionTecnicas() {
		return this.resultadoEvaluacionTecnicas;
	}

	public void setResultadoEvaluacionTecnicas(List<ResultadoEvaluacionTecnica> resultadosEvaluacionTecnica) {
		this.resultadoEvaluacionTecnicas = resultadosEvaluacionTecnica;
	}

	public String toString() {
		String tecnica = "\n";
		for (ResultadoEvaluacionTecnica resultadoEvaluacionTecnica : this.getResultadoEvaluacionTecnicas())
			tecnica += resultadoEvaluacionTecnica.toString() + "\n";
		return this.getCriterio().toString() + tecnica;
	}

}