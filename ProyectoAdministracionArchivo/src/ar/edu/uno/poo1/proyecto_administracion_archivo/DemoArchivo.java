package ar.edu.uno.poo1.proyecto_administracion_archivo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoArchivo {

	public static void main(String[] args) {
		File file = new File("/Users/ppando/Desktop/Prueba/Arch.txt"); //Absoluto
		System.out.println(file.exists()); //true
		System.out.println(file.isDirectory()); //false
		System.out.println(file.isFile()); //true
		System.out.println(file.getName()); //Arch.txt
		System.out.println(file.getPath()); ///Users/ppando/Desktop/Prueba/Arch.txt
		System.out.println(file.getParent()); ///Users/ppando/Desktop/Prueba
		System.out.println(file.canRead()); //true
		System.out.println(file.canWrite()); //true
		System.out.println(file.isHidden()); //false
		System.out.println(file.toURI()); //file:/Users/ppando/Desktop/Prueba/Arch.tx
		System.out.println(file.length()); //18
		System.out.println(file.lastModified());
		Date date = new Date(file.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println(sdf.format(date));
		
		File dir = new File("/Users/ppando/Desktop/Prueba/Otro");
		if (!dir.exists())
			dir.mkdir();
		else
			dir.delete();
		
		File file2 = new File("resources/Arch2.txt"); //Relativo
		System.out.println(file2.exists());
		File dir2 = new File("resources");
		if (dir2.isDirectory())  {
			System.out.println("SIN FILTRO");
			for(File arch : dir2.listFiles())
				System.out.println(arch.getName() + " -> " + arch.length());
			System.out.println("CON FILTRO EXTENSION");
			for(File arch : dir2.listFiles(new MiFiltro("txt")))
				System.out.println(arch.getName());
			System.out.println("CON FILTRO REGEXP");
			for(File arch : dir2.listFiles(new OtroFiltro("([a-zA-Z0-9])+4\\.([a-zA-Z])+")))
				System.out.println(arch.getName());
		}
		
		File fileACrear = new File("resources/ArchivoCreado.txt");
		if (!fileACrear.exists())
			try {
				fileACrear.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}