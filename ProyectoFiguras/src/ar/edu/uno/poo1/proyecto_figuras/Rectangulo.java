package ar.edu.uno.poo1.proyecto_figuras;

public class Rectangulo implements Figura {
	
	private double base;
	private double altura;
	
	public Rectangulo(double base, double altura) {
		this.setBase(base);
		this.setAltura(altura);
	}
	
	public Rectangulo() {
		this(2.0, 1.0);
	}
	
	public double getBase() {
		return this.base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return this.altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public double area() {
		return this.getBase() * this.getAltura();
	}

	@Override
	public String toString() {
		return "Rectangulo [base= " + this.getBase() + ", altura= " + this.getAltura() + "]";
	}
	
}