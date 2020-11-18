package ar.edu.uno.poo1.proyecto_parcial2020;

public class Presentacion {
	
	public Presentacion() {
		
	}
	
	public void encender() {
		System.out.println("encender()");
	}
	
	public void mostrar() throws UsuarioNoAutorizado {
		System.out.println("mostrar()");
	}
	
	public void desplegar() {
		System.out.println("desplegar()");
	}
	
	public void reproducir() throws FormatoCorrupto, RecursoNoEncontrado {
		//if (true) throw new FormatoCorrupto();
		Presentacion p = null;
		p.apagar();
		System.out.println("reproducir()");
	}
	
	public void preguntar() {
		System.out.println("preguntar()");
	}
	
	public void ocultar() {
		System.out.println("ocultar()");
	}
	
	public void apagar() {
		System.out.println("apagar()");
	}
	
	public void explicar(String mensaje) {
		System.out.println("explicar(): " + mensaje);
	}

}