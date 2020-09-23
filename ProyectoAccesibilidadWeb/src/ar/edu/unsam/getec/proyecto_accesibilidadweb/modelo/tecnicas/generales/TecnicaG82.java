package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG82 extends TecnicaGeneral {

	public TecnicaG82(CategoriaTecnica categoriaTecnica) {
		super(
				"G82",
				"Proporcionar una alternativa de texto que identifica el prop�sito del contenido no textual.",
				"El prop�sito de esta t�cnica es proporcionar informaci�n �til a trav�s de la alternativa textual, incluso si la funci�n completa del contenido no textual no puede proporcionarse. A veces, una alternativa textual no puede servir al mismo prop�sito que el contenido original no textual (por ejemplo, un applet destinado a desarrollar dos habilidades de orientaci�n r�pidas dimensionales y la coordinaci�n ojo-mano). En estos casos se utiliza esta t�cnica. Con esta t�cnica se proporciona una descripci�n de la finalidad del contenido no textual.", 
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el contenido no textual.
	 * 2. Reemplazarlo con el texto alternativo.
	 * 3. Verificar que el prop�sito del contenido no textual es claro - incluso si se pierde la funci�n.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualIdentificaPropositoContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual identifica el prop�sito del contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el prop�sito del contenido no textual es claro - incluso si se pierde la funci�n.",
				"Aseg�rate que el contenido no textual identifica el prop�sito del contenido no textual.");
		comprobacionAlternativaTextualIdentificaPropositoContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualIdentificaPropositoContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}