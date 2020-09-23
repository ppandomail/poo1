package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.base.Estructura;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionCriterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public abstract class Criterio extends Estructura {
	
	private List<Tecnica> tecnicas;
	private NivelAccesibilidad nivelAccesibilidad;

	public Criterio(String numero, String nombre, String descripcion, NivelAccesibilidad nivelAccesibilidad) {
		super(numero, nombre, descripcion);
		this.setTecnicas(new LinkedList<Tecnica>());
		this.setNivelAccesibilidad(nivelAccesibilidad);
		for (Tecnica tecnica : this.getTecnicasAAgregar())
			this.agregarTecnica(tecnica);
	}

	public abstract List<Tecnica> getTecnicasAAgregar();

	private void agregarTecnica(Tecnica tecnica) {
		this.getTecnicas().add(tecnica);
	}

	public ResultadoEvaluacionCriterio validarAccesibilidadPorCriterio(Parseador parseador) {
		ResultadoEvaluacionCriterio resultadoEvaluacionCriterio = new ResultadoEvaluacionCriterio(this);
		for (Tecnica tecnica : this.getTecnicas())
			resultadoEvaluacionCriterio.agregarResultadoEvaluacionTecnica(tecnica.validarAccesibilidadPorTecnica(parseador));
		return resultadoEvaluacionCriterio;
	}

	public List<Tecnica> getTecnicas() {
		return this.tecnicas;
	}

	public void setTecnicas(List<Tecnica> tecnicas) {
		this.tecnicas = tecnicas;
	}

	public NivelAccesibilidad getNivelAccesibilidad() {
		return this.nivelAccesibilidad;
	}

	public void setNivelAccesibilidad(NivelAccesibilidad nivelAccesibilidad) {
		this.nivelAccesibilidad = nivelAccesibilidad;
	}

	public String toString() {
		return this.getNumero();
	}

}
