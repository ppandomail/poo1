package ar.edu.uno.poo1.proyecto_empleados;

public abstract class Empleado {
	
	private static final Double IMPORTE_POR_HIJO = 20.0;
	private static final Double IMPORTE_POR_CASADO = 10.0;
	
	private Integer cantidadHorasTrabajadas;
	private Boolean estaCasado;
	private Integer cantidadHijos;
	
	public Empleado(Integer cantidadHorasTrabajadas, Boolean estaCasado, Integer cantidadHijos) {
		this.setCantidadHorasTrabajadas(cantidadHorasTrabajadas);
		this.setEstaCasado(estaCasado);
		this.setCantidadHijos(cantidadHijos);
	}
	
	public abstract Double getSalarioHorasTrabajadas();
	public abstract Double getSalarioAntiguedad();
	
	public Integer getCantidadHorasTrabajadas() {
		return this.cantidadHorasTrabajadas;
	}
	
	public void setCantidadHorasTrabajadas(Integer cantidadHorasTrabajadas) {
		this.cantidadHorasTrabajadas = cantidadHorasTrabajadas;
	}
	
	public Boolean getEstaCasado() {
		return this.estaCasado;
	}
	
	public void setEstaCasado(Boolean estaCasado) {
		this.estaCasado = estaCasado;
	}
	
	public Integer getCantidadHijos() {
		return this.cantidadHijos;
	}
	
	public void setCantidadHijos(Integer cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	
	public Double getSalarioFamiliar() {
		return this.getCantidadHijos() * Empleado.IMPORTE_POR_HIJO
				+ ((this.estaCasado) ? Empleado.IMPORTE_POR_CASADO : 0.0);
	}
	
	public Double getSueldo() {
		return this.getSalarioHorasTrabajadas() + this.getSalarioAntiguedad() + this.getSalarioFamiliar();
	}
	
	public String toString() {
		return "\t\t".concat(String.valueOf(this.getCantidadHorasTrabajadas())).concat("\t\t\t")
			.concat(this.getEstaCasado() ? "SI" : "NO").concat("\t\t")
			.concat(String.valueOf(this.getCantidadHijos()));
	}
	
}