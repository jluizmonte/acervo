package br.com.acervo.model;

import java.util.ArrayList;

/**
 *
 * @author joseluiz
 */
public class EmprestimoLocatarioModel {

	private EmprestimoModel emprestimoModel;
	private LocatarioModel locatarioModel;
	private LocadorModel locadorModel;
	private LivroModel livroModel;
	private ArrayList<EmprestimoLivroModel> listaEmprestimoLivroModel;

	public EmprestimoModel getEmprestimoModel() {
		return emprestimoModel;
	}

	public void setEmprestimoModel(EmprestimoModel emprestimoModel) {
		this.emprestimoModel = emprestimoModel;
	}

	public LocatarioModel getLocatarioModel() {
		return locatarioModel;
	}

	public void setLocatarioModel(LocatarioModel locatarioModel) {
		this.locatarioModel = locatarioModel;
	}

	public LocadorModel getLocadorModel() {
		return locadorModel;
	}

	public void setLocadorModel(LocadorModel locadorModel) {
		this.locadorModel = locadorModel;
	}

	public LivroModel getLivroModel() {
		return livroModel;
	}

	public void setLivroModel(LivroModel livroModel) {
		this.livroModel = livroModel;
	}

	public ArrayList<EmprestimoLivroModel> getListaEmprestimoLivroModel() {
		return listaEmprestimoLivroModel;
	}

	public void setListaEmprestimoLivroModel(ArrayList<EmprestimoLivroModel> listaEmprestimoLivroModel) {
		this.listaEmprestimoLivroModel = listaEmprestimoLivroModel;
	}

	@Override
	public String toString() {
		return "EmprestimoLocatarioModel{" + "emprestimoModel=" + emprestimoModel + ", locatarioModel=" + locatarioModel
				+ ", locadorModel=" + locadorModel + ", livroModel=" + livroModel + ", listaEmprestimoLivroModel="
				+ listaEmprestimoLivroModel + '}';
	}

}
