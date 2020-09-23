package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH81 extends TecnicaHTML {

	public TecnicaH81(CategoriaTecnica categoriaTecnica) {
		super(
				"H81",
				"Identificar el pr�posito de un enlace usando su texto combinado con elemento de lista padre de la lista que lo contiene.", 
				"",
				categoriaTecnica);
	}

	/**
	 * En cada enlace en el contenido que utiliza esta t�cnica:
	 * 1. Encontrar el elemento ul u ol que contiene el enlace.
	 * 2. Verificar que este elemento de la lista (ul, ol) es descendiente de un elemento li.
	 * 3. Verificar que el texto del enlace combinado con el texto de ese elemento li describe el prop�sito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceYListaDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace y del elemento de lista descendiente de \"ol\" o \"ul\" describen el prop�sito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"En cada enlace en el contenido que utiliza esta t�cnica: Verificar que el texto del enlace combinado con el texto del elemento \"li\" describe el prop�sito del enlace.",
				"Identifica el objetivo de un enlace usando un texto de enlace combinado con su contexto (en una lista anidada, el elemento padre que lo engloba) de forma que sea determinable por software.");
		for (Element elementoLI : this.getParseador().getElementos(HTMLElementName.LI)) 
			for (Element elementoOL : elementoLI.getAllElements(HTMLElementName.OL))
				for (Element elementoLI2 : elementoOL.getAllElements(HTMLElementName.LI))
					for (Element elementoA: elementoLI2.getAllElements(HTMLElementName.A)) 
						comprobacionTextoEnlaceYListaDescribenPropositoEnlace.procesar(elementoA);
		for (Element elementoLI : this.getParseador().getElementos(HTMLElementName.LI)) 
			for (Element elementoUL : elementoLI.getAllElements(HTMLElementName.UL))
				for (Element elementoLI2 : elementoUL.getAllElements(HTMLElementName.LI))
					for (Element elementoA: elementoLI2.getAllElements(HTMLElementName.A)) 
						comprobacionTextoEnlaceYListaDescribenPropositoEnlace.procesar(elementoA);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceYListaDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}