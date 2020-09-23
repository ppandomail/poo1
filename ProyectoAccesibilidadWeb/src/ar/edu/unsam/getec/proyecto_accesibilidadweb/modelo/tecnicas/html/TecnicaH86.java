package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaH86 extends TecnicaHTML {

	public TecnicaH86(CategoriaTecnica categoriaTecnica) {
		super(
				"H86",
				"Proporcionar alternativas textuales para el arte ASCII, los emoticones y la escritura leet.", 
				"",
				categoriaTecnica);
	}

	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAltEnArteASCII = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Atributo \"alt\" en arte ASCII.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que hay un texto alternativo inmediatamente antes o despu�s de todo arte ASCII.",
				"No utilices arte ASCII sin ofrecer una alternativa textual.");
		ResultadoEvaluacionTecnicaItem comprobacionAltEnEmoticones = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Atributo \"alt\" en emoticones.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que hay un texto alternativo inmediatamente antes o despu�s de todo emoticones.",
				"No utilices emoticones sin ofrecer una alternativa textual.");
		ResultadoEvaluacionTecnicaItem comprobacionAltEnEscrituraLeet = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Atributo \"alt\" en texto en formato \"leet\".", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que hay un texto alternativo inmediatamente antes o despu�s de todo texto en formato \"leet\".",
				"No utilices texto en formato \"leet\" sin ofrecer una alternativa textual.");
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAltEnArteASCII);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAltEnEmoticones);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAltEnEscrituraLeet);
		return resultadoEvaluacionTecnica;
	}

}