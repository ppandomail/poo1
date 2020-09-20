package ar.edu.uno.poo1.proyecto_empleados;

public class EmpleadoGerente extends EmpleadoPlantaPermanente {
	
	private static final Double IMPORTE_POR_HORA = 40.0;
	private static final Double IMPORTE_POR_AÑO_ANTIGUEDAD = 15.0;
	
	public EmpleadoGerente(Integer cantidadHorasTrabajadas, Boolean estaCasado, Integer cantidadHijos,
			Integer cantidadAñosTrabajados) {
		super(cantidadHorasTrabajadas, estaCasado, cantidadHijos, cantidadAñosTrabajados);
	}
	
	public Double getSalarioHorasTrabajadas() {
		return this.getCantidadHorasTrabajadas() * EmpleadoGerente.IMPORTE_POR_HORA;
	}
	
	public Double getSalarioAntiguedad() {
		return this.getCantidadAñosAntiguedad() * EmpleadoGerente.IMPORTE_POR_AÑO_ANTIGUEDAD;
	}
	
}