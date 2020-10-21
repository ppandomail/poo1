package ar.edu.uno.poo1.proyecto_granmanzana;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		Notebook notebook1 = new Notebook("Abble", "Pro", "", 100);
		Notebook notebook2 = new Notebook("Mamung", "Z", "", 200);
		DetalleOrden detalleOrden1 = new DetalleOrden(notebook1, 20000, 2);
		DetalleOrden detalleOrden2 = new DetalleOrden(notebook2, 10000, 1);
		Orden orden = new Orden(1, new Date());
		orden.agregarItem(detalleOrden1);
		orden.agregarItem(detalleOrden2);
		System.out.println(orden.calcularTotalOrden());
	}

}