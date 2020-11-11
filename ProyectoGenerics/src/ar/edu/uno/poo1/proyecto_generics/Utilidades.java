package ar.edu.uno.poo1.proyecto_generics;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {
	
	public static <E> List<E> getPares(List<E> lista) {
		if (lista == null) return null;
		if (lista.isEmpty()) return lista;
		List<E> listaARetornar =  new ArrayList<E>();
		for(int i=0; i < lista.size(); i+=2)
			listaARetornar.add(lista.get(i));
		return listaARetornar;
	}

}