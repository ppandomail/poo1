package ar.edu.uno.poo1.proyecto_carrito;

public class ItemCarrito {
	
	private Integer cantidadLibrosAComprar;
	private Libro libro;
	
	public ItemCarrito(Integer cantidadLibrosAComprar, Libro libro) {
		this.setCantidadLibrosAComprar(cantidadLibrosAComprar);
		this.setLibro(libro);
	}
	
	public ItemCarrito(Libro libro) {
		this(1, libro);
	}
	
	public Integer getCantidadLibrosAComprar() {
		return this.cantidadLibrosAComprar;
	}
	
	public void setCantidadLibrosAComprar(Integer cantidadLibrosAComprar) {
		this.cantidadLibrosAComprar = cantidadLibrosAComprar;
	}
	
	public Libro getLibro() {
		return this.libro;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public Double getPrecio() {
		return this.getCantidadLibrosAComprar() * this.getLibro().getPrecio();
	}
	
}