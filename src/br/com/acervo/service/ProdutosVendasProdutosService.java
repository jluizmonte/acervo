package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.LivrosVendasLivrosModel;
import br.com.acervo.model.dao.LivrosVendasLivrosDao;

/**
 *
 * @author joseluiz
 */
public class ProdutosVendasProdutosService {

	LivrosVendasLivrosDao livrosVendasLivrosDao = new LivrosVendasLivrosDao();

	public ArrayList<LivrosVendasLivrosModel> getListaLivrosVendasLivrosDAO(int pCodigoVenda) {
		return livrosVendasLivrosDao.getListaLivrosVendasLivrosDAO(pCodigoVenda);
	}

}
