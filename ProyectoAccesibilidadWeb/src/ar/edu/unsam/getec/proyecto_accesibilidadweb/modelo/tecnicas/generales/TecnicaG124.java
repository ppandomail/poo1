package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG124 extends TecnicaGeneral {

	public TecnicaG124(CategoriaTecnica categoriaTecnica) {
		super(
				"G124", 
				"Agregar enlaces en la parte superior de la p�gina para cada �rea del contenido.", 
				"El objetivo de esta t�cnica es proporcionar un mecanismo para evitar bloques de material proporcionando una lista de enlaces a las diferentes secciones del contenido. Los enlaces en esta lista, como una peque�a tabla de contenidos al inicio del contenido, establecer el foco en las diferentes secciones del contenido. Esta t�cnica es particularmente �til para las p�ginas con muchas secciones independientes, tales como portales. Tambi�n se puede combinar con otras t�cnicas para saltar bloques dentro de una secci�n.",
				categoriaTecnica);
	}

	/**
	 * Para cada eslab�n de la serie de enlaces que se proporcionan para este prop�sito:
	 * 1. Verificar que los �nicos controles en la p�gina Web que preceden el enlace son otros enlaces en el conjunto.
	 * 2. Verificar que la descripci�n de cada enlace comunica que conecta a alguna secci�n del contenido.
	 * 3. Verificar que el enlace est� bien siempre visible o visible cuando tiene el foco del teclado.
	 * 4. Verificar que la activaci�n del enlace mueve el foco a esa secci�n del contenido.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSaltarBloquesContenidoRepetidos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Saltar bloques de contenido repetidos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la descripci�n de cada enlace comunica que conecta a alguna secci�n del contenido.",
				"Evita al usuario tener que pasar bloques de contenido o elementos repetidos con un enlace en el principio de la p�gina para ir directamente al contenido principal o a cada bloque de contenido.");
		comprobacionSaltarBloquesContenidoRepetidos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSaltarBloquesContenidoRepetidos);
		return resultadoEvaluacionTecnica;
	}

}