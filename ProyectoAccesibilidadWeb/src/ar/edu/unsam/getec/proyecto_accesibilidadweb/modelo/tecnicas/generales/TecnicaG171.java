package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG171 extends TecnicaGeneral {

	public TecnicaG171(CategoriaTecnica categoriaTecnica) {
		super(
				"G171", 
				"Reproducci�n de sonidos s�lo a petici�n del usuario.", 
				"La intenci�n de esta t�cnica es permitir a un usuario controlar el uso de sonidos en el contenido Web. Alguien que utiliza un lector de pantalla puede resultar muy molesto y dif�cil de escuchar a su lector de pantalla si hay tambi�n sonidos procedentes de contenido Web. Proporcionando una manera de reproducir sonidos �nicamente a petici�n dar� a un usuario el control necesario para escuchar sonidos o otros archivos de audio sin interferir con la salida de un lector de pantalla.", 
				categoriaTecnica);
	}

	/**
	 * 1. Cargar una p�gina Web que se conoce que contiene sonidos que se reproducen por 3 segundos o mas.
	 * 2. Verificar que los sonidos no se reproduzcan autom�ticamente.
	 * 3. Verificar que haya un forma para que el usuario inicie los sonidos manualmente.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFormaUsuarioInicieSonidosManualmente = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Forma para que el usuario inicie los sonidos manualmente.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Cargar una p�gina Web que se conoce que contiene sonidos que se reproducen por 3 segundos o mas: Verificar que haya un forma para que el usuario inicie los sonidos manualmente.",
				"Reproduce los sonidos s�lo a petici�n del usuario.");
		comprobacionFormaUsuarioInicieSonidosManualmente.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFormaUsuarioInicieSonidosManualmente);
		return resultadoEvaluacionTecnica;
	}

}