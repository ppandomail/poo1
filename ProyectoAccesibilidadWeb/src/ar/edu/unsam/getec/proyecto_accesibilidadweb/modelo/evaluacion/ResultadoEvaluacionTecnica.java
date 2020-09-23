package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;

public class ResultadoEvaluacionTecnica {
	
	private Tecnica tecnica;
	private List<ResultadoEvaluacionTecnicaItem> resultadoEvaluacionTecnicaItems;

	public ResultadoEvaluacionTecnica(Tecnica tecnica) {
		this.setTecnica(tecnica);
		this.setResultadoEvaluacionTecnicaItems(new LinkedList<ResultadoEvaluacionTecnicaItem>());
	}

	public void agregarResultadoEvaluacionTecnicaItem(ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem) {
		this.getResultadoEvaluacionTecnicaItems().add(resultadoEvaluacionTecnicaItem);
	}

	public Integer getCantidadOKPorTecnica() {
		return this.getCantidadPorTecnica(TipoResultadoEvaluacion.OK);
	}

	public Integer getCantidadErrorPorTecnica() {
		return this.getCantidadPorTecnica(TipoResultadoEvaluacion.ERROR);
	}

	public Integer getCantidadManualPorTecnica() {
		return this.getCantidadPorTecnica(TipoResultadoEvaluacion.MANUAL);
	}

	public Integer getCantidadImposiblePorTecnica() {
		return this.getCantidadPorTecnica(TipoResultadoEvaluacion.IMPOSIBLE);
	}

	private Integer getCantidadPorTecnica(TipoResultadoEvaluacion tipoResultadoEvaluacion) {
		Integer cantidad = 0;
		for (ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem : this.getResultadoEvaluacionTecnicaItems())
			if (resultadoEvaluacionTecnicaItem.getTipoResultadoEvaluacion().getRepresentacionNumerica() == tipoResultadoEvaluacion.getRepresentacionNumerica())
				cantidad += resultadoEvaluacionTecnicaItem.getIncidencias();
		return cantidad;
	}

	public boolean isOKResultadoEvaluacionTecnica() {
		Integer cantidad = 0;
		if (this.getTecnica().isCategoriaTecnicaSuficiente())
			for (ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem : this.getResultadoEvaluacionTecnicaItems())
				if (resultadoEvaluacionTecnicaItem.getTipoResultadoEvaluacion().getRepresentacionNumerica() == TipoResultadoEvaluacion.ERROR.getRepresentacionNumerica())
					cantidad += resultadoEvaluacionTecnicaItem.getIncidencias();
		return cantidad == 0;
	}

	public Tecnica getTecnica() {
		return this.tecnica;
	}

	public void setTecnica(Tecnica tecnica) {
		this.tecnica = tecnica;
	}

	public List<ResultadoEvaluacionTecnicaItem> getResultadoEvaluacionTecnicaItems() {
		return this.resultadoEvaluacionTecnicaItems;
	}

	public void setResultadoEvaluacionTecnicaItems(List<ResultadoEvaluacionTecnicaItem> resultadosEvaluacionTecnicaItems) {
		this.resultadoEvaluacionTecnicaItems = resultadosEvaluacionTecnicaItems;
	}

	public String toString() {
		String tecnicaItem = "\n";
		for (ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem : this.getResultadoEvaluacionTecnicaItems())
			tecnicaItem += resultadoEvaluacionTecnicaItem.toString() + "\n";
		return this.getTecnica().toString() + tecnicaItem;
	}

}
