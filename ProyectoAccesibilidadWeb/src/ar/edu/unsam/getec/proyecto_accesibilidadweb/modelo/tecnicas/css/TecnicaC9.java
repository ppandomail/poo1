package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC9 extends TecnicaCSS {

	public TecnicaC9(CategoriaTecnica categoriaTecnica) {
		super(
				"C9",
				"Usar CSS para incluir im�genes decorativas.",
				"El prop�sito de esta t�cnica es proporcionar un mecanismo que permita agregar im�genes puramente decorativas e im�genes usadas para dar formato visual al contenido sin necesidad de marcas adicionales en el contenido. Esto hace posible que las ayudas t�cnicas ignoren el contenido no textual. Cuando las im�genes son decorativas es aceptable el uso del atributo alt nulo pero las im�genes que no transmiten informaci�n ni proporcionan alguna funcionalidad deber�an incluirse mediante CSS. Ejemplos: body {background: #ffe url(\"/images/home-bg.jpg\") repeat;} ul {list-style-image: url(\"bullet.gif\")} p:before {content: url(\"smiley.gif\")}",
				categoriaTecnica);
	}

	/**
	 *  Verificar la presencia de im�genes decorativas.
	 *  Verificar que est�n incluidos con CSS.
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
						"Validaci�n de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar la presencia de im�genes decorativas.",
						"Incluye im�genes decorativas con la propiedad \"background\", o los pseudo-elementos \":before\" y \":after\" de CSS.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}