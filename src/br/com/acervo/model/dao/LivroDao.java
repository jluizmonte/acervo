package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.LivroModel;

/**
 * implementação da interface I*DAO extensão da classe de conexão com o Banco de
 * dados
 *
 * @author joseluiz
 */
public class LivroDao extends AcervoConnectionMySql implements ILivroDao {

	/**
	 * salva Livro
	 *
	 * @param pLivroModel
	 * @return
	 */
	@Override
	public int salvarLivroDAO(LivroModel pLivroModel) {
		try {
			this.conectar();
			return this.insertSQL("INSERT INTO tbl_livro (" + "livro_titulo," + "livro_autor," + "livro_ano,"
					+ "livro_categoria," + "livro_obs," + "livro_data," + "livro_tipo," + "livro_quantidade,"
					+ "livro_preco" + ") VALUES (" + "'" + pLivroModel.getTitulo() + "'," + "'" + pLivroModel.getAutor()
					+ "'," + "'" + pLivroModel.getAno() + "'," + "'" + pLivroModel.getCategoria() + "'," + "'"
					+ pLivroModel.getObservacao() + "'," + "'" + pLivroModel.getDataCadastro() + "'," + "'"
					+ pLivroModel.getTipoLivro() + "'," + "'" + pLivroModel.getQuantidadeLivro() + "'," + "'"
					+ pLivroModel.getLivroValorUnitario() + "'" + ");");
		} catch (Exception e) {
			return 0;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * busca livro pelo pk
	 *
	 * @param pIdLivro
	 * @return
	 */
	@Override
	public LivroModel getLivroDAO(int pIdLivro) {
		LivroModel livroModel = new LivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT " + "pk_id_livro," + "livro_titulo," + "livro_autor," + "livro_ano,"
					+ "livro_categoria," + "livro_obs," + "livro_data," + "livro_tipo," + "livro_quantidade,"
					+ "livro_preco" + " FROM" + " tbl_livro" + " WHERE" + " pk_id_livro = '" + pIdLivro + "'" + ";");

			while (this.getResultSet().next()) {
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
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return livroModel;
	}

	/**
	 * busca livro pelo titulo
	 *
	 * @param pLivroModel
	 * @return
	 */
	@Override
	public LivroModel getLivroDAO(String pLivroModel) {
		LivroModel livroModel = new LivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM" + " tbl_livro" + " WHERE" + " livro_titulo = '" + pLivroModel + "'" + ";");

			while (this.getResultSet().next()) {
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

			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return livroModel;
	}

	/**
	 * busca livros e retorna numa lista
	 *
	 * @return
	 */
	@Override
	public ArrayList<LivroModel> getListaLivroDAO() {
		ArrayList<LivroModel> listaLivroModel = new ArrayList<>();
		LivroModel livroModel = new LivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM tbl_livro;");

			while (this.getResultSet().next()) {
				livroModel = new LivroModel();
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

				listaLivroModel.add(livroModel);
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return listaLivroModel;
	}

	/**
	 * atualiza os dados de um livro
	 *
	 * @param pLivroModel
	 * @return
	 */
	@Override
	public boolean atualizarLivroDAO(LivroModel pLivroModel) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE tbl_livro SET " + "pk_id_livro = '" + pLivroModel.getIdLivro()
					+ "'," + "livro_titulo = '" + pLivroModel.getTitulo() + "'," + "livro_autor  = '"
					+ pLivroModel.getAutor() + "'," + "livro_ano   = '" + pLivroModel.getAno() + "',"
					+ "livro_categoria   = '" + pLivroModel.getCategoria() + "'," + "livro_obs   = '"
					+ pLivroModel.getObservacao() + "'," + "livro_data   = '" + pLivroModel.getDataCadastro() + "',"
					+ "livro_tipo = '" + pLivroModel.getTipoLivro() + "'," + "livro_quantidade ='"
					+ pLivroModel.getQuantidadeLivro() + "'," + "livro_preco = '" + pLivroModel.getLivroValorUnitario()
					+ "'" + " WHERE " + "pk_id_livro = '" + pLivroModel.getIdLivro() + "'" + ";");
		} catch (Exception e) {
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * exclui Livro
	 *
	 * @param pIdLivro
	 * @return
	 */
	@Override
	public boolean excluirLivroDAO(int pIdLivro) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL(
					"DELETE FROM tbl_livro " + " WHERE " + "pk_id_livro = '" + pIdLivro + "'" + ";");
		} catch (Exception e) {
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * busca a quantidade total de livros cadastrados
	 *
	 * @return
	 */
	@Override
	public LivroModel getQuantidadeLivrosCadastrados() {
		LivroModel livroModel = new LivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT COUNT(*) FROM tbl_livro;");
			while (this.getResultSet().next()) {
				livroModel.setQuantidadeLivro(this.getResultSet().getInt(1));
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return livroModel;
	}

	@Override
	public boolean alterarEstoqueLivrosDAO(ArrayList<LivroModel> pListaLivroModel) {
		try {
			this.conectar();
			for (int i = 0; i < pListaLivroModel.size(); i++) {
				this.executarUpdateDeleteSQL(
						"UPDATE tbl_livro SET " + "livro_quantidade = '" + pListaLivroModel.get(i).getQuantidadeLivro()
								+ "'" + " WHERE pk_id_livro = '" + pListaLivroModel.get(i).getIdLivro() + "'");
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
