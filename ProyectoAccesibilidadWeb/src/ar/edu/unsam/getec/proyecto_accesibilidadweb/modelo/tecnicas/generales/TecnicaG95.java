package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG95 extends TecnicaGeneral {

	public TecnicaG95(CategoriaTecnica categoriaTecnica) {
		super(
				"G95",
				"Proporcionar alternativas de texto cortos que proporcionan una breve descripci�n del contenido no textual.",
				"Esta tecnica es usada cuando el texto necesita servir el mismo proposito y presentar la misma informacion que el contenido no textual original es muy largo o cuando este objetivo no puede lograrse con el texto solo. En ese caso esta tecnica es usada para proporcionar una alternativa textual corta que brevemente sirve el mismo proposito y presenta la misma informacion que el contenido no textual original. Al decidir que texto para incluir en la alternativa textual, es buena idea tener en cuenta las siguientes preguntas: �Por que esta este contenido no textual aqui? �Que informacion esta presentando? Que proposito tiene que cumplir? Si no se podia utilizar contenido no textual, �que palabras tendria que utilizar para transmitir la misma funcion y/o informacion?.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar la presencia de una alternativa textual corta que proporciona una breve descripci�n del contenido no textual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualCortaDescribeContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual corta describe contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la presencia de una alternativa textual corta que proporciona una breve descripci�n del contenido no textual.",
				"Aseg�rate que la alternativa textual corta proporciona una breve descripci�n del contenido no textual.");
		comprobacionAlternativaTextualCortaDescribeContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualCortaDescribeContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}