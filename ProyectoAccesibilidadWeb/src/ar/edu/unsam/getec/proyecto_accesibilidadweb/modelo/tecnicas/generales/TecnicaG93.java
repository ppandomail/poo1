package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG93 extends TecnicaGeneral {

	public TecnicaG93(CategoriaTecnica categoriaTecnica) {
		super(
				"G93", 
				"Proporcionar los subt�tulos abiertos (siempre visible).", 
				"El objetivo de esta t�cnica es proporcionar una manera para que las personas sordas o que de otra manera tendr�an problemas para escuchar el di�logo en el material audiovisual para poder ver el material. Con esta t�cnica, todos los di�logos y sonidos importantes est�n incrustadas como texto en la pista de v�deo. Como el resultado siempre es visible y no hay soporte especial para la capturacion, es requerido por el agente de usuario.", 
				categoriaTecnica);
	}

	/**
	 * 1. Ver la sincronizaci�n multimedia cuando los subt�tulos se apagan.
	 * 2. Verificar que los subt�tulos (de todos los di�logos y sonidos importantes) son visibles.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSubtitulos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Subt�tulos visibles.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que los subt�tulos (de todos los di�logos y sonidos importantes) son visibles.",
				"Ofrece sub�tulos para sordos de forma abierta (est�n incrustados en la propia imagen del v�deo, por lo que no se pueden alterar ni ocultar, salvo ubicando encima otros subt�tulos).");
		comprobacionSubtitulos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSubtitulos);
		return resultadoEvaluacionTecnica;
	}

}