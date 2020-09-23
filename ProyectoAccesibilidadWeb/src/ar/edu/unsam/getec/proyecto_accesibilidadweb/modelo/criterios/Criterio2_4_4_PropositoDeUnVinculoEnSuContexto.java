package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css.TecnicaC7;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG189;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG53;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG91;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH2;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH30;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH33;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH77;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH78;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH79;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH80;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH81;

public class Criterio2_4_4_PropositoDeUnVinculoEnSuContexto extends Criterio {

	public Criterio2_4_4_PropositoDeUnVinculoEnSuContexto() {
		super(
				"2.4.4",
				"Propósito de un vínculo (en su contexto).",
				"El propósito de cada vínculo puede determinarse con el texto del vínculo descontextualizado, o del texto del vínculo junto a su contexto programablemente determinable, excepto donde el propósito del vínculo puede ser ambiguo para los usuarios en general.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG91(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG189(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG53(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH30(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH33(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH77(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH78(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH79(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH81(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH2(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaH80(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC7(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
