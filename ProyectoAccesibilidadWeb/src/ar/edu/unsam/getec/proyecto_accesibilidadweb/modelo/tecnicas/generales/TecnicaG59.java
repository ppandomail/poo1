package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG59 extends TecnicaGeneral {

	public TecnicaG59(CategoriaTecnica categoriaTecnica) {
		super(
				"G59",
				"La colocaci�n de los elementos interactivos en un orden que sigue secuencias y relaciones dentro del contenido.",
				"El objetivo de esta t�cnica es asegurar que los elementos interactivos reciben el foco en un orden que sigue a las secuencias y relaciones en el contenido. Al dise�ar el contenido, los elementos interactivos, como los enlaces y controles de formulario se colocan en el contenido para que el orden de tabulaci�n por defecto se ajuste a las secuencias y relaciones en el contenido. Cada tecnolog�a define su orden de tabulaci�n predeterminado, por lo que el mecanismo para la colocaci�n de los controles en el contenido depender� de la tecnolog�a utilizada. A modo de ejemplo, en HTML, el orden de selecci�n predeterminado sigue el orden en el que aparecen los elementos en el origen del contenido. Cuando la orden de la fuente HTML coincide con el orden visual de la p�gina Web, la tabulaci�n a trav�s de los contenidos sigue el dise�o visual del contenido. Cuando la orden de origen no coincide con el orden visual, el orden de tabulaci�n a trav�s del contenido debe reflejar las relaciones l�gicas en el contenido que se muestra visualmente.", 
				categoriaTecnica);
	}

	/**
	 * 1. Determinar el orden de los elementos interactivos en el contenido.
	 * 2. Determinar el orden l�gico de los elementos interactivos.
	 * 3. Verificar que el orden de los elementos interactivos en el contenido es el mismo que el orden l�gico.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionOrdenLogicoNavegacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.NAVEGACION, 
				"Orden l�gico de navegaci�n.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que el orden de los elementos interactivos en el contenido es el mismo que el orden l�gico.",
				"Sit�a los elementos interactivos en una secuencia que siga el orden y las relaciones dentro del contenido.");
		comprobacionOrdenLogicoNavegacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionOrdenLogicoNavegacion);
		return resultadoEvaluacionTecnica;
	}

}