package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Tag;

public class TecnicaH48 extends TecnicaHTML {

	public TecnicaH48(CategoriaTecnica categoriaTecnica) {
		super(
				"H48",
				"Usar ol, ul y dl para las listas",
				"El prop�sito de esta t�cnica es crear listas de elementos relacionados utilizando los elementos de lista apropiados. El elemento ol se usa cuando la lista est� ordenada y el elemento ul se utiliza cuando la lista no est� ordenada. Las listas de definiciones (dl) se usan para agrupar t�rminos con sus definiciones. Cuando se utiliza un marcado que da formato visual a los elementos como una lista pero no indica la relaci�n entre los elementos, los usuarios pueden tener dificultades para navegar la informaci�n. Un ejemplo de este formato visual es incluir asteriscos al principio de cada elemento de la lista y usar <br> para separar los elementos.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que el contenido que tiene la apariencia visual de una lista se marca como una lista desordenada.
	 * 2. Verificar que el contenido que tiene la apariencia visual de una lista numerada se marca como una lista ordenada.
	 * 3. Verificar que el contenido est� marcado como una lista de definici�n cuando los t�rminos y sus definiciones se presentan en forma de una lista.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAparienciaVisualListaMarcarListaDesordenada = new ResultadoEvaluacionTecnicaItem(
				Tipologia.LISTAS, 
				"Contenido con apariencia visual de lista marcada como una lista desordenada.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el contenido que tiene la apariencia visual de una lista se marca como una lista desordenada.",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: los elementos \"ol\", \"ul\" y \"dl\" para listas.");
		ResultadoEvaluacionTecnicaItem comprobacionAparienciaVisualListaNumeradaMarcarListaOrdenada = new ResultadoEvaluacionTecnicaItem(
				Tipologia.LISTAS, 
				"Contenido con apariencia visual de lista numerada marcada como una lista ordenada.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el contenido que tiene la apariencia visual de una lista numerada se marca como una lista ordenada.",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: los elementos \"ol\", \"ul\" y \"dl\" para listas.");
		ResultadoEvaluacionTecnicaItem comprobacionElementoLIFueraDeLista = new ResultadoEvaluacionTecnicaItem(
				Tipologia.LISTAS, 
				"Elemento \"li\" usado fuera de elemento \"ol\" o \"ul\".",
				"Verificar que el elemento \"li\" no es usado fuera de elemento \"ol\" o \"ul\".",
				"Comunica la informaci�n y sus relaciones mediantes la estructura de la p�gina web: los elementos \"ol\", \"ul\" y \"dl\" para listas.");
		for (Tag tag : this.getParseador().getEtiquetasInicio()) {
			if (tag.getName().equalsIgnoreCase(HTMLElementName.LI)) {
				Element parentElement = tag.getElement().getParentElement();
				if (parentElement != null && !parentElement.getName().equalsIgnoreCase(HTMLElementName.UL) && !parentElement.getName().equalsIgnoreCase(HTMLElementName.OL)) 
					comprobacionElementoLIFueraDeLista.procesar(tag.getElement());
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAparienciaVisualListaMarcarListaDesordenada);	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAparienciaVisualListaNumeradaMarcarListaOrdenada);	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionElementoLIFueraDeLista);	
		return resultadoEvaluacionTecnica;
	}

}