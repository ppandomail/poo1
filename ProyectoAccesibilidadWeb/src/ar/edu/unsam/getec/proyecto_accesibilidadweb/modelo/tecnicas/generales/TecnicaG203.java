package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG203 extends TecnicaGeneral {

	public TecnicaG203(CategoriaTecnica categoriaTecnica) {
		super(
				"G203", 
				"El uso de una alternativa de texto est�tico para describir un video busto parlante.",
				"El prop�sito de esta t�cnica es proporcionar una alternativa a la descripci�n de audio para la multimedia sincronizada que no dispone de informaci�n basada en el tiempo importante contenida en la parte de v�deo de la media. Esto se aplica particularmente a los v�deos de \"presentaci�n\" en que una persona est� hablando delante de un fondo inmutable, como una rueda de prensa, la empresa presidente de conversaci�n, o anuncio del gobierno, etc. En este caso no hay \"detalles visuales importantes\", que har�a justificar la descripci�n de audio. La descripci�n de audio no es necesaria cuando hay una persona que habla en contra de un fondo que no cambia porque no hay informaci�n visual basada en el tiempo en el video que es \"importante\" para la comprensi�n de los contenidos. El entorno es est�tico y por lo tanto puede ser descrito en un formato no multimedia est�tico, tales como texto alternativo que esta programadamente asociada con el v�deo. Todo lo que es necesario en este caso es un texto alternativo est�tico que contendr�a una descripci�n general del contexto del medio ambiente, cualquier apertura/cierre de cr�ditos, cualquier texto que aparece en la parte inferior del video con el nombre del que habla, y otra informaci�n b�sica, si �stos se ven en la pantalla y no se pueden escuchar en el audio. Esta t�cnica NO se aplica a una situaci�n en la que hay varios altavoces y donde la identidad de cada nuevo altavoz no es evidente en la pista de audio, pero se identifica en la pantalla con texto visual, ya que hablan. En este caso, la descripci�n de audio debe ser utilizado, y esta t�cnica no se aplicar�a.", 
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que no hay informaci�n importante basada en el tiempo en la pista de v�deo.
	 * 2. Verificar que la programada descripci�n asociada a los contenidos multimedia contiene contexto del contenido que no est� contenido en la pista de audio (por ejemplo, la identificaci�n del hablante, cr�ditos, contexto).
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionAlternativaTextualVideoPresentacion = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PRESENTACION, 
				"Alternativa de texto para videos de presentaci�n", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que la programada descripci�n asociada a los contenidos multimedia contiene contexto del contenido que no est� contenido en la pista de audio (por ejemplo, la identificaci�n del hablante, cr�ditos, contexto).",
				"Ofrece una versi�n del v�deo con una alternativa de texto est�tico para describir el contenido que no est� en la pista de audio.");
		comprobacionAlternativaTextualVideoPresentacion.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionAlternativaTextualVideoPresentacion);
		return resultadoEvaluacionTecnica;
	}

}