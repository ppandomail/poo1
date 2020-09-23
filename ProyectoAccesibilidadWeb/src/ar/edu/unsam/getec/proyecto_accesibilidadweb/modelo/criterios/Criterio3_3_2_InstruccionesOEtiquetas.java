package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.uade.tic.tesis.arweb.modelo.tecnicas.html.TecnicaH90;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG13;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG131;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG162;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG167;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG184;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG83;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG89;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH44;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH65;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH71;

public class Criterio3_3_2_InstruccionesOEtiquetas extends Criterio {

	public Criterio3_3_2_InstruccionesOEtiquetas() {
		super(
				"3.3.2",
				"Instrucciones o etiquetas.",
				"Se proporcionan etiquetas o instrucciones cuando el contenido requiere entrada de datos por parte del usuario.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG131(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG89(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG184(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG162(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG83(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG167(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG13(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaH90(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH44(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH71(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH65(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
