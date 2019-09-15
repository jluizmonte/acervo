package br.com.acervo.service;

import br.com.acervo.model.TemaModel;
import br.com.acervo.model.dao.TemaDao;

public class TemaService {

	TemaDao temaDao = new TemaDao();

	public boolean atualizarTemaDAO(TemaModel pTemaModel) {
		return temaDao.atualizarTemaDAO(pTemaModel);
	}

	public TemaModel getTemaDAO() {
		return temaDao.getTemaDAO();
	}

	public TemaModel getNomeBiblioteca() {
		return temaDao.getNomeBiblioteca();
	}
}
