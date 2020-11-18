package ar.edu.uno.poo1.proyecto_parcial2020;

public class Ejercicio3 {
	
	public static Integer count(Libro [][] matriz, Libro libroToCount) {
		Integer countLibro = 0;
		for (int i = 0; i < matriz.length; i++) 
			for (int j = 0; j < matriz[0].length; j++)
				if (libroToCount.equals(matriz[i][j]))
					countLibro++;
		return countLibro;
	}

}