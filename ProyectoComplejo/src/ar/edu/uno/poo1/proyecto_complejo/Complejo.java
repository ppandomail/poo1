package ar.edu.uno.poo1.proyecto_complejo;

public class Complejo implements Comparable<Complejo> {

	private double real;
	private double imag;

	public Complejo(double real ,double imag) {
		this.setReal(real);
		this.setImag(imag);
	}

	public Complejo() {
		this(0,0);
	}

	public Complejo suma(Complejo z) {
		return new Complejo(this.getReal() + z.getReal(), this.getImag() + z.getImag());
	}

	public static Complejo suma(Complejo z1, Complejo z2) {
		return new Complejo(z1.getReal() + z2.getReal(), z1.getImag() + z2.getImag());
	}
	
	public double modulo() {
		return Math.sqrt(Math.pow(this.getReal(), 2) + Math.pow(this.getImag(), 2));
	}

	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null) 
			return false;
		if (this.getClass() != obj.getClass()) 
			return false;
		Complejo other = (Complejo) obj;
		if (Double.doubleToLongBits(this.getImag()) != Double
				.doubleToLongBits(other.getImag())) 
			return false;
		if (Double.doubleToLongBits(this.getReal()) != Double
				.doubleToLongBits(other.getReal())) 
			return false;
		return true;
	}


	public String toString() {
		return "Complejo [real=" + this.getReal() + ", imag=" + this.getImag() + "]";
	}

	public int compareTo(Complejo c1) {
		if (this.modulo()< c1.modulo())
			return -1;
		if (this.modulo()> c1.modulo())
			return 1;
		return 0;
	}

	public final double getReal() {
		return this.real;
	}
	
	public final void setReal(double real) {
		this.real = real;
	}
	
	public final double getImag() {
		return this.imag;
	}
	
	public final void setImag(double imag) {
		this.imag = imag;
	}
	
}