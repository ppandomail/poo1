package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG123 extends TecnicaGeneral {

	public TecnicaG123(CategoriaTecnica categoriaTecnica) {
		super(
				"G123",
				"Agregar un enlace al principio de un bloque de contenido repetitivo que dirija al final del bloque.",
				"El objetivo de esta t�cnica es proporcionar un mecanismo para pasar por alto un bloque de material saltando hasta el final del bloque. El primer eslab�n de la manzana o el enlace anterior directamente el bloque se mueve el enfoque para el contenido inmediatamente despu�s del bloque. Activando el enlace avanza el foco del teclado m�s all� del bloque. Cuando hay varios bloques a ser omitidos, el usuario se salta de un bloque a trav�s de estos enlaces.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que un enlace es el �ltimo control enfocable antes de que el bloque de contenido repetitivo o el primer eslab�n de la manzana.
	 * 2. Verificar que la descripci�n del enlace se comunica que se salta el bloque.
	 * 3. Verificar que el enlace est� bien siempre visible o visible cuando tiene el foco del teclado.
	 * 4. Verificar que despu�s de activar el enlace, el foco del teclado se ha movido al contenido inmediatamente despu�s del bloque.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionSaltarBloquesContenidoRepetidos = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Saltar bloques de contenido repetidos.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la descripci�n del enlace se comunica que se salta el bloque.",
				"Evita al usuario tener que pasar bloques de contenido o elementos repetidos con un enlace en el inicio de cada bloque repetido para ir al final de ese bloque.");
		comprobacionSaltarBloquesContenidoRepetidos.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionSaltarBloquesContenidoRepetidos);
		return resultadoEvaluacionTecnica;
	}

}