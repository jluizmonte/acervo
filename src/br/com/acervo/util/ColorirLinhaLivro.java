package br.com.acervo.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class ColorirLinhaLivro extends DefaultTableCellRenderer {
	private final int colunaLivro;

	public ColorirLinhaLivro(int colunaTabela) {
		this.colunaLivro = colunaTabela;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus,
			int row, int col) {
		Font font = new Font("DejaVu Sans", Font.BOLD, 16);
		switch (table.getValueAt(row, colunaLivro).toString()) {

		case "0":
			setForeground(Color.WHITE);
			setBackground(Color.RED);
			setFont(font);
			setHorizontalAlignment(CENTER);
			break;

		default:
			setForeground(Color.BLACK);
			setBackground(Color.WHITE);
			setHorizontalAlignment(CENTER);
			break;
		}
		super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
		return this;
	}

}
