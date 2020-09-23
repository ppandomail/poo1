package ar.edu.unsam.getec.proyecto_accesibilidadweb.vista;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Etiqueta extends JLabel {
	
	private static final long serialVersionUID = 1L;
	private Object object;

	public Etiqueta(Object object, String texto, Icon icon) {
		super(texto);
		this.setHorizontalTextPosition(SwingConstants.LEFT);
		this.setHorizontalAlignment(SwingConstants.LEADING);
		this.setIcon(icon);
		this.setObject(object);
	}

	public Object getObject() {
		return this.object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}