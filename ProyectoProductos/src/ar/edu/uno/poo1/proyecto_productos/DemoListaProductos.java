package ar.edu.uno.poo1.proyecto_productos;

public class DemoListaProductos {

	public static void main(String[] args) {
		ListaProductos listaProductos = new ListaProductos();
		listaProductos.agregarProducto(new Producto(1, "MacBook", 300000.0, 42));
		listaProductos.agregarProducto(new Producto(2, "IPAD", 100000.0, 21));
		listaProductos.agregarProducto(new Producto(3, "IPHONE", 80000.0, 53));
		listaProductos.agregarProducto(new Producto(4, "PEN", 15000.0, 7));
		listaProductos.agregarProducto(new Producto(5, "KEY", 18000.0, 89));
		System.out.println(listaProductos);
		System.out.println(listaProductos.getKesimo(2));
		System.out.println();
		listaProductos.incrementarImporte(new Producto(2), 10);
		System.out.println(listaProductos);
		System.out.println(listaProductos.getStock(new Producto(2)));
		System.out.println(listaProductos.getStock(new Producto(9)));
		System.out.println();
		System.out.println(listaProductos.getProductosStockInferiorA(50));
		System.out.println(listaProductos.getProductosStockSuperiorIgualA(50));			
	}

}