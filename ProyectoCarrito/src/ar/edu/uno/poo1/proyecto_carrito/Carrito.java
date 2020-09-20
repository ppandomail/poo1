package ar.edu.uno.poo1.proyecto_carrito;

import java.util.ArrayList;

public class Carrito {
	
	private static final Integer CANTIDAD_MAXIMA_ITEMS = 30;
	private Integer contadorItems;
	private ArrayList<ItemCarrito> itemsCarrito;
	
	public Carrito() {
		this.setContadorItems(0);
		this.setItemsCarrito(new ArrayList<ItemCarrito>(Carrito.getCantidadMaximaItems()));
	}
	
	public Integer getContadorItems() {
		return this.contadorItems;
	}
	
	public void setContadorItems(Integer contadorItems) {
		this.contadorItems = contadorItems;
	}
	
	public ArrayList<ItemCarrito> getItemsCarrito() {
		return this.itemsCarrito;
	}
	
	public void setItemsCarrito(ArrayList<ItemCarrito> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}
	
	public static Integer getCantidadMaximaItems() {
		return Carrito.CANTIDAD_MAXIMA_ITEMS;
	}
	
	public void agregarItemCarrito(ItemCarrito itemCarrito) {
		if (this.getContadorItems() <= Carrito.getCantidadMaximaItems()) {
			this.getItemsCarrito().add(itemCarrito);
			this.setContadorItems(this.getContadorItems() + 1);
		}
	}
	
	// TODO
	public void eliminarItemCarrito(ItemCarrito itemCarrito) {
		
	}
	
	public Double getPrecio() {
		Double acumuladorPrecioItemCarrito = 0.0;
		for (ItemCarrito itemCarrito : this.getItemsCarrito())
			acumuladorPrecioItemCarrito += itemCarrito.getPrecio();
		return acumuladorPrecioItemCarrito;
	}
	
	public Integer getCantidadLibrosPorGenero(Genero genero) {
		Integer contadorLibrosPorGenero = 0;
		for (ItemCarrito itemCarrito : this.getItemsCarrito())
			if (itemCarrito.getLibro().getGenero().equals(genero))
				contadorLibrosPorGenero++;
		return contadorLibrosPorGenero;
	}
	
	public String toString() {
		String representacion = "--------------------------------------" + "\n";
		for (ItemCarrito itemCarrito : this.getItemsCarrito())
			representacion += itemCarrito.getCantidadLibrosAComprar() + "\t"
					+ String.format("%1$-20s", itemCarrito.getLibro().getTitulo()) + "\t"
					+ itemCarrito.getPrecio() + "\n";
		representacion += "--------------------------------------" + "\n";
		representacion += "Cantidad Items: " + this.getContadorItems() + "\n";
		representacion += "TOTAL A PAGAR : " + this.getPrecio();
		return representacion;
	}
	
}