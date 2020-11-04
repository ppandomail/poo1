package ar.edu.uno.poo1.proyecto_archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		File [] files = new File[] {new File("resources/ArchivoEjercicio1.txt"), 
				new File("resources/ArchivoEjercicio2.txt")};
		String nombreArchivo = Ejercicio3.getNombresArchivoConcatenados(files);
		String contenido = Ejercicio3.getContenidoArchivos(files);
		Ejercicio3.escribirContenido(nombreArchivo, contenido);
	}

	public static String getNombresArchivoConcatenados(File...files) {
		String nombreArchivoARetornar = "";
		for(File file : files) 
			nombreArchivoARetornar += file.getName().split("[.]")[0] + "_";
		int index = nombreArchivoARetornar.lastIndexOf("_");
		nombreArchivoARetornar = nombreArchivoARetornar.substring(0, index);
		nombreArchivoARetornar = nombreArchivoARetornar + ".txt";
		return nombreArchivoARetornar;
	}

	public static String getContenidoArchivos(File...files) {
		String contenidoARetornar = "";
		for(File file : files) {
			FileReader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(file.getPath());
				br = new BufferedReader(fr);
				String linea = null;
				while ((linea = br.readLine()) != null) 
					contenidoARetornar += linea;
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
		return contenidoARetornar;
	}
	
	public static void escribirContenido(String nombreArchivo, String contenido) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		File file = new File("resources/" + nombreArchivo);
		try {
			boolean append = true;
			if (file.exists()) {
				System.out.println("Desea sobreescribirlo (S/N)?");
				Scanner scan = new Scanner(System.in);
				String respuesta = scan.next();
				scan.close();
				if (respuesta.equals("S"))
					append = false;
			}
			fw = new FileWriter(file, append);
			bw = new BufferedWriter(fw);
			bw.write(contenido);
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