package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta3_1_Legible;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta3_2_Predecible;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta3_3_AyudaEntradaDatos;

public class Principio3_Comprensibilidad extends Principio {

	public Principio3_Comprensibilidad() {
		super(
				"3", 
				"Comprensibilidad.", 
				"Haga el contenido textual legible y comprensible.");
	}

	public List<Pauta> getPautasAAgregar() {
		List<Pauta> listaPautas = new LinkedList<Pauta>();
		listaPautas.add(new Pauta3_1_Legible());
		listaPautas.add(new Pauta3_2_Predecible()); 
		listaPautas.add(new Pauta3_3_AyudaEntradaDatos());
		return listaPautas;
	}	

}