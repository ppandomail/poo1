package ar.edu.uno.poo1.proyecto_intercambio_valor_variables;

public class IntercambioValorVariable {

	public static void main(String[] args) {
		int primera = 10, segunda = 20;
		System.out.println("Antes de intercambiar. Primera: " + primera + ", segunda: " + segunda);
		primera = primera + segunda;
		segunda = primera - segunda;
		primera = primera - segunda;
		System.out.println("Después de intercambiar. Primera: " + primera + ", segunda: " + segunda);	
	}

}