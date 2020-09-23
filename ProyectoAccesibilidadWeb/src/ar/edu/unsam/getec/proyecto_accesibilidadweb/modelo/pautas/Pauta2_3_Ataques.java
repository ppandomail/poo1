package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio2_3_1_TresDestellosOPorDebajoDelUmbral;

public class Pauta2_3_Ataques extends Pauta {

	public Pauta2_3_Ataques() {
		super(
				"2.3", 
				"Ataques.", 
				"No diseñe un contenido de manera que se sepa que puede causar ataques, espasmos o convulsiones.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_3_1_TresDestellosOPorDebajoDelUmbral());
		return listaCriterios;
	}

}