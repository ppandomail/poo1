package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG68 extends TecnicaGeneral {

	public TecnicaG68(CategoriaTecnica categoriaTecnica) {
		super(
				"G68",
				"Proporcionar una alternativa de texto corto que describe el prop�sito del contenido en vivo de s�lo audio en directo y s�lo v�deo.",
				"Esta t�cnica ofrece una alternativa textual corta para el contenido en vivo de s�lo audio y solo video. Este texto puede ser utilizado en combinaci�n con una alternativa de texto completo de los medios de comunicaci�n basados en el tiempo (por audio o video), o en combinaci�n con la descripci�n de audio (para v�deo). Esas alternativas, sin embargo, no son parte de esta t�cnica. El prop�sito de esta t�cnica es asegurar que el usuario pueda determinar cu�l es el contenido no textual, incluso si no pueden acceder a el. NOTA: Aunque las alternativas completas tambi�n est�n disponibles, es importante que los usuarios sean capaces de identificar el contenido no textual cuando se encuentran con �l para que no se confundan, y para que puedan asociarlo con la alternativa completa cuando se encuentran con ella.", 
				categoriaTecnica);
	}

	/**
	 * 1. Eliminar, ocultar o enmascarar el contenido no textual.
	 * 2. Mostrar la/s alternativa de texto corto/s.
	 * 3. Verificar que el prop�sito del contenido no textual es claro, incluso si el contenido se pierde.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualDescribeContenidoAudioVideo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativas textuales describen prop�sito contenido audio y video.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el prop�sito del contenido no textual es claro, incluso si el contenido se pierde.",
				"Si el contenido no textual es un v�deo solo en directo o un sonido solo en directo describe el contenido no textual o su objetivo con una t�cnica de descripci�n corta.");
		comprobacionAlternativaTextualDescribeContenidoAudioVideo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualDescribeContenidoAudioVideo);
		return resultadoEvaluacionTecnica;
	}

}