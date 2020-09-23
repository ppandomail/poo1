package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.html;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaH45 extends TecnicaHTML {

	public TecnicaH45(CategoriaTecnica categoriaTecnica) {
		super(
				"H45", 
				"Usar longdesc.", 
				"El prop�sito de esta t�cnica es proporcionar la informaci�n en un archivo identificado por el atributo longdesc cuando una alternativa textual breve no transmite adecuadamente la funci�n o la informaci�n proporcionada por la imagen. El atributo longdesc es un URI cuyo destino contiene una descripci�n extensa de la imagen. Los autores pueden proporcionar la descripci�n mediante la inclusi�n del texto en un recurso separado o en la misma p�gina que contiene la imagen.",
				categoriaTecnica);
	}

	/**
	 * 1. Verificar que el elemento img tiene un atributo longdesc.
	 * 2. Verificar que el valor del atributo longdesc es una URI de un recurso existente.
	 * 3. Verificar que el contenido en el destino de la URI contiene una descripci�n larga que describe el contenido original no textual asociado a �l. 
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionImagenConAltExtenso = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes con atributo \"alt\" extenso.",
				"Verificar que el elemento \"img\" tiene un atributo \"longdesc\" cuando el atributo \"alt\" es extenso.",
				"Haz breve la \"descripci�n corta\".");
		ResultadoEvaluacionTecnicaItem comprobacionImagenConLongdescPocoExtenso = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes con atributo \"longdesc\" poco extenso.",
				"Verificar que el elemento \"img\" tiene un atributo \"longdesc\" poco extenso.",
				"Describe el contenido no textual mas extensamente s�lo cuando sea necesario.");
		ResultadoEvaluacionTecnicaItem comprobacionImagenConValorLongdescEsRecursoInexistente = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes con valor del atributo \"longdesc\" es un recurso inexistente.",
				"Verificar que el valor del atributo \"longdesc\" es una URI de un recurso existente.",
				"Aseg�rate que el valor del atributo \"longdesc\" es una URI de un recurso existente.");
		ResultadoEvaluacionTecnicaItem comprobacionImagenConValorLongdescEsRecursoMalformado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Im�genes con valor del atributo \"longdesc\" es un recurso malformado.",
				"Verificar que el valor del atributo \"longdesc\" es una URI de un recurso bien formado.",
				"Aseg�rate que el valor del atributo \"longdesc\" es una URI de un recurso bien formado.");
		ResultadoEvaluacionTecnicaItem comprobacionContenidoRecursoDescribeImagen = new ResultadoEvaluacionTecnicaItem(
				Tipologia.IMAGENES, 
				"Contenido en el destino de la URI no describe la imagen.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que el contenido en el destino de la URI contiene una descripci�n larga que describe el contenido original no textual asociado a �l.",
				"Aseg�rate que el contenido en el destino de la URI contiene una descripci�n larga que describe el contenido original no textual asociada a �l.");
		for (Element elementoIMG : this.getParseador().getElementos(HTMLElementName.IMG)) {
			String atributoAlt = elementoIMG.getAttributeValue("alt");
			String atributoLongdesc = elementoIMG.getAttributeValue("longdesc");
			if ((atributoAlt != null) && (atributoAlt.length() > 100) && (atributoLongdesc == null))
				comprobacionImagenConAltExtenso.procesar(elementoIMG);
			if ((atributoLongdesc != null) && (!atributoLongdesc.contains("#"))){
				try {
					BufferedInputStream bufferedInputStream = (BufferedInputStream) new URL("file:" + atributoLongdesc).getContent();
					byte[] buffer = new byte[1024];
					int leidos= 0;
					String contenido = "";
					while ((leidos= bufferedInputStream.read(buffer)) != -1)
						contenido += new String(buffer, 0, leidos);
					bufferedInputStream.close();
					if (contenido.length() <= 100) 
						comprobacionImagenConLongdescPocoExtenso.procesar(elementoIMG);
				} catch (MalformedURLException e) {
					comprobacionImagenConValorLongdescEsRecursoMalformado.procesar(elementoIMG);
				} catch (IOException e) {
					comprobacionImagenConValorLongdescEsRecursoInexistente.procesar(elementoIMG);
				}
				comprobacionContenidoRecursoDescribeImagen.procesar(elementoIMG);
			}
		}		
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenConAltExtenso);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenConLongdescPocoExtenso);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenConValorLongdescEsRecursoInexistente);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionImagenConValorLongdescEsRecursoMalformado);
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionContenidoRecursoDescribeImagen);
		return resultadoEvaluacionTecnica;
	}

}