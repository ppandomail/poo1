package ar.edu.uno.poo1.proyecto_punto;

public enum Cuadrante {

	I("Cuadrante I"),
	II("Cuadrante II"),
	III("Cuadrante III"),
	IV("Cuadrante IV"), 
	SC("Sin Cuadrante");

	private String representacion;

	private Cuadrante(String representacion) {
		this.setRepresentacion(representacion);
	}

	public String getRepresentacion() {
		return this.representacion;
	}

	public void setRepresentacion(String representacion) {
		this.representacion = representacion;
	}

	public String toString() {
		return this.getRepresentacion();
	}

}	