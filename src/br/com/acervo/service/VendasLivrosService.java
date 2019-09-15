package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.VendasLivroModel;
import br.com.acervo.model.dao.VendasLivrosDao;

/**
 *
 * @author joseluiz
 */
public class VendasLivrosService {

	VendasLivrosDao vendasLivrosDao = new VendasLivrosDao();
	VendasLivroModel vendasLivroModel = new VendasLivroModel();

	public boolean salvarVendasLivrosDAO(ArrayList<VendasLivroModel> plistaModelLivros) {
		return vendasLivrosDao.salvarVendasLivrosDAO(plistaModelLivros);
	}

	public boolean excluirVendasLivrosDAO(int pIdVendaLivro) {
		return vendasLivrosDao.excluirVendasLivrosDAO(pIdVendaLivro);
	}

	public boolean atualizarVendasLivrosDAO(VendasLivroModel pModelVendasLivros) {
		return vendasLivrosDao.atualizarVendasLivrosDAO(pModelVendasLivros);
	}

	public ArrayList<VendasLivroModel> getListaVendasLivrosDAO() {
		return vendasLivrosDao.getListaVendasLivrosDAO();
	}

	public VendasLivroModel getVendasLivrosDAO(int pIdVendaLivro) {
		return vendasLivrosDao.getVendasLivrosDAO(pIdVendaLivro);
	}

	public int salvarVendasLivrosDAO(VendasLivroModel pModelVendasLivros) {
		return vendasLivrosDao.salvarVendasLivrosDAO(pModelVendasLivros);
	}
}
