package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.LivrosVendasLivrosModel;

/**
 *
 * @author joseluiz
 */
public interface ILivrosVendasLivrosDao {

	public ArrayList<LivrosVendasLivrosModel> getListaLivrosVendasLivrosDAO(int pCodigoVenda);
}
