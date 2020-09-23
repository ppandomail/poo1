package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH57;

public class Criterio3_1_1_IdiomaDeLaPagina extends Criterio {

	public Criterio3_1_1_IdiomaDeLaPagina() {
		super(
				"3.1.1", 
				"Idioma de la página.",
				"El idioma por defecto de cada página web puede ser programablemente determinado.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaH57(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
