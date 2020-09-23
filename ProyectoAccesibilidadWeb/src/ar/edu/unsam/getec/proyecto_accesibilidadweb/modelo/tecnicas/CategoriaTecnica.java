package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas;

public enum CategoriaTecnica {
	
	SUFICIENTE(0, "S", "Suficiente"), 
	RECOMENDABLE(1, "R", "Recomendable"), 
	FALLO_COMUN(2, "F", "Fallo común");

	private Integer representacionNumerica;
	private String representacionSimbolica;
	private String representacionString;

	private CategoriaTecnica(Integer representacionNumerica, String representacionSimbolica, String representacionString) {
		this.setRepresentacionNumerica(representacionNumerica);
		this.setRepresentacionSimbolica(representacionSimbolica);
		this.setRepresentacionString(representacionString);
	}

	public Integer getRepresentacionNumerica() {
		return this.representacionNumerica;
	}

	public void setRepresentacionNumerica(Integer representacionNumerica) {
		this.representacionNumerica = representacionNumerica;
	}

	public String getRepresentacionSimbolica() {
		return this.representacionSimbolica;
	}

	public void setRepresentacionSimbolica(String representacionSimbolica) {
		this.representacionSimbolica = representacionSimbolica;
	}

	public String getRepresentacionString() {
		return this.representacionString;
	}

	public void setRepresentacionString(String representacionString) {
		this.representacionString = representacionString;
	}

}