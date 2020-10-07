package ar.edu.uno.poo1.proyecto_videoclub;

public class AplicacionReseteable {

	public static void main(String[] args) {
		Entrega entregas [] = new Entrega[] {
				new Pelicula("Batman", "Campanella"),
				new Serie("Los Simuladores", 2, Genero.ACCION, "Sifrom"),
				new Pelicula()
		};
		entregas[0].setTitulo("Batman 2");
		System.out.println(entregas[0]);
		entregas[0].reset();
		System.out.println(entregas[0]);
	}

}
