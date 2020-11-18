package ar.edu.uno.poo1.proyecto_parcial2020;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Ejercicio4 {

	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		lista.add(5);
		lista.add(3);
		lista.add(2);
		lista.add(5);
		lista.add(1);

		System.out.println(Ejercicio4.usarStack(lista));
	}

	public static List<Integer> usarStack(List<Integer> numeros){
		List<Integer> numerosReordenados = new LinkedList<Integer>();
		Stack<Integer> pila = new Stack<Integer>();

		for (Integer numero : numeros) {

			if (numero == 5) {
				pila.push(numero);
			} 
			numerosReordenados.add(numero);
		}

		while(! pila.isEmpty()) {
			numerosReordenados.add(pila.pop());
		}

		return numerosReordenados;
	}
	
}