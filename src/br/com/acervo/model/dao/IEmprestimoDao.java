package br.com.acervo.model.dao;

import java.util.ArrayList;

import br.com.acervo.model.EmprestimoModel;

/**
 *
 * @author joseluiz
 */
public interface IEmprestimoDao {

    public int salvarEmprestimoDAO(EmprestimoModel pEmprestimoModel);

    public boolean salvarEmprestimosDAO(ArrayList<EmprestimoModel> plistaModelEmprestimos);

    public EmprestimoModel getEmprestimoDAO(int pIdEmprestimo);

    public ArrayList<EmprestimoModel> getListaEmprestimoDAO();

    public boolean atualizarEmprestimoDAO(EmprestimoModel pEmprestimoModel);

    public boolean excluirEmprestimoDAO(int pIdEmprestimoModel);

    public EmprestimoModel getQuantidadeEmprestimo();

}
