package br.com.acervo.view;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.acervo.model.SessaoUsuarioModel;
import br.com.acervo.util.ObterInfoSistema;

@SuppressWarnings("serial")
public class SettingView extends javax.swing.JInternalFrame {

    ObterInfoSistema info = new ObterInfoSistema();
    static String diretorioPadrao = System.getProperty("user.home");
    String caminho = diretorioPadrao + "/br/com/acervo";

    public SettingView() {
        // setUndecorated(true);
        initComponents();
        setarInfoSistema();
        habilitarSql();
        JOptionPane.showMessageDialog(null,
                "Não esqueça de fazer backup do BD antes de executar\n" + "algum comando SQL!", "Atenção",
                JOptionPane.WARNING_MESSAGE);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbJava = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jbGoogle = new javax.swing.JButton();
        jbFirefox = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jbPdf = new javax.swing.JButton();
        jlServer = new javax.swing.JLabel();
        jbServer = new javax.swing.JButton();
        jlFront = new javax.swing.JLabel();
        jbFront = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jlInsert = new javax.swing.JLabel();
        jlTruncate = new javax.swing.JLabel();
        jcInsert = new javax.swing.JCheckBox();
        jcTruncate = new javax.swing.JCheckBox();
        jbSql = new javax.swing.JButton();
        jlGoogleSistema = new javax.swing.JLabel();
        jlJavaSistema = new javax.swing.JLabel();
        jlFirefoxSistema = new javax.swing.JLabel();
        jlPdfSistema = new javax.swing.JLabel();
        jlJavaArq = new javax.swing.JLabel();
        jlGoogleArq = new javax.swing.JLabel();
        jlFirefoxArq = new javax.swing.JLabel();
        jlPdfArq = new javax.swing.JLabel();
        jlMensagem = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setIconifiable(true);
        setClosable(true);
        setTitle("CONFIGURAÇÕES");

        jPanel1.setBackground(new java.awt.Color(247, 202, 201));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel2.setText("Java JRE");

        jbJava.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbJava.setText("Extrair e Instalar");
        jbJava.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbJavaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel3.setText("Google Chrome");

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel4.setText("Mozilla Firefox");

        jbGoogle.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbGoogle.setText("Extrair e Instalar");

        jbFirefox.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbFirefox.setText("Extrair e Instalar");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel5.setText("Leitor de PDF");

        jbPdf.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbPdf.setText("Extrair e Instalar");

        jlServer.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlServer.setText("MySQL Server");

        jbServer.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbServer.setText("Instalar");

        jlFront.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlFront.setText("MySQL Front");

        jbFront.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jbFront.setText("Instalar");

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel8.setText("Sql Features:");

        jlInsert.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlInsert.setText("INSERT DATA IN ALL TABLES");

        jlTruncate.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jlTruncate.setText("TRUNCATE ALL TABLES");

        jcInsert.setBackground(new java.awt.Color(247, 202, 201));

        jcTruncate.setBackground(new java.awt.Color(247, 202, 201));

        jbSql.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jbSql.setText("Execute SQL");

        jlGoogleSistema.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlGoogleSistema.setText("SISTEMA");
        jlGoogleSistema.setEnabled(false);

        jlJavaSistema.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlJavaSistema.setText("SISTEMA");
        jlJavaSistema.setEnabled(false);

        jlFirefoxSistema.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlFirefoxSistema.setText("SISTEMA");
        jlFirefoxSistema.setEnabled(false);

        jlPdfSistema.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlPdfSistema.setText("SISTEMA");
        jlPdfSistema.setEnabled(false);

        jlJavaArq.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlJavaArq.setText("ARQUITETURA");
        jlJavaArq.setEnabled(false);

        jlGoogleArq.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlGoogleArq.setText("ARQUITETURA");
        jlGoogleArq.setEnabled(false);

        jlFirefoxArq.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlFirefoxArq.setText("ARQUITETURA");
        jlFirefoxArq.setEnabled(false);

        jlPdfArq.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jlPdfArq.setText("ARQUITETURA");
        jlPdfArq.setEnabled(false);

        jlMensagem.setText("APENAS DISPONÍVEIS PARA USUÁRIOS ADMINISTRADORES!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2).addComponent(jLabel3).addComponent(jLabel4))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlFirefoxSistema, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlGoogleSistema, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlJavaSistema, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlPdfSistema)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlJavaArq).addComponent(jlGoogleArq).addComponent(jlFirefoxArq)
                                .addComponent(jlPdfArq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbPdf)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jbFirefox).addComponent(jbGoogle).addComponent(jbJava)))
                        .addGap(29, 29, 29))
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlMensagem).addContainerGap())
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                        jPanel1Layout.createSequentialGroup().addComponent(jlFront)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jbFront))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                        jPanel1Layout.createSequentialGroup().addComponent(jlServer)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jbServer)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcTruncate).addComponent(jcInsert))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jbSql))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlTruncate, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlInsert)))
                        .addGap(23, 23, 23))
                .addComponent(jSeparator2));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2).addComponent(jlJavaSistema).addComponent(jbJava)
                                .addComponent(jlJavaArq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3).addComponent(jlGoogleSistema).addComponent(jbGoogle)
                                .addComponent(jlGoogleArq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4).addComponent(jlFirefoxSistema).addComponent(jbFirefox)
                                .addComponent(jlFirefoxArq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5).addComponent(jlPdfSistema).addComponent(jbPdf)
                                .addComponent(jlPdfArq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8).addComponent(jlMensagem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jlServer).addComponent(jbServer))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jlFront).addComponent(jbFront)))
                                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jlInsert)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jlTruncate))
                                        .addComponent(jcTruncate)
                                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(jcInsert)
                                                .addGap(27, 27, 27)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbSql)))
                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }

    private void jbJavaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String command = caminho + "/balena.AppImage";
            Runtime run = Runtime.getRuntime();
            @SuppressWarnings("unused")
            Process proc = run.exec(command);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "O arquivo não foi encontrado", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setarInfoSistema() {
        jlFirefoxSistema.setText(info.getNomeSistema());
        jlGoogleSistema.setText(info.getNomeSistema());
        jlJavaSistema.setText(info.getNomeSistema());
        jlPdfSistema.setText(info.getNomeSistema());

        jlFirefoxArq.setText(info.getArquiteturaSistema());
        jlGoogleArq.setText(info.getArquiteturaSistema());
        jlJavaArq.setText(info.getArquiteturaSistema());
        jlPdfArq.setText(info.getArquiteturaSistema());
    }

    private void habilitarSql() {
        if (SessaoUsuarioModel.tipoUsuario.equals("ADMINISTRADOR")) {
            jlMensagem.setText("FUNÇÕES AVANÇADAS PARA O SQL!");
            jlMensagem.setForeground(Color.green);
            jbFront.setEnabled(true);
            jbServer.setEnabled(true);
            jbSql.setEnabled(true);
            jlTruncate.setEnabled(true);
            jlInsert.setEnabled(true);
            jlServer.setEnabled(true);
            jlFront.setEnabled(true);
        } else {
            jlMensagem.setText("APENAS DISPONÍVEIS PARA USUÁRIOS ADMINISTRADORES!");
            jlMensagem.setForeground(Color.red);
            jbFront.setEnabled(false);
            jbServer.setEnabled(false);
            jbSql.setEnabled(false);
            jlTruncate.setEnabled(false);
            jlInsert.setEnabled(false);
            jlServer.setEnabled(false);
            jlFront.setEnabled(false);
        }
    }
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbFirefox;
    private javax.swing.JButton jbFront;
    private javax.swing.JButton jbGoogle;
    private javax.swing.JButton jbJava;
    private javax.swing.JButton jbPdf;
    private javax.swing.JButton jbServer;
    private javax.swing.JButton jbSql;
    private javax.swing.JCheckBox jcInsert;
    private javax.swing.JCheckBox jcTruncate;
    private javax.swing.JLabel jlFirefoxArq;
    private javax.swing.JLabel jlFirefoxSistema;
    private javax.swing.JLabel jlFront;
    private javax.swing.JLabel jlGoogleArq;
    private javax.swing.JLabel jlGoogleSistema;
    private javax.swing.JLabel jlInsert;
    private javax.swing.JLabel jlJavaArq;
    private javax.swing.JLabel jlJavaSistema;
    private javax.swing.JLabel jlMensagem;
    private javax.swing.JLabel jlPdfArq;
    private javax.swing.JLabel jlPdfSistema;
    private javax.swing.JLabel jlServer;
    private javax.swing.JLabel jlTruncate;
}
