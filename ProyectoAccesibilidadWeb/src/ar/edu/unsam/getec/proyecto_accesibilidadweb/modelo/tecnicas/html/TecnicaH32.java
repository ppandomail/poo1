package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;


import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH32 extends TecnicaHTML {

	public TecnicaH32(CategoriaTecnica categoriaTecnica) {
		super(
				"H32",
				"Proporcionar botones de env�o",
				"El prop�sito de esta t�cnica es proporcionar un mecanismo que permita a los usuarios solicitar expl�citamente cambios de contexto. El uso previsto de un bot�n de env�o (input type=\"submit\", input type=\"image\" o button type=\"submit\") es generar una petici�n HTTP que env�a los datos introducidos en un formulario, por lo que es un control apropiado para provocar un cambio de contexto y es una pr�ctica que no crea confusi�n entre los usuarios.",
				categoriaTecnica);
	}

	/**
	 * 1. Buscar todos los formularios en el contenido.
	 * 2. Por cada formulario verificar que tiene un bot�n submit (input type="submit", input type="image", or button type="submit") 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormularioSinBotonesEnvio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Formularios sin bot�n de env�o.",
				"Por cada formulario verificar que tiene un bot�n submit (input type=\"submit\", input type=\"image\", or button type=\"submit\")",
				"Para iniciar un cambio de contexto, ofrece un bot�n que el usuario pueda pulsar. No env�es un formulario autom�ticamente.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			Integer contador = 0;
			for (Element elemento : elementoFORM.getAllElements()) {
				String atributoType = elemento.getAttributeValue("type");
				if (elemento.getName().equalsIgnoreCase(HTMLElementName.INPUT))
					if ((atributoType != null) && (atributoType.matches("(submit|image)")))
						contador++;
				if (elemento.getName().equalsIgnoreCase(HTMLElementName.BUTTON))
					if ((atributoType != null) && (atributoType.matches("submit")))
						contador++;
			}
			if (contador == 0) 
				comprobacionFormularioSinBotonesEnvio.procesar(elementoFORM);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormularioSinBotonesEnvio);
		return resultadoEvaluacionTecnica;
	}

}