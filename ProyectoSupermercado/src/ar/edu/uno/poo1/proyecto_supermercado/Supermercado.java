package ar.edu.uno.poo1.proyecto_supermercado;

public class Supermercado {
	
	private ColaClientes colaA;
	private ColaClientes colaB;
	
	public Supermercado() {
		this.setColaA(new ColaClientes());
		this.setColaB(new ColaClientes());
	}

	public ColaClientes getColaA() {
		return this.colaA;
	}

	private void setColaA(ColaClientes colaA) {
		this.colaA = colaA;
	}

	public ColaClientes getColaB() {
		return this.colaB;
	}

	private void setColaB(ColaClientes colaB) {
		this.colaB = colaB;
	}
	
	public void agregarClientesColaA(int cantidadClientes) {
		for(int i = 0; i < cantidadClientes; i++)
			this.getColaA().ponerCliente(new Cliente(i+1, (int) (Math.random()*100 % 100)));
	}
	
	public void agregarClienteColaA(Cliente cliente) {
		this.getColaA().ponerCliente(cliente);
	}
	
	public void abrirColaB(int cantidadMaximaProductos) {
		ColaClientes colaAux = new ColaClientes();
		int ubicacionA = 1;
		int ubicacionB = 1;
		while (!this.getColaA().estaVacia()) {
			Cliente cliente = this.getColaA().sacarCliente();
			if (cliente.getCantidadProductos() >= cantidadMaximaProductos) { 
				cliente.setNumeroUbicacion(ubicacionA++);
				colaAux.ponerCliente(cliente);
			}
			else {
				cliente.setNumeroUbicacion(ubicacionB++);
				this.getColaB().ponerCliente(cliente);
			}
		}
		while (!colaAux.estaVacia())
			this.getColaA().ponerCliente(colaAux.sacarCliente());
	}
	
	public String toString() {
		return "ColaA: " + this.getColaA() + " \nColaB: " + this.getColaB();
	}

}