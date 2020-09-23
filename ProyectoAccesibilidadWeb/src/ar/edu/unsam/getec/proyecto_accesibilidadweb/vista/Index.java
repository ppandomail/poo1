package ar.edu.unsam.getec.proyecto_accesibilidadweb.vista;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador.ControlInformacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador.GestorControlValidacionAccesibilidad;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador.GestorValidacionURL;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador.TipoValidacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Constantes;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Contexto;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ContextoClaves;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Utilidades;

public class Index extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private static final Color COLOR = new Color(245,245,245);
	private JTabbedPane jTabbedPaneSolapas;
	private JTextField jTextFieldURL;
	private JTextField jTextFieldPathArchivo;
	private JTextArea jTextAreaCodigo;
	private JList<String> jListURL;
	private DefaultListModel<String> modeloListaURL;
	private JCheckBox jCheckBoxPrincipio1;
	private JCheckBox jCheckBoxPrincipio2;
	private JCheckBox jCheckBoxPrincipio3;
	private JCheckBox jCheckBoxPrincipio4;
	private JButton jButtonExaminar;
	private JButton jButtonValidar;
	private Timer monitorValidador;

	public Index() {
		this.setIconImages(Utilidades.getListaLogos());
		this.setTitle(Constantes.TITULO_PRINCIPAL.concat(" ").concat(Constantes.VERSION));
		this.setSize(880, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				cerrar();
			}
		});
		this.add(this.getPanelPrincipal());
		this.getRootPane().setDefaultButton(this.getjButtonValidar());
		this.setResizable(Boolean.TRUE);
		this.setVisible(Boolean.TRUE);
	}

	private JPanel getPanelPrincipal() {
		JPanel jPanelPrincipal = new JPanel();
		jPanelPrincipal.setBackground(Index.COLOR);
		jPanelPrincipal.setBorder(BorderFactory.createTitledBorder("<HTML><H1>Evaluación de la Accesibilidad Web</H1></HTML>"));
		jPanelPrincipal.setLayout(new GridLayout(3, 1));
		jPanelPrincipal.add(this.getPanelSolapas());
		jPanelPrincipal.add(this.getPanelPrincipiosAVerificar());
		jPanelPrincipal.add(this.getPanelBotonValidarYAcercaDe());
		return jPanelPrincipal;
	}

	private JPanel getPanelSolapas() {
		JPanel jPanelSolapas = new JPanel();
		jPanelSolapas.setBackground(Index.COLOR);
		UIManager.put("TabbedPane.selected", Color.WHITE);
		this.setjTabbedPaneSolapas(new JTabbedPane());
		this.getjTabbedPaneSolapas().addTab("<HTML><H2> Página Web </H2></HTML>", this.getPanelPaginaWeb());
		this.getjTabbedPaneSolapas().addTab("<HTML><H2> Archivo </H2></HTML>", this.getPanelArchivo());
		this.getjTabbedPaneSolapas().addTab("<HTML><H2> Código </H2></HTML>", this.getPanelCodigo());
		this.getjTabbedPaneSolapas().addTab("<HTML><H2> URLs </H2></HTML>", this.getPanelURL());
		jPanelSolapas.add(this.getjTabbedPaneSolapas());
		return jPanelSolapas;
	}

	private JPanel getPanelPaginaWeb() {
		JPanel jPanelPaginaWeb = new JPanel();
		jPanelPaginaWeb.setBackground(Color.WHITE);
		jPanelPaginaWeb.setBorder(BorderFactory.createTitledBorder("<HTML><H3> Indique URL de la Página Web: </H3></HTML>"));
		this.setjTextFieldURL(new JTextField("http://", 68));
		this.getjTextFieldURL().setEditable(Boolean.TRUE);
		this.getjTextFieldURL().setBackground(Index.COLOR);
		jPanelPaginaWeb.add(this.getjTextFieldURL());
		return jPanelPaginaWeb;
	}

	private JPanel getPanelArchivo() {
		JPanel jPanelArchivo = new JPanel();
		jPanelArchivo.setBackground(Color.WHITE);
		jPanelArchivo.setBorder(BorderFactory.createTitledBorder("<HTML><H3> Suba un archivo local: </H3></HTML>"));
		jPanelArchivo.setLayout(new FlowLayout());
		this.setjTextFieldPathArchivo(new JTextField("No se seleccionó un archivo.", 64));
		this.getjTextFieldPathArchivo().setEditable(Boolean.FALSE);
		this.getjTextFieldPathArchivo().setBackground(Index.COLOR);
		this.setjButtonExaminar(new JButton("..."));
		this.getjButtonExaminar().addActionListener(this);
		jPanelArchivo.add(this.getjTextFieldPathArchivo());
		jPanelArchivo.add(this.getjButtonExaminar());
		return jPanelArchivo;
	}

	private JPanel getPanelCodigo() {
		JPanel jPanelCodigo = new JPanel();
		jPanelCodigo.setBackground(Color.WHITE);
		jPanelCodigo.setBorder(BorderFactory.createTitledBorder("<HTML><H3> Copie y pegue el código HTML: </H3></HTML>"));
		jPanelCodigo.setLayout(new FlowLayout());
		this.setjTextAreaCodigo(new JTextArea(3, 68));
		this.getjTextAreaCodigo().setEditable(Boolean.TRUE);
		this.getjTextAreaCodigo().setBackground(Index.COLOR);
		jPanelCodigo.add(new JScrollPane(this.getjTextAreaCodigo()));
		return jPanelCodigo;
	}

	private JPanel getPanelURL() {
		JPanel jPanelURL = new JPanel();
		jPanelURL.setBackground(Color.WHITE);
		jPanelURL.setBorder(BorderFactory.createTitledBorder("<HTML><H3> Seleccione una URL: </H3></HTML>"));
		jPanelURL.setLayout(new FlowLayout());
		this.setModeloListaURL(new DefaultListModel<>());
		this.setjListURL(new JList<>(this.getModeloListaURL()));
		this.getjListURL().setBackground(Index.COLOR);
		this.getjListURL().setFixedCellWidth(750);
		this.getjListURL().setVisibleRowCount(3);
		this.getjListURL().setLayoutOrientation(JList.VERTICAL);
		this.getjListURL().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getjListURL().addMouseListener(this);
		jPanelURL.add(new JScrollPane(this.getjListURL()));
		return jPanelURL;
	}

	private JPanel getPanelPrincipiosAVerificar() {
		JPanel jPanelPrincipiosAVerificar = new JPanel();
		jPanelPrincipiosAVerificar.setBorder(BorderFactory.createTitledBorder("<HTML><H3>Principios a Verificar</H3></HTML>"));
		jPanelPrincipiosAVerificar.setLayout(new GridLayout(4, 3));
		this.setjCheckBoxPrincipio1(new JCheckBox("<HTML><H4>1. Perceptibilidad</H4></HTML>", true));
		jPanelPrincipiosAVerificar.add(this.getjCheckBoxPrincipio1());
		jPanelPrincipiosAVerificar.add(new JLabel(""));
		jPanelPrincipiosAVerificar.add(new JLabel(""));
		this.setjCheckBoxPrincipio2(new JCheckBox("<HTML><H4>2. Operabilidad</H4></HTML>", true));
		jPanelPrincipiosAVerificar.add(this.getjCheckBoxPrincipio2());
		jPanelPrincipiosAVerificar.add(new JLabel(""));
		jPanelPrincipiosAVerificar.add(new JLabel(""));
		this.setjCheckBoxPrincipio3(new JCheckBox("<HTML><H4>3. Comprensibilidad</H4></HTML>", true));
		jPanelPrincipiosAVerificar.add(this.getjCheckBoxPrincipio3());
		jPanelPrincipiosAVerificar.add(new JLabel(""));
		jPanelPrincipiosAVerificar.add(new JLabel(""));
		this.setjCheckBoxPrincipio4(new JCheckBox("<HTML><H4>4. Robustez</H4></HTML>", true));
		jPanelPrincipiosAVerificar.add(this.getjCheckBoxPrincipio4());
		jPanelPrincipiosAVerificar.add(new JLabel(""));
		jPanelPrincipiosAVerificar.add(new JLabel(""));
		return jPanelPrincipiosAVerificar;
	}

	private JPanel getPanelBotonValidarYAcercaDe() {
		JPanel jPanelBotonValidarYAcercaDe = new JPanel();
		jPanelBotonValidarYAcercaDe.setBackground(Index.COLOR);
		jPanelBotonValidarYAcercaDe.setLayout(new GridLayout(3, 1));
		jPanelBotonValidarYAcercaDe.add(this.getPanelBotonValidar());
		jPanelBotonValidarYAcercaDe.add(this.getPanelAcercaDe());
		jPanelBotonValidarYAcercaDe.add(this.getPanelDesarrollador());
		return jPanelBotonValidarYAcercaDe;
	}

	private JPanel getPanelBotonValidar() {
		JPanel jPanelBotonValidar = new JPanel();
		jPanelBotonValidar.setBackground(Index.COLOR);
		jPanelBotonValidar.setLayout(new FlowLayout());
		this.setjButtonValidar(new JButton("<HTML><H4>Validar</H4></HTML>"));
		this.getjButtonValidar().addActionListener(this);
		jPanelBotonValidar.add(this.getjButtonValidar());
		return jPanelBotonValidar;
	}

	private JPanel getPanelAcercaDe() {
		JPanel jPanelAcercaDe = new JPanel();
		jPanelAcercaDe.setBackground(Index.COLOR);
		jPanelAcercaDe.setLayout(new FlowLayout(FlowLayout.LEFT));
		String texto = "<HTML><p align=\"left\">  ¿Qué es ARWeb?</p><p align=\"left\">Es una aplicación para la verificación automática de las Pautas de Accesibilidad en Contenidos Web establecidas por el W3C en la guía</p> <p align=\"left\"> WCAG versión 2.0 y reglamentadas por la ONTI en la Disposición N° 06/2019 como normas vigentes en la República Argentina. </p> <p align=\"left\"> en materia de accesibilidad web a partir de setiembre de 2019.</p></HTML>";
		jPanelAcercaDe.add(new JLabel(texto));
		return jPanelAcercaDe;
	}	

	private JPanel getPanelDesarrollador() {
		JPanel jPanelAcercaDe = new JPanel();
		jPanelAcercaDe.setBackground(Index.COLOR);
		jPanelAcercaDe.setLayout(new FlowLayout(FlowLayout.RIGHT));
		String texto = "<HTML><H5>by Soledad de Dios & Pablo Pandolfo (2020) <br> GETEC - EEyN - UNSAM </H5> </HTML>";
		jPanelAcercaDe.add(new JLabel(texto));
		return jPanelAcercaDe;
	}	

	public JTabbedPane getjTabbedPaneSolapas() {
		return this.jTabbedPaneSolapas;
	}

	public void setjTabbedPaneSolapas(JTabbedPane jTabbedPaneSolapas) {
		this.jTabbedPaneSolapas = jTabbedPaneSolapas;
	}

	private JTextField getjTextFieldURL() {
		return this.jTextFieldURL;
	}

	private void setjTextFieldURL(JTextField jTextFieldURL) {
		this.jTextFieldURL = jTextFieldURL;
	}

	public JTextField getjTextFieldPathArchivo() {
		return this.jTextFieldPathArchivo;
	}

	public void setjTextFieldPathArchivo(JTextField jTextFieldPathArchivo) {
		this.jTextFieldPathArchivo = jTextFieldPathArchivo;
	}

	public JTextArea getjTextAreaCodigo() {
		return this.jTextAreaCodigo;
	}

	public void setjTextAreaCodigo(JTextArea jTextAreaCodigo) {
		this.jTextAreaCodigo = jTextAreaCodigo;
	}

	public JList<String> getjListURL() {
		return this.jListURL;
	}

	public void setjListURL(JList<String> jListURL) {
		this.jListURL = jListURL;
	}

	public DefaultListModel<String> getModeloListaURL() {
		return this.modeloListaURL;
	}

	public void setModeloListaURL(DefaultListModel<String> modeloListaURL) {
		this.modeloListaURL = modeloListaURL;
	}

	public JCheckBox getjCheckBoxPrincipio1() {
		return this.jCheckBoxPrincipio1;
	}

	public void setjCheckBoxPrincipio1(JCheckBox jCheckBoxPrincipio1) {
		this.jCheckBoxPrincipio1 = jCheckBoxPrincipio1;
	}

	public JCheckBox getjCheckBoxPrincipio2() {
		return this.jCheckBoxPrincipio2;
	}

	public void setjCheckBoxPrincipio2(JCheckBox jCheckBoxPrincipio2) {
		this.jCheckBoxPrincipio2 = jCheckBoxPrincipio2;
	}

	public JCheckBox getjCheckBoxPrincipio3() {
		return this.jCheckBoxPrincipio3;
	}

	public void setjCheckBoxPrincipio3(JCheckBox jCheckBoxPrincipio3) {
		this.jCheckBoxPrincipio3 = jCheckBoxPrincipio3;
	}

	public JCheckBox getjCheckBoxPrincipio4() {
		return this.jCheckBoxPrincipio4;
	}

	public void setjCheckBoxPrincipio4(JCheckBox jCheckBoxPrincipio4) {
		this.jCheckBoxPrincipio4 = jCheckBoxPrincipio4;
	}

	public JButton getjButtonExaminar() {
		return this.jButtonExaminar;
	}

	public void setjButtonExaminar(JButton jButtonExaminar) {
		this.jButtonExaminar = jButtonExaminar;
	}

	public JButton getjButtonValidar() {
		return this.jButtonValidar;
	}

	public void setjButtonValidar(JButton jButtonValidar) {
		this.jButtonValidar = jButtonValidar;
	}

	public Timer getMonitorValidador() {
		return this.monitorValidador;
	}

	public void setMonitorValidador(Timer monitorValidador) {
		this.monitorValidador = monitorValidador;
	}

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource() == this.getjButtonValidar()) {
			ResultadoEvaluacionTecnicaItem.limpiarRegistroLinea();
			if (this.getjTabbedPaneSolapas().getSelectedIndex() != 0) {
				String principios = "";
				if (this.getjCheckBoxPrincipio1().isSelected())
					principios += "1";
				if (this.getjCheckBoxPrincipio2().isSelected())
					principios += "2";
				if (this.getjCheckBoxPrincipio3().isSelected())
					principios += "3";
				if (this.getjCheckBoxPrincipio4().isSelected())
					principios += "4";

				TipoValidacion tipoValidacion = null;
				String texto = "";
				switch (this.getjTabbedPaneSolapas().getSelectedIndex()) {
				case 1: tipoValidacion = TipoValidacion.ARCHIVO; texto = this.getjTextFieldPathArchivo().getText(); break;
				case 2: tipoValidacion = TipoValidacion.CODIGO; texto = this.getjTextAreaCodigo().getText(); break;
				case 3: tipoValidacion = TipoValidacion.PAGINA_WEB; texto = this.getjListURL().getSelectedValue(); break;
				}

				final TipoValidacion tipoValidacionFinal = tipoValidacion;
				final String textoFinal = texto;
				final String principiosFinal = principios;

				if ((tipoValidacion != null) && (texto != null) && ((texto.length() > 10) && !texto.equals("No se seleccionó un archivo."))) {
					GestorControlValidacionAccesibilidad validador = new GestorControlValidacionAccesibilidad(tipoValidacion, texto, principios, 1000);
					Thread hiloValidador = new Thread(validador);
					hiloValidador.start();
					this.getjButtonValidar().setEnabled(Boolean.FALSE);
					ProgressMonitor dialogoProgreso = new ProgressMonitor(this, "Validando Accesibilidad Web...", null, 0, validador.getMeta());
					this.setMonitorValidador(new Timer(500, new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							Integer actual = validador.getActual();
							dialogoProgreso.setProgress(actual);
							if (actual == validador.getMeta() || dialogoProgreso.isCanceled()) {
								monitorValidador.stop();
								dialogoProgreso.close();
								hiloValidador.interrupt();
								jButtonValidar.setEnabled(Boolean.TRUE);
							}
							if ((actual >= 20) && (Contexto.get(ContextoClaves.RESULTADOS) != null)) {
								monitorValidador.stop();
								dialogoProgreso.close();
								hiloValidador.interrupt();
								jButtonValidar.setEnabled(Boolean.TRUE);
								new Resultados((List<ResultadoEvaluacionPrincipio>) Contexto.get(ContextoClaves.RESULTADOS), tipoValidacionFinal, textoFinal, principiosFinal);
							}
						}
					}));
					this.getMonitorValidador().start();
				}	
				else
					JOptionPane.showMessageDialog(this, tipoValidacion.getCampoAValidar(), Constantes.TITULO_PRINCIPAL, JOptionPane.WARNING_MESSAGE);
			} else {
				this.getModeloListaURL().clear();
				ControlInformacion controlInformacion = GestorValidacionURL.validarURL(this.getjTextFieldURL().getText());
				if (!controlInformacion.isOk()) {
					JOptionPane.showMessageDialog(this, controlInformacion.getMensaje(), Constantes.TITULO_PRINCIPAL, JOptionPane.WARNING_MESSAGE);
					return;
				}
				HashMap<Integer, List<String>> mapaURL = Parseador.getURLs((Parseador)Contexto.get(ContextoClaves.PARSEADOR), 1);
				this.getModeloListaURL().addElement(Utilidades.completarURL(this.getjTextFieldURL().getText()));
				for (Integer nivel : mapaURL.keySet()) {
					for (String url : mapaURL.get(nivel))
						if (url.length() <= 120)
							this.getModeloListaURL().addElement(url);
				}
				this.getjListURL().setSelectedIndex(0);
				this.getjTabbedPaneSolapas().setSelectedIndex(3);
			}
		}	

		if (actionEvent.getSource() == this.getjButtonExaminar()) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setDialogTitle(Constantes.TITULO_PAGINA_WEB);
			jFileChooser.setAcceptAllFileFilterUsed(Boolean.FALSE);
			jFileChooser.setFileFilter(new FileNameExtensionFilter(".html", "html"));
			jFileChooser.setCurrentDirectory(new File(this.getClass().getResource("/ar/edu/uade/tic/tesis/arweb/tests/").getFile()));
			jFileChooser.showOpenDialog(this);
			File file = jFileChooser.getSelectedFile();
			if (file != null)
				this.getjTextFieldPathArchivo().setText(file.getPath());
		}
	}

	public void mouseClicked(MouseEvent mouseEvent) {
		if (mouseEvent.getClickCount() == 2) {
			this.getjTextFieldURL().setText(this.getjListURL().getSelectedValue());
			this.getjTabbedPaneSolapas().setSelectedIndex(0);
		}
	}

	public void mouseEntered(MouseEvent mouseEvent) {

	}

	public void mouseExited(MouseEvent mouseEvent) {

	}

	public void mousePressed(MouseEvent mouseEvent) {

	}

	public void mouseReleased(MouseEvent mouseEvent) {

	}

	private void cerrar(){
		if (JOptionPane.showConfirmDialog(this, "¿Desea realmente salir de ARWeb?", Constantes.TITULO_PRINCIPAL, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}   

}