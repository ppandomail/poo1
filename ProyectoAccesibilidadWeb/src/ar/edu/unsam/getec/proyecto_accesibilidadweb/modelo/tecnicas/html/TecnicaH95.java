package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH95 extends TecnicaHTML {

	public TecnicaH95(CategoriaTecnica categoriaTecnica) {
		super(
				"H95", 
				"Usar el elemento track para proporcionar subt�tulos.", 
				"El objetivo de esta t�cnica es utilizar el elemento track para especificar una pista de texto de subt�tulos temporizados para un elemento video. Las pistas de texto de subt�tulo temporizado contienen transcripciones o traducciones del di�logo, efectos de sonido, m�sica relevante y otro informaci�n de audio importante adecuada para cuando el sonido no est� disponible o no claramente audible. El atributo src del elemento track es una URL que es la direcci�n de los datos de la pista de texto. El atributo kind del elemento track indica el tipo de informaci�n en el texto temporizado. Las pistas de texto de subut�tulo proveen una versi�n de texto del di�logo y otros sonidos importantes para entender el video. Los subt�tulos contienen solamente el di�logo. Si otra informaci�n de audio es importante para entender el video, una pista de subt�tulo no ser� suficiente para cumplir con los criterios de �xito.", 
				categoriaTecnica);
	}

	/**
	 *  Por cada elemento video que se utiliza para reproducir un video:
	 *  1. Verificar que el video contiene un elemento track con kind="captions" en el idioma del video.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionVideoConTrackConKindSinValorCaptions = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Videos con elemento \"track\" con atributo \"kind\" sin valor \"captions\".",
				"Por cada elemento \"video\" que se utiliza para reproducir un video: Verificar que el elemento \"video\" contiene un elemento \"track\" con atributo kind=\"captions\" en el idioma del video.",
				"No omitas los subt�tulos para sordos (subt�tulos generales  que incluyen informaci�n sobre los sonidos que suceden) en di�logos o efectos de sonido importantes, utilizando el elemento \"track\", para proporcionar subt�tulos en el idioma del v�deo.");
		for (Element elementoVIDEO : this.getParseador().getElementos(HTMLElementName.VIDEO))
			for (Element elementoTRACK : elementoVIDEO.getAllElements("track")) {
				String atributoKind = elementoTRACK.getAttributeValue("kind");
				if ((atributoKind != null) && (!atributoKind.equals("captions")))
					comprobacionVideoConTrackConKindSinValorCaptions.procesar(elementoTRACK);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionVideoConTrackConKindSinValorCaptions);
		return resultadoEvaluacionTecnica;
	}

}