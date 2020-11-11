package ar.edu.uno.poo1.proyecto_annotations;

import java.lang.reflect.Method;

public class DemoAnnotation {

	public static void main(String[] args) {
		Method[] metodos = Persona.class.getMethods();
		for (Method m : metodos)
			System.out.println(m.getName() + "->" + m.getDeclaredAnnotations().length);
	}

}