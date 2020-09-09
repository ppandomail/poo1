package ar.edu.uno.poo1.proyecto_compilador;

public enum ErrorCompilacion {
	
	VACIO(100, "El programa fuente se encuentra vacio."),
	SIN_INICIO(200, "El programa fuente no inicia con la sentencia C."),
	SIN_FIN(300, "El programa fuente no termina con la sentencia F."),
	SIMBOLOS_DESCONOCIDOS(400, "Símbolos desconocidos.");
	
	private int codigoError;
	private String descripcionError;
	
	private ErrorCompilacion(int codigoError, String descripcionError) {
		this.setCodigoError(codigoError);
		this.setDescripcionError(descripcionError);
	}

	public int getCodigoError() {
		return this.codigoError;
	}

	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}

	public String getDescripcionError() {
		return this.descripcionError;
	}

	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	
	public String toString() {
		return this.getCodigoError() + " - " + this.getDescripcionError();
	}
		
}