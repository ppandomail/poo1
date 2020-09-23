package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio3_3_1_IdentificacionErrores;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio3_3_2_InstruccionesOEtiquetas;

public class Pauta3_3_AyudaEntradaDatos extends Pauta {

	public Pauta3_3_AyudaEntradaDatos() {
		super(
				"3.3", 
				"Ayuda a la entrada de datos.", 
				"Ayude a los usuarios a evitar y corregir errores.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio3_3_1_IdentificacionErrores());
		listaCriterios.add(new Criterio3_3_2_InstruccionesOEtiquetas());
		return listaCriterios;
	}

}