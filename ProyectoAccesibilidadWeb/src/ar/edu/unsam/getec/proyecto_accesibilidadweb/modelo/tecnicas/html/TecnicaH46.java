package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH46 extends TecnicaHTML {

	public TecnicaH46(CategoriaTecnica categoriaTecnica) {
		super(
				"H46", 
				"Usar noembed con embed.", 
				"El objetivo de esta t�cnica es proporcionar contenido alternativo para el elemento embed en un elemento noembed. El noembed se hace s�lo si no se admite la inserci�n. Si bien se puede colocar en cualquier lugar de la p�gina, es una buena idea incluirlo como un elemento hijo de embed.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar si el elemento embed tiene un elemento noembed.
	 * 2. Verificar si el elemento embed tiene un elemento noembed que inmediatamente lo sigue.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEmbedConNoembed = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Elemento \"embed\" tiene elemento \"noembed\".",
				"Verificar si el elemento \"embed\" tiene un elemento \"noembed\" que inmediatamente lo sigue.",
				"Complementa los elementos \"embed\" con los elementos \"noembed\".");
		Boolean flagNoembedEnEmbed = Boolean.TRUE;
		Boolean flagNoembedSigueInmediatamenteAEmbed = Boolean.TRUE;
		List<Element> listaElementos = this.getParseador().getElementos();
		for (Integer i=0; i < listaElementos.size(); i++) {
			Element elemento = listaElementos.get(i);
			if (elemento.getName().equals(HTMLElementName.EMBED)) {
				if (elemento.getAllElements("noembed").isEmpty())
					flagNoembedEnEmbed = Boolean.FALSE;
				if ((i+1) == listaElementos.size())
					flagNoembedSigueInmediatamenteAEmbed = Boolean.FALSE;
				else
					if (!listaElementos.get(i+1).getName().equals("noembed"))
						flagNoembedSigueInmediatamenteAEmbed = Boolean.FALSE;
				if (!flagNoembedEnEmbed && !flagNoembedSigueInmediatamenteAEmbed)
					comprobacionEmbedConNoembed.procesar(elemento);
			}	
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEmbedConNoembed);
		return resultadoEvaluacionTecnica;
	}

}