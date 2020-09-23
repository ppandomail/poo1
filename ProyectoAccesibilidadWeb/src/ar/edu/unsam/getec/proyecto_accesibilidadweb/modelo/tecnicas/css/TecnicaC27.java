package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC27 extends TecnicaCSS {

	public TecnicaC27(CategoriaTecnica categoriaTecnica) {
		super(
				"C27", 
				"Hacer que el orden en el DOM sea igual al orden visual.",
				"El objetivo de esta t�cnica es para asegurar que el orden del contenido en el c�digo fuente es la misma que la presentaci�n visual del contenido. El orden de los contenidos en el c�digo fuente puede ser cambiado por el autor para cualquier n�mero de presentaciones visuales con CSS. Cada orden puede ser significativo en s� mismo, pero puede causar confusi�n entre los usuarios de tecnolog�a de asistencia. Esto podr�a ser debido a que el usuario desconecte la presentaci�n especificados por el autor, mediante el acceso al contenido directamente a partir del c�digo fuente (como con un lector de pantalla), o mediante la interacci�n con el contenido con un teclado. Si un usuario ciego, que lee la p�gina con un lector de pantalla que sigue el orden de las fuentes, est� trabajando con un usuario vidente que lee la p�gina en orden visual, puede confundirse cuando se encuentran con informaci�n en diferentes �rdenes. Un usuario con baja visi�n que utiliza un amplificador de pantalla en combinaci�n con un lector de pantalla puede ser confundido cuando el orden de lectura parece saltar de un lado de la pantalla. Un usuario del teclado puede tener problemas para predecir d�nde ir� enfoque siguiente, cuando la orden de origen no coincide con el orden visual.", 
				categoriaTecnica);
	}

	/**
	 * 1. Inspeccionar visualmente el orden del contenido en la p�gina web tal y como se lo presenta al usuario final. 
	 * 2. Inspeccionar los elementos del DOM utilizando una herramienta que permite visualizar el DOM. 
	 * 3. Asegurar que el orden del contenido en las secciones del c�digo fuente concuerda con la presentacion visual del contenido en la p�gina web (ej., en una p�gina en idioma espa�ol el orden es de arriba hacia abajo y de izquierda a derecha). 
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
						"Verificar que el orden del contenido en las secciones del c�digo fuente concuerda con la presentaci�n visual del contenido en la p�gina web (por ejemplo: en una p�gina en idioma espa�ol el orden es de arriba hacia abajo y de izquierda a derecha).",
						"Ajusta el orden del DOM al orden visual.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}