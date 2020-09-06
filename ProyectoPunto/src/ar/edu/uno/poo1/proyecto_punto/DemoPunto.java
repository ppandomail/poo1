package ar.edu.uno.poo1.proyecto_punto;

public class DemoPunto {

	public static void main(String[] args) {
		Punto punto00 = new Punto();
		Punto punto34 = new Punto(3.0, 4.0);
		System.out.println(punto00);
		System.out.println(punto34);
		System.out.println(punto00.calcularDistancia(punto34));
		System.out.println(Punto.calcularDistancia(punto00, punto34));
		System.out.println(punto00.getCuadrante());
		System.out.println(punto34.getCuadrante());
		
		Punto punto100_200 = new Punto(100.0, 200.0);
		Punto punto400_800 = new Punto(400.0, 800.0);
		System.out.println(punto100_200.calcularDistancia(punto400_800));
		
		Plano plano = new Plano();
		System.out.println(plano);
		plano.agregarPunto(punto00);
		System.out.println(plano);
		plano.agregarPunto(punto34);
		System.out.println(plano);
		plano.agregarPunto(new Punto(-9.8, 5.5));
		plano.agregarPunto(new Punto());
		plano.agregarPunto(new Punto(-1.3, 2.2));
		System.out.println(plano);
		
		System.out.println(Cuadrante.I + ": " + plano.getCantidadPuntos(Cuadrante.I));
		System.out.println(Cuadrante.II + ": " + plano.getCantidadPuntos(Cuadrante.II));
		System.out.println(Cuadrante.III + ": " + plano.getCantidadPuntos(Cuadrante.III));
		System.out.println(Cuadrante.IV + ": " + plano.getCantidadPuntos(Cuadrante.IV));
		System.out.println(Cuadrante.SC + ": " + plano.getCantidadPuntos(Cuadrante.SC));
	}

}