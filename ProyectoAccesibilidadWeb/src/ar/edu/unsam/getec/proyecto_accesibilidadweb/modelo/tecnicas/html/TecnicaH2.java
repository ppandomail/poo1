package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;


import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH2 extends TecnicaHTML {

	public TecnicaH2(CategoriaTecnica categoriaTecnica) {
		super(
				"H2",
				"Combinar la imagen y el texto adyacentes cuando enlazan con el mismo recurso.",
				"Proporcionar el texto y los �conos de enlaces sin hacer que la p�gina web sea m�s confusa o dif�cil para los usuarios de teclado o usuarios de tecnolog�a de asistencia. Debido a que diferentes usuarios la b�squeda de texto e iconos m�s f�cil de usar, proporcionando ambos pueden mejorar la accesibilidad del enlace.",
				categoriaTecnica);
	}

	/**
	 * Para cada 'a'
	 * 1. Verificar que cada elemento 'img' contenido dentro del elemento 'a' tiene un valor nulo seteado para su atributo 'alt'.
	 * 2. Verificar que el elemento 'a' contiene un elemento 'img' que tiene o un valor del atributo 'alt' nulo o un valor que complementa el texto del enlace y describe la imagen. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenesEnASinAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes dentro del elemento \"a\" sin atributo \"alt\".", 
				"Para cada elemento \"a\": Verificar que cada elemento \"img\" contenido dentro del elemento \"a\" no tiene un valor nulo seteado para su atributo \"alt\".",
				"Uiliza el atributo \"alt\" en im�genes dentro del elemento \"a\".");
		ResultadoEvaluacionTecnicaItem comprobacionImagenesEnAConAltDistintoATextoA = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Imágenes dentro del elemento \"a\" con atributo \"alt\" distinto a texto de \"a\".",
				"Para cada elemento \"a\":  Verificar que el elemento \"a\" contiene un elemento \"img\" que tiene o un valor del atributo \"alt\" nulo o un valor que complementa el texto del enlace y describe la imagen.",
				"Utiliza el atributo \"alt\" en imágenes dentro del elemento \"a\" para complementar el texto del enlace y de esa forma describir la imagen.");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A)) {
			for (Element elementoIMG : elementoA.getAllElements(HTMLElementName.IMG)) {
				String atributoAlt = elementoIMG.getAttributeValue("alt");
				if (atributoAlt == null) 
					comprobacionImagenesEnASinAlt.procesar(elementoIMG);
				else
					if(atributoAlt.equals(elementoA.getTextExtractor().toString()))
						comprobacionImagenesEnAConAltDistintoATextoA.procesar(elementoIMG);
			}	
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesEnASinAlt);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesEnAConAltDistintoATextoA);
		return resultadoEvaluacionTecnica;
	}

}