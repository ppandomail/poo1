package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio1_3_1_InformacionYRelaciones;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio1_3_2_SecuenciaSignificativa;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio1_3_3_CaracteristicasSensoriales;

public class Pauta1_3_Adaptabilidad extends Pauta {

	public Pauta1_3_Adaptabilidad() {
		super(
				"1.3", 
				"Adaptabilidad.", 
				"Cree contenidos que puedan presentarse de diversas maneras (como por ejemplo una composición más simple) sin perder la información ni su estructura.");
	}

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio1_3_1_InformacionYRelaciones());
		listaCriterios.add(new Criterio1_3_2_SecuenciaSignificativa());
		listaCriterios.add(new Criterio1_3_3_CaracteristicasSensoriales());
		return listaCriterios;
	}

}