package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG134 extends TecnicaGeneral {

	public TecnicaG134(CategoriaTecnica categoriaTecnica) {
		super(
				"G134", 
				"Validar las p�ginas Web.", 
				"El objetivo de esta t�cnica es evitar las ambig�edades en las p�ginas web que con frecuencia resultan de c�digo que no es v�lido seg�n las especificaciones formales. se utiliza el mecanismo de cada tecnolog�a para especificar la versi�n de la tecnolog�a y la tecnolog�a, y la p�gina Web se valida con la especificaci�n formal de dicha tecnolog�a. Si un validador para que la tecnolog�a est� disponible, el desarrollador puede usarlo. Validaci�n por lo general eliminar ambig�edades (y m�s), ya que un paso esencial en la validaci�n es comprobar el uso adecuado de marcado de que la tecnolog�a (en un lenguaje de marcas) o el c�digo (en otras tecnolog�as). La validaci�n no significa necesariamente comprobar la plena conformidad con una especificaci�n, pero es el mejor medio para comprobar autom�ticamente el contenido en contra de su especificaci�n.", 
				categoriaTecnica);
	}

	/**
	 * Para HTML, SGML y basados en tecnolog�as basadas en XML:
	 * 1. Cargar cada p�gina o documento en un analizador de validaci�n.
	 * 2. Verificar que no hay errores de validaci�n se encuentran.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPaginaBienFormada = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"P�gina 'bien formada'.",
				"Verificar que no hay errores de validaci�n.",
				"Aseg�rate que la p�gina web puede ser procesada y est� bien formada.");
		if (!this.getParseador().esBienFormado())
			comprobacionPaginaBienFormada.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPaginaBienFormada);
		return resultadoEvaluacionTecnica;
	}

}