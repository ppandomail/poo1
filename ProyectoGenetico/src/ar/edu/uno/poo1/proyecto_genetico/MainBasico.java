package ar.edu.uno.poo1.proyecto_genetico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainBasico {

	public static void main(String[] args) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String linea = null;
		Poblacion poblacion = new Poblacion();
		try {
			fileReader = new FileReader("resources//poblacion.txt");
			bufferedReader = new BufferedReader(fileReader);
			while ((linea = bufferedReader.readLine()) != null) {
				poblacion.agregarCromosoma(new Cromosoma(linea));
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		try {
			if (bufferedReader != null)
				bufferedReader.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		for (Cromosoma c : poblacion.getPoblacion())
			System.out.println(c);
		System.out.println(poblacion.mutar());
	}

}