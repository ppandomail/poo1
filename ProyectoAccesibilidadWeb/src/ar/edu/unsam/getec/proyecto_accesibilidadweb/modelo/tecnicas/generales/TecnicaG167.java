package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG167 extends TecnicaGeneral {

	public TecnicaG167(CategoriaTecnica categoriaTecnica) {
		super(
				"G167", 
				"El uso de un bot�n adyacente para etiquetar el prop�sito de un campo.", 
				"Cuando un bot�n invoca una funci�n en un campo de entrada, tiene una etiqueta de texto claro, y se rindi� al lado del campo de entrada, el bot�n tambi�n act�a como una etiqueta para el campo de entrada. Esta etiqueta ayuda a los usuarios a entender el prop�sito del campo sin introducir texto repetitivo en la p�gina Web. Botones que etiquetan los campos de texto individuales suelen seguir el campo de entrada.",
				categoriaTecnica);
	}

	/**
	 * Para un campo y un bot�n de uso de esta t�cnica:
	 * 1. Verificar que el campo y el bot�n son adyacentes entre s� en la secuencia de lectura determinada mediante programaci�n.
	 * 2. Verificar que el campo y el bot�n se representan visualmente una junto a otra.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionBotonAdyacenteParaEtiquetarCampo = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Bot�n adyacente para etiquetar el prop�sito de un campo.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para un campo y un bot�n de uso de esta t�cnica: Verificar que el campo y el bot�n son adyacentes entre s� en la secuencia de lectura determinada mediante programaci�n.",
				"Si no puedes identificar el control de formulario con el atributo \"title\" ni asociarle una etiqueta al elemento, sit�a un bot�n adyacente para explicar el objetivo de ese campo.");
		comprobacionBotonAdyacenteParaEtiquetarCampo.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionBotonAdyacenteParaEtiquetarCampo);
		return resultadoEvaluacionTecnica;
	}

}