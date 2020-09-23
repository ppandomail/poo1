package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG88 extends TecnicaGeneral {

	public TecnicaG88(CategoriaTecnica categoriaTecnica) {
		super(
				"G88", 
				"Proporcionar t�tulos descriptivos para las p�gina web.", 
				"El objetivo de esta t�cnica es dar a cada p�gina web un t�tulo descriptivo. Los t�tulos descriptivos ayudan a los usuarios a encontrar contenidos,  orientarse dentro de los mismos, y navegar a trav�s de ellos. Un t�tulo descriptivo permite a un usuario identificar f�cilmente qu� p�gina web que est�n utilizando y que contar cuando la p�gina Web ha cambiado. El t�tulo se puede utilizar para identificar la p�gina Web sin que los usuarios deban leer o interpretar el contenido de la p�gina. Los usuarios pueden identificar m�s r�pidamente el contenido que necesitan cuando los t�tulos precisos y descriptivos aparecen en los mapas de sitios o listas de resultados de b�squeda. Cuando se utilizan t�tulos descriptivos dentro del texto de enlace, que ayudan a los usuarios a navegar con mayor precisi�n al contenido que les interesa.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que la p�gina web tiene un t�tulo.
	 * 2. Verificar que el t�tulo es relevante para el contenido de la p�gina Web.
	 * 3. Verificar que la p�gina web se puede identificar con el t�tulo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaConTituloDescriptivo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"P�gina con t�tulo descriptivo.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el t�tulo es relevante para el contenido de la p�gina Web.",
				"Ofrece un t�tulo �nico y descriptivo para cada p�gina web. No identifiques la p�gina o sus contenidos con textos como \"Documento sin t�tulo\" o similar. No utilices el mismo t�tulo para diferentes p�ginas.");
		for (Element elementoTITLE : this.getParseador().getElementos(HTMLElementName.TITLE))
			comprobacionPaginaConTituloDescriptivo.procesar(elementoTITLE);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaConTituloDescriptivo);
		return resultadoEvaluacionTecnica;
	}

}