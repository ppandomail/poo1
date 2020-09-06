package ar.edu.uno.poo1.proyecto_fizzbuzz;

public class FizzBuzzOrientadoObjetos {
	
	private int numero;
	
	public FizzBuzzOrientadoObjetos(int numero) {
		this.setNumero(numero);
	}
	
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String toString() {
		if (this.esDivisiblePor3(this.getNumero()) && this.esDivisiblePor5(this.getNumero()))
			return "FizzBuzz";
		if (this.esDivisiblePor3(this.getNumero()))
				return "Fizz";
		if (this.esDivisiblePor5(this.getNumero()))
					return "Buzz";
		return String.valueOf(this.getNumero());
	}
	
	public boolean esDivisiblePor3(int numero) {
		return this.esDivisible(numero, 3);
	}

	public boolean esDivisiblePor5(int numero) {
		return this.esDivisible(numero, 5);
	}
	
	public boolean esDivisible(int numero, int divisor) {
		return numero % divisor == 0;
	}

	public static void main(String[] args) {
		for (int i=1; i<=100; i++)
			System.out.println(new FizzBuzzOrientadoObjetos(i));
	}

}