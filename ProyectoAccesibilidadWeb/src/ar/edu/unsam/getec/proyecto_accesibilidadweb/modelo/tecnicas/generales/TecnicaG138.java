package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG138 extends TecnicaGeneral {

	public TecnicaG138(CategoriaTecnica categoriaTecnica) {
		super(
				"G138", 
				"Usar marcado sem�ntico cuando se utilizan las se�ales de color.", 
				"El objetivo de esta t�cnica es combinar color y marcado sem�ntico para transmitir informaci�n. La mayor�a de los usuarios pueden escanear r�pidamente el contenido para localizar la informaci�n facilitada mediante el uso del color . Para los usuarios que no pueden ver el color, el marcado sem�ntico puede proporcionar un tipo diferente de se�al . Los agentes de usuario pueden entonces hacer este tipo de estructura perceptible para el usuario, por ejemplo, utilizando una presentaci�n visual diferente para diferentes tipos de estructuras o mediante el uso de una voz o tono diferente en una presentaci�n auditiva. La mayor�a de las aplicaciones de usuario se distinguen visualmente el texto, que ha sido identificado utilizando el marcado sem�ntico . Algunas tecnolog�as de apoyo proporcionan un mecanismo para determinar las caracter�sticas de los contenidos que se ha creado usando el marcado sem�ntico adecuado.", 
				categoriaTecnica);
	}

	/**
	 * Para cualquier contenido que se utilizan diferencias de color para transmitir informaci�n:
	 * 1. Verificar que la misma informaci�n est� disponible a trav�s de marcado sem�ntico.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCombinacionColorYMarcadoSemantico = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Combinar color y marcado sem�ntico para transmitir informaci�n", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cualquier contenido que se utilizan diferencias de color para transmitir informaci�n: Verificar que la misma informaci�n est� disponible a trav�s de marcado sem�ntico.",
				"Comunica la informaci�n y sus relaciones mediante la estructura de la p�gina web: el marcado sem�ntico cuando se utilizan claves de colores (por ejemplo, si se colorea el texto en rojo para indicar que es un error).");
		comprobacionCombinacionColorYMarcadoSemantico.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCombinacionColorYMarcadoSemantico);
		return resultadoEvaluacionTecnica;
	}

}