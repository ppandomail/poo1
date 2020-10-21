package ar.edu.uno.poo1.proyecto_granmanzana;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orden {
	
	private List<DetalleOrden> items;
	private int id;
	private Date creacion;
	private Date envio;
	
	public Orden(int id, Date creacion) {
		this.setItems(new ArrayList<DetalleOrden>());
		this.setId(id);
		this.setCreacion(creacion);
		this.setEnvio(null);
	}

	public List<DetalleOrden> getItems() {
		return this.items;
	}

	public void setItems(List<DetalleOrden> items) {
		this.items = items;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

	public Date getEnvio() {
		return this.envio;
	}

	public void setEnvio(Date envio) {
		this.envio = envio;
	}
	
	public void agregarItem(DetalleOrden detalle) {
		this.getItems().add(detalle);
	}
	
	public int getNroItems() {
		return this.getItems().size();
	}
	
	public double calcularTotalOrden() {
		double acumulador = 0;
		for(DetalleOrden item : this.getItems())
			acumulador += item.getCantidad() * item.getPrecioUnitario();
		return acumulador;
	}
	
}