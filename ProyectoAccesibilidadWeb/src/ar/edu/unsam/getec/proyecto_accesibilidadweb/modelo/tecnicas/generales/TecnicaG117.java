package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG117 extends TecnicaGeneral {

	public TecnicaG117(CategoriaTecnica categoriaTecnica) {
		super(
				"G117",
				"El uso de texto para transmitir la informaci�n que se transmite por las variaciones en la presentaci�n del texto.",
				"El objetivo de esta t�cnica es asegurar que la informaci�n transmitida a trav�s de variaciones en el formato del texto se transmita en el texto tambi�n. Cuando la apariencia visual del texto se var�a para transmitir informaci�n, el estado de la informaci�n est� de forma expl�cita en el texto. Las variaciones en la apariencia visual se pueden hacer por los cambios de tipo de letra, tama�o de fuente, subrayado, tachado y varios atributos de otro texto. Cuando estos tipos de variaciones transmiten informaci�n, la informaci�n tiene que estar disponible en el contenido a trav�s de texto en otro lugar. Incluyendo secciones adicionales en el documento o una descripci�n en l�nea donde la variaci�n en la presentaci�n del texto se produce, puede ser usado para transmitir la informaci�n.", 
				categoriaTecnica);
	}

	/**
	 * 1. Encontrar objetos donde se utilizan las variaciones en la presentaci�n del texto para transmitir informaci�n.
	 * 2. Para aquellos art�culos, verificar para determinar si la informaci�n transmitida visualmente tambi�n se indica expl�citamente en el texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVariacionesFormatoTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Variaciones en el formato del texto se transmita en el texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Encontrar objetos donde se utilizan las variaciones en la presentaci�n del texto para transmitir informaci�n y verificar para determinar si la informaci�n transmitida visualmente tambi�n se indica expl�citamente en el texto.",
				"Si la tecnolog�a ofrece una estructura sem�ntica para comunicar la informaci�n y las relaciones (por ejemplo, HTML), comunica con texto la informaci�n que es transmitida por las variaciones en la presentaci�n de texto.");
		comprobacionVariacionesFormatoTexto.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVariacionesFormatoTexto);
		return resultadoEvaluacionTecnica;
	}

}