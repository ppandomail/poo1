package ar.edu.uno.poo1.proyecto_granmanzana;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nombre;
	private int dni;
	private List<Orden> ordenes;
	
	public Cliente(String nombre, int dni) {
		this.setNombre(nombre);
		this.setDni(dni);
		this.setOrdenes(new ArrayList<Orden>());
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public List<Orden> getOrdenes() {
		return this.ordenes;
	}

	public void setOrdenes(List<Orden> ordenes) {
		this.ordenes = ordenes;
	}
	
	public void addOrden(Orden o) {
		this.getOrdenes().add(o);
	}

}