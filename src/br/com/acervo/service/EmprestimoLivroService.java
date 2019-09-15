package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.EmprestimoLivroModel;
import br.com.acervo.model.dao.EmprestimoLivrosDao;

/**
 *
 * @author joseluiz
 */
public class EmprestimoLivroService {

	EmprestimoLivrosDao emprestimoLivrosDao = new EmprestimoLivrosDao();
	EmprestimoLivroModel emprestimoLivroModel = new EmprestimoLivroModel();

	public boolean salvarEmprestimosLivrosDAO(ArrayList<EmprestimoLivroModel> plistaModelLivros) {
		return emprestimoLivrosDao.salvarEmprestimosLivrosDAO(plistaModelLivros);
	}

	public boolean excluirEmprestimosLivrosDAO(int pIdEmprestimoLivro) {
		return emprestimoLivrosDao.excluirEmprestimosLivrosDAO(pIdEmprestimoLivro);
	}

	public boolean atualizarEmprestimosLivrosDAO(EmprestimoLivroModel pModelEmprestimosLivros) {
		return emprestimoLivrosDao.atualizarEmprestimosLivrosDAO(pModelEmprestimosLivros);
	}

	public ArrayList<EmprestimoLivroModel> getListaEmprestimosLivrosDAO() {
		return emprestimoLivrosDao.getListaEmprestimosLivrosDAO();
	}

	public EmprestimoLivroModel getEmprestimosLivrosDAO(int pIdEmprestimoLivro) {
		return emprestimoLivrosDao.getEmprestimosLivrosDAO(pIdEmprestimoLivro);
	}

	public int salvarEmprestimosLivrosDAO(EmprestimoLivroModel pModelEmprestimosLivros) {
		return emprestimoLivrosDao.salvarEmprestimosLivrosDAO(pModelEmprestimosLivros);
	}
}
