package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaH75 extends TecnicaHTML {

	public TecnicaH75(CategoriaTecnica categoriaTecnica) {
		super(
				"H75",
				"Asegurarse de las p�ginas web sean bien formadas.", 
				"El objetivo de esta t�cnica es evitar errores claves que se sabe que causan problemas de las tecnolog�as de apoyo cuando est�n tratando de analizar su contenido. Una buena formaci�n se comprueba mediante el an�lisis del documento con un analizador XML y comprobar si el informe de validaci�n menciona errores de buena formaci�n. Se requiere que cada analizador XML para comprobar la buena formaci�n y detener el procesamiento normal cuando se encuentra un error de buena formaci�n (un analizador XML no tiene que permitir la validaci�n).",
				categoriaTecnica);
	}

	/**
	 * 1. Cargar cada archivo en un analizador XML de validaci�n. 
	 * 2. Verificar que no hay errores de buena formaci�n.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDocumentoHTMLMalFormado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Documento HTML mal formado.",
				"Verificar que no hay errores de buena formaci�n.",
				"Aseg�rate que la p�gina web puede ser procesada y que est� bien formada.");
		if (!this.getParseador().esBienFormado())
			comprobacionDocumentoHTMLMalFormado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDocumentoHTMLMalFormado);
		return resultadoEvaluacionTecnica;
	}

}