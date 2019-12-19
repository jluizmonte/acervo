package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.EmprestimoModel;

/**
 *
 * @author joseluiz
 */
public class EmprestimoDao extends AcervoConnectionMySql implements IEmprestimoDao {

    @Override
    public int salvarEmprestimoDAO(EmprestimoModel pEmprestimoModel) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_emprestimo (" + "fk_locador," + "fk_locatario," + "fk_livro,"
                    + "emprestimo_data," + "emprestimo_data_devolucao," + "emprestimo_status" + ") VALUES (" + "'"
                    + pEmprestimoModel.getIdLocador() + "'," + "'" + pEmprestimoModel.getIdLocatario() + "'," + "'"
                    + pEmprestimoModel.getIdLivro() + "'," + "'" + pEmprestimoModel.getDataEmprestimo() + "'," + "'"
                    + pEmprestimoModel.getDataDevolucao() + "'," + "'" + pEmprestimoModel.getStatus() + "'" + ");");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }

    }

    @Override
    public EmprestimoModel getEmprestimoDAO(int pIdEmprestimo) {
        EmprestimoModel emprestimoModel = new EmprestimoModel();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM" + " tbl_emprestimo" + " WHERE" + " pk_id_emprestimo = '" + pIdEmprestimo
                    + "'" + ";");

            while (this.getResultSet().next()) {
                emprestimoModel.setIdEmprestimo(this.getResultSet().getInt(1));
                emprestimoModel.setIdLocador(this.getResultSet().getInt(2));
                emprestimoModel.setIdLocatario(this.getResultSet().getInt(3));
                emprestimoModel.setDataEmprestimo(this.getResultSet().getString(4));
                emprestimoModel.setDataDevolucao(this.getResultSet().getString(5));
                emprestimoModel.setStatus(this.getResultSet().getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return emprestimoModel;
    }

    @Override
    public ArrayList<EmprestimoModel> getListaEmprestimoDAO() {
        ArrayList<EmprestimoModel> listaEmprestimoModel = new ArrayList<>();
        EmprestimoModel emprestimoModel = new EmprestimoModel();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM tbl_emprestimo;");

            while (this.getResultSet().next()) {
                emprestimoModel.setIdEmprestimo(this.getResultSet().getInt(1));
                emprestimoModel.setIdLocador(this.getResultSet().getInt(2));
                emprestimoModel.setIdLocatario(this.getResultSet().getInt(3));
                emprestimoModel.setDataEmprestimo(this.getResultSet().getString(4));
                emprestimoModel.setDataDevolucao(this.getResultSet().getString(5));
                emprestimoModel.setStatus(this.getResultSet().getString(6));
                listaEmprestimoModel.add(emprestimoModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaEmprestimoModel;
    }

    @Override
    public boolean atualizarEmprestimoDAO(EmprestimoModel pEmprestimoModel) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_emprestimo SET " + "pk_id_emprestimo = '" + pEmprestimoModel.getIdEmprestimo() + "',"
                    + "fk_locador ='" + pEmprestimoModel.getIdLocador() + "'," + "fk_locatario = '"
                    + pEmprestimoModel.getIdLocatario() + "'," + "fk_livro ='" + pEmprestimoModel.getIdLivro()
                    + "'," + "emprestimo_data = '" + pEmprestimoModel.getDataEmprestimo() + "',"
                    + "emprestimo_data_devolucao = '" + pEmprestimoModel.getDataDevolucao() + "',"
                    + "emprestimo_status = '" + pEmprestimoModel.getStatus() + "'" + " WHERE "
                    + "pk_id_emprestimo = '" + pEmprestimoModel.getIdEmprestimo() + "'" + ";");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    @Override
    public boolean excluirEmprestimoDAO(int pIdEmprestimoModel) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_emprestimo " + " WHERE " + "pk_id_emprestimo = '"
                    + pIdEmprestimoModel + "'" + ";");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    @Override
    public EmprestimoModel getQuantidadeEmprestimo() {
        EmprestimoModel emprestimoModel = new EmprestimoModel();
        try {
            this.conectar();
            this.executarSQL("SELECT COUNT(*) FROM tbl_emprestimo;");
            while (this.getResultSet().next()) {
                emprestimoModel.setQuantidadeEmprestimo(this.getResultSet().getInt(1));
            }
        } catch (SQLException e) {
        } finally {
            this.fecharConexao();
        }
        return emprestimoModel;
    }

    @Override
    public boolean salvarEmprestimosDAO(ArrayList<EmprestimoModel> plistaModelEmprestimos) {
        try {
            this.conectar();
            int cont = plistaModelEmprestimos.size();
            for (int i = 0; i < cont; i++) {
                this.insertSQL("INSERT INTO tbl_emprestimo (" + "fk_locador," + "fk_locatario," + "fk_livro,"
                        + "emprestimo_data," + "emprestimo_data_devolucao," + "emprestimo_status" + ") VALUES (" + "'"
                        + plistaModelEmprestimos.get(i).getIdLocador() + "'," + "'"
                        + plistaModelEmprestimos.get(i).getIdLocatario() + "'," + "'"
                        + plistaModelEmprestimos.get(i).getIdLivro() + "'," + "'"
                        + plistaModelEmprestimos.get(i).getDataEmprestimo() + "'," + "'"
                        + plistaModelEmprestimos.get(i).getDataDevolucao() + "'," + "'"
                        + plistaModelEmprestimos.get(i).getStatus() + "'" + ");");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
