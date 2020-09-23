package ar.edu.uno.poo1.proyecto_videoclub;

public class AplicacionEjecutable {

	public static void main(String[] args) {
		Pelicula [] peliculas = new Pelicula[] {new Pelicula(), new Pelicula("Titanic", "Cameron")};
		Serie [] series = new Serie[] {new Serie(), new Serie("Lost", 6, Genero.SUSPENSO, "Abrams"), new Serie()};
		VideoJuego [] videoJuegos = new VideoJuego[] {new VideoJuego(), new VideoJuego("Pacman", 24)};
		peliculas[1].entregar();
		series[0].entregar();
		series[1].entregar();
		System.out.println(AplicacionEjecutable.getCantidadEntregados(peliculas));
		System.out.println(AplicacionEjecutable.getCantidadEntregados(series));
		System.out.println(AplicacionEjecutable.getCantidadEntregados(videoJuegos));
		System.out.println(AplicacionEjecutable.getMax(peliculas));
		System.out.println(AplicacionEjecutable.getMax(series));
		System.out.println(AplicacionEjecutable.getMax(videoJuegos));
	}
	
	private static int getCantidadEntregados(Entrega [] entregas) {
		if (entregas == null) return 0;
		int contador = 0;
		for (Entrega entrega : entregas) 
			if (entrega.isEntregado())
				contador++;
		return contador;
	}
	
	private static Entrega getMax(Entrega [] entregas) {
		if (entregas == null) return null;
		if (entregas.length == 0) return null;
		Entrega entregaMax = entregas[0];
		for (Entrega entrega : entregas)
			if (entrega.compareTo(entregaMax) > 0)
				entregaMax = entrega;
		return entregaMax;
	}

}