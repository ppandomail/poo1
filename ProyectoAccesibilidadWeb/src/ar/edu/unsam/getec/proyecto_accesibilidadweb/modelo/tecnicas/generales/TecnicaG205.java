package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG205 extends TecnicaGeneral {

	public TecnicaG205(CategoriaTecnica categoriaTecnica) {
		super(
				"G205",
				"La inclusi�n de una entrada de texto para las etiquetas de control de formulario de colores.",
				"El objetivo de esta t�cnica es combinar color y de texto o de caracteres se�ales para transmitir informaci�n. La mayor�a de los usuarios pueden escanear r�pidamente el contenido para localizar la informaci�n facilitada mediante el uso de las diferencias de color. Los usuarios que no pueden ver el color puede mirar o escuchar a las se�ales de texto; personas que utilizan pantallas braille o en otras interfaces t�ctiles pueden detectar se�ales de texto a trav�s del tacto. La entrada de texto debe ser incluido como parte del nombre determinable por software para el control.", 
				categoriaTecnica);
	}

	/**
	 * Para cualquier contenido que se utilizan diferencias de color para transmitir informaci�n:
	 * 1. Verificar que la misma informaci�n est� disponible a trav�s de texto o caracteres se�ales.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Informaci�n transmitida con color tambi�n en texto.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cualquier contenido que se utilizan diferencias de color para transmitir informaci�n: Verificar que la misma informaci�n est� disponible a trav�s de texto o caracteres se�ales.",
				"Si se comunica informaci�n mediante el color en palabras, fondos u otros contenidos: Incluye una se�al de texto para etiquetas de controles de formulario coloreadas.");
		comprobacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
		return resultadoEvaluacionTecnica;
	}

}