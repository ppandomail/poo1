package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css.TecnicaC15;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG111;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG14;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG182;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG183;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG205;

public class Criterio1_4_1_UsoColor extends Criterio {

	public Criterio1_4_1_UsoColor() {
		super(
				"1.4.1",
				"Uso del color.",
				"El color no se emplea como el único medio visual para transmitir una información, indicar una acción, provocar una respuesta o distinguir visualmente un elemento.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG14(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG205(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG182(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG183(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG111(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC15(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}
