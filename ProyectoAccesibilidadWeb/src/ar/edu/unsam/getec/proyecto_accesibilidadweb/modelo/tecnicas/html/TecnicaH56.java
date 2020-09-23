package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH56 extends TecnicaHTML {

	public TecnicaH56(CategoriaTecnica categoriaTecnica) {
		super(
				"H56",
				"Usar el atributo dir en un elemento de l�nea para resolver los problemas con direcciones opuestas anidadas.",
				"El objetivo de esta t�cnica es identificar los cambios en la direcci�n del texto del texto que incluye secuencias direccionales anidadas con el atributo dir de los elementos en l�nea. Una secuencia direccional anidada es una extensi�n de texto que incluye texto direccional mixto, por ejemplo, un p�rrafo en Ingl�s que contiene una frase en hebreo citado que a su vez incluye una frase de Ingl�s. El uso del atributo dir en un span u otro elemento en l�nea puede ser necesario debido a que el algoritmo bidireccional Unicode puede producir resultados no deseados cuando el texto direccional mezclado contiene espacios o puntuacion.",
				categoriaTecnica);
	}

	/**
	 * 1. Examinar la direcci�n del texto en el documento.
	 * 2. Si la direcci�n del texto es derecha a izquierda, verificar que el elemento antecesor que tiene un atributo dir, el atributo tiene el valor "rtl".
	 * 3. Si la direcci�n del texto es izquierda a derecha, verificar que no hay elemento antecesor con un atributo dir o que para el elemento antecesor que tiene un atributo dir, el atributo tiene el valor "ltr".
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAtributoDirConValorRTL = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Direcci�n del texto derecha a izquierda con atributo \"dir\" sin valor \"rtl\".",
				"Si la direcci�n del texto es derecha a izquierda, verificar que el elemento antecesor que tiene un atributo \"dir\", el atributo tiene el valor \"rtl\".",
				"Ordena todos los contenidos de la p�gina web en un orden que tenga sentido y m�quetalos agregando el atributo \"dir\" en elementos de l�nea para resolver problemas con diferentes direcciones anidadas.");
		ResultadoEvaluacionTecnicaItem comprobacionAtributoDirConValorLTR = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Direcci�n del texto izquierda a derecha con atributo \"dir\" sin valor \"ltr\".",
				"Si la direcci�n del texto es izquierda a derecha, verificar que no hay elemento antecesor con un atributo \"dir\" o que para el elemento antecesor que tiene un atributo \"dir\", el atributo tiene el valor \"ltr\".",
				"Ordena todos los contenidos de la p�gina web en un orden que tenga sentido y m�quetalos agregando el atributo \"dir\" en elementos de l�nea para resolver problemas con diferentes direcciones anidadas.");
		List<Element> listaHTML = this.getParseador().getElementos(HTMLElementName.HTML);
		if (!listaHTML.isEmpty()) {
			Element elementoHTML = listaHTML.get(0);
			String  idioma = null;
			String atributoLang = elementoHTML.getAttributeValue("lang");
			String atributoXmlLang = elementoHTML.getAttributeValue("xml:lang");
			if ((atributoLang != null) && (!atributoLang.isEmpty())) { 
				idioma = atributoLang;
			}
			if ((atributoXmlLang != null) && (!atributoXmlLang.isEmpty())) {
				idioma = atributoXmlLang;
			}
			if ((idioma != null) && (idioma.equalsIgnoreCase("he") || idioma.equalsIgnoreCase("ar"))) 
				for (Element elemento: this.getParseador().getElementos()) {
					String atributoDir = elemento.getAttributeValue("dir");
					if ((atributoDir != null) && (!atributoDir.equalsIgnoreCase("RTL"))) 
						comprobacionAtributoDirConValorRTL.procesar(elemento);
				}
			else 
				if (idioma != null) {
					for (Element elemento: this.getParseador().getElementos()) {
						String atributoDir = elemento.getAttributeValue("dir");
						if ((atributoDir != null) && (!atributoDir.equalsIgnoreCase("LTR"))) 
							comprobacionAtributoDirConValorLTR.procesar(elemento);
					}
				}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoDirConValorRTL);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoDirConValorLTR);
		return resultadoEvaluacionTecnica;
	}

}