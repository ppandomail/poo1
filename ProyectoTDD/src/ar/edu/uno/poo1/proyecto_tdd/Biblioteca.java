package ar.edu.uno.poo1.proyecto_tdd;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Biblioteca {

	private Map<Genero, List<PlayList>> mapa;

	public Biblioteca() {
		mapa = new HashMap<Genero, List<PlayList>>();
	}

	public void agregar(Genero genero, PlayList playlist) {
		if (mapa.get(genero) == null) {
			List<PlayList> listaPlayList = new LinkedList<PlayList>();
			listaPlayList.add(playlist);
			mapa.put(genero, listaPlayList);
		} else {
			mapa.get(genero).add(playlist);
		}
	}

	public int getCantidadPlayList(Genero genero) {
		return mapa.get(genero) == null ? 0 : mapa.get(genero).size();
	}

}