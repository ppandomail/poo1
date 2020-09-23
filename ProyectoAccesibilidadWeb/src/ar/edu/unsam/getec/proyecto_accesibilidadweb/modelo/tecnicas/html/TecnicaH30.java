package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH30 extends TecnicaHTML {

	public TecnicaH30(CategoriaTecnica categoriaTecnica) {
		super(
				"H30",
				"Proporcionar en los enlaces textos que describan el prop�sito del enlace para los elementos ancla",
				"El objetivo de esta t�cnica es describir el prop�sito de un enlace al proporcionar texto descriptivo como el contenido del elemento a. La descripci�n permite a un usuario a distinguir este enlace de otros enlaces en la p�gina web y ayuda al usuario a determinar si seguir el enlace . El URI del destino en general no es suficientemente descriptivo. Cuando una imagen es el �nico contenido de un enlace, el texto alternativo para la imagen describe la funci�n �nica del enlace. Cuando el contenido de un enlace contiene texto y una o m�s im�genes , si el texto es suficiente para describir el prop�sito del enlace, las im�genes pueden tener una alternativa de texto vac�o.",
				categoriaTecnica);
	}

	/**
	 * Para cada enlace en el contenido que utiliza esta t�cnica:
	 * 1. Verificar que el texto o un texto alternativo para el contenido no textual est� incluido en el elemento a.
	 * 2. Si un elemento 'img' es el �nico contenido del elemento 'a', verificar que su alternativa textual describe el prop�sito del enlace.
	 * 3. Si el elemento 'a' contiene uno o m�s elementos 'img' y la alternativa textual del elemento img est� vac�a, verificar que el texto del enlace describe el prop�sito del enlace.
	 * 4. Si el elemento 'a' s�lo contiene texto, verificar que el texto describe el prop�sito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenesEnlaceConAltNoDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Im�genes del enlace con atributo \"alt\" no describen el prop�sito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"Para cada enlace en el contenido: Si un elemento \"img\" es el �nico contenido del elemento \"a\", verificar que su alternativa textual describe el prop�sito del enlace.",
				"No dejes el atributo \"alt\" vac�o de una imagen cuando la imagen sea el �nico contenido de un enlace.");
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceNoDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace no describen el prop�sito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"Para cada enlace en el contenido:  Si el elemento \"a\" s�lo contiene texto, verificar que el texto describe el prop�sito del enlace.",
				"Aseg�rate que el texto de un enlace describe el prop�sito del enlace cuando el elemento \"a\" solo contiene texto. No ofrezcas enlaces sin un texto informativo que lo contextualice (como \"Click aqu�\" o \"Leer m�s\").");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A)) {
			List<Element> listaElementos = elementoA.getAllElements();
			List<Element> listaElementosIMGenA = elementoA.getAllElements(HTMLElementName.IMG);
			if ((listaElementos.size() == 2) && (listaElementosIMGenA.size() == 1)) 
				comprobacionImagenesEnlaceConAltNoDescribenPropositoEnlace.procesar(listaElementosIMGenA.get(0));
			if (listaElementosIMGenA.size() >= 1) {
				for (Element elementoIMG : listaElementosIMGenA) {
					if ((elementoIMG.getAttributeValue("alt") != null) && (!elementoIMG.getAttributeValue("alt").isEmpty())) {

					} else 
						comprobacionTextoEnlaceNoDescribenPropositoEnlace.procesar(elementoA);
				}
			} else 
				comprobacionTextoEnlaceNoDescribenPropositoEnlace.procesar(elementoA);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesEnlaceConAltNoDescribenPropositoEnlace);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceNoDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}