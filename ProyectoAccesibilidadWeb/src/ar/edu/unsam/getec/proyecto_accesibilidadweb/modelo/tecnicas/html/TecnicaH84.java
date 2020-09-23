package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH84 extends TecnicaHTML {

	public TecnicaH84(CategoriaTecnica categoriaTecnica) {
		super(
				"H84",
				"Usar un bot�n con un elemento select para realizar una acci�n.", 
				"El objetivo de esta t�cnica es permitir al usuario controlar cuando se realiza una acci�n, en lugar que la acci�n ocurra como un efecto secundario de la elecci�n de un valor para el elemento select. El usuario puede inspeccionar los diferentes valores del elemento select, o puede optar por error el valor incorrecto, sin causar la acci�n que se produzca. Cuando el usuario est� satisfecho con su elecci�n, seleccionan el bot�n para realizar la acci�n. Esto es particularmente importante para los usuarios que est�n eligiendo el valor del elemento select a trav�s del teclado, ya que navegar por las opciones del elemento select cambia el valor del control.",
				categoriaTecnica);
	}

	/**
	 * Por cada combinaci�n de elemento select / elemento button:
	 * 1. Verificar que el foco en una opci�n en el elemento select no da lugar a ninguna acci�n.
	 * 2. Verificar que la selecci�n del bot�n realiza la acci�n asociada con el valor actual del select.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCambiosCausadosPorElEventoOnChangeEnSelector = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Cambios causados por el evento \"onChange\" en un selector.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Por cada combinaci�n de elemento \"select\" / elemento \"button\": Verificar que el foco en una opci�n en el elemento \"select\" no da lugar a ninguna acci�n.",
				"Si un cambio en un control de formulario causa un cambio de contexto, describe antes qu� suceder�. No abras una vetana nueva -sin antes avisar- cuando cambia el estado de un bot�n de radio, una casilla de verificaci�n o una lista de selecci�n.");
		for (Element elementoSELECT : this.getParseador().getElementos(HTMLElementName.SELECT)) {
			String atributoOnchange = elementoSELECT.getAttributeValue("onchange");
			if ((atributoOnchange != null) && (!atributoOnchange.isEmpty())) 
				comprobacionCambiosCausadosPorElEventoOnChangeEnSelector.procesar(elementoSELECT);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCambiosCausadosPorElEventoOnChangeEnSelector);
		return resultadoEvaluacionTecnica;
	}

}