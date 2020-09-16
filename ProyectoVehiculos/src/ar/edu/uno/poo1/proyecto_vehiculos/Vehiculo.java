package ar.edu.uno.poo1.proyecto_vehiculos;

public abstract class Vehiculo {
	
	private Persona chofer;
	private double cantidadKm;
	
	public Vehiculo(Persona chofer, double cantidadKm) {
		this.setChofer(chofer);
		this.setCantidadKm(cantidadKm);
	}

	public Persona getChofer() {
		return this.chofer;
	}

	public void setChofer(Persona chofer) {
		this.chofer = chofer;
	}

	public double getCantidadKm() {
		return this.cantidadKm;
	}

	public void setCantidadKm(double cantidadKm) {
		this.cantidadKm = cantidadKm;
	}
	
}