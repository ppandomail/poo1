package ar.edu.uno.poo1.proyecto_productos;

import java.util.LinkedList;

public class ListaProductos {

	private LinkedList<Producto> productos;

	public ListaProductos() {
		this.setProductos(new LinkedList<Producto>());
	}

	public LinkedList<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(LinkedList<Producto> productos) {
		this.productos = productos;
	}

	public void agregarProducto(Producto producto) {
		this.getProductos().add(producto);
	}

	public Producto getKesimo(int kesimo) {
		return this.getProductos().get(kesimo);
	}

	public void incrementarImporte(Producto producto, double porcentaje) {
		int index = this.getProductos().indexOf(producto);
		if (index != -1)
			this.getProductos().get(index).incrementarImporte(porcentaje);
	}

	public int getStock(Producto producto) {
		int index = this.getProductos().indexOf(producto);
		return (index != -1)? this.getProductos().get(index).getStock() : 0;
	}

	public ListaProductos getProductosStockInferiorA(int stock) {
		return this.getProductosStock('<', stock);
	}
	
	public ListaProductos getProductosStockSuperiorIgualA(int stock) {
		return this.getProductosStock('>', stock);
	}

	public ListaProductos getProductosStock(char operador, int stock) {
		ListaProductos listaADevolver = new ListaProductos();
		for(Producto producto : this.getProductos()) 
			switch(operador) {
			case '<': if (producto.getStock() < stock) listaADevolver.agregarProducto(producto);
			break;
			case '>': if (producto.getStock() >= stock) listaADevolver.agregarProducto(producto);
			break;
			}
		return listaADevolver;
	}

	public String toString() {
		String representacion = "";
		for (Producto producto : this.getProductos())
			representacion += producto + "\n";
		return representacion;
	}

}
