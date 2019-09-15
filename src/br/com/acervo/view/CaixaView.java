package br.com.acervo.view;

import br.com.acervo.model.LogModel;
import br.com.acervo.service.LivroService;
import br.com.acervo.service.VendasService;
import br.com.acervo.util.LogCat;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class CaixaView extends javax.swing.JInternalFrame {

	LivroService livroService = new LivroService();
	VendasService vendasService = new VendasService();

	/**
	 * Creates new form CaixaView
	 */
	public CaixaView() {
		initComponents();
		setarValores();
	}

	private void initComponents() {
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jlVendas = new javax.swing.JLabel();
		jlValor = new javax.swing.JLabel();
		jlLivros = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jlQuantidadeLivros = new javax.swing.JLabel();

		setClosable(true);
		setIconifiable(true);
		setTitle("CAIXA");

		jPanel1.setBackground(new java.awt.Color(47, 89, 25));

		jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("REGISTRO TOTAL DE VENDAS DOS LIVROS");

		jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("VENDAS REALIZADAS:");

		jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("VALOR TOTAL DAS VENDAS:");

		jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("LIVROS EM ESTOQUE PARA VENDAS:");
		jLabel4.setEnabled(false);

		jlVendas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jlVendas.setForeground(new java.awt.Color(255, 255, 255));
		jlVendas.setText("$0");

		jlValor.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jlValor.setForeground(new java.awt.Color(255, 255, 255));
		jlValor.setText("$0");

		jlLivros.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jlLivros.setForeground(new java.awt.Color(255, 255, 255));
		jlLivros.setText("0");
		jlLivros.setEnabled(false);

		jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("LIVROS VENDIDOS:");

		jlQuantidadeLivros.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jlQuantidadeLivros.setForeground(new java.awt.Color(255, 255, 255));
		jlQuantidadeLivros.setText("0");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel4)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jlLivros))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel1Layout.createSequentialGroup()
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel3).addComponent(jLabel2))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jlValor).addComponent(jlVendas)))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel1Layout.createSequentialGroup().addComponent(jLabel5)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jlQuantidadeLivros)))
								.addGap(39, 39, 39))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addGap(27, 27, 27)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jlVendas))
						.addGap(27, 27, 27)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jlValor))
						.addGap(26, 26, 26)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jlQuantidadeLivros))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(jlLivros))
								.addGroup(
										jPanel1Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(jLabel4)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	public void setarValores() {
		try {
			jlVendas.setText(String.valueOf(vendasService.getQuantidadeVendas().getQuantidadeVendas()));
			jlValor.setText(String.valueOf("R$: " + vendasService.getValorTotal().getValorTotal()));
			jlQuantidadeLivros
					.setText(String.valueOf(vendasService.getQuantidadeLivroVendas().getQuantidadeLivrosVendidos()));

	} catch (Exception e) {
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(e));
	}
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel jlLivros;
	private javax.swing.JLabel jlQuantidadeLivros;
	private javax.swing.JLabel jlValor;
	private javax.swing.JLabel jlVendas;

}
