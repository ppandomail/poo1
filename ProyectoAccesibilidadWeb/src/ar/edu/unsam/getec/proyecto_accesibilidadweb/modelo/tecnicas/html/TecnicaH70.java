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

public class TecnicaH70 extends TecnicaHTML {

	public TecnicaH70(CategoriaTecnica categoriaTecnica) {
		super(
				"H70",
				"Usar el elemento frame para agrupar bloques de material repetido.", 
				"",
				categoriaTecnica);
	}

	/**
	 * Si la p�gina web utiliza elementos frame para organizar el contenido:
	 * 1. Verificar que bloques de contenido repetido se organizan en elementos frame separados.
	 * 2. Verificar que los elementos frame con contenido repetido aparecen en la misma ubicaci�n dentro de cada elemento frameset.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionBloquesContenido = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Bloques de contenido.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Si la p�gina web utiliza elementos \"frame\" para organizar el contenido: Verificar que bloques de contenido repetidos se organizan en elementos \"frame\" separados.",
				"Evita al usuario tener que pasar por bloques de contenido o elementos que no le interesan con elementos \"frame\".");
		List<Element> listaFrame = this.getParseador().getElementos(HTMLElementName.FRAME);
		if (listaFrame.size()>0)
			comprobacionBloquesContenido.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBloquesContenido);
		return resultadoEvaluacionTecnica;
	}

}
