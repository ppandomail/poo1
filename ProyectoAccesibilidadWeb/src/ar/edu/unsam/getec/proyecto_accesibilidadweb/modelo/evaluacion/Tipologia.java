package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion;

public enum Tipologia {
	
	NO_DEFINIDA(0, "No Definida"), 
	IMAGENES(1, "Imágenes"), 
	FORMULARIOS(2, "Formularios"), 
	ESTRUCTURA_Y_SEMANTICA(3, "Semántica"), 
	PRESENTACION(4, "Presentación"), 
	PAGINA_WEB(5, "Página web"), 
	NAVEGACION(6, "Navegación"), 
	SCRIPTS(7, "Scripts"), 
	APPLETS(8, "Applets"), 
	TABLAS(9, "Tablas"), 
	LISTAS(10, "Listas");

	private Integer representacionNumerica;
	private String representacionString;

	private Tipologia(Integer representacionNumerica, String representacionString) {
		this.setRepresentacionNumerica(representacionNumerica);
		this.setRepresentacionString(representacionString);
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

}