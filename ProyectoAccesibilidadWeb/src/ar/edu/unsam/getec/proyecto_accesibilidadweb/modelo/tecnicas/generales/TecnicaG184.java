package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG184 extends TecnicaGeneral {

	public TecnicaG184(CategoriaTecnica categoriaTecnica) {
		super(
				"G184",
				"Proporcionar instrucciones de texto al principio de una forma o conjunto de campos que describe la entrada necesaria.",
				"El objetivo de esta t�cnica es ayudar al usuario a evitar errores de entrada, inform�ndoles de antemano acerca de las restricciones sobre el formato de los datos que se deben introducir. La instrucciones de las restricciones previstas en la parte superior de las formas. Esta t�cnica funciona mejor para las formas que tienen un peque�o n�mero de campos o aquellos en los que muchos campos de formulario requieren datos en el mismo formato. En estos casos, es m�s eficiente para describir el formato de una vez en las instrucciones en la parte superior de la forma en lugar de repetir la misma informaci�n para cada campo que tiene el mismo requisito formato restringido.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar los controles de formulario que s�lo aceptar� los datos de entrada del usuario en un formato determinado.
	 * 2. Determinar si se proporcionan instrucciones en la parte superior de la forma sobre el formato esperado de cada uno de los controles de formulario identificados en 1.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormatoDatosEsperado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Informaci�n sobre formato de datos esperado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Determinar si se proporcionan instrucciones en la parte superior de la forma sobre el formato esperado de cada uno de los controles de formulario que s�lo aceptar� los datos de entrada del usuario en un formato determinado.",
				"Ofrece etiquetas \"label\" descriptivas para dar instrucciones al comienzo del formulario o de un grupo de campos.");
		comprobacionFormatoDatosEsperado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormatoDatosEsperado);
		return resultadoEvaluacionTecnica;
	}

}