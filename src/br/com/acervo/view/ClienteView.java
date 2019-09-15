package br.com.acervo.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import br.com.acervo.model.ClienteModel;
import br.com.acervo.model.LogModel;
import br.com.acervo.service.ClienteService;
import br.com.acervo.util.LogCat;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class ClienteView extends javax.swing.JInternalFrame {

    /**
     * instancia o controller do usuario o model do usuario instancia o
     * modelusuario em uma lista
     */
    ClienteService clienteService = new ClienteService();
    ClienteModel clienteModel = new ClienteModel();
    ArrayList<ClienteModel> listaModelCliente = new ArrayList<>();
    String alterarSalvar;

    public ClienteView() {
        initComponents();
        desabilitaHabilitaCampos(false); // desabilita o formulário
        carregarCliente(); // carrega os clientes já cadastrados na tabela
        carregarClientePesquisa();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jtfEndereco = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jtfCidade = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jcbUf = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jtfCep = new javax.swing.JFormattedTextField();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbPesquisa = new javax.swing.JButton();
        jtfPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientePesquisa = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("CLIENTE");
        setVisible(true);
        setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jTabbedPane1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(47, 79, 79));

        jPanel5.setBackground(new java.awt.Color(47, 79, 79));
        jPanel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel28.setBackground(new java.awt.Color(47, 79, 79));
        jLabel28.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel28.setText("Nome:");

        jtfNome.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtfNome.setToolTipText("");
        jtfNome.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                // jtfNomeMouseEntered(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel29.setText("Rua:");

        jtfEndereco.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtfEndereco.setToolTipText("");

        jtfBairro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtfBairro.setToolTipText("");

        jLabel30.setBackground(new java.awt.Color(47, 79, 79));
        jLabel30.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel30.setText("Bairro:");

        jLabel31.setBackground(new java.awt.Color(47, 79, 79));
        jLabel31.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel31.setText("Cidade:");

        jtfCidade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jLabel32.setBackground(new java.awt.Color(47, 79, 79));
        jLabel32.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel32.setText("UF:");

        jcbUf.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jcbUf.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
                    "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));

        jLabel7.setBackground(new java.awt.Color(47, 79, 79));
        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        // jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CEP:");

        jLabel8.setBackground(new java.awt.Color(47, 79, 79));
        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel8.setText("Telefone:");

        jbCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbCancelar.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/cancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setToolTipText("Cancelar Cliente");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbNovo.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/adicionar.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.setToolTipText("Novo Cliente");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbSalvar.setFont(new java.awt.Font("Tahoma", 0, 14));
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/salvar.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.setToolTipText("Salvar Cliente");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbAlterar.setFont(new java.awt.Font("Tahoma", 0, 14));
        jbAlterar.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/atualizar.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.setToolTipText("Alterar Cliente");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbExcluir.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/excluir.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setToolTipText("Excluir Cliente");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        try {
            jtfCep.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfCep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        try {
            jtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
                    new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfTelefone.setToolTipText("Entre com o telefone sem o nono digito");
        jtfTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel1.setText("Número:");

        jtfNumero.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel3.setText("Email:");

        jtfEmail.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setText("NOVO CLIENTE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup().addComponent(jbNovo).addGap(18, 18, 18)
                                        .addComponent(jbCancelar).addGap(26, 26, 26).addComponent(jbAlterar)
                                        .addGap(18, 18, 18).addComponent(jbSalvar).addGap(26, 26, 26)
                                        .addComponent(jbExcluir))
                                .addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jcbUf, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel32))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jtfTelefone,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 141,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8)))
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1).addComponent(jtfNumero,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel5Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel30).addComponent(jtfBairro)))
                                                .addComponent(jLabel28).addComponent(jtfNome,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 314,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel3).addComponent(jLabel29).addComponent(jtfEndereco)
                                                .addComponent(jLabel31)
                                                .addComponent(jtfCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 266,
                                                        Short.MAX_VALUE)
                                                .addComponent(jtfEmail)))))
                        .addGroup(jPanel5Layout.createSequentialGroup().addGap(260, 260, 260).addComponent(jLabel2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                        jPanel5Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel5Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel30).addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel5Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8).addComponent(jLabel7)
                                                        .addComponent(jLabel32))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jtfTelefone,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jcbUf, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel29)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel31)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbNovo).addComponent(jbCancelar).addComponent(jbAlterar)
                                        .addComponent(jbSalvar).addComponent(jbExcluir))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel3.setBackground(new java.awt.Color(47, 79, 79));

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setText("ALTERAR CLIENTE");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel5.setText("INSIRA O NOME DO CLIENTE:");

        jbPesquisa.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/pesquisar.png"))); // NOI18N
        jbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisaActionPerformed(evt);
            }
        });

        jtfPesquisa.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisaActionPerformed(evt);
            }
        });

        jtClientePesquisa.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        jtClientePesquisa.setModel(
                new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null}, {null, null, null},
        {null, null, null}, {null, null, null}}, new String[]{"#", "Nome", "Telefone"}) {
            @SuppressWarnings("rawtypes")
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class,
                java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false, false};

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
        jScrollPane1.setViewportView(jtClientePesquisa);
        if (jtClientePesquisa.getColumnModel().getColumnCount() > 0) {
            jtClientePesquisa.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(
                                        jPanel3Layout.createSequentialGroup().addComponent(jLabel4).addGap(83, 83, 83))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                        jPanel3Layout.createSequentialGroup().addComponent(jLabel5).addContainerGap(137,
                                                Short.MAX_VALUE))))
                .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jbPesquisa).addComponent(jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 321,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 253,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jbPesquisa, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap()));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel3,
                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1).addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)));

        jTabbedPane1.addTab("Cadastrar Cliente", jPanel1);

        jtCliente.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{{null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}},
                new String[]{"#", "Nome", "Rua", "Nº", "Bairro", "Cidade", "UF", "CEP", "Telefone", "EMAIL"}) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtCliente);
        if (jtCliente.getColumnModel().getColumnCount() > 0) {
            jtCliente.getColumnModel().getColumn(0).setMaxWidth(30);
            jtCliente.getColumnModel().getColumn(3).setMaxWidth(40);
            jtCliente.getColumnModel().getColumn(6).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jScrollPane2,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));

        jTabbedPane1.addTab("Listar Clientes", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }

    /**
     *
     * @param evt
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        /**
         * ao cancelar desabilita os campos altera o nome do botao salvar limpa
         * os campos
         */
        jbSalvar.setText("Salvar");
        this.desabilitaHabilitaCampos(false);
        this.limparCampos();
    }

    /**
     *
     * @param evt
     */
    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
        /**
         * ao clicar em novo limpa os campos habilita o formulário seta 'salvar'
         * na variavel global coloca o foco do mouse para o campo nome altera o
         * nome do botao salvar
         */
        jbSalvar.setText("Salvar");
        limparCampos();
        desabilitaHabilitaCampos(true);
        alterarSalvar = "salvar";
        jtfNome.requestFocusInWindow();
    }

    /**
     *
     * @param evt
     */
    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        /**
         * chama o Metodo para salvar ou alterar diferenciado pela escolha do
         * usuário
         */
        if (alterarSalvar.equals("salvar")) {
            this.salvarCliente();
        } else if (alterarSalvar.equals("alterar")) {
            this.alterarCliente();
        }
    }

    /**
     *
     * @param evt
     */
    private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {
        pesquisaCliente();
    }

    /**
     *
     * @param evt
     */
    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        /**
         * altera a variavel global para alterar altera o nome do botao salvar
         * joga o foco para o campo nome habilita os campos atribui a uma
         * variavel a linha selecionada na tabela
         */

        alterarSalvar = "alterar";
        jtfNome.requestFocusInWindow();
        jbAlterar.setEnabled(false);
        desabilitaHabilitaCampos(true);
        int linha = jtClientePesquisa.getSelectedRow();
        try {
            int codigoCliente = (int) jtClientePesquisa.getValueAt(linha, 0);
            /**
             * recupera os dados do BD
             */
            clienteModel = clienteService.getClienteDAO(codigoCliente);
            /**
             * colocar os dados do BD na tabela
             */
            jtfNome.setText(clienteModel.getCliNome());
            jtfEndereco.setText(clienteModel.getCliRua());
            jtfBairro.setText(clienteModel.getCliBairro());
            jtfCidade.setText(clienteModel.getCliCidade());
            jcbUf.setSelectedItem(clienteModel.getCliUf());
            jtfCep.setText(clienteModel.getCliCep());
            jtfTelefone.setText(clienteModel.getCliTelefone());
            jtfNumero.setText(clienteModel.getCliNumero());
            jtfEmail.setText(clienteModel.getCliEmail());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código invalido ou nenhum registro selecionado", "Erro",
                    JOptionPane.ERROR_MESSAGE);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        } finally {
            jbAlterar.setEnabled(true);
        }
    }

    /**
     *
     * @param evt
     */
    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        /**
         * Excluir cliente do BD e atualiza a tabela
         */
        int linha = jtClientePesquisa.getSelectedRow();
        int codigoCliente = (int) jtClientePesquisa.getValueAt(linha, 0);
        /**
         * menu de opções para o usuario confirmar a exclusão
         */
        Object[] opcoes = {"Sim", "Não"};
        Object resposta;
        resposta = JOptionPane.showInputDialog(null, "Deseja excluir o cliente?", "Excluir",
                JOptionPane.OK_CANCEL_OPTION, null, opcoes, "Sim");
        if (resposta.equals("Sim")) {
            /**
             * exclui o cliente do banco de dados e atualiza a tabela
             * automaticamete apos excluir altera oo nome do botao para salvar
             * atualiza a lista dos clientes e desabilita os campos para um novo
             */
            try {
                clienteService.excluirClienteDAO(codigoCliente);
                JOptionPane.showMessageDialog(this, "Cliente excluido com sucesso!", "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                jbSalvar.setText("Salvar");
                carregarCliente();
                carregarClientePesquisa();
                this.desabilitaHabilitaCampos(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
                LogModel.logClass = this.getClass().getName();
                new LogCat().writeFile(String.valueOf(e));
            }

        }
    }

    private void jbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {
        pesquisaCliente();
    }

    /**
     * Metodo para caregar do BD os clientes e exibi-los na tabela
     */
    public void carregarCliente() {
        /**
         * Array que buscará no BD (atraves do Controller) os dados para serem
         * exibidos na tabela
         */
        listaModelCliente = clienteService.getListaClienteDAO();
        DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();

        /**
         * Setando a quantidade de linhas que a tabela para não haver duplicação
         * de dados
         */
        modelo.setNumRows(0);

        /**
         * insere os produtos na tabela
         */
        int cont = listaModelCliente.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{listaModelCliente.get(i).getIdCliente(), listaModelCliente.get(i).getCliNome(),
                listaModelCliente.get(i).getCliRua(), listaModelCliente.get(i).getCliNumero(),
                listaModelCliente.get(i).getCliBairro(), listaModelCliente.get(i).getCliCidade(),
                listaModelCliente.get(i).getCliUf(), listaModelCliente.get(i).getCliCep(),
                listaModelCliente.get(i).getCliTelefone(), listaModelCliente.get(i).getCliEmail()});
        }
    }

    private void carregarClientePesquisa() {
        /**
         * Array que buscará no BD (atraves do Controller) os dados para serem
         * exibidos na tabela
         */
        listaModelCliente = clienteService.getListaClienteDAO();
        DefaultTableModel modelo = (DefaultTableModel) jtClientePesquisa.getModel();

        /**
         * Setando a quantidade de linhas que a tabela para não haver duplicação
         * de dados
         */
        modelo.setNumRows(0);

        // insere os produtos na tabela
        int cont = listaModelCliente.size();
        for (int i = 0; i < cont; i++) {
            modelo.addRow(new Object[]{listaModelCliente.get(i).getIdCliente(), listaModelCliente.get(i).getCliNome(),
                listaModelCliente.get(i).getCliTelefone()

            });
        }
    }

    /**
     * Metodo para salvar o cliente. Esse Metodo é invocado no botao salvar após
     * a verificação da variavel global alterarSalvar
     */
    private void salvarCliente() {
        /**
         * Salva um novo cliente no BD e atualiza a tabela
         */
        clienteModel.setCliNome(jtfNome.getText().toUpperCase());
        clienteModel.setCliRua(jtfEndereco.getText().toUpperCase());
        clienteModel.setCliBairro(jtfBairro.getText().toUpperCase());
        clienteModel.setCliCidade(jtfCidade.getText().toUpperCase());
        clienteModel.setCliNumero(jtfNumero.getText());
        clienteModel.setCliUf(jcbUf.getSelectedItem().toString());
        clienteModel.setCliCep(jtfCep.getText());
        clienteModel.setCliTelefone(jtfTelefone.getText());
        clienteModel.setCliEmail(jtfEmail.getText());
        /**
         * chama o metodo de salvar no controller salva o cliente altera o nome
         * do botao salvar recarrega os produtos exibidos na tabela limpa os
         * campos do formulario desabilita os campos do formluario se houver
         * algum erro exibe uma mensagem na tela
         */

        try {
            if (clienteService.salvarClienteDAO(clienteModel) > 0) {
                JOptionPane.showMessageDialog(this,
                        "Cliente: " + clienteModel.getCliNome() + " cadastrado com sucesso!", "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                jbSalvar.setText("Salvar");
                carregarCliente();
                carregarClientePesquisa();
                limparCampos();
                desabilitaHabilitaCampos(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o cliente", "Erro", JOptionPane.ERROR_MESSAGE);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    /**
     * Metodo para alterar e salvar o cliente. Esse Metodo é invocado no botao
     * salvar após a verificação da variavel global alterarSalvar
     */
    private void alterarCliente() {
        /**
         * altera e salva o cliente no BD e atualiza a tabela
         */
        clienteModel.setCliNome(jtfNome.getText().toUpperCase());
        clienteModel.setCliRua(jtfEndereco.getText().toUpperCase());
        clienteModel.setCliBairro(jtfBairro.getText().toUpperCase());
        clienteModel.setCliCidade(jtfCidade.getText().toUpperCase());
        clienteModel.setCliNumero(jtfNumero.getText());
        clienteModel.setCliUf(jcbUf.getSelectedItem().toString());
        clienteModel.setCliCep(jtfCep.getText());
        clienteModel.setCliTelefone(jtfTelefone.getText());
        clienteModel.setCliEmail(jtfEmail.getText());
        /**
         * chama o metodo de alterar no controller salva o produto altera o nome
         * do botao salvar recarrega os produtos exibidos na tabela limpa os
         * campos do formulario desabilita os campos do formluario se houver
         * algum erro exibe uma mensagem na tela
         */
        try {
            clienteService.atualizarClienteDAO(clienteModel);
            JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!", "Atenção",
                    JOptionPane.WARNING_MESSAGE);
            jbSalvar.setText("Salvar");
            carregarCliente();
            carregarClientePesquisa();
            limparCampos();
            desabilitaHabilitaCampos(false);
            this.jbSalvar.setText("Salvar");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar o cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    /**
     * Metodo para desativar ou não os campos mediante escolha por uma variavel
     * booleana
     *
     * @param condicao
     */
    private void desabilitaHabilitaCampos(boolean condicao) {
        jtfNome.setEnabled(condicao);
        jtfEndereco.setEnabled(condicao);
        jtfBairro.setEnabled(condicao);
        jtfCidade.setEnabled(condicao);
        jtfNumero.setEnabled(condicao);
        jcbUf.setEnabled(condicao);
        jtfCep.setEnabled(condicao);
        jtfTelefone.setEnabled(condicao);
        jbSalvar.setEnabled(condicao);
        jtfEmail.setEnabled(condicao);
    }

    /**
     * Metodo para limpar os campos caso o cadastro seja cancelado salvo ou
     * alterado.
     */
    private void limparCampos() {
        jtfNome.setText("");
        jtfEndereco.setText("");
        jtfBairro.setText("");
        jtfCidade.setText("");
        jtfNumero.setText("");
        jcbUf.setSelectedItem("AC");
        jtfCep.setText("");
        jtfTelefone.setText("");
        jtfEmail.setText("");
    }

    public void pesquisaCliente() {

        try {
            DefaultTableModel modelo = (DefaultTableModel) this.jtClientePesquisa.getModel();
            final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
            this.jtClientePesquisa.setRowSorter(classificador);
            String texto = jtfPesquisa.getText().toUpperCase();
            classificador.setRowFilter(RowFilter.regexFilter(texto, 1));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o cliente!", "Erro", JOptionPane.ERROR_MESSAGE);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JComboBox<String> jcbUf;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtClientePesquisa;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JFormattedTextField jtfCep;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JFormattedTextField jtfTelefone;
}
