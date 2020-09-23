package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH49 extends TecnicaHTML {

	public TecnicaH49(CategoriaTecnica categoriaTecnica) {
		super(
				"H49", 
				"Usar marcado sem�ntico para identificar el texto especial o enfatizado.", 
				"El objetivo de esta t�cnica es demostrar c�mo el marcado sem�ntico puede ser utilizado para marcar �nfasis o texto especial para que se pueda determinar por programaci�n. El uso de marcas sem�nticas para marcar �nfasis o texto especial tambi�n proporciona estructura al documento. Los agentes de usuario pueden entonces hacer la estructura perceptible para el usuario, por ejemplo, utilizando una presentaci�n visual diferente para diferentes tipos de estructuras o mediante el uso de una voz o tono diferente en una presentaci�n auditiva. La mayor�a de las aplicaciones de usuario se distinguen visualmente el texto, que ha sido identificado utilizando el marcado sem�ntico . Algunas tecnolog�as de apoyo proporcionan un mecanismo para determinar las caracter�sticas de los contenidos que se ha creado usando el marcado sem�ntico adecuado.",
				categoriaTecnica);
	}

	/**
	 * 1. Examinar el contenido de la informaci�n que se transmite a trav�s de las variaciones en la presentaci�n del texto.
	 * 2. Verificar que el marcado sem�ntico apropiado (como em, strong, cite, blockquote, sub y sup) se han utilizado para marcar el texto que transmite informaci�n a trav�s de variaciones en el texto.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMarcadoSemanticoSinTexto = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Marcado sem�ntico sin texto.",
				"Verificar que el marcado sem�ntico apropiado (como \"em\", \"strong\", \"cite\", \"blockquote\", \"sub\" y \"sup\") se han utilizado para marcar el texto.",
				"Formatea la estructura y el texto con elementos sem�nticos.");
		ResultadoEvaluacionTecnicaItem comprobacionMarcadoSemanticoTransmiteInformacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Marcado sem�ntico se ha utilizado para identificar texto especial o enfatizado.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el marcado sem�ntico apropiado (como \"em\", \"strong\", \"cite\", \"blockquote\", \"sub\" y \"sup\") se han utilizado para marcar el texto que transmite informaci�n a trav�s de variaciones en el texto.",
				"Formatea la estructura y el texto con elementos sem�nticos.");
		for (Element elemento : this.getParseador().getElementos()) {
			if (elemento.getName().matches("(" + HTMLElementName.EM + "|" + HTMLElementName.STRONG + "|" + HTMLElementName.CITE + "|" + HTMLElementName.BLOCKQUOTE  + "|" + HTMLElementName.SUB + "|" + HTMLElementName.SUP + ")")) {
				if (elemento.getTextExtractor().toString().isEmpty()) 
					comprobacionMarcadoSemanticoSinTexto.procesar(elemento);
				comprobacionMarcadoSemanticoTransmiteInformacion.procesar(elemento);
			}	
		}	
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMarcadoSemanticoSinTexto);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMarcadoSemanticoTransmiteInformacion);
		return resultadoEvaluacionTecnica;
	}

}