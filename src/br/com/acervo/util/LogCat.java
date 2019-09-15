package br.com.acervo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import br.com.acervo.model.LogModel;
import br.com.acervo.model.SessaoUsuarioModel;

public class LogCat {
	File logCat;

	public void createFolder() {
		File diretorio = new File(LogModel.userSystemDirectory);
		if (!diretorio.exists()) {
			try {
				diretorio.mkdirs();
			} catch (Exception e) {
				e.printStackTrace();
				LogModel.logClass = this.getClass().getName();
				new LogCat().writeFile(String.valueOf(e));
			}
		}
	}

	public void createFile() {

		logCat = new File(LogModel.userSystemFile);

		try {
			logCat.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
			LogModel.logClass = this.getClass().getName();
			new LogCat().writeFile(String.valueOf(e));
		}

	}

	public void writeFile(String log) {
		logCat = new File(LogModel.userSystemFile);
		try {
			if ((log == "") || (log == null)) {
				log = "Sem mais registros!";
				LogModel.logClass = getClass().toString();
			}

			if (SessaoUsuarioModel.nomeUsuario == null) {
				SessaoUsuarioModel.nomeUsuario = "Usuário não logado";
			}
			FileWriter fileWriter = new FileWriter(logCat, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("---------------------------------------------");
			bufferedWriter.newLine();
			bufferedWriter.write("usuário: " + SessaoUsuarioModel.nomeUsuario);
			bufferedWriter.newLine();
			bufferedWriter.write("Classe geradora do log: " + LogModel.logClass);
			bufferedWriter.newLine();
			bufferedWriter.write(new LogModel().logDateNow + ": " + log + "\n");
			bufferedWriter.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					"Erro ao criar arquivo de LOG\n" + " Informe ao desenvolvedor o ocorrido", "Erro Critico",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	public void firstWriteFile() {
		logCat = new File(LogModel.userSystemFile);
		try {
			FileWriter fileWriter = new FileWriter(logCat);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Log sistema acervo");
			bufferedWriter.newLine();
			bufferedWriter.write("Instituição: " + LogModel.logLibrary);
			bufferedWriter.newLine();
			bufferedWriter.write("Data criação arquivo de log: " + new LogModel().logDateNow);
			bufferedWriter.newLine();
			bufferedWriter.write("Sistema operacional: " + new ObterInfoSistema().getNomeSistema());
			bufferedWriter.newLine();
			bufferedWriter.write("Licenciado para: " + new ObterInfoSistema().getNomeUsuario());
			bufferedWriter.newLine();
			bufferedWriter.write("<<<<< LOGCAT >>>>>\n");
			bufferedWriter.write("\n");
			bufferedWriter.write(new LogModel().logDateNow + ": " + "sistema instalado com sucesso!\n");
			bufferedWriter.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					"Erro ao criar arquivo de LOG\n" + " Informe ao desenvolvedor o ocorrido", "Erro Critico",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	public void createWriteChangeLog() {

		logCat = new File(LogModel.userChangeLog);

		try {
			logCat.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileWriter fileWriter = new FileWriter(logCat);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write("<<Registro de alterações: Sistema ACERVO>>\n"
					+ "<<        versão atual 1.3           >>\n" + "\n" + "<>PRELÚDIO:\n"
					+ "ACERVO, sistema de controle para bibliotecas e afins\n" + "Desenvolvido por José Luiz.\n"
					+ "Distribuído sob a licença openSource sendo permitida a instalação e utilização em qualquer dispositivo suportado\n"
					+ "ficando vetado o uso em ambiente comercial.\n" + "\n" + "<>SOBRE:\n"
					+ "O sistema de gerenciamento denominado ACERVO, foi desenvolvido especialmente para solucionar problemas relacionados a gestão de livros, revistas e afins. Desenvolvido para ser útil e de fácil utilização em bibliotecas ou acervos particulares.\n"
					+ "Contando com uma gama de funções essenciais, o sistema abrange desde a entrada do livro,sua saída (por meio de empréstimos) até vendas e cadastros de clientes, locatários e locadores tudo isso facilitando o uso e dinamizando o gerenciamento.\n"
					+ "O sistema conta com acesso restrito, contando com um login ‘geral’ para acesso do sistema e bloqueio de funções por nível de usuário;\n"
					+ "\n" + "<>FUNÇÕES DISPONÍVEIS:\n" + "\n" + "> CADASTRO:\n" + "	- Livros;\n"
					+ "	- Usuários;\n" + "	- Locadores;\n" + "	- Locatários;\n" + "	- Clientes;\n"
					+ "	- Empréstimos;\n" + "	- Vendas;\n" + "\n" + "> FUNÇÕES EXTRAS:\n"
					+ "	- Visualização de Log de erros do sistema (apenas para o administrador);\n"
					+ "	- Visualização das mudanças do sistema;\n"
					+ "	- Visualização de itens cadastrados no sistema (livros, clientes, etc.);\n" + "\n"
					+ "<>REQUISITOS:\n"
					+ "Este sistema, foi desenvolvido com algumas especificações de configurações de equipamento,caso seu equipamento não possua o mínimo da configuração desejada o desempenho do sistema como também seu design e recursos podem ficar comprometidos.\n"
					+ "\n" + ">REQUISITOS MÍNIMOS:\n" + "*Processador: 1GHz\n" + "*Memória RAM: 1GB\n"
					+ "*Armazenamento interno: 1GB\n" + "*Resolução monitor: 1024 x 768\n"
					+ "*Sistema operacional: Qualquer um que suporte JAVA\n" + "\n" + ">OUTROS REQUISITOS:\n"
					+ "- JAVA 8 (JRE ou JDK) ou OPENJRE/JDK 8\n" + "- MySQL Server 5.5\n"
					+ "- Navegador atualizado (Firefox, Google Chrome ou Opera)\n" + "\n" + "<>MUDANÇAS DO SISTEMA\n"
					+ "\n" + ">Build 1.0 maio/2019\n" + "\n"
					+ "Adição de janelas para o cadastro de outras entidades:\n" + "*Cliente;\n"
					+ "*Locador e Locatário;\n" + "*Vendas (não finalizada totalmente);\n"
					+ "*Empréstimo (não finalizada totalmente);\n" + "*Melhorias internas;\n" + "\n"
					+ ">Build 1.1 maio/2019\n" + "\n" + "*Finalização das janelas:\n" + "#Empréstimo;\n" + "#Vendas;\n"
					+ "\n" + "*Adição completa de janelas extras:\n" + "#Usuário;\n" + "#Levantamento;\n" + "\n"
					+ "*Padronização geral de cores e fontes, como também tamanho das janelas;\n"
					+ "*Finalização de interface para levantamento de clientes, livros, locadores e locatários;\n"
					+ "*melhorias internas;\n" + "\n" + ">Build 1.2 junho/2019\n"
					+ "*Organização do menu de atalhos e tamanho e tipo de fonte da barra inferior;\n"
					+ "*Inserção de temas;\n"
					+ "*Correção do nome do botão salvar nas telas de cadastro de livros, clientes, *Locatários e locadores;\n"
					+ "*Botão alterar desabilitado;\n" + "*Melhorias internas;\n"
					+ "*Modificação na janela Sobre o sistema;\n" + "\n" + ">Build 1.3 julho/2019\n"
					+ "*Adição de novo tema(Temas>>2019>>Plain);\n"
					+ "*Melhoria interna relacionada a aplicação de temas;\n"
					+ "*Versão de teste do sistema criada (com o banco SqLite);\n"
					+ "*Criação de arquivos de registros (Logs);\n"
					+ "*Inserção de nome para instituição (ou da livraria apenas);\n"
					+ "*Melhorias internas relacionadas a criação de diretórios;\n"
					+ "*Criação de visualizador do registro de versões;\n"
					+ "*Correção de erro botão alterar desabilitado após alterar um livro;\n"
					+ "*Correção de erro botão alterar desabilitado após alterar um cliente;\n"
					+ "*Alteração de hora estática para dinâmica no menu principal;\n"
					+ "*Correção ao gerar relatórios seguidos;\n" + "\n" + "\n" + "");
			bufferedWriter.close();
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					"Erro ao criar arquivo de LOG\n" + " Informe ao desenvolvedor o ocorrido", "Erro Critico",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	public void readNameLogs() {
		File folder = new File(LogModel.userSystemDirectory);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
				LogModel.logLibrary += listOfFiles[i].getName();
			}
		}
	}
}
