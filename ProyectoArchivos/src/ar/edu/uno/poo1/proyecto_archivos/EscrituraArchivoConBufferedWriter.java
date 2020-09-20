package ar.edu.uno.poo1.proyecto_archivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraArchivoConBufferedWriter {

	public static void main(String[] args) {
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			fileWriter = new FileWriter(
					"src//ar//edu//uno//poo1//loteprueba//out//00_puntos_primer_cuadrante.out", Boolean.TRUE);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Esto es una prueba");
			bufferedWriter.newLine();
			bufferedWriter.write("y esto otro tambien!");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		try {
			if (bufferedWriter != null)
				bufferedWriter.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

}