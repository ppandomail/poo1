package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG170 extends TecnicaGeneral {

	public TecnicaG170(CategoriaTecnica categoriaTecnica) {
		super(
				"G170",
				"Proporcionar un control casi al principio de la p�gina Web que se apaga sonidos que se reproducen de forma autom�tica.",
				"La intenci�n de esta t�cnica es permitir que un usuario pueda anular los sonidos que se inician autom�ticamente cuando se carga una p�gina. El control para apagar los sonidos debe estar situado cerca del comienzo de la p�gina para permitir el control a sea f�cilmente y r�pidamente descubierto por los usuarios. Esto es �til para aquellos que utilizan tecnolog�as de apoyo (tales como lectores de pantalla, magnificadores de pantalla, dispositivos de conmutaci�n, etc.) y los que no (como los que tienen discapacidad cognitiva, el aprendizaje y lenguaje). En esta t�cnica, un autor incluye un control que hace posible que los usuarios puedan desactivar los sonidos que se reproducen autom�ticamente. El control debe ser operable por teclado, que se encuentra al principio del orden de tabulaci�n y la lectura, y claramente etiquetado para indicar que se va a desactivar los sonidos que se est�n reproduciendo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Cargar la p�gina Web.
	 * 2. Identificar m�sica o sonido que inicie autom�ticamente.
	 * 3. Verificar que el control que permite al usuario apagar el sonido sea provisto cerca del inicio de la p�gina.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionControlApagadoSonidoReproduccionAutomatica = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Control que apaga sonidos que se reproducen de forma autom�tica.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Identificar m�sica o sonido que inicie autom�ticamente: Verificar que el control que permite al usuario apagar el sonido sea provisto cerca del inicio de la p�gina.",
				"Ofrece un control al usuario en el inicio de la p�gina web para que pueda apagar los sonidos que suenan autom�ticamente.");
		comprobacionControlApagadoSonidoReproduccionAutomatica.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionControlApagadoSonidoReproduccionAutomatica);
		return resultadoEvaluacionTecnica;
	}

}