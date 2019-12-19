package br.com.acervo.util;

import java.io.File;
import java.io.IOException;

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
