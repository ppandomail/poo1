package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG21 extends TecnicaGeneral {

	public TecnicaG21(CategoriaTecnica categoriaTecnica) {
		super(
				"G21", 
				"Asegurar que los usuarios no se encuentran atrapados en el contenido.", 
				"El objetivo de esta t�cnica es asegurar que los usuarios de teclado no se encuentren atrapados en un subconjunto del contenido del cual solo pueda salirse con un mouse o un dispositivo para apuntar. Un ejemplo com�n es el contenido renderizado por plug-ins. Los plug-ins son agentes usuario que renderizan contenido dentro de un agente usuario de host de ventana y responden a todas las acciones de usuarios que tengan lugar mientras el plug-in sea el foco. Si el plug-in no provee un mecanismo de teclado para devolver el foco a la ventana, los usuarios que deban usar el teclado pueden encontrarse atrapados en el contenido del plug-in. Este problema se puede evitar mediante el uso de uno de los siguientes mecanismos para proporcionar una manera para que los usuarios escapen el subconjunto del contenido: Asegurar que la funci�n del teclado para hacer avanzar el enfoque en el contenido (com�nmente la tecla de tabulaci�n) sale del subconjunto del contenido despu�s de que llegue a la ubicaci�n de navegaci�n final. Proporcionar una funci�n de teclado para mover el enfoque fuera del subconjunto del contenido. Aseg�rese de documentar la caracter�stica de una forma accesible dentro del subconjunto. Si la tecnolog�a utilizada en el subconjunto del contenido de forma nativa proporciona un comando de teclado \"mover a los padres\", la documentaci�n de ese comando antes de que el usuario entra en el plug-in para que sepan c�mo salir de nuevo. Si el autor utiliza una tecnolog�a que permite a los usuarios introducir la sub-contenido con el teclado y no permite a los usuarios salir del sub-contenido con el teclado por defecto (es decir, no es una caracter�stica de la tecnolog�a de contenido Web o aplicaciones de usuario) a continuaci�n, con el fin de poner en pr�ctica esta t�cnica el autor sea para construir esa capacidad en su contenido o no utilizar la tecnolog�a.",
				categoriaTecnica);
	}

	/**
	 * 1. Tabular el contenido desde el incio hasta el final.
	 * 2. Verificar para ver que el enfoque del teclado no este atrapado en ninguno de los contenidos.
	 * 3. Si el enfoque del teclado parece estar atrapado en alguno de los contenidos, verificar que la informaci�n de ayuda est� disponible explicando como salir del contenido y como acceder v�a teclado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMovimientoFocoMedianteTeclado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Movimiento del foco mediante teclado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar para ver que el enfoque del teclado no este atrapado en ninguno de los contenidos.",
				"Asegurate que los usuarios no queden atrapados en el contenido. No combines varios formatos de contenido en una forma que los usuarios puedan quedar atrapados dentro de un tipo de formato.");
		comprobacionMovimientoFocoMedianteTeclado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMovimientoFocoMedianteTeclado);
		return resultadoEvaluacionTecnica;
	}

}