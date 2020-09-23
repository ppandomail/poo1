package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG202;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html.TecnicaH91;

public class Criterio2_1_1_Teclado extends Criterio {

	public Criterio2_1_1_Teclado() {
		super(
				"2.1.1",
				"Teclado.",
				"Toda funcionalidad del contenido es operable a través de una interfaz de teclado sin que exista un límite de tiempo específico para realizar las pulsaciones de las teclas, excepto para cuando la funcionalidad subyacente requiere una interacción del usuario para la que es relevante no sólo los puntos finales de su movimiento sino también la ruta que traza el mismo.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG202(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaH91(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}