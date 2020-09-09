package ar.edu.uno.poo1.proyecto_cruznumeros;

public class CruzNumeros {

	public static void main(String[] args) {
		CruzNumeros.mostrar(2);
		CruzNumeros.mostrar(3);
		CruzNumeros.mostrar(4);
		CruzNumeros.mostrar(5);
		CruzNumeros.mostrar(6);
	}
	
	public static void mostrar(int numero) {
		String blancos = "";
		for (int i=1; i<numero; i++)
			blancos += " ";
		for (int i=1; i<numero; i++)
			System.out.println(blancos + i);
		for (int i=1; i<=numero; i++)
			System.out.print(i);
		for (int i=numero-1; i>0; i--)
			System.out.print(i);
		System.out.println();
		for (int i=numero-1; i>0; i--)
			System.out.println(blancos + i);
		System.out.println();
	}

}