package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.LivroModel;

/**
 *
 * @author joseluiz
 */
public interface ILivroDao {

	public int salvarLivroDAO(LivroModel pLivroModel);

	public LivroModel getLivroDAO(int pIdLivro); // recupera livro pela pk

	public LivroModel getLivroDAO(String pLivroModel); // recupera livro pelo titulo

	public ArrayList<LivroModel> getListaLivroDAO();

	public boolean atualizarLivroDAO(LivroModel pLivroModel);

	public boolean excluirLivroDAO(int idLivroModel);

	public boolean alterarEstoqueLivrosDAO(ArrayList<LivroModel> pListaLivroModel);

	public LivroModel getQuantidadeLivrosCadastrados();

}
