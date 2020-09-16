package ar.edu.uno.poo1.proyecto_punto3d;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PuntoTest {
	
	@Test
	public void verificar1() {
		assertEquals(0.0, new Punto3D().getX(), 0.01);
	}
	
	@Test
	public void verificar2() {
		Punto3D p3D = new Punto3D();
		assertEquals(new Double(0.0), new Double(p3D.calcularDistancia(p3D)));
	}
	
	@Test
	public void verificar3() {
		assertEquals(new Double(0.0), new Double(new Punto3D().calcularDistancia(new Punto())));
	}
	
	@Test
	public void verificar4() {
		assertEquals(new Double(3.7416573867739413), new Double(new Punto3D().calcularDistancia(new Punto3D(1.0, 2.0, 3.0))));
	}
	
}