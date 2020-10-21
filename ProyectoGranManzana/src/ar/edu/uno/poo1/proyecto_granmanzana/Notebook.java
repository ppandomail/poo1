package ar.edu.uno.poo1.proyecto_granmanzana;

public class Notebook {
	
	private String marca;
	private String modelo;
	private String procesador;
	private float tamañoDisco;
	
	public Notebook(String marca, String modelo, String procesador, float tamañoDisco) {
		this.setMarca(marca);
		this.setModelo(modelo);
		this.setProcesador(procesador);
		this.setTamañoDisco(tamañoDisco);
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProcesador() {
		return this.procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public float getTamañoDisco() {
		return this.tamañoDisco;
	}

	public void setTamañoDisco(float tamañoDisco) {
		this.tamañoDisco = tamañoDisco;
	}
			
}