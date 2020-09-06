package ar.edu.uno.poo1.proyecto_punto;

public class Punto {
	
	private double x;
	private double y;
	
	public Punto(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Punto(double xy) {
		this(xy, xy);
	}
	
	public Punto() {
		this(0.0);
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double calcularDistancia(Punto punto) {
		return Math.hypot(this.getX() - punto.getX(), this.getY() - punto.getY());
	}
	
	public double calcularDistancia(double x, double y) {
		return this.calcularDistancia(new Punto(x, y));
	}
	
	public static double calcularDistancia(Punto punto1, Punto punto2) {
		return Math.hypot(punto1.getX() - punto2.getX(), punto1.getY() - punto2.getY());
	}
	
	public Cuadrante getCuadrante() {
		if (this.getX() > 0 && this.getY() > 0) return Cuadrante.I;
		if (this.getX() < 0 && this.getY() > 0) return Cuadrante.II;
		if (this.getX() < 0 && this.getY() < 0) return Cuadrante.III;
		if (this.getX() > 0 && this.getY() < 0) return Cuadrante.IV;
		return Cuadrante.SC;
	}
	
	public String toString() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}
	
}