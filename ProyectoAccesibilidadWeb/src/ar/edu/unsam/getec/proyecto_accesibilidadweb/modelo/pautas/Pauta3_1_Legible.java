package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio3_1_1_IdiomaDeLaPagina;

public class Pauta3_1_Legible extends Pauta {

	public Pauta3_1_Legible() {
		super(
				"3.1", 
				"Legible.", 
				"Haga el contenido textual legible y comprensible.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio3_1_1_IdiomaDeLaPagina());
		return listaCriterios;
	}

}