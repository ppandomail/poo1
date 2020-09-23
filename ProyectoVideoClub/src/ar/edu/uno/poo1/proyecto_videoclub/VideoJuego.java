package ar.edu.uno.poo1.proyecto_videoclub;

public class VideoJuego extends Entrega {

	private int horasEstimadas;
	private String compañia;
	
	public VideoJuego(String titulo, int horasEstimdas, Genero genero, String compañia) {
		super(titulo, genero);
		this.setHorasEstimadas(horasEstimdas);
		this.setCompañia(compañia);
	}
	
	public VideoJuego(String titulo, int horasEstimadas) {
		this(titulo, horasEstimadas, Genero.NO_DEFINIDO, "");
	}
	
	public VideoJuego() {
		this("", 10);
	}

	public int getHorasEstimadas() {
		return this.horasEstimadas;
	}

	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	public String getCompañia() {
		return this.compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Horas estimadas=" + this.getHorasEstimadas() + ", Compañia=" + this.getCompañia();
	}
	
	@Override
	public int compareTo(Object objeto) {
		if (objeto == null) return 1;
		if (!(objeto instanceof VideoJuego)) return 1;
		VideoJuego videoJuego = (VideoJuego) objeto;
		if (this.getHorasEstimadas() == videoJuego.getHorasEstimadas()) return 0;
		return this.getHorasEstimadas() > videoJuego.getHorasEstimadas()? 1 : -1;
	}
	
}