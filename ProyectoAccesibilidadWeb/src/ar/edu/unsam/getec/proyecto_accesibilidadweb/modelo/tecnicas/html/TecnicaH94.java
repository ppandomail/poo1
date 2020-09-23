package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.StartTag;

public class TecnicaH94 extends TecnicaHTML {

	public TecnicaH94(CategoriaTecnica categoriaTecnica) {
		super(
				"H94",
				"Asegurarse de que los elementos no contienen atributos duplicados.", 
				"El objetivo de esta t�cnica es evitar errores clave que se sabe que causan problemas de las tecnolog�as de apoyo cuando est�n tratando de analizar el contenido que tiene atributos duplicados en el mismo elemento. Esto se puede comprobar de forma manual, o utilizando el mecanismo del HTML para especificar la versi�n de la tecnolog�a y la tecnolog�a y la validaci�n del documento para esta condici�n. Hay varios validadores que el desarrollador puede utilizar; informes de validaci�n general mencionan este tipo de error. La declaraci�n de tipo de documento no es estrictamente necesario para este tipo de evaluaci�n, pero especificando la declaraci�n de tipo de documento hace que sea m�s f�cil de usar un validador.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que ning�n atributo aparece m�s de una vez en cualquier elemento.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionElementosConAtributosDuplicados = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Elementos con atributos duplicados.",
				"Verificar que ning�n atributo aparece m�s de una vez en cualquier elemento.",
				"Aseg�rate que los elementos no tienen atributos repetidos.");
		List<String> listaAtributos = new LinkedList<String>();
		for (StartTag elemento : this.getParseador().getEtiquetasInicio()) {
			if (elemento.getAttributes() != null) {
				for (Attribute atributo : elemento.getAttributes()) {
					if (listaAtributos.contains(atributo.getKey())) 
						comprobacionElementosConAtributosDuplicados.procesar(atributo);
					else
						listaAtributos.add(atributo.getKey());
				}
				listaAtributos.clear();
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionElementosConAtributosDuplicados);
		return resultadoEvaluacionTecnica;
	}

}