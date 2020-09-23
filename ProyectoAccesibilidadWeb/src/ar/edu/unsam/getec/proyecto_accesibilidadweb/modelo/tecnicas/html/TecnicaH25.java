package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;


import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH25 extends TecnicaHTML {

	public TecnicaH25(CategoriaTecnica categoriaTecnica) {
		super(
				"H25", 
				"Proporcionar un t�tulo usando el elemento title.", 
				"Todos los documentos HTML y XHTML, incluyendo aquellos en los marcos individuales de un frameset, tienen un elemento title en la secci�n head que define, en una frase simple, el prop�sito del documento. Esto ayuda a los usuarios a orientarse dentro del sitio de forma r�pida y sin tener que buscar informaci�n en el cuerpo de la p�gina. Tenga en cuenta que el elemento title (obligatorio), que s�lo aparece una vez en un documento, es diferente del atributo title, que se puede aplicar a casi todos los elemento HTML y XHTML.",
				categoriaTecnica);
	}

	/**
	 * 1.Examinar el c�digo fuente del documento HTML o XHTML y verificar que un elemento title no-vac�o aparece en la secci�n head.
	 * 2.Verificar que el elemento title describe el documento.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaSinTitulo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"P�gina sin t�tulo.",
				"Examinar el c�digo fuente del documento HTML o XHTML y verificar que un elemento \"title\" no-vac�o aparece en la secci�n head.",
				"Ofrece un t�tulo �nico y descriptivo para cada p�gina web. No identifiques la p�gina o sus contenidos con textos como \"Documento sin t�tulo\" o similar. No utilices el mismo t�tulo para diferentes p�ginas.");
		ResultadoEvaluacionTecnicaItem comprobacionTituloConTitleDescribiendoDocumento = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"T�tulo describe el documento.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el elemento \"title\" describe el documento.",
				"Ofrece un t�tulo �nico y descriptivo para cada p�gina web. No identifiques la p�gina o sus contenidos con textos como \"Documento sin t�tulo\" o similar. No utilices el mismo t�tulo para diferentes p�ginas.");
		String titulo = null;
		Element element = null;
		for (Element elementoHEAD : this.getParseador().getElementos(HTMLElementName.HEAD))
			for (Element elementTitle : elementoHEAD.getAllElements(HTMLElementName.TITLE)) {
				element = elementTitle;
				titulo = elementTitle.getTextExtractor().toString();
			}	
		if (titulo == null) 
			comprobacionPaginaSinTitulo.procesar();
		else
			if (titulo.isEmpty()) 
				comprobacionPaginaSinTitulo.procesar(element);
			else 
				comprobacionTituloConTitleDescribiendoDocumento.procesar(element);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaSinTitulo);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTituloConTitleDescribiendoDocumento);
		return resultadoEvaluacionTecnica;
	}

}