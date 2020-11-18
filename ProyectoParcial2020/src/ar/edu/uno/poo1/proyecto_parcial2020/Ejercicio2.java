package ar.edu.uno.poo1.proyecto_parcial2020;

public class Ejercicio2 extends Presentacion {
	
	private Presentacion pantalla;
	private Presentacion titulo;
	private Presentacion contenido;
	private Presentacion video;
	private Presentacion cuestionario;
	
	public Ejercicio2() {
		pantalla = new Presentacion();
		titulo = new Presentacion();
		contenido = new Presentacion();
		video = new Presentacion();
		cuestionario = new Presentacion();
	}
	
	public void ejecutar() throws ExcepcionDePresentacion {
		
		pantalla.encender();
		
		try {
			titulo.mostrar();
			contenido.desplegar();
			video.reproducir();
			cuestionario.preguntar();
		} catch (RecursoNoEncontrado noEncontrado) {
			pantalla.explicar("No se encontró: " + noEncontrado.obtenerNombre());
		} catch (UsuarioNoAutorizado noAutorizado) {
			pantalla.explicar("Usuario " + noAutorizado.obtenerUsuario() + " no autorizado.");
		} finally {
			video.ocultar();
		}
		pantalla.apagar();
	}
	
	public static void main(String[] args) throws ExcepcionDePresentacion {
		new Ejercicio2().ejecutar();
	}
	
}
