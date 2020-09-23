package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG134;

public class Criterio4_1_1_Interpretacion extends Criterio {

	public Criterio4_1_1_Interpretacion() {
		super(
				"4.1.1",
				"Interpretación.",
				"Para contenido que se haya implementado empleando un lenguaje de marcado, los elementos cuentan con etiquetas completas de cierre y apertura, se han anidado correctamente, no contienen atributos duplicados y cualquier ID es único, excepto donde la especificación permita excepciones.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG134(CategoriaTecnica.SUFICIENTE));
		/*
		 * listaTecnicas.add(new TecnicaG192(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH88(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH74(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH93(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH94(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH75(CategoriaTecnica.SUFICIENTE));
		 */
		return listaTecnicas;
	}

}
