package ar.edu.uno.poo1.proyecto_vehiculos;

public class Autobus extends Vehiculo {
	
	public static final int CANT_MAX_PASAJEROS = 24; 
	private Persona [] pasajeros;
	private int size;
	
	public Autobus(Persona chofer, double cantKm) {
		super(chofer, cantKm);
		this.setPasajeros(new Persona[24]);
		this.setSize(0);
	}

	public Persona[] getPasajeros() {
		return this.pasajeros;
	}

	public void setPasajeros(Persona[] pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean agregarPasajero(Persona pasajero) {
		if (pasajero == null) return false;
		if (this.getSize() == Autobus.CANT_MAX_PASAJEROS) return false;
		this.getPasajeros()[this.getSize()] = pasajero;
		this.setSize(this.getSize() + 1);
		return true;
	}
	
	public void setChofer(Persona chofer) {
		if (this.getSize() == 0) 
			super.setChofer(chofer);
	}
	
	public String toString() {
		String representacion = "-----------------------------" + "\n";
		representacion += super.toString() + "\n" + "Cant Pasajeros: ";
		representacion += this.getSize();
		representacion += "\n" + "-----------------------------" + "\n";
		return representacion;
	}
	
}