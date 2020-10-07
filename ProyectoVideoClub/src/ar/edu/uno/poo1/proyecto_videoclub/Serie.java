package ar.edu.uno.poo1.proyecto_videoclub;

public class Serie extends Entrega {
	
	private int numeroTemporadas;
	private String creador;
	private int numeroTemporadas_bkp;
	private String creador_bkp;
	
	public Serie(String titulo, int numeroTemporadas, Genero genero, String creador) {
		super(titulo, genero);
		this.setNumeroTemporadas(numeroTemporadas);
		this.setCreador(creador);
		this.setNumeroTemporadas_bkp(numeroTemporadas);
		this.setCreador_bkp(creador);
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
	
	public int getNumeroTemporadas_bkp() {
		return this.numeroTemporadas_bkp;
	}

	private void setNumeroTemporadas_bkp(int numeroTemporadas_bkp) {
		this.numeroTemporadas_bkp = numeroTemporadas_bkp;
	}

	public String getCreador_bkp() {
		return this.creador_bkp;
	}

	private void setCreador_bkp(String creador_bkp) {
		this.creador_bkp = creador_bkp;
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
	
	public void reset() {
		super.reset();
		this.setNumeroTemporadas(this.getNumeroTemporadas_bkp());
		this.setCreador(this.getCreador_bkp());
	}

}