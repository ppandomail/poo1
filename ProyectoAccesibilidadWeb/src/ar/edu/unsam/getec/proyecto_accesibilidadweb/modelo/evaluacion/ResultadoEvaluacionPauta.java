package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta;

public class ResultadoEvaluacionPauta {
	
	private Pauta pauta;
	private List<ResultadoEvaluacionCriterio> resultadoEvaluacionCriterios;

	public ResultadoEvaluacionPauta(Pauta pauta) {
		this.setPauta(pauta);
		this.setResultadoEvaluacionCriterios(new LinkedList<ResultadoEvaluacionCriterio>());
	}

	public void agregarResultadoEvaluacionCriterio(ResultadoEvaluacionCriterio resultadoEvaluacionCriterio) {
		this.getResultadoEvaluacionCriterios().add(resultadoEvaluacionCriterio);
	}

	public Integer getCantidadCriteriosOKPorPauta() {
		Integer cantidadCriteriosOKPorPauta = 0;
		for (ResultadoEvaluacionCriterio resultadoEvaluacionCriterio : this.getResultadoEvaluacionCriterios())
			if (resultadoEvaluacionCriterio.isOKResultadoEvaluacionCriterio())
				cantidadCriteriosOKPorPauta++;
		return cantidadCriteriosOKPorPauta;
	}

	public Integer getCantidadOKPorPauta() {
		return this.getCantidadPorPauta(TipoResultadoEvaluacion.OK);
	}

	public Integer getCantidadErrorPorPauta() {
		return this.getCantidadPorPauta(TipoResultadoEvaluacion.ERROR);
	}

	public Integer getCantidadManualPorPauta() {
		return this.getCantidadPorPauta(TipoResultadoEvaluacion.MANUAL);
	}

	public Integer getCantidadImposiblePorPauta() {
		return this.getCantidadPorPauta(TipoResultadoEvaluacion.IMPOSIBLE);
	}

	private Integer getCantidadPorPauta(TipoResultadoEvaluacion tipoResultadoEvaluacion) {
		Integer cantidad = 0;
		for (ResultadoEvaluacionCriterio resultadoEvaluacionCriterio : this.getResultadoEvaluacionCriterios())
			switch(tipoResultadoEvaluacion.getRepresentacionNumerica()) {
			case 1: cantidad += resultadoEvaluacionCriterio.getCantidadOKPorCriterio(); break;
			case 2: cantidad += resultadoEvaluacionCriterio.getCantidadErrorPorCriterio(); break;
			case 3: cantidad += resultadoEvaluacionCriterio.getCantidadManualPorCriterio(); break;
			case 4: cantidad += resultadoEvaluacionCriterio.getCantidadImposiblePorCriterio(); break;
			}
		return cantidad;
	}

	public Pauta getPauta() {
		return this.pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public List<ResultadoEvaluacionCriterio> getResultadoEvaluacionCriterios() {
		return this.resultadoEvaluacionCriterios;
	}

	public void setResultadoEvaluacionCriterios(List<ResultadoEvaluacionCriterio> resultadoEvaluacionCriterios) {
		this.resultadoEvaluacionCriterios = resultadoEvaluacionCriterios;
	}


}
