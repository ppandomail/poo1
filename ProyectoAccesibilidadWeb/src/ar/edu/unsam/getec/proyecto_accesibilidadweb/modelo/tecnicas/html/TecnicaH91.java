package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH91 extends TecnicaHTML {

	public TecnicaH91(CategoriaTecnica categoriaTecnica) {
		super(
				"H91",
				"Usar controles de formulario y enlaces HTML.", 
				"El objetivo de esta t�cnica es usar controles de formulario y enlaces HTML para proporcionar el funcionamiento del teclado y la interoperabilidad de tecnolog�a asistida de los elementos de interfaces de usuario interactiva.",
				categoriaTecnica);
	}

	/**
	 * 1. Inspeccionar el c�digo fuente del HTML.
	 * 2. Por cada instancia de elementos de enlace y formulario, verificar que el nombre, valor y estado son especificado correctamente.
	 *    <a> Atributo 'title', texto dentro de  elemento a o atributo 'alt' si v�nculo de la imagen. Concatenan si se proporcionan tanto el texto y la imagen atributo 'alt'.
	 *    <button> Texto dentro del elemento button o atributo "t�tulo".
	 *    <fieldset> Texto dentro del elemento legend dentro del elemento fieldset.
	 *    <input type = "button", "submit", or "reset"> atributo value.
	 *    <input type = "image"> atributo alt o atributo title.
	 *    <input type = "text">  elemento label asociado con �l o atributo title.
	 *    <input type = "password"> elemento label asociado con �l o atributo title.
	 *    <input type="file">  elemento label asociado con �l o atributo title.
	 *    <input type="checkbox"> elemento label asociado con �l o atributo title.
	 *    <input type="radio"> elemento label asociado con �l o atributo title.
	 *    <select> elemento label asociado con �l o atributo title.
	 *    <textarea> elemento label asociado con �l o atributo title.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaces = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Enlaces.",
				"Por cada instancia de elementos de enlace y formulario, verificar que el nombre, valor y estado son especificado correctamente.",
				"Emplea los atributos \"role\", \"state\" y \"value\" si quieres que los elementos est�ticos de la interfaz de usuario se comporten como componentes interactivos en XHTML; y agrega acciones accesibles por teclado para elementos est�ticos en HTML.");
		ResultadoEvaluacionTecnicaItem comprobacionBotonesFormularios = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Botones de formulario.",
				"Por cada instancia de elementos de enlace y formulario, verificar que el nombre, valor y estado son especificado correctamente.",
				"Emplea los atributos \"role\", \"state\" y \"value\" si quieres que los elementos est�ticos de la interfaz de usuario se comporten como componentes interactivos en XHTML; y agrega acciones accesibles por teclado para elementos est�ticos en HTML.");
		ResultadoEvaluacionTecnicaItem comprobacionGroupingFormularios = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Grupos de formulario.",
				"Por cada instancia de elementos de enlace y formulario, verificar que el nombre, valor y estado son especificado correctamente.",
				"Emplea los atributos \"role\", \"state\" y \"value\" si quieres que los elementos est�ticos de la interfaz de usuario se comporten como componentes interactivos en XHTML; y agrega acciones accesibles por teclado para elementos est�ticos en HTML.");
		ResultadoEvaluacionTecnicaItem comprobacionImagenesFormularios = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Imagenes de formulario.",
				"Por cada instancia de elementos de enlace y formulario, verificar que el nombre, valor y estado son especificado correctamente.",
				"Emplea los atributos \"role\", \"state\" y \"value\" si quieres que los elementos est�ticos de la interfaz de usuario se comporten como componentes interactivos en XHTML; y agrega acciones accesibles por teclado para elementos est�ticos en HTML.");
		ResultadoEvaluacionTecnicaItem comprobacionTextosFormularios = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Textos de formulario.",
				"Por cada instancia de elementos de enlace y formulario, verificar que el nombre, valor y estado son especificado correctamente.",
				"Emplea los atributos \"role\", \"state\" y \"value\" si quieres que los elementos est�ticos de la interfaz de usuario se comporten como componentes interactivos en XHTML; y agrega acciones accesibles por teclado para elementos est�ticos en HTML.");
		ResultadoEvaluacionTecnicaItem comprobacionSeleccionesFormularios = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Selecciones de formulario.",
				"Por cada instancia de elementos de enlace y formulario, verificar que el nombre, valor y estado son especificado correctamente.",
				"Emplea los atributos \"role\", \"state\" y \"value\" si quieres que los elementos est�ticos de la interfaz de usuario se comporten como componentes interactivos en XHTML; y agrega acciones accesibles por teclado para elementos est�ticos en HTML.");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A)) {
			if ((elementoA.getAttributeValue("title") == null) && (elementoA.getAttributeValue("alt") == null) && (elementoA.getTextExtractor().toString().isEmpty()))
				comprobacionEnlaces.procesar(elementoA);
			String atributoHref = elementoA.getAttributeValue("href");
			if (atributoHref == null) 
				comprobacionEnlaces.procesar(elementoA);
			else
				if (atributoHref.isEmpty())
					comprobacionEnlaces.procesar(elementoA);
		}
		for (Element elementoButton : this.getParseador().getElementos(HTMLElementName.BUTTON)) {
			if ((elementoButton.getAttributeValue("title") == null) && (elementoButton.getTextExtractor().toString().isEmpty())) 
				comprobacionBotonesFormularios.procesar(elementoButton);
		}
		for (Element elementoFieldset : this.getParseador().getElementos(HTMLElementName.FIELDSET)) {
			for (Element elementoLegend : elementoFieldset.getAllElements(HTMLElementName.LEGEND)) {
				if (elementoLegend.getTextExtractor().toString().isEmpty())
					comprobacionGroupingFormularios.procesar(elementoLegend);
			}
		}
		for (Element elementoInput : this.getParseador().getElementos(HTMLElementName.INPUT)) {
			String atributoType = elementoInput.getAttributeValue("type");
			if (atributoType != null) {
				if (atributoType.matches("(button|submit|resert)")) {
					String atributoValue = elementoInput.getAttributeValue("value");			
					if (atributoValue == null)
						comprobacionBotonesFormularios.procesar(elementoInput);
					else
						if (atributoValue.isEmpty())
							comprobacionBotonesFormularios.procesar(elementoInput);
				}
				if (atributoType.equals("image")) {
					if ((elementoInput.getAttributeValue("title") == null) && (elementoInput.getAttributeValue("alt") == null))
						comprobacionImagenesFormularios.procesar(elementoInput);
				}
				if (atributoType.matches("(text|password|file)")) {
					if (elementoInput.getAttributeValue("title") == null)
						comprobacionTextosFormularios.procesar(elementoInput);
					String atributoValue = elementoInput.getAttributeValue("value");			
					if (atributoValue == null)
						comprobacionTextosFormularios.procesar(elementoInput);
					else
						if (atributoValue.isEmpty())
							comprobacionTextosFormularios.procesar(elementoInput);
				}
				if (atributoType.matches("(checkbox|radio)")) {
					if (elementoInput.getAttributeValue("title") == null)
						comprobacionBotonesFormularios.procesar(elementoInput);
				}
			}
		}
		for (Element elementoSelect : this.getParseador().getElementos(HTMLElementName.SELECT)) {
			if (elementoSelect.getAttributeValue("title") == null)
				comprobacionSeleccionesFormularios.procesar(elementoSelect);
			Boolean flagSelected = Boolean.FALSE;
			for (Element elementoOpcion : elementoSelect.getAllElements(HTMLElementName.OPTION)) {
				String atributoSelected = elementoOpcion.getAttributeValue("selected");
				if ((atributoSelected != null) && (atributoSelected.equals("selected")))
					flagSelected = Boolean.TRUE;
			}
			if (flagSelected == Boolean.FALSE)
				comprobacionSeleccionesFormularios.procesar(elementoSelect);
		}
		for (Element elementoTextArea : this.getParseador().getElementos(HTMLElementName.TEXTAREA)) {
			if (elementoTextArea.getAttributeValue("title") == null)
				comprobacionTextosFormularios.procesar(elementoTextArea);
			if (elementoTextArea.getTextExtractor().toString().isEmpty())
				comprobacionTextosFormularios.procesar(elementoTextArea);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlaces);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBotonesFormularios);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionGroupingFormularios);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenesFormularios);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextosFormularios);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSeleccionesFormularios);
		return resultadoEvaluacionTecnica;
	}

}