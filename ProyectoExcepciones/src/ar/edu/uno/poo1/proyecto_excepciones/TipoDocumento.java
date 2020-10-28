package ar.edu.uno.poo1.proyecto_excepciones;

public enum TipoDocumento {
	CI("cédula de identidad", ""),
	CC("cédula de ciudadanía", ""),
	TI("tarjeta de identidad", ""),
	TP("tarjeta pasaporte", ""),
	RC("registro civil", ""),
	CE("cédula de extranjería", ""),
	DNI("documento nacional de identidad", "\\d{8}"),
	DUI("documento único de identidad", ""),
	ID("identificación oficial", ""); 

	private String nombreTipoDocumento;
	private String patronFormatoNumerico;

	private TipoDocumento(String nombreTipoDocumento, String patronFormatoNumerico) {
		this.setNombreTipoDocumento(nombreTipoDocumento);
		this.setPatronFormatoNumerico(patronFormatoNumerico);
	}

	public String getNombreTipoDocumento() {
		return this.nombreTipoDocumento;
	}

	public void setNombreTipoDocumento(String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
	}

	public String getPatronFormatoNumerico() {
		return this.patronFormatoNumerico;
	}

	public void setPatronFormatoNumerico(String patronFormatoNumerico) {
		this.patronFormatoNumerico = patronFormatoNumerico;
	}

}