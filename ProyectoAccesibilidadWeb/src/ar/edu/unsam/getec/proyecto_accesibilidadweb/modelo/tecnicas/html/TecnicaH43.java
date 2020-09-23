package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH43 extends TecnicaHTML {

	public TecnicaH43(CategoriaTecnica categoriaTecnica) {
		super(
				"H43",
				"Usar el atributo id y headers para asociar las celdas de datos con las celdas de encabezado en las tablas de datos.",
				"El objetivo esta t�cnica es asociar cada celda de datos (en una tabla de datos) con los encabezamientos apropiados. Esta t�cnica agrega un atributo headers a cada celda de datos (elemento td). Tambi�n agrega un atributo id a cualquier celda usada como un encabezado para otras celdas. El atributo headers de una celda contiene una lista de atributos id de las celdas de encabezado asociadas. Si hay mas de un id son separados por espacios. Esta t�cnica se utiliza cuando las celdas de datos est�n asociadas con m�s de una fila y/o una columna de encabezado. Esto permite a los lectores de pantalla hablar el encabezado asociado con cada celda de datos cuando las relaciones son demasiadoo complejas para ser identificados usando solo el elemento th o el elemento th con el atributo scope. Usando esta t�cnica tambi�n hace que estas relaciones complejas perceptibles cuando cambia el formato de presentaci�n. Esta t�cnica no es recomendada para las tablas de dise�o ya que su uso implica una relaci�n entre las celdas que no es significativo cuando las tablas son usadas para maquetar.",
				categoriaTecnica);
	}

	/**
	 * Para cada tabla de datos donde alguna celda contiene un atributo id o headers
	 * a. Verificar que cada id listado en el atributo headers de la celda de datos coincide el atributo id de una celda que es usada con un elemento header.
	 * b. Verificar que el atributo headers de una celda de datos contiene el atributo id de todos los headers asociados con la celda de datos.
	 * c. Verificar que todos los ids son �nicos (es decir, no hay 2 elementos en la p�gina que tienen el mismo id)
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionValorHeadersTDSinValorIDTH = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Elementos \"td\" con valor headers no coincide con valor \"id\" de elemento \"th\".",
				"Para cada tabla de datos donde alguna celda contiene un atributo \"id\" o \"headers\": Verificar que cada \"id\" listado en el atributo \"headers\" de la celda de datos coincide el atributo \"id\" de una celda que es usada con un elemento \"header\".",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos: los atributos  \"id\" y \"header\" para asociar celdas de datos con celdas de encabezado.");
		ResultadoEvaluacionTecnicaItem comprobacionIDSduplicados = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Elementos \"td\" o \"th\" con valores del atributo \"id\" duplicados.",
				"Para cada tabla de datos donde alguna celda contiene un atributo \"id\" o \"headers\": Verificar que todos los ids son �nicos (es decir, no hay 2 elementos en la p�gina que tienen el mismo \"id\")",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos: los atributos  \"id\" y \"header\" para asociar celdas de datos con celdas de encabezado.");
		List<String> idsTHTDs = new LinkedList<String>();
		for (Element elementoTABLE : this.getParseador().getElementos(HTMLElementName.TABLE)) {
			List<String> ids = new LinkedList<String>();
			for (Element elementoTH : elementoTABLE.getAllElements(HTMLElementName.TH)) {
				String atributoId = elementoTH.getAttributeValue("id");
				if (atributoId != null) {
					ids.add(atributoId);
					if (idsTHTDs.contains(atributoId))
						comprobacionIDSduplicados.procesar(elementoTH);
					idsTHTDs.add(atributoId);
				}
			}
			for (Element elementoTD : elementoTABLE.getAllElements(HTMLElementName.TD)) {
				String atributoHeaders = elementoTD.getAttributeValue("headers");
				String atributoId = elementoTD.getAttributeValue("id");
				if (atributoHeaders != null) {
					if (!this.isCoincideHeadersTDconIDsTH(ids, atributoHeaders)) 
						comprobacionValorHeadersTDSinValorIDTH.procesar(elementoTD);
				}
				if (atributoId != null) {
					if (idsTHTDs.contains(atributoId)) 
						comprobacionIDSduplicados.procesar(elementoTD);
					idsTHTDs.add(atributoId);
				}
			}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionValorHeadersTDSinValorIDTH);	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionIDSduplicados);	
		return resultadoEvaluacionTecnica;
	}

	private boolean isCoincideHeadersTDconIDsTH(List<String> ids, String headers) {
		if (ids.contains(headers)) return Boolean.TRUE;
		for (String palabra : headers.split(" ")) {
			if (ids.contains(palabra)) return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}