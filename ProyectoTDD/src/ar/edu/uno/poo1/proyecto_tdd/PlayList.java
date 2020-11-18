package ar.edu.uno.poo1.proyecto_tdd;

import java.util.LinkedList;
import java.util.List;

public class PlayList {
	
	private List<Cancion> canciones;
	
	public PlayList() {
		canciones = new LinkedList<Cancion>();
	}
	
	public void agregar(Cancion cancion) {
		canciones.add(cancion);	
	}

	public Object getCantidadCanciones() {
		return canciones.size();
	}

	public int getDuracion() {
		int acum = 0;
		for(Cancion cancion : canciones)
			acum += cancion.getDuracion();
		return acum;
	}

	public String getTituloMenorDuracion() {
		if (canciones.isEmpty()) return "";
		Cancion cancionConDurMin = canciones.get(0);
		for (int i = 1; i < canciones.size(); i++)
			if (canciones.get(i).getDuracion() < cancionConDurMin.getDuracion())
				cancionConDurMin = canciones.get(i);
		return cancionConDurMin.getTitulo();
	}

}