package ar.edu.uno.poo1.proyecto_videoclub;

public abstract class Entrega implements Entregable {
	
	private String titulo;
	protected boolean entregado;
	private Genero genero;
	
	public Entrega(String titulo, Genero genero) {
		this.setTitulo(titulo);
		this.setGenero(genero);
		this.entregado = false;
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

	@Override
	public String toString() {
		return "Titulo=" + this.getTitulo() + ", "
				+ "Entregado=" + ((this.entregado)? "SI" : "NO") + ", "
						+ "Genero=" + this.getGenero();
	}
	
	@Override
	public void entregar() {
		this.entregado = true;
	}

	@Override
	public void devolver() {
		this.entregado = false;
	}

	@Override
	public boolean isEntregado() {
		return this.entregado;
	}

}