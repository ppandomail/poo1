package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG180 extends TecnicaGeneral {

	public TecnicaG180(CategoriaTecnica categoriaTecnica) {
		super(
				"G180",
				"Proporcionar al usuario un medio para establecer el l�mite de tiempo de 10 veces el l�mite de tiempo predeterminado.",
				"El objetivo de esta t�cnica es dar a las personas con discapacidad suficiente tiempo para completar las tareas que pueden tardar m�s tiempo que alguien sin esas dificultades. Algunos mecanismos, como una opci�n de preferencias o un control de la p�gina  permite al usuario cambiar los l�mites de tiempo de al menos 10 veces el l�mite de tiempo predeterminado. Preferentemente, el mecanismo tendr�a un ajuste variable que permite al usuario cambiar el l�mite de tiempo para cualquier valor en su rango, pero tambi�n podr�a proporcionar formas de cambiar el l�mite de tiempo en incrementos discretos. El usuario cambia el l�mite de tiempo al inicio de su sesi�n, antes de cualquier actividad que tiene un l�mite de tiempo.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar para ver si hay un mecanismo para establecer el l�mite de tiempo de 10 veces el l�mite de tiempo predeterminado.
	 * 2. Cambiar el l�mite de tiempo para un nuevo valor que es 10 veces el l�mite de tiempo predeterminado.
	 * 3. Realizar una acci�n que tiene un l�mite de tiempo.
	 * 4. Espere hasta que haya transcurrido el plazo predeterminado.
	 * 5. Verificar que el plazo no expira hasta el l�mite especificado en el paso 2 ha pasado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLimiteTiempoControladoPorScript = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"L�mite de tiempo controlado mediante un script.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar para ver si hay un mecanismo para establecer el l�mite de tiempo de 10 veces el l�mite de tiempo predeterminado.",
				"Si el l�mite de tiempo es controlado por la programaci�n de la p�gina: Ofrece un medio para aumentar el l�mite de tiempo 10 veces al l�mite predefinido. Avisa al usuario cuando el l�mite de tiempo est� pr�ximo a expirar: y permite que el usuario pueda aumentar el l�mite predefinido.");
		comprobacionLimiteTiempoControladoPorScript.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLimiteTiempoControladoPorScript);
		return resultadoEvaluacionTecnica;
	}

}