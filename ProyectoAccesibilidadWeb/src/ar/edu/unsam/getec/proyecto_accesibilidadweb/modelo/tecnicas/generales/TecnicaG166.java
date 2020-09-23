package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG166 extends TecnicaGeneral {

	public TecnicaG166(CategoriaTecnica categoriaTecnica) {
		super(
				"G166",
				"Proporcionar audio que describe el contenido de v�deo importante y lo describi� como tales.",
				"Contenido de solo v�deo es inaccesible para las personas ciegas y con algunos que tienen baja visi�n. Por lo tanto, es importante para ellos tener un audio alternativo. Una forma de hacer esto es proporcionar una pista de audio que describe la informaci�n en el v�deo. El audio debe ser un formato de audio com�n usado en Internet, tales como MP3.", 
				categoriaTecnica);
	}

	/**
	 * Para una p�gina Web que contiene el contenido de s�lo v�deo:
	 * 1. Verificar que hay un link a un audio alternativo que describe el contenido del v�deo inmediatamente antes o despu�s del contenido de s�lo v�deo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAudioDescribeContenidoVideo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Audio que describe el contenido del video.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para una p�gina Web que contiene el contenido de s�lo v�deo: Verificar que hay un link a un audio alternativo que describe el contenido del v�deo inmediatamente antes o despu�s del contenido de s�lo v�deo.",
				"Si el contenido es v�deo solo grabado, ofrece un contenido sonoro que describa el contenido m�s importante del video.");
		comprobacionAudioDescribeContenidoVideo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAudioDescribeContenidoVideo);
		return resultadoEvaluacionTecnica;
	}

}