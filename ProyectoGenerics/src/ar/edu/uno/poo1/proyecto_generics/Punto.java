package ar.edu.uno.poo1.proyecto_generics;

public class Punto <T1, T2>{
	
	private T1 x;
	private T2 y;
	
	public Punto(T1 x, T2 y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Punto() {
		this(null, null);
	}

	public T1 getX() {
		return this.x;
	}

	public void setX(T1 x) {
		this.x = x;
	}

	public T2 getY() {
		return this.y;
	}

	public void setY(T2 y) {
		this.y = y;
	}
	
	public String toString() {
		return this.getX() + "," + this.getY();
	}
	
}