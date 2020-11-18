package ar.edu.uno.poo1.proyecto_parcial2020;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

public class TestEjercicio1 {
	
	@Test
	public void test1() {
		LinkedList<Persona> personas = new LinkedList<Persona>();
		personas.add(new Persona(20, 2));
		personas.add(new Persona(23, 2));
		personas.add(new Persona(41, 5));
		Double promedio = Ejercicio1.getChildrenAverage(personas, 20, 41);
		assertEquals(new Double(3.0), promedio);
	}
	
	@Test
	public void test2() {
		LinkedList<Persona> personas = new LinkedList<Persona>();
		personas.add(new Persona(20, 2));
		personas.add(new Persona(23, 2));
		personas.add(new Persona(41, 3));
		Double promedio = Ejercicio1.getChildrenAverage(personas, 20, 23);
		assertEquals(new Double(2), promedio);
	}
	
	@Test
	public void test3() {
		LinkedList<Persona> personas = new LinkedList<Persona>();
		Double promedio = Ejercicio1.getChildrenAverage(personas, 20, 23);
		assertEquals(new Double(0), promedio);
	}
	
	@Test
	public void test4() {
		ArrayList<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona(20, 2));
		personas.add(new Persona(23, 2));
		personas.add(new Persona(41, 3));
		Double promedio = Ejercicio1.getChildrenAverage(personas, 20, 23);
		assertEquals(new Double(2), promedio);
	}
	
}