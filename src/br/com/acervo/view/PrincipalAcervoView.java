package br.com.acervo.view;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.acervo.model.SessaoUsuarioModel;
import br.com.acervo.model.TemaModel;
import br.com.acervo.service.ClienteService;
import br.com.acervo.service.LivroService;
import br.com.acervo.service.TemaService;
import br.com.acervo.service.UsuarioService;
import br.com.acervo.service.VendasService;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class PrincipalAcervoView extends javax.swing.JFrame {

    /**
     * importações dos services responsaveis por buscar os dados no banco e
     * exibir na toolbar da tela principal
     */
    LivroService livroService = new LivroService();
    UsuarioService usuarioService = new UsuarioService();
    VendasService vendasService = new VendasService();
    ClienteService clienteService = new ClienteService();
    TemaService temaService = new TemaService();
    TemaModel temaModel = new TemaModel();
    public String tema;

    public PrincipalAcervoView() {
        initComponents();
        setExtendedState(Frame.MAXIMIZED_BOTH); // seta o tamanho da janela (maximizado) ao iniciar
        setarData();
        setarQuantidade();
        setarAcesso();
        setarOperador();
    }

    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jPanel = new javax.swing.JPanel();
        jbBiblioteca = new rojerusan.RSButtonRound();
        jbLocador = new rojerusan.RSButtonRound();
        jbLocatario = new rojerusan.RSButtonRound();
        jbVendas = new rojerusan.RSButtonRound();
        jbUsuario = new rojerusan.RSButtonRound();
        jbCliente = new rojerusan.RSButtonRound();
        jbEmprestimo = new rojerusan.RSButtonRound();

        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/acervo/images/book/livro3.jpg"));
        Image image = icon.getImage();
        painelInterno = new javax.swing.JDesktopPane() {
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jlOperador = new javax.swing.JLabel();
        jlNomeBiblioteca = new javax.swing.JLabel();
        jlData = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlVendas = new javax.swing.JLabel();
        jlLivros = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlCliente = new javax.swing.JLabel();
        jlIcone = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmiSair = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiLocatario = new javax.swing.JMenuItem();
        jmiEmprestimo = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiAcervo = new javax.swing.JMenuItem();
        jmiLocador = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmiVendas = new javax.swing.JMenuItem();
        jmiCaixa = new javax.swing.JMenuItem();
        jmiCliente = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jmiUsuario = new javax.swing.JMenuItem();
        jmiConfiguracoes = new javax.swing.JMenuItem();
        jmiTemas = new javax.swing.JMenu();
        jmiJTattoo = new javax.swing.JMenu();
        jmiPadrao = new javax.swing.JMenu();
        jmiSynthetica = new javax.swing.JMenu();
        jmiNimbus = new javax.swing.JMenuItem();
        jmiMcWin = new javax.swing.JMenuItem();
        jmiMetal = new javax.swing.JMenuItem();
        jmiMotif = new javax.swing.JMenuItem();
        jmiNoire = new javax.swing.JMenuItem();
        jmiAero = new javax.swing.JMenuItem();
        jmiBlack = new javax.swing.JMenuItem();
        jmiPlain = new javax.swing.JMenuItem();
        jmiBlue = new javax.swing.JMenuItem();
        jmiSystem = new javax.swing.JMenuItem();
        jmiGraphite = new javax.swing.JMenuItem();
        jmiLevantamento = new javax.swing.JMenuItem();
        jmiLogCat = new javax.swing.JMenuItem();
        jmiChangeLog = new javax.swing.JMenuItem();
        jmiSobre = new javax.swing.JMenuItem();
        jmiReiniciar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JLabel();

        URL caminhoImagem = this.getClass().getResource("/br/com/acervo/images/icon/book.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // setTitle("ACERVO - TELA PRINCIPAL");
        this.setTitle("ACERVO 1.2");
        setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(1031, 768));
        setSize(new java.awt.Dimension(1024, 768));

        desktopPane.setBackground(new java.awt.Color(98, 158, 166));
        desktopPane.setFont(new java.awt.Font("Dejavu Sans", 0, 15)); // NOI18N

        jPanel.setBackground(new java.awt.Color(0, 110, 109));

        jbBiblioteca.setBackground(new java.awt.Color(107, 91, 149));
        jbBiblioteca.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jbBiblioteca.setForeground(new java.awt.Color(0, 0, 0));
        jbBiblioteca
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/book.png"))); // NOI18N
        jbBiblioteca.setText("ACERVO");
        jbBiblioteca.setToolTipText("Cadastro e consultas de livros.");
        jbBiblioteca.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jbBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBibliotecaActionPerformed(evt);
            }
        });

        jbLocador.setBackground(new java.awt.Color(0, 83, 156));
        jbLocador.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jbLocador.setForeground(new java.awt.Color(255, 255, 255));
        jbLocador.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/locador.png"))); // NOI18N
        jbLocador.setText("LOCADOR");
        jbLocador.setToolTipText("Cadastro e consulta de pessoas aptas a liberação de livros.");
        jbLocador.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jbLocador.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLocadorActionPerformed(evt);
            }
        });

        jbVendas.setBackground(new java.awt.Color(155, 35, 53));
        jbVendas.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jbVendas.setForeground(new java.awt.Color(255, 255, 255));
        jbVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/venda.png"))); // NOI18N
        jbVendas.setText("VENDA");
        jbVendas.setToolTipText("Cadastro e consulta de vendas realizadas.");
        jbVendas.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jbVendas.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVendasActionPerformed(evt);
            }
        });

        jbLocatario.setBackground(new java.awt.Color(148, 71, 67));
        jbLocatario.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jbLocatario.setForeground(new java.awt.Color(255, 255, 255));
        jbLocatario.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/locatario.png"))); // NOI18N
        jbLocatario.setText("LOCATÁRIO");
        jbLocatario.setToolTipText("Cadastro e consulta de pessoas aptas à retirar livros.");
        jbLocatario.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jbLocatario.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLocatarioActionPerformed(evt);
            }
        });

        jbEmprestimo.setBackground(new java.awt.Color(76, 106, 146));
        jbEmprestimo.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jbEmprestimo.setForeground(new java.awt.Color(255, 255, 255));
        jbEmprestimo.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/emprestar.png"))); // NOI18N
        jbEmprestimo.setText("EMPRÉSTIMO");
        jbEmprestimo.setToolTipText("Cadastro e consulta de livros.");
        jbEmprestimo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jbEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEmprestimoActionPerformed(evt);
            }
        });

        jbUsuario.setBackground(new java.awt.Color(42, 41, 62));
        jbUsuario.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jbUsuario.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/usuario.png"))); // NOI18N
        jbUsuario.setText("USUÁRIO");
        jbUsuario.setToolTipText("Cadastro e consulta de usuário com acesso ao sistema.");
        jbUsuario.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jbUsuario.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsuarioActionPerformed(evt);
            }
        });

        jbCliente.setBackground(new java.awt.Color(47, 79, 79));
        jbCliente.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jbCliente.setForeground(new java.awt.Color(255, 255, 255));
        jbCliente.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/cliente.png"))); // NOI18N
        jbCliente.setText("CLIENTE");
        jbCliente.setToolTipText("Cadastro e consulta de clientes.");
        jbCliente.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jbCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup().addContainerGap().addComponent(jbBiblioteca)
                        .addGap(18, 18, 18).addComponent(jbVendas).addGap(18, 18, 18).addComponent(jbLocador)
                        .addGap(18, 18, 18).addComponent(jbLocatario).addGap(18, 18, 18).addComponent(jbEmprestimo)
                        .addGap(18, 18, 18).addComponent(jbCliente).addGap(18, 18, 18).addComponent(jbUsuario)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanelLayout.setVerticalGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbBiblioteca).addComponent(jbVendas).addComponent(jbLocador)
                                .addComponent(jbLocatario).addComponent(jbEmprestimo).addComponent(jbCliente)
                                .addComponent(jbUsuario))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        painelInterno.setBackground(new java.awt.Color(98, 158, 166));
        painelInterno.setFont(new java.awt.Font("Dejavu Sans", 0, 15)); // NOI18N

        javax.swing.GroupLayout painelInternoLayout = new javax.swing.GroupLayout(painelInterno);
        painelInterno.setLayout(painelInternoLayout);
        painelInternoLayout.setHorizontalGroup(painelInternoLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        painelInternoLayout.setVerticalGroup(painelInternoLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 388, Short.MAX_VALUE));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(1046, 24));

        jlOperador.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jlOperador.setForeground(new java.awt.Color(0, 0, 0));
        jlOperador.setText("$Locador");
        jlOperador.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jlNomeBiblioteca.setFont(new java.awt.Font("Dejavu Sans", 1, 12));
        jlNomeBiblioteca.setForeground(new java.awt.Color(0, 0, 0));
        jlNomeBiblioteca.setText("$NomeBiblioteca");
        jlNomeBiblioteca.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jlData.setFont(new java.awt.Font("Dejavu Sans", 1, 12)); // NOI18N
        jlData.setForeground(new java.awt.Color(0, 0, 0));
        jlData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlData.setText("HH:mm:ss");
        jlData.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel1.setFont(new java.awt.Font("Dejavu Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Vendas Realizadas: ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jlVendas.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jlVendas.setForeground(new java.awt.Color(0, 0, 0));
        jlVendas.setText("0");
        jlVendas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jlLivros.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jlLivros.setForeground(new java.awt.Color(0, 0, 0));
        jlLivros.setText("0");

        jLabel4.setFont(new java.awt.Font("Dejavu Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Livros Disponíveis:");

        jLabel5.setFont(new java.awt.Font("Dejavu Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Clientes Cadastrados:");

        jlCliente.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jlCliente.setForeground(new java.awt.Color(0, 0, 0));
        jlCliente.setText("0");

        jlIcone.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlIcone.setForeground(new java.awt.Color(255, 255, 255));
        jlIcone.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/br/com/acervo/images/actions/icons8-contatos-16.png"))); // NOI18N
        jlIcone.setText("L");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2)
                        .addComponent(jlIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jlOperador)
                        .addGap(11, 11, 11).addComponent(jlNomeBiblioteca).addGap(18, 18, 18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jLabel1).addGap(11, 11, 11).addComponent(jlVendas).addGap(18, 18, 18)
                        .addComponent(jLabel4).addGap(13, 13, 13).addComponent(jlLivros).addGap(18, 18, 18)
                        .addComponent(jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlCliente).addGap(16, 16, 16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jlData)
                        .addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jlOperador, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlNomeBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlIcone))
                        .addComponent(jlVendas).addComponent(jLabel4).addComponent(jlLivros)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlCliente).addComponent(jLabel5).addComponent(jlData)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        desktopPane.setLayer(jPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(painelInterno, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktopPane.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout
                .setHorizontalGroup(desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(painelInterno)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE));
        desktopPaneLayout.setVerticalGroup(desktopPaneLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(desktopPaneLayout.createSequentialGroup()
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(painelInterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setFont(new java.awt.Font("Dejavu Sans", 1, 14)); // NOI18N

        jMenu3.setText("Arquivo");
        jMenu3.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N

        jmiSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jmiSair.setFont(new java.awt.Font("Dejavu Sans", 0, 14)); // NOI18N
        jmiSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/exit.png"))); // NOI18N
        jmiSair.setText("Sair");
        jmiSair.setToolTipText("Sair da aplicação");
        jmiSair.addActionListener((java.awt.event.ActionEvent evt) -> {
            jmiSairActionPerformed(evt);
        });
        jMenu3.add(jmiSair);

        jMenuBar1.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(180, 180, 177));
        jMenu4.setText("Saída de Livro");
        jMenu4.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N

        jmiLocatario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jmiLocatario.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jmiLocatario.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/locatario.png"))); // NOI18N
        jmiLocatario.setText("Locatário");
        jmiLocatario.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLocatarioActionPerformed(evt);
            }
        });
        jMenu4.add(jmiLocatario);

        jmiLogCat.setFont(new java.awt.Font("Dejavu Sans", 0, 12));
        jmiLogCat.setText("Logs do Sistema");
        jmiLogCat.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jmiLogCat.setToolTipText("Visualizador de Logs do sistema.");
        jmiLogCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/log.png")));
        jmiLogCat.addActionListener((java.awt.event.ActionEvent evt) -> {
            try {
                jmiLogCatActionPerformed(evt);
            } catch (FileNotFoundException e) {
            }
        });
        jMenu7.add(jmiLogCat);

        jmiChangeLog.setFont(new java.awt.Font("Dejavu Sans", 0, 12));
        jmiChangeLog.setText("Registro de mudanças");
        jmiChangeLog.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jmiChangeLog.setToolTipText("Visualizador de mudanças do sistema.");
        jmiChangeLog.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/changelog.png")));
        jmiChangeLog.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jmiChangeLogActionPerformed(evt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });
        jMenu7.add(jmiChangeLog);

        jmiEmprestimo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jmiEmprestimo.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jmiEmprestimo.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/emprestar.png"))); // NOI18N
        jmiEmprestimo.setText("Empréstimo");
        jmiEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEmprestimoActionPerformed(evt);
            }
        });
        jMenu4.add(jmiEmprestimo);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Entrada de Livro");
        jMenu5.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N

        jmiAcervo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jmiAcervo.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jmiAcervo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/book.png"))); // NOI18N
        jmiAcervo.setText("Acervo");
        jmiAcervo.addActionListener((java.awt.event.ActionEvent evt) -> {
            jmiAcervoActionPerformed(evt);
        });
        jMenu5.add(jmiAcervo);

        jmiLocador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jmiLocador.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jmiLocador.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/locador.png"))); // NOI18N
        jmiLocador.setText("Locador");
        jmiLocador.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiLocadorActionPerformed(evt);
            }
        });
        jMenu5.add(jmiLocador);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Vendas");
        jMenu6.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N

        jmiVendas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jmiVendas.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jmiVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/venda.png"))); // NOI18N
        jmiVendas.setText("Vendas");
        jmiVendas.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVendasActionPerformed(evt);
            }
        });
        jMenu6.add(jmiVendas);

        jmiCaixa.setText("Caixa");
        jmiCaixa.setFont(new java.awt.Font("Dejavu Sans", 0, 12));
        jmiCaixa.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmiCaixa.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmiCaixaActionPerformed(evt);
            }
        });
        jmiCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/money.png"))); // NOI18N
        jMenu6.add(jmiCaixa);

        jmiCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jmiCliente.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jmiCliente.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/cliente.png"))); // NOI18N
        jmiCliente.setText("Cliente");
        jmiCliente.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClienteActionPerformed(evt);
            }
        });
        jMenu6.add(jmiCliente);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Ferramentas");
        jMenu7.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N

        jmiUsuario.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jmiUsuario.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jmiUsuario.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/usuario.png"))); // NOI18N
        jmiUsuario.setText("Usuários");
        jmiUsuario.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUsuarioActionPerformed(evt);
            }
        });
        jMenu7.add(jmiUsuario);

        jmiConfiguracoes.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jmiConfiguracoes.setFont(new java.awt.Font("Dejavu Sans", 0, 12)); // NOI18N
        jmiConfiguracoes.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/configuracao.png"))); // NOI18N
        jmiConfiguracoes.setText("Configurações");
        jmiConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConfiguracoesActionPerformed(evt);
            }
        });
        jMenu7.add(jmiConfiguracoes);

        jmiTemas.setText("Tema");
        jmiTemas.setFont(new java.awt.Font("Dejavu Sans", 0, 12));
        jmiTemas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/tema.png")));

        //
        jmiJTattoo.setText("Temas 2018");
        jmiJTattoo.setFont(new java.awt.Font("Dejavu Sans", 0, 12));
        jmiJTattoo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/tema.png")));
        jmiTemas.add(jmiJTattoo);

        jmiSobre.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmiSobre.setFont(new java.awt.Font("Dejavu Sans", 0, 12));
        jmiSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/sobre.png"))); // NOI18N
        jmiSobre.setText("Sobre");
        jmiSobre.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSobreActionPerformed(evt);
            }
        });
        jMenu7.add(jmiSobre);

        jMenuBar1.add(jMenu7);

        jMenu1.setText(
                "ATALHOS: F2 - SAIR F3 - ACERVO F4 - VENDA F5 - LOCADOR F6 - LOCATÁRIO F7 - EMPRÉSTIMO F8 - CLIENTE");
        jMenu1.setFont(new java.awt.Font("Dejavu Sans", 0, 10));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/atalho.png")));
        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuBar1.add(jMenu1);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(desktopPane));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addComponent(desktopPane).addGap(0, 0, 0)));

        pack();
    }

    /**
     * evento para exibir a tela: Biblioteca(acervo)
     *
     * @param evt
     */
    private void jbBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {
        AcervoView acervo = new AcervoView();
        painelInterno.add(acervo);
        acervo.setVisible(true);
    }

    /**
     * evento para exibir a tela: vendas de livros
     *
     * @param evt
     */
    private void jbVendasActionPerformed(java.awt.event.ActionEvent evt) {
        VendasLivrosView vendas = new VendasLivrosView();
        painelInterno.add(vendas);
        vendas.setVisible(true);
    }

    /**
     * evento para exibir a tela: Locador (cadastro e administração)
     *
     * @param evt
     */
    private void jbLocadorActionPerformed(java.awt.event.ActionEvent evt) {
        LocadorView locadorView = new LocadorView();
        painelInterno.add(locadorView);
        locadorView.setVisible(true);
    }

    /**
     * evento para exibir a tela: Locatário (cadastro e administração)
     *
     * @param evt
     */
    private void jbLocatarioActionPerformed(java.awt.event.ActionEvent evt) {
        LocatarioView locatarioView = new LocatarioView();
        painelInterno.add(locatarioView);
        locatarioView.setVisible(true);
    }

    /**
     * evento para exibir a tela: Empréstimo de livros e devoluções
     *
     * @param evt
     */
    private void jbEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {
        EmprestimoView emprestimoView = new EmprestimoView();
        painelInterno.add(emprestimoView);
        emprestimoView.setVisible(true);
    }

    /**
     * Item de menu para sair do sistema
     *
     * @param evt
     */
    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {
        Object[] opcoes = {"Sim", "Não"};
        Object resposta;
        resposta = JOptionPane.showInputDialog(null, "Deseja encerrar a aplicação?", "Sair?",
                JOptionPane.OK_CANCEL_OPTION, null, opcoes, "Sim");
        if (resposta.equals("Sim")) {
            System.exit(0);
        }
    }

    /**
     * evento para exibir a tela: Usuário(cadastro e administração)
     *
     * @param evt
     */
    private void jbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        UsuarioView usu = new UsuarioView();
        painelInterno.add(usu);
        usu.setVisible(true);
    }

    /**
     * evento para exibir a tela: Cliente (cadastro e administração)
     *
     * @param evt
     */
    private void jbClienteActionPerformed(java.awt.event.ActionEvent evt) {
        ClienteView clienteView = new ClienteView();
        painelInterno.add(clienteView);
        clienteView.setVisible(true);
    }

    /**
     * evento para exibir a tela: Locatário (cadastro e administração)
     *
     * @param evt
     */
    private void jmiLocatarioActionPerformed(java.awt.event.ActionEvent evt) {

        jbLocatarioActionPerformed(evt);
    }

    /**
     * evento para exibir a tela: Empréstimo e devoluções de livros
     *
     * @param evt
     */
    private void jmiEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {
        jbEmprestimoActionPerformed(evt);
    }

    /**
     * evento para exibir a tela: biblioteca (acervo)
     *
     * @param evt
     */
    private void jmiAcervoActionPerformed(java.awt.event.ActionEvent evt) {
        jbBibliotecaActionPerformed(evt);
    }

    private void jmiLogCatActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {
        LogCatView logCatView = new LogCatView();
        painelInterno.add(logCatView);
        logCatView.setVisible(true);
    }

    private void jmiChangeLogActionPerformed(ActionEvent evt) throws FileNotFoundException {
        ChangelogView changelogView = new ChangelogView();
        painelInterno.add(changelogView);
        changelogView.setVisible(true);
    }

    /**
     * evento para exibir a tela: Locador (cadastro e administração)
     *
     * @param evt
     */
    private void jmiLocadorActionPerformed(java.awt.event.ActionEvent evt) {
        jbLocadorActionPerformed(evt);
    }

    /**
     * evento para exibir a tela: Vendas de livros
     *
     * @param evt
     */
    private void jmiVendasActionPerformed(java.awt.event.ActionEvent evt) {
        jbVendasActionPerformed(evt);
    }

    /**
     * evento para exibir a tela: Cliente (cadastro e administração)
     *
     * @param evt
     */
    private void jmiClienteActionPerformed(java.awt.event.ActionEvent evt) {
        jbClienteActionPerformed(evt);
    }

    /**
     * evento para exibir a tela: Usuário (cadastro e administração)
     *
     * @param evt
     */
    private void jmiUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
        jbUsuarioActionPerformed(evt);
    }

    /**
     *
     * @param evt
     */
    private void jmiCaixaActionPerformed(java.awt.event.ActionEvent evt) {
        CaixaView caixaView = new CaixaView();
        painelInterno.add(caixaView);
        caixaView.setVisible(true);
    }

    /**
     * evento para exibir a tela: Configurações (funções extras)
     *
     * @param evt
     */
    private void jmiConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {
        SettingView settingView = new SettingView();
        painelInterno.add(settingView);
        settingView.setVisible(true);
    }

    /**
     * evento para exibir a tela: Sobre (informações sobre o sistema)
     *
     * @param evt
     */
    private void jmiSobreActionPerformed(java.awt.event.ActionEvent evt) {
        SobreView sobreView = new SobreView(this, true);
        sobreView.setVisible(true);
    }

    /**
     * exibir na toolbar (barra de status/ barra inferior) o nome e o código do
     * operador (usuário) após logar no sistema.
     */
    private void setarOperador() {
        jlOperador.setText(SessaoUsuarioModel.codigoUsuario + "- " + SessaoUsuarioModel.nomeUsuario);
        jlNomeBiblioteca.setText("INSTITUIÇÃO: " + temaService.getNomeBiblioteca().getNomeLivraria());
    }

    /**
     * exibir na toolbar (barra de status/ barra inferior) a data atual do login
     * do usuário.
     */
    public void setarData() {
        Thread clock = new Thread() {
            @Override
            public void run() {
                for (;;) {
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
                    LocalDateTime timepoint = LocalDateTime.now();
                    jlData.setText(timepoint.format(fmt));
                }
            }
        };
        clock.start();
    }

    /**
     * exibir na toolbar (barra de status/ barra inferior) a quantidade de
     * livros, clientes, vendas e usuários cadastrados.
     */
    private void setarQuantidade() {
        jlLivros.setText(String.valueOf(livroService.getQuantidadeLivrosCadastrados().getQuantidadeLivro()));
        jlVendas.setText(String.valueOf(vendasService.getQuantidadeVendas().getQuantidadeVendas()));
        jlCliente.setText(String.valueOf(clienteService.getQuantidadeCliente().getQuantidadeCliente()));
    }

    /**
     * filtrar funções que são disponiveis apenas para algum tipo de usuário.
     */
    private void setarAcesso() {
        switch (SessaoUsuarioModel.tipoUsuario) {
            case "CONVIDADO":
                JOptionPane.showMessageDialog(this,
                        "O usuário acessou o sistema como convidado\n" + "Apenas funções do acervo estão disponíveis!",
                        "Aviso!", JOptionPane.WARNING_MESSAGE);
                jbCliente.setEnabled(false);
                jbEmprestimo.setEnabled(false);
                jbLocador.setEnabled(false);
                jbLocatario.setEnabled(false);
                jbUsuario.setEnabled(false);
                jbVendas.setEnabled(false);
                jmiCliente.setEnabled(false);
                jmiEmprestimo.setEnabled(false);
                jmiLocador.setEnabled(false);
                jmiLocatario.setEnabled(false);
                jmiUsuario.setEnabled(false);
                jmiVendas.setEnabled(false);
                jmiLevantamento.setEnabled(false);
                jmiConfiguracoes.setEnabled(false);
                jmiCaixa.setEnabled(false);
                jmiLogCat.setEnabled(false);
                break;
            case "ADMINISTRADOR":
                JOptionPane
                        .showMessageDialog(
                                this, "O usuário acessou o sistema como administrador\n"
                                + "Todas as funções estão disponíveis!\n" + "Consulte o arquivo de log",
                                "Aviso!", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                jbUsuario.setEnabled(false);
                jmiUsuario.setEnabled(false);
                jmiConfiguracoes.setEnabled(false);
                jmiCaixa.setEnabled(false);
                jmiLogCat.setEnabled(false);
                break;
        }
    }

    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSButtonRound jbBiblioteca;
    private rojerusan.RSButtonRound jbCliente;
    private rojerusan.RSButtonRound jbLocador;
    private rojerusan.RSButtonRound jbLocatario;
    private rojerusan.RSButtonRound jbUsuario;
    private rojerusan.RSButtonRound jbVendas;
    private rojerusan.RSButtonRound jbEmprestimo;
    private javax.swing.JLabel jlCliente;
    public javax.swing.JLabel jlData;
    private javax.swing.JLabel jlIcone;
    private javax.swing.JLabel jlLivros;
    private javax.swing.JLabel jlOperador;
    private javax.swing.JLabel jlNomeBiblioteca;
    private javax.swing.JLabel jlVendas;
    private javax.swing.JMenuItem jmiAcervo;
    private javax.swing.JMenuItem jmiCliente;
    private javax.swing.JMenuItem jmiConfiguracoes;
    private javax.swing.JMenuItem jmiEmprestimo;
    private javax.swing.JMenuItem jmiLocador;
    private javax.swing.JMenuItem jmiLocatario;
    private javax.swing.JMenuItem jmiReiniciar;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiSobre;
    private javax.swing.JMenuItem jmiUsuario;
    private javax.swing.JMenuItem jmiVendas;
    private javax.swing.JMenuItem jmiLevantamento;
    private javax.swing.JMenuItem jmiLogCat;
    private javax.swing.JMenuItem jmiChangeLog;
    private javax.swing.JMenuItem jmiCaixa;
    private javax.swing.JMenuItem jmiMetal;
    private javax.swing.JMenuItem jmiMotif;
    private javax.swing.JMenuItem jmiNimbus;
    private javax.swing.JMenuItem jmiSystem;
    private javax.swing.JMenuItem jmiAero;
    private javax.swing.JMenuItem jmiMcWin;
    private javax.swing.JMenuItem jmiNoire;
    private javax.swing.JMenuItem jmiBlue;
    private javax.swing.JMenuItem jmiBlack;
    private javax.swing.JMenuItem jmiPlain;
    private javax.swing.JMenuItem jmiGraphite;
    private javax.swing.JMenu jmiTemas;
    private javax.swing.JMenu jmiPadrao;
    private javax.swing.JMenu jmiJTattoo;
    private javax.swing.JMenu jmiSynthetica;
    private javax.swing.JDesktopPane painelInterno;
}
