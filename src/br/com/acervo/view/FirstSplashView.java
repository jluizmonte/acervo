package br.com.acervo.view;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class FirstSplashView extends javax.swing.JFrame {

    public FirstSplashView() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loadingbar = new javax.swing.JProgressBar();
        loadingnum = new javax.swing.JLabel();
        process = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        URL caminhoImagem = this.getClass().getResource("/br/com/acervo/images/icon/book.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);

        jPanel1.setBackground(new java.awt.Color(0, 112, 192));

        loadingnum.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        loadingnum.setForeground(new java.awt.Color(255, 255, 255));
        loadingnum.setText("90%");

        process.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        process.setForeground(new java.awt.Color(255, 255, 255));
        process.setText("Iniciando o sistema com as novas configurações");

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("A primeira execução pode demorar alguns segundos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout
                .setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(loadingbar, javax.swing.GroupLayout.PREFERRED_SIZE, 433,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(loadingnum))
                                        .addComponent(process)))
                                .addContainerGap(32, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(loadingnum, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup().addComponent(process)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(loadingbar, javax.swing.GroupLayout.PREFERRED_SIZE, 20,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JProgressBar loadingbar;
    public javax.swing.JLabel loadingnum;
    public javax.swing.JLabel process;
}
