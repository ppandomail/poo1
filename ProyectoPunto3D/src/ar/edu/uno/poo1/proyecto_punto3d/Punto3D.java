package ar.edu.uno.poo1.proyecto_punto3d;

public class Punto3D extends Punto {
	
	private double z;
	
	public Punto3D(double x, double y, double z) {
		super(x, y);
		this.setZ(z);
	}
	
	public Punto3D(double xyz) {
		this(xyz, xyz, xyz);
	}
	
	public Punto3D() {
		this(0.0);
	}
	
	public double getZ() {
		return this.z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public double calcularDistancia(Punto punto) {
		if (!(punto instanceof Punto3D))
			return 0.0;
		Punto3D punto3D = (Punto3D) punto;
		double sumaCuadradoCatetos = Math.pow(this.getX() - punto3D.getX(), 2) + 
				                     Math.pow(this.getY() - punto3D.getY(), 2) + 
				                     Math.pow(this.getZ() - punto3D.getZ(), 2);
		return Math.sqrt(sumaCuadradoCatetos);
	}

	@Override
	public double calcularDistancia(double x, double y) {
		return this.calcularDistancia(new Punto3D(x, y, 0.0));
	}
	
	@Override
	public String toString() {
		return super.toString().replace(')', ',').concat(String.valueOf(this.getZ())).concat(")");
	}
	
}