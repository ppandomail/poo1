package ar.edu.unsam.getec.proyecto_accesibilidadweb.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador.GestorContadorAccesibilidad;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador.TipoValidacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionCriterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios.Principio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.Tecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Constantes;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Contexto;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ContextoClaves;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ExportadorAnexoPDF;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ExportadorDetallePDF;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ExportadorDetalleXLS;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Utilidades;


public class Resultados extends JFrame implements ActionListener, MouseListener, HyperlinkListener {
	
	private static final long serialVersionUID = 1L;
	private static final Color COLOR = new Color(245, 245, 245);
	private DefaultTableModel tableModel;
	private JTable jTable;
	private JLabel jLabelCantidadProblemas;
	private JLabel jLabelCantidadAdvertencias;
	private JLabel jLabelCantidadNoVerificados;
	private JLabel jLabelAccesibilidad;
	private Integer puntosTotal;
	private String recurso;
	private TipoValidacion tipoValidacion;
	private List<ResultadoEvaluacionPrincipio> resultadosEvaluacionPrincipio;
	private JButton jButtonAnexoPDF;
	private JButton jButtonDetallePDF;
	private JButton jButtonDetalleXLS;
	private JButton jButtonHTML;

	public Resultados(List<ResultadoEvaluacionPrincipio> resultadosEvaluacionPrincipio, TipoValidacion tipoValidacion, String texto, String principios) {
		this.setResultadosEvaluacionPrincipio(resultadosEvaluacionPrincipio);
		this.setTipoValidacion(tipoValidacion);
		this.setPuntosTotal(0);
		if (tipoValidacion == TipoValidacion.PAGINA_WEB)
			this.setRecurso(texto);
		if (tipoValidacion == TipoValidacion.ARCHIVO)
			this.setRecurso(texto.substring(texto.lastIndexOf("\\") + 1));
		if (tipoValidacion == TipoValidacion.CODIGO)
			this.setRecurso("---");
		this.setTitle(Constantes.TITULO_PRINCIPAL.concat(" ").concat(Constantes.VERSION));
		this.setIconImages(Utilidades.getListaLogos());
		this.setSize(880, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Resultados.COLOR);
		this.add(this.getPanelPrincipal(principios));
		this.setResizable(Boolean.FALSE);
		this.setVisible(Boolean.TRUE);
	}

	private JPanel getPanelPrincipal(String principios) {
		JPanel jPanelPrincipal = new JPanel();
		jPanelPrincipal.setBackground(Resultados.COLOR);
		jPanelPrincipal.setLayout(new BorderLayout());
		jPanelPrincipal.add(this.getPanelBotonExportadores(), BorderLayout.NORTH);
		jPanelPrincipal.add(this.getPanelEncabezado(principios), BorderLayout.CENTER);
		jPanelPrincipal.add(this.getPanelDetalle(principios, this.getResultadosEvaluacionPrincipio()), BorderLayout.SOUTH);
		return jPanelPrincipal;
	}

	private JPanel getPanelEncabezado(String principios) {
		JPanel jPanelEncabezado = new JPanel();
		jPanelEncabezado.setBackground(Resultados.COLOR);
		jPanelEncabezado.setLayout(new GridLayout(1, 2, 10, 10));
		jPanelEncabezado.add(this.getPanelEncabezadoInformacion(principios));
		jPanelEncabezado.add(new JPanel());
		return jPanelEncabezado;
	}

	private JPanel getPanelEncabezadoInformacion(String principios) {
		JPanel jPanelEncabezadoInformacion = new JPanel();
		jPanelEncabezadoInformacion.setBackground(Color.WHITE);
		jPanelEncabezadoInformacion.setBorder(BorderFactory.createTitledBorder("<HTML><H3>Información de Análisis de Accesibilidad Web</H3></HTML>"));
		jPanelEncabezadoInformacion.setLayout(new GridLayout(11, 2));
		jPanelEncabezadoInformacion.add(new JLabel("Recurso " + this.getTipoValidacion().getRepresentacionString() + " : "));
		JLabel jLabelRecurso = new JLabel(this.getRecurso());
		jPanelEncabezadoInformacion.add(jLabelRecurso);
		jLabelRecurso.setToolTipText(this.getRecurso());
		jPanelEncabezadoInformacion.add(new JLabel("Fecha / Hora : "));
		jPanelEncabezadoInformacion.add(new JLabel(new SimpleDateFormat().format(new Date())));
		jPanelEncabezadoInformacion.add(new JLabel("Pautas Aplicadas : "));
		jPanelEncabezadoInformacion.add(new JLabel("WCAG 2.0"));
		jPanelEncabezadoInformacion.add(new JLabel("Principios : "));
		jPanelEncabezadoInformacion.add(new JLabel(Utilidades.separarCaracteresPorComa(principios)));
		jPanelEncabezadoInformacion.add(new JLabel("Nivel Accesibilidad : "));
		jPanelEncabezadoInformacion.add(new JLabel("A" + " " + "(umbral: " + Constantes.PUNTAJE_UMBRAL + " puntos)"));
		jPanelEncabezadoInformacion.add(new JLabel("Tecnologías Verificadas : "));
		jPanelEncabezadoInformacion.add(new JLabel("HTML y CSS"));
		jPanelEncabezadoInformacion.add(new JLabel("Cantidad Problemas : ", new ImageIcon(Constantes.PATH_IMAGE_ERROR), JLabel.LEFT));
		this.setjLabelCantidadProblemas(new JLabel(""));
		jPanelEncabezadoInformacion.add(this.getjLabelCantidadProblemas());
		jPanelEncabezadoInformacion.add(new JLabel("Cantidad Advertencias : ", new ImageIcon(Constantes.PATH_IMAGE_MANUAL), JLabel.LEFT));
		this.setjLabelCantidadAdvertencias(new JLabel(""));
		jPanelEncabezadoInformacion.add(this.getjLabelCantidadAdvertencias());
		jPanelEncabezadoInformacion.add(new JLabel("Cantidad No verificados : ", new ImageIcon(Constantes.PATH_IMAGE_IMPOSIBLE), JLabel.LEFT));
		this.setjLabelCantidadNoVerificados(new JLabel(""));
		jPanelEncabezadoInformacion.add(this.getjLabelCantidadNoVerificados());
		jPanelEncabezadoInformacion.add(new JLabel(""));
		jPanelEncabezadoInformacion.add(new JLabel(""));
		jPanelEncabezadoInformacion.add(new JLabel("Puntos:  ", JLabel.RIGHT));
		this.setjLabelAccesibilidad(new JLabel("", JLabel.LEFT));
		jPanelEncabezadoInformacion.add(this.getjLabelAccesibilidad());
		return jPanelEncabezadoInformacion;
	}

	private JPanel getPanelBotonExportadores() {
		JPanel jPanelExportador = new JPanel();
		jPanelExportador.setBackground(Resultados.COLOR);
		jPanelExportador.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setjButtonAnexoPDF(new JButton("Exportar Anexo PDF", new ImageIcon(Constantes.PATH_IMAGE_LOGO_PDF)));
		this.getjButtonAnexoPDF().setBackground(Resultados.COLOR);
		this.getjButtonAnexoPDF().addActionListener(this);
		this.getjButtonAnexoPDF().setToolTipText(Utilidades.getTextFormateadoToolTip("Información expuesta conforme el modelo del Anexo II de Disposición 2/2014 de la ONTI.", 50));
		jPanelExportador.add(this.getjButtonAnexoPDF());
		this.setjButtonDetallePDF(new JButton("Exportar Detalle PDF", new ImageIcon(Constantes.PATH_IMAGE_LOGO_PDF)));
		this.getjButtonDetallePDF().setBackground(Resultados.COLOR);
		this.getjButtonDetallePDF().addActionListener(this);
		this.getjButtonDetallePDF().setToolTipText(Utilidades.getTextFormateadoToolTip("Información detallada de Análisis de Accesibilidad Web (formato PDF).", 50));
		jPanelExportador.add(this.getjButtonDetallePDF());
		this.setjButtonDetalleXLS(new JButton("Exportar Detalle XLS", new ImageIcon(Constantes.PATH_IMAGE_LOGO_XLS)));
		this.getjButtonDetalleXLS().setBackground(Resultados.COLOR);
		this.getjButtonDetalleXLS().addActionListener(this);
		this.getjButtonDetalleXLS().setToolTipText(Utilidades.getTextFormateadoToolTip("Información detallada de Análisis de Accesibilidad Web (formato XLS).", 50));
		jPanelExportador.add(this.getjButtonDetalleXLS());
		this.setjButtonHTML(new JButton("Ver Código HTML", new ImageIcon(Constantes.PATH_IMAGE_LOGO_HTML)));
		this.getjButtonHTML().setBackground(Resultados.COLOR);
		this.getjButtonHTML().addActionListener(this);
		this.getjButtonHTML().setToolTipText(Utilidades.getTextFormateadoToolTip("Visualización del código fuente.", 20));
		jPanelExportador.add(this.getjButtonHTML());
		return jPanelExportador;
	}

	private JPanel getPanelDetalle(String principios, List<ResultadoEvaluacionPrincipio> resultadoValidacionGeneral) {
		JPanel jPanelExportador = new JPanel();
		jPanelExportador.setBackground(Resultados.COLOR);
		jPanelExportador.setBorder(BorderFactory.createTitledBorder("<HTML><H3>Resultados Generales</H3></HTML>"));
		jPanelExportador.setLayout(new FlowLayout());
		this.setTableModel(new DefaultTableModel(){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		this.setJTable(new JTable(this.getTableModel()));
		this.getJTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		this.getJTable().setDefaultRenderer(Object.class, new IconCellRender());
		this.getTableModel().addColumn("Ppios.");
		this.getTableModel().addColumn("Pautas");
		this.getTableModel().addColumn("Criterios");
		this.getTableModel().addColumn("A");
		this.getTableModel().addColumn("Técnicas");
		this.getTableModel().addColumn("Tipologías");
		this.getTableModel().addColumn("Verificaciones");
		this.getTableModel().addColumn("Rdo.");
		this.getTableModel().addColumn("Inc.");
		this.getTableModel().addColumn("# Líneas");
		JTableHeader jTableHeader = this.getJTable().getTableHeader();
		ColumnHeaderToolTips tips = new ColumnHeaderToolTips();
		TableColumnModel columnModel = this.getJTable().getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(40);
		tips.setToolTip(columnModel.getColumn(0), "Principios");
		columnModel.getColumn(1).setPreferredWidth(50);
		tips.setToolTip(columnModel.getColumn(1), "Pautas");
		columnModel.getColumn(2).setPreferredWidth(55);
		tips.setToolTip(columnModel.getColumn(2), "Criterios");
		columnModel.getColumn(3).setPreferredWidth(30);
		tips.setToolTip(columnModel.getColumn(3), "Nivel A");
		columnModel.getColumn(4).setPreferredWidth(68);
		tips.setToolTip(columnModel.getColumn(4), "Técnicas");
		columnModel.getColumn(5).setPreferredWidth(80);
		tips.setToolTip(columnModel.getColumn(5), "Tipologías");
		columnModel.getColumn(6).setPreferredWidth(312);
		tips.setToolTip(columnModel.getColumn(6), "Verificaciones");
		columnModel.getColumn(7).setPreferredWidth(30);
		tips.setToolTip(columnModel.getColumn(7), "Resultado Verificación");
		columnModel.getColumn(8).setPreferredWidth(30);
		tips.setToolTip(columnModel.getColumn(8), "Incidencias");
		columnModel.getColumn(9).setPreferredWidth(55);
		tips.setToolTip(columnModel.getColumn(9), "Número de líneas");
		jTableHeader.addMouseMotionListener(tips);

		String marcaPrincipio = "";
		String marcaPauta = "";
		String marcaCriterio = "";
		String marcaTecnica = "";

		for (ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio : resultadoValidacionGeneral) {
			for (ResultadoEvaluacionPauta resultadoEvaluacionPauta : resultadoEvaluacionPrincipio
					.getResultadoEvaluacionPautas()) {
				for (ResultadoEvaluacionCriterio resultadoEvaluacionCriterio : resultadoEvaluacionPauta
						.getResultadoEvaluacionCriterios()) {
					for (ResultadoEvaluacionTecnica resultadoEvaluacionTecnica : resultadoEvaluacionCriterio
							.getResultadoEvaluacionTecnicas()) {
						for (ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem : resultadoEvaluacionTecnica.getResultadoEvaluacionTecnicaItems()) {
							Object[] fila = new Object[] {"", "", "", "", "", "", "", "", "", ""};
							if (!marcaPrincipio.equals(resultadoEvaluacionPrincipio.getPrincipio().toString()))
								fila[0] = new Etiqueta(resultadoEvaluacionPrincipio.getPrincipio(), resultadoEvaluacionPrincipio.getPrincipio().toString(), new ImageIcon(Constantes.PATH_IMAGE_HELP));
							if (!marcaPauta.equals(resultadoEvaluacionPauta.getPauta().toString()))
								fila[1] = new Etiqueta(resultadoEvaluacionPauta.getPauta(), resultadoEvaluacionPauta.getPauta().toString(), new ImageIcon(Constantes.PATH_IMAGE_HELP));
							if (!marcaCriterio.equals(resultadoEvaluacionCriterio.getCriterio().toString())) {
								fila[2] = new Etiqueta(resultadoEvaluacionCriterio.getCriterio(), resultadoEvaluacionCriterio.getCriterio().toString(), new ImageIcon(Constantes.PATH_IMAGE_HELP));
								fila[3] = new JLabel(String.valueOf(resultadoEvaluacionCriterio.getPuntosPorCriterio()), JLabel.CENTER);
							}
							if (!marcaTecnica.equals(resultadoEvaluacionTecnica.getTecnica().toString())) 
								fila[4] = new Etiqueta(resultadoEvaluacionTecnica.getTecnica(), Utilidades.getTextoFormateadoConLongitud(resultadoEvaluacionTecnica.getTecnica().toString(), 6), new ImageIcon(Constantes.PATH_IMAGE_HELP));
							fila[5] = resultadoEvaluacionTecnicaItem.getTipologia().getRepresentacionString();
							fila[6] = new Etiqueta(resultadoEvaluacionTecnicaItem, resultadoEvaluacionTecnicaItem.getNombre(), new ImageIcon(Constantes.PATH_IMAGE_HELP));
							fila[7] = new JLabel(new ImageIcon(resultadoEvaluacionTecnicaItem.getTipoResultadoEvaluacion().getRepresentacionPathImagen()));
							fila[8] = new JLabel(String.valueOf(resultadoEvaluacionTecnicaItem.getIncidencias()), JLabel.CENTER);
							fila[9] = resultadoEvaluacionTecnicaItem;

							this.getTableModel().addRow(fila);
							marcaPrincipio = resultadoEvaluacionPrincipio.getPrincipio().toString();
							marcaPauta = resultadoEvaluacionPauta.getPauta().toString();
							marcaCriterio = resultadoEvaluacionCriterio.getCriterio().toString();
							marcaTecnica = resultadoEvaluacionTecnica.getTecnica().toString();
						}
					}
				}
			}
			this.setPuntosTotal(this.getPuntosTotal() + resultadoEvaluacionPrincipio.getCantidadPautasOKPorPrincipio());
		}
		this.getJTable().setPreferredScrollableViewportSize(new Dimension(750, 200));
		this.getjLabelCantidadProblemas().setText(String.valueOf(GestorContadorAccesibilidad.getCantidad(TipoResultadoEvaluacion.ERROR)));
		this.getjLabelCantidadAdvertencias().setText(String.valueOf(GestorContadorAccesibilidad.getCantidad(TipoResultadoEvaluacion.MANUAL)));
		this.getjLabelCantidadNoVerificados().setText(String.valueOf(GestorContadorAccesibilidad.getCantidad(TipoResultadoEvaluacion.IMPOSIBLE)));
		Integer accesibilidad = this.getPuntosTotal() * Constantes.PUNTAJE_CRITERIO_OK;
		this.getjLabelAccesibilidad().setText(accesibilidad >= Constantes.PUNTAJE_UMBRAL? accesibilidad + "  -  " + Constantes.MENSAJE_ACCESIBLE : accesibilidad +  "  -  " + Constantes.MENSAJE_NO_ACCESIBLE);
		this.getjLabelAccesibilidad().setForeground(accesibilidad >= Constantes.PUNTAJE_UMBRAL? Color.GREEN.darker() : Color.RED.darker());
		jPanelExportador.add(new JScrollPane(this.getJTable()));
		this.getJTable().addMouseListener(this);
		return jPanelExportador;
	}

	public DefaultTableModel getTableModel() {
		return this.tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public JTable getJTable() {
		return this.jTable;
	}

	public void setJTable(JTable jTable) {
		this.jTable = jTable;
	}

	public Integer getPuntosTotal() {
		return this.puntosTotal;
	}

	public void setPuntosTotal(Integer puntosTotal) {
		this.puntosTotal = puntosTotal;
	}

	public JLabel getjLabelCantidadProblemas() {
		return this.jLabelCantidadProblemas;
	}

	public void setjLabelCantidadProblemas(JLabel jLabelCantidadProblemas) {
		this.jLabelCantidadProblemas = jLabelCantidadProblemas;
	}

	public JLabel getjLabelCantidadAdvertencias() {
		return this.jLabelCantidadAdvertencias;
	}

	public void setjLabelCantidadAdvertencias(JLabel jLabelCantidadAdvertencias) {
		this.jLabelCantidadAdvertencias = jLabelCantidadAdvertencias;
	}

	public JLabel getjLabelCantidadNoVerificados() {
		return this.jLabelCantidadNoVerificados;
	}

	public void setjLabelCantidadNoVerificados(JLabel jLabelCantidadNoVerificados) {
		this.jLabelCantidadNoVerificados = jLabelCantidadNoVerificados;
	}

	public JLabel getjLabelAccesibilidad() {
		return this.jLabelAccesibilidad;
	}

	public void setjLabelAccesibilidad(JLabel jLabelAccesibilidad) {
		this.jLabelAccesibilidad = jLabelAccesibilidad;
	}

	public String getRecurso() {
		return this.recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public TipoValidacion getTipoValidacion() {
		return this.tipoValidacion;
	}

	public void setTipoValidacion(TipoValidacion tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}

	public List<ResultadoEvaluacionPrincipio> getResultadosEvaluacionPrincipio() {
		return this.resultadosEvaluacionPrincipio;
	}

	public void setResultadosEvaluacionPrincipio(
			List<ResultadoEvaluacionPrincipio> resultadosEvaluacionPrincipio) {
		this.resultadosEvaluacionPrincipio = resultadosEvaluacionPrincipio;
	}

	public JButton getjButtonAnexoPDF() {
		return this.jButtonAnexoPDF;
	}

	public void setjButtonAnexoPDF(JButton jButtonAnexoPDF) {
		this.jButtonAnexoPDF = jButtonAnexoPDF;
	}

	public JButton getjButtonDetallePDF() {
		return this.jButtonDetallePDF;
	}

	public void setjButtonDetallePDF(JButton jButtonDetallePDF) {
		this.jButtonDetallePDF = jButtonDetallePDF;
	}

	public JButton getjButtonDetalleXLS() {
		return this.jButtonDetalleXLS;
	}

	public void setjButtonDetalleXLS(JButton jButtonDetalleXLS) {
		this.jButtonDetalleXLS = jButtonDetalleXLS;
	}

	public JButton getjButtonHTML() {
		return this.jButtonHTML;
	}

	public void setjButtonHTML(JButton jButtonHTML) {
		this.jButtonHTML = jButtonHTML;
	}

	public void mouseClicked(MouseEvent e) {
		Object object = this.getJTable().getModel().getValueAt(this.getJTable().getSelectedRow(), this.getJTable().getSelectedColumn());
		String titulo = null;
		Object mensaje = null;
		switch (this.getJTable().getSelectedColumn()) {
		case 0:
			if ((object instanceof Etiqueta) && (((Etiqueta) object).getObject() instanceof Principio)){ 
				Etiqueta etiqueta = (Etiqueta) object;
				Principio principio = (Principio) etiqueta.getObject();
				titulo = "Principio " + principio.getNumero(); 
				JEditorPane jEditorPane = new JEditorPane("text/html", "<HTML><BODY>"
						+ "<H3>Nombre: </H3>" 
						+ Utilidades.getTextoFormateadoHTML(principio.getNombre()) + "<BR>"
						+ "<H3>Descripción: </H3>" 
						+ Utilidades.getTextoFormateadoHTML(principio.getDescripcion()) + " <BR><BR></BODY></HTML>");
				jEditorPane.setEditable(false);
				jEditorPane.setBackground(Resultados.COLOR);
				mensaje = jEditorPane;
			}
			break;
		case 1:
			if ((object instanceof Etiqueta) && (((Etiqueta) object).getObject() instanceof Pauta)){ 
				Etiqueta etiqueta = (Etiqueta) object;
				Pauta pauta = (Pauta) etiqueta.getObject();
				titulo = "Pauta " + pauta.getNumero();
				JEditorPane jEditorPane = new JEditorPane("text/html", "<HTML><BODY>"
						+ "<H3>Nombre: </H3>" 
						+ Utilidades.getTextoFormateadoHTML(pauta.getNombre()) + "<BR>"
						+ "<H3>Descripción: </H3>" 
						+ Utilidades.getTextoFormateadoHTML(pauta.getDescripcion()) + " <BR><BR></BODY></HTML>");
				jEditorPane.setEditable(false);
				jEditorPane.setBackground(Resultados.COLOR);
				mensaje = jEditorPane;
			}
			break;
		case 2:
			if ((object instanceof Etiqueta) && (((Etiqueta) object).getObject() instanceof Criterio)){ 
				Etiqueta etiqueta = (Etiqueta) object;
				Criterio criterio = (Criterio) etiqueta.getObject();
				titulo = "Criterio " + criterio.getNumero();
				JEditorPane jEditorPane = new JEditorPane("text/html", "<HTML><BODY>"
						+ "<H3>Nombre: </H3>" 
						+ Utilidades.getTextoFormateadoHTML(criterio.getNombre()) + "<BR>"
						+ "<H3>Descripción: </H3>" 
						+ Utilidades.getTextoFormateadoHTML(criterio.getDescripcion()) + " <BR><BR></BODY></HTML>");
				jEditorPane.setEditable(false);
				jEditorPane.setBackground(Resultados.COLOR);
				mensaje = jEditorPane;
			}
			break;
		case 4:
			if ((object instanceof Etiqueta) && (((Etiqueta) object).getObject() instanceof Tecnica)){ 
				Etiqueta etiqueta = (Etiqueta) object;
				Tecnica tecnica = (Tecnica) etiqueta.getObject();
				titulo = "Técnica " + tecnica.getNumero();
				JEditorPane jEditorPane = new JEditorPane("text/html", "<HTML><BODY>"
						+ "<H3>Nombre: </H3>"   
						+ Utilidades.getTextoFormateadoHTML(tecnica.getNombre()) + "<BR><BR>"
						+ "<H3>Descripción: </H3>" 
						+ Utilidades.getTextoFormateadoHTML(tecnica.getDescripcion()) + " <BR> " +
						" <A HREF=\"" + tecnica.getUrl() + "\">" + tecnica.getUrl()	+ "</A> <BR><BR></BODY></HTML>");
				jEditorPane.addHyperlinkListener(this);
				jEditorPane.setEditable(false);
				jEditorPane.setBackground(Resultados.COLOR);
				mensaje = jEditorPane;
			}
			break;
		case 6:
			if ((object instanceof Etiqueta) && (((Etiqueta) object).getObject() instanceof ResultadoEvaluacionTecnicaItem)){ 
				Etiqueta etiqueta = (Etiqueta) object;
				ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem = (ResultadoEvaluacionTecnicaItem) etiqueta.getObject();
				titulo = "Verificación";
				JEditorPane jEditorPane = new JEditorPane("text/html", "<HTML><BODY>"
						+ "<H3>Nombre: </H3>" 
						+ Utilidades.getTextoFormateadoHTML(resultadoEvaluacionTecnicaItem.getNombre()) + "<BR>"
						+ "<P> <H3> <img src=\"" + this.getClass().getResource(Constantes.PATH_IMAGE_VERIFICACION)  + "\" align=\"left\">" + "  Descripción: </H3> </P> " 
						+ Utilidades.getTextoFormateadoHTML(resultadoEvaluacionTecnicaItem.getDescripcion()) + " <BR>" 
						+ "<P> <H3> <img src=\"" + this.getClass().getResource(Constantes.PATH_IMAGE_RECOMENDACION) + "\" align=\"left\">" + "  Recomendación: </H3> </P>"  
						+ Utilidades.getTextoFormateadoHTML(resultadoEvaluacionTecnicaItem.getRecomendacion()) + " <BR><BR></BODY></HTML>");
				jEditorPane.setEditable(false);
				jEditorPane.setBackground(Resultados.COLOR);
				mensaje = jEditorPane;
			}
			break;
		case 9:
			if (object instanceof ResultadoEvaluacionTecnicaItem) {
				ResultadoEvaluacionTecnicaItem resultadoEvaluacionTecnicaItem = (ResultadoEvaluacionTecnicaItem) object;
				String numeroLineas = resultadoEvaluacionTecnicaItem.getNumeroLineas();
				if (numeroLineas.length() > 4) {
					titulo = "Número de Lineas: ";
					mensaje = Utilidades.getTextoFormateado(numeroLineas);
				}
			}
			break;
		}

		if ((titulo != null) && (mensaje != null))
			JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == this.getjButtonAnexoPDF()) {
			try {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle(Constantes.TITULO_PDF_ANEXO);
				fileChooser.setCurrentDirectory(new File("."));
				fileChooser.setAcceptAllFileFilterUsed(Boolean.FALSE);
				fileChooser.setFileFilter(new FileNameExtensionFilter(".pdf", "pdf"));
				fileChooser.showSaveDialog(this);
				File file = fileChooser.getSelectedFile();
				if (file != null) {
					if (!file.getName().endsWith(".pdf"))
						file = new File(file.getPath() + ".pdf");
					new ExportadorAnexoPDF(this.getRecurso(), this.getResultadosEvaluacionPrincipio(), file).exportar();
					JOptionPane.showMessageDialog(this, "El archivo se ha guardado exitosamente.", Constantes.TITULO_PRINCIPAL, JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(this, exception.getMessage(),  Constantes.TITULO_PRINCIPAL, JOptionPane.ERROR_MESSAGE);
			}
		}

		if (actionEvent.getSource() == this.getjButtonDetallePDF()) {
			try {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle(Constantes.TITULO_PDF_DETALLADO);
				fileChooser.setCurrentDirectory(new File("."));
				fileChooser.setAcceptAllFileFilterUsed(Boolean.FALSE);
				fileChooser.setFileFilter(new FileNameExtensionFilter(".pdf", "pdf"));
				fileChooser.showSaveDialog(this);
				File file = fileChooser.getSelectedFile();
				if (file != null) {
					if (!file.getName().endsWith(".pdf"))
						file = new File(file.getPath() + ".pdf");
					new ExportadorDetallePDF(this.getRecurso(), this.getResultadosEvaluacionPrincipio(), ((Parseador) Contexto.get(ContextoClaves.PARSEADOR)).getOutputDocument().toString(), file).exportar();
					JOptionPane.showMessageDialog(this, "El archivo se ha guardado exitosamente.",  Constantes.TITULO_PRINCIPAL, JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(this, exception.getMessage(),  Constantes.TITULO_PRINCIPAL, JOptionPane.ERROR_MESSAGE);
			}
		}

		if (actionEvent.getSource() == this.getjButtonDetalleXLS()) {
			try {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle(Constantes.TITULO_XLS_DETALLADO);
				fileChooser.setCurrentDirectory(new File("."));
				fileChooser.setAcceptAllFileFilterUsed(Boolean.FALSE);
				fileChooser.setFileFilter(new FileNameExtensionFilter(".xls", "xls"));
				fileChooser.showSaveDialog(this);
				File file = fileChooser.getSelectedFile();
				if (file != null) {
					if (!file.getName().endsWith(".xls"))
						file = new File(file.getPath() + ".xls");
					new ExportadorDetalleXLS(this.getRecurso(), this.getResultadosEvaluacionPrincipio(), file).exportar();
					JOptionPane.showMessageDialog(this, "El archivo se ha guardado exitosamente.",  Constantes.TITULO_PRINCIPAL, JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception exception) {
				JOptionPane.showMessageDialog(this, exception.getMessage(),  Constantes.TITULO_PRINCIPAL, JOptionPane.ERROR_MESSAGE);
			}
		}

		if (actionEvent.getSource() == this.getjButtonHTML()) {
			new DialogoHTML(this, ((Parseador) Contexto.get(ContextoClaves.PARSEADOR)).getOutputDocument().toString(), ResultadoEvaluacionTecnicaItem.getRegistroLinea());
		}
	}

	public void hyperlinkUpdate(HyperlinkEvent paramHyperlinkEvent) {
		if (paramHyperlinkEvent.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))
			try {
				Desktop.getDesktop().browse(paramHyperlinkEvent.getURL().toURI());
			} catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, ioException.getMessage(), Constantes.TITULO_PRINCIPAL, JOptionPane.ERROR_MESSAGE);
			} catch (URISyntaxException uriSyntaxException) {
				JOptionPane.showMessageDialog(this, uriSyntaxException.getMessage(), Constantes.TITULO_PRINCIPAL, JOptionPane.ERROR_MESSAGE);
			}
	}

}