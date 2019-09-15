package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.LivrosEmprestimosLivrosModel;
import br.com.acervo.model.dao.LivrosEmprestimosLivrosDao;

/**
 *
 * @author joseluiz
 */
public class LivrosEmprestimosLivrosService {

	LivrosEmprestimosLivrosDao livrosEmprestimosLivrosDao = new LivrosEmprestimosLivrosDao();

	public ArrayList<LivrosEmprestimosLivrosModel> getListaLivrosVendasLivrosDAO(int pCodigoEmprestimo) {
		return livrosEmprestimosLivrosDao.getListaLivrosEmprestimoLivrosDAO(pCodigoEmprestimo);
	}
}
