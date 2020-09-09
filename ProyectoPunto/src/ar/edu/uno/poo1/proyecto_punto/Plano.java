package ar.edu.uno.poo1.proyecto_punto;

public class Plano {

	private Punto[] puntos;
	private int tamaño;

	public Plano(int capacidad) {
		this.setPuntos(new Punto[capacidad]);
		this.setTamaño(0);
	}

	public Plano() {
		this(10);
	}

	public Punto[] getPuntos() {
		return puntos;
	}

	public void setPuntos(Punto[] puntos) {
		this.puntos = puntos;
	}

	public int getTamaño() {
		return this.tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}

	public boolean agregarPunto(Punto punto) {
		if (punto == null) return false;
		if (this.getPuntos().length == this.getTamaño())
			return false;
		this.getPuntos()[this.getTamaño()] = punto;
		this.setTamaño(this.getTamaño()+1);
		return true;
	}

	public int getCantidadPuntos(Cuadrante cuadrante) {
		int contador = 0;
		for (int i=0; i<this.getTamaño(); i++) 
			if (this.getPuntos()[i].getCuadrante().equals(cuadrante))
				contador++;
		return contador;
	}

	public String toString() {
		String representacion = "[";
		for (int i=0; i<this.getTamaño(); i++)
			representacion += this.getPuntos()[i] + " , ";
		if (representacion.length() > 1)
			representacion = representacion.substring(0, representacion.length()-3);
		return  representacion + "]";
	}

}