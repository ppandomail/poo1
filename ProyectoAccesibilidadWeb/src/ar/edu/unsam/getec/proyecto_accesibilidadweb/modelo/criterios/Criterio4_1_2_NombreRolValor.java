package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG108;

public class Criterio4_1_2_NombreRolValor extends Criterio {

	public Criterio4_1_2_NombreRolValor() {
		super(
				"4.1.2",
				"Nombre, rol, valor.",
				"Para todo componente de interfaz de usuario (incluidos, pero no limitados a: elementos de formulario, vínculos y componentes generados por medio de scripts), el nombre y el rol pueden ser programablemente determinados, los estados, propiedades y valores que pueden ser establecidos por el usuario pueden ser programablemente establecidos, y los cambios en tales ítems se notifican a los agentes de usuario, incluidas las ayudas técnicas.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG108(CategoriaTecnica.SUFICIENTE));
		/*
		 * listaTecnicas.add(new TecnicaH91(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH44(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH64(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH65(CategoriaTecnica.SUFICIENTE));
		 * listaTecnicas.add(new TecnicaH88(CategoriaTecnica.SUFICIENTE));
		 */
		return listaTecnicas;
	}


}
