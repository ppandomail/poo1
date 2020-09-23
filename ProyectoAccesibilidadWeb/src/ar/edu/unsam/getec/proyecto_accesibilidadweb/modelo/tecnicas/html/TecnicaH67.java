package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH67 extends TecnicaHTML {

	public TecnicaH67(CategoriaTecnica categoriaTecnica) {
		super(
				"H67", 
				"El uso de alt nulo y sin atributo title en los elementos img para im�genes que AT debe ignorar.",	
				"El prop�sito de esta t�cnica es mostrar c�mo las im�genes se pueden marcar de modo que puedan ser ignorados por la tecnolog�a de asistencia. Si no se utiliza un atributo title, y el texto alternativo se establece en nulo (es decir alt = \" \" ) indica que la tecnolog�a de asistencia que la imagen puede ser ignorado.",
				categoriaTecnica);
	}

	/**
	 * Para cada imagen:
	 * 1. Verificar que el atributo title est� ausente o vac�o.
	 * 2. Verificar que el atributo alt est� presente o vac�o.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenesConAltVacio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes con atributo \"alt\" vac�o.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el atributo \"alt\" est� presente o vac�o.",
				"Si las im�genes deben ser ignoradas por los productos de apoyo deja el atributo \"alt\" vac�o.");
		for (Element elementoIMG : this.getParseador().getElementos(HTMLElementName.IMG)) {
			String atributoAlt = elementoIMG.getAttributeValue("alt");
			if ((atributoAlt != null) && (atributoAlt.isEmpty())) 
				comprobacionImagenesConAltVacio.procesar(elementoIMG);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesConAltVacio);
		return resultadoEvaluacionTecnica;
	}

}