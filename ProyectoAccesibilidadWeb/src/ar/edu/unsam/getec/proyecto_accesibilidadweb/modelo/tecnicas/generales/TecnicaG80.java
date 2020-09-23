package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG80 extends TecnicaGeneral {

	public TecnicaG80(CategoriaTecnica categoriaTecnica) {
		super(
				"G80", 
				"Proporcionar un bot�n de env�o para iniciar un cambio de contexto.", 
				"El objetivo de esta t�cnica es proporcionar un mecanismo que permita a los usuarios solicitar expl�citamente cambios de contexto. Dado que el uso previsto de un bot�n de env�o es generar una petici�n HTTP que env�a los datos introducidos en un formulario, este es un control apropiado para provocar un cambio de contexto y es una pr�ctica para no dar lugar a confusi�n a los usuarios.",
				categoriaTecnica);
	}

	/**
	 * 1. Buscar todas los formularios en el contenido.
	 * 2. Para cada formulario, verificar que dispone de un bot�n de env�o.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormularioSinBotonEnvio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Formulario sin bot�n de env�o.",
				"Para cada formulario, verificar que dispone de un bot�n de env�o.",
				"Para iniciar un cambio de contexto, ofrece un bot�n que el usuario pueda pulsar.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM)) {
			Integer contador = 0;
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
				String atributoType = elementoINPUT.getAttributeValue("type");
				if ((atributoType != null) && (atributoType.equals("submit")))
					contador++;
			}
			if (contador == 0)
				comprobacionFormularioSinBotonEnvio.procesar(elementoFORM);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormularioSinBotonEnvio);
		return resultadoEvaluacionTecnica;
	}

}