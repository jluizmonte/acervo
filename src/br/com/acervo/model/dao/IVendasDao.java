package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.VendasModel;

/**
 *
 * @author joseluiz
 */
public interface IVendasDao {

	public int salvarVendasDAO(VendasModel pVendasModel);

	public VendasModel getVendasDAO(int pIdVendas);

	public ArrayList<VendasModel> getListaVendasDAO();

	public boolean atualizarVendasDAO(VendasModel pVendasModel);

	public boolean excluirVendasDAO(int idVendasModel);

	public VendasModel getQuantidadeVendas();

	public VendasModel getValorTotal();

	public VendasModel getQuantidadeLivroVendas();
}
