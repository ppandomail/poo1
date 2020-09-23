package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH63 extends TecnicaHTML {

	public TecnicaH63(CategoriaTecnica categoriaTecnica) {
		super(
				"H63",
				"Usar el atributo scope para asociar celdas de encabezado y celdas de datos en las tablas de datos.",
				"El objetivo de esta t�cnica es asociar las celdas de encabezado con las celdas de datos en tablas complejas usando en atributo scope. El atributo scope puede utilizarse para aclarar el alcance de cualquier celda usada como un header. El alcance identifica si la celda es el encabezado de una fila, colummna o grupo de filas o columnas. Los valores row, col, rowgroup y colgroup identifican estos �mbitos posibles, respectivamente.",
				categoriaTecnica);
	}

	/**
	 * Para cada tabla de datos:
	 * 1. Verificar que todos los elementos th tienen un atributo scope.
	 * 2. Verificar que todos los elementos td que actuan como headers para otros elementos tienen un atributo scope.
	 * 3. Verificar que todos los atribtuos scope tienen el valor row, rowgroup o colgroup.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTHSinScope = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Elementos \"th\" sin atributos \"scope\".",
				"Para cada tabla de datos: Verificar que todos los elementos \"th\" tienen un atributo \"scope\".",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos: el atributo \"scope\" para asociar celdas de encabezado con celdas de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionValoresScope = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Atributos \"scope\" con valores desconocidos.",
				"Para cada tabla de datos: Verificar que todos los atributos \"scope\" tienen el valor \"row\", \"rowgroup\" o \"colgroup\".",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos: el atributo \"scope\" para asociar celdas de encabezado con celdas de datos.");
		for (Element elementoTH : this.getParseador().getElementos(HTMLElementName.TH)) {
			String atributoScope = elementoTH.getAttributeValue("scope");
			if (atributoScope == null) 
				comprobacionTHSinScope.procesar(elementoTH);
			else
				if 	(!atributoScope.matches("(row|col|rowgroup|colgroup)"))
					comprobacionValoresScope.procesar(elementoTH);
		}		
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTHSinScope);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionValoresScope);
		return resultadoEvaluacionTecnica;
	}

}