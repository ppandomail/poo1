package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG11;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG152;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG186;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG187;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG191;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales.TecnicaG4;

public class Criterio2_2_2_PausarDetenerOcultar extends Criterio {

	public Criterio2_2_2_PausarDetenerOcultar() {
		super(
				"2.2.2",
				"Pausar, detener, ocultar.",
				"Para cualquier información que se mueva, parpadee, se desplace o se actualice automáticamente, se cumplen todos los puntos siguientes: Movimiento, parpadeo, desplazamiento: Para cualquier información que se mueva, parpadee o se desplace, y que (1) comience automáticamente, (2) dure más de cinco segundos, y (3) se presente paralelamente a otro contenido, existe un mecanismo que permite al usuario pausar, detener u ocultar la información, a menos que ese movimiento, parpadeo o desplazamiento sea esencial para la actividad, y Actualización automática: Para cualquier información que (1) comience automáticamente y (2) se presente paralelamente a otro contenido, existe un mecanismo que permite al usuario pausar, detener u ocultar la información, o controlar la frecuencia de la actualización, a menos que la actualización automática sea esencial para la actividad.",
				NivelAccesibilidad.A);
	}

	public List<Tecnica> getTecnicasAAgregar() {
		List<Tecnica> listaTecnicas = new LinkedList<Tecnica>();
		listaTecnicas.add(new TecnicaG4(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG11(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG187(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG152(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG186(CategoriaTecnica.SUFICIENTE));
		listaTecnicas.add(new TecnicaG191(CategoriaTecnica.SUFICIENTE));
		return listaTecnicas;
	}

}
