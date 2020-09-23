package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH57 extends TecnicaHTML {

	public TecnicaH57(CategoriaTecnica categoriaTecnica) {
		super(
				"H57",
				"Usar atributos de idioma en el elemento html.",
				"El prop�sito de esta t�cnica es identificar el idioma predeterminado de un documento proporcionando el atributlo lang y/o xml:lang en el elemento html. Identificar el idioma del documento es importante para que las ayudas t�cnicas y las aplicaciones de usuario convencionales puedan procesar los textos con mayor fidelidad. Los lectores de pantalla pueden cargar las reglas de pronunciaci�n adecuadas y los usuarios con discapacidad tendr�n m�s posibilidades de entender el contenido. HTML s�lo ofrece el uso del atributo lang mientras que XHTML 1.0 (como medida de transici�n) permite lang y xml:lang (ambos deben tener un mismo valor), y XHTML 1.1 s�lo permite xml:lang.",
				categoriaTecnica);
	}

	/**
	 * 1. Examinar el elemento HTML del documento.
	 * 2. Verificar que el elemento HTML tiene un atributo lang y/o un atributo xml:lang
	 * 3. Verificar que el valor del atributo lang se ajusta a BCP 47: Etiquetas para la identificaci�n del lenguaje o su sucesor y refleja el idioma principal utilizado por la p�gina web.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionDeclaracionIdiomaDocumento = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Declaraci�n de idioma del documento.",
				"Verificar que el elemento HTML tiene un atributo \"lang\" y/o un atributo \"xml:lang\".",
				"Identifica el idioma o los idiomas predeterminados usando el atributo \"language\" en los elementos de HTML. Especifica el idioma predeterminado de toda la p�gina usando: en el encabezado \"http\" de servidor, en el atributo \"lang\" de la etiqueta \"http\", en el atributo \"content-language\" de la etiqueta \"meta\".");
		ResultadoEvaluacionTecnicaItem comprobacionIdiomaDeclaradoIdiomaReal = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Idioma declarado e idioma real.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el valor del atributo \"lang\" se ajusta a BCP 47: Etiquetas para la identificaci�n del lenguaje o su sucesor y refleja el idioma principal utilizado por la p�gina web.",
				"Identifica el idioma o los idiomas predeterminados usando el atributo \"language\" en los elementos de HTML. Especifica el idioma predeterminado de toda la p�gina usando: en el encabezado \"http\" de servidor, en el atributo \"lang\" de la etiqueta \"http\", en el atributo \"content-language\" de la etiqueta \"meta\".");
		for (Element elementoHTML : this.getParseador().getElementos(HTMLElementName.HTML)) {
			Boolean flagLang = Boolean.FALSE;
			Boolean flagXmlLang = Boolean.FALSE;
			if ((elementoHTML.getAttributeValue("lang") != null) && (!elementoHTML.getAttributeValue("lang").isEmpty())) { 
				flagLang = Boolean.TRUE;
			}
			if ((elementoHTML.getAttributeValue("xml:lang") != null) && (!elementoHTML.getAttributeValue("xml:lang").isEmpty())) {
				flagXmlLang = Boolean.TRUE;
			}
			if (!flagLang && !flagXmlLang) 
				comprobacionDeclaracionIdiomaDocumento.procesar(elementoHTML);
			if ((elementoHTML.getAttributeValue("lang") != null) && (!elementoHTML.getAttributeValue("lang").isEmpty())) 
				comprobacionIdiomaDeclaradoIdiomaReal.procesar();
			if ((elementoHTML.getAttributeValue("xml:lang") != null) && (!elementoHTML.getAttributeValue("xml:lang").isEmpty())) 
				comprobacionIdiomaDeclaradoIdiomaReal.procesar();
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionDeclaracionIdiomaDocumento);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionIdiomaDeclaradoIdiomaReal);
		return resultadoEvaluacionTecnica;
	}

}