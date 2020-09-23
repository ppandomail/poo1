package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG115 extends TecnicaGeneral {

	public TecnicaG115(CategoriaTecnica categoriaTecnica) {
		super(
				"G115", 
				"Usar elementos sem�nticos para marcar la estructura.", 
				"El objetivo de esta t�cnica es para marcar la estructura del contenido de la Web utilizando los elementos sem�nticos apropiados. En otras palabras, los elementos se utilizan seg�n su significado, no por la forma en que aparecen visualmente. El uso de los elementos sem�nticos apropiados se asegurar� de que la estructura est� disponible para el agente de usuario. Esto implica que indique expl�citamente el papel que tienen diferentes unidades para comprender el significado del contenido. La naturaleza de un fragmento de contenido como un p�rrafo, encabezado, texto subrayado, cuadros, etc. todo puede ser indicado de esta manera. En algunos casos, las relaciones entre las unidades de contenido tambi�n se deben indicar, por ejemplo, entre los t�tulos y subt�tulos, o entre las celdas de una tabla. El agente de usuario puede entonces hacer la perceptible estructura para el usuario, por ejemplo, utilizando una presentaci�n visual diferente para diferentes tipos de estructuras o mediante el uso de una voz o tono diferente en una presentaci�n auditiva. En HTML, por ejemplo, los elementos a nivel de frase, como EM, ABBR, y CITE a�ade informaci�n sem�ntica dentro de las sentencias, el marcado de texto para el �nfasis y la identificaci�n de las abreviaturas y las citas, respectivamente. MathML, un lenguaje de marcas dise�ado para mantener las distinciones importantes entre la estructura y la presentaci�n en matem�ticas, incluye especial marcado \"presentaci�n\" de los complejos notaciones usadas para representar las ideas matem�ticas, as� como el marcado \"contenido\" (sem�ntica) para las propias ideas matem�ticas.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar si hay partes del contenido que tienen una funci�n sem�ntica.
	 * 2. Para cada parte que tiene una funci�n sem�ntica, si el correspondiente marcado sem�ntico existe en la tecnolog�a, verificar que el contenido ha sido marcado usando el lenguaje de formato sem�ntico.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionElementosSemanticos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Uso de elementos sem�nticos para marcar la estructura", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada parte que tiene una funci�n sem�ntica, si el correspondiente marcado sem�ntico existe en la tecnolog�a, verificar que el contenido ha sido marcado usando el lenguaje de formato sem�ntico.",
				"Si la tecnolog�a ofrece una estructura sem�ntica para comunicar la informaci�n y las relaciones (por ejemplo, HTML), formatea la estructura y el texto con elementos sem�nticos.");
		comprobacionElementosSemanticos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionElementosSemanticos);
		return resultadoEvaluacionTecnica;
	}

}