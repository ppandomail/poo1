package ar.edu.uno.poo1.proyecto_administracion_archivo;

import java.io.File;
import java.io.FilenameFilter;

public class OtroFiltro implements FilenameFilter {
	
	private String expreg;
	
	public OtroFiltro(String expreg) {
		this.setExpreg(expreg);
	}
	
	public String getExpreg() {
		return this.expreg;
	}

	public void setExpreg(String expreg) {
		this.expreg = expreg;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.matches(this.getExpreg());
	}

}