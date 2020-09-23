package ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Contexto;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ContextoClaves;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Utilidades;

public class GestorValidacionURL {
	
	public static ControlInformacion validarURL(String texto) {
		Parseador parseador = null;
		if (texto.equals("") || texto.equals("http://"))
			return new ControlInformacion(ControlInformacion.ERROR, "Complete el campo URL.", "", null);
		texto = Utilidades.completarURL(texto);
		try {
			parseador = new Parseador(new URL(texto));
		} catch (MalformedURLException e) {
			return new ControlInformacion(ControlInformacion.ERROR, "La URL esta mal formada.", "", e);
		} catch (IOException e) {
			return new ControlInformacion(ControlInformacion.ERROR, "La URL es inexistente.", "", e);
		}
		Contexto.set(ContextoClaves.PARSEADOR, parseador);
		return new ControlInformacion();
	}

}
