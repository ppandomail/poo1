package ar.edu.unsam.getec.proyecto_accesibilidadweb.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Constantes;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Utilidades;

public class DialogoHTML extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private static final Color COLOR = new Color(245, 245, 245);

	public DialogoHTML(JFrame jFrame, String codigo, Hashtable<Integer, List<TipoResultadoEvaluacion>> registroLineas) {
		super(jFrame, Constantes.TITULO_HTML);
		this.setIconImages(Utilidades.getListaLogos());
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(DialogoHTML.COLOR);
		this.add(this.getPanelPrincipal(codigo, registroLineas), BorderLayout.CENTER);
		this.setResizable(Boolean.FALSE);
		this.setVisible(Boolean.TRUE);
	}

	public JPanel getPanelPrincipal(String codigo, Hashtable<Integer, List<TipoResultadoEvaluacion>> registroLineas) {
		JPanel jPanelPrincipal = new JPanel();
		jPanelPrincipal.setBackground(DialogoHTML.COLOR);
		JTextPaneHTML jTextPane = new JTextPaneHTML();
		String [] split = codigo.split("\n");
		Integer contadorLinea = 1;
		for (String linea : split) {
			jTextPane.agregarTexto(Color.BLACK, contadorLinea + ".  "); 
			if (registroLineas.containsKey(contadorLinea)){
				for (TipoResultadoEvaluacion tipoResultadoEvaluacion : registroLineas.get(contadorLinea)) 
					jTextPane.agregarImagen(tipoResultadoEvaluacion.getRepresentacionPathImagen());
			}
			jTextPane.agregarTexto(Color.BLACK, "\t" + linea + "\n");
			contadorLinea++;
		}
		jTextPane.setCaretPosition(0);
		jTextPane.setEditable(Boolean.FALSE);
		JScrollPane scrollPane = new JScrollPane(jTextPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(470, 365));
		jPanelPrincipal.add(scrollPane);
		return jPanelPrincipal;
	}

}
