package ar.edu.uno.poo1.proyecto_videoclub;

public abstract class Entrega implements Entregable, Reseteable {
	
	private String titulo;
	protected boolean entregado;
	private Genero genero;
	private String titulo_bkp;
	private Genero genero_bkp;
	
	public Entrega(String titulo, Genero genero) {
		this.setTitulo(titulo);
		this.setGenero(genero);
		this.entregado = false;
		this.setTitulo_bkp(titulo);
		this.setGenero_bkp(genero);
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
	
	public String getTitulo_bkp() {
		return this.titulo_bkp;
	}

	public void setTitulo_bkp(String titulo_bkp) {
		this.titulo_bkp = titulo_bkp;
	}

	public Genero getGenero_bkp() {
		return this.genero_bkp;
	}

	public void setGenero_bkp(Genero genero_bkp) {
		this.genero_bkp = genero_bkp;
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
	
	public void reset() {
		this.setTitulo(this.getTitulo_bkp());
		this.setGenero(this.getGenero_bkp());
		this.devolver();
	}

}