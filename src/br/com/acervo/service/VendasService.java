package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.VendasModel;
import br.com.acervo.model.dao.VendasDao;

/**
 *
 * @author joseluiz
 */
public class VendasService {

	VendasDao vendasDao = new VendasDao();

	public int salvarVendasDAO(VendasModel pModelVendas) {
		return vendasDao.salvarVendasDAO(pModelVendas);
	}

	public VendasModel getVendasDAO(int pIdVenda) {
		return vendasDao.getVendasDAO(pIdVenda);
	}

	public ArrayList<VendasModel> getListaVendasDAO() {
		return vendasDao.getListaVendasDAO();
	}

	public boolean atualizarVendasDAO(VendasModel pModelVendas) {
		return vendasDao.atualizarVendasDAO(pModelVendas);
	}

	public boolean excluirVendasDAO(int pIdVenda) {
		return vendasDao.excluirVendasDAO(pIdVenda);
	}

	public VendasModel getQuantidadeVendas() {
		return vendasDao.getQuantidadeVendas();
	}

	public VendasModel getValorTotal() {
		return vendasDao.getValorTotal();
	}

	public VendasModel getQuantidadeLivroVendas() {
		return vendasDao.getQuantidadeLivroVendas();
	}
}
