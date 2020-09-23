package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG73 extends TecnicaGeneral {

	public TecnicaG73(CategoriaTecnica categoriaTecnica) {
		super(
				"G73",
				"Proporcionar una larga descripci�n en otro lugar con un enlace a la misma que se encuentra inmediatamente adyacente al contenido no textual.",
				"El objetivo de esta t�cnica es proporcionar una manera de enlazar a largas descripciones remotas de las tecnolog�as que no cuentan con una larga descripci�n de funciones integrada directamente en ellas (por ejemplo, longdesc) o cuando la funci�n es conocida por no ser compatible. Con esta t�cnica, la descripci�n larga se proporciona en otro lugar que el contenido no textual. Esto podr�a ser en otro lugar dentro de la misma URI o en otro URI. Un enlace a la descripci�n larga est� previsto que se encuentra inmediatamente adyacente al contenido no textual. El enlace puede ser inmediatamente antes o despu�s de que el contenido no textual. Si la descripci�n se encuentra junto con otro texto a continuaci�n, poner 'Fin de la descripci�n' al final para que sepan cu�ndo dejar de leer y volver a la p�gina principal. Si un bot�n 'Volver' no va a llevar a la persona de nuevo al punto desde el que saltaron, se proporciona a continuaci�n un enlace a la ubicaci�n del contenido no textual. Esta t�cnica era utilizada com�nmente en HTML antes de la adicion de 'longdesc' a la especificaci�n. En HTML se denominaba D-Link, porque se implementaba normalmente poniendo una D junto a las im�genes y el uso de la D como un enlace a la descripci�n larga. Esta t�cnica no es una tecnolog�a espec�fica y puede ser utilizado en cualquier tecnolog�a que soporta enlaces.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar la presencia de un enlace inmediatamente antes o despu�s que el contenido no textual.
	 * 2. Verificar que el enlace es un enlace v�lido que apunta directamente a la descripci�n larga de este contenido no textual particular.
	 * 3. Verificar que la descripci�n larga transmite la misma informaci�n que el contenido no textual.
	 * 4. Verificar la disponibilidad de un enlace o la funcion retornar para devolver al usuario a la ubicaci�n original del contenido no textual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionEnlaceAntesDespuesContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Presencia de enlace antes o despu�s que el contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la presencia de un enlace inmediatamente antes o despu�s que el contenido no textual.",
				"Utiliza un archivo externo con la descripci�n extensa, indicando su localizaci�n con un enlace situado justo al lado del contenido no textual.");
		comprobacionEnlaceAntesDespuesContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionEnlaceAntesDespuesContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}