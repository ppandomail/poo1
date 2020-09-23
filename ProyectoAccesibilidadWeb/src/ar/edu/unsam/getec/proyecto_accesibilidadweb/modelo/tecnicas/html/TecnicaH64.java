package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH64 extends TecnicaHTML {

	public TecnicaH64(CategoriaTecnica categoriaTecnica) {
		super(
				"H64", 
				"Usar el atributo title de los elementos frame o iframe.",
				"El prop�sito de esta t�cnica es demostrar el uso del atributo title en los elementos frame o iframe para describir el contenido de cada marco. Esto proporciona una etiqueta para el marco de modo que los usuarios pueden determinar a qu� marco entrar y explorar en detalle. Tenga en cuenta que el atributo title etiqueta los marcos y es diferente del elemento title que etiqueta los documentos. Ambos deben ser usados siempre, ya que el primero facilita la navegaci�n entre los marcos y el segundo aclara la ubicaci�n actual del usuario.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que cada elemento frame y iframe en el c�digo HTML tenga la presencia de un atributo title.
	 * 2. Verificar que el atributo title contiene texto que identifica el frame.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMarcosSinTitulo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Marcos sin t�tulo.",
				"Verificar que cada elemento \"frame\" y \"iframe\" en el c�digo HTML tengan la presencia de un atributo \"title\".",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan identificando los elementos \"frame\" e \"iframe\" con el atributo \"title\".");
		ResultadoEvaluacionTecnicaItem comprobacionMarcosConTituloQueLoIdentifica = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Marcos con t�tulo que lo identifica.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el atributo \"title\" contiene texto que identifica el \"frame\".",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan identificando los elementos \"frame\" e \"iframe\" con el atributo \"title\".");
		for (Element elementoFRAME : this.getParseador().getElementos(HTMLElementName.FRAME)) {
			String atributoTitle = elementoFRAME.getAttributeValue("title");
			if (atributoTitle == null) 
				comprobacionMarcosSinTitulo.procesar(elementoFRAME);
			else
				if (atributoTitle.isEmpty()) 
					comprobacionMarcosSinTitulo.procesar(elementoFRAME);
				else 
					comprobacionMarcosConTituloQueLoIdentifica.procesar(elementoFRAME);
		}	
		for (Element elementoIFRAME : this.getParseador().getElementos(HTMLElementName.IFRAME)) {
			String atributoTitle = elementoIFRAME.getAttributeValue("title");
			if (atributoTitle == null) 
				comprobacionMarcosSinTitulo.procesar(elementoIFRAME);
			else
				if (atributoTitle.isEmpty()) 
					comprobacionMarcosSinTitulo.procesar(elementoIFRAME);
				else
					comprobacionMarcosConTituloQueLoIdentifica.procesar(elementoIFRAME);
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMarcosSinTitulo);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMarcosConTituloQueLoIdentifica);	
		return resultadoEvaluacionTecnica;
	}

}