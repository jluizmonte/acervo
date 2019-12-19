package br.com.acervo.view;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class SplashView extends javax.swing.JFrame {

    /**
     * Creates new form SplashView
     */
    public SplashView() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        jLabel1 = new javax.swing.JLabel();
        rSProgressCircleAnimated1 = new rojerusan.RSProgressCircleAnimated();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 112, 192));

        rSPanelImage1
                .setImagen(new javax.swing.ImageIcon(getClass().getResource("/br/com/acervo/images/book/livro2.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comfortaa", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SISTEMA ACERVO");

        rSProgressCircleAnimated1.setForeground(new java.awt.Color(255, 255, 255));
        rSProgressCircleAnimated1.setString("");
        rSProgressCircleAnimated1.setVelocidad(15);

        jLabel2.setFont(new java.awt.Font("Comfortaa", 0, 11)); // NOI18N
        jLabel2.setText("v 1.3 final");

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(rSPanelImage1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rSPanelImage1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(
                        rSProgressCircleAnimated1, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                        javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelImage1Layout.createSequentialGroup()
                        .addContainerGap(513, Short.MAX_VALUE)
                        .addGroup(rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap()));
        rSPanelImage1Layout.setVerticalGroup(rSPanelImage1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelImage1Layout.createSequentialGroup()
                        .addComponent(rSProgressCircleAnimated1, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                        .addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel1Layout.createSequentialGroup().addGap(0, 0, 0).addComponent(rSPanelImage1,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(rSPanelImage1, javax.swing.GroupLayout.Alignment.TRAILING,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSPanelImage rSPanelImage1;
    private rojerusan.RSProgressCircleAnimated rSProgressCircleAnimated1;
}
