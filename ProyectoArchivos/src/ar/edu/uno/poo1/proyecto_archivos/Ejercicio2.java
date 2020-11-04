package ar.edu.uno.poo1.proyecto_archivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String contenidoArchivo = scan.nextLine();
		scan.close();
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("resources/ArchivoEjercicio2.txt");
			bw = new BufferedWriter(fw);
			String modificado = "";
			for (int i = 0; i < contenidoArchivo.length(); i++) {
				char caracter = contenidoArchivo.charAt(i);
				String string = Character.toString(caracter);
				if (Character.isLetter(caracter))
					if (Character.isLowerCase(caracter))
						modificado += string.toUpperCase();
					else 
						modificado += string.toLowerCase();
				else
					modificado += string;
			}
			bw.write(contenidoArchivo);
			bw.newLine();
			bw.write(modificado);
			System.out.println(modificado);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (bw != null) 
				bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}