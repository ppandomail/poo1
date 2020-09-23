package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css.TecnicaC18;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css.TecnicaC9;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.*;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.*;

public class Criterio1_1_1_ContenidoNoTextual extends Criterio {

	public Criterio1_1_1_ContenidoNoTextual() {
		super(
				"1.1.1",
				"Contenido no textual.",
				"Todo contenido no textual que se presenta al usuario cuenta con una alternativa textual que sirve para un propósito equivalente.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG94(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG196(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG95(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG73(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG74(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG92(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG82(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG68(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG100(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG143(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG144(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH2(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH24(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH35(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH37(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH53(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH86(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH45(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH30(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH36(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH44(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH65(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH67(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH46(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaC9(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaC18(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}