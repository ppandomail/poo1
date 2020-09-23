package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG196 extends TecnicaGeneral {

	public TecnicaG196(CategoriaTecnica categoriaTecnica) {
		super(
				"G196",
				"El uso de una alternativa de texto en un elemento dentro de un grupo de im�genes que describe todos los elementos en el grupo.",
				"El objetivo de esta tecnica es evitar la duplicacion innecesaria que ocurre cuando una agrupacion de contenido no textual adyacente es usado para presentar informacion o funcionalidad. En algunos casos, las paginas presentaran un grupo de paginas para transmitir la informacion. Cuando son presentadas juntas o en una combinacion especifica de estas agrupaciones pueden transmitir diferentes tipos de informacion. Por ejemplo, dos imagenes de una estrella donde uno se presenta en blanco y negro y el otro es de color se pueden utilizar en una combinacion para representar una puntuacion de usuarios. Por ejemplo, tres estrellas llenas seguidas de dos estrellas sin relleno podria representar una calificacion de tres de cada cinco estrellas. Para utilizar esta tecnica, un autor proporciona una alternativa textual que sirve como equivalente para todo el grupo y lo asocia con un elemento en el grupo. Los otros items en el grupo son marcados de una manera que pueden ser ignorados por asistencias tecnologicas. De esta manera, el usuario es capaz de identificar el proposito del grupo y puede evitar la duplicacion o la confusion que puede producirse si se habia proporcionado una alternativa textual para cada elemento en el grupo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que un elemento en el grupo incluye un texto alternativo que sirve para el prop�sito equivalente para todo el grupo.
	 * 2. Verificar que los otros elementos del grupo est�n marcados de una manera que puede ser ignorado por las asistencias tecnologicas.
	 * 3. Verificar que los elementos marcados en una forma que puede ser ignorado por las asistencias tecnologicas son adyacentes al elemento que contiene el texto alternativo para el grupo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualDescribeElementosEnElGrupo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual describe todos los elementos en el grupo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que un elemento en el grupo incluye un texto alternativo que sirve para el prop�sito equivalente para todo el grupo.",
				"Describe textualmente un grupo de im�genes relacionadas entre s�.");
		comprobacionAlternativaTextualDescribeElementosEnElGrupo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualDescribeElementosEnElGrupo);
		return resultadoEvaluacionTecnica;
	}

}