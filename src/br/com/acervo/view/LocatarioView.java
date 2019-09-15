package br.com.acervo.view;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import br.com.acervo.model.LocatarioModel;
import br.com.acervo.model.LogModel;
import br.com.acervo.service.LocatarioService;
import br.com.acervo.util.ColorirLinhaLocatario;
import br.com.acervo.util.LogCat;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class LocatarioView extends javax.swing.JInternalFrame {

	LocatarioService locatarioService = new LocatarioService();
	LocatarioModel locatarioModel = new LocatarioModel();
	ArrayList<LocatarioModel> listaLocatarioModel = new ArrayList<>();
	String alterarSalvar;

	public LocatarioView() {
		initComponents();
		habilitarCampos(false);
		corLinhaTabela();
		carregarLocatario();
		carregarLocatarioPesquisa();
	}

	private void initComponents() {

		jTabbedPane1 = new javax.swing.JTabbedPane();
		jPanel1 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jtfNome = new javax.swing.JTextField();
		jtfRua = new javax.swing.JTextField();
		jtfNumero = new javax.swing.JTextField();
		jtfCidade = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jcbUf = new javax.swing.JComboBox<>();
		jLabel9 = new javax.swing.JLabel();
		jtfTelefone = new javax.swing.JFormattedTextField();
		jtfBairro = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();
		jbNovo = new javax.swing.JButton();
		jbCancelar = new javax.swing.JButton();
		jbAlterar = new javax.swing.JButton();
		jbSalvar = new javax.swing.JButton();
		jbExcluir = new javax.swing.JButton();
		jLabel11 = new javax.swing.JLabel();
		jtfEmail = new javax.swing.JTextField();
		jtfCep = new javax.swing.JFormattedTextField();
		jLabel13 = new javax.swing.JLabel();
		jcbStatus = new javax.swing.JComboBox<>();
		jPanel4 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jtfPesquisa = new javax.swing.JTextField();
		jbPesquisa = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jtPesquisaLocatario = new javax.swing.JTable();
		jSeparator1 = new javax.swing.JSeparator();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtLocatario = new javax.swing.JTable();

		setClosable(true);
		setIconifiable(true);
		setTitle("LOCATÁRIO");

		jTabbedPane1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jPanel1.setBackground(new java.awt.Color(148, 71, 67));

		jPanel3.setBackground(new java.awt.Color(148, 71, 67));

		jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
		jLabel1.setText("NOVO LOCATÁRIO");

		jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
		jLabel3.setText("Nome:");

		jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
		jLabel4.setText("Rua:");

		jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
		jLabel5.setText("Número:");

		jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
		jLabel6.setText("Cidade:");

		jtfNome.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jtfRua.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jtfNumero.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jtfCidade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel7.setText("UF:");

		jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel8.setText("CEP:");

		jcbUf.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jcbUf.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

		jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel9.setText("Telefone:");

		try {
			jtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
					new javax.swing.text.MaskFormatter("(##) #####-####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		jtfTelefone.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jtfBairro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jLabel10.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel10.setText("Bairro:");

		jbNovo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbNovo.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/adicionar.png"))); // NOI18N
		jbNovo.setText("Novo");
		jbNovo.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbNovoActionPerformed(evt);
			}
		});

		jbCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbCancelar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/cancelar.png"))); // NOI18N
		jbCancelar.setText("Cancelar");
		jbCancelar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbCancelarActionPerformed(evt);
			}
		});

		jbAlterar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbAlterar.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/atualizar.png"))); // NOI18N
		jbAlterar.setText("Alterar");
		jbAlterar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbAlterarActionPerformed(evt);
			}
		});

		jbSalvar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/salvar.png"))); // NOI18N
		jbSalvar.setText("Salvar");
		jbSalvar.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbSalvarActionPerformed(evt);
			}
		});

		jbExcluir.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jbExcluir.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/excluir.png"))); // NOI18N
		jbExcluir.setText("Excluir");
		jbExcluir.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbExcluirActionPerformed(evt);
			}
		});

		jLabel11.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel11.setText("Email:");

		jtfEmail.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		try {
			jtfCep.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		jtfCep.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

		jLabel13.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel13.setText("Status:");

		jcbStatus.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "SUSPENSO", "BLOQUEADO" }));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel3)
														.addGap(0, 0, Short.MAX_VALUE))
												.addComponent(jtfNome))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanel3Layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel4)
												.addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 225,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jtfNumero)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE,
																188, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE,
																223, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(9, 9, 9))
												.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel5)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(jLabel10)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel6).addGap(178, 178, 178)))
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel7).addComponent(jcbUf,
																javax.swing.GroupLayout.PREFERRED_SIZE, 65,
																javax.swing.GroupLayout.PREFERRED_SIZE))))
								.addContainerGap())
						.addGroup(jPanel3Layout.createSequentialGroup()
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel3Layout
												.createSequentialGroup().addComponent(jbNovo)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbCancelar))
										.addGroup(
												jPanel3Layout
														.createSequentialGroup().addGroup(jPanel3Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jLabel8,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 74,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jtfCep,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 87,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addGroup(jPanel3Layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING).addComponent(
																		jtfTelefone,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 135,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel9))))
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jbAlterar)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbSalvar)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(jbExcluir).addGap(0, 7, Short.MAX_VALUE))
										.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel3Layout.createSequentialGroup().addGap(6, 6, 6)
														.addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
																177, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel3Layout.createSequentialGroup().addGap(9, 9, 9)
														.addComponent(jLabel11)))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(jPanel3Layout.createSequentialGroup()
																.addComponent(jLabel13,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 51,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, Short.MAX_VALUE))
														.addComponent(jcbStatus, 0,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addContainerGap())))))
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(224, 224, 224).addComponent(jLabel1).addGap(0, 0,
						Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfRua, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(jLabel6).addComponent(jLabel10)
								.addComponent(jLabel7))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcbUf, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(26, 26, 26)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8).addComponent(jLabel9).addComponent(jLabel11)
								.addComponent(jLabel13))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(38, 38, 38)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jbNovo).addComponent(jbCancelar).addComponent(jbAlterar)
								.addComponent(jbSalvar).addComponent(jbExcluir))
						.addContainerGap(18, Short.MAX_VALUE)));

		jPanel4.setBackground(new java.awt.Color(148, 71, 67));

		jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
		jLabel2.setText("ATUALIZAR LOCATÁRIO");

		jLabel12.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jLabel12.setText("INSIRA O NOME DO LOCATÁRIO");

		jtfPesquisa.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jtfPesquisa.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtfPesquisaActionPerformed(evt);
			}
		});

		jbPesquisa.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/pesquisar.png"))); // NOI18N
		jbPesquisa.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbPesquisaActionPerformed(evt);
			}
		});

		jtPesquisaLocatario.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
		jtPesquisaLocatario.setModel(
				new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null } }, new String[] { "#", "Nome", "Telefone" }) {
					@SuppressWarnings("rawtypes")
					Class[] types = new Class[] { java.lang.String.class, java.lang.String.class,
							java.lang.String.class };
					boolean[] canEdit = new boolean[] { false, false, false };

					@Override
					@SuppressWarnings({ "unchecked", "rawtypes" })
					public Class getColumnClass(int columnIndex) {
						return types[columnIndex];
					}

					@Override
					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return canEdit[columnIndex];
					}
				});
		jScrollPane2.setViewportView(jtPesquisaLocatario);
		if (jtPesquisaLocatario.getColumnModel().getColumnCount() > 0) {
			jtPesquisaLocatario.getColumnModel().getColumn(0).setMaxWidth(30);
		}

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addGap(6, 6, 6)
								.addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 281,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jbPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
						.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										jPanel4Layout.createSequentialGroup().addGap(84, 84, 84).addComponent(jLabel2))
								.addGroup(
										jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jLabel12)))
								.addGap(0, 0, Short.MAX_VALUE)))
						.addContainerGap())
				.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel4Layout.createSequentialGroup().addComponent(jLabel2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel12)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)));

		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(8, 8, 8)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jSeparator1)
								.addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));

		jTabbedPane1.addTab("Cadastrar Locatário", jPanel1);

		jPanel2.setBackground(new java.awt.Color(0, 83, 156));

		jtLocatario.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
		jtLocatario.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null } },
				new String[] { "#", "Nome", "Rua", "Nº", "Bairro", "Cidade", "UF", "CEP", "Telefone", "EMAIL",
						"Status" }) {
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false,
					false };

			@Override
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jtLocatario.getTableHeader().setReorderingAllowed(false);
		jScrollPane1.setViewportView(jtLocatario);
		if (jtLocatario.getColumnModel().getColumnCount() > 0) {
			jtLocatario.getColumnModel().getColumn(0).setMaxWidth(30);
			jtLocatario.getColumnModel().getColumn(3).setMaxWidth(40);
			jtLocatario.getColumnModel().getColumn(6).setMaxWidth(40);
		}

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE));

		jTabbedPane1.addTab("Listar Locatários", jPanel2);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPane1));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPane1));

		pack();
	}

	private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
		jbSalvar.setText("Salvar");
		habilitarCampos(true);
		jtfNome.requestFocus();
		alterarSalvar = "salvar";
		jbNovo.setEnabled(false);
		jbAlterar.setEnabled(true);
	}

	private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		jbSalvar.setText("Salvar");
		limparCampos();
		jbNovo.setEnabled(true);
		habilitarCampos(false);
		jbAlterar.setEnabled(true);
	}

	private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {
		alterarSalvar = "alterar";
		habilitarCampos(true);
		jbAlterar.setEnabled(false);
		jtfNome.requestFocusInWindow();
		int linha = jtPesquisaLocatario.getSelectedRow();
		try {
			int codigoLocatario = (int) jtPesquisaLocatario.getValueAt(linha, 0);
			locatarioModel = locatarioService.getLocatarioDAO(codigoLocatario);

			jtfBairro.setText(locatarioModel.getBairro());
			jtfCep.setText(locatarioModel.getCep());
			jtfCidade.setText(locatarioModel.getCidade());
			jtfEmail.setText(locatarioModel.getEmail());
			jtfNome.setText(locatarioModel.getNome());
			jtfNumero.setText(locatarioModel.getNumero());
			jtfRua.setText(locatarioModel.getRua());
			jtfTelefone.setText(locatarioModel.getTelefone());
			jcbUf.setSelectedItem(locatarioModel.getUf());
			jcbStatus.setSelectedItem(locatarioModel.getStatus());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Código invalido ou nenhum locatário selecionado", "Erro",
					JOptionPane.ERROR_MESSAGE);
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(e));
		}
	}

	private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {
		if (alterarSalvar.equals("salvar")) {
			this.salvarLocatario();
			Object[] opcoes = { "Sim", "Não" };
			Object resposta;
			resposta = JOptionPane.showInputDialog(null, "Deseja salvar outro Locatário?", "Salvar Novo?",
					JOptionPane.OK_CANCEL_OPTION, null, opcoes, "Sim");
			if (resposta.equals("Sim")) {
				habilitarCampos(true);
				jtfNome.requestFocus();
			}
		} else if (alterarSalvar.equals("alterar")) {
			this.alterarLocatario();
		}
		carregarLocatario();
		carregarLocatarioPesquisa();
	}

	private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {
		pesquisaLocatario();
	}

	private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
		int linha = jtPesquisaLocatario.getSelectedRow();
		int codigoLocatario = (int) jtPesquisaLocatario.getValueAt(linha, 0);
		// menu de opções para o usuario confirmar a exclusão
		Object[] opcoes = { "Sim", "Não" };
		Object resposta;
		resposta = JOptionPane.showInputDialog(null, "Deseja excluir o Locatário?", "Excluir",
				JOptionPane.OK_CANCEL_OPTION, null, opcoes, "Sim");
		if (resposta.equals("Sim")) {
			/**
			 * exclui o livro do banco de dados e atualiza a tabela
			 */

			try {
				locatarioService.excluirLocatarioDAO(codigoLocatario);
				JOptionPane.showMessageDialog(this, "Locatário excluido com sucesso!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				carregarLocatario();
				carregarLocatarioPesquisa();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Erro ao excluir o locatário!", "Erro", JOptionPane.ERROR_MESSAGE);
				LogModel.logClass = this.getClass().getName();
				new LogCat().writeFile(String.valueOf(e));
			}
		}
	}

	private void jbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {
		pesquisaLocatario();
	}

	private void habilitarCampos(boolean condicao) {
		jtfBairro.setEnabled(condicao);
		jtfCep.setEnabled(condicao);
		jtfCidade.setEnabled(condicao);
		jtfEmail.setEnabled(condicao);
		jtfNome.setEnabled(condicao);
		jtfNumero.setEnabled(condicao);
		jtfTelefone.setEnabled(condicao);
		jtfRua.setEnabled(condicao);
		jbCancelar.setEnabled(condicao);
		jbSalvar.setEnabled(condicao);
		jcbUf.setEnabled(condicao);
		jcbStatus.setEnabled(condicao);
	}

	private void limparCampos() {
		jtfBairro.setText("");
		jtfCep.setText("");
		jtfCidade.setText("");
		jtfEmail.setText("");
		jtfNome.setText("");
		jtfNumero.setText("");
		jtfPesquisa.setText("");
		jtfRua.setText("");
		jtfTelefone.setText("");
		jcbUf.setSelectedItem("PE");
		jcbStatus.setSelectedItem("ATIVO");
	}

	public void carregarLocatarioPesquisa() {
		/**
		 * Array que buscará no BD (atraves do Controller) os dados para serem exibidos
		 * na tabela
		 */
		listaLocatarioModel = locatarioService.getListaLocatarioDAO();
		DefaultTableModel modelo = (DefaultTableModel) jtPesquisaLocatario.getModel();

		// Setando a quantidade de linhas que a tabela para não haver duplicação de
		// dados
		modelo.setNumRows(0);

		try {
			// insere os produtos na tabela
			int cont = listaLocatarioModel.size();
			for (int i = 0; i < cont; i++) {
				modelo.addRow(new Object[] { listaLocatarioModel.get(i).getIdLocatario(),
						listaLocatarioModel.get(i).getNome(), listaLocatarioModel.get(i).getTelefone() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao buscar locatários para preencher a tabela\n" + e.toString());
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(e));
		}
	}

	public void carregarLocatario() {
		/**
		 * Array que buscará no BD (atraves do Controller) os dados para serem exibidos
		 * na tabela
		 */
		listaLocatarioModel = locatarioService.getListaLocatarioDAO();
		DefaultTableModel modelo = (DefaultTableModel) jtLocatario.getModel();

		// Setando a quantidade de linhas que a tabela para não haver duplicação de
		// dados
		modelo.setNumRows(0);

		try {
			// insere os produtos na tabela
			int cont = listaLocatarioModel.size();
			for (int i = 0; i < cont; i++) {
				modelo.addRow(new Object[] { listaLocatarioModel.get(i).getIdLocatario(),
						listaLocatarioModel.get(i).getNome(), listaLocatarioModel.get(i).getRua(),
						listaLocatarioModel.get(i).getNumero(), listaLocatarioModel.get(i).getBairro(),
						listaLocatarioModel.get(i).getCidade(), listaLocatarioModel.get(i).getUf(),
						listaLocatarioModel.get(i).getCep(), listaLocatarioModel.get(i).getTelefone(),
						listaLocatarioModel.get(i).getEmail(), listaLocatarioModel.get(i).getStatus() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao buscar locadores para preencher a tabela\n" + e.toString());
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(e));
		}
	}

	private void salvarLocatario() {
		locatarioModel.setBairro(jtfBairro.getText().toUpperCase());
		locatarioModel.setCep(jtfCep.getText());
		locatarioModel.setCidade(jtfCidade.getText().toUpperCase());
		locatarioModel.setEmail(jtfEmail.getText().toUpperCase());
		locatarioModel.setNome(jtfNome.getText().toUpperCase());
		locatarioModel.setNumero(jtfNumero.getText());
		locatarioModel.setRua(jtfRua.getText().toUpperCase());
		locatarioModel.setTelefone(jtfTelefone.getText());
		locatarioModel.setUf(jcbUf.getSelectedItem().toString());
		locatarioModel.setStatus(jcbStatus.getSelectedItem().toString());
		try {
			if (locatarioService.salvarLivroDAO(locatarioModel) > 0) {
				JOptionPane.showMessageDialog(this,
						"Locatário: " + locatarioModel.getNome() + " cadastrado com sucesso!", "Atenção",
						JOptionPane.WARNING_MESSAGE);
				limparCampos();
				jbNovo.setEnabled(true);
				carregarLocatario();
				carregarLocatarioPesquisa();
				habilitarCampos(false);
			}
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(this, "Erro ao cadastrar o locatário\n" + e.toString(), "Erro",
					JOptionPane.ERROR_MESSAGE);
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(e));
		}
	}

	private void alterarLocatario() {
		locatarioModel.setBairro(jtfBairro.getText().toUpperCase());
		locatarioModel.setCep(jtfCep.getText());
		locatarioModel.setCidade(jtfCidade.getText().toUpperCase());
		locatarioModel.setEmail(jtfEmail.getText().toUpperCase());
		locatarioModel.setNome(jtfNome.getText().toUpperCase());
		locatarioModel.setNumero(jtfNumero.getText());
		locatarioModel.setRua(jtfRua.getText().toUpperCase());
		locatarioModel.setTelefone(jtfTelefone.getText());
		locatarioModel.setUf(jcbUf.getSelectedItem().toString());
		locatarioModel.setStatus(jcbStatus.getSelectedItem().toString());

		try {
			locatarioService.atualizarLocatarioDAO(locatarioModel);
			JOptionPane.showMessageDialog(this, "Locatário alterado com sucesso!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
			jbSalvar.setText("Salvar");
			carregarLocatarioPesquisa();
			carregarLocatario();
			limparCampos();
			habilitarCampos(false);
			jbAlterar.setEnabled(true);
			this.jbSalvar.setText("Salvar");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao alterar o locatário!", "Erro", JOptionPane.ERROR_MESSAGE);
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(e));
		}
	}

	private void corLinhaTabela() {
		ColorirLinhaLocatario colorirLinhas = new ColorirLinhaLocatario(10);
		jtLocatario.getColumnModel().getColumn(10).setCellRenderer(colorirLinhas);
	}

	public void pesquisaLocatario() {
		try {
			DefaultTableModel modelo = (DefaultTableModel) this.jtPesquisaLocatario.getModel();
			final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
			this.jtPesquisaLocatario.setRowSorter(classificador);
			String texto = jtfPesquisa.getText().toUpperCase();
			classificador.setRowFilter(RowFilter.regexFilter(texto, 1));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erro ao pesquisar o locatário!", "Erro", JOptionPane.ERROR_MESSAGE);
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(e));
		}
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
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
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JButton jbAlterar;
	private javax.swing.JButton jbCancelar;
	private javax.swing.JButton jbExcluir;
	private javax.swing.JButton jbNovo;
	private javax.swing.JButton jbPesquisa;
	private javax.swing.JButton jbSalvar;
	private javax.swing.JComboBox<String> jcbStatus;
	private javax.swing.JComboBox<String> jcbUf;
	private javax.swing.JTable jtLocatario;
	private javax.swing.JTable jtPesquisaLocatario;
	private javax.swing.JTextField jtfBairro;
	private javax.swing.JFormattedTextField jtfCep;
	private javax.swing.JTextField jtfCidade;
	private javax.swing.JTextField jtfEmail;
	private javax.swing.JTextField jtfNome;
	private javax.swing.JTextField jtfNumero;
	private javax.swing.JTextField jtfPesquisa;
	private javax.swing.JTextField jtfRua;
	private javax.swing.JFormattedTextField jtfTelefone;
}
