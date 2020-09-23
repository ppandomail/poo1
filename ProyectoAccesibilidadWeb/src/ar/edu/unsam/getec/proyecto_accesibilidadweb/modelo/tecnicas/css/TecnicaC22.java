package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC22 extends TecnicaCSS {

	public TecnicaC22(CategoriaTecnica categoriaTecnica) {
		super(
				"C22",
				"Usar CSS para controlar la presentaci�n visual del texto.",
				"El prop�sito de esta t�cnica es demostrar c�mo se pueden utilizar las CSS para controlar la presentaci�n visual del texto. Esto permitir� a los usuarios modificar, a trav�s de la aplicaci�n de usuario, las caracter�sticas visuales del texto para satisfacer sus necesidades. Las CSS benefician la accesibilidad principalmente por la separaci�n de la estructura del documento de su presentaci�n. Las hojas de estilo fueron dise�adas para permitir un control preciso -por fuera del sistema de marcas- del espaciado entre caracteres, alineaci�n del texto, la posici�n del objeto en la p�gina, las caracter�sticas de la fuente, etc. Al separar el estilo del sistema de marcas, los autores pueden simplificar y limpiar el marcado en su contenido, logrando al mismo tiempo que sea m�s accesible. Ejemplos: code {font-family:\"Courier New\", Courier, monospace}.right {text-align: right;} strong.largersize {font-size: 1.5em;} .highlight {font-weight:bold; color:#990000;}",
				categoriaTecnica);
	}

	/**
	 * Verifique si las propiedades CSS se utilizan para controlar la presentaci�n visual del texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/css"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validaci�n de las hojas de estilo: " +  atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar si las propiedades CSS se utilizan para controlar la presentaci�n visual del texto.",
						"Controla la presentaci�n visual del texto con CSS. Maqueta la p�gina con CSS, en lugar de hacerlo con tablas.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}		
		return resultadoEvaluacionTecnica;
	}

}