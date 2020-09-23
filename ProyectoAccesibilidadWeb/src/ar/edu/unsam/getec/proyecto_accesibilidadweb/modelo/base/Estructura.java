package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.base;

public abstract class Estructura {
	
	private String numero;
	private String nombre;
	private String descripcion;

	public Estructura(String numero, String nombre, String descripcion) {
		this.setNumero(numero);
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String toString() {
		return this.getNumero() + ": " + this.getNombre() + " - " + this.getDescripcion();
	}

}