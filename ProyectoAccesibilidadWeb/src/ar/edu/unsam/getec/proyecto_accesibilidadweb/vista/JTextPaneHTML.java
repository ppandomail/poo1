package ar.edu.unsam.getec.proyecto_accesibilidadweb.vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class JTextPaneHTML extends JTextPane {
	
	private static final long serialVersionUID = 1L;

	public void agregarTexto(Color color, String texto) {
		StyleContext styleContext = StyleContext.getDefaultStyleContext();
		AttributeSet attributeSet = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
		Integer longitudDocumento = getDocument().getLength(); 
		this.setCaretPosition(longitudDocumento); 
		this.setCharacterAttributes(attributeSet, false);
		this.replaceSelection(texto); 
	}   

	public void agregarImagen(String url) {
		this.insertIcon(new ImageIcon(url));
	}

}