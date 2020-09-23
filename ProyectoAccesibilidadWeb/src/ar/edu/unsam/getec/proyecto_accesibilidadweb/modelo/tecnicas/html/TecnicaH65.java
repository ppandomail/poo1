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

public class TecnicaH65 extends TecnicaHTML {

	public TecnicaH65(CategoriaTecnica categoriaTecnica) {
		super(
				"H65",
				"Usar el atributo title para identificar los controles de formulario cuando no se pueda usar el elemento label.",
				"Los elementos label permiten asociar una etiqueta de texto con los controles de formulario para brindar informaci�n sobre los controles. El prop�sito de esta t�cnica es utilizar el atributo title para etiquetar los controles de formulario cuando el dise�o visual no permite acomodar la etiqueta o cuando puede resultar confuso mostrar una etiqueta. Las aplicaciones de usuario, incluyendo las ayudas t�cnicas, pueden leer el atributo title que reemplaza la funci�n de label.",
				categoriaTecnica);
	}

	/**
	 * 1. Identificar cada control del formulario que no est� asociado con un elemento label.
	 * 2. Verificar que el control tiene un atributo title.
	 * 3. Verificar que el atributo title identifica el prop�sito del control.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionControlesFormularioSinEtiquetar = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Controles del formulario sin etiquetar.",
				"Verificar que el control tiene un atributo \"title\".",
				"Identifica el control del formulario con el atributo \"title\".");
		ResultadoEvaluacionTecnicaItem comprobacionAtributoTitleNoIdentificaPropositoControl = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Atributo \"title\" no identifica el prop�sito del control.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el atributo \"title\" identifica el prop�sito del control.",
				"Aseg�rate que el atributo \"title\" identifica el prop�sito del control.");
		List<Element> listaElementos = this.getParseador().getElementos();
		for (int i=1; i < listaElementos.size(); i++) {
			if (listaElementos.get(i).getName().equals(HTMLElementName.INPUT)) {
				Element elementoINPUT = listaElementos.get(i);
				String atributoType = elementoINPUT.getAttributeValue("type");
				String atributoTitle = elementoINPUT.getAttributeValue("title");
				if ((atributoType != null) && (atributoType.matches("(text|file|password)"))) {
					if (!listaElementos.get(i-1).getName().equals(HTMLElementName.LABEL)) {
						if (atributoTitle == null) 
							comprobacionControlesFormularioSinEtiquetar.procesar(elementoINPUT);
						else
							if (atributoTitle.isEmpty()) 
								comprobacionControlesFormularioSinEtiquetar.procesar(elementoINPUT);
							else 
								comprobacionAtributoTitleNoIdentificaPropositoControl.procesar(elementoINPUT);
					}
				}	
				else
					if ((atributoType != null) && (atributoType.matches("(checkbox|radio)"))) {
						if (!listaElementos.get(i+1).getName().equals(HTMLElementName.LABEL)) {
							if (atributoTitle == null) 
								comprobacionControlesFormularioSinEtiquetar.procesar(elementoINPUT);
							else
								if (atributoTitle.isEmpty()) 
									comprobacionControlesFormularioSinEtiquetar.procesar(elementoINPUT);
								else 
									comprobacionAtributoTitleNoIdentificaPropositoControl.procesar(elementoINPUT);
						}					
					}
			}
			if (listaElementos.get(i).getName().equals(HTMLElementName.TEXTAREA)) {
				Element elementoTEXTAREA = listaElementos.get(i);
				String atributoTitle = elementoTEXTAREA.getAttributeValue("title");
				if (!listaElementos.get(i-1).getName().equals(HTMLElementName.LABEL)){
					if (atributoTitle == null)
						comprobacionControlesFormularioSinEtiquetar.procesar(elementoTEXTAREA);
					else
						if (atributoTitle.isEmpty()) 
							comprobacionControlesFormularioSinEtiquetar.procesar(elementoTEXTAREA);
						else 
							comprobacionAtributoTitleNoIdentificaPropositoControl.procesar(elementoTEXTAREA);
				}
			}
			if (listaElementos.get(i).getName().equals(HTMLElementName.SELECT)) {
				Element elementoSELECT = listaElementos.get(i);
				String atributoTitle = elementoSELECT.getAttributeValue("title");
				if (!listaElementos.get(i-1).getName().equals(HTMLElementName.LABEL)){
					if (atributoTitle == null) 
						comprobacionControlesFormularioSinEtiquetar.procesar(elementoSELECT);
					else
						if (atributoTitle.isEmpty()) 
							comprobacionControlesFormularioSinEtiquetar.procesar(elementoSELECT);
						else 
							comprobacionAtributoTitleNoIdentificaPropositoControl.procesar(elementoSELECT);
				}
			}
		}		
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlesFormularioSinEtiquetar);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoTitleNoIdentificaPropositoControl);
		return resultadoEvaluacionTecnica;
	}

}