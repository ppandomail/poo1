package ar.edu.uno.poo1.proyecto_archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("resources/ArchivoEjercicio1.txt");
			br = new BufferedReader(fr);
			String linea = null;
			String lineas = "";
			while ((linea = br.readLine()) != null) {
				lineas += linea;
			}
			System.out.println(lineas.replace(" ", ""));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (br != null) 
				br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}