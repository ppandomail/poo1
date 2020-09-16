package ar.edu.uno.poo1.proyecto_punto;

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
	
	public static void main(String[] args) {
		Punto3D p3D1 = new Punto3D();
		Punto3D p3D2 = new Punto3D(1.0, 2.0, 3.0);
		Punto3D p3D3 = new Punto3D(9.9);
		Punto p2D1 = new Punto(2.0, 3.0);
		
		/*System.out.println(p3D1.getX()); //0.0
		System.out.println(p3D1.calcularDistancia(p3D1)); //0.0
		System.out.println(p3D1.calcularDistancia(p2D1)); //0.0
		System.out.println(p3D1.calcularDistancia(p3D2)); //3.74
		*/
		
		Punto [] vector = new Punto[] {p3D1, p2D1, p3D2, p3D3, new Punto(), new Punto(3.14)};
		for (Punto p : vector) 
			System.out.println(p);
		
	}
	
	public String toString() {
		return super.toString().replace(')', ',').concat(String.valueOf(this.getZ())).concat(")");
	}
	
	

}