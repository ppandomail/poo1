package ar.edu.uno.poo1.proyecto_archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ar.edu.uno.poo1.proyecto_punto.Cuadrante;
import ar.edu.uno.poo1.proyecto_punto.Plano;
import ar.edu.uno.poo1.proyecto_punto.Punto;

public class LecturaArchivoPuntos {
	
	public static void main(String[] args) {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String linea = null;
		Plano plano = new Plano();
		try {
			fileReader = new FileReader(
				"resources//puntos.in");
			bufferedReader = new BufferedReader(fileReader);
			while ((linea = bufferedReader.readLine()) != null) {
				System.out.println(linea);
				String[] lineaSpliteada = linea.split(",");
				plano.agregarPunto(new Punto(Double.parseDouble(lineaSpliteada[0]), Double
					.parseDouble(lineaSpliteada[1])));
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
		System.out.println(plano.getCantidadPuntos(Cuadrante.I));
		System.out.println(plano.getCantidadPuntos(Cuadrante.II));
		System.out.println(plano.getCantidadPuntos(Cuadrante.III));
		System.out.println(plano.getCantidadPuntos(Cuadrante.IV));
	}

}