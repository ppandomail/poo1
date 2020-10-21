package ar.edu.uno.poo1.proyecto_arraylist;

import java.util.ArrayList;

public class Ejercicios {

	public static void main(String[] args) {
		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("pepe");
		palabras.add("casa");
		palabras.add("pepe");
		System.out.println(palabras);
		System.out.println(Ejercicios.todosLosElementosSonUnicos(palabras));
		Ejercicios.eliminarDuplicados(palabras);
		System.out.println(Ejercicios.todosLosElementosSonUnicos(palabras));
		System.out.println(palabras);
		Ejercicios.invertir(palabras);
		System.out.println(palabras);
		palabras.add("casa");
		Ejercicios.reemplazarOcurrencias(palabras, "casa", "casinha");
		System.out.println(palabras);
	}
	
	public static void eliminarDuplicados(ArrayList<?> array) {
	     for (int i = 0; i < array.size(); i++) 
	        for (int j = 0; j < array.size(); j++) 
	           if ((i != j) && (array.get(j).equals(array.get(i))))
	        	   array.remove(j);
	}
	
	public static <E> void invertir(ArrayList<E> array) {
	   int tamanoArreglo = array.size(); 	
	   for (int i = 0; i < tamanoArreglo / 2; i++) {
	      E temporal = array.get(i);   
	      int indiceContrario = tamanoArreglo - i - 1;
	      array.set(i, array.get(indiceContrario));
	      array.set(indiceContrario, temporal);   
	    }
	}
	
	public static <E> boolean todosLosElementosSonUnicos(ArrayList<E> array) {
		 for (int i = 0; i < array.size(); i++) 
		        for (int j = 0; j < array.size(); j++) 
		           if ((i != j) && (array.get(j).equals(array.get(i))))
		        	   return false;
		 return true;
	}
	
	public static <E> void reemplazarOcurrencias(ArrayList<E> array, E elemento, E nuevo) {
		for (int i = 0; i < array.size(); i++) 
			if (array.get(i).equals(elemento))
				array.set(i, nuevo);
	}

}