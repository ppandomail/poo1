package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG100 extends TecnicaGeneral {

	public TecnicaG100(CategoriaTecnica categoriaTecnica) {
		super(
				"G100",
				"Proporcionar una alternativa de texto corto que es el nombre aceptado o un nombre descriptivo del contenido no textual.",
				"El objetivo de esta t�cnica es permitir a los usuarios identificar el contenido no textual, incluso si el contenido no textual tiene por objeto proporcionar una experiencia sensorial espec�fica. Por ejemplo, una persona sorda puede querer saber qu� es un archivo de audio instrumental - incluso si no pueden oirlo. Del mismo modo, una persona ciega puede querer saber lo que el sujeto de una imagen visual es - incluso si no pueden verlo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que alternativa de texto corto proporciona un nombre descriptivo.
	 * 2. Verificar que alternativa de texto corto proporciona un nombre que ha sido previamente dado al contenido no textual por el autor u otro.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualCortaProporcionaNombreDescriptivo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual corta proporciona un nombre descriptivo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que alternativa de texto corta proporciona un nombre descriptivo.",
				"Haz breve la \"descripci�n corta\".");
		comprobacionAlternativaTextualCortaProporcionaNombreDescriptivo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualCortaProporcionaNombreDescriptivo);
		return resultadoEvaluacionTecnica;
	}

}