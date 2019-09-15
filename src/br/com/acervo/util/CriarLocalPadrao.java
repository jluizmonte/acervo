package br.com.acervo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Jose Luiz
 */
public class CriarLocalPadrao {

    ObterInfoSistema info = new ObterInfoSistema();
    static String diretorioUsuario;
    static String diretorioPadrao = System.getProperty("user.home");

    /**
     * cria uma pasta com o nome acervo na pasta de usuário (Linux e Windows).
     *
     * @throws IOException
     */
    public void criarPastaPadrao() throws IOException {
        diretorioUsuario = diretorioPadrao + "/.acervo";
        File diretorio = new File(diretorioUsuario);
        diretorio.mkdir();
        if (!diretorio.exists()) {
            diretorio.createNewFile();
        }
    }
}
