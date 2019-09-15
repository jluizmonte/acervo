package br.com.acervo.service;

import java.util.ArrayList;

import br.com.acervo.model.EmprestimoLocatarioModel;
import br.com.acervo.model.dao.EmprestimoLocatarioDao;

/**
 *
 * @author joseluiz
 */
public class EmprestimoLocatarioService {

	EmprestimoLocatarioDao emprestimoLocatarioDao = new EmprestimoLocatarioDao();

	public ArrayList<EmprestimoLocatarioModel> getListaEmprestimosLocatarioDAO() {
		return emprestimoLocatarioDao.getListaEmprestimosLocatarioDAO();
	}
}
