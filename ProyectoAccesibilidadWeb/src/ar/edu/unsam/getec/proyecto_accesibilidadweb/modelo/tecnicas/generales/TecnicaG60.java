package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG60 extends TecnicaGeneral {

	public TecnicaG60(CategoriaTecnica categoriaTecnica) {
		super(
				"G60", 
				"Reproducci�n de un sonido que se apague autom�ticamente dentro de tres segundos.", 
				"El prop�sito de esta t�cnica es permitir a los autores a reproducir sonido en su p�gina Web pero evitar el problema de que los usuarios no puedan usar sus lectores de pantalla debido a la interferencia causada por el sonido del contenido. Esta t�cnica es simple. El sonido se reproduce durante 3 segundos o menos y se para autom�ticamente.",
				categoriaTecnica);
	}

	/**
	 * 1. Cargar la p�gina Web.
	 * 2. Verificar que todos los sonidos que se reproduzcan autom�ticamente se detengan en 3 segundos o menos.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionApagadoSonido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Sonidos que se reproduzcan autom�ticamente se detengan en 3 segundos o menos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todos los sonidos que se reproduzcan autom�ticamente se detengan en 3 segundos o menos.",
				"Si un sonido se reproduce autom�ticamente, ap�galo tambi�n autom�ticamente antes de tres segundos.");
		comprobacionApagadoSonido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionApagadoSonido);
		return resultadoEvaluacionTecnica;
	}

}