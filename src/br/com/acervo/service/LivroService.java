package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.LivroModel;
import br.com.acervo.model.dao.LivroDao;

/**
 *
 * @author joseluiz
 */
public class LivroService {

	LivroDao livroDao = new LivroDao();

	public int salvarLivroDAO(LivroModel pLivroModel) {
		return livroDao.salvarLivroDAO(pLivroModel);
	}

	public LivroModel getLivroDAO(int pLivro) // recupera livro pela pk
	{
		return livroDao.getLivroDAO(pLivro);
	}

	public LivroModel getLivroDAO(String pLivroModel) // recupera livro pelo titulo
	{
		return livroDao.getLivroDAO(pLivroModel);
	}

	public ArrayList<LivroModel> getListaLivroDAO() {
		return livroDao.getListaLivroDAO();
	}

	public boolean atualizarLivroDAO(LivroModel pLivroModel) {
		return livroDao.atualizarLivroDAO(pLivroModel);
	}

	public boolean excluirLivroDAO(int idLivroModel) {
		return livroDao.excluirLivroDAO(idLivroModel);
	}

	public LivroModel getQuantidadeLivrosCadastrados() {
		return livroDao.getQuantidadeLivrosCadastrados();
	}

	public boolean alterarEstoqueLivroDAO(ArrayList<LivroModel> pListaLivroModel) {
		return livroDao.alterarEstoqueLivrosDAO(pListaLivroModel);
	}
}
