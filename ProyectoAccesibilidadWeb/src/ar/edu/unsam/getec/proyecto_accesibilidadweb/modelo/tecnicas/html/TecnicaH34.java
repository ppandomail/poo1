package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;

public class TecnicaH34 extends TecnicaHTML {

	public TecnicaH34(CategoriaTecnica categoriaTecnica) {
		super(
				"H34",
				"Usar una marca derecha a izquierda (RLM) o izquierda a derecha (LRM) para mezclar direcciones de texto en una misma l�nea.",
				"El objetivo de esta t�cnica es el uso de marcas Unicode derecha a izquierda e izquierda a derecha para sobreescribir el algoritmo bidireccional HTML cuando produce resultados no deseados. Esto puede ser necesario, por ejemplo, al colocar caracteres neutros como espacios o puntuaci�n entre las diferentes ejecuciones de texto direccionales.",
				categoriaTecnica);
	}

	/**
	 * 1. Inspeccionar el c�digo fuente para encontrar lugares donde el texto cambia de direcci�n.
	 * 2. Cuando el texto cambia de direcci�n verificar que los caracteres neutros como espacios o puntuaci�n son adyacentes al texto que se presenta en la direcci�n no predeterminada.
	 * 3. Cuando #2 es verdadera y el algoritmo bidireccional HTML producir�a la ubicaci�n incorrecta de los caracteres neutros verificar que los caracteres neutros est�n seguidos por marcas de Unicode derecha-a-izquierda o izquierda-a-derecha que ubican a los caracteres neutros como parte de los caracteres que los preceden.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCaracteresNeutrosSonAdyacentesTextoQueSePresentaEnDireccionNoPredeterminada = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Caracteres neutros no son adyacentes al texto que se presentan en la direcci�n no predeterminada.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cuando el texto cambia de direcci�n verificar que los caracteres neutros como espacios o puntuaci�n son adyacentes al texto que se presenta en la direcci�n no predeterminada.",
				"Ordena todos los contenidos de la p�gina web en un orden que tenga sentido y m�quetalos usando marcas de Unicode para mezclar texto \"de derecha a izquierda\" y \"de izquierda a derecha\".");
		for (Element elemento: this.getParseador().getElementos()) {
			String atributoDir = elemento.getAttributeValue("dir");
			if ((atributoDir != null) && (!atributoDir.isEmpty())) 
				comprobacionCaracteresNeutrosSonAdyacentesTextoQueSePresentaEnDireccionNoPredeterminada.procesar(elemento);
		}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCaracteresNeutrosSonAdyacentesTextoQueSePresentaEnDireccionNoPredeterminada);	
		return resultadoEvaluacionTecnica;
	}

}