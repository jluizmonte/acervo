package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.LivrosEmprestimosLivrosModel;

/**
 *
 * @author joseluiz
 */
public interface ILivrosEmprestimosLivrosDao {

	public ArrayList<LivrosEmprestimosLivrosModel> getListaLivrosEmprestimoLivrosDAO(int pCodigoEmprestimo);

}
