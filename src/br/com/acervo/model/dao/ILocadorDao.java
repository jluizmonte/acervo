package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.LocadorModel;

/**
 *
 * @author joseluiz
 */
public interface ILocadorDao {

	public int salvarLocadorDAO(LocadorModel pLocadorModel);

	public LocadorModel getLocadorDAO(int pIdLocador); // recupera locador pela pk

	public LocadorModel getLocadorDAO(String pLocadorModel); // recupera locador pelo titulo

	public ArrayList<LocadorModel> getListaLocadorDAO();

	public boolean atualizarLocadorDAO(LocadorModel pLocadorModel);

	public boolean excluirLocadorDAO(int idLocadorModel);

}
