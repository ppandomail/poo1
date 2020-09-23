package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC18 extends TecnicaCSS {

	public TecnicaC18(CategoriaTecnica categoriaTecnica) {
		super(
				"C18",
				"Usar reglas de margen CSS y de relleno en lugar de im�genes de espaciador de dise�o de la disposici�n.",
				"A veces los dise�adores Web utilizan las im�genes de espaciado (generalmente de 1x1 p�xeles, GIF transparentes) para un mejor control sobre el dise�o, por ejemplo, en tablas o para indentar un p�rrafo. Sin embargo, Cascading Style Sheets (CSS) permiten un control suficiente sobre el dise�o para sustituir las im�genes de espaciado. Las propiedades CSS para m�rgenes y el relleno se pueden utilizar solos o en combinaci�n para controlar la disposici�n. Las propiedades del margen (�margin- top ' , ' margin-right ' , ' margin-bottom ' , 'margin- left' , y la abreviatura �margin� ) se puede utilizar en cualquier elemento que se muestra como un bloque; que a�aden espacio en la parte exterior de un elemento. Las propiedades de relleno ( 'padding -top ' , ' padding-right ' , ' padding-bottom ' , 'padding - left' y la abreviatura 'padding ' ) se pueden utilizar en cualquier elemento; ellos agregan el espacio interior del elemento.", 
				categoriaTecnica);
	}

	/**
	 *
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
						"Verificar que se usan reglas de margen CSS y de relleno en lugar de im�genes de espaciador de dise�o de la disposici�n.",
						"Formatea la p�gina con las reglas de caja de CSS en lugar de con im�genes.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}