package ar.edu.uno.poo1.proyecto_carrito;

public class DemoCarrito {

	public static void main(String[] args) {
		Carrito carrito = new Carrito();
		carrito.agregarItemCarrito(new ItemCarrito(2,
			new Libro("123", "Harry Potter", Genero.INFANTIL, 100.0)));
		carrito.agregarItemCarrito(new ItemCarrito(1,
			new Libro("456", "El Principito", Genero.INFANTIL, 50.0)));
		carrito.agregarItemCarrito(new ItemCarrito(3, new Libro("789", "Los Juegos del Hambre",
			Genero.CIENCIA_FICCION, 150.0)));
		System.out.println(carrito.getPrecio());
		System.out.println(carrito.getCantidadLibrosPorGenero(Genero.INFANTIL));
		System.out.println(carrito.getCantidadLibrosPorGenero(Genero.CIENCIA_FICCION));
		System.out.println(carrito.getCantidadLibrosPorGenero(Genero.TERROR));
		System.out.println(carrito);
	}

}