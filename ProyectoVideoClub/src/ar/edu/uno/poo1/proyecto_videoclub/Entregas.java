package ar.edu.uno.poo1.proyecto_videoclub;

public class Entregas {
	
	private Entrega [] arreglo;
	
	public Entregas(Entrega [] arreglo) {
		this.setArreglo(arreglo);
	}
	
	public Entrega[] getArreglo() {
		return this.arreglo;
	}

	public void setArreglo(Entrega[] arreglo) {
		this.arreglo = arreglo;
	}
	
	public int getCantidadEntregados() {
		if (this.getArreglo() == null) return 0;
		int contador = 0;
		for (Entregable entrega : this.getArreglo()) 
			if (entrega.isEntregado())
				contador++;
		return contador;
	}
	
	public Entrega getMax() {
		if (this.getArreglo() == null) return null;
		if (this.getArreglo().length == 0) return null;
		Entrega entregaMax = this.getArreglo()[0];
		for (Entrega entrega : this.getArreglo())
			if (entrega.compareTo(entregaMax) > 0)
				entregaMax = entrega;
		return entregaMax;
	}
	
}