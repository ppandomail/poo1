package ar.edu.uno.poo1.proyecto_parcial2020;

import java.util.Collection;

public class Ejercicio1 {

	public static Double getChildrenAverage(Collection<Persona> coleccion, Integer desdeEdad, Integer hastaEdad) {
		if (coleccion == null) return 0.0;
		if (coleccion.isEmpty()) return 0.0;
		if (desdeEdad < 0) return 0.0;
		if (hastaEdad < 0) return 0.0;
		if (hastaEdad < desdeEdad) return 0.0;
		
		Integer cantidadHijos = 0;
		Integer cantidadPersonas = 0;
		for(Persona persona : coleccion) {
			if ((persona.getEdad() >= desdeEdad) && (persona.getEdad() <= hastaEdad)) {
				cantidadHijos += persona.getCantidadHijos();
				cantidadPersonas++;
			}
		}
		return new Double(cantidadHijos/cantidadPersonas);	
	}

}