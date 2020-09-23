package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio2_1_1_Teclado;

public class Pauta2_1_AccesibleATravesDelTeclado extends Pauta {

	public Pauta2_1_AccesibleATravesDelTeclado() {
		super(
				"2.1", 
				"Accesible a través del teclado.", 
				"Haga que toda funcionalidad esté disponible a través del teclado.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio2_1_1_Teclado());
		/* listaCriterios.add(new Criterio2_1_2_SinTrampaDeTeclado()); */
		return listaCriterios;
	}

}
