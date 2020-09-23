package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH37 extends TecnicaHTML {

	public TecnicaH37(CategoriaTecnica categoriaTecnica) {
		super(
				"H37", 
				"Usar atributos alt en los elementos img.", 
				"Al usar el elemento img, especifique una breve alternativa textual con el atributo alt. El valor de este atributo se denomina \"texto alternativo\". Cuando una imagen contiene palabras que son importantes para la comprensi�n del contenido, el texto alternativo debe incluir esas palabras. Esto permitir� que el texto alternativo cumpla la misma funci�n en la p�gina que la imagen. Tenga en cuenta que no es necesario describir las caracter�sticas visuales de la imagen en s�, sino que se debe transmitir el mismo significado que la imagen.",
				categoriaTecnica);
	}

	/**
	 * 1. Examinar cada elemento 'img' en el contenido.
	 * 2. Verificar que cada elemento 'img' que transmite significado contiene un atributo 'alt'
	 * 3. Si la imagen contiene palabras que son importantes para entender el contenido, las palabras se incluyen en el texto alternativo. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenesSinAtributoAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes sin atributo \"alt\".", 
				"Verificar que cada elemento \"img\" que transmite significado contiene un atributo \"alt\".", 
				"Utiliza el atributo \"alt\" en im�genes.");
		ResultadoEvaluacionTecnicaItem comprobacionImagenesNoTransmitenSignificado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes que no transmiten significado.", 
				TipoResultadoEvaluacion.MANUAL, 
				"Verificar que cada elemento \"img\" transmite significado.", 
				"No utilices una alternativa textual descriptiva para im�genes que deben ser ignoradas.");
		ResultadoEvaluacionTecnicaItem comprobacionImagenesConPalabrasSeIncluyenEnAtributoAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes con palabras, se incluyen en el atributo \"alt\".", 
				TipoResultadoEvaluacion.IMPOSIBLE, 
				"Si la imagen contiene palabras que son importantes para entender el contenido, las palabras se incluyen en el texto alternativo.", 
				"Incluye en el texto alternativo las palabras que est�n dentro de las im�genes.");
		for (Element elementoIMG : this.getParseador().getElementos(HTMLElementName.IMG)) {
			String atributoALT = elementoIMG.getAttributeValue("alt");
			if (atributoALT == null) 
				comprobacionImagenesSinAtributoAlt.procesar(elementoIMG);
			else 
				if (atributoALT.isEmpty()) 
					comprobacionImagenesSinAtributoAlt.procesar(elementoIMG);
			comprobacionImagenesNoTransmitenSignificado.procesar(elementoIMG);
			comprobacionImagenesConPalabrasSeIncluyenEnAtributoAlt.procesar(elementoIMG);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesSinAtributoAlt);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesNoTransmitenSignificado);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesConPalabrasSeIncluyenEnAtributoAlt);
		return resultadoEvaluacionTecnica;
	}

}