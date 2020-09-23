package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH97 extends TecnicaHTML {

	public TecnicaH97(CategoriaTecnica categoriaTecnica) {
		super(
				"H97", 
				"La agrupaci�n de enlaces relacionados utilizando el elemento nav.", 
				"El objetivo de esta t�cnica es agrupar los enlaces de navegaci�n usando el elemento nav. El elemento nav es uno de los varios elementos de seccionamiento en HTML5. El uso de esta marca puede hacer grupos de enlaces mas f�ciles de localizar y pasar de largo por los usuarios de tecnolog�a de asistencia tales como los lectores de pantalla. Utilizando las estructuras sem�nticas permiten que las hojas de estilo personalizado que se utilizan para cambiar la presentaci�n de los grupos de enlaces preservando al mismo tiempo su relaci�n. Cuando el elemento nav se emplea mas de una vez en una p�gina, distinguir los grupos de navegaci�n mediante el uso del atributo aria-label o aria-labelledby. No todos los grupos de enlaces necesitan utilizar el elemento nav parra el marcado. Por ejemplo, los enlaces pueden ser agrupados en otra estructura, tales como listas.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que los enlaces que se agrupan visualmente y representan una secci�n de la p�gina est�n encerrados en un elemento nav.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionNavConMenos2Enlaces = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Elementos \"nav\" con menos de dos enlaces.",
				"Verificar que los enlaces que se agrupan visualmente y representan una secci�n de la p�gina est�n encerrados en un elemento \"nav\".",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: elemento \"nav\" para agrupar enlaces relacionados.");
		ResultadoEvaluacionTecnicaItem comprobacionNavAgrupanEnlaces = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Elementos \"nav\" agrupan enlaces relacionados.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que los enlaces que se agrupan visualmente y representan una secci�n de la p�gina est�n encerrados en un elemento \"nav\".",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: elemento \"nav\" para agrupar enlaces relacionados.");
		for (Element elementoNAV : this.getParseador().getElementos(HTMLElementName.NAV)) {
			List<Element> listaElementosA = elementoNAV.getAllElements(HTMLElementName.A);
			if (listaElementosA.size() < 2)
				comprobacionNavConMenos2Enlaces.procesar(elementoNAV);
			for (Element elementoA : listaElementosA)
				comprobacionNavAgrupanEnlaces.procesar(elementoA);
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionNavConMenos2Enlaces);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionNavAgrupanEnlaces);
		return resultadoEvaluacionTecnica;
	}

}