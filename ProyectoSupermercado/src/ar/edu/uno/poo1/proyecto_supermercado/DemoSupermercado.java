package ar.edu.uno.poo1.proyecto_supermercado;

public class DemoSupermercado {

	public static void main(String[] args) {
		System.out.println("DIA");
		Supermercado dia = new Supermercado();
		dia.agregarClientesColaA(10);
		System.out.println(dia);
		dia.abrirColaB(15);
		System.out.println(dia);
		System.out.println();
		
		System.out.println("COTO");
		Supermercado coto = new Supermercado();
		coto.agregarClienteColaA(new Cliente(1, 9));
		coto.agregarClienteColaA(new Cliente(2, 3));
		coto.agregarClienteColaA(new Cliente(3, 7));
		System.out.println(coto);
		coto.abrirColaB(5);
		System.out.println(coto);		
	}

}
