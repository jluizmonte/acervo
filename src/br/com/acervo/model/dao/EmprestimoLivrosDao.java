package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.EmprestimoLivroModel;

/**
 *
 * @author joseluiz
 */
public class EmprestimoLivrosDao extends AcervoConnectionMySql implements IEmprestimoLivroDao {

	@Override
	public int salvarEmprestimosLivrosDAO(EmprestimoLivroModel pModelEmprestimosLivros) {

		try {
			this.conectar();
			return this.insertSQL("INSERT INTO tbl_emprestimo_livro (" + "fk_livro," + "fk_emprestimo,"
					+ "emprestimo_quantidade" + ") VALUES (" + "'" + pModelEmprestimosLivros.getLivro() + "'," + "'"
					+ pModelEmprestimosLivros.getEmprestimo() + "'," + "'"
					+ pModelEmprestimosLivros.getQuantidadeEmprestimo() + "'" + ");");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			this.fecharConexao();
		}
	}

	@Override
	public boolean salvarEmprestimosLivrosDAO(ArrayList<EmprestimoLivroModel> plistaModelEmprestimosLivros) {
		try {
			this.conectar();
			int cont = plistaModelEmprestimosLivros.size();
			for (int i = 0; i < cont; i++) {
				this.insertSQL("INSERT INTO tbl_emprestimo_livro (" + "fk_livro," + "fk_emprestimo,"
						+ "emprestimo_quantidade" + ") VALUES (" + "'" + plistaModelEmprestimosLivros.get(i).getLivro()
						+ "'," + "'" + plistaModelEmprestimosLivros.get(i).getEmprestimo() + "'," + "'"
						+ plistaModelEmprestimosLivros.get(i).getQuantidadeEmprestimo() + "'" + ");");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	@Override
	public boolean excluirEmprestimosLivrosDAO(int pIdEmprestimoLivro) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("DELETE FROM tbl_emprestimo_livro " + " WHERE "
					+ "pk_id_emprestimo_livro = '" + pIdEmprestimoLivro + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	@Override
	public boolean atualizarEmprestimosLivrosDAO(EmprestimoLivroModel pModelEmprestimosLivros) {

		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE tbl_emprestimo_livro SET " + "pk_id_emprestimo_livro = '"
					+ pModelEmprestimosLivros.getIdEmprestimoLivro() + "'," + "fk_livro= '"
					+ pModelEmprestimosLivros.getLivro() + "'," + "fk_emprestimo = '"
					+ pModelEmprestimosLivros.getEmprestimo() + "'," + "emprestimo_quantidade = '"
					+ pModelEmprestimosLivros.getQuantidadeEmprestimo() + "'" + " WHERE " + "pk_id_venda_livro = '"
					+ pModelEmprestimosLivros.getIdEmprestimoLivro() + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	@Override
	public ArrayList<EmprestimoLivroModel> getListaEmprestimosLivrosDAO() {
		ArrayList<EmprestimoLivroModel> listaEmprestimoModel = new ArrayList<>();
		EmprestimoLivroModel emprestimoLivroModel = new EmprestimoLivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM  tbl_emprestimo_livro;");

			while (this.getResultSet().next()) {
				emprestimoLivroModel = new EmprestimoLivroModel();
				emprestimoLivroModel.setIdEmprestimoLivro(1);
				emprestimoLivroModel.setLivro(2);
				emprestimoLivroModel.setEmprestimo(3);
				emprestimoLivroModel.setQuantidadeEmprestimo(4);
				listaEmprestimoModel.add(emprestimoLivroModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listaEmprestimoModel;

	}

	@Override
	public EmprestimoLivroModel getEmprestimosLivrosDAO(int pIdEmprestimoLivro) {
		EmprestimoLivroModel emprestimoLivroModel = new EmprestimoLivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM  tbl_emprestimo_livro;" + " WHERE" + " pk_id_emprestimo_livro = '"
					+ pIdEmprestimoLivro + "'" + ";");

			while (this.getResultSet().next()) {
				emprestimoLivroModel = new EmprestimoLivroModel();
				emprestimoLivroModel.setIdEmprestimoLivro(1);
				emprestimoLivroModel.setLivro(2);
				emprestimoLivroModel.setEmprestimo(3);
				emprestimoLivroModel.setQuantidadeEmprestimo(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return emprestimoLivroModel;
	}

}
