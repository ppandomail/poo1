package ar.edu.uno.poo1.proyecto_archivos;

import java.io.File;
import java.io.FilenameFilter;

public class FiltroNombres implements FilenameFilter {
	
	private String extension;
	
	public FiltroNombres(String extension) {
		this.setExtension(extension);
	}
	
	public String getExtension() {
		return this.extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		if (this.getExtension().equals("*"))
			return Boolean.TRUE;
		return name.endsWith(this.getExtension());
	}
	
}