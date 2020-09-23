package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta4_1_Compatible;

public class Principio4_Robustez extends Principio {

	public Principio4_Robustez() {
		super(
				"4", 
				"Robustez.", 
				"El contenido debe ser lo suficientemente robusto como para confiarse en su interpretación por parte de una amplia variedad de aplicaciones de usuario, incluidas las ayudas técnicas.");
	}

	public List<Pauta> getPautasAAgregar() {
		List<Pauta> listaPautas = new LinkedList<Pauta>();
		listaPautas.add(new Pauta4_1_Compatible());
		return listaPautas;
	}

}