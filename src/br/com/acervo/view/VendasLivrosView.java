package br.com.acervo.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import br.com.acervo.exception.VendasException;
import br.com.acervo.model.ClienteModel;
import br.com.acervo.model.LivroModel;
import br.com.acervo.model.LivrosVendasLivrosModel;
import br.com.acervo.model.LogModel;
import br.com.acervo.model.VendasClientesModel;
import br.com.acervo.model.VendasLivroModel;
import br.com.acervo.model.VendasModel;
import br.com.acervo.service.ClienteService;
import br.com.acervo.service.LivroService;
import br.com.acervo.service.LivrosVendasLivrosService;
import br.com.acervo.service.VendasClientesService;
import br.com.acervo.service.VendasLivrosService;
import br.com.acervo.service.VendasService;
import br.com.acervo.util.LogCat;
import br.com.acervo.util.Mascaras;

/**
 *
 * @author Jose Luiz
 */
@SuppressWarnings("serial")
public class VendasLivrosView extends javax.swing.JInternalFrame {
	LogCat logCat = new LogCat();

	ClienteModel clienteModel = new ClienteModel();
	ClienteService clienteService = new ClienteService();
	ArrayList<ClienteModel> listaClienteModel = new ArrayList<>();

	LivroModel livroModel = new LivroModel();
	LivroService livroService = new LivroService();
	ArrayList<LivroModel> listaLivroModel = new ArrayList<>();

	VendasClientesModel vendasClientesModel = new VendasClientesModel();
	VendasClientesService vendasClienteService = new VendasClientesService();
	ArrayList<VendasClientesModel> listaVendasCliente = new ArrayList<>();

	VendasModel vendasModel = new VendasModel();
	VendasService vendasService = new VendasService();
	ArrayList<VendasModel> listaVendasModel = new ArrayList<>();

	VendasLivrosService vendasLivroService = new VendasLivrosService();
	VendasLivroModel vendasLivroModel = new VendasLivroModel();
	ArrayList<VendasLivroModel> listaVendasLivroModel = new ArrayList<>();

	LivrosVendasLivrosService livrosVendasLivrosService = new LivrosVendasLivrosService();
	LivrosVendasLivrosModel livrosVendasLivrosModel = new LivrosVendasLivrosModel();
	ArrayList<LivrosVendasLivrosModel> listaLivrosVendasLivrosModel = new ArrayList<>();

	VendasException vendasException = new VendasException();
	Mascaras mascaras = new Mascaras();
	String alterarSalvar;

	public VendasLivrosView() {
		initComponents();
		listarClientes();
		listarProdutos();
		habilitarDesabilitarCampos(false);
		carregarVendas();
		preencherCodigoCliente();
		preencherCodigoProduto();
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jtfCodCliente = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jtfCodLivro = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jtfQuantidade = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jbAdicionar = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtLivrosVendas = new javax.swing.JTable();
		jbCancelar = new javax.swing.JButton();
		jbNovo = new javax.swing.JButton();
		jbSalvar = new javax.swing.JButton();
		jtfValorTotal = new javax.swing.JTextField();
		jtfDesconto = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jbRemoverLivro = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jlQuantidadeLivro = new javax.swing.JLabel();
		jcbNomeCliente = new javax.swing.JComboBox<>();
		jcbNomeLivro = new javax.swing.JComboBox<>();
		jPanel2 = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		jtfPesquisa = new javax.swing.JTextField();
		jbPesquisar = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jtVendas = new javax.swing.JTable();
		jbExcluir = new javax.swing.JButton();
		jbAlterar = new javax.swing.JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("VENDAS");
		setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jTabbedPane1.setToolTipText("");
		jTabbedPane1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jPanel1.setBackground(new java.awt.Color(155, 35, 53));
		jPanel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

		jtfCodCliente.setEditable(false);
		jtfCodCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jtfCodCliente.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				jtfCodClienteFocusLost(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel1.setText("Código Cli.");

		jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel2.setText("Nome do Cliente:");

		jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel4.setText("Cód. Pro.");

		jtfCodLivro.setEditable(false);
		jtfCodLivro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jtfCodLivro.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				jtfCodLivroFocusLost(evt);
			}
		});

		jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel5.setText("Nome Livro:");

		jtfQuantidade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jtfQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		jtfQuantidade.setEnabled(false);
		jtfQuantidade.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtfQuantidadeActionPerformed(evt);
			}
		});

		jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel6.setText("Quantidade:");

		jbAdicionar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/add.png"))); // NOI18N
		jbAdicionar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbAdicionarActionPerformed(evt);
			}
		});

		jtLivrosVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jtLivrosVendas.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "#", "Livro", "Quant.", "R$ Unitário", "R$ Total" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			@Override
			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jtLivrosVendas.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(jtLivrosVendas);
		if (jtLivrosVendas.getColumnModel().getColumnCount() > 0) {
			jtLivrosVendas.getColumnModel().getColumn(0).setMaxWidth(30);
			jtLivrosVendas.getColumnModel().getColumn(2).setMaxWidth(70);
			jtLivrosVendas.getColumnModel().getColumn(3).setMaxWidth(70);
			jtLivrosVendas.getColumnModel().getColumn(4).setMaxWidth(70);
		}

		jbCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbCancelar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/cancelar.png"))); // NOI18N
		jbCancelar.setText("Cancelar");
		jbCancelar.setToolTipText("Cancelar Venda");
		jbCancelar.setEnabled(false);
		jbCancelar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbCancelarActionPerformed(evt);
			}
		});

		jbNovo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbNovo.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/adicionar.png"))); // NOI18N
		jbNovo.setText("Novo");
		jbNovo.setToolTipText("Nova Venda");
		jbNovo.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbNovoActionPerformed(evt);
			}
		});

		jbSalvar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/salvar.png"))); // NOI18N
		jbSalvar.setText("Salvar");
		jbSalvar.setToolTipText("Salvar Venda");
		jbSalvar.setEnabled(false);
		jbSalvar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbSalvarActionPerformed(evt);
			}
		});

		jtfValorTotal.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jtfValorTotal.setEnabled(false);

		jtfDesconto.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jtfDesconto.setHorizontalAlignment(SwingConstants.CENTER);
		jtfDesconto.setEnabled(false);
		jtfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				jtfDescontoFocusLost(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel7.setText("Valor Total:");

		jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel8.setText("Desconto:");

		jbRemoverLivro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbRemoverLivro.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/lixeira.png"))); // NOI18N
		jbRemoverLivro.setText("Remover Livro");
		jbRemoverLivro.setToolTipText("Remover Produtos");
		jbRemoverLivro.setEnabled(false);
		jbRemoverLivro.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbRemoverLivroActionPerformed(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
		jLabel3.setText("Quantidade disponível do livro selecionado:");

		jlQuantidadeLivro.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
		jlQuantidadeLivro.setText("0");

		jcbNomeCliente.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jcbNomeCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
			}

			@Override
			public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
				jcbNomeClientePopupMenuWillBecomeInvisible(evt);
			}

			@Override
			public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
			}
		});

		jcbNomeLivro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jcbNomeLivro.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
			@Override
			public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
			}

			@Override
			public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
				jcbNomeLivroPopupMenuWillBecomeInvisible(evt);
			}

			@Override
			public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jtfCodLivro, javax.swing.GroupLayout.DEFAULT_SIZE, 79,
														Short.MAX_VALUE)
												.addComponent(jtfCodCliente)
												.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
										.addComponent(jLabel4))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel5)
												.addGap(219, 219, 219).addComponent(jLabel6)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93,
														Short.MAX_VALUE)
												.addComponent(jbAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel2)
												.addComponent(jcbNomeLivro, 0, 291, Short.MAX_VALUE)
												.addComponent(jcbNomeCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel1Layout.createSequentialGroup()
																.addComponent(jLabel3).addGap(0, 4, Short.MAX_VALUE))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout.createSequentialGroup()
																		.addGroup(jPanel1Layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																				.addGroup(jPanel1Layout
																						.createSequentialGroup()
																						.addGap(0, 0, Short.MAX_VALUE)
																						.addComponent(
																								jlQuantidadeLivro))
																				.addComponent(jtfQuantidade))
																		.addGap(113, 113, 113))))))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jbNovo)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbCancelar)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jbRemoverLivro).addGap(0, 0, Short.MAX_VALUE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
												.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup().addComponent(jLabel8)
																		.addGap(49, 49, 49))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout.createSequentialGroup()
																		.addComponent(jtfDesconto,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				103,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(jtfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 103,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jbSalvar))))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(13, 13, 13)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1).addComponent(jLabel2))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jtfCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jcbNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel6)))
						.addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(jLabel3)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jlQuantidadeLivro)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jtfCodLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcbNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8).addComponent(jLabel7))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jtfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jbCancelar).addComponent(jbSalvar).addComponent(jbRemoverLivro)
								.addComponent(jbNovo))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jTabbedPane1.addTab("Cadastro", jPanel1);

		jPanel2.setBackground(new java.awt.Color(155, 35, 53));

		jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
		jLabel9.setText("Pesquisa:");

		jtfPesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		jbPesquisar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbPesquisar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/pesquisar.png"))); // NOI18N
		jbPesquisar.setText("Pesquisar");
		jbPesquisar.setToolTipText("Pesquisar Venda");
		jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbPesquisarActionPerformed(evt);
			}
		});

		jtVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		jtVendas.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "#", "Cliente", "Desconto", "R$ Total", "Data" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			@Override
			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jtVendas.getTableHeader().setReorderingAllowed(false);
		jScrollPane2.setViewportView(jtVendas);
		if (jtVendas.getColumnModel().getColumnCount() > 0) {
			jtVendas.getColumnModel().getColumn(0).setMaxWidth(30);
			jtVendas.getColumnModel().getColumn(4).setMaxWidth(70);
		}

		jbExcluir.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbExcluir.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/excluir.png"))); // NOI18N
		jbExcluir.setText("Excluir");
		jbExcluir.setToolTipText("Excluir Venda");
		jbExcluir.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbExcluirActionPerformed(evt);
			}
		});

		jbAlterar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbAlterar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/atualizar.png"))); // NOI18N
		jbAlterar.setText("Alterar");
		jbAlterar.setToolTipText("Alterar Venda");
		jbAlterar.setEnabled(false);
		jbAlterar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbAlterarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel9)
										.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jbExcluir)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jbAlterar)))
								.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(jPanel2Layout.createSequentialGroup().addComponent(jtfPesquisa).addGap(18, 18, 18)
								.addComponent(jbPesquisar)))
						.addContainerGap()));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel9)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jbPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jbAlterar).addComponent(jbExcluir))						
						.addContainerGap()));

		jTabbedPane1.addTab("Listar Vendas", jPanel2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPane1));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}

	private void jtfCodClienteFocusLost(java.awt.event.FocusEvent evt) {
		clienteModel = clienteService.getClienteDAO(Integer.parseInt(jtfCodCliente.getText()));
		jcbNomeCliente.setSelectedItem(clienteModel.getCliNome());
	}

	private void jtfCodLivroFocusLost(java.awt.event.FocusEvent evt) {
		livroModel = livroService.getLivroDAO(Integer.parseInt(jtfCodLivro.getText()));
		jcbNomeLivro.setSelectedItem(livroModel.getTitulo());
	}

	private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
		// menu de opções para o usuario confirmar a exclusão
		Object[] opcoes = { "Sim", "Não" };
		Object resposta;
		resposta = JOptionPane.showInputDialog(null, "Deseja excluir a venda", "Excluir?", JOptionPane.OK_CANCEL_OPTION,
				null, opcoes, "Sim");
		if (resposta.equals("Sim")) {
			int linha = jtVendas.getSelectedRow();
			int codigoVenda = (int) jtVendas.getValueAt(linha, 0);

			listaLivrosVendasLivrosModel = livrosVendasLivrosService.getListaLivrosVendasLivrosDAO(codigoVenda);
			for (int i = 0; i < listaLivrosVendasLivrosModel.size(); i++) {
				livroModel = new LivroModel();
				vendasModel = new VendasModel();
				vendasLivroModel = new VendasLivroModel();
				livroModel.setIdLivro(listaLivrosVendasLivrosModel.get(i).getLivroModel().getIdLivro());
				livroModel.setQuantidadeLivro((listaLivrosVendasLivrosModel.get(i).getLivroModel().getQuantidadeLivro()
						+ listaLivrosVendasLivrosModel.get(i).getModelVendasLivros().getVenLivroQuantidade()));
				listaLivroModel.add(livroModel);

			}
			if (livroService.alterarEstoqueLivroDAO(listaLivroModel)) {
				vendasLivroService.excluirVendasLivrosDAO(codigoVenda);
				if (vendasService.excluirVendasDAO(codigoVenda)) {
					JOptionPane.showMessageDialog(this, "Venda excluida com sucesso!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					carregarVendas();
					jbSalvar.setText("Salvar");
				} else {
				}
			} else {
				JOptionPane.showMessageDialog(this, "Erro ao excluir a venda", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			try {
				livroService.alterarEstoqueLivroDAO(listaLivroModel);
				vendasLivroService.excluirVendasLivrosDAO(codigoVenda);
				vendasService.excluirVendasDAO(codigoVenda);
				carregarVendas();
				jbSalvar.setText("Salvar");
			} catch (Exception e) {
				String erro = vendasException.erroSaleBook() + vendasException.messageDefault();
				JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
				LogModel.logClass = this.getClass().getName();
				new LogCat().writeFile(erro);
			}
		}
	}

	private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void jtfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {
		adicionarProdutoTabela();
	}

	private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
		adicionarProdutoTabela();
	}

	private void jtfDescontoFocusLost(java.awt.event.FocusEvent evt) {
		somarValorTotalProduto();
	}

	private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
		alterarSalvar = "salvar";
		habilitarDesabilitarCampos(true);
		jbNovo.setEnabled(false);
		jbSalvar.setText("Salvar");
		limparFormulario();
		preencherQuantidadeLivro();
		preencherCodigoCliente();
		preencherCodigoProduto();
		listarProdutos();
		listarClientes();
	}

	private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		/**
		 * este trecho salva a venda do livro e exclui n unidades do livro servira para
		 * a parte de locação de livros
		 */
		int codigoVenda = 0;
		double desconto;
		int codigoProduto = 0;
		// int quantidade = 0;

		desconto = Double.parseDouble(mascaras.converterVirgulaParaPonto(
				JOptionPane.showInputDialog(this, "Qual desconto para este livro?\n Se não houver digite 0",
						"Aplicar Desconto?", JOptionPane.QUESTION_MESSAGE)));
		jtfDesconto.setText(String.valueOf(desconto));

		listaVendasLivroModel = new ArrayList<>();
		if (jtfDesconto.getText().equals("")) {
			desconto = 0;
		} else {
			desconto = Double.parseDouble(jtfDesconto.getText());
		}

		try {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yy");
			LocalDateTime timepoint = LocalDateTime.now();
			vendasModel.setVenDataVenda(timepoint.format(fmt));
		} catch (Exception ex) {
			Logger.getLogger(VendasLivrosView.class.getName()).log(Level.SEVERE, null, ex);
			LogModel.logClass = this.getClass().getName();
			logCat.writeFile(new VendasException().erroSaleBook() + new VendasException().messageDefault());
		}

		vendasModel.setCliente(Integer.parseInt(jtfCodCliente.getText()));
		vendasModel.setVenValorLiquido(Double.parseDouble(jtfValorTotal.getText()) - desconto);
		vendasModel.setVenValorBruto(Double.parseDouble(jtfValorTotal.getText()));
		vendasModel.setVenDesconto(desconto);

		codigoVenda = vendasService.salvarVendasDAO(vendasModel);
		if (codigoVenda > 0) {
			JOptionPane.showMessageDialog(this, "Venda salva com sucesso!", "Atenção", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Erro ao salvar a venda!", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		int cont = jtLivrosVendas.getRowCount();
		for (int i = 0; i < cont; i++) {
			livroModel = new LivroModel();
			livroModel = livroService.getLivroDAO(codigoProduto);
			vendasLivroModel = new VendasLivroModel();
			codigoProduto = (int) jtLivrosVendas.getValueAt(i, 0);
			// vendas
			vendasLivroModel.setIdVendaLivro(codigoProduto);
			vendasLivroModel.setVendas(codigoVenda);
			vendasLivroModel.setVendasLivroValor((double) jtLivrosVendas.getValueAt(i, 3));
			vendasLivroModel.setLivro(codigoProduto);
			vendasLivroModel.setVenLivroQuantidade(Integer.parseInt(jtLivrosVendas.getValueAt(i, 2).toString()));

			// produto
			livroModel.setIdLivro(codigoProduto);
			livroModel.setQuantidadeLivro(livroService.getLivroDAO(codigoProduto).getQuantidadeLivro()
					- Integer.parseInt(jtLivrosVendas.getValueAt(i, 2).toString()));
			livroModel.setTitulo(livroService.getLivroDAO(codigoProduto).getTitulo());
			listaVendasLivroModel.add(vendasLivroModel);
			listaLivroModel.add(livroModel);
		}
		try {
			vendasLivroService.salvarVendasLivrosDAO(listaVendasLivroModel);
			livroService.alterarEstoqueLivroDAO(listaLivroModel);
		} catch (Exception e) {
			String erro = vendasException.erroSaveBookSale() + vendasException.messageDefault();
			LogModel.logClass = this.getClass().getName();
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			logCat.writeFile(erro);
		}
		jbNovo.setEnabled(true);
		habilitarDesabilitarCampos(false);
		listarClientes();
		listarProdutos();
	}

	private void jbRemoverLivroActionPerformed(java.awt.event.ActionEvent evt) {
		int linha = jtLivrosVendas.getSelectedRow();
		DefaultTableModel modelo = (DefaultTableModel) jtLivrosVendas.getModel();
		modelo.removeRow(linha);
		somarValorTotalProduto();
	}

	private void jcbNomeClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {// GEN-FIRST:event_jcbNomeClientePopupMenuWillBecomeInvisible
		if (jcbNomeCliente.isVisible()) {
			preencherCodigoCliente();
		}
	}

	private void jcbNomeLivroPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
		if (jcbNomeLivro.isPopupVisible()) {
			preencherCodigoProduto();
			exibirQuantidadeLivro();
		}
	}

	/**
	 * cancela a venda atual
	 * 
	 * @param evt
	 */
	private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		limparFormulario();
		habilitarDesabilitarCampos(false);
		jbSalvar.setText("Salvar");
		jbNovo.setEnabled(true);
	}

	/**
	 * 
	 * @param evt
	 */
	private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel modelo = (DefaultTableModel) this.jtVendas.getModel();
		final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
		this.jtVendas.setRowSorter(classificador);
		String texto = jtfPesquisa.getText();
		classificador.setRowFilter(RowFilter.regexFilter(texto, 1));
	}

	/**
	 * Aplica descontos ao valor final de venda
	 */
	private void aplicarDescontos() {
		try {
			jtfValorTotal.setText(String
					.valueOf(Double.parseDouble(jtfValorTotal.getText()) - Double.parseDouble(jtfDesconto.getText())));

		} catch (NumberFormatException e) {
		}
	}

	/**
	 * Preenche o comboBox com todos os clientes
	 */
	private void listarClientes() {
		listaClienteModel = clienteService.getListaClienteDAO();
		jcbNomeCliente.removeAllItems();
		int cont = listaClienteModel.size();
		for (int i = 0; i < cont; i++) {
			jcbNomeCliente.addItem(listaClienteModel.get(i).getCliNome());
		}
	}

	/**
	 * preencher o comboBox com todos os produtos
	 */
	private void listarProdutos() {
		listaLivroModel = livroService.getListaLivroDAO();
		jcbNomeLivro.removeAllItems();
		int cont = listaLivroModel.size();
		for (int i = 0; i < cont; i++) {
			if (listaLivroModel.get(i).getQuantidadeLivro() > 0) {
				if (listaLivroModel.get(i).getTipoLivro().equals("VENDA")) {
					jcbNomeLivro.addItem(listaLivroModel.get(i).getTitulo());
				}
			}
		}
	}

	/**
	 * carregar as vendas finalizadas e salvas corretamente
	 */
	private void carregarVendas() {
		DefaultTableModel modelo = (DefaultTableModel) jtVendas.getModel();
		listaVendasCliente = vendasClienteService.getListaVendasClienteDAO();
		int cont = listaVendasCliente.size();

		modelo.setNumRows(0);
		for (int i = 0; i < cont; i++) {
			modelo.addRow(new Object[] { listaVendasCliente.get(i).getModelVendas().getIdVenda(),
					listaVendasCliente.get(i).getModelCliente().getCliCep(),
					listaVendasCliente.get(i).getModelVendas().getVenDesconto(),
					listaVendasCliente.get(i).getModelVendas().getVenValorLiquido(),
					listaVendasCliente.get(i).getModelVendas().getVenDataVenda() });
		}
	}

	/**
	 * Soma todos os produtos da venda
	 */
	private void somarValorTotalProduto() {
		double soma = 0, valor;
		int cont = jtLivrosVendas.getRowCount();

		for (int i = 0; i < cont; i++) {
			valor = (double) jtLivrosVendas.getValueAt(i, 4);
			soma = soma + valor;
		}
		jtfValorTotal.setText(String.valueOf(soma));
		aplicarDescontos();
	}

	/**
	 * Atribui ao iniciar o frame o código do cliente no jtfCodNome pelo comboBox
	 */
	private void preencherCodigoCliente() {

		try {
			clienteModel = clienteService.getClienteDAO(jcbNomeCliente.getSelectedItem().toString());
			jtfCodCliente.setText(String.valueOf(clienteModel.getIdCliente()));
		} catch (Exception e) {
			String erro = new VendasException().clientNull() + new VendasException().messageDefault();
			JOptionPane.showMessageDialog(null, erro, "Informe ao desenvolvedor o erro", JOptionPane.ERROR_MESSAGE);
			LogModel.logClass = this.getClass().getName();
			logCat.writeFile(erro);
		}

	}

	/**
	 * Atribui ao iniciar o frame o código do produto no jtfCodProduto pelo comboBox
	 */
	private void preencherCodigoProduto() {
		try {
			jtfCodLivro.setText(String.valueOf(livroModel.getIdLivro()));
			livroModel = livroService.getLivroDAO(jcbNomeLivro.getSelectedItem().toString());
		} catch (Exception e) {
			String erro = new VendasException().bookNull() + new VendasException().messageDefault();
			JOptionPane.showMessageDialog(null, erro, "Informe ao desenvolvedor o erro", JOptionPane.ERROR_MESSAGE);
			LogModel.logClass = this.getClass().getName();
			logCat.writeFile(new VendasException().bookNull() + new VendasException().messageDefault());
		}
	}

	private void preencherQuantidadeLivro() {
		livroModel = livroService.getLivroDAO(jcbNomeLivro.getSelectedItem().toString());
		jlQuantidadeLivro.setText(String.valueOf(livroModel.getQuantidadeLivro()));
	}

	/**
	 * Limpar formulario de vendas
	 */
	private void limparFormulario() {
		jtfQuantidade.setText("");
		jtfValorTotal.setText("");
		jtfDesconto.setText("");
		jtfCodCliente.setText("");
		jtfCodLivro.setText("");
		jlQuantidadeLivro.setText("0");
		DefaultTableModel modelo = (DefaultTableModel) jtLivrosVendas.getModel();
		modelo.setNumRows(0);
	}

	private void habilitarDesabilitarCampos(boolean condicao) {
		jbSalvar.setEnabled(condicao);
		jcbNomeLivro.setEnabled(condicao);
		jcbNomeCliente.setEnabled(condicao);
		jtfQuantidade.setEnabled(condicao);
		jbAdicionar.setEnabled(condicao);
		jbRemoverLivro.setEnabled(condicao);
		jtfDesconto.setEnabled(condicao);
		jtfValorTotal.setEnabled(condicao);
		jbCancelar.setEnabled(condicao);
	}

	private void exibirQuantidadeLivro() {
		livroModel = livroService.getLivroDAO(jcbNomeLivro.getSelectedItem().toString());
		jlQuantidadeLivro.setText(String.valueOf(livroModel.getQuantidadeLivro()));
	}

	private void adicionarProdutoTabela() {
		if (jtfQuantidade.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Você deve inserir a quantidade de livros!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
		} else {
			livroModel = livroService.getLivroDAO(Integer.parseInt(jtfCodLivro.getText()));
			// adiciona uma linha na tabela
			DefaultTableModel modelo = (DefaultTableModel) jtLivrosVendas.getModel();
			int cont = 0;
			double quantidade = 0;
			quantidade = Double.parseDouble(jtfQuantidade.getText());
			for (int i = 0; i < cont; i++) {
				modelo.setNumRows(0);
			}
			modelo.addRow(new Object[] { livroModel.getIdLivro(), livroModel.getTitulo(), jtfQuantidade.getText(),
					livroModel.getLivroValorUnitario(), quantidade * livroModel.getLivroValorUnitario() });
			somarValorTotalProduto();
			jtfQuantidade.setText("");
		}
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JButton jbAdicionar;
	private javax.swing.JButton jbAlterar;
	private javax.swing.JButton jbCancelar;
	private javax.swing.JButton jbExcluir;
	private javax.swing.JButton jbNovo;
	private javax.swing.JButton jbPesquisar;
	private javax.swing.JButton jbRemoverLivro;
	private javax.swing.JButton jbSalvar;
	private javax.swing.JComboBox<String> jcbNomeCliente;
	private javax.swing.JComboBox<String> jcbNomeLivro;
	private javax.swing.JLabel jlQuantidadeLivro;
	private javax.swing.JTable jtLivrosVendas;
	private javax.swing.JTable jtVendas;
	private javax.swing.JTextField jtfCodCliente;
	private javax.swing.JTextField jtfCodLivro;
	private javax.swing.JTextField jtfDesconto;
	private javax.swing.JTextField jtfPesquisa;
	private javax.swing.JTextField jtfQuantidade;
	private javax.swing.JTextField jtfValorTotal;
}
