package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG111 extends TecnicaGeneral {

	public TecnicaG111(CategoriaTecnica categoriaTecnica) {
		super(
				"G111", 
				"Uso del color y el patr�n.", 
				"El objetivo de esta t�cnica es para asegurar que cuando se usan las diferencias de color para transmitir informaci�n dentro de contenido no textual, los patrones se incluyen para transmitir la misma informaci�n de una manera que no depende de color.", 
				categoriaTecnica);
	}

	/**
	 * Para cada imagen dentro de la p�gina Web que utilizan las diferencias de color para transmitir informaci�n:
	 * 1. Verificar que toda la informaci�n que es transmitida usando color es tambi�n transmitida usando patrones que no se basan en el color. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionInformacionConColorYPatrones = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Informaci�n que es transmitida usando color es tambi�n transmitida usando patrones que no se basan en el color.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada imagen dentro de la p�gina Web que utilizan las diferencias de color para transmitir informaci�n: Verificar que toda la informaci�n que es transmitida usando color es tambi�n transmitida usando patrones que no se basan en el color.",
				"Si se comunica informaci�n mediante el color dentro de una imagen: Diferencia los datos mediante colores y motivos del dibujo. Aseg�rate que la informaci�n comunicada por las diferencias de color est� tambi�n disponible en el texto.");
		comprobacionInformacionConColorYPatrones.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionInformacionConColorYPatrones);
		return resultadoEvaluacionTecnica;
	}

}