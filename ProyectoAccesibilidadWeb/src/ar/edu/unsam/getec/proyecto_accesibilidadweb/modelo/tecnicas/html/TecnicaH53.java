package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH53 extends TecnicaHTML {

	public TecnicaH53(CategoriaTecnica categoriaTecnica) {
		super(
				"H53", 
				"Usar el cuerpo del elemento object.", 
				"El objetivo de esta t�cnica es proporcionar una alternativa textual para contenido representado mediante el elemento object. El cuerpo del elemento object se puede utilizar para proporcionar una alternativa de texto completo para el objeto , o puede contener contenido adcional no textual con alternativas de texto.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que el cuerpo de cada elemento 'object' contiene una alternativa textual para el objeto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenEnObjectConAltNULL = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes dentro del elemento \"object\" sin atributo \"alt\".",
				"Verificar que el cuerpo de cada elemento \"object\" contiene una alternativa textual para la imagen.",
				"Uiliza el atributo \"alt\" en im�genes dentro del elemento \"object\".");
		ResultadoEvaluacionTecnicaItem comprobacionObjectSinTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Elementos \"object\" sin texto.",
				"Verificar que el cuerpo de cada elemento \"object\" contiene texto.",
				"Utiliza el texto dentro del elemento \"object\".");
		for (Element elementoOBJECT : this.getParseador().getElementos(HTMLElementName.OBJECT)) {
			for (Element elementoIMG : elementoOBJECT.getAllElements(HTMLElementName.IMG)) {
				String atributoAlt = elementoIMG.getAttributeValue("alt");
				if (atributoAlt == null)
					comprobacionImagenEnObjectConAltNULL.procesar(elementoIMG);
				else
					if (atributoAlt.isEmpty()) 
						comprobacionImagenEnObjectConAltNULL.procesar(elementoIMG);
			}
			if (elementoOBJECT.getAllElements(HTMLElementName.IMG).isEmpty()) {	
				if (elementoOBJECT.getTextExtractor().toString().isEmpty()) 
					comprobacionObjectSinTexto.procesar(elementoOBJECT);
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenEnObjectConAltNULL);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionObjectSinTexto);
		return resultadoEvaluacionTecnica;
	}

}