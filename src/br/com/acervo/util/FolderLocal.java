package br.com.acervo.util;

import br.com.acervo.model.LogModel;

public class FolderLocal {
	public static String diretorioPadrao = System.getProperty("user.home");
	private final String nomeSistema = System.getProperty("os.name");
	public static String userDirectory;
	String logCat;
	String changeLog;

	/**
	 * retorna o nome da pasta adiciona da barra necessária utilizada somente para
	 * visualizar os logs
	 * 
	 * @return
	 */
	public String userDirectory() {
		if (nomeSistema.equals("Linux")) {
			userDirectory = diretorioPadrao + "/.acervo/logs/";
		} else {
			userDirectory = diretorioPadrao + "\\acervo\\logs\\";
		}
		return userDirectory;
	}

	/**
	 * cria a pasta de LOGS vazia
	 * 
	 * @return
	 */
	public String userSystemDirectory() {
		if (nomeSistema.equals("Linux")) {
			userDirectory = diretorioPadrao + "/.acervo/logs";
		} else {
			userDirectory = diretorioPadrao + "\\acervo\\logs";
		}
		return userDirectory;
	}

	/**
	 * cria os arquivos de LOGS
	 * 
	 * @return
	 */
	public String userSystemFile() {
		if (nomeSistema.equals("Linux")) {
			userDirectory = diretorioPadrao + "/.acervo/logs/";
			logCat = userDirectory + LogModel.logLibrary + ".log";
		} else {
			userDirectory = diretorioPadrao + "\\acervo\\logs\\";
			String uri = userDirectory + LogModel.logLibrary + ".log";
			logCat = uri;
		}
		return logCat;
	}

	public String userChangeLog() {
		if (nomeSistema.equals("Linux")) {
			userDirectory = diretorioPadrao + "/.acervo/logs/";
			changeLog = userDirectory + "changelog.txt";
		} else {
			userDirectory = diretorioPadrao + "\\acervo\\logs\\";
			changeLog = userDirectory + "changelog.txt";
		}
		return changeLog;
	}
}
