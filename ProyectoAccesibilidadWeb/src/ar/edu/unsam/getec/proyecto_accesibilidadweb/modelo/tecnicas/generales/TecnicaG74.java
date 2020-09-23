package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG74 extends TecnicaGeneral {

	public TecnicaG74(CategoriaTecnica categoriaTecnica) {
		super(
				"G74",
				"Proporcionar una larga descripci�n en texto cerca del contenido no textual, con una referencia a la ubicaci�n de la descripci�n larga en la descripci�n breve.",
				"El objetivo de esta t�cnica es proporcionar una descripci�n larga sin que el usuario requiera saltar a otra ubicaci�n de la descripci�n. Tambi�n permite que todos los usuarios puedan ver la descripci�n que puede ser �til para cualquier persona que pudiera perderse algunas caracter�sticas en el contenido no textual. Con esta t�cnica, la descripci�n larga se proporciona como parte de la presentaci�n est�ndar (es decir, todo el mundo lo recibe). La descripci�n est� situada cerca del contenido no textual, pero no tiene que ser el siguiente art�culo. Por ejemplo, puede haber una leyenda bajo un gr�fico con la larga descripci�n proporcionada en el p�rrafo siguiente. La ubicaci�n de esta descripci�n larga es luego proporcionada dentro de la alternativa de texto corto asi el usuario sabe d�nde buscarla por si no pueden ver el contenido no textual.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que la alternativa de texto corto incluye la ubicaci�n de la descripci�n larga.
	 * 2. Verificar que la descripci�n larga se encuentra cerca del contenido no textual tanto visual como en el orden de lectura lineal.
	 * 3. Verificar que la descripci�n larga transmite la misma informaci�n que el contenido no textual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualCercaContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa textual cerca del contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la descripci�n larga se encuentra cerca del contenido no textual tanto visual como en el orden de lectura lineal.",
				"Aseg�rate que la descripci�n larga se encuentra cerca del contenido no textual tanto visual como en el orden de lectura lineal.");
		comprobacionAlternativaTextualCercaContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualCercaContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}