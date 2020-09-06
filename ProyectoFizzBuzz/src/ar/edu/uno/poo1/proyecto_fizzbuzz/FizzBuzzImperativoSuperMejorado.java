package ar.edu.uno.poo1.proyecto_fizzbuzz;

public class FizzBuzzImperativoSuperMejorado {

	public static void main(String[] args) {
		for(int i=1; i<=100; i++) 
			if (FizzBuzzImperativoSuperMejorado.esDivisiblePor3(i) && FizzBuzzImperativoSuperMejorado.esDivisiblePor5(i))
				FizzBuzzImperativoSuperMejorado.mostrarConsola("FizzBuzz");
			else
				if (FizzBuzzImperativoSuperMejorado.esDivisiblePor3(i))
					FizzBuzzImperativoSuperMejorado.mostrarConsola("Fizz");
				else
					if (FizzBuzzImperativoSuperMejorado.esDivisiblePor5(i))
						FizzBuzzImperativoSuperMejorado.mostrarConsola("Buzz");
					else FizzBuzzImperativoSuperMejorado.mostrarConsola(String.valueOf(i));

	}

	public static boolean esDivisiblePor3(int numero) {
		return FizzBuzzImperativoSuperMejorado.esDivisible(numero, 3);
	}

	public static boolean esDivisiblePor5(int numero) {
		return FizzBuzzImperativoSuperMejorado.esDivisible(numero, 5);
	}
	
	public static boolean esDivisible(int numero, int divisor) {
		return numero % divisor == 0;
	}
	
	public static void mostrarConsola(String mensaje) {
		System.out.println(mensaje);
	}

}