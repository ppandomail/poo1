package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH35 extends TecnicaHTML {

	public TecnicaH35(CategoriaTecnica categoriaTecnica) {
		super(
				"H35", 
				"Proporcionar alternativas textuales en los elementos applet.", 
				"Proporcionar un texto alternativo para un applet mediante el atributo alt para etiquetar un applet y proporcionar el texto alternativo en el cuerpo del elemento applet.",
				categoriaTecnica);
	}

	/**
	 * 1. Ver el c�digo fuente del elemento 'applet'.
	 * 2. Verificar que el elemento 'applet' contiene un atributo 'alt' con un texto alternativo para el applet.
	 * 3. Verificar que el elemento 'applet' contiene un texto alternativo para el applet en el cuerpo del elemento 'applet'
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAppletSinAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.APPLETS, 
				"Elementos \"applet\" sin atributo \"alt\".",
				"Verificar que el elemento \"applet\" contiene un atributo \"alt\" con un texto alternativo para el applet.",
				"Ofrece una alternativa textual para los \"applets\".");
		ResultadoEvaluacionTecnicaItem comprobacionAppletSinTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.APPLETS, 
				"Elementos \"applet\" sin texto.",
				"Verificar que el elemento \"applet\" contiene un texto alternativo para el applet en el cuerpo del elemento \"applet\".",
				"Ofrece un texto alternativo para el applet en el cuerpo del elemento \"applet\".");
		for (Element elementoAPPLET : this.getParseador().getElementos(HTMLElementName.APPLET)) {
			String atributoAlt = elementoAPPLET.getAttributeValue("alt");
			if (atributoAlt == null) 
				comprobacionAppletSinAlt.procesar(elementoAPPLET);
			else
				if(atributoAlt.isEmpty()) 
					comprobacionAppletSinAlt.procesar(elementoAPPLET);
			if(elementoAPPLET.getTextExtractor().toString().isEmpty())
				comprobacionAppletSinTexto.procesar(elementoAPPLET);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAppletSinAlt);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAppletSinTexto);
		return resultadoEvaluacionTecnica;
	}

}