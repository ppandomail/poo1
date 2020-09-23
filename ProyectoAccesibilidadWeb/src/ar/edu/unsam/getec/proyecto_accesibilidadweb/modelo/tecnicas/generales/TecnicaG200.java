package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG200 extends TecnicaGeneral {

	public TecnicaG200(CategoriaTecnica categoriaTecnica) {
		super(
				"G200", 
				"La apertura de nuevas ventanas y pesta�as de un enlace s�lo cuando sea necesario.",
				"El objetivo de esta t�cnica es la de limitar el uso de enlaces o botones que abren nuevas ventanas o pesta�as dentro del contenido Web. En general, es mejor no abrir las ventanas y pesta�as nuevas, ya que pueden desorientar a las personas, especialmente las personas que tienen dificultades para percibir el contenido visual. Sin embargo, hay algunas situaciones en las que es preferible desde el punto de vista de accesibilidad abrir una nueva ventana o pesta�a. Aqu� hay dos tipos de situaciones: 1) �	La apertura de una p�gina que contiene informaci�n contextual, como por ejemplo las instrucciones de ayuda, o un medio alternativo para completar un formulario, como un selector de fechas basado en el calendario, se interrumpir�a considerablemente el flujo de trabajo de m�ltiples pasos, tales como rellenar y enviar un formulario, si la p�gina se abre en la misma ventana o pesta�a. 2) �	El usuario se registra en una zona de seguridad de un sitio, y siguiendo un enlace a una p�gina que est� afuera del �rea de seguridad terminar�a con el inicio de sesi�n del usuario. En esta apertura de los enlaces externos en una ventana nueva que le permita al usuario acceder a tales referencias, manteniendo su nombre de usuario activo en la ventana original.", 
				categoriaTecnica);
	}

	/**
	 * Sin descripci�n!
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAperturaNuevasVentanasPestanasSoloCuandoSeaNecesario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Apertura de nuevas ventanas y pesta�as de un enlace s�lo cuando sea necesario.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la apertura de nuevas ventanas y pesta�as de un enlace s�lo cuando sea necesario.",
				"Abre ventanas nuevas s�lo cuando sea la mejor alternativa.");
		comprobacionAperturaNuevasVentanasPestanasSoloCuandoSeaNecesario.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAperturaNuevasVentanasPestanasSoloCuandoSeaNecesario);
		return resultadoEvaluacionTecnica;
	}

}