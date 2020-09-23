package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH71 extends TecnicaHTML {

	public TecnicaH71(CategoriaTecnica categoriaTecnica) {
		super(
				"H71",
				"Proporcionar una descripci�n de los grupos de controles de formulario usando los elementos fieldset y legend.",
				"El prop�sito de esta t�cnica es proporcionar una agrupaci�n sem�ntica para los controles de formulario relacionados. Esto permite a los usuarios entender la relaci�n de los controles e interact�ar con el formulario m�s r�pida y eficazmente. Los controles de formulario se pueden agrupar encerr�ndolos en el elemento fieldset. Todos los controles dentro de un fieldset quedan entonces relacionados. El primer elemento dentro de fieldset debe ser un elemento legend, que proporciona una etiqueta o descripci�n del grupo. La agrupaci�n de los controles es m�s importante para los botones radio y checkbox cuando los botones representan los valores de un mismo campo de env�o. Tambi�n puede ser �til para agrupar otros conjuntos de controles menos estrechamente relacionados que los botones radio y checkbox. Como regla general, se puede decir que, cuando un grupo de controles dentro de un formulario, requiere un encabezado adicional para proporcionar una descripci�n espec�fica de ese grupo, el uso de fieldset y legend es apropiado.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que el grupo de elementos input o select relacionados logicamente est�n contenidos dentro de elementos fieldset.
	 * 2. Verificar que cada fieldset tiene un elemento legend que incluye una descripci�n de ese grupo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionGrupoElementosInputSelectRelacionadosLogicamente = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Grupo de elementos \"input\" o \"select\" no relacionados logicamente.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el grupo de elementos \"input\" o \"select\" relacionados logicamente est�n contenidos dentro de elementos \"fieldset\".",
				"Describe los grupos de campos usando los elementos \"fieldset\" y \"legend\".");
		ResultadoEvaluacionTecnicaItem comprobacionFieldsetSinLegend = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Elementos \"fieldset\" sin elementos \"legend\".",
				"Verificar que cada elemento \"fieldset\" tiene un elemento \"legend\" que incluye una descripci�n de ese grupo.",
				"Describe los grupos de campos usando los elementos \"fieldset\" y \"legend\".");
		for (Element elementoFIELDSET : this.getParseador().getElementos(HTMLElementName.FIELDSET)) { 
			Element elementoLEGEND = Parseador.getElemento(elementoFIELDSET.getChildElements(), HTMLElementName.LEGEND);
			if (elementoLEGEND == null) 
				comprobacionFieldsetSinLegend.procesar(elementoFIELDSET);
			else
				if (elementoLEGEND.getTextExtractor().toString().isEmpty())
					comprobacionFieldsetSinLegend.procesar(elementoFIELDSET);
			comprobacionGrupoElementosInputSelectRelacionadosLogicamente.procesar(elementoFIELDSET);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionGrupoElementosInputSelectRelacionadosLogicamente);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFieldsetSinLegend);
		return resultadoEvaluacionTecnica;
	}

}