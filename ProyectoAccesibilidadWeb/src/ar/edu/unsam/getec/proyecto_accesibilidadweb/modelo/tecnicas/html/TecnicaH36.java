package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.FormControlType;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH36 extends TecnicaHTML {

	public TecnicaH36(CategoriaTecnica categoriaTecnica) {
		super(
				"H36", 
				"Usar atributos alt en las im�genes usadas como botones de env�o.",	
				"Para los elementos input de tipo \"image\", el atributo alt se utiliza para proporcionar una etiqueta funcional. Esta etiqueta indica la funci�n del bot�n, pero no trata de describir la imagen. La etiqueta es especialmente importante si hay varios botones de env�o en la p�gina que conducen, cada uno, a resultados diferentes. El elemento input se usa para crear muchos tipos de controles de formulario. A pesar de que las DTD de HTML y XHTML permiten el atributo alt en todos estos controles, debe ser usado s�lo en los botones gr�ficos. El soporte de las aplicaciones de usuario a este atributo en otros tipos de controles de formulario no est� bien definido y se usan otros mecanismos para etiquetar estos controles.",
				categoriaTecnica);
	}

	/**
	 * 1. Para todos los elementos 'input' que tienen un valor de atributo de tipo de 'image' , verificar la presencia de un atributo 'alt'. 
	 * 2. Verificar que el atributo alt indica la funci�n del bot�n.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionBotonGraficosSinAlt = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Botones gr�ficos sin atributo \"alt\".",
				"Para todos los elementos \"input\" que tienen un valor de atributo de tipo de \"image\", verificar la presencia de un atributo \"alt\".",
				"Utiliza el atributo \"alt\" en im�genes usada como botones.");
		ResultadoEvaluacionTecnicaItem comprobacionBotonGraficosConAltIndicandoFuncionBoton = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Atributo \"alt\" no indica funci�n del bot�n.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el atributo \"alt\" indica la funci�n del bot�n.",
				"Aseg�rate que la alternativa textual describe la funci�n del bot�n.");
		for (Element elemento : this.getParseador().getElementos()) {
			if (elemento.getName().equals(HTMLElementName.INPUT))
				if (elemento.getFormControl() != null)
					if (elemento.getFormControl().getFormControlType().equals(FormControlType.IMAGE)) {
						String atributoAlt = elemento.getAttributeValue("alt");
						if (atributoAlt == null) 
							comprobacionBotonGraficosSinAlt.procesar(elemento);
						else
							if (atributoAlt.isEmpty()) 
								comprobacionBotonGraficosSinAlt.procesar(elemento);
						comprobacionBotonGraficosConAltIndicandoFuncionBoton.procesar(elemento);
					}
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBotonGraficosSinAlt);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBotonGraficosConAltIndicandoFuncionBoton);
		return resultadoEvaluacionTecnica;
	}

}