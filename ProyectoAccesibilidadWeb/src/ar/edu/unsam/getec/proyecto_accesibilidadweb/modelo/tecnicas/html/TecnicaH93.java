package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;

public class TecnicaH93 extends TecnicaHTML {

	public TecnicaH93(CategoriaTecnica categoriaTecnica) {
		super(
				"H93",
				"Asegurarse de que los atributos id sean �nicos en una p�gina web.", 
				"El objetivo de esta t�cnica es evitar errores clave que se sabe que causan problemas de las tecnolog�as de apoyo cuando est�n tratando de analizar el contenido que tiene el mismo atributo id en los diferentes elementos. Estos errores se pueden evitar asegur�ndose de que la p�gina web no tiene valores de ID duplicados. Esto se puede hacer manualmente o mediante el uso de mecanismo de HTML para especificar la versi�n de tecnolog�a y de la tecnolog�a, y la validaci�n del documento para esta condici�n. Hay varios validadores que el desarrollador puede utilizar; informes de validaci�n general mencionan este tipo de error. La declaraci�n de tipo de documento no es estrictamente necesario para este tipo de evaluaci�n, pero especificando la declaraci�n de tipo de documento hace que sea m�s f�cil de usar un validador.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que todos los valores del atributo id son �nico en la p�gina Web.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAtributoIDUnico = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Atributos \"id\" con valores duplicados.",
				"Verificar que todos los valores del atributo id son �nicos en la p�gina Web.",
				"Aseg�rate que cada atributo \"id\" tiene un valor diferente en la p�gina web.");
		List<String> listaID = new LinkedList<String>();
		for (Element elemento : this.getParseador().getElementos()) {
			String atributoId = elemento.getAttributeValue("id");
			if (atributoId != null) 
				if (listaID.contains(atributoId)) 
					comprobacionAtributoIDUnico.procesar(elemento);
				else
					listaID.add(atributoId);
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAtributoIDUnico);
		return resultadoEvaluacionTecnica;
	}

}