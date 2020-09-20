package ar.edu.uno.poo1.proyecto_genetico;

import java.util.ArrayList;

public class Poblacion {

	private ArrayList<Cromosoma> poblacion;

	public Poblacion() {
		this.setPoblacion(new ArrayList<Cromosoma>());
	}

	public ArrayList<Cromosoma> getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(ArrayList<Cromosoma> poblacion) {
		this.poblacion = poblacion;
	}

	public void agregarCromosoma(Cromosoma cromosoma) {
		this.getPoblacion().add(cromosoma);
	}

	public Cromosoma mutar() {
		int k = (int) ((Math.random() * 10) % this.getPoblacion().size());
		System.out.println(k);
		Cromosoma c = this.getPoblacion().get(k);
		return c;
	}

}