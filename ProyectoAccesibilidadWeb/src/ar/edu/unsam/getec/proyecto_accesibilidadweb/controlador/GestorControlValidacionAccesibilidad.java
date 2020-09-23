package ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Contexto;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ContextoClaves;

public class GestorControlValidacionAccesibilidad implements Runnable {
	
	private TipoValidacion tipoValidacion;
	private String texto;
	private String principios;
	private Integer actual;
	private Integer meta;

	public GestorControlValidacionAccesibilidad(TipoValidacion tipoValidacion, String texto, String principios, Integer meta) { 
		this.setTipoValidacion(tipoValidacion);
		this.setTexto(texto);
		this.setPrincipios(principios);
		this.setActual(0);
		this.setMeta(meta);
	}

	public void run() {
		new Thread(new GestorValidacionAccesibilidad(this.getTipoValidacion(), this.getTexto(), this.getPrincipios())).start();
		try {
			while ((this.getActual() < this.getMeta()) || (Contexto.get(ContextoClaves.RESULTADOS) == null)) {
				Thread.sleep(100);
				this.setActual(this.getActual() + 1);
			}
		} catch(InterruptedException e) { }
	}

	public TipoValidacion getTipoValidacion() {
		return this.tipoValidacion;
	}

	public void setTipoValidacion(TipoValidacion tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPrincipios() {
		return this.principios;
	}

	public void setPrincipios(String principios) {
		this.principios = principios;
	}

	public Integer getActual() {
		return this.actual;
	}

	public void setActual(Integer actual) {
		this.actual = actual;
	}

	public Integer getMeta() {
		return this.meta;
	}

	public void setMeta(Integer meta) {
		this.meta = meta;
	}


}
