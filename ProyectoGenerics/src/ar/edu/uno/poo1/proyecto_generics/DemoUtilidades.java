package ar.edu.uno.poo1.proyecto_generics;

import java.util.ArrayList;
import java.util.List;

public class DemoUtilidades {

	public static void main(String[] args) {
		List<String> listaS = new ArrayList<String>();
		listaS.add("UNO");
		listaS.add("UNLAM");
		listaS.add("UBA");
		listaS.add("UNTREF");
		listaS.add("UNHUR");
		listaS.add("UNM");
		
		List<Integer> listaI = new ArrayList<Integer>();
		listaI.add(1);
		listaI.add(8);
		listaI.add(3);
		listaI.add(9);
		
		List<Double> listaD = new ArrayList<Double>();
		listaD.add(3.14);
		listaD.add(9.81);
		
		System.out.println(Utilidades.getPares(listaS));
		System.out.println(Utilidades.getPares(listaI));
		System.out.println(Utilidades.getPares(listaD));
	}

}