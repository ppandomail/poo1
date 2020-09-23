package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

public enum NivelAccesibilidad {
	
	A ("A"),
	AA ("AA"),
	AAA ("AAA");

	private String representacion;

	private NivelAccesibilidad(String representacion) {
		this.setRepresentacion(representacion);
	}

	public String getRepresentacion() {
		return this.representacion;
	}

	public void setRepresentacion(String representacion) {
		this.representacion = representacion;
	}

}