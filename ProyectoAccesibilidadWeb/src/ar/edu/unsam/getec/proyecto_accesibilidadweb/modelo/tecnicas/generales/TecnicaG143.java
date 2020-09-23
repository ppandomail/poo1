package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG143 extends TecnicaGeneral {

	public TecnicaG143(CategoriaTecnica categoriaTecnica) {
		super(
				"G143", 
				"Proporcionar un texto alternativo que describe el prop�sito de la prueba CAPTCHA.",
				"El prop�sito de esta t�cnica es proporcionar informaci�n a trav�s de la alternativa textual que identifica el contenido no textual como de CAPTCHA. Tales pruebas implican a menudo pidiendo al usuario que escriba el texto que se presenta en una imagen oscurecida o archivo de audio. A partir de la alternativa de texto, el usuario puede decir que el CAPTCHA requiere completar una tarea y qu� tipo de tarea que es. Cuando una versi�n alternativa de un CAPTCHA esta disponible, el texto alternativo debe incluir instrucciones sobre c�mo encontrar la versi�n alternativa.", 
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el CAPTCHA.
	 * 2. Reemplazarlo con el texto alternativo.
	 * 3. Verificar que la alternativa de texto describe el prop�sito del CAPTCHA.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualDescribePropositoCAPTCHA = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual describe el prop�sito del CAPTCHA.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la alternativa de texto describe el prop�sito del CAPTCHA.",
				"Si el contenido no textual es un CAPTCHA describe el objetivo del CAPTCHA.");
		comprobacionAlternativaTextualDescribePropositoCAPTCHA.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualDescribePropositoCAPTCHA);
		return resultadoEvaluacionTecnica;
	}

}