package ar.edu.uno.poo1.proyecto_administracion_archivo;

import java.io.File;
import java.io.FilenameFilter;

public class MiFiltro implements FilenameFilter {
	
	private String extension;
	
	public MiFiltro(String extension) {
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
		return name.endsWith(this.getExtension());
	}

}