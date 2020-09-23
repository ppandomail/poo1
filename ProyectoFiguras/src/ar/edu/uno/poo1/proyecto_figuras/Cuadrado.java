package ar.edu.uno.poo1.proyecto_figuras;

public class Cuadrado implements Figura {

	private double lado;
	
	public Cuadrado(double lado) {
		this.setLado(lado);
	}
	
	public Cuadrado() {
		this(1.0);
	}

	public double getLado() {
		return this.lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public double area() {
		return this.getLado() * this.getLado();
	}

	@Override
	public String toString() {
		return "Cuadrado [lado= " + this.getLado() + "]";
	}
	
}