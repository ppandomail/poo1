package ar.edu.uno.poo1.proyecto_arraylist;

import java.util.ArrayList;
import java.util.List;

public class DemoArrayList {

	public static void main(String[] args) {
		ArrayList<Persona> personas = new MIArrayList<Persona>();    //capac default 10
		List<Persona> personas2 = new ArrayList<Persona>(5);  //capac param 5
		System.out.println(personas.size());
		System.out.println(personas);
		personas.add(new Persona(111, "pepe", 13));
		System.out.println(personas.size());
		//System.out.println(personas);
		personas.add(new Persona(222, "pepa", 60));
		System.out.println(personas);
		for (int i = 1; i <= 8; i++) {
			personas2.add(new Persona(i, "poo1", 27));
			System.out.println(personas2);
		}
		System.out.println(personas2.isEmpty());
		personas2.clear();
		System.out.println(personas2.size());
		Persona per = new Persona(12345, "Pablo Pandolfo", 33);
		System.out.println(personas2.contains(per));
		personas2.add(per);
		System.out.println(personas2.contains(per));	
	}
	
	public static void mostrarArrayList(ArrayList<Persona> personas) {
		for (Persona p : personas)
			System.out.println(p);
	}

}