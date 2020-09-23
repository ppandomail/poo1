package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG140 extends TecnicaGeneral {

	public TecnicaG140(CategoriaTecnica categoriaTecnica) {
		super(
				"G140",
				"Separar la informaci�n y la estructura en la presentaci�n para permitir presentaciones diferentes.",
				"El objetivo de esta t�cnica es la de facilitar la interacci�n de la tecnolog�a de asistencia con el contenido mediante la separaci�n l�gica de codificaci�n estructural del contenido de la codificaci�n de presentaci�n. Codificaci�n estructural es la indicaci�n de elementos como encabezados, p�rrafos, listas, tablas, etc., y se realiza mediante el uso de caracter�sticas de la tecnolog�a reservada para tal fin. Por el contrario, la codificaci�n de presentaci�n es la indicaci�n de los efectos de formato, tales como tipo de letra, color, tama�o, posici�n, bordes, etc., y tambi�n es apoyado por caracter�sticas de la tecnolog�a. Mientras que implican elementos de presentaci�n visual estructura - los usuarios pueden determinar encabezados, p�rrafos, listas, etc., de las convenciones de formato utilizados - estas caracter�sticas no codifican la estructura sin ambig�edad suficiente para que la tecnolog�a de asistencia para interactuar con la p�gina de forma efectiva. Proporcionar capas de estructura, funcionalidad y presentaci�n por separado permite la sem�ntica que implica el formato para convertirse en determinaron mediante programaci�n a trav�s de la capa de estructura.", 
				categoriaTecnica);
	}

	/**
	 * 1. Examinar la codificaci�n de un documento.
	 * 2. Verificar que la informaci�n estructural y la funcionalidad se proporcionan de manera expl�cita y est� separada l�gicamente de informaci�n de presentaci�n.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionUtilizacionAtributosPresentacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Utilizaci�n de atributos de presentaci�n.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que la informaci�n estructural y la funcionalidad se proporcionan de manera expl�cita y est� separada l�gicamente de informaci�n de presentaci�n.",
				"Si la tecnolog�a ofrece una estructura sem�ntica para comunicar la informaci�n y las relaciones (por ejemplo, HTML), separa la informaci�n y la estructura de la forma de presentaci�n para permitir al usuario disponer de diferentes presentaciones, por ejemplo, utilizando sus propias hojas de estilo.");
		ResultadoEvaluacionTecnicaItem comprobacionUtilizacionEtiquetasPresentacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Utilizaci�n de etiquetas de presentaci�n.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que la informaci�n estructural y la funcionalidad se proporcionan de manera expl�cita y est� separada l�gicamente de informaci�n de presentaci�n.",
				"Si la tecnolog�a ofrece una estructura sem�ntica para comunicar la informaci�n y las relaciones (por ejemplo, HTML), separa la informaci�n y la estructura de la forma de presentaci�n para permitir al usuario disponer de diferentes presentaciones, por ejemplo, utilizando sus propias hojas de estilo.");
		comprobacionUtilizacionAtributosPresentacion.procesar();
		comprobacionUtilizacionEtiquetasPresentacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionUtilizacionAtributosPresentacion);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionUtilizacionEtiquetasPresentacion);
		return resultadoEvaluacionTecnica;
	}

}