package ar.edu.uno.poo1.proyecto_empleados;

public class EmpleadoPlantaPermanente extends Empleado {
	
	private static final Double IMPORTE_POR_HORA = 30.0;
	private static final Double IMPORTE_POR_AÑO_ANTIGUEDAD = 10.0;
	
	private Integer cantidadAñosAntiguedad;
	
	public EmpleadoPlantaPermanente(Integer cantidadHorasTrabajadas, Boolean estaCasado,
			Integer cantidadHijos, Integer cantidadAñosAntiguedad) {
		super(cantidadHorasTrabajadas, estaCasado, cantidadHijos);
		this.setCantidadAñosAntiguedad(cantidadAñosAntiguedad);
	}
	
	public Integer getCantidadAñosAntiguedad() {
		return this.cantidadAñosAntiguedad;
	}
	
	public void setCantidadAñosAntiguedad(Integer cantidadAñosAntiguedad) {
		this.cantidadAñosAntiguedad = cantidadAñosAntiguedad;
	}
	
	public Double getSalarioHorasTrabajadas() {
		return this.getCantidadHorasTrabajadas() * EmpleadoPlantaPermanente.IMPORTE_POR_HORA;
	}
	
	public Double getSalarioAntiguedad() {
		return this.getCantidadAñosAntiguedad() * EmpleadoPlantaPermanente.IMPORTE_POR_AÑO_ANTIGUEDAD;
	}
	
	public String toString() {
		return super.toString().concat("\t\t").concat(String.valueOf(this.getCantidadAñosAntiguedad()));
	}
	
}