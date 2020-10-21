package ar.edu.uno.poo1.proyecto_supermercado;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ColaClientes {

	private ConcurrentLinkedQueue<Cliente> clientes;

	public ColaClientes() {
		this.setClientes(new ConcurrentLinkedQueue<Cliente>());
	}

	public ConcurrentLinkedQueue<Cliente> getClientes() {
		return this.clientes;
	}

	private void setClientes(ConcurrentLinkedQueue<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void ponerCliente(Cliente cliente) {
		this.getClientes().offer(cliente);
	}

	public Cliente sacarCliente() {
		return this.getClientes().poll();
	}

	public Cliente verCliente() {
		return this.getClientes().peek();
	}

	public boolean estaVacia() {
		return this.getClientes().isEmpty();
	}

	public String toString() {
		if (this.estaVacia()) return "";
		String representacion = "";
		Cliente cliente = this.sacarCliente();
		representacion += cliente;
		int marca = cliente.getNumeroUbicacion();
		this.ponerCliente(cliente);
		while (this.verCliente().getNumeroUbicacion() != marca) {
			cliente = this.sacarCliente();
			representacion += cliente;
			this.ponerCliente(cliente);
		}
		return representacion.substring(0, representacion.length()-2);
	}

}