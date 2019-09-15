package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.LocatarioModel;
import br.com.acervo.model.dao.LocatarioDao;

/**
 *
 * @author joseluiz
 */
public class LocatarioService {

	LocatarioDao locatarioDao = new LocatarioDao();

	public int salvarLivroDAO(LocatarioModel pLocatarioModel) {
		return locatarioDao.salvarLocatarioDAO(pLocatarioModel);
	}

	public LocatarioModel getLocatarioDAO(int pIdLocatario) {
		return locatarioDao.getLocatarioDAO(pIdLocatario);
	}

	public LocatarioModel getLocatarioDAO(String pLocatarioModel) {
		return locatarioDao.getLocatarioDAO(pLocatarioModel);
	}

	public ArrayList<LocatarioModel> getListaLocatarioDAO() {
		return locatarioDao.getListaLocatarioDAO();
	}

	public boolean atualizarLocatarioDAO(LocatarioModel pLocatarioModel) {
		return locatarioDao.atualizarLocatarioDAO(pLocatarioModel);
	}

	public boolean excluirLocatarioDAO(int idLocatarioModel) {
		return locatarioDao.excluirLocatarioDAO(idLocatarioModel);
	}
}
