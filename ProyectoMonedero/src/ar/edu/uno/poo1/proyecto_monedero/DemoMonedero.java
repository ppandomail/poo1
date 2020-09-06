package ar.edu.uno.poo1.proyecto_monedero;

public class DemoMonedero {

	public static void main(String[] args) {
		Monedero monedero = new Monedero(25000.0);
		System.out.println(monedero.consultarSaldoFormatoNumerico());
		System.out.println(monedero.consultarSaldoFormatoString());
		
		monedero.meterDinero(2000.0);
		System.out.println(monedero.consultarSaldoFormatoString());
		
		monedero.sacarDinero(30000.0);
		System.out.println(monedero.consultarSaldoFormatoString());
		
		monedero.sacarDinero(27000.0);
		System.out.println(monedero.consultarSaldoFormatoString());
	}

}