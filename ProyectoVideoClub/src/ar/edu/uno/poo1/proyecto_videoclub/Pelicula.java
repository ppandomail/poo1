package ar.edu.uno.poo1.proyecto_videoclub;

import java.util.Calendar;

public class Pelicula extends Entrega {
	
	private int año;
	private String director;
	
	public Pelicula(String titulo, int año, Genero genero, String director) {
		super(titulo, genero);
		this.setAño(año);
		this.setDirector(director);
	}
	
	public Pelicula(String titulo, String director) {
		this(titulo, Calendar.getInstance().get(Calendar.YEAR), Genero.NO_DEFINIDO, director);
	}
	
	public Pelicula() {
		this("", "");
	}
	
	public int getAño() {
		return this.año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return super.toString() + ", Año=" + this.getAño() + ", Director=" + this.getDirector();
	}

	@Override
	public int compareTo(Object objeto) {
		if (objeto == null) return 1;
		if (!(objeto instanceof Pelicula)) return 1;
		Pelicula pelicula = (Pelicula) objeto;
		if (this.getAño() == pelicula.getAño()) return 0;
		return this.getAño() > pelicula.getAño()? 1 : -1;
	}
	
}