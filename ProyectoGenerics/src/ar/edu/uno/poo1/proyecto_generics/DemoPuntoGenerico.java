package ar.edu.uno.poo1.proyecto_generics;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class DemoPuntoGenerico {

	public static void main(String[] args) {
		Punto<Integer, Integer> p = new Punto<Integer, Integer>(1, 2);
		System.out.println(p.getY());
		System.out.println(p);
		
		Punto<String, Integer> p2 = new Punto<String, Integer>("Nov", 2);
		System.out.println(p2.getX());
		System.out.println(p2);
		
		Punto<Date, File> p3 = new Punto<Date, File>(new Date(), new File("resources/Archivo.txt"));
		System.out.println(p3.getX());
		System.out.println(p3.getY().exists());
		System.out.println(p3);
		
		Punto<ArrayList<Integer>, String> p4 = new Punto<ArrayList<Integer>, String>(new ArrayList<Integer>(), "Prueba");
		System.out.println(p4);
	}

}