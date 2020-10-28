package ar.edu.uno.poo1.proyecto_excepciones;

public class Documento {
	
	private TipoDocumento tipoDocumento;
	private Long numeroDocumento;
	
	public Documento(TipoDocumento tipoDocumento, Long numeroDocumento) throws FormatoNumeroDocumentoException {
		if (numeroDocumento == null) 
			throw new NullPointerException("Numero de Documento es obligatorio");
		if (!numeroDocumento.toString().matches(tipoDocumento.getPatronFormatoNumerico()))
			throw new FormatoNumeroDocumentoException();
		this.setTipoDocumento(tipoDocumento);
		this.setNumeroDocumento(numeroDocumento);	
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	private void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getNumeroDocumento() {
		return this.numeroDocumento;
	}

	private void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
}