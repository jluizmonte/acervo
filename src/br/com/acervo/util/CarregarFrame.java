package br.com.acervo.util;

import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.acervo.connection.AcervoConnectionSqLite;
import br.com.acervo.model.LogModel;
import br.com.acervo.view.FirstSplashView;

public class CarregarFrame {
	public void setFrameTime() throws ClassNotFoundException, IOException {
		String livraria = JOptionPane.showInputDialog(null,
				"Insira o nome da da instituição\n" + "Se for muito longo, insira apenas a sigla", "Insira um nome",
				JOptionPane.QUESTION_MESSAGE).toUpperCase();

		AcervoConnectionSqLite acervoConnectionSqLite = new AcervoConnectionSqLite();
		acervoConnectionSqLite.createNewTable(livraria);

		new LogCat().createFolder();
		new LogCat().createFile();
		new LogCat().firstWriteFile();
		new LogCat().createWriteChangeLog();

		FirstSplashView firstSplash = new FirstSplashView();
		firstSplash.setVisible(true);

		for (int i = 0; i <= 100; i++) {
			try {
				Thread.sleep(80);
			} catch (InterruptedException ex) {
				ex.getLocalizedMessage();
				LogModel.logClass = this.getClass().getName();
				new LogCat().writeFile(String.valueOf(ex));
			}
			firstSplash.loadingnum.setText(Integer.toString(i) + "%");
			firstSplash.loadingbar.setValue(i);
			firstSplash.loadingbar.setForeground(new java.awt.Color(127, 205, 205));
			switch (i) {
			case 10:
				firstSplash.process.setText("Criando diretórios");
				break;
			case 20:
				firstSplash.process.setText("Criando arquivos necessários");
				break;
			case 30:
				firstSplash.process.setText("Realizando configurações permanentes");
				break;
			case 50:
				firstSplash.process.setText("Arquivos e diretórios criados");
				break;
			case 70:
				firstSplash.process.setText("Aguarde a inicialização do sistema!");
				break;
			case 90:
				firstSplash.process.setText("Iniciando sistema com novas configurações!");
				break;
			}
			if (i == 100) {
				firstSplash.dispose();
			}
		}
	}
}
