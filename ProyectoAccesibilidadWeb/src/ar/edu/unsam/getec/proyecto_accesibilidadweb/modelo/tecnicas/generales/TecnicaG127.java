package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG127 extends TecnicaGeneral {

	public TecnicaG127(CategoriaTecnica categoriaTecnica) {
		super(
				"G127", 
				"Identificar la relaci�n de una p�gina Web con una gran colecci�n de p�ginas Web.", 
				"El objetivo de esta t�cnica es que los usuarios puedan identificar la relaci�n entre la p�gina Web actual y otras p�ginas Web en la misma colecci�n (por ejemplo, en el mismo sitio web). En algunos casos esto se puede hacer mediante programaci�n, por ejemplo mediante el atributo rel del elemento link  en HTML. En otros casos, la informaci�n se proporciona mediante la inclusi�n de la informaci�n relevante en el t�tulo de la p�gina Web.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar si el t�tulo de la p�gina Web describe la relaci�n de la p�gina Web de la colecci�n a la que pertenece.
	 * 2. Verificar si la p�gina Web incluye metadatos que identifican la relaci�n de la p�gina Web de la colecci�n a la que pertenece.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTituloDescribeRelacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"T�tulo de la p�gina Web describe la relaci�n de la p�gina Web de la colecci�n a la que pertenece.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar si el t�tulo de la p�gina Web describe la relaci�n de la p�gina Web de la colecci�n a la que pertenece.",
				"Identifica la relaci�n de la p�gina web con un conjunto de p�ginas.");
		comprobacionTituloDescribeRelacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTituloDescribeRelacion);
		return resultadoEvaluacionTecnica;
	}

}