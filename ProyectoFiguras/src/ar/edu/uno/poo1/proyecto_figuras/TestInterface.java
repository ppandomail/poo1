package ar.edu.uno.poo1.proyecto_figuras;

public class TestInterface {

	public static void main(String[] args) {
		Figura [] figuras = new Figura[] {new Cuadrado(), 
				new Circulo(10.0), 
				new Rectangulo(5.0, 10.0),
				new Circulo(),
				new Cuadrado(5.0),
				new Rectangulo()};
		double acumuladorArea = 0;
		for (Figura figura : figuras) {
			System.out.println(figura + " -> area: " + figura.area());
			acumuladorArea += figura.area();
		}
		System.out.println("\nDe un total de " + figuras.length + " figuras, el área total es de " + acumuladorArea);
	}

}