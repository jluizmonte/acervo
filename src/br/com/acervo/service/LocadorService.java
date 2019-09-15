package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.LocadorModel;
import br.com.acervo.model.dao.LocadorDao;

/**
 *
 * @author joseluiz
 */
public class LocadorService {

	LocadorDao locadorDao = new LocadorDao();

	public int salvarLivroDAO(LocadorModel pLocadorModel) {
		return locadorDao.salvarLocadorDAO(pLocadorModel);
	}

	public LocadorModel getLocadorDAO(int pLocador) {
		return locadorDao.getLocadorDAO(pLocador);
	}

	public LocadorModel getLocadorDAO(String pLocadorModel) {
		return locadorDao.getLocadorDAO(pLocadorModel);
	}

	public ArrayList<LocadorModel> getListaLocadorDAO() {
		return locadorDao.getListaLocadorDAO();
	}

	public boolean atualizarLocadorDAO(LocadorModel pLocadorModel) {
		return locadorDao.atualizarLocadorDAO(pLocadorModel);
	}

	public boolean excluirLocadorDAO(int idLocadorModel) {
		return locadorDao.excluirLocadorDAO(idLocadorModel);
	}

}
