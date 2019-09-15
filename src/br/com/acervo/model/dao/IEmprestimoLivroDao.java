package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.EmprestimoLivroModel;

/**
 *
 * @author joseluiz
 */
public interface IEmprestimoLivroDao {

	public boolean salvarEmprestimosLivrosDAO(ArrayList<EmprestimoLivroModel> plistaModelEmprestimosLivros);

	public boolean excluirEmprestimosLivrosDAO(int pIdEmprestimoLivro);

	public boolean atualizarEmprestimosLivrosDAO(EmprestimoLivroModel pModelEmprestimosLivros);

	public ArrayList<EmprestimoLivroModel> getListaEmprestimosLivrosDAO();

	public EmprestimoLivroModel getEmprestimosLivrosDAO(int pIdEmprestimoLivro);

	public int salvarEmprestimosLivrosDAO(EmprestimoLivroModel pModelEmprestimosLivros);
}
