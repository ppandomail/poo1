package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH85 extends TecnicaHTML {

	public TecnicaH85(CategoriaTecnica categoriaTecnica) {
		super(
				"H85",
				"Usar OPTGROUP para agrupar los elementos OPTION dentro de un SELECT.",
				"El objetivo de esta t�cnica es agrupar items en una lista de selecci�n. Una lista de selecci�n es un conjunto de valores permitidos para un control de un formulario tales como una lista de selecci�n m�ltiple o un combo. A menudo las listas de selecci�n tienen grupos de opciones relacionados. Estos grupos deber�an ser identitificados semanticamente, en lugar de simplemente delimitar los grupos con opciones de la lista \"dummy\". Esto permite a los agentes de usuario colapsar las opciones por grupos para apoyar el skimming mas r�pido de las opciones e indicar en que grupo una opci�n de inter�s se encuentra. Tambi�n ayuda a romper visualmente las listas largas de manera que los usuarios pueden localizar m�s f�cilmente las opciones que les interesan. En HTML el elemento select es usado para crear tanto listas de selecci�n m�ltiple como combo de opciones. Las distintas opciones permitidas son indicadas con elementos option. Para agrupar opciones juntas, use el elemento optgroup, con los elementos option relacionados dentro del elemento. Etiquetar el grupo con el atributo label para que los usuarios conoscan que esperan dentro del grupo. El elemento optgroup debe estar directamente dentro del elemento select y los elementos option directemente dentro del optgroup. Es posible que un elemento select contenga ambos elementos option y grupos optgroup, aunque los autores deber�an considerar si este es, de hecho, la intenci�n deseada cuando se utiliza este. No es anidar el elemento optgroup, por lo que solo un nivel de agrupaci�n puede hacerse dentro de un select. Si el agrupamiento de informaci�n es esencial para comprender la lista, los autores pueden definir etiquetas option que pueden entender incluso cuando el lector de pantalla no presenta la informaci�n agrupada proporcionada por el optgroup.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que el conjunto de opciones dentro de una lista de selecci�n para ver si hay grupo de opciones relacionadas.
	 * 2. Si existen grupos de opciones relacionadas deben ser agrupadas con optgroup. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOpcionesMenusSeleccionAgrupadas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Opciones de los men�s de selecci�n agrupadas.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el conjunto de opciones dentro de una lista de selecci�n para ver si hay grupo de opciones relacionadas, si existen grupos de opciones relacionadas deben ser agrupadas con el atributo \"optgroup\".",
				"Comunica la informaci�n y sus relaciones mediantes formularios: el atributo \"optgroup\" para agrupar elementos \"option\" dentro de un elemento \"select\".");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) 
			for (Element elementoSELECT : elementoFORM.getAllElements(HTMLElementName.SELECT)) 
				comprobacionOpcionesMenusSeleccionAgrupadas.procesar(elementoSELECT);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOpcionesMenusSeleccionAgrupadas);
		return resultadoEvaluacionTecnica;
	}

}