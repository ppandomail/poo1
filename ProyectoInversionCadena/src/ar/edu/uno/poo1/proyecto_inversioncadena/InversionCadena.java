package ar.edu.uno.poo1.proyecto_inversioncadena;

public class InversionCadena {

	public static void main(String[] args) {
		System.out.println(InversionCadena.invertir("Programación con Objetos 1"));

	}
	
	public static String invertir(String cadena) {
		String cadenaInvertida = "";
		for (int x=cadena.length()-1; x>=0; x--)
			cadenaInvertida += cadena.charAt(x);
		return cadenaInvertida;
	}

}