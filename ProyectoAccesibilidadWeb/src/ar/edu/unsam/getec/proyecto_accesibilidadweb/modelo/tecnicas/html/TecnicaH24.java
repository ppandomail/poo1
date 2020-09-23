package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;


import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH24 extends TecnicaHTML {

	public TecnicaH24(CategoriaTecnica categoriaTecnica) {
		super(
				"H24", 
				"Proporcionar alternativas textuales para los elementos area de los mapas de imagen",
				"El prop�sito de esta t�cnica es proporcionar alternativas textuales que sirvan al mismo prop�sito que las regiones seleccionables de un mapa de imagen. Un mapa de imagen es una imagen dividida en regiones seleccionables definidas por los elementos area. Cada area es un enlace a otra p�gina Web o a otra parte de la p�gina Web actual. El atributo alt de cada elemento area sirve al mismo prop�sito que el area seleccionable de la imagen.",
				categoriaTecnica);
	}

	/**
	 * Por cada elemento 'area' en un mapa de imagen:
	 * 1. Verificar que el elemento 'area' tiene un atributo 'alt'
	 * 2. Verificar que el texto alternativo especificado por el atributo 'alt' sirve al mismo prop�sito que la parte de imagen de mapa de imagen de referenciada por el elemento 'area' del mapa de imagen  
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAreaMapasDeImagenSinAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Elementos \"area\" de los mapas de imagen sin atributo \"alt\".",
				"Por cada elemento \"area\" en un mapa de imagen: Verificar que el elemento \"area\" tiene un atributo \"alt\".",
				"Ofrece una alternativa textual para las \"area\" de los mapas de im�genes.");
		ResultadoEvaluacionTecnicaItem comprobacionAreaEnMapConAltConIgualProposito = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Elementos \"area\" de los mapas de imagen con atributo \"alt\" sin prop�sito que la parte de imagen de mapa.", 
				TipoResultadoEvaluacion.MANUAL,
				"Por cada elemento \"area\" en un mapa de imagen: Verificar que el texto alternativo especificado por el atributo \"alt\" sirve al mismo prop�sito que la parte de imagen de mapa de imagen de referenciada por el elemento \"area\" del mapa de imagen.",
				"Aseg�rate que el texto alternativo especificado por el atributo \"alt\" sirve al mismo prop�sito que la parte de imagen de mapa de imagen de referenciada por el elemento \"area\" del mapa de imagen.");
		for (Element elementoMAP : this.getParseador().getElementos(HTMLElementName.MAP)) {
			for (Element elementoAREA : elementoMAP.getAllElements(HTMLElementName.AREA)) {
				String atributoAlt = elementoAREA.getAttributeValue("alt"); 
				if (atributoAlt == null) 
					comprobacionAreaMapasDeImagenSinAlt.procesar(elementoAREA);
				else {
					if (atributoAlt.isEmpty()) 	
						comprobacionAreaMapasDeImagenSinAlt.procesar(elementoAREA);
					comprobacionAreaEnMapConAltConIgualProposito.procesar(elementoAREA);
				}	
			}
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAreaMapasDeImagenSinAlt);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAreaEnMapConAltConIgualProposito);
		return resultadoEvaluacionTecnica;
	}

}