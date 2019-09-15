package br.com.acervo.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class ColorirLinhaEmprestimo extends DefaultTableCellRenderer {

	private final int colunaEmprestimo;

	public ColorirLinhaEmprestimo(int colunaTabela) {
		this.colunaEmprestimo = colunaTabela;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus,
			int row, int col) {
		Font font = new Font("DejaVu Sans", Font.BOLD, 16);
		switch (table.getValueAt(row, colunaEmprestimo).toString()) {

		case "ATIVO":
			setForeground(new java.awt.Color(0, 110, 109));
			setFont(font);
			setHorizontalAlignment(CENTER);
			break;

		case "SUSPENSO":
			setForeground(new java.awt.Color(0, 83, 156));
			setFont(font);
			setHorizontalAlignment(CENTER);
			break;

		case "INATIVO":
			setForeground(Color.RED);
			setFont(font);
			setHorizontalAlignment(CENTER);
			break;

		default:
			setForeground(Color.BLACK);
			setHorizontalAlignment(CENTER);
			break;
		}
		super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
		return this;
	}
}
