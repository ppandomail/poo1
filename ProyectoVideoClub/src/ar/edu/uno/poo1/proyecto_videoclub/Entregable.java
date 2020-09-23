package ar.edu.uno.poo1.proyecto_videoclub;

public interface Entregable {
	
	void entregar();
	void devolver();
	boolean isEntregado();
	int compareTo(Object objeto);

}