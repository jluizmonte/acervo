package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.UsuarioModel;
import br.com.acervo.model.dao.UsuarioDao;

/**
 *
 * @author jluiz
 */
public class UsuarioService {

    UsuarioDao usuarioDao = new UsuarioDao();

    public int salvarUsuarioDAO(UsuarioModel pModelUsuario) {
        return usuarioDao.salvarUsuarioDAO(pModelUsuario);
    }

    public UsuarioModel getUsuarioDAO(int pIdUsuario) {
        return usuarioDao.getUsuarioDAO(pIdUsuario);
    }

    public UsuarioModel getUsuarioDAO(String pLogin) {
        return usuarioDao.getUsuarioDAO(pLogin);
    }

    public ArrayList<UsuarioModel> getListaUsuarioDAO() {
        return usuarioDao.getListaUsuarioDAO();
    }

    public boolean atualizarUsuarioDAO(UsuarioModel pModelUsuario) {
        return usuarioDao.atualizarUsuarioDAO(pModelUsuario);
    }

    public boolean excluirUsuarioDAO(int pIdUsuario) {
        return usuarioDao.excluirUsuarioDAO(pIdUsuario);
    }

    public boolean getValidarUsuarioDAO(UsuarioModel pModelUsuario) {
        return usuarioDao.getValidarUsuarioDAO(pModelUsuario);
    }

    public UsuarioModel getQuantidadeUsuariosCadastrados() {
        return usuarioDao.getQuantidadeUsuariosCadastrados();
    }
}
