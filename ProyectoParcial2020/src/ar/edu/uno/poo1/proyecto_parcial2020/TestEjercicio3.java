package ar.edu.uno.poo1.proyecto_parcial2020;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEjercicio3 {

	@Test
	public void test1() {
		Libro [][] matriz = new Libro[][] {{}};
		Integer cantidad = Ejercicio3.count(matriz, new Libro("ABC"));
		assertEquals(new Integer(0), cantidad);
	}
	
	@Test
	public void test2() {
		Libro [][] matriz = new Libro[][] {{new Libro("A"), new Libro("C")},
			                               {new Libro("C"), new Libro("C")}};
		Integer cantidad = Ejercicio3.count(matriz, new Libro("C"));
		assertEquals(new Integer(3), cantidad);
	}
		
}