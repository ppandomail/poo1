package ar.edu.uno.poo1.proyecto_teletipo;

public class DemoTeletipo {

	public static void main(String[] args) {
		Teletipo teletipo1 = new Teletipo("abc/d//e*");
		System.out.println("Tira resultante: " + teletipo1.ejecutar());
		
		Teletipo teletipo2 = new Teletipo("ab&c/d//e*");
		System.out.println("Tira resultante: " + teletipo2.ejecutar());
		
		Teletipo teletipo3 = new Teletipo("abcde*");
		System.out.println("Tira resultante: " + teletipo3.ejecutar());
		
		Teletipo teletipo4 = new Teletipo("h/o/l/AM/unD/o*");
		System.out.println("Tira resultante: " + teletipo4.ejecutar());
	}

}