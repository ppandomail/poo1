package ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador;

public enum TipoValidacion {
	
	PAGINA_WEB(1, "(Página Web)", "Seleccione una URL."),
	ARCHIVO(2, "(Archivo)", "Seleccione un archivo."),
	CODIGO(3, "(Código HTML)", "Complete el campo código HTML.");

	private Integer representacionNumerica;
	private String representacionString;
	private String campoAValidar;

	private TipoValidacion(Integer representacionNumerica, String representacionString, String campoAValidar) {
		this.setRepresentacionNumerica(representacionNumerica);
		this.setRepresentacionString(representacionString);
		this.setCampoAValidar(campoAValidar);
	}

	public Integer getRepresentacionNumerica() {
		return this.representacionNumerica;
	}

	public void setRepresentacionNumerica(Integer representacionNumerica) {
		this.representacionNumerica = representacionNumerica;
	}

	public String getRepresentacionString() {
		return this.representacionString;
	}

	public void setRepresentacionString(String representacionString) {
		this.representacionString = representacionString;
	}

	public String getCampoAValidar() {
		return this.campoAValidar;
	}

	public void setCampoAValidar(String campoAValidar) {
		this.campoAValidar = campoAValidar;
	}

}