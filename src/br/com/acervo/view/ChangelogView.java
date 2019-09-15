package br.com.acervo.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import br.com.acervo.model.LogModel;
import br.com.acervo.util.LogCat;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class ChangelogView extends javax.swing.JInternalFrame {

	/**
	 * Creates new form LogView
	 * 
	 * @throws FileNotFoundException
	 */
	public ChangelogView() throws FileNotFoundException {
		initComponents();
		loadChangelog();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jtaVisualizadorChangeLog = new javax.swing.JTextArea();
		jbFechar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("ChangeLog");
		jtaVisualizadorChangeLog.setEditable(false);
		jPanel1.setBackground(new java.awt.Color(0, 112, 192));

		jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("Lista de alterações do sistema acervo:");

		jtaVisualizadorChangeLog.setColumns(20);
		jtaVisualizadorChangeLog.setFont(new java.awt.Font("Comfortaa", 0, 16)); // NOI18N
		jtaVisualizadorChangeLog.setLineWrap(true);
		jtaVisualizadorChangeLog.setRows(5);
		jtaVisualizadorChangeLog.setWrapStyleWord(true);
		jScrollPane1.setViewportView(jtaVisualizadorChangeLog);

		jbFechar.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
		jbFechar.setText("Fechar");
		jbFechar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbFecharActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(31, 31, 31).addComponent(jLabel1)
						.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1))
						.addGroup(jPanel1Layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jbFechar)))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jbFechar)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		pack();
	}

	private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	private void loadChangelog() throws FileNotFoundException {
		String fileName = LogModel.userChangeLog;
		FileReader logCat = new FileReader(fileName);
		String one, two = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(logCat);

			while ((one = bufferedReader.readLine()) != null) {
				two = two + one + "\n";
			}
			jtaVisualizadorChangeLog.setText(two);
			bufferedReader.close();
		} catch (IOException ex) {
			System.out.println("Unable to open file '" + logCat + "'");
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(ex));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		new ChangelogView().setVisible(true);
	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jtaVisualizadorChangeLog;
	private javax.swing.JButton jbFechar;

}
