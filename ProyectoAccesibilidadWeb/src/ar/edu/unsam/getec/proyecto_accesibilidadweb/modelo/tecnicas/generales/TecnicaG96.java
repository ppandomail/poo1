package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG96 extends TecnicaGeneral {

	public TecnicaG96(CategoriaTecnica categoriaTecnica) {
		super(
				"G96",
				"Proporcionar la identificaci�n textual de art�culos que de otra manera se basan �nicamente en la informaci�n sensorial que se entienda.",
				"El objetivo de esta t�cnica es asegurar que los elementos dentro de una p�gina web se hace referencia en el contenido , no s�lo por la forma, el tama�o , el sonido o la ubicaci�n , sino tambi�n en formas que no dependen de que la percepci�n sensorial . Por ejemplo , una referencia tambi�n puede describir la funci�n del art�culo o su etiqueta", 
				categoriaTecnica);
	}

	/**
	 * Buscar todas las referencias en la p�gina Web que menciona la forma, el tama�o o la posici�n de un objeto. Para cada uno de esos elementos:
	 * 1. Verificar que la referencia contiene informaci�n adicional que permite que el elemento a ser localizados e identificados sin ning�n conocimiento de su forma, tama�o o posici�n relativa.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCaracteristicasSensoriales = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Caracter�sticas sensoriales.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Buscar todas las referencias en la p�gina Web que menciona la forma, el tama�o o la posici�n de un objeto. Para cada uno de esos elementos: Verificar que la referencia contiene informaci�n adicional que permite que el elemento a ser localizados e identificados sin ning�n conocimiento de su forma, tama�o o posici�n relativa.",
				"Ofrece identificaci�n textual de los elementos que de otra manera s�lo depender�an de la informaci�n sensorial para ser comprendidos (por ejemplo,  \"pulsa en el cuadro grande para continuar\"). No identifiques el contenido s�lo por su forma o localizaci�n. No utilices �nicamente un s�mbolo gr�fico para comunicar informaci�n.");
		comprobacionCaracteristicasSensoriales.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCaracteristicasSensoriales);
		return resultadoEvaluacionTecnica;
	}

}