package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH51 extends TecnicaHTML {

	public TecnicaH51(CategoriaTecnica categoriaTecnica) {
		super(
				"H51", 
				"Usar tablas para presentar informaci�n tabular.",
				"El prop�sito de esta t�cnica es presentar informaci�n tabular de una manera que preserve las relaciones dentro de la informaci�n, incluso cuando los usuarios no puedan ver la tabla o el formato de presentaci�n es cambiado. La informaci�n se considera tabular cuando existen relaciones l�gicas entre texto, n�meros, im�genes u otros datos en dos dimensiones (vertical y horizontal). Estas relaciones son representadas en columnas y filas, y las columnas y las filas deben ser reconocibles a fin de que las relaciones l�gicas puedan ser percibidas. Utilizando el elemento table con los elementos hijos tr, th y td hace que estas relaciones resulten perceptibles. T�cnicas tales como el uso de tabuladores para crear columnas o usar el elemento pre son puramente visuales y las relaciones l�gicas impl�citas visualmente se pierden si el usuario no puede ver la tabla o se cambia la presentaci�n visual. Aunque las WCAG no proh�ben el uso de tablas para maquetar, se recomienda usar dise�os basados en CSS para conservar el sentido sem�ntica del elemento table definido en HTML y XHTML, y para cumplir con la pr�ctica de separar la presentaci�n del contenido.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar la presencia de informaci�n tabular.
	 * 2. Para cada ocurrencia de informaci�n tabular:
	 * 		a. Verificar que la tabla est� marcada con un m�nimo de elementos de la tabla, tr, th y td se utiliza.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTablaSinFilas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin filas (\"tr\").",
				"Verificar que la tabla est� marcada con un m�nimo de elementos \"tr\" de la tabla.",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionTablaSinCeldasEncabezado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin celdas de encabezado (\"th\").",
				"Verificar que la tabla est� marcada con un m�nimo de elementos \"th\" de la tabla.",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionTablaSinCeldas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin celdas (\"td\").",
				"Verificar que la tabla est� marcada con un m�nimo de elementos \"td\" de la tabla.",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos.");
		for (Element elementoTABLE : this.getParseador().getElementos(HTMLElementName.TABLE)) {
			if (elementoTABLE.getAllElements(HTMLElementName.TR).isEmpty()) 
				comprobacionTablaSinFilas.procesar(elementoTABLE);
			if (elementoTABLE.getAllElements(HTMLElementName.TH).isEmpty()) 
				comprobacionTablaSinCeldasEncabezado.procesar(elementoTABLE);
			if (elementoTABLE.getAllElements(HTMLElementName.TD).isEmpty()) 
				comprobacionTablaSinCeldas.procesar(elementoTABLE);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaSinFilas); 
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaSinCeldasEncabezado); 
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaSinCeldas); 
		return resultadoEvaluacionTecnica;
	}

}