package ar.edu.uno.poo1.proyecto_granmanzana;

public class DetalleOrden {
	
	private Notebook item;
	private float precioUnitario;
	private int cantidad;
	
	public DetalleOrden(Notebook item, float precioUnitario, int cantidad) {
		this.setItem(item);
		this.setPrecioUnitario(precioUnitario);
		this.setCantidad(cantidad);
	}

	public Notebook getItem() {
		return this.item;
	}

	public void setItem(Notebook item) {
		this.item = item;
	}

	public float getPrecioUnitario() {
		return this.precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}