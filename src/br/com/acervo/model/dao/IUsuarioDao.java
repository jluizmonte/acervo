package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.UsuarioModel;

/**
 *
 * @author jluiz
 */
public interface IUsuarioDao {

	public int salvarUsuarioDAO(UsuarioModel pUsuarioModel);

	public UsuarioModel getUsuarioDAO(int pIdUsuario);

	public UsuarioModel getUsuarioDAO(String pLogin);

	public ArrayList<UsuarioModel> getListaUsuarioDAO();

	public boolean atualizarUsuarioDAO(UsuarioModel pUsuarioModel);

	public boolean excluirUsuarioDAO(int pIdUsuario);

	public boolean getValidarUsuarioDAO(UsuarioModel pUsuarioModel);

	public UsuarioModel getQuantidadeUsuariosCadastrados();
}
