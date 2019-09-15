package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.EmprestimoLivroModel;
import br.com.acervo.model.LivroModel;
import br.com.acervo.model.LivrosEmprestimosLivrosModel;

/**
 *
 * @author joseluiz
 */
public class LivrosEmprestimosLivrosDao extends AcervoConnectionMySql implements ILivrosEmprestimosLivrosDao {

	@Override
	public ArrayList<LivrosEmprestimosLivrosModel> getListaLivrosEmprestimoLivrosDAO(int pCodigoEmprestimo) {
		ArrayList<LivrosEmprestimosLivrosModel> listaLivroEmprestimoLivroModel = new ArrayList<>();
		LivrosEmprestimosLivrosModel livrosEprestimoLivroModel = new LivrosEmprestimosLivrosModel();
		LivroModel livroModel = new LivroModel();
		EmprestimoLivroModel emprestimoLivroModel = new EmprestimoLivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT " + "tbl_livro.pk_id_livro," + "tbl_livro.livro_titulo," + "tbl_livro.livro_autor,"
					+ "tbl_livro.livro_ano," + "tbl_livro.livro_categoria," + "tbl_livro.livro_obs,"
					+ "tbl_livro.livro_data," + "tbl_livro.livro_tipo," + "tbl_livro.livro_quantidade,"
					+ "tbl_livro.livro_preco," + "tbl_emprestimo_livro.pk_id_emprestimo_livro,"
					+ "tbl_emprestimo_livro.fk_livro," + "tbl_emprestimo_livro.fk_emprestimo,"
					+ "tbl_emprestimo_livro.emprestimo_quantidade" + " FROM tbl_emprestimo_livro "
					+ " INNER JOIN tbl_livro ON tbl_livro.pk_id_livro = tbl_emprestimo_livro.fk_livro "
					+ " WHERE tbl_emprestimo_livro.fk_emprestimo = '" + pCodigoEmprestimo + "';");

			while (this.getResultSet().next()) {
				livrosEprestimoLivroModel = new LivrosEmprestimosLivrosModel();
				livroModel = new LivroModel();
				emprestimoLivroModel = new EmprestimoLivroModel();

				livroModel.setIdLivro(this.getResultSet().getInt(1));
				livroModel.setTitulo(this.getResultSet().getString(2));
				livroModel.setAutor(this.getResultSet().getString(3));
				livroModel.setAno(this.getResultSet().getInt(4));
				livroModel.setCategoria(this.getResultSet().getString(5));
				livroModel.setObservacao((this.getResultSet().getString(6)));
				livroModel.setDataCadastro(this.getResultSet().getString(7));
				livroModel.setTipoLivro(this.getResultSet().getString(8));
				livroModel.setQuantidadeLivro(this.getResultSet().getInt(9));
				livroModel.setLivroValorUnitario(this.getResultSet().getDouble(10));

				// emprestimo-->
				emprestimoLivroModel = new EmprestimoLivroModel();
				emprestimoLivroModel.setIdEmprestimoLivro(this.getResultSet().getInt(11));
				emprestimoLivroModel.setLivro(this.getResultSet().getInt(12));
				emprestimoLivroModel.setEmprestimo(this.getResultSet().getInt(13));
				emprestimoLivroModel.setQuantidadeEmprestimo(this.getResultSet().getInt(14));

				livrosEprestimoLivroModel.setLivroModel(livroModel);
				livrosEprestimoLivroModel.setEmprestimoLivroModel(emprestimoLivroModel);
				listaLivroEmprestimoLivroModel.add(livrosEprestimoLivroModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listaLivroEmprestimoLivroModel;
	}

}
