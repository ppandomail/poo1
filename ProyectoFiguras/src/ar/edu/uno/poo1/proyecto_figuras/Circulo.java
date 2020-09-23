package ar.edu.uno.poo1.proyecto_figuras;

public class Circulo implements Figura {
	
	private double radio;
	
	public Circulo(double radio) {
		this.setRadio(radio);
	}
	
	public Circulo() {
		this(1.0);
	}
	
	public double getRadio() {
		return this.radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double area() {
		return Math.PI * this.getRadio() * this.getRadio();
	}

	@Override
	public String toString() {
		return "Circulo [radio= " + this.getRadio() + "]";
	}
	
}