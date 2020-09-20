package ar.edu.uno.poo1.proyecto_complejo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestComplejo {
	
	@Test
	public void testGetReal() {
		Complejo z = new Complejo(1, 2);
		assertEquals("Fallo, debería dar 1", 1, z.getReal(), 0.0);
	}

	@Test
	public void testGetImag() {
		Complejo z = new Complejo(1, 2);
		assertEquals("Fallo, debería dar 2", 2, z.getImag(), 0.0);
	}

	@Test
	public void testModulo() {
		Complejo z = new Complejo(3, 4);
		assertEquals("Fallo, debería dar 5", 5, z.modulo(), 0.0);
	}

	@Test
	public void testSumaComplejo() {
		Complejo z1 = new Complejo(1,1);
		Complejo z2 = new Complejo(3,2);
		assertEquals("Fallo, deberia dar Complejo(4,3)", new Complejo(4, 3), z1.suma(z2));
	}

	@Test
	public void testSumaComplejoComplejo() {
		Complejo z1 = new Complejo(1,1);
		Complejo z2 = new Complejo(3,2);
		assertEquals("Fallo, deberia dar Complejo(4,3)", new Complejo(4, 3), Complejo.suma(z1, z2));
	}

	@Test
	public void testEqualsObject() {
		Complejo z1 = new Complejo(1,1);
		Complejo z2 = new Complejo(1,1);
		assertTrue("Fallo, deberia dar TRUE", z1.equals(z2));
	}

}