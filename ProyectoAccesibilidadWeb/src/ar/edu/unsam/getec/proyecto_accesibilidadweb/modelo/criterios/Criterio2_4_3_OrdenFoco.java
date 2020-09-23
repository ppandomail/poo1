package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css.TecnicaC27;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG59;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH4;

public class Criterio2_4_3_OrdenFoco extends Criterio {

	public Criterio2_4_3_OrdenFoco() {
		super(
				"2.4.3",
				"Orden de foco.",
				"Si una página web puede navegarse secuencialmente y la secuencia de navegación afecta a su significado u operatividad, los componentes que pueden recibir el foco lo hacen en un orden que conserva íntegros su significado y operatividad",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG59(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH4(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC27(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
