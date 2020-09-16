package ar.edu.uno.poo1.proyecto_vehiculos;

public class DemoVehiculos {

	public static void main(String[] args) {
		Persona persona1 = new Persona(001, "A", "A");
		Persona persona2 = new Persona(010, "B", "B");
		Persona persona3 = new Persona(110, "C", "C");
		Persona persona4 = new Persona(100, "D", "D");
		Persona persona5 = new Persona(101, "E", "E");
		
		Motocicleta motocicleta1 = new Motocicleta(persona1, 1000);
		Motocicleta motocicleta2 = new Motocicleta(persona2, 2000, persona3);
		
		Autobus autobus = new Autobus(persona1, 3000);
		autobus.agregarPasajero(persona2);
		autobus.agregarPasajero(persona3);
		autobus.agregarPasajero(persona4);
		autobus.agregarPasajero(persona5);
	}

}