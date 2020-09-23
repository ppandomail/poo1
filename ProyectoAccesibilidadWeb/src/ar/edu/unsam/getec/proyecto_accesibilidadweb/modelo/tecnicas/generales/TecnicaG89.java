package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG89 extends TecnicaGeneral {

	public TecnicaG89(CategoriaTecnica categoriaTecnica) {
		super(
				"G89", 
				"Proporcionar espera formato de datos y el ejemplo.", 
				"El objetivo de esta t�cnica es ayudar al usuario a evitar errores de entrada, ofreci�ndoles informaci�n sobre restricciones en el formato de los datos que se deben introducir. Esto se puede hacer mediante la descripci�n de las caracter�sticas del formato o proporcionar una muestra del formato de los datos deben tener.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar los controles de formulario que s�lo aceptar� los datos de entrada del usuario en un formato determinado.
	 * 2. Determinar si cada uno de los controles de formulario identificados en 1 proporciona informaci�n sobre el formato esperado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormatoDatosEsperado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Informaci�n sobre formato de datos esperado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Determinar si cada uno de los controles de formulario que s�lo aceptar� los datos de entrada del usuario en un formato determinado proporciona informaci�n sobre el formato esperado.",
				"Ofrece etiquetas \"label\" descriptivas para indicar el formato esperado de los datos y pon un ejemplo.");
		comprobacionFormatoDatosEsperado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormatoDatosEsperado);
		return resultadoEvaluacionTecnica;
	}

}