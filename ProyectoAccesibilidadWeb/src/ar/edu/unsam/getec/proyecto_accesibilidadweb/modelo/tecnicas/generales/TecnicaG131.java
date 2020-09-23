package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG131 extends TecnicaGeneral {

	public TecnicaG131(CategoriaTecnica categoriaTecnica) {
		super(
				"G131", 
				"Proporcionar etiquetas descriptivas.", 
				"El objetivo de esta t�cnica es para asegurar que la etiqueta de cualquier componente interactivo dentro del contenido Web hace que el prop�sito del componente claro. Utilizando las t�cnicas a tecnolog�as apropiadas para las tecnolog�as para asociar etiquetas con controles interactivos permite la tecnolog�a de asistencia para reconocer la etiqueta y la presentan al usuario, por lo tanto permitiendo al usuario identificar el prop�sito del control. La etiqueta tambi�n se puede usar para incluir texto o se requiere un s�mbolo de texto que indica que la entrada.", 
				categoriaTecnica);
	}

	/**
	 * Para cada componente de interfaz en el contenido:
	 * 1. Identificar el prop�sito del componente de interfaz.
	 * 2. Verificar que cualquier etiqueta necesaria est� presente.
	 * 3. Verificar que cada etiqueta hace que el prop�sito del componente clara.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionComponentesConEtiquetasDescriptivas = new ResultadoEvaluacionTecnicaItem(
				Tipologia.ESTRUCTURA_Y_SEMANTICA, 
				"Componentes con etiquetas descriptivas.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Para cada componente de interfaz en el contenido: Verificar que cada etiqueta hace que el prop�sito del componente sea claro.",
				"Ofrece etiquetas \"label\" descriptivas a cada componente de interfaz en el contenido.");
		comprobacionComponentesConEtiquetasDescriptivas.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionComponentesConEtiquetasDescriptivas);
		return resultadoEvaluacionTecnica;
	}

}