package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG53 extends TecnicaGeneral {

	public TecnicaG53(CategoriaTecnica categoriaTecnica) {
		super(
				"G53",
				"Identificar el prop�sito de un enlace usando el texto de enlaces combinado con el texto de la sentencia de encerramiento.",
				"El objetivo de esta t�cnica es identificar el prop�sito de un enlace desde el enlace y su sentencia. La sentencia que encierra el enlace proporciona el contexto para un enlace de otra manera poco clara. La descripci�n permite a un usuario a distinguir este enlace siguiendo los enlaces de la p�gina Web que conducen a otros destinos y ayuda al usuario a determinar si seguir o no el enlace. Tener en cuenta que simplemente proporcionar el URL del destino en general no es suficientemente descriptivo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que el enlace es parte de una sentencia.
	 * 2. Verificar que el texto del enlace combinada con el texto de su sentencia de cierre describe el prop�sito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceConTextoSentenciaDescribePropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Texto del enlace con el texto de la oraci�n que lo engloba describe el prop�sito del enlace.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el texto en el enlace combinado con el texto de la oraci�n que lo engloba describe el prop�sito del enlace.",
				"Identifica el objetivo de un enlace usando un texto en el enlace combinado con el texto de la oraci�n que lo engloba.");
		comprobacionTextoEnlaceConTextoSentenciaDescribePropositoEnlace.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceConTextoSentenciaDescribePropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}