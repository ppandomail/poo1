package ar.edu.uno.poo1.proyecto_vehiculos;

public class Motocicleta extends Vehiculo {
	
	private Persona acompañante;
	
	public Motocicleta(Persona chofer, double cantKm, Persona acompañante) {
		super(chofer, cantKm);
		this.setAcompañante(acompañante);
	}
	
	public Motocicleta(Persona chofer, double cantKm) {
		this(chofer, cantKm, null);
	}

	public Persona getAcompañante() {
		return this.acompañante;
	}

	public void setAcompañante(Persona acompañante) {
		this.acompañante = acompañante;
	}
	
	public void setChofer(Persona chofer) {
		if (this.getAcompañante() == null)
			super.setChofer(chofer);
	}
	
}