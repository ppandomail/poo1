package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG78 extends TecnicaGeneral {

	public TecnicaG78(CategoriaTecnica categoriaTecnica) {
		super(
				"G78",
				"Proporcionar un segundo, seleccionable por el usuario, pista de audio que incluye descripciones de audio.",
				"El objetivo de esta t�cnica es proporcionar una versi�n de audio (hablado) de la informaci�n que se proporciona visualmente por lo que es posible para las personas que no pueden ver ser capaz de entender el material audiovisual. Dado que los agentes de usuario hoy en d�a no se puede combinar m�ltiples pistas de sonido, esta t�cnica a�ade la informaci�n de audio adicional a los medios sincronizados, proporcionando una opci�n que permite a los usuarios reemplazar la banda sonora con una nueva copia de la banda sonora original que tiene la descripci�n de audio adicional a�adido. Esta informaci�n a�adida se centra en acciones, personajes, cambios de escena y en pantalla de texto (capturas) que son importantes para entender el contenido. Dado que no es �til contar con esta nueva informaci�n de la informaci�n de audio clave oscura en la banda sonora original (o ser oscurecida por los efectos de sonido altos), se a�ade la nueva informaci�n durante las pausas en el di�logo y efectos de sonido. Esto limita la cantidad de informaci�n suplementaria que puede ser a�adido al programa. La banda sonora con la descripci�n de audio (de la informaci�n visual) puede ser o bien una pista de sonido alternativo que el usuario puede elegir, o puede ser la pista de sonido est�ndar que todo el mundo escucha.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que existe la capacidad para encender la pista de audio que incluye descripciones de audio. Por ejemplo, mediante el uso de un control en el contenido en s� mismo o mediante la selecci�n de un control o de preferencia en el reproductor multimedia o en el sistema operativo.
	 * 2. Escuchar el contenido multimedia sincronizado.
	 * 3. Verificar si las lagunas en el di�logo se utilizan para transmitir informaci�n importante relacionada con el contenido visual.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionPistaAudio = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Capacidad para encesder la pista de audio que incluye descripciones de audio.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que existe la capacidad para encender la pista de audio que incluye descripciones de audio.",
				"Agrega una segunda pista de sonido, seleccionable por el usuario, que incluya la audiodescripci�n (sistema destinado a personas con discapacidad visual, mediante el cual se suministra informaci�n sonora que traduce o explica un contenido visual, como los gestos de un personaje,  el vestuario, los paisajes, etc.)");
		comprobacionPistaAudio.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionPistaAudio);
		return resultadoEvaluacionTecnica;
	}

}