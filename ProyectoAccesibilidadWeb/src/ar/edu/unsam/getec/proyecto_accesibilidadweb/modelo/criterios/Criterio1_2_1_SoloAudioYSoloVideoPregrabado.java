package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG158;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG159;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG166;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH96;

public class Criterio1_2_1_SoloAudioYSoloVideoPregrabado extends Criterio {

	public Criterio1_2_1_SoloAudioYSoloVideoPregrabado() {
		super(
				"1.2.1",
				"Sólo audio y sólo vídeo (pregrabado).",
				"Para contenidos pregrabados que consisten en sólo audio y sólo vídeo, se cumple lo siguiente, excepto para cuando el audio o el vídeo es un contenido multimedia alternativo al texto y está claramente identificado como tal.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG158(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG159(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG166(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH96(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}

}
