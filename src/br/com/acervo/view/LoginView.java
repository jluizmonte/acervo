package br.com.acervo.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import br.com.acervo.exception.LoginInvalidoException;
import br.com.acervo.model.LogModel;
import br.com.acervo.model.SessaoUsuarioModel;
import br.com.acervo.model.UsuarioModel;
import br.com.acervo.service.UsuarioService;
import br.com.acervo.util.LogCat;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class LoginView extends javax.swing.JFrame {

    /**
     * instancia do model, service e sessão do usuário criação de lista de
     * usuário.
     */
    UsuarioService usuarioService = new UsuarioService();
    UsuarioModel usuarioModel = new UsuarioModel();
    ArrayList<UsuarioModel> listaUsuarioModel = new ArrayList<>();
    SessaoUsuarioModel sessaoUsuarioModel = new SessaoUsuarioModel();
    LogCat logCat = new LogCat();

    public LoginView() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null); // centraliza a janela
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfSenha = new javax.swing.JPasswordField();
        jbEntrar = new rojerusan.RSButtonRound();
        jbSair = new rojerusan.RSButtonRound();
        jtfLogin = new javax.swing.JTextField();

        URL caminhoImagem = this.getClass().getResource("/br/com/acervo/images/icon/book.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
        this.setTitle("ACERVO 1.2");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 110, 109));
        jPanel2.setBackground(new java.awt.Color(47, 79, 79));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Comfortaa", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(208, 240, 214));
        jLabel2.setText("ACERVO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 0, -1, -1));

        jLabel5.setIcon(
                new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/icon/login (cópia).png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 110, 109));

        jLabel3.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGIN:");

        jLabel4.setFont(new java.awt.Font("Comfortaa", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SENHA:");

        jtfSenha.setFont(new java.awt.Font("Comfortaa", 0, 18)); // NOI18N
        jtfSenha.setHorizontalAlignment(SwingConstants.CENTER);
        jtfSenha.setBorder(null);
        jtfSenha.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jtfSenhaActionPerformed(evt);
                } catch (LoginInvalidoException e) {
                    e.printStackTrace();
                }
            }
        });

        jbEntrar.setBackground(new java.awt.Color(0, 47, 47));
        jbEntrar.setFont(new java.awt.Font("Comfortaa", 0, 18)); // NOI18N
        jbEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jbEntrar.setText("Entrar");
        jbEntrar.setToolTipText("Entrar no Sistema");
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jbEntrarActionPerformed(evt);
                } catch (LoginInvalidoException e) {
                    e.printStackTrace();
                }
            }
        });

        jbSair.setBackground(new java.awt.Color(188, 36, 60));
        jbSair.setFont(new java.awt.Font("Comfortaa", 0, 18)); // NOI18N
        jbSair.setForeground(new java.awt.Color(255, 255, 255));
        jbSair.setText("Sair");
        jbSair.setToolTipText("Sair da Aplicação");
        jbSair.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);
            }
        });

        jtfLogin.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        jtfLogin.setHorizontalAlignment(SwingConstants.CENTER);
        jtfLogin.setBorder(null);
        jtfLogin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel3Layout.createSequentialGroup().addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 123,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18).addComponent(jbEntrar,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                                .addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel3Layout.createSequentialGroup().addGap(0, 12, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jbEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jbSair, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    /**
     * ao teclar ENTER o cursor automaticamente é lançado para o campo da senha
     *
     * @param evt
     */
    private void jtfLoginActionPerformed(java.awt.event.ActionEvent evt) {
        /**
         * ao inserir o login (usuario) e apertar a tecla enter o campo da senha
         * receberá o foco de entrada de texto.
         */
        jtfSenha.requestFocus();
    }

    /**
     * encerra o sistema, caso o usuário não deseje logar no sistema
     *
     * @param evt
     */
    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {
        /**
         * quando o botão sair for clicado a janela fechará.
         */
        System.exit(0);
    }

    /**
     * botão 'chama' o meódo responsável por fazer o login verificando o login e
     * senha
     *
     * @param evt
     * @throws LoginException
     */
    private void jbEntrarActionPerformed(java.awt.event.ActionEvent evt) throws LoginInvalidoException {
        /**
         * aqui o o método de logar no sistema é chamado quando o usuário entra
         * com os paramêtos do login seguidos pelo clique no botão entrar.
         */
        entrar();
    }

    /**
     * botão 'chama' o meódo responsável por fazer o login verificando o login e
     * senha
     *
     * @param evt
     * @throws LoginException
     */
    private void jtfSenhaActionPerformed(java.awt.event.ActionEvent evt) throws LoginInvalidoException {
        /**
         * aqui o o método de logar no sistema é chamado quando o usuário entra
         * com os paramêtos do login seguidos pela tecla enter.
         */
        entrar();
    }

    /**
     * metodo para fazer o login.
     */
    private void entrar() throws LoginInvalidoException {
        /**
         * seta no modelusuario a senha e o login digitados nos campos pelo
         * usuário.
         */

        usuarioModel.setUsuLogin(jtfLogin.getText());
        usuarioModel.setUsuSenha(String.valueOf(jtfSenha.getPassword()));

        /**
         * chama o metódo para validar o usuário, verificar senha e efetuar o
         * login se o login e senha estiverem corretos, o form principal é
         * chamado se houver algum tipo de erro, o usuário receberá a mensagem
         * de erro.
         */
        try {
            if (!usuarioModel.getUsuLogin().equals("") && !usuarioModel.getUsuSenha().equals("")) {
                if (usuarioService.getValidarUsuarioDAO(usuarioModel)) {
                    usuarioModel = usuarioService.getUsuarioDAO(jtfLogin.getText());
                    setSessionUser();
                    JOptionPane.showMessageDialog(this, "Bem-vindo de volta " + usuarioModel.getUsuNome() + "!",
                            "Sucesso!", JOptionPane.WARNING_MESSAGE);
                    new PrincipalAcervoView().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Usuário ou senha inválidos!\nRevise as credenciais e tente novamente",
                            "Erro ao fazer login", JOptionPane.ERROR_MESSAGE);
                    limparCampos();
                    LogModel.logClass = getClass().toString();
                    throw new LoginInvalidoException("Erro ao realizar ao login, usuario ou senha incorretos");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum dos campos podem ficar em branco", "Revise os dados",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (LoginInvalidoException e) {
            new LogCat().writeFile(e.getMessage());
        }
    }

    private void limparCampos() {
        jtfSenha.setText("");
        jtfLogin.setText("");
        jtfLogin.requestFocusInWindow();
    }

    private void setSessionUser() {
        SessaoUsuarioModel.codigoUsuario = usuarioModel.getIdUsuario();
        SessaoUsuarioModel.nomeUsuario = usuarioModel.getUsuNome();
        SessaoUsuarioModel.loginUsuario = usuarioModel.getUsuLogin();
        SessaoUsuarioModel.tipoUsuario = usuarioModel.getUsuTipo();
    }

    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private rojerusan.RSButtonRound jbEntrar;
    private rojerusan.RSButtonRound jbSair;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JPasswordField jtfSenha;
}
