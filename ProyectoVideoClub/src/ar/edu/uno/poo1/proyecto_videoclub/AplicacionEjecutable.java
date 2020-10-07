package ar.edu.uno.poo1.proyecto_videoclub;

public class AplicacionEjecutable {

	public static void main(String[] args) {
		Pelicula [] peliculas = new Pelicula[] {new Pelicula(), new Pelicula("Titanic", 2021, Genero.DRAMA, "Cameron")};
		Serie [] series = new Serie[] {new Serie(), new Serie("Lost", 1, Genero.SUSPENSO, "Abrams"), new Serie()};
		VideoJuego [] videoJuegos = new VideoJuego[] {new VideoJuego(), new VideoJuego("Pacman", 5)};
		peliculas[1].entregar();
		series[0].entregar();
		series[1].entregar();
		Entregas entregasPeliculas = new Entregas(peliculas);
		Entregas entregasSeries = new Entregas(series);
		Entregas entregasVideoJuegos = new Entregas(videoJuegos);
		System.out.println(entregasPeliculas.getCantidadEntregados());
		System.out.println(entregasSeries.getCantidadEntregados());
		System.out.println(entregasVideoJuegos.getCantidadEntregados());
		System.out.println(entregasPeliculas.getMax());
		System.out.println(entregasSeries.getMax());
		System.out.println(entregasVideoJuegos.getMax());
	}
	
	

}