package ar.edu.unsam.getec.proyecto_accesibilidadweb.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.EndTag;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.OutputDocument;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.StartTag;
import net.htmlparser.jericho.StartTagType;
import net.htmlparser.jericho.Tag;

public class Parseador {
	
	private Source source;
	private OutputDocument outputDocument;
	public static final String WEB_SITE_JAVADOC = Constantes.URL_JERICHO; 

	public Parseador(URL url) throws IOException {
		this.setSource(new Source(url));
		this.setOutputDocument(new OutputDocument(this.getSource()));
	}

	public Parseador(File file) throws IOException {
		this.setSource(new Source(file));
		this.setOutputDocument(new OutputDocument(this.getSource()));
	}

	public Parseador(String codigo) {
		this.setSource(new Source(codigo));
		this.setOutputDocument(new OutputDocument(this.getSource()));
	}	

	public Source getSource() {
		return this.source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public OutputDocument getOutputDocument() {
		return this.outputDocument;
	}

	public void setOutputDocument(OutputDocument outputDocument) {
		this.outputDocument = outputDocument;
	}

	public List<Element> getElementos() {
		return this.getSource().getAllElements();
	}

	public List<Element> getElementos(String nombre) {
		return this.getSource().getAllElements(nombre);
	}

	public static Element getElemento(List<Element> listaElementos, String nombreElemento) {
		for (Element element : listaElementos)
			if (element.getName().equals(nombreElemento))
				return element;
		return null;
	}

	public List<Tag> getEtiquetas() {
		return this.getSource().getAllTags();
	}

	public List<StartTag> getEtiquetasInicio() {
		return this.getSource().getAllStartTags();
	}

	public List<StartTag> getEtiquetasInicio(StartTagType startTagType) {
		return this.getSource().getAllStartTags(startTagType);
	}

	public EndTag getEtiquetasFin(int pos) {
		return this.getSource().getNextEndTag(pos);
	}

	public boolean esBienFormado() {
		Parser parser = Parser.htmlParser();
		parser.setTrackErrors(100);
		Jsoup.parse(this.getOutputDocument().getSourceText().toString(), "", parser);
		return parser.getErrors().isEmpty();
	}

	public static HashMap<Integer, List<String>> getURLs(Parseador parseador, Integer niveles) {
		HashMap<Integer, List<String>> mapaURL = new HashMap<>();
		for (int i = 1; i <= niveles; i++) {
			List<String> lista = new LinkedList<>();
			if (i==1) {
				for (Element elementoA : parseador.getElementos(HTMLElementName.A)) {
					String atributoHref = elementoA.getAttributeValue("href");
					if (atributoHref != null)
						if (!lista.contains(atributoHref))
							lista.add(atributoHref);
				}
			}
			else {
				for (String url : mapaURL.get(i-1)) {
					try {
						Parseador p = new Parseador(new URL(url));
						for (Element elementoA : p.getElementos(HTMLElementName.A)) {
							String atributoHref = elementoA.getAttributeValue("href");
							if (atributoHref != null)
								if (!lista.contains(atributoHref))
									lista.add(atributoHref);
						}
					} catch(MalformedURLException malformedURLException) {
						System.out.println(malformedURLException.getMessage());
					} catch(IOException ioException) {
						System.out.println(ioException.getMessage());
					}
				}
			}
			mapaURL.put(i, lista);
		}
		return mapaURL;
	}

}