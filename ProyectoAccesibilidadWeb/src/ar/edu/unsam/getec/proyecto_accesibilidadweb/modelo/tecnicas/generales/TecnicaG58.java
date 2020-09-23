package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG58 extends TecnicaGeneral {

	public TecnicaG58(CategoriaTecnica categoriaTecnica) {
		super(
				"G58",
				"Un acceso directo a la alternativa de los medios de comunicaci�n basados en el tiempo inmediatamente al lado del contenido no textual.",
				"Con esta t�cnica, se proporciona un link al documento compaginado que recopile la descripci�n de audio y subt�tulos. El documento compaginado podr�a estar en otro lugar, en la misma p�gina Web o en otro URI. Un enlace al documento compaginado es inmediatamente adyacente al contenido no textual. El link puede ser inmediatamente antes o despu�s sincronizado con el contenido multimedia. Si el documento compaginado est� en la misma p�gina Web como otros contenidos a continuaci�n, colocar \"Fin del documento\" al final para que sepan cu�ndo dejar de leer y volver a su lugar anterior. Si un bot�n Back no llevar� a la persona de nuevo al punto desde el que saltaron, se proporciona a continuaci�n un link a la ubicaci�n del contenido no textual.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar la presencia de un link inmediatamente antes o despu�s del contenido no textual.
	 * 2. Verificar que es un link valido, que apunta directamente al documento ingresado de este medio sincronizado en particular.
	 * 3. Verificar la disponibilidad de un link o su funci�n trasera para conseguir que el usuario vuelva a la localizaci�n original del contenido multimedia sincronizado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionLinkContenidoNoTextual = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Link antes o despu�s del contenido no textual.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar la presencia de un link inmediatamente antes o despu�s del contenido no textual.",
				"Ofrece un enlace a la alternativa de los medios tempodependientes.");
		comprobacionLinkContenidoNoTextual.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionLinkContenidoNoTextual);
		return resultadoEvaluacionTecnica;
	}

}