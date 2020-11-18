package ar.edu.uno.poo1.proyecto_parcial2020;

public class Persona {
	
	private Integer edad;
	private Integer cantidadHijos;
	
	public Persona(Integer edad, Integer cantidadHijos) {
		this.setEdad(edad);
		this.setCantidadHijos(cantidadHijos);
	}
	
	public Persona() {
		this(25, 2);
	}
	
	public Integer getEdad() {
		return this.edad;
	}
	
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	public Integer getCantidadHijos() {
		return this.cantidadHijos;
	}
	
	public void setCantidadHijos(Integer cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	
}