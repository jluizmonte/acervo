package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.VendasLivroModel;

/**
 *
 * @author joseluiz
 */
public interface IVendasLivrosDao {

	public boolean salvarVendasLivrosDAO(ArrayList<VendasLivroModel> plistaModelVendasLivros);

	public boolean excluirVendasLivrosDAO(int pIdVendaLivro);

	public boolean atualizarVendasLivrosDAO(VendasLivroModel pModelVendasLivros);

	public ArrayList<VendasLivroModel> getListaVendasLivrosDAO();

	public VendasLivroModel getVendasLivrosDAO(int pIdVendaLivro);

	public int salvarVendasLivrosDAO(VendasLivroModel pModelVendasLivros);

}
