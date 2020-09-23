package ar.edu.unsam.getec.proyecto_accesibilidadweb.vista;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class IconCellRender extends DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable jTable, Object value, boolean isSelected, boolean hasFocus, int fila, int columna) {
		if (value instanceof JLabel) {
			JLabel jLabel = (JLabel) value;
			jLabel.setOpaque(Boolean.TRUE);
			this.rellenarColor(jTable, jLabel, isSelected);
			return jLabel;
		}
		return super.getTableCellRendererComponent(jTable, value, isSelected, hasFocus, fila, columna);
	}

	public void rellenarColor(JTable jTable, JLabel jLabel, boolean isSelected) {
		if (isSelected) {
			jLabel.setBackground(jTable.getSelectionBackground());
			jLabel.setForeground(jTable.getSelectionForeground());
		} else {
			jLabel.setBackground(jTable.getBackground());
			jLabel.setForeground(jTable.getForeground());
		}
	}

}
