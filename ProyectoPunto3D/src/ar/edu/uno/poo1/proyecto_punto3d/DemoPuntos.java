package ar.edu.uno.poo1.proyecto_punto3d;

public class DemoPuntos {

	public static void main(String[] args) {
		Punto3D p3D1 = new Punto3D();
		Punto3D p3D2 = new Punto3D(1.0, 2.0, 3.0);
		Punto3D p3D3 = new Punto3D(9.9);
		Punto p2D1 = new Punto(2.0, 3.0);
		
		System.out.println(p3D1.getX()); //0.0
		System.out.println(p3D1.calcularDistancia(p3D1)); //0.0
		System.out.println(p3D1.calcularDistancia(p2D1)); //0.0
		System.out.println(p3D1.calcularDistancia(p3D2)); //3.74
		
		Punto [] vector = new Punto[] {p3D1, p2D1, p3D2, p3D3, new Punto(), new Punto(3.14)};
		for (Punto p : vector) 
			System.out.println(p);
	}

}