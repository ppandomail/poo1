package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG13;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG201;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG80;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH32;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH84;

public class Criterio3_2_2_ConEntradaDeDatos extends Criterio {

	public Criterio3_2_2_ConEntradaDeDatos() {
		super(
				"3.2.2",
				"Con entrada de datos.",
				"Cambiar la configuración de cualquier componente de la interfaz de usuario no causa automáticamente ningún cambio de contexto a menos que el usuario haya sido advertido del comportamiento antes de emplear el componente.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG80(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG13(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG201(CategoriaTecnica.RECOMENDABLE));
		listaTecnicas.add(new TecnicaH32(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH84(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
