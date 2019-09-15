package br.com.acervo.view;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.acervo.model.LogModel;
import br.com.acervo.model.UsuarioModel;
import br.com.acervo.service.UsuarioService;
import br.com.acervo.util.LogCat;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class UsuarioView extends javax.swing.JInternalFrame {

    UsuarioService usuarioService = new UsuarioService();
    UsuarioModel usuarioModel = new UsuarioModel();
    ArrayList<UsuarioModel> listaUsuarioModel = new ArrayList<>();

    public UsuarioView() {
        initComponents();
        habilitarCampos(false);
        carregarUsuarios();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbNivel = new javax.swing.JComboBox<>();
        jbNovo = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jtfSenha = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("USUÁRIO");

        jTabbedPane1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(42, 41, 62));

        jPanel3.setBackground(new java.awt.Color(42, 41, 62));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setText("NOVO USUÁRIO");

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel3.setText("Login:");

        jtfNome.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jtfLogin.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel4.setText("Senha:");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel5.setText("Nivel Acesso:");

        jcbNivel.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jcbNivel.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[]{"LOCADOR", "CONVIDADO", "ADMINISTRADOR"}));

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

        jbSalvar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/actions/salvar.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jtfSenha.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout
                .setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel2).addComponent(jLabel4)
                                                .addComponent(jtfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 174,
                                                        Short.MAX_VALUE)
                                                .addComponent(jtfSenha))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel5).addComponent(jLabel3)
                                                        .addComponent(jtfLogin)
                                                        .addComponent(jcbNivel, 0, 177, Short.MAX_VALUE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup().addComponent(jbNovo)
                                                .addGap(62, 62, 62).addComponent(jbCancelar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67,
                                                        Short.MAX_VALUE)
                                                .addComponent(jbSalvar)))
                                .addContainerGap())
                        .addGroup(jPanel3Layout.createSequentialGroup().addGap(160, 160, 160).addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2).addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4).addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jcbNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbNovo).addComponent(jbCancelar).addComponent(jbSalvar))
                        .addContainerGap(31, Short.MAX_VALUE)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jPanel3,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jPanel3,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)));

        jTabbedPane1.addTab("Cadastrar Usuário", jPanel1);

        jPanel2.setBackground(new java.awt.Color(42, 41, 62));

        jtUsuario.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jtUsuario
                .setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{{null, null, null, null}, {null, null, null, null},
                        {null, null, null, null}, {null, null, null, null}},
                        new String[]{"#", "Nome", "Login", "Nivel Acesso"}) {
                    @SuppressWarnings("rawtypes")
                    Class[] types = new Class[]{java.lang.String.class, java.lang.String.class,
                        java.lang.String.class, java.lang.String.class};
                    boolean[] canEdit = new boolean[]{false, false, false, false};

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
        jtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuario);
        if (jtUsuario.getColumnModel().getColumnCount() > 0) {
            jtUsuario.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE));

        jTabbedPane1.addTab("Listar Usuários", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addComponent(jTabbedPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)));
        pack();
    }

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        usuarioModel.setUsuLogin(jtfLogin.getText());
        usuarioModel.setUsuNome(jtfNome.getText().toUpperCase());
        usuarioModel.setUsuSenha(String.valueOf(jtfSenha.getPassword()));
        usuarioModel.setUsuTipo(jcbNivel.getSelectedItem().toString());
        try {
            if (usuarioService.salvarUsuarioDAO(usuarioModel) > 0) {
                JOptionPane.showMessageDialog(this,
                        "Usuário: " + usuarioModel.getUsuNome() + " cadastrado com sucesso!", "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                limparCampos();
                jbNovo.setEnabled(true);
                habilitarCampos(false);
                carregarUsuarios();
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar o usuário\n" + e.toString(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
            LogModel.logClass = this.getClass().getName();
            new LogCat().writeFile(String.valueOf(e));
        }
    }

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {
        habilitarCampos(true);
        jbNovo.setEnabled(false);
        jtfNome.requestFocus();
    }

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        limparCampos();
        habilitarCampos(false);
        jbNovo.setEnabled(true);
    }

    private void jtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {
        int linha = jtUsuario.getSelectedRow();
        int codigoUsuario = (int) jtUsuario.getValueAt(linha, 0);
        /**
         * menu de opções para o usuario confirmar a exclusão
         */
        Object[] opcoes = {"Sim", "Não"};
        Object resposta;
        resposta = JOptionPane.showInputDialog(null, "Deseja excluir o usuário?", "Excluir",
                JOptionPane.OK_CANCEL_OPTION, null, opcoes, "Sim");
        if (resposta.equals("Sim")) {
            /**
             * exclui o livro do banco de dados e atualiza a tabela
             */

            try {
                usuarioService.excluirUsuarioDAO(codigoUsuario);
                JOptionPane.showMessageDialog(this, "Usuário excluido com sucesso!", "Atenção",
                        JOptionPane.WARNING_MESSAGE);
                carregarUsuarios();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
                LogModel.logClass = this.getClass().getName();
                new LogCat().writeFile(String.valueOf(e));
            }
        }
    }

    private void habilitarCampos(boolean condicao) {
        jtfLogin.setEnabled(condicao);
        jtfNome.setEnabled(condicao);
        jtfSenha.setEnabled(condicao);
        jcbNivel.setEnabled(condicao);
        jbSalvar.setEnabled(condicao);
    }

    private void limparCampos() {
        jtfLogin.setText("");
        jtfNome.setText("");
        jtfSenha.setText("");
        jcbNivel.setSelectedItem("LOCADOR");
    }

    public void carregarUsuarios() {
        /**
         * Array que buscará no BD (atraves do Controller) os dados para serem
         * exibidos na tabela
         */
        listaUsuarioModel = usuarioService.getListaUsuarioDAO();
        DefaultTableModel modelo = (DefaultTableModel) jtUsuario.getModel();

        // Setando a quantidade de linhas que a tabela para não haver duplicação de
        // dados
        modelo.setNumRows(0);

        try {
            /**
             * insere os produtos na tabela
             */
            int cont = listaUsuarioModel.size();
            for (int i = 0; i < cont; i++) {
                modelo.addRow(
                        new Object[]{listaUsuarioModel.get(i).getIdUsuario(), listaUsuarioModel.get(i).getUsuNome(),
                            listaUsuarioModel.get(i).getUsuLogin(), listaUsuarioModel.get(i).getUsuTipo()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar usuários para preencher a tabela\n" + e.toString());
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<String> jcbNivel;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JPasswordField jtfSenha;
}
