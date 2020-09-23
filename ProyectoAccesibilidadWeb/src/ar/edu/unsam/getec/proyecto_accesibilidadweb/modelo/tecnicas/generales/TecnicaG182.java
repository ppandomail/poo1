package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG182 extends TecnicaGeneral {

	public TecnicaG182(CategoriaTecnica categoriaTecnica) {
		super(
				"G182",
				"Asegurarse de que las se�ales visuales adicionales est�n disponibles cuando se utilizan las diferencias de color de texto para transmitir informaci�n.",
				"La intenci�n de esta t�cnica es proporcionar una se�al visual redundante para usuarios que pueden no ser capaces de discernir la diferencia en el color del texto . El color se utiliza normalmente para indicar los diferentes estados de las palabras que forman parte de un p�rrafo u otro bloque de texto o en caracteres o gr�ficos especiales no se pueden utilizar para indicar qu� palabras tienen un estatus especial . Por ejemplo , las palabras dispersas en el texto pueden ser enlaces de hipertexto que est�n marcados como tal al ser impresa en un color diferente . Esta t�cnica se describe una manera de proporcionar se�ales , adem�s de color de modo que los usuarios que pueden tener dificultades para percibir las diferencias de color o con baja visi�n puede identificarlos. Para utilizar esta t�cnica, un autor incorpora una se�al visual, adem�s de color para cada lugar en el que s�lo el color se utiliza para transmitir informaci�n. Las indicaciones visuales pueden tomar muchas formas, incluyendo cambios en el estilo de fuente, la adici�n de subrayados, negrita o cursiva, o cambios en el tama�o de la fuente .", 
				categoriaTecnica);
	}

	/**
	 * 1. Localizar todos los casos en los que se utiliza el color del texto para transmitir informaci�n.
	 * 2. Verificar que cualquier texto en el que se utiliza el color para transmitir informaci�n tambi�n se labra o utiliza una fuente que hace que sea visualmente distinta del resto del texto alrededor de ella.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoConColorConFuenteDistinta = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Texto con color con fuente visualmente distinta del resto del texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que cualquier texto en el que se utiliza el color para transmitir informaci�n tambi�n se labra o utiliza una fuente que hace que sea visualmente distinta del resto del texto alrededor de ella.",
				"Si se comunica informaci�n mediante el color en palabras, fondos u otros contenidos: Aseg�rate que hay se�ales visuales adicionales cuando las diferencias de color en el texto contienen informaci�n.");
		comprobacionTextoConColorConFuenteDistinta.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoConColorConFuenteDistinta);
		return resultadoEvaluacionTecnica;
	}

}