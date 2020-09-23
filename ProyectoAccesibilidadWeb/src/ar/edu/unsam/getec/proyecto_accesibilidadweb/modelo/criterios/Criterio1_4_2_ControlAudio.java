package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG170;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG171;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG60;

public class Criterio1_4_2_ControlAudio extends Criterio {

	public Criterio1_4_2_ControlAudio() {
		super(
				"1.4.2",
				"Control de audio.",
				"Si cualquier audio se reproduce automáticamente en una página web durante más de tres segundos, se proporciona ya sea un mecanismo que permita pausar o detener el audio, o un mecanismo que permita controlar el volumen del audio de manera independiente al del resto del sistema.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG60(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG170(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG171(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
