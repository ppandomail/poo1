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

public class TecnicaH39 extends TecnicaHTML {

	public TecnicaH39(CategoriaTecnica categoriaTecnica) {
		super(
				"H39", 
				"Usar elementos caption para asociar t�tulos de tabla con las tablas de datos.", 
				"El prop�sito de esta t�cnica es asociar por software los t�tulos de las tablas de datos cuando los t�tulos se proporcionan en la presentaci�n. El t�tulo de una tabla es un identificador de la tabla y act�a como un encabezado. El elemento caption es el marcado adecuado para tal texto y se asegura de que el identificador se asocie a la tabla, incluso visualmente. Adem�s, usar el elemento caption permite que los lectores de pantalla naveguen directamente al t�tulo de la tabla si hay uno presente. El elemento caption se puede utilizar a�n si la tabla incluye un atributo summary. El elemento caption identifica la tabla mientras que el atributo summary ofrece una visi�n general de la finalidad o explica c�mo navegar la tabla. Si se usan ambos, el t�tulo no debe duplicar la informaci�n en el resumen.",
				categoriaTecnica);
	}

	/**
	 * Para cada tabla de datos:
	 * 1. Verificar que la tabla incluye un elemento caption.
	 * 2. Verificar que el contenido del elemento caption identifica la tabla.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTablaSinCaption = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Tablas sin elemento \"caption\".",
				"Verificar que la tabla incluye un elemento \"caption\".",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos: el elemento \"caption\" para titular la tabla de datos.");
		ResultadoEvaluacionTecnicaItem comprobacionContenidoCaptionIdentificaTabla = new ResultadoEvaluacionTecnicaItem(
				Tipologia.TABLAS, 
				"Contenido del elemento \"caption\" identifica la tabla.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el contenido del elemento \"caption\" identifica la tabla.",
				"Comunica la informaci�n y sus relaciones mediantes tabla de datos: el elemento \"caption\" para titular la tabla de datos.");
		for (Element elementoTABLE : this.getParseador().getElementos(HTMLElementName.TABLE)) {
			List<Element> listaElementosCaption = elementoTABLE.getAllElements(HTMLElementName.CAPTION);
			if (listaElementosCaption.isEmpty()) 
				comprobacionTablaSinCaption.procesar(elementoTABLE);
			else 
				for (Element elementoCAPTION : listaElementosCaption) 
					comprobacionContenidoCaptionIdentificaTabla.procesar(elementoCAPTION);
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTablaSinCaption); 
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoCaptionIdentificaTabla); 
		return resultadoEvaluacionTecnica;
	}

}