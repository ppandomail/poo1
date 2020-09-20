package ar.edu.uno.poo1.proyecto_archivos;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscrituraArchivoConPrintWriter {

	public static void main(String[] args) {
		FileWriter archivo = null;
		PrintWriter pw = null;
		try {
			archivo = new FileWriter("prueba.txt");
			pw = new PrintWriter(archivo);
			for (int i = 0; i < 10; i++)
				pw.println("Linea " + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != archivo)
					archivo.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}