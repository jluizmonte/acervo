package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.VendasClientesModel;
import br.com.acervo.model.dao.VendasClientesDao;

/**
 *
 * @author joseluiz
 */
public class VendasClientesService {

	VendasClientesDao vendasClientesDao = new VendasClientesDao();

	public ArrayList<VendasClientesModel> getListaVendasClienteDAO() {
		return vendasClientesDao.getListaVendasClienteDAO();
	}

}
