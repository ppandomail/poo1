package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH80 extends TecnicaHTML {

	public TecnicaH80(CategoriaTecnica categoriaTecnica) {
		super(
				"H80",
				"Identificar el pr�posito de un enlace usando su texto combinado con el elemento de encabezado que lo precede.", 
				"",
				categoriaTecnica);
	}

	/**
	 * En cada enlace en el contenido que utiliza esta t�cnica:
	 * 1. Encontrar el elemento de encabezado que precede al enlace.
	 * 2. Verificar que el texto del enlace combinado con el texto de ese encabezado describe el prop�sito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace y del encabezado describen el prop�sito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"En cada enlace en el contenido que utiliza esta t�cnica: Verificar que el texto del enlace combinado con el texto del encabezado que precede al enlace describe el prop�sito del enlace.",
				"Identifica el objetivo de un enlace usando un texto de enlace combinado con su contexto (el elemento de encabezado que le precede) de forma que sea determinable por software.");
		for (Element elementoTD : this.getParseador().getElementos(HTMLElementName.H1)) 
			for (Element elementoA: elementoTD.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace.procesar(elementoA);
		for (Element elementoTD : this.getParseador().getElementos(HTMLElementName.H2)) 
			for (Element elementoA: elementoTD.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace.procesar(elementoA);
		for (Element elementoTD : this.getParseador().getElementos(HTMLElementName.H3)) 
			for (Element elementoA: elementoTD.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace.procesar(elementoA);
		for (Element elementoTD : this.getParseador().getElementos(HTMLElementName.H4)) 
			for (Element elementoA: elementoTD.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace.procesar(elementoA);
		for (Element elementoTD : this.getParseador().getElementos(HTMLElementName.H5)) 
			for (Element elementoA: elementoTD.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace.procesar(elementoA);
		for (Element elementoTD : this.getParseador().getElementos(HTMLElementName.H6)) 
			for (Element elementoA: elementoTD.getAllElements(HTMLElementName.A)) 
				comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace.procesar(elementoA);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceYEncabezadoTablaDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}