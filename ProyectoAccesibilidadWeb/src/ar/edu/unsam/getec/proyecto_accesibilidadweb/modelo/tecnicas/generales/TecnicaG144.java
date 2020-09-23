package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG144 extends TecnicaGeneral {

	public TecnicaG144(CategoriaTecnica categoriaTecnica) {
		super(
				"G144",
				"Asegurarse de que la p�gina Web contiene otro CAPTCHA para servir al mismo prop�sito utilizando una modalidad diferente.",
				"El prop�sito de esta t�cnica es reducir las ocasiones en las que un usuario con una discapacidad no puede completar una tarea de CAPTCHA. Debido a que hay tareas de CAPTCHA alternativos que utilizan diferentes modalidades, un usuario es m�s probable que sea capaz de completar una de las tareas con �xito.", 
				categoriaTecnica);
	}

	/**
	 * Por cada CAPTCHA en una p�gina Web:
	 * 1. Verificar que la p�gina web contiene otro CAPTCHA para el mismo prop�sito, pero utilizando una modalidad diferente.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOtroCAPTCHAParaMismoProposito = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"P�gina Web con otro CAPTCHA para el mismo prop�sito.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Por cada CAPTCHA en una p�gina Web: Verificar que la p�gina web contiene otro CAPTCHA para el mismo prop�sito, pero utilizando una modalidad diferente.",
				"Ofrece m�s de dos modalidades de CAPTCHA o acceso directo al personal de atenci�n al cliente.");
		comprobacionOtroCAPTCHAParaMismoProposito.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOtroCAPTCHAParaMismoProposito);
		return resultadoEvaluacionTecnica;
	}

}