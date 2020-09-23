package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG15 extends TecnicaGeneral {

	public TecnicaG15(CategoriaTecnica categoriaTecnica) {
		super(
				"G15",
				"El uso de una herramienta para asegurar que el contenido no viola el umbral de destello general o umbral de destello rojo.",
				"El prop�sito de las pruebas de violaciones de los umbrales generales y luz roja es la de permitir a las personas que tienen convulsiones fotosensibles para ver sitios web sin ning�n material que pueda causar una convulsi�n encuentro.  Las advertencias se pueden proporcionar, pero la gente puede pasar por alto ellos y los ni�os pueden no ser capaces de leer o entender. Con esta t�cnica todo el material se comprueba y si se viola el �flash� o los umbrales de destello rojo que o bien no se puso en el sitio o se modifica de forma que no viole los umbrales.", 
				categoriaTecnica);
	}

	/**
	 * Verificar para ver que el contenido no viola el flash general y / o umbral destello rojo.
	 * 1. Utilizar una herramienta para determinar que ni el flash ni el umbral general de destello rojo fueron excedidos. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDestellosPorDebajoUmbralLimite = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Destellos por debajo del umbral l�mite.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Utilizar una herramienta para determinar que ni el flash ni el umbral general de destello rojo fueron excedidos.",
				"Asegura que el contenido no viola el umbral del destello general o el umbral de destello rojo.");
		comprobacionDestellosPorDebajoUmbralLimite.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDestellosPorDebajoUmbralLimite);
		return resultadoEvaluacionTecnica;
	}

}