package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.util.List;


import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
public class TecnicaH44 extends TecnicaHTML {

	public TecnicaH44(CategoriaTecnica categoriaTecnica) {
		super(
				"H44",
				"Usar los elementos label para asociar etiquetas con los controles de formulario.",
				"El prop�sito de esta t�cnica es utilizar el elemento label para asociar expl�citamente un control de formulario con una etiqueta. Una etiqueta se asocia a un control de forma expl�cita a trav�s del atributo for. El valor del atributo for debe ser el mismo que el valor del atributo id del control de formulario. El atributo id puede tener el mismo valor que el atributo name pero ambos se deben proporcionar siempre, y el id debe ser �nico en la p�gina. Un beneficio adicional de esta t�cnica es un �rea de selecci�n m�s grande ya que al hacer clic, tanto en la etiqueta como en el control, se activar� el control. Esto puede ser �til para los usuarios con dificultades motrices. Los elementos que utilizan etiquetas asociadas expl�citamente son: 1) input (de tipo \"text\", \"checkbox\", \"radio\" o \"file\") 2) textarea 3) select.",
				categoriaTecnica);
	}

	/**
	 * Para todos los elementos input de tipo text, file o password, para todos los textarea y para todos los elementos select en la p�gina Web
	 * 1. Verificar que hay un elemento label que identifica el prop�sito del control antes del input, textarea o elemento select.
	 * 2. Verificar que el atributo for del elemento label coincide con el id del elemento input, textarea o elemento select.
	 * 3. Verificar que el elemento label est� visible.
	 * Para todos los elementos input de tipo checkbox o radio en la p�gina Web
	 * 1. Verificar que hay un elemento label que identifica el prop�sito del control despu�s del elemento input.
	 * 2. Verificar que el atributo for del elemento label coincide con el id del elemento input.
	 * 3. Verificar que el elemento label est� visible. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLabelNoIdentificaPropositoControl = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Elementos \"label\" no identifica el prop�sito del control del formulario.", 
				TipoResultadoEvaluacion.MANUAL,
				"Para todos los controles del formulario verificar que hay un elemento \"label\" que identifica el prop�sito del control.",
				"Asocia una etiqueta al control del formulario con el elemento \"label\" para identificar el prop�sito del control.");
		ResultadoEvaluacionTecnicaItem comprobacionControlFormularioSinLabel = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Controles del formulario sin etiquetar.",
				"Para todos los controles del formulario verificar que hay un elemento \"label\".",
				"Asocia una etiqueta al control del formulario con el elemento \"label\".");
		ResultadoEvaluacionTecnicaItem comprobacionControlFormularioConIDDistintoAForDelLabel = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Controles del formulario con \"id\" distinto al valor del atributo \"for\" del elemento \"label\".",
				"Para todos los controles del formulario verificar que verificar que el atributo \"for\" del elemento \"label\" coincide con el \"id\" del elemento \"input\", \"textarea\" o elemento \"select\".",
				"Aseg�rate que que el atributo \"for\" del elemento \"label\" coincide con el \"id\" del elemento \"input\", \"textarea\" o elemento \"select\".");
		ResultadoEvaluacionTecnicaItem comprobacionLabelAsociadoAlControlFormularioInvisble = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Elementos \"label\" asociado al control del formulario no visibles.",
				"Para todos los controles del formulario verificar que el elemento \"label\" est� visible.",
				"Aseg�rate que las etiquetas son visibles en todos los controles del formulario.");
		List<Element> listaElementos = this.getParseador().getElementos();
		for (int i=0; i < listaElementos.size(); i++) {
			if (listaElementos.get(i).getName().equals(HTMLElementName.INPUT)) {
				Element elementoINPUT = listaElementos.get(i);
				String atributoType = elementoINPUT.getAttributeValue("type");
				if (atributoType != null) {
					if (atributoType.matches("(text|file|password)")) {
						if (!listaElementos.get(i-1).getName().equals(HTMLElementName.LABEL)) 
							comprobacionControlFormularioSinLabel.procesar(elementoINPUT);
						else {
							Element elementoLABEL = listaElementos.get(i-1);
							if ((elementoLABEL != null) && (elementoLABEL.getAttributeValue("for") != null)){
								if (!elementoLABEL.getAttributeValue("for").equals(elementoINPUT.getAttributeValue("id"))) 
									comprobacionControlFormularioConIDDistintoAForDelLabel.procesar(elementoINPUT);
								if ((elementoLABEL.getAttributeValue("visible") != null) && (elementoLABEL.getAttributeValue("visible").equalsIgnoreCase("false"))) 
									comprobacionLabelAsociadoAlControlFormularioInvisble.procesar(elementoLABEL);
								comprobacionLabelNoIdentificaPropositoControl.procesar(elementoLABEL);
							}
						}
					}
					else
						if(atributoType.matches("(checkbox|radio)"))
							if (!listaElementos.get(i+1).getName().equals(HTMLElementName.LABEL)) 
								comprobacionControlFormularioSinLabel.procesar(elementoINPUT);
							else {
								Element elementoLABEL = listaElementos.get(i+1);
								if ((elementoLABEL != null) && (elementoLABEL.getAttributeValue("for") != null)){
									if (!elementoLABEL.getAttributeValue("for").equals(elementoINPUT.getAttributeValue("id"))) 
										comprobacionControlFormularioConIDDistintoAForDelLabel.procesar(elementoINPUT);
									if ((elementoLABEL.getAttributeValue("visible") != null) && (elementoLABEL.getAttributeValue("visible").equalsIgnoreCase("false"))) 
										comprobacionLabelAsociadoAlControlFormularioInvisble.procesar(elementoLABEL);
									comprobacionLabelNoIdentificaPropositoControl.procesar(elementoLABEL);
								}
							}
				}
			}
			if (listaElementos.get(i).getName().equals(HTMLElementName.TEXTAREA)) {
				Element elementoTEXTAREA = listaElementos.get(i);
				if (!listaElementos.get(i-1).getName().equals(HTMLElementName.LABEL)) 
					comprobacionControlFormularioSinLabel.procesar(elementoTEXTAREA);
				else {
					Element elementoLABEL = listaElementos.get(i-1);
					if ((elementoLABEL != null) && (elementoLABEL.getAttributeValue("for") != null)){
						if (!elementoLABEL.getAttributeValue("for").equals(elementoTEXTAREA.getAttributeValue("id"))) 
							comprobacionControlFormularioConIDDistintoAForDelLabel.procesar(elementoTEXTAREA);
						if ((elementoLABEL.getAttributeValue("visible") != null) && (elementoLABEL.getAttributeValue("visible").equalsIgnoreCase("false"))) 
							comprobacionLabelAsociadoAlControlFormularioInvisble.procesar(elementoLABEL);
						comprobacionLabelNoIdentificaPropositoControl.procesar(elementoLABEL);
					}
				}
			}
			if (listaElementos.get(i).getName().equals(HTMLElementName.SELECT)) {
				Element elementoSELECT = listaElementos.get(i);
				if (!listaElementos.get(i-1).getName().equals(HTMLElementName.LABEL))
					comprobacionControlFormularioSinLabel.procesar(elementoSELECT);
				else {
					Element elementoLABEL = listaElementos.get(i-1);
					if ((elementoLABEL != null) && (elementoLABEL.getAttributeValue("for") != null)){
						if (!elementoLABEL.getAttributeValue("for").equals(elementoSELECT.getAttributeValue("id"))) 
							comprobacionControlFormularioConIDDistintoAForDelLabel.procesar(elementoSELECT);
						if ((elementoLABEL.getAttributeValue("visible") != null) && (elementoLABEL.getAttributeValue("visible").equalsIgnoreCase("false"))) 
							comprobacionLabelAsociadoAlControlFormularioInvisble.procesar(elementoLABEL);
						comprobacionLabelNoIdentificaPropositoControl.procesar(elementoLABEL);
					}	
				}
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLabelNoIdentificaPropositoControl);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlFormularioSinLabel);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlFormularioConIDDistintoAForDelLabel);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLabelAsociadoAlControlFormularioInvisble);
		return resultadoEvaluacionTecnica;
	}

}