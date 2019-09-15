package br.com.acervo.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.acervo.model.LogModel;
import br.com.acervo.service.TemaService;
import br.com.acervo.util.LogCat;

/**
 *
 * @author joseluiz
 */
@SuppressWarnings("serial")
public class LogCatView extends javax.swing.JInternalFrame {
	LogCat logCat = new LogCat();
	TemaService temaService = new TemaService();

	/**
	 * Creates new form LogCatView
	 * 
	 * @throws FileNotFoundException
	 */
	public LogCatView() throws FileNotFoundException {
		initComponents();
		listLogs();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jcbLogs = new javax.swing.JComboBox<>();
		jbVisualizarLog = new rojerusan.RSButtonRound();
		jbSair = new rojerusan.RSButtonRound();
		jScrollPane2 = new javax.swing.JScrollPane();
		jtaVisualizadorLog = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Visualizador de Logs");

		jPanel1.setBackground(new java.awt.Color(235, 235, 235));

		jPanel2.setBackground(new java.awt.Color(0, 47, 79));
		jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("Há arquivos de logs disponíveis:");
		jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 28));

		jcbLogs.setFont(new java.awt.Font("DejaVu Sans", 0, 16)); // NOI18N
		jcbLogs.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		jPanel2.add(jcbLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 256, 28));

		jbVisualizarLog.setText("VISUALIZAR LOG");
		jbVisualizarLog.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbVisualizarLogActionPerformed(evt);
			}
		});
		jPanel2.add(jbVisualizarLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 160, 28));

		jbSair.setText("Fechar");
		jbSair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbSairActionPerformed(evt);
			}
		});
		jPanel2.add(jbSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 84, 27));

		jtaVisualizadorLog.setColumns(20);
		jtaVisualizadorLog.setFont(new java.awt.Font("Comfortaa", 0, 18)); // NOI18N
		jtaVisualizadorLog.setLineWrap(true);
		jtaVisualizadorLog.setRows(5);
		jtaVisualizadorLog.setText("NENHUM LOG ABERTO");
		jScrollPane2.setViewportView(jtaVisualizadorLog);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
								.addComponent(jScrollPane2))
						.addGap(0, 0, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}

	private void jbVisualizarLogActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			readLogs();
		} catch (IOException ex) {
			Logger.getLogger(LogCatView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}

	public void listLogs() {

		jcbLogs.removeAllItems();

		File folder = new File(LogModel.userSystemDirectory);
		File[] listOfFiles = folder.listFiles();

		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				jcbLogs.addItem(listOfFile.getName());
			}
		}
		if (jcbLogs.getItemCount() == 0) {
			String status = "Não há arquivos de Log";
			jcbLogs.addItem(status);
		}

	}

	public void readLogs() throws IOException {

		String fileName = LogModel.userDirectory + jcbLogs.getSelectedItem();
		FileReader logCat = new FileReader(fileName);
		String one, two = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(logCat);

			while ((one = bufferedReader.readLine()) != null) {
				two = two + one + "\n";
			}
			jtaVisualizadorLog.setText(two);
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + logCat + "'");
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(ex));
		}

	}

	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane2;
	private rojerusan.RSButtonRound jbSair;
	private rojerusan.RSButtonRound jbVisualizarLog;
	private javax.swing.JComboBox<String> jcbLogs;
	private javax.swing.JTextArea jtaVisualizadorLog;
}
