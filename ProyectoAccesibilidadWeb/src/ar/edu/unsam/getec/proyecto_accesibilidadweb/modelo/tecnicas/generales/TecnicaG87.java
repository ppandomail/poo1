package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG87 extends TecnicaGeneral {

	public TecnicaG87(CategoriaTecnica categoriaTecnica) {
		super(
				"G87", 
				"Proporcionar subt�tulos.", 
				"El objetivo de esta t�cnica es proporcionar una manera para que las personas que tienen problemas de audici�n o de otra manera tendr�an problemas para escuchar el di�logo en el material multimedia sincronizado para poder ver el material y ver el di�logo y sonidos - sin personas que requieren que no son sordos para ver las capturas. Con esta t�cnica, todo el di�logo y sonidos importantes est�n incrustados como texto de una manera que hace que el texto no sea visible a menos que el usuario lo solicita. Como resultado son visibles s�lo cuando sea necesario. Se requiere un apoyo especial para las capturas en el agente de usuario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Activar la funci�n de subt�tulos del reproductor multimedia.
	 * 2. Ver el contenido multimedia sincronizado.
	 * 3. Verificar que los subt�tulos (de todos los di�logos y sonidos importantes) son visibles.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Subt�tulos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los subt�tulos (de todos los di�logos y sonidos importantes) son visibles.",
				"Ofrece sub�tulos para sordos de forma cerrada  (disponibles en un archivo externo, un programa auxiliar los presenta junto al v�deo).");
		comprobacionSubtitulos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulos);
		return resultadoEvaluacionTecnica;
	}

}