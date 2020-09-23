package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG139;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG199;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG83;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG84;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG85;

public class Criterio3_3_1_IdentificacionErrores extends Criterio {

	public Criterio3_3_1_IdentificacionErrores() {
		super(
				"3.3.1",
				"Identificación de errores.",
				"Si se detecta automáticamente un error de entrada de datos, se identifica el ítem erróneo y el error se describe al usuario por medio de texto.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG83(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG84(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG85(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG139(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaG199(CategoriaTecnica.RECOMENDABLE));
		return listaTecnicas;
	}


}
