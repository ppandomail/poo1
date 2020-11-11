package ar.edu.uno.poo1.proyecto_annotations;

public class Persona {
	
	private long dni;
	private String nombre;
	
	public Persona(long dni, String nombre) {
		this.setDni(dni);
		this.setNombre(nombre);
	}

	@Bug(numero = 1, descripcion = "Esto es un bug", desarrollo = "pepe")
	public long getDni() {
		return this.dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Deprecated
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}
		
}