package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH33 extends TecnicaHTML {

	public TecnicaH33(CategoriaTecnica categoriaTecnica) {
		super(
				"H33",
				"Complementar el texto de un enlace con el tributo title.",
				"El prop�sito de esta t�cnica es mostrar c�mo usar un atributo title en un enlace para proporcionar texto adicional que describa el enlace. El atributo title se usa para proporcionar informaci�n adicional para aclarar o describir con m�s detalle el prop�sito de un enlace. Si la informaci�n complementaria proporcionada por el atributo title es algo que el usuario debe saber antes de seguir el enlace, como una advertencia, entonces debe ser proporcionada en el texto del enlace y no en el atributo title.",
				categoriaTecnica);
	}

	/**
	 * 1. Por cada elemento a que tiene un atributo title, verificar que el atributo title junto con el texto del enlace describen el prop�sito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAtributoTitleRepiteTextoDelEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Enlaces con igual texto en el contenido y atributo \"title\".",
				"Por cada elemento \"a\" que tiene un atributo \"title\", verificar que el atributo \"title\" sea distinto del texto del enlace.",
				"Identifica el objetivo del un enlace usando un texto clarificador en el enlace combinado con el atributo \"title\".");
		ResultadoEvaluacionTecnicaItem comprobacionAtributoTitleJuntoConTextoEnlaceDescribenPropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Enlaces con atributo \"title\" junto con el texto del enlace describen su prop�sito.", 
				TipoResultadoEvaluacion.MANUAL,
				"Por cada elemento \"a\" que tiene un atributo \"title\", verificar que el atributo \"title\" junto con el texto del enlace describen el prop�sito del enlace.",
				"Identifica el objetivo del un enlace usando un texto clarificador en el enlace combinado con el atributo \"title\".");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A)) {
			String atributoTitle = elementoA.getAttributeValue("title");
			if ((atributoTitle != null) && (!atributoTitle.isEmpty())) {
				if (elementoA.getTextExtractor().toString().trim().equalsIgnoreCase(atributoTitle))
					comprobacionAtributoTitleRepiteTextoDelEnlace.procesar(elementoA);
				comprobacionAtributoTitleJuntoConTextoEnlaceDescribenPropositoEnlace.procesar(elementoA);			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoTitleRepiteTextoDelEnlace);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoTitleJuntoConTextoEnlaceDescribenPropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}