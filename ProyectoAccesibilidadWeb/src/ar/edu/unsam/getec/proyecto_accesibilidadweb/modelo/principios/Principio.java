package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.base.Estructura;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public abstract class Principio extends Estructura {
	
	private List<Pauta> pautas;

	public Principio(String numero, String nombre, String descripcion) {
		super(numero, nombre, descripcion);
		this.setPautas(new ArrayList<Pauta>());
		for (Pauta pauta : this.getPautasAAgregar())
			this.agregarPauta(pauta);
	}

	public abstract List<Pauta> getPautasAAgregar();

	private void agregarPauta(Pauta pauta) {
		this.getPautas().add(pauta);
	}

	public ResultadoEvaluacionPrincipio validarAccesibilidadPorPrincipio(Parseador parseador) {
		ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio = new ResultadoEvaluacionPrincipio(this);
		for (Pauta pauta : this.getPautas())
			resultadoEvaluacionPrincipio.agregarResultadoEvaluacionPauta(pauta.validarAccesibilidadPorPauta(parseador));
		return resultadoEvaluacionPrincipio;
	}

	public List<Pauta> getPautas() {
		return this.pautas;
	}

	public void setPautas(List<Pauta> pautas) {
		this.pautas = pautas;
	}

	public String toString() {
		return this.getNumero();
	}

}