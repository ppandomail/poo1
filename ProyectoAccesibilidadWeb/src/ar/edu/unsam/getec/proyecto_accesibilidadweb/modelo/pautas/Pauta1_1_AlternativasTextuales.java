package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio1_1_1_ContenidoNoTextual;

public class Pauta1_1_AlternativasTextuales extends Pauta {

	public Pauta1_1_AlternativasTextuales() {
		super(
				"1.1", 
				"Alternativas textuales.", 
				"Proporcione alternativas textuales para todo contenido no textual, de manera que pueda modificarse para ajustarse a las necesidades de las personas, como por ejemplo en una letra mayor, braille, voz, símbolos o un lenguaje más simple.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio1_1_1_ContenidoNoTextual());
		return listaCriterios;
	}

}
