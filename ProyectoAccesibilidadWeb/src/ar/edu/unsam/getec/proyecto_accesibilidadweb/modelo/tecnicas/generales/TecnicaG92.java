package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG92 extends TecnicaGeneral {

	public TecnicaG92(CategoriaTecnica categoriaTecnica) {
		super(
				"G92",
				"Proporcionar descripci�n larga de contenido no textual que sirve al mismo prop�sito y presenta la misma informaci�n.",
				"El objetivo de esta t�cnica es proporcionar una alternativa textual larga que sirve al mismo prop�sito y presenta la misma informaci�n que el contenido no textual original cuando una alternativa textual corta no es suficiente. Combinada con la alternativa textual corta, la descripci�n larga debe ser capaz de sustituir el contenido no textual. La alternativa textual corta identifica el contenido no textual; la alternativa textual larga proporciona la informaci�n. Si el contenido no textual fuera eliminado de la p�gina y se sustituyese por las descripciones cortas y largas, la p�gina todav�a proporcionar�a la misma funci�n y la informaci�n. Al decidir lo que deber�a ir en las alternativas de texto, las siguientes preguntas son �tiles: �Por qu� esta este contenido no textual aqu�? �Qu� informaci�n presenta? �Qu� prop�sito tiene que cumplir? Si no podria utilizar el contenido no textual, �qu� palabras usaria para transmitir la misma funci�n y/o informaci�n?.", 
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el contenido no textual.
	 * 2. Mostrar la descripci�n larga.
	 * 3. Verificar que la descripci�n larga transmite la misma informaci�n que se transmite por el contenido no textual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualTransmiteMismaInformacionContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual larga transmite misma informaci�n que se se transmite por el contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la descripci�n larga transmite la misma informaci�n que se transmite por el contenido no textual.",
				"Enlaza la informaci�n en texto que ofrezca la misma informaci�n que el contenido no textual.");
		comprobacionAlternativaTextualTransmiteMismaInformacionContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualTransmiteMismaInformacionContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}