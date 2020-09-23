package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css.TecnicaC6;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG1;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG123;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG124;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH64;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH69;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH70;

public class Criterio2_4_1_SaltarBloques extends Criterio {

	public Criterio2_4_1_SaltarBloques() {
		super(
				"2.4.1",
				"Saltar bloques.",
				"Existe un mecanismo que permite saltar bloques de contenido que se repiten en múltiples páginas web.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG1(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG123(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG124(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH69(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH70(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH64(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC6(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}
