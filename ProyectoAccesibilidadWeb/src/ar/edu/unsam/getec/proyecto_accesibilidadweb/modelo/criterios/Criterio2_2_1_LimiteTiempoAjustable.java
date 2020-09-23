package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG133;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG180;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG198;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG4;

public class Criterio2_2_1_LimiteTiempoAjustable extends Criterio {

	public Criterio2_2_1_LimiteTiempoAjustable() {
		super(
				"2.2.1",
				"Límite de tiempo ajustable.",
				"Para cada límite de tiempo que se establece en el contenido, se cumple al menos uno de los siguientes casos: Desactivar: Al usuario se le permite desactivar el límite de tiempo antes de encontrarse con él, o Ajustar: Al usuario se le permite ajustar el límite de tiempo antes de encontrarse con él, hasta un rango de al menos diez veces la duración por defecto o Extender: Al usuario se le avisa antes de que el límite expire con un margen de al menos 20 segundos y se le permite extender ese mismo límite por medio de alguna acción simple (por ejemplo, 'pulse la barra espaciadora'), y además se le permite repetir la acción al menos diez veces, o Excepción de tiempo real: El límite de tiempo es un requisito de un evento en tiempo real (por ejemplo, una subasta), y no es posible ninguna alternativa a ese límite, o Excepción esencial: El límite de tiempo es esencial y su extensión invalidaría la actividad, o Excepción de 20 horas: El límite de tiempo supera las 20 horas.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG133(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG198(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG180(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG4(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
