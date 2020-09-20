package ar.edu.uno.poo1.proyecto_archivos;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class GestionArchivo {
	
	public static void main(String[] args) {
		File fileCarp = new File("c://carp");
		System.out.println(fileCarp.exists());
		System.out.println(fileCarp.isDirectory());
		System.out.println(fileCarp.isFile());
		for (File file : fileCarp.listFiles(new FiltroNombres("*"))) {
			System.out.println(file.getName());
			System.out.println(file.lastModified());
			System.out.println(new Date(file.lastModified()));
		}
		Scanner scanner = new Scanner(System.in);
		String nombreCarpeta = scanner.next();
		File fileCarp2 = new File("c://" + nombreCarpeta);
		if (!fileCarp2.exists())
			fileCarp2.mkdir();
		scanner.close();
	}

}