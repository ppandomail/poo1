package ar.edu.uno.poo1.proyecto_carrito;

public class Libro {
	
	private String ISBN;
	private String titulo;
	private Genero genero;
	private Double precio;
	
	public Libro(String ISBN, String titulo, Genero genero, Double precio) {
		this.setISBN(ISBN);
		this.setTitulo(titulo);
		this.setGenero(genero);
		this.setPrecio(precio);
	}
	
	public Libro(String ISBN, String titulo, Genero genero) {
		this(ISBN, titulo, genero, 0.0);
	}
	
	public String getISBN() {
		return this.ISBN;
	}
	
	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Genero getGenero() {
		return this.genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public Double getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}