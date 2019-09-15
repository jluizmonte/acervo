package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.LocatarioModel;

/**
 *
 * @author joseluiz
 */
public interface ILocatarioDao {

	public int salvarLocatarioDAO(LocatarioModel pLocatarioModel);

	public LocatarioModel getLocatarioDAO(int pIdLocatario); // recupera locatario pela pk

	public LocatarioModel getLocatarioDAO(String pLocatarioModel); // recupera locatario pelo titulo

	public ArrayList<LocatarioModel> getListaLocatarioDAO();

	public boolean atualizarLocatarioDAO(LocatarioModel pLocatarioModel);

	public boolean excluirLocatarioDAO(int idLocatarioModel);

}
