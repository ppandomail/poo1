package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG11 extends TecnicaGeneral {

	public TecnicaG11(CategoriaTecnica categoriaTecnica) {
		super(
				"G11", 
				"Crear contenido que no destelle mas de 5 segundos.", 
				"El objetivo de esta t�cnica es minimizar las distracciones causadas por el destello del contenido y habilitar al usuario a reconcentrarse en otros contenidos en la pagina. El contenido destellante puede ser creado con una variedad de tecnolog�as, muchas de las cuales incluyen opciones de ciclos de contenido destellante o especificarlo la cantidad de tiempo que el contenido destellante es mostrado. Limitar el destello del contenido a 5 segundos minimiza las distracciones que el destello causa. Esto beneficiara a personas con determinados tipos de discapacidades de aprendizaje o personas con poca visi�n.", 
				categoriaTecnica);
	}

	/**
	 * 1. Hallar todos los elementos que destellen.
	 * 2. Por cada elemento que destelle, verificar si el intervalo entre el inicio y el final de los destellos es menor a 5 segundos.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDestellosPorDebajoUmbralLimite = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Destellos por debajo del umbral l�mite.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Por cada elemento que destelle, verificar si el intervalo entre el inicio y el final de los destellos es menor a 5 segundos.",
				"Crea contenido que parpadee menos de 5 segundos. No utilices el elemento \"blink\".");
		comprobacionDestellosPorDebajoUmbralLimite.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDestellosPorDebajoUmbralLimite);
		return resultadoEvaluacionTecnica;
	}

}