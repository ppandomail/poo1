package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio2_4_1_SaltarBloques;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio2_4_2_PaginaTitulada;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio2_4_3_OrdenFoco;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio2_4_4_PropositoDeUnVinculoEnSuContexto;

public class Pauta2_4_Navegable extends Pauta {

	public Pauta2_4_Navegable() {
		super(
				"2.4", 
				"Navegable.", 
				"Proporcione medios que sirvan de ayuda a los usuarios a la hora de navegar, localizar contenido y determinar dónde se encuentran.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_4_1_SaltarBloques());
		listaCriterios.add(new Criterio2_4_2_PaginaTitulada());
		listaCriterios.add(new Criterio2_4_3_OrdenFoco());
		listaCriterios.add(new Criterio2_4_4_PropositoDeUnVinculoEnSuContexto());
		return listaCriterios;
	}

}