package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG1 extends TecnicaGeneral {

	public TecnicaG1(CategoriaTecnica categoriaTecnica) {
		super(
				"G1", 
				"Agregar un enlace al principio de cada p�gina que lleve directamente al �rea de contenido principal.", 
				"El objetivo de esta t�cnica es proporcionar un mecanismo para eludir bloques de material que se repiten en m�ltiples p�ginas web salt�ndose directamente al contenido principal de la p�gina web. El primer elemento interactivo en la p�gina web es un enlace al principio de la p�gina principal. La activaci�n de los conjuntos de enlaces se centran m�s all� del otro contenido a la p�gina principal. Esta t�cnica es m�s �til cuando una p�gina Web tiene un �rea de contenido principal, en lugar de un conjunto de �reas de contenido que son igualmente importantes, y cuando no hay varias secciones de navegaci�n de la p�gina.", 
				categoriaTecnica);
	}

	/**
	 * 1.  Verificar que el enlace corresponda a la p�gina Web. 
	 * 2.  Verificar que la descripci�n del enlace comunique que vincula a la p�gina principal. 
	 * 3.  Verificar que el enlace est� siempre visible o visible cuando tiene el foco del teclado. 
	 * 4.  Verificar que la activaci�n del enlace mueve el foco a la p�gina principal. 
	 * 5.  Verificar que despu�s de activar el enlace, el foco del teclado se haya movido a la p�gina principal.
	 * EX: Compruebe que el primer enlace sea visible siempre o cuando recibe el foco del teclado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSaltarBloquesContenidoRepetidos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Saltar bloques de contenido repetidos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la activaci�n del enlace mueve el foco a la p�gina principal.",
				"Evita al usuario tener que pasar bloques de contenido o elementos repetidos con un enlace en el principio de la p�gina para ir directamente al contenido principal o  a cada bloque de contenido.");
		comprobacionSaltarBloquesContenidoRepetidos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSaltarBloquesContenidoRepetidos);
		return resultadoEvaluacionTecnica;
	}

}