package br.com.acervo.model;

import java.util.ArrayList;

/**
 *
 * @author Jose Luiz
 */
public class LivrosVendasLivrosModel {

	private LivroModel livroModel;
	private VendasLivroModel modelVendasLivros;
	private ArrayList<LivrosVendasLivrosModel> listaLivroVendaLivroModel = new ArrayList<>();

	public LivroModel getLivroModel() {
		return livroModel;
	}

	public void setLivroModel(LivroModel livroModel) {
		this.livroModel = livroModel;
	}

	public VendasLivroModel getModelVendasLivros() {
		return modelVendasLivros;
	}

	public void setModelVendasLivros(VendasLivroModel modelVendasLivros) {
		this.modelVendasLivros = modelVendasLivros;
	}

	public ArrayList<LivrosVendasLivrosModel> getListaLivroVendaLivroModel() {
		return listaLivroVendaLivroModel;
	}

	public void setListaLivroVendaLivroModel(ArrayList<LivrosVendasLivrosModel> listaLivroVendaLivroModel) {
		this.listaLivroVendaLivroModel = listaLivroVendaLivroModel;
	}

}
