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
		
		Autobus autobus1 = new Autobus(persona1, 3000);
		Autobus autobus2 = new Autobus(persona2, 4000);
		autobus2.agregarPasajero(persona2);
		autobus2.agregarPasajero(persona3);
		autobus2.agregarPasajero(persona4);
		autobus2.agregarPasajero(persona5);
		
		Vehiculo [] vehiculos = new Vehiculo[] {motocicleta1, motocicleta2, autobus1, autobus2};
		for (Vehiculo vehiculo : vehiculos) {
			vehiculo.setChofer(new Persona(999));
			System.out.println(vehiculo);
		}
			
	}

}