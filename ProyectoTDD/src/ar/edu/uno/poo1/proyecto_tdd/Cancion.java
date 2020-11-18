package ar.edu.uno.poo1.proyecto_tdd;

public class Cancion {
	
	private String titulo;
	private int duracion;
	
	public Cancion(String string) {
		this(string, 5);
	}

	public Cancion(String string, int i) {
		titulo = string;
		duracion = i;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getTitulo() {
		return titulo;
	}
	
}