package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.EmprestimoModel;
import br.com.acervo.model.dao.EmprestimoDao;

/**
 *
 * @author joseluiz
 */
public class EmprestimoService {

	EmprestimoDao emprestimoDao = new EmprestimoDao();

	public int salvarEmprestimoDAO(EmprestimoModel pEmprestimoModel) {
		return emprestimoDao.salvarEmprestimoDAO(pEmprestimoModel);
	}

	public boolean salvarEmprestimosDAO(ArrayList<EmprestimoModel> plistaModelEmprestimos) {
		return emprestimoDao.salvarEmprestimosDAO(plistaModelEmprestimos);
	}

	public EmprestimoModel getEmprestimoDAO(int pIdEmprestimo) {
		return emprestimoDao.getEmprestimoDAO(pIdEmprestimo);
	}

	public ArrayList<EmprestimoModel> getListaEmprestimoDAO() {
		return emprestimoDao.getListaEmprestimoDAO();
	}

	public boolean atualizarEmprestimoDAO(EmprestimoModel pEmprestimoModel) {
		return emprestimoDao.atualizarEmprestimoDAO(pEmprestimoModel);
	}

	public boolean excluirEmprestimoDAO(int pIdEmprestimoModel) {
		return emprestimoDao.excluirEmprestimoDAO(pIdEmprestimoModel);
	}

	public EmprestimoModel getQuantidadeEmprestimo() {
		return emprestimoDao.getQuantidadeEmprestimo();
	}
}
