package ar.edu.unsam.getec.proyecto_accesibilidadweb.util;

import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

public class Utilidades {
	
	private Utilidades() {

	}

	public static String separarCaracteresPorComa(String string) {
		String stringARetornar = "";
		for (Integer i=0; i<string.length(); i++)
			if (i != (string.length() - 1))
				stringARetornar += String.valueOf(string.charAt(i) + ", ");
			else
				stringARetornar += String.valueOf(string.charAt(i));
		return stringARetornar;

	}

	public static String getTextoFormateado(String texto) {
		return Utilidades.getTextoFormateadoHasta(texto, 100, Boolean.FALSE);
	}

	public static String getTextoFormateadoHTML(String texto) {
		return Utilidades.getTextoFormateadoHasta(texto, 100, Boolean.TRUE);
	}

	private static String getTextoFormateadoHasta(String texto, Integer hasta, Boolean esHTML) {
		String formateado = "";
		String linea = "";
		String [] split = texto.split(" ");
		for (String palabra : split) {
			linea += palabra.concat(" ");
			if (linea.length() >= hasta) {
				formateado += linea + ((esHTML)? " <BR> " : "\n");
				linea = "";
			}	
		}
		return formateado.isEmpty()? String.format("%1$-" + hasta + "s", texto) : formateado.concat(linea);
	}

	public static String truncarLineaHasta(String linea, Integer hasta) {
		return linea.length() > hasta ? linea.substring(0, hasta).concat(" ... ") : linea;
	}

	public static String getTextoFormateadoConLongitud(String texto, Integer integer) {
		return String.format("%1$-" + integer + "s", texto);
	}

	public static String completarURL(String url) {
		return (url.startsWith("http://") || url.startsWith("https://"))? url : "http://".concat(url);
	}

	public static String getTextFormateadoToolTip(String tip,int length) {
		if(tip.length() <= length + 10 )
			return tip;
		List<String>  parts = new ArrayList<>();
		int maxLength = 0;
		String overLong = tip.substring(0, length + 10);
		int lastSpace = overLong.lastIndexOf(' ');
		if(lastSpace >= length) {
			parts.add(tip.substring(0,lastSpace));
			maxLength = lastSpace;
		}
		else {
			parts.add(tip.substring(0,length));
			maxLength = length;
		}
		while(maxLength < tip.length()) {
			if(maxLength + length < tip.length()) {
				parts.add(tip.substring(maxLength, maxLength + length));
				maxLength += maxLength+length;
			}
			else {
				parts.add(tip.substring(maxLength));
				break;
			}
		}
		StringBuilder  stringBuilder = new StringBuilder("<html>");
		for(int i=0; i<parts.size() - 1; i++)
			stringBuilder.append(parts.get(i)+"<br>");
		stringBuilder.append(parts.get(parts.size() - 1));
		stringBuilder.append(("</html>"));
		return stringBuilder.toString();
	}
	
	public static List<Image> getListaLogos() {
		List<Image> listaLogos = new LinkedList<>();
		listaLogos.add(new ImageIcon(Constantes.PATH_IMAGE_LOGO16).getImage());
		listaLogos.add(new ImageIcon(Constantes.PATH_IMAGE_LOGO32).getImage());
		listaLogos.add(new ImageIcon(Constantes.PATH_IMAGE_LOGO48).getImage());
		return listaLogos;
	}

}