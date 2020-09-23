package ar.edu.unsam.getec.proyecto_accesibilidadweb.util;

import java.util.HashMap;

public class Contexto {
	
private static final HashMap<String, Object> MAPA = new HashMap<String, Object>();
	
	private Contexto() {
		
	}
	
	public static Object get(String clave) {
		return Contexto.MAPA.get(clave);
	}
	
	public static void set(String clave, Object valor) {
		Contexto.MAPA.put(clave, valor);
	}
	
	public static String getString(String clave) {
		Object objeto = Contexto.get(clave);
		return (objeto != null) ? objeto.toString() : null;
	}

}
