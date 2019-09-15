package br.com.acervo.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import br.com.acervo.model.EmprestimoLivroModel;
import br.com.acervo.model.EmprestimoLocatarioModel;
import br.com.acervo.model.EmprestimoModel;
import br.com.acervo.model.LivroModel;
import br.com.acervo.model.LivrosEmprestimosLivrosModel;
import br.com.acervo.model.LocadorModel;
import br.com.acervo.model.LocatarioModel;
import br.com.acervo.model.LogModel;
import br.com.acervo.service.EmprestimoLivroService;
import br.com.acervo.service.EmprestimoLocatarioService;
import br.com.acervo.service.EmprestimoService;
import br.com.acervo.service.LivroService;
import br.com.acervo.service.LivrosEmprestimosLivrosService;
import br.com.acervo.service.LocadorService;
import br.com.acervo.service.LocatarioService;
import br.com.acervo.util.ColorirLinhaEmprestimo;
import br.com.acervo.util.GetDateUtil;
import br.com.acervo.util.LogCat;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class EmprestimoView extends javax.swing.JInternalFrame {

    LocatarioModel locatarioModel = new LocatarioModel();
    LocatarioService locatarioService = new LocatarioService();
    ArrayList<LocatarioModel> listaLocatarioModel = new ArrayList<>();

    LocadorModel locadorModel = new LocadorModel();
    LocadorService locadorService = new LocadorService();
    ArrayList<LocadorModel> listaLocadorModel = new ArrayList<>();

    LivroModel livroModel = new LivroModel();
    LivroService livroService = new LivroService();
    ArrayList<LivroModel> listaLivroModel = new ArrayList<>();

    EmprestimoModel emprestimoModel = new EmprestimoModel();
    EmprestimoService emprestimoService = new EmprestimoService();
    ArrayList<EmprestimoModel> listaEmprestimoModel = new ArrayList<>();

    EmprestimoLocatarioModel emprestimoLocatarioModel = new EmprestimoLocatarioModel();
    EmprestimoLocatarioService emprestimoLocatarioService = new EmprestimoLocatarioService();
    ArrayList<EmprestimoLocatarioModel> listaEmprestimoLocatarioModel = new ArrayList<>();

    EmprestimoLivroModel emprestimoLivroModel = new EmprestimoLivroModel();
    EmprestimoLivroService emprestimoLivroService = new EmprestimoLivroService();
    ArrayList<EmprestimoLivroModel> listaEmprestimoLivroModel = new ArrayList<>();

    LivrosEmprestimosLivrosModel livrosEmprestimosLivrosModel = new LivrosEmprestimosLivrosModel();
    LivrosEmprestimosLivrosService livrosEmprestimosLivrosService = new LivrosEmprestimosLivrosService();
    ArrayList<LivrosEmprestimosLivrosModel> listaLivrosEmprestimosLivrosModel = new ArrayList<>();

    GetDateUtil getDateUtil = new GetDateUtil();

    public EmprestimoView() {
        initComponents();
        corLinhaTabela();
        jlCategoria.setText("ESTUDO");
        setarData();
        listarLocatarios();
        listarLocadores();
        listarLivros();
        carregarEmprestimo();
        carregarLivroDevolucao();
        habilitarDesabilitarCampos(false);
    }

    private void initComponents() {
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbLocatario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jtfDataEmprestimo = new javax.swing.JTextField();
        jcbLivro = new javax.swing.JComboBox<>();
        jtfDataDevolucao = new JTextField();
        jtfAutor = new javax.swing.JTextField();
        jlQuantidade = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlCategoria = new javax.swing.JLabel();
        jcbLocador = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbEmprestar = new javax.swing.JButton();
        jbAdicionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtEmprestimoLivro = new javax.swing.JTable();
        jbRemoverItem = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmprestimo = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JScrollPane = new javax.swing.JScrollPane();
        jtDevolucaoLivro = new javax.swing.JTable();
        jbDevolucao = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("EMPRÉSTIMOS & DEVOLUÇÕES");

        jTabbedPane1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(76, 106, 146));

        jPanel2.setBackground(new java.awt.Color(76, 106, 146));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setText("Locatário:");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel8.setText("Data de Empréstimo:");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel3.setText("Título:");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel9.setText("Data de Devolução:");

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setText("Autor(es):");

        jcbLocatario.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jcbLocatario.setForeground(new java.awt.Color(148, 71, 67));

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setText("Disponíveis para empréstimo:");

        jtfDataEmprestimo.setEditable(false);
        jtfDataEmprestimo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtfDataEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
        jtfDataEmprestimo.setBorder(null);

        jcbLivro.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jcbLivro.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbLivroPopupMenuWillBecomeInvisible(evt);
            }

            @Override
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jtfDataDevolucao.setEditable(false);
        jtfDataDevolucao.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtfDataDevolucao.setHorizontalAlignment(SwingConstants.CENTER);
        jtfDataDevolucao.setBorder(null);

        jtfAutor.setEditable(false);
        jtfAutor.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtfAutor.setHorizontalAlignment(SwingConstants.CENTER);
        jtfAutor.setEnabled(false);

        jlQuantidade.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        jlQuantidade.setText("0");
        jlQuantidade.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("Seção(Categoria):");

        jlCategoria.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jlCategoria.setEnabled(false);

        jcbLocador.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jcbLocador.setForeground(new java.awt.Color(0, 83, 156));

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel7.setText("Locador:");

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

        jbEmprestar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbEmprestar.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/emprestar.png"))); // NOI18N
        jbEmprestar.setText("Emprestar");
        jbEmprestar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmprestarActionPerformed(evt);
            }
        });

        jbAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/add.png"))); // NOI18N
        jbAdicionar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarActionPerformed(evt);
            }
        });

        jtEmprestimoLivro.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        jtEmprestimoLivro.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"#", "Livro", "Locador", "Locatário", "Empréstimo", "Devolução", "Qtde."}) {
            @SuppressWarnings("rawtypes")
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false, false, true, false, false, false};

            @Override
            @SuppressWarnings({"rawtypes", "unchecked"})
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jtEmprestimoLivro.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane3.setViewportView(jtEmprestimoLivro);
        if (jtEmprestimoLivro.getColumnModel().getColumnCount() > 0) {
            jtEmprestimoLivro.getColumnModel().getColumn(0).setMaxWidth(30);
            jtEmprestimoLivro.getColumnModel().getColumn(4).setMaxWidth(70);
            jtEmprestimoLivro.getColumnModel().getColumn(5).setMaxWidth(70);
            jtEmprestimoLivro.getColumnModel().getColumn(6).setMaxWidth(60);
        }

        jbRemoverItem.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbRemoverItem.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/lixeira.png"))); // NOI18N
        jbRemoverItem.setText("Remover Itens");
        jbRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverItemActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4).addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jcbLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jtfAutor)))
                                        .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51,
                                                        Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                false)
                                                        .addComponent(jlCategoria,
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                jPanel2Layout.createSequentialGroup().addGap(55, 55, 55)
                                                                        .addComponent(jlQuantidade)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9).addComponent(jLabel2).addComponent(jLabel7))
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(jcbLocatario, 0, 219, Short.MAX_VALUE)
                                                                .addComponent(jcbLocador, 0,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addComponent(jtfDataDevolucao,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 141,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18).addComponent(jbAdicionar,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup().addComponent(jLabel8)
                                                .addGap(33, 33, 33)
                                                .addComponent(jtfDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                jPanel2Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(jbNovo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbRemoverItem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbEmprestar)))
                        .addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jcbLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jlCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jcbLocador, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jcbLocatario, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtfDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jbAdicionar, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 163,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jbEmprestar)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbRemoverItem).addComponent(jbCancelar).addComponent(jbNovo)))
                        .addContainerGap(29, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel2,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));

        jTabbedPane1.addTab("Empréstimo", jPanel1);

        jPanel3.setBackground(new java.awt.Color(76, 106, 146));

        jtEmprestimo.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        jtEmprestimo.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"#", "Título", "Locador", "Locatário", "Data Empréstimo", "Data Devolução", "Status"}) {
            @SuppressWarnings("rawtypes")
            Class[] types = new Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};

            @Override
            @SuppressWarnings({"rawtypes", "unchecked"})
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jtEmprestimo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtEmprestimo);
        if (jtEmprestimo.getColumnModel().getColumnCount() > 0) {
            jtEmprestimo.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1));

        jTabbedPane1.addTab("Listar Empréstimos", jPanel3);

        jPanel5.setBackground(new java.awt.Color(76, 106, 146));

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setText("DEVOLUÇÃO DE LIVRO");

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel10.setText("SELECIONE O EMPRÉSTIMO NA TABELA:");

        jtDevolucaoLivro.setFont(new java.awt.Font("DejaVu Sans", 0, 12));
        jtDevolucaoLivro.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{"#", "Livro", "Locatário", "Data Empréstimo", "Data Devolução"}) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false};

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jtDevolucaoLivro.getTableHeader().setReorderingAllowed(false);
        JScrollPane.setViewportView(jtDevolucaoLivro);
        if (jtDevolucaoLivro.getColumnModel().getColumnCount() > 0) {
            jtDevolucaoLivro.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jbDevolucao.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbDevolucao.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/devolver.png"))); // NOI18N
        jbDevolucao.setText("Fazer Devolução");
        jbDevolucao.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDevolucaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JScrollPane)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                        jPanel5Layout.createSequentialGroup().addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        295, Short.MAX_VALUE)
                                                .addComponent(jLabel10))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        295, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        )).addComponent(jbDevolucao)).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5).addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jbDevolucao)
                        .addContainerGap()));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel5,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel5,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        jTabbedPane1.addTab("Devolver Livro", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jTabbedPane1));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 454,
                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
        preencherCampos();
        listarLocatarios();
        listarLocadores();
        listarLivros();
        carregarEmprestimo();
        carregarLivroDevolucao();
        jbNovo.setEnabled(false);
        habilitarDesabilitarCampos(true);
    }

    private void jbRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = jtEmprestimoLivro.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) jtEmprestimoLivro.getModel();
        modelo.removeRow(linha);
    }

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        adicionarLivroTabela();
    }

    private void jbEmprestarActionPerformed(java.awt.event.ActionEvent evt) {

        liberarEmprestimo();
        jbNovo.setEnabled(true);
        habilitarDesabilitarCampos(false);
        limparCampos();
        listarLocatarios();
        listarLocadores();
        listarLivros();
        carregarEmprestimo();
        carregarLivroDevolucao();
        listaEmprestimoModel = new ArrayList<>();
    }

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        corLinhaTabela();
        setarData();
        limparCampos();
        listarLocatarios();
        listarLocadores();
        listarLivros();
        carregarEmprestimo();
        carregarLivroDevolucao();
        habilitarDesabilitarCampos(false);
        jbNovo.setEnabled(true);
    }

    private void jcbLivroPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
        if (jcbLivro.isVisible()) {
            exibirQuantidadeLivro();
        }
    }

    private void jbDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {
        Object[] opcoes = {"Sim", "Não"};
        Object resposta;
        resposta = JOptionPane.showInputDialog(null, "Registrar devolução do(s) livro(s)", "Registrar?",
                JOptionPane.OK_CANCEL_OPTION, null, opcoes, "Sim");
        if (resposta.equals("Sim")) {
            int linha = jtDevolucaoLivro.getSelectedRow();
            int codigoEmprestimo = (int) jtDevolucaoLivro.getValueAt(linha, 0);

            listaLivrosEmprestimosLivrosModel = livrosEmprestimosLivrosService
                    .getListaLivrosVendasLivrosDAO(codigoEmprestimo);

            emprestimoModel = emprestimoService.getEmprestimoDAO(codigoEmprestimo);
            for (int i = 0; i < listaLivrosEmprestimosLivrosModel.size(); i++) {

                livroModel = new LivroModel();
                emprestimoLivroModel = new EmprestimoLivroModel();

                livroModel.setIdLivro(listaLivrosEmprestimosLivrosModel.get(i).getLivroModel().getIdLivro());
                livroModel.setQuantidadeLivro(
                        (listaLivrosEmprestimosLivrosModel.get(i).getLivroModel().getQuantidadeLivro()
                        + listaLivrosEmprestimosLivrosModel.get(i).getEmprestimoLivroModel()
                                .getQuantidadeEmprestimo()));

                emprestimoModel.setStatus("INATIVO");
                emprestimoModel.setIdLivro(listaLivrosEmprestimosLivrosModel.get(i).getLivroModel().getIdLivro());
                emprestimoModel.setDataDevolucao(String.valueOf(jtDevolucaoLivro.getValueAt(linha, 4)));
                emprestimoModel.setDataEmprestimo(String.valueOf(jtDevolucaoLivro.getValueAt(linha, 3)));

                livroModel.setQuantidadeLivro(1);
                listaLivroModel.add(livroModel);
            }

            try {
                livroService.alterarEstoqueLivroDAO(listaLivroModel);
                emprestimoService.atualizarEmprestimoDAO(emprestimoModel);
                JOptionPane.showMessageDialog(this, "Livro devolvido com sucesso!", "Atenção",
                        JOptionPane.WARNING_MESSAGE);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao registrar a devolução", "Erro", JOptionPane.ERROR_MESSAGE);
                LogModel.logClass = this.getClass().getName();
                new LogCat().writeFile(String.valueOf(e));
            }
        }
        carregarEmprestimo();
        carregarLivroDevolucao();
        listarLivros();
        limparCampos();
        jbNovo.setEnabled(true);
    }

    private void listarLocatarios() {

        try {
            listaLocatarioModel = locatarioService.getListaLocatarioDAO();
            jcbLocatario.removeAllItems();
            int cont = listaLocatarioModel.size();
            for (int i = 0; i < cont; i++) {
                jcbLocatario.addItem(listaLocatarioModel.get(i).getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os locatários", "Erro", JOptionPane.ERROR);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    private void listarLocadores() {

        try {
            listaLocadorModel = locadorService.getListaLocadorDAO();
            jcbLocador.removeAllItems();
            int cont = listaLocadorModel.size();
            for (int i = 0; i < cont; i++) {
                jcbLocador.addItem(listaLocadorModel.get(i).getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os locadores", "Erro", JOptionPane.ERROR);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    private void listarLivros() {
        try {
            listaLivroModel = livroService.getListaLivroDAO();
            jcbLivro.removeAllItems();
            int cont = listaLivroModel.size();
            for (int i = 0; i < cont; i++) {
                if (listaLivroModel.get(i).getQuantidadeLivro() > 0) {
                    if (listaLivroModel.get(i).getTipoLivro().equals("EMPRÉSTIMO")) {
                        jcbLivro.addItem(listaLivroModel.get(i).getTitulo());
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar os livros", "Erro", JOptionPane.ERROR);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    private void preencherCampos() {
        livroModel = livroService.getLivroDAO(jcbLivro.getSelectedItem().toString());
        jlQuantidade.setText(String.valueOf(livroModel.getQuantidadeLivro()));
        jtfAutor.setText(String.valueOf(livroModel.getAutor()));
        jlCategoria.setText(String.valueOf(livroModel.getCategoria()));
    }

    private void carregarEmprestimo() {
        /**
         * Array que buscará no BD (atraves do Controller) os dados para serem
         * exibidos na tabela
         */
        DefaultTableModel modelo = (DefaultTableModel) jtEmprestimo.getModel();
        listaEmprestimoLocatarioModel = emprestimoLocatarioService.getListaEmprestimosLocatarioDAO();
        // Setando a quantidade de linhas que a tabela para não haver duplicação de
        // dados
        modelo.setNumRows(0);

        try {
            // insere os produtos na tabela
            int cont = listaEmprestimoLocatarioModel.size();
            for (int i = 0; i < cont; i++) {
                modelo.addRow(
                        new Object[]{listaEmprestimoLocatarioModel.get(i).getEmprestimoModel().getIdEmprestimo(),
                            listaEmprestimoLocatarioModel.get(i).getLivroModel().getTitulo(),
                            listaEmprestimoLocatarioModel.get(i).getLocadorModel().getNome(),
                            listaEmprestimoLocatarioModel.get(i).getLocatarioModel().getNome(),
                            listaEmprestimoLocatarioModel.get(i).getEmprestimoModel().getDataEmprestimo(),
                            listaEmprestimoLocatarioModel.get(i).getEmprestimoModel().getDataDevolucao(),
                            listaEmprestimoLocatarioModel.get(i).getEmprestimoModel().getStatus()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar livros para preencher a tabela\n" + e.toString());
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    private void exibirQuantidadeLivro() {
        jlQuantidade.setEnabled(true);
        jlCategoria.setEnabled(true);
        jtfAutor.setEnabled(true);

        livroModel = livroService.getLivroDAO(jcbLivro.getSelectedItem().toString());

        jlQuantidade.setText(String.valueOf(livroModel.getQuantidadeLivro()));
        jlCategoria.setText(livroModel.getCategoria());
        jtfAutor.setText(livroModel.getAutor());

    }

    private void setarData() {
        jtfDataEmprestimo.setText(getDateUtil.getDateTime());
        jtfDataDevolucao.setText(getDateUtil.getDateTimeMonth());

    }

    private void habilitarDesabilitarCampos(boolean condicao) {
        jtfAutor.setEnabled(condicao);
        jtfDataDevolucao.setEnabled(condicao);
        jtfDataEmprestimo.setEnabled(condicao);
        jcbLivro.setEnabled(condicao);
        jcbLocador.setEnabled(condicao);
        jcbLocatario.setEnabled(condicao);
        jbEmprestar.setEnabled(condicao);
        jlCategoria.setEnabled(condicao);
        jlQuantidade.setEnabled(condicao);
        jbAdicionar.setEnabled(condicao);
        jbCancelar.setEnabled(condicao);
        jbEmprestar.setEnabled(condicao);
    }

    private void limparCampos() {
        jtfAutor.setText("");
        jlCategoria.setText("ESTUDO");
        jlQuantidade.setText("0");
        DefaultTableModel modelo = (DefaultTableModel) jtEmprestimoLivro.getModel();
        modelo.setNumRows(0);
    }

    private void corLinhaTabela() {
        ColorirLinhaEmprestimo colorirLinhas = new ColorirLinhaEmprestimo(6);
        jtEmprestimo.getColumnModel().getColumn(6).setCellRenderer(colorirLinhas);
    }

    private void adicionarLivroTabela() {
        @SuppressWarnings("unused")
        int codigoLivro, codigoLocador, codigoLocatario, codigoEmprestimo, quantidade = 0;

        // pegar o id do locador
        locadorModel = locadorService.getLocadorDAO(jcbLocador.getSelectedItem().toString());
        codigoLocador = locadorModel.getIdLocador();

        // pegar o id do locatario
        locatarioModel = locatarioService.getLocatarioDAO(jcbLocatario.getSelectedItem().toString());
        codigoLocatario = locatarioModel.getIdLocatario();

        // pegar o id do livro
        livroModel = livroService.getLivroDAO(jcbLivro.getSelectedItem().toString());
        codigoLivro = livroModel.getIdLivro();

        if (jlQuantidade.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Você deve inserir a quantidade de livros!", "Atenção",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            livroModel = livroService.getLivroDAO(codigoLivro);
            locadorModel = locadorService.getLocadorDAO(codigoLocador);
            locatarioModel = locatarioService.getLocatarioDAO(codigoLocatario);

            quantidade = livroModel.getQuantidadeLivro();
            if (quantidade > 1) {
                quantidade = Integer.parseInt((JOptionPane.showInputDialog(this,
                        "Quantas unidades emprestar deste livro?", "Quantidade", JOptionPane.QUESTION_MESSAGE)));
            } else {
                quantidade = Integer.parseInt(jlQuantidade.getText());
            }
            String dataDevolucao = jtfDataDevolucao.getText();
            String dataEmprestimo = jtfDataEmprestimo.getText();

            // adiciona uma linha na tabela
            DefaultTableModel modelo = (DefaultTableModel) jtEmprestimoLivro.getModel();
            int cont = 0;
            for (int i = 0; i < cont; i++) {
                modelo.setNumRows(0);
            }
            modelo.addRow(new Object[]{livroModel.getIdLivro(), livroModel.getTitulo(), locadorModel.getNome(),
                locatarioModel.getNome(), dataEmprestimo, dataDevolucao, quantidade});
        }
    }

    private void carregarLivroDevolucao() {
        DefaultTableModel modelo = (DefaultTableModel) jtDevolucaoLivro.getModel();
        // Setando a quantidade de linhas que a tabela para não haver duplicação de
        // dados
        modelo.setNumRows(0);
        try {
            // insere os produtos na tabela
            int cont = listaEmprestimoLocatarioModel.size();
            for (int i = 0; i < cont; i++) {
                if (listaEmprestimoLocatarioModel.get(i).getEmprestimoModel().getStatus().equals("ATIVO")) {
                    modelo.addRow(
                            new Object[]{listaEmprestimoLocatarioModel.get(i).getEmprestimoModel().getIdEmprestimo(),
                                listaEmprestimoLocatarioModel.get(i).getLivroModel().getTitulo(),
                                listaEmprestimoLocatarioModel.get(i).getLocatarioModel().getNome(),
                                listaEmprestimoLocatarioModel.get(i).getEmprestimoModel().getDataEmprestimo(),
                                listaEmprestimoLocatarioModel.get(i).getEmprestimoModel().getDataDevolucao()});
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar livros para preencher a tabela\n" + e.toString());
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    /**
     * verifica o status antes de liberar para ele o emprestimo de um
     * determinado livro.
     */
    public void liberarEmprestimo() {
        String statusLocatario = "";
        locatarioModel = locatarioService.getLocatarioDAO(jcbLocatario.getSelectedItem().toString());
        statusLocatario = locatarioModel.getStatus();
        if (statusLocatario.equals("SUSPENSO") || statusLocatario.equals("BLOQUEADO")) {
            JOptionPane.showMessageDialog(this,
                    "O locatário está com o cadastro " + statusLocatario + ".\n"
                    + "Procure o responsável pela livraria para mais informações.\n"
                    + "O empréstimo não foi realizado.",
                    "Atenção locatário " + statusLocatario + "!", JOptionPane.WARNING_MESSAGE);
            habilitarDesabilitarCampos(false);
        } else {
            realizarEmprestimo();
        }
    }

    public void realizarEmprestimo() {
        @SuppressWarnings("unused")
        int codigoLivro = 0;
        int codigoLocador, codigoLocatario = 0;
        int codigoProduto = 0;
        int codigoEmprestimo = 0;
        // int quantidade = 0;
        String status = "ATIVO";
        listaEmprestimoLivroModel = new ArrayList<>();

        // pegar o id do locador
        locadorModel = locadorService.getLocadorDAO(jcbLocador.getSelectedItem().toString());
        codigoLocador = locadorModel.getIdLocador();

        // pegar o id do locatario
        locatarioModel = locatarioService.getLocatarioDAO(jcbLocatario.getSelectedItem().toString());
        codigoLocatario = locatarioModel.getIdLocatario();

        // pegar o id do livro
        livroModel = livroService.getLivroDAO(jcbLivro.getSelectedItem().toString());
        codigoLivro = livroModel.getIdLivro();

        int cont = jtEmprestimoLivro.getRowCount();
        for (int i = 0; i < cont; i++) {
            livroModel = new LivroModel();
            emprestimoModel = new EmprestimoModel();

            livroModel = livroService.getLivroDAO(codigoProduto);
            emprestimoLivroModel = new EmprestimoLivroModel();
            codigoProduto = (int) jtEmprestimoLivro.getValueAt(i, 0);

            // emprestimo
            emprestimoModel.setIdLocador(codigoLocador);
            emprestimoModel.setIdLocatario(codigoLocatario);
            emprestimoModel.setIdEmprestimo(codigoProduto);
            emprestimoModel.setIdLivro(codigoProduto);
            emprestimoModel.setQuantidadeEmprestimo(Integer.parseInt(jtEmprestimoLivro.getValueAt(i, 6).toString()));
            emprestimoModel.setStatus(status);
            emprestimoModel.setDataDevolucao(jtEmprestimoLivro.getValueAt(i, 5).toString());
            emprestimoModel.setDataEmprestimo(jtEmprestimoLivro.getValueAt(i, 4).toString());

            codigoEmprestimo = emprestimoService.salvarEmprestimoDAO(emprestimoModel);
            if (codigoEmprestimo > 0) {
                JOptionPane.showMessageDialog(this,
                        "Empréstimo registrado com sucesso:\n" + "Locador: " + locadorModel.getNome() + "\n"
                        + "Locatário: " + locatarioModel.getNome() + "\n" + "Data de Devolução: "
                        + emprestimoModel.getDataDevolucao() + "\n",
                        "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao registrar o empréstimo!", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }

            // emprestimo livro
            emprestimoLivroModel.setIdEmprestimoLivro(codigoProduto);
            emprestimoLivroModel.setLivro(codigoProduto);
            emprestimoLivroModel.setQuantidadeEmprestimo(emprestimoModel.getQuantidadeEmprestimo());
            emprestimoLivroModel.setEmprestimo(codigoEmprestimo);

            // livro
            livroModel.setIdLivro(codigoProduto);
            livroModel.setQuantidadeLivro(livroService.getLivroDAO(codigoProduto).getQuantidadeLivro()
                    - Integer.parseInt(jtEmprestimoLivro.getValueAt(i, 6).toString()));
            livroModel.setTitulo(livroService.getLivroDAO(codigoProduto).getTitulo());
            listaEmprestimoLivroModel.add(emprestimoLivroModel);
            listaLivroModel.add(livroModel);
        }

        // salvar os livros do empréstimo
        if (emprestimoLivroService.salvarEmprestimosLivrosDAO(listaEmprestimoLivroModel)) {
            // alterar estoque de livros
            livroService.alterarEstoqueLivroDAO(listaLivroModel);
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao salvar os livros do empréstimo!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private javax.swing.JScrollPane JScrollPane;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbAdicionar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbDevolucao;
    private javax.swing.JButton jbEmprestar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbRemoverItem;
    private javax.swing.JComboBox<String> jcbLivro;
    private javax.swing.JComboBox<String> jcbLocador;
    private javax.swing.JComboBox<String> jcbLocatario;
    private javax.swing.JLabel jlCategoria;
    private javax.swing.JLabel jlQuantidade;
    private javax.swing.JTable jtDevolucaoLivro;
    private javax.swing.JTable jtEmprestimo;
    private javax.swing.JTable jtEmprestimoLivro;
    private javax.swing.JTextField jtfAutor;
    private javax.swing.JTextField jtfDataEmprestimo;
    // private jCalendarTextField jtfDataDevolucao;
    private javax.swing.JTextField jtfDataDevolucao;

}
