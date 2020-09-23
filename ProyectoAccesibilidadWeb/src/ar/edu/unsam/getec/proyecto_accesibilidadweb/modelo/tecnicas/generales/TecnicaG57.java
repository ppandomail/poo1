package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG57 extends TecnicaGeneral {

	public TecnicaG57(CategoriaTecnica categoriaTecnica) {
		super(
				"G57", 
				"Ordenar el contenido de una secuencia significativa.", 
				"El objetivo de esta t�cnica es asegurar que el orden del contenido que se presenta para las ayudas t�cnicas permite al usuario tener sentido del contenido. Algunas t�cnicas permiten que el contenido que pasar�n a ser visualmente en una secuencia significativa incluso si esta es diferente del orden en el que el contenido est� codificado en el archivo de origen subyacente. Por ejemplo, cuando se mezclan idiomas con direccionalidad diferente en HTML, el algoritmo bidireccional puede posicionar puntuaci�n en el lugar equivocado en la prestaci�n visual. El problema de representaci�n visual podr�a corregirse moviendo la puntuaci�n en el flujo de contenido para que el algoritmo bidireccional lo posiciona como se desee, pero esto podr�a exponer el contenido incorrecto fin a la tecnolog�a de asistencia . El contenido se vuelve tanto en el orden correcto visualmente y se expone a la tecnolog�a de asistencia en el orden correcto mediante el uso de marcadores para anular el algoritmo bidireccional. Cuando se representa visualmente, los espacios en blanco como espacio o ficha no pueden aparecer como parte del contenido. Sin embargo, cuando se inserta en el contenido para controlar el formato visual, que pueden interferir con el significado del contenido. En una granularidad m�s grande, el control de la colocaci�n de bloques de contenido en un documento HTML utilizando tablas de dise�o puede producir una representaci�n en la que la informaci�n relacionada est� posicionado junto visualmente , pero separado en el flujo de contenido. Dado que las tablas de dise�o se leen fila por fila, si el t�tulo de una ilustraci�n se coloca en la fila siguiente a la ilustraci�n , puede que sea imposible asociar el t�tulo con la imagen.", 
				categoriaTecnica);
	}

	/**
	 * 1. Linealizar el contenido con un enfoque est�ndar para la tecnolog�a (por ejemplo, la eliminaci�n de estilos de dise�o o ejecutar una herramienta de linealizaci�n)
	 * 2. Verificar  si el orden del contenido da el mismo significado que el original.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionContenidoSecuenciaSignificativaOrdenado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Contenido de una secuencia significativa ordenado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar  si el orden del contenido da el mismo significado que el original.",
				"Ordena todos los contenidos de la p�gina web en un orden que tenga sentido y maqu�talos asegur�ndote si el orden del contenido da el mismo significado que el original.");
		comprobacionContenidoSecuenciaSignificativaOrdenado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoSecuenciaSignificativaOrdenado);
		return resultadoEvaluacionTecnica;
	}

}