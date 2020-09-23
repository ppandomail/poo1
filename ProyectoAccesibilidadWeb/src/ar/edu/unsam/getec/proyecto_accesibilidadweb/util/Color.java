package ar.edu.unsam.getec.proyecto_accesibilidadweb.util;

public class Color {
	
	private Integer rojo;
	private Integer verde;
	private Integer azul;

	public Color(String color) {
		String [] saturaciones = color.split(",");
		this.setRojo(Integer.parseInt(saturaciones[0]));
		this.setVerde(Integer.parseInt(saturaciones[1]));
		this.setAzul(Integer.parseInt(saturaciones[2]));
	}

	public Color(Integer rojo, Integer verde, Integer azul) {
		this.setRojo(rojo);
		this.setVerde(verde);
		this.setAzul(azul);
	}

	public Integer getRojo() {
		return this.rojo;
	}

	public void setRojo(Integer rojo) {
		this.rojo = rojo;
	}

	public Integer getVerde() {
		return this.verde;
	}

	public void setVerde(Integer verde) {
		this.verde = verde;
	}

	public Integer getAzul() {
		return this.azul;
	}

	public void setAzul(Integer azul) {
		this.azul = azul;
	}

}