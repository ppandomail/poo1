package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;


public class TecnicaC6 extends TecnicaCSS {

	public TecnicaC6(CategoriaTecnica categoriaTecnica) {
		super(
				"C6",
				"Posicionar el contenido bas�ndose en marcado estructural.",
				"El objetivo de esta t�cnica es demostrar c�mo la apariencia visual se puede mejorar a trav�s de las hojas de estilo, manteniendo una presentaci�n significativa cuando las hojas de estilo no se aplican. Usando las propiedades de posicionamiento de CSS2, el contenido puede aparecer en cualquier posici�n en la ventana gr�fica del usuario. Usando elementos estructurales se asegura que el significado del contenido aun se pueda determinar cuando el estilo no est� disponible.",
				categoriaTecnica);
	}

	/**
	 * En el contenido que utiliza CSS para posicionamiento:
	 * 1. Eliminar del documento la informacion sobre estilo o deshabilitar el uso de hojas de estilo en el agente usuario.
	 * 2. Verificar que se preservan las relaciones estructurales y el significado del contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/css"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validaci�n de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar  que se preservan las relaciones estructurales y el significado del contenido al eliminar del documento la informaci�n sobre estilo o deshabilitar el uso de hojas de estilo en el agente usuario.",
						"No cambies con CSS el sgnificado del contenido por la forma de ubicar la informaci�n.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}