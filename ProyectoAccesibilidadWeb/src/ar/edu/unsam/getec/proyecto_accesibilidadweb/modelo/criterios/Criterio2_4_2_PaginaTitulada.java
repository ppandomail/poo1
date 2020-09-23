package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG127;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG88;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH25;

public class Criterio2_4_2_PaginaTitulada extends Criterio {

	public Criterio2_4_2_PaginaTitulada() {
		super(
				"2.4.2", 
				"Página titulada.",
				"Las páginas web tienen títulos que describen su tema o propósito.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG88(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG127(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaH25(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
