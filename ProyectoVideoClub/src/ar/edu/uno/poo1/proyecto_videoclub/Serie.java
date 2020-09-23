package ar.edu.uno.poo1.proyecto_videoclub;

public class Serie extends Entrega {
	
	private int numeroTemporadas;
	private String creador;
	
	public Serie(String titulo, int numeroTemporadas, Genero genero, String creador) {
		super(titulo, genero);
		this.setNumeroTemporadas(numeroTemporadas);
		this.setCreador(creador);
	}
	
	public Serie(String titulo, String creador) {
		this(titulo, 3, Genero.NO_DEFINIDO, creador);
	}
	
	public Serie() {
		this("", "");
	}

	public int getNumeroTemporadas() {
		return this.numeroTemporadas;
	}

	public void setNumeroTemporadas(int numeroTemporadas) {
		this.numeroTemporadas = numeroTemporadas;
	}

	public String getCreador() {
		return this.creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Número de temporadas=" + this.getNumeroTemporadas() + ", Creador=" + this.getCreador();
	}
	
	@Override
	public int compareTo(Object objeto) {
		if (objeto == null) return 1;
		if (!(objeto instanceof Serie)) return 1;
		Serie serie = (Serie) objeto;
		if (this.getNumeroTemporadas() == serie.getNumeroTemporadas()) return 0;
		return this.getNumeroTemporadas() > serie.getNumeroTemporadas()? 1 : -1;
	}

}