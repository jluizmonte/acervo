package br.com.acervo.model;

import java.util.ArrayList;

/**
 *
 * @author joseluiz
 */
public class LivrosEmprestimosLivrosModel {

	private LivroModel livroModel;
	private EmprestimoLivroModel emprestimoLivroModel;
	private ArrayList<LivrosEmprestimosLivrosModel> listaLivroEmprestimoLivroModel = new ArrayList<>();

	public LivroModel getLivroModel() {
		return livroModel;
	}

	public void setLivroModel(LivroModel livroModel) {
		this.livroModel = livroModel;
	}

	public EmprestimoLivroModel getEmprestimoLivroModel() {
		return emprestimoLivroModel;
	}

	public void setEmprestimoLivroModel(EmprestimoLivroModel emprestimoLivroModel) {
		this.emprestimoLivroModel = emprestimoLivroModel;
	}

	public ArrayList<LivrosEmprestimosLivrosModel> getListaLivroEmprestimoLivroModel() {
		return listaLivroEmprestimoLivroModel;
	}

	public void setListaLivroEmprestimoLivroModel(
			ArrayList<LivrosEmprestimosLivrosModel> listaLivroEmprestimoLivroModel) {
		this.listaLivroEmprestimoLivroModel = listaLivroEmprestimoLivroModel;
	}

	@Override
	public String toString() {
		return "LivrosEmprestimosLivrosModel{" + "livroModel=" + livroModel + ", emprestimoLivroModel="
				+ emprestimoLivroModel + ", listaLivroEmprestimoLivroModel=" + listaLivroEmprestimoLivroModel + '}';
	}

}
