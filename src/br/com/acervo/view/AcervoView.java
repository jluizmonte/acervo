package br.com.acervo.view;

import java.awt.HeadlessException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import br.com.acervo.model.LivroModel;
import br.com.acervo.model.LogModel;
import br.com.acervo.service.LivroService;
import br.com.acervo.util.ColorirLinhaLivro;
import br.com.acervo.util.LogCat;
import br.com.acervo.util.Mascaras;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class AcervoView extends javax.swing.JInternalFrame {

    LivroModel livroModel = new LivroModel();
    LivroService livroService = new LivroService();
    ArrayList<LivroModel> listaModelLivro = new ArrayList<>();
    String alterarSalvar;
    int qtdeLivro = 0;
    Mascaras mascaras = new Mascaras();

    public AcervoView() {
        initComponents();
        habilitarCampos(false);
        setarData();
        corLinhaTabela();
        carregarLivros();
        carregarLivrosPesquisa();
        jtfQuantidade.setText("1");
        cellRendering();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jtBiblioteca = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jpNovo = new javax.swing.JPanel();
        jlNovo = new javax.swing.JLabel();
        jcbCategoria = new javax.swing.JComboBox<>();
        jtfData = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jtfAutor = new javax.swing.JTextField();
        jtfAno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtfObs = new javax.swing.JTextArea();
        jbNovo = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jcbTipoLivro = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfQuantidade = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfPreco = new javax.swing.JFormattedTextField();
        jpAtualizar = new javax.swing.JPanel();
        jlAtualizar = new javax.swing.JLabel();
        jtfPesquisa = new javax.swing.JTextField();
        jbPesquisa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtPesquisaLivro = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtLivro = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("BIBLIOTECA");
        setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jtBiblioteca.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtBiblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtBibliotecaMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(107, 91, 149));

        jpNovo.setBackground(new java.awt.Color(107, 91, 149));

        jlNovo.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        jlNovo.setText("NOVO LIVRO");
        jlNovo.setToolTipText("");

        jcbCategoria.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jcbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"ESTUDO", "CODIFICAÇÃO", "ROMANCE", "INFANTOJUVENIL", "MENSAGENS", "OUTRA"}));

        jtfData.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jtfData.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jLabel1.setText("Título do Livro:");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jLabel2.setText("Autor(es):");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jLabel3.setText("Ano Lancamento:");

        jtfTitulo.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N

        jtfAutor.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N

        jtfAno.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jtfAno.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jLabel4.setText("Categoria:");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jLabel5.setText("Data de Cadastro:");

        jbSalvar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/salvar.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jLabel7.setText("Observações Gerais:");

        jScrollPane2.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N

        jtfObs.setColumns(20);
        jtfObs.setLineWrap(true);
        jtfObs.setRows(5);
        jScrollPane2.setViewportView(jtfObs);

        jbNovo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jbNovo.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/adicionar.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jbCancelar.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/cancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbAlterar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jbAlterar.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/atualizar.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jbExcluir.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/excluir.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jcbTipoLivro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jcbTipoLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"EMPRÉSTIMO", "VENDA"}));

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel9.setText("Tipo de Livro:");

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel6.setText("Quantidade:");

        jtfQuantidade.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtfQuantidade.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel10.setText("Preço Livro:");

        try {
            jtfPreco.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jtfPreco.setFont(new java.awt.Font("DejaVu Sans", 0, 14));
        jtfPreco.setHorizontalAlignment(SwingConstants.CENTER);

        javax.swing.GroupLayout jpNovoLayout = new javax.swing.GroupLayout(jpNovo);
        jpNovo.setLayout(jpNovoLayout);
        jpNovoLayout.setHorizontalGroup(jpNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpNovoLayout.createSequentialGroup().addContainerGap()
                        .addGroup(jpNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jpNovoLayout.createSequentialGroup().addComponent(jbNovo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18,
                                                        Short.MAX_VALUE)
                                                .addComponent(jbCancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jbAlterar).addGap(12, 12, 12).addComponent(jbSalvar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(
                                        jpNovoLayout.createSequentialGroup().addComponent(jScrollPane2).addGap(7, 7, 7))
                                .addGroup(jpNovoLayout.createSequentialGroup().addGroup(jpNovoLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpNovoLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jpNovoLayout.createSequentialGroup().addGroup(jpNovoLayout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(jpNovoLayout.createSequentialGroup()
                                                                        .addGroup(jpNovoLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel1,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel4,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jcbCategoria,
                                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(jpNovoLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false).addComponent(jLabel5)
                                                                                .addComponent(jtfData,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        134,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jpNovoLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false).addComponent(jLabel6)
                                                                                .addComponent(jtfQuantidade,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        97,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(jpNovoLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false).addComponent(jLabel9)
                                                                                .addComponent(jtfAno)
                                                                                .addComponent(jcbTipoLivro,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        129,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addComponent(jLabel3)).addGap(5, 5, 5))
                                                .addGroup(jpNovoLayout.createSequentialGroup().addGap(217, 217, 217)
                                                        .addComponent(jlNovo)))
                                        .addComponent(jLabel7)
                                        .addGroup(jpNovoLayout.createSequentialGroup()
                                                .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 222,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jpNovoLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2).addComponent(jtfAutor,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 159,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jpNovoLayout.createSequentialGroup()
                                        .addGroup(jpNovoLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel10).addComponent(jtfPreco,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))));
        jpNovoLayout.setVerticalGroup(jpNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpNovoLayout.createSequentialGroup().addContainerGap().addComponent(jlNovo).addGap(17, 17, 17)
                        .addGroup(jpNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1).addComponent(jLabel2).addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4).addComponent(jLabel5).addComponent(jLabel9)
                                .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jcbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfData, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbTipoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbNovo).addComponent(jbCancelar).addComponent(jbSalvar)
                                .addComponent(jbAlterar).addComponent(jbExcluir))
                        .addContainerGap()));

        jlAtualizar.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        jlAtualizar.setText("ATUALIZAR LIVRO");

        jtfPesquisa.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jtfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisaActionPerformed(evt);
            }
        });
        jbPesquisa.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jbPesquisa.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/pesquisar.png"))); // NOI18N
        jbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 15)); // NOI18N
        jLabel8.setText("INSIRA O TÍTULO DO LIVRO:");

        jtPesquisaLivro.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtPesquisaLivro.setModel(
                new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null}, {null, null, null},
        {null, null, null}, {null, null, null}}, new String[]{"#", "Titulo", "Autor"}) {
            @SuppressWarnings("rawtypes")
            Class[] types = new Class[]{java.lang.Object.class, java.lang.String.class,
                java.lang.String.class};
            boolean[] canEdit = new boolean[]{true, false, false};

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
        jtPesquisaLivro.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jtPesquisaLivro);
        if (jtPesquisaLivro.getColumnModel().getColumnCount() > 0) {
            jtPesquisaLivro.getColumnModel().getColumn(0).setMaxWidth(40);
            jtPesquisaLivro.getColumnModel().getColumn(1).setResizable(false);
            jtPesquisaLivro.getColumnModel().getColumn(2).setResizable(false);
            jtPesquisaLivro.getColumnModel().getColumn(2).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jpAtualizarLayout = new javax.swing.GroupLayout(jpAtualizar);
        jpAtualizar.setLayout(jpAtualizarLayout);
        jpAtualizarLayout.setHorizontalGroup(jpAtualizarLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpAtualizarLayout.createSequentialGroup().addGap(127, 127, 127).addComponent(jlAtualizar))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jpAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                        jpAtualizarLayout.createSequentialGroup()
                                                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 309,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbPesquisa))));
        jpAtualizarLayout.setVerticalGroup(jpAtualizarLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpAtualizarLayout.createSequentialGroup().addContainerGap().addComponent(jlAtualizar)
                        .addGap(25, 25, 25).addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap()));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpNovo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jpAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jpNovo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1))
                        .addGap(2, 2, 2)));

        jtBiblioteca.addTab("Cadastro Livro", jPanel1);

        jPanel2.setBackground(new java.awt.Color(107, 91, 149));

        jtLivro.setAutoCreateRowSorter(true);
        jtLivro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtLivro.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{{null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}},
                new String[]{"#", "Título", "Autor", "Ano", "Categoria", "Data", "Tipo", "Itens", "R$",
                    "Observações"}) {
            @SuppressWarnings("rawtypes")
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false, false, false, false};

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
        jtLivro.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtLivro);
        if (jtLivro.getColumnModel().getColumnCount() > 0) {
            jtLivro.getColumnModel().getColumn(0).setMaxWidth(40);
            jtLivro.getColumnModel().getColumn(3).setMaxWidth(60);
            jtLivro.getColumnModel().getColumn(5).setMaxWidth(75);
            jtLivro.getColumnModel().getColumn(7).setMaxWidth(40);
            jtLivro.getColumnModel().getColumn(8).setMaxWidth(60);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE));

        jtBiblioteca.addTab("Listar Livros", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jtBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jtBiblioteca));

        pack();
    }

    /**
     *
     * @param evt
     */
    private void jbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {
        pesquisaLivro();
    }

    /**
     * *
     *
     * @param evt
     */
    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        jbSalvar.setText("Salvar");
        limparCampos();
        jbNovo.setEnabled(true);
        habilitarCampos(false);
        setarData();
    }

    /**
     *
     * @param evt
     */
    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
        jbSalvar.setText("Salvar");
        habilitarCampos(true);
        jtfTitulo.requestFocus();
        alterarSalvar = "salvar";
        jbNovo.setEnabled(false);
    }

    /**
     *
     * @param evt
     */
    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        if (alterarSalvar.equals("salvar")) {
            this.salvarLivro();
        } else if (alterarSalvar.equals("alterar")) {
            this.alterarLivro();
        }
        carregarLivros();
        carregarLivrosPesquisa();
        setarData();
    }

    /**
     *
     * @param evt
     */
    private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {
        pesquisaLivro();
    }

    /**
     *
     * @param evt
     */
    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        alterarSalvar = "alterar";
        habilitarCampos(true);
        jbAlterar.setEnabled(false);
        jtfTitulo.requestFocusInWindow();
        int linha = jtPesquisaLivro.getSelectedRow();
        try {
            int codigoLivro = (int) jtPesquisaLivro.getValueAt(linha, 0);

            livroModel = livroService.getLivroDAO(codigoLivro);

            jtfAno.setText(String.valueOf(livroModel.getAno()));
            jtfAutor.setText(livroModel.getAutor());
            jcbCategoria.setSelectedItem(livroModel.getCategoria());
            jtfData.setText(livroModel.getDataCadastro());
            jtfObs.setText(livroModel.getObservacao());
            jtfTitulo.setText(livroModel.getTitulo());
            jcbTipoLivro.setSelectedItem(livroModel.getTipoLivro());
            jtfQuantidade.setText(String.valueOf(livroModel.getQuantidadeLivro()));
            jtfPreco.setText(String.valueOf(livroModel.getLivroValorUnitario()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Código invalido ou nenhum livro selecionado", "Erro",
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
        int linha = jtPesquisaLivro.getSelectedRow();
        int codigoLivro = (int) jtPesquisaLivro.getValueAt(linha, 0);
        // menu de opções para o usuario confirmar a exclusão
        Object[] opcoes = {"Sim", "Não"};
        Object resposta;
        resposta = JOptionPane.showInputDialog(null, "Deseja excluir o livro?", "Excluir?",
                JOptionPane.OK_CANCEL_OPTION, null, opcoes, "Sim");
        if (resposta.equals("Sim")) {
            /**
             * exclui o livro do banco de dados e atualiza a tabela
             */
            if (livroService.excluirLivroDAO(codigoLivro)) {
                JOptionPane.showMessageDialog(this, "Livro excluido com sucesso!", "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                carregarLivros();
                carregarLivrosPesquisa();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o livro!", "Erro", JOptionPane.ERROR_MESSAGE);
                LogModel.logClass = this.getClass().getName();
                new LogCat().writeFile(String.valueOf("Erro ao excluir o livro!"));
            }
        }
    }

    /**
     *
     * @param evt
     */
    private void jtBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {
        carregarLivros();
    }

    /**
     *
     */
    public void carregarLivrosPesquisa() {
        /**
         * Array que buscará no BD (atraves do Controller) os dados para serem
         * exibidos na tabela
         */
        listaModelLivro = livroService.getListaLivroDAO();
        DefaultTableModel modelo = (DefaultTableModel) jtPesquisaLivro.getModel();

        /**
         * Setando a quantidade de linhas que a tabela para não haver duplicação
         * de dados
         */
        modelo.setNumRows(0);

        try {
            /*
			 * insere os produtos na tabela
             */
            int cont = listaModelLivro.size();
            for (int i = 0; i < cont; i++) {
                modelo.addRow(new Object[]{listaModelLivro.get(i).getIdLivro(), listaModelLivro.get(i).getTitulo(),
                    listaModelLivro.get(i).getAutor()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar livros para preencher a tabela\n" + e.toString());
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    /**
     *
     */
    public void carregarLivros() {
        /**
         * Array que buscará no BD (atraves do Controller) os dados para serem
         * exibidos na tabela
         */
        listaModelLivro = livroService.getListaLivroDAO();
        DefaultTableModel modeloTabela = (DefaultTableModel) jtLivro.getModel();

        /**
         * Setando a quantidade de linhas que a tabela para não haver duplicação
         * de dados
         */
        modeloTabela.setNumRows(0);

        try {
            /*
			 * insere os produtos na tabela
             */
            int cont = listaModelLivro.size();
            for (int i = 0; i < cont; i++) {

                modeloTabela.addRow(new Object[]{listaModelLivro.get(i).getIdLivro(),
                    listaModelLivro.get(i).getTitulo(), listaModelLivro.get(i).getAutor(),
                    listaModelLivro.get(i).getAno(), listaModelLivro.get(i).getCategoria(),
                    listaModelLivro.get(i).getDataCadastro(), listaModelLivro.get(i).getTipoLivro(),
                    listaModelLivro.get(i).getQuantidadeLivro(), listaModelLivro.get(i).getLivroValorUnitario(),
                    listaModelLivro.get(i).getObservacao()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar livros para preencher a tabela\n" + e.toString());
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    /**
     *
     * @param condicao
     */
    private void habilitarCampos(boolean condicao) {
        jtfAno.setEnabled(condicao);
        jtfAutor.setEnabled(condicao);
        jtfData.setEnabled(condicao);
        jtfObs.setEnabled(condicao);
        jtfTitulo.setEnabled(condicao);
        jtfQuantidade.setEnabled(condicao);
        jbSalvar.setEnabled(condicao);
        jbCancelar.setEnabled(condicao);
        jcbCategoria.setEnabled(condicao);
        jcbTipoLivro.setEnabled(condicao);
        jtfPreco.setEnabled(condicao);
    }

    public void pesquisaLivro() {
        DefaultTableModel modelo = (DefaultTableModel) this.jtPesquisaLivro.getModel();
        final TableRowSorter<TableModel> classificador = new TableRowSorter<>(modelo);
        this.jtPesquisaLivro.setRowSorter(classificador);
        String texto = jtfPesquisa.getText().toUpperCase();
        classificador.setRowFilter(RowFilter.regexFilter(texto, 1));
    }

    /**
     *
     */
    private void limparCampos() {
        jtfAno.setText("");
        jtfAutor.setText("");
        jtfData.setText("");
        jtfQuantidade.setText("1");
        jtfObs.setText("");
        jtfTitulo.setText("");
        jcbCategoria.setSelectedItem("DOUTRINÁRIO");
        jcbTipoLivro.setSelectedItem("EMPRÉSTIMO");
        jtfPreco.setText("0");
    }

    /**
     *
     */
    private void salvarLivro() {
        livroModel.setAno(Integer.parseInt(jtfAno.getText()));
        livroModel.setAutor(jtfAutor.getText().toUpperCase());
        livroModel.setDataCadastro(jtfData.getText());
        livroModel.setCategoria(jcbCategoria.getSelectedItem().toString());
        livroModel.setObservacao(jtfObs.getText().toUpperCase());
        livroModel.setTitulo(jtfTitulo.getText().toUpperCase());
        livroModel.setTipoLivro(jcbTipoLivro.getSelectedItem().toString());
        livroModel.setQuantidadeLivro(Integer.parseInt(jtfQuantidade.getText()));
        livroModel.setLivroValorUnitario(Double.parseDouble(mascaras.converterVirgulaParaPonto(jtfPreco.getText())));
        try {
            if (livroService.salvarLivroDAO(livroModel) > 0) {
                JOptionPane.showMessageDialog(this, "Livro: " + livroModel.getTitulo() + " cadastrado com sucesso!",
                        "Atenção", JOptionPane.WARNING_MESSAGE);
                limparCampos();
                jbNovo.setEnabled(true);
                habilitarCampos(false);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o livro\n" + e.toString(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    /**
     *
     */
    private void alterarLivro() {
        livroModel.setAno(Integer.parseInt(jtfAno.getText()));
        livroModel.setAutor(jtfAutor.getText().toUpperCase());
        livroModel.setDataCadastro(jtfData.getText());
        livroModel.setCategoria(jcbCategoria.getSelectedItem().toString());
        livroModel.setObservacao(jtfObs.getText().toUpperCase());
        livroModel.setTitulo(jtfTitulo.getText().toUpperCase());
        livroModel.setTipoLivro(jcbTipoLivro.getSelectedItem().toString());
        livroModel.setQuantidadeLivro(Integer.parseInt(jtfQuantidade.getText()));

        if (livroService.atualizarLivroDAO(livroModel)) {
            JOptionPane.showMessageDialog(this, "Livro alterado com sucesso!", "Atenção", JOptionPane.WARNING_MESSAGE);
            jbSalvar.setText("Salvar");
            carregarLivrosPesquisa();
            carregarLivros();
            limparCampos();
            habilitarCampos(false);
            this.jbSalvar.setText("Salvar");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar o livro!", "Erro", JOptionPane.ERROR_MESSAGE);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile("Erro ao alterar o livro!");
        }
    }

    /**
     *
     */
    private void setarData() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDateTime timepoint = LocalDateTime.now();
        jtfData.setText(timepoint.format(fmt));
    }

    /**
     *
     */
    private void corLinhaTabela() {
        ColorirLinhaLivro colorirLinhas = new ColorirLinhaLivro(7);
        jtLivro.getColumnModel().getColumn(7).setCellRenderer(colorirLinhas);
    }

    /**/
    private void cellRendering() {
        // CustomTableCellRenderer cor = new CustomTableCellRenderer();
        // jtLivro.getColumnModel().getColumn(2).setCellRenderer(cor);
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisa;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbCategoria;
    private javax.swing.JComboBox<String> jcbTipoLivro;
    private javax.swing.JLabel jlAtualizar;
    private javax.swing.JLabel jlNovo;
    private javax.swing.JPanel jpAtualizar;
    private javax.swing.JPanel jpNovo;
    private javax.swing.JTabbedPane jtBiblioteca;
    private javax.swing.JTable jtLivro;
    private javax.swing.JTable jtPesquisaLivro;
    private javax.swing.JTextField jtfAno;
    private javax.swing.JTextField jtfAutor;
    private javax.swing.JTextField jtfData;
    private javax.swing.JTextArea jtfObs;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JFormattedTextField jtfPreco;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTextField jtfTitulo;

}
