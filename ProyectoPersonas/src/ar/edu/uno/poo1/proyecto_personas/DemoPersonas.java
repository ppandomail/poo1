package ar.edu.uno.poo1.proyecto_personas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DemoPersonas {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		ColaPersonas colaPersonas = new ColaPersonas();
		try {
			fr = new FileReader("resources/Datos.in");
			br = new BufferedReader(fr);
			String linea = null;
			while ((linea = br.readLine()) != null) {
				String [] split = linea.split(",");
				Persona persona = new Persona(split);
				colaPersonas.agregarPersona(persona);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		try {
			if (br != null)
				br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println(colaPersonas);
		HashMap<TipoCola, ConcurrentLinkedQueue<Persona>> mapa = colaPersonas.getMapaEdad();
		for(TipoCola tc : mapa.keySet())
			System.out.println(mapa.get(tc));
	}

}