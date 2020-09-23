package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios.Principio;

public class ResultadoEvaluacionPrincipio {
	
	private Principio principio;
	private List<ResultadoEvaluacionPauta> resultadoEvaluacionPautas;

	public ResultadoEvaluacionPrincipio(Principio principio) {
		this.setPrincipio(principio);
		this.setResultadoEvaluacionPautas(new LinkedList<ResultadoEvaluacionPauta>());
	}

	public void agregarResultadoEvaluacionPauta(ResultadoEvaluacionPauta resultadoEvaluacionPauta) {
		this.getResultadoEvaluacionPautas().add(resultadoEvaluacionPauta);
	}

	public Integer getCantidadPautasOKPorPrincipio() {
		Integer cantidadPautasOKPorPrincipio = 0;
		for (ResultadoEvaluacionPauta resultadoEvaluacionPauta : this.getResultadoEvaluacionPautas())
			cantidadPautasOKPorPrincipio += resultadoEvaluacionPauta.getCantidadCriteriosOKPorPauta();
		return cantidadPautasOKPorPrincipio;
	}

	public Integer getCantidadOKPorPrincipio() {
		return this.getCantidadPorPrincipio(TipoResultadoEvaluacion.OK);
	}

	public Integer getCantidadErrorPorPrincipio() {
		return this.getCantidadPorPrincipio(TipoResultadoEvaluacion.ERROR);
	}

	public Integer getCantidadManualPorPrincipio() {
		return this.getCantidadPorPrincipio(TipoResultadoEvaluacion.MANUAL);
	}

	public Integer getCantidadImposiblePorPrincipio() {
		return this.getCantidadPorPrincipio(TipoResultadoEvaluacion.IMPOSIBLE);
	}

	private Integer getCantidadPorPrincipio(TipoResultadoEvaluacion tipoResultadoEvaluacion) {
		Integer cantidad = 0;
		for (ResultadoEvaluacionPauta resultadoEvaluacionPauta : this.getResultadoEvaluacionPautas())
			switch(tipoResultadoEvaluacion.getRepresentacionNumerica()) {
			case 1: cantidad += resultadoEvaluacionPauta.getCantidadOKPorPauta(); break;
			case 2: cantidad += resultadoEvaluacionPauta.getCantidadErrorPorPauta(); break;
			case 3: cantidad += resultadoEvaluacionPauta.getCantidadManualPorPauta(); break;
			case 4: cantidad += resultadoEvaluacionPauta.getCantidadImposiblePorPauta(); break;
			}
		return cantidad;
	}

	public Principio getPrincipio() {
		return this.principio;
	}

	public void setPrincipio(Principio principio) {
		this.principio = principio;
	}

	public List<ResultadoEvaluacionPauta> getResultadoEvaluacionPautas() {
		return this.resultadoEvaluacionPautas;
	}

	public void setResultadoEvaluacionPautas(List<ResultadoEvaluacionPauta> resultadoEvaluacionPautas) {
		this.resultadoEvaluacionPautas = resultadoEvaluacionPautas;
	}

}
