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
					"resources/Archivo.txt", Boolean.FALSE);
			bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Recuerden que el parcial es el 12!!!");
			bufferedWriter.newLine();
			bufferedWriter.write("y que no hay TP2");
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