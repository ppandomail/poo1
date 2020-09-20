package ar.edu.uno.poo1.proyecto_empleados;

public class DemoEmpleados {

	public static void main(String[] args) {
		Empresa empresa = new Empresa("20-24862699-3", "Universidad Nacional del Oeste");
		empresa.agregarEmpleado(new EmpleadoPlantaTemporaria(80, Boolean.TRUE, 0));
		empresa.agregarEmpleado(new EmpleadoPlantaPermanente(80, Boolean.TRUE, 2, 6));
		empresa.agregarEmpleado(new EmpleadoPlantaPermanente(160, Boolean.FALSE, 0, 4));
		empresa.agregarEmpleado(new EmpleadoGerente(160, Boolean.TRUE, 1, 10));
		empresa.mostrarEnConsolaLiquidacion();
	}

}