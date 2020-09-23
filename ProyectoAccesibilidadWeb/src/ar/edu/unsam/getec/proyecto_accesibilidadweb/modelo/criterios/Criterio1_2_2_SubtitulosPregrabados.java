package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG87;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG93;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH95;

public class Criterio1_2_2_SubtitulosPregrabados extends Criterio {

	public Criterio1_2_2_SubtitulosPregrabados() {
		super(
				"1.2.2",
				"Subtítulos (pregrabados).",
				"Se proporcionan subtítulos para todo audio pregrabado presente en un contenido multimedia sincronizado, excepto cuando tal contenido es un contenido multimedia alternativo al texto y está claramente identificado como tal.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG93(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG87(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH95(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
