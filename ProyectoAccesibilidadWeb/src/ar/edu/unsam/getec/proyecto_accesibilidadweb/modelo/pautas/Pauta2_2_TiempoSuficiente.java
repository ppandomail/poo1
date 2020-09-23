package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio2_2_1_LimiteTiempoAjustable;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio2_2_2_PausarDetenerOcultar;

public class Pauta2_2_TiempoSuficiente extends Pauta {

	public Pauta2_2_TiempoSuficiente() {
		super(
				"2.2", 
				"Tiempo suficiente.", 
				"Proporcione a los usuarios el tiempo suficiente para leer y usar un contenido.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_2_1_LimiteTiempoAjustable());
		listaCriterios.add(new Criterio2_2_2_PausarDetenerOcultar());
		return listaCriterios;
	}

}