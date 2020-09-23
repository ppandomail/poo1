package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC7 extends TecnicaCSS {

	public TecnicaC7(CategoriaTecnica categoriaTecnica) {
		super(
				"C7", 
				"Usar CSS para ocultar una parte del texto del enlace.", 
				"El objetivo de esta t�cnica es complementar el texto del enlace mediante la adici�n de texto adicional que describe la funci�n �nica del link y el estilo del texto adicional de modo tal que no se muestra en  pantalla por los agentes de usuario que soporta CSS. Cuando la informaci�n en el contexto que lo rodea es necesaria para interpretar el texto del enlace que se muestra,esta t�cnica proporciona una descripci�n completa de la funci�n del link de salida permitiendo al mismo tiempo el menor texto completo que se va a mostrar. Esta t�cnica funciona mediante la creaci�n de un selector CSS para linkear al texto que va a ser oculto. El conjunto de reglas para el selector, coloca el texto que se oculta en una caja de 1 p�xel de  overflow oculto, y posiciona el texto fuera de la ventana gr�fica. Esto asegura que el texto no se muestre en pantalla, pero sigue siendo accesible para las ayudas t�cnicas tales como lectores de pantalla y pantallas braille.", 
				categoriaTecnica);
	}

	/**
	 * En cada elemento anchor que utiliza esta t�cnica:
	 * 1. Verificar que hay definido un elemento que delimita su exposici�n a un p�xel y posiciona texto fuera de la exposici�n con rebosadero oculto.
	 * 2. Verificar que el elemento de esa clase est� incluido en el contenido del anchor.
	 * 3. Verificar que el contenido combinado del anchor describe el prop�sito del enlace.
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
						"En cada elemento anchor que utiliza esta t�cnica: Verificar que hay definido un elemento que delimita su exposici�n a un p�xel y posiciona texto fuera de la exposici�n con overflow oculto.",
						"Describe el objetivo de un enlace. Si necesitas ocultar un trozo del texto del enlace con CSS, hazlo.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}