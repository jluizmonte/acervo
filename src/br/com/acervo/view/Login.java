package br.com.acervo.view;

import br.com.acervo.exception.LoginInvalidoException;
import br.com.acervo.model.LogModel;
import br.com.acervo.model.SessaoUsuarioModel;
import br.com.acervo.model.UsuarioModel;
import br.com.acervo.service.UsuarioService;
import br.com.acervo.util.LogCat;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author proxc
 */
public class Login extends javax.swing.JFrame {

    /**
     * instancia do model, service e sessão do usuário criação de lista de
     * usuário.
     */
    UsuarioService usuarioService = new UsuarioService();
    UsuarioModel usuarioModel = new UsuarioModel();
    ArrayList<UsuarioModel> listaUsuarioModel = new ArrayList<>();
    SessaoUsuarioModel sessaoUsuarioModel = new SessaoUsuarioModel();
    LogCat logCat = new LogCat();

    /**
     * Creates new form Home17
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_bg = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jtfLogin = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_close = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jbEntrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        loader = new javax.swing.JPanel();
        img_loader = new javax.swing.JLabel();
        lbl_loader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        pnl_bg.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));
        login.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                loginMouseDragged(evt);
            }
        });
        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginMousePressed(evt);
            }
        });

        jtfLogin.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jtfLogin.setForeground(new java.awt.Color(0, 0, 0));
        jtfLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfLogin.setBorder(null);
        jtfLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfLoginFocusGained(evt);
            }
        });
        jtfLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLoginActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 112, 192));
        jSeparator1.setForeground(new java.awt.Color(0, 112, 192));

        jSeparator2.setBackground(new java.awt.Color(0, 112, 192));
        jSeparator2.setForeground(new java.awt.Color(0, 112, 192));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/others/unlock_18px.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/others/contacts_18px.png"))); // NOI18N

        lbl_close.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        lbl_close.setForeground(new java.awt.Color(0, 112, 192));
        lbl_close.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_close.setText("X");
        lbl_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_closeMousePressed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 112, 192));
        jLabel5.setText("Esqueceu a senha?");

        jtfSenha.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jtfSenha.setForeground(new java.awt.Color(102, 102, 102));
        jtfSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfSenha.setText("jPasswordField1");
        jtfSenha.setBorder(null);
        jtfSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfSenhaFocusGained(evt);
            }
        });
        jtfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSenhaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel6.setText("Login");

        jbEntrar.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        jbEntrar.setText("Login");
        jbEntrar.setToolTipText("");
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEntrarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 112, 192));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(loginLayout.createSequentialGroup()
                                        .addGap(262, 262, 262)
                                        .addComponent(jbEntrar))))
                            .addGroup(loginLayout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel6)))
                        .addGap(1, 1, 1)
                        .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))))
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addGap(35, 35, 35)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jbEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addGroup(loginLayout.createSequentialGroup()
                .addComponent(lbl_close)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(login, "card2");

        loader.setBackground(new java.awt.Color(255, 255, 255));

        img_loader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/gifs/spinnerLoad.gif"))); // NOI18N

        lbl_loader.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_loader.setForeground(new java.awt.Color(0, 112, 192));
        lbl_loader.setText("Efetuando Login ...");

        javax.swing.GroupLayout loaderLayout = new javax.swing.GroupLayout(loader);
        loader.setLayout(loaderLayout);
        loaderLayout.setHorizontalGroup(
            loaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img_loader)
                .addGap(133, 133, 133))
            .addGroup(loaderLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(lbl_loader)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        loaderLayout.setVerticalGroup(
            loaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loaderLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(img_loader, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_loader)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jPanel1.add(loader, "card3");

        javax.swing.GroupLayout pnl_bgLayout = new javax.swing.GroupLayout(pnl_bg);
        pnl_bg.setLayout(pnl_bgLayout);
        pnl_bgLayout.setHorizontalGroup(
            pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_bgLayout.setVerticalGroup(
            pnl_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jtfLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfLoginFocusGained
        // TODO add your handling code here:
        jtfLogin.setText("");
    }//GEN-LAST:event_jtfLoginFocusGained

    private void jtfSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfSenhaFocusGained
        // TODO add your handling code here:
        jtfSenha.setText("");
    }//GEN-LAST:event_jtfSenhaFocusGained

    private void lbl_closeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_closeMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lbl_closeMousePressed
    int xy, xx;
    private void loginMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }//GEN-LAST:event_loginMouseDragged

    private void loginMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMousePressed
        // TODO add your handling code here:

        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_loginMousePressed

    private void jbEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEntrarActionPerformed
        loader.show();
        login.hide();
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                entrar();
            }
        }, 1000 * 5);
    }//GEN-LAST:event_jbEntrarActionPerformed

    private void jtfLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLoginActionPerformed
        jtfSenha.requestFocus();
    }//GEN-LAST:event_jtfLoginActionPerformed

    private void jtfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSenhaActionPerformed
        loader.show();
        login.hide();
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                entrar();
            }
        }, 500);
    }//GEN-LAST:event_jtfSenhaActionPerformed

    /**
     * metodo para fazer o login.
     */
    private void entrar() {
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
                    this.dispose();
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
                limparCampos();
            }
        } catch (LoginInvalidoException e) {
            new LogCat().writeFile(e.getMessage());
        }

    }

    private void limparCampos() {
        jtfSenha.setText("");
        jtfLogin.setText("");
        login.show();
        loader.hide();
        jtfLogin.requestFocusInWindow();
    }

    private void setSessionUser() {
        SessaoUsuarioModel.codigoUsuario = usuarioModel.getIdUsuario();
        SessaoUsuarioModel.nomeUsuario = usuarioModel.getUsuNome();
        SessaoUsuarioModel.loginUsuario = usuarioModel.getUsuLogin();
        SessaoUsuarioModel.tipoUsuario = usuarioModel.getUsuTipo();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img_loader;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbEntrar;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JPasswordField jtfSenha;
    private javax.swing.JLabel lbl_close;
    private javax.swing.JLabel lbl_loader;
    private javax.swing.JPanel loader;
    private javax.swing.JPanel login;
    private javax.swing.JPanel pnl_bg;
    // End of variables declaration//GEN-END:variables
}
