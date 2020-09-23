package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG107;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG200;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG201;

public class Criterio3_2_1_ConFoco extends Criterio {

	public Criterio3_2_1_ConFoco() {
		super(
				"3.2.1", 
				"Con foco.",
				"Recibir el foco por parte de cualquier componente no provoca ningún cambio de contexto.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG107(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG200(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaG201(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}
