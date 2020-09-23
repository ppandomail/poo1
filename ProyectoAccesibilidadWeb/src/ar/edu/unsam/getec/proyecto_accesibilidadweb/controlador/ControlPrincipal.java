package ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Constantes;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.vista.Index;

public class ControlPrincipal {
	
	public static void main(String[] args) throws IOException {
		try {
			Properties properties = new Properties();
			properties.load(new FileReader("resources/Config.properties"));
			Constantes.cargarVariables(properties);
		} catch (IOException e) {
			throw new IOException("No se pudo leer el archivo de Configuraciones: ".concat("Config.properties").concat(" : ").concat(e.getMessage()));
		}
		new Index();
	}

}