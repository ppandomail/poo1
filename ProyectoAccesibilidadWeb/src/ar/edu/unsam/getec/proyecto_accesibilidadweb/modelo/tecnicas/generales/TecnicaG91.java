package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG91 extends TecnicaGeneral {

	public TecnicaG91(CategoriaTecnica categoriaTecnica) {
		super(
				"G91", 
				"Proporcionar enlaces de texto que describe el prop�sito de un enlace.", 
				"El objetivo de esta t�cnica es describir el prop�sito de un enlace en el texto del enlace. La descripci�n permite a un usuario a distinguir este enlace siguiendo los enlaces de la p�gina Web que conducen a otros destinos y ayuda al usuario a determinar si seguir el enlace o no. El URL de destino en general no es suficientemente descriptivo.",
				categoriaTecnica);
	}

	/**
	 * Para cada enlace en el contenido que utiliza esta t�cnica:
	 * 1. Verificar que el texto del enlace describe el prop�sito del enlace.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionTextoEnlaceDescribePropositoEnlace = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Texto del enlace describe el prop�sito del enlace.", 
				TipoResultadoEvaluacion.MANUAL,
				"Para cada enlace en el contenido que utiliza esta t�cnica: Verificar que el texto del enlace describe el prop�sito del enlace.",
				"Identifica el objetivo de un enlace usando un texto clarificador en el enlace.");
		for (Element elementoA : this.getParseador().getElementos(HTMLElementName.A))
			if (!elementoA.getTextExtractor().toString().isEmpty())
				comprobacionTextoEnlaceDescribePropositoEnlace.procesar(elementoA);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionTextoEnlaceDescribePropositoEnlace);
		return resultadoEvaluacionTecnica;
	}

}