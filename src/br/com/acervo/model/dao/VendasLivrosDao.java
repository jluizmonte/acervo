package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.VendasLivroModel;

/**
 *
 * @author Jose Luiz
 */
public class VendasLivrosDao extends AcervoConnectionMySql implements IVendasLivrosDao {

	/**
	 * grava VendasProdutos
	 *
	 * @param pModelVendasLivros return int
	 * @return
	 */
	@Override
	public int salvarVendasLivrosDAO(VendasLivroModel pModelVendasLivros) {
		try {
			this.conectar();
			return this.insertSQL("INSERT INTO tbl_vendas_livro (" + "fk_livro," + "fk_vendas," + "ven_livro_valor,"
					+ "ven_livro_quantidade" + ") VALUES (" + "'" + pModelVendasLivros.getLivro() + "'," + "'"
					+ pModelVendasLivros.getVendas() + "'," + "'" + pModelVendasLivros.getVendasLivroValor() + "',"
					+ "'" + pModelVendasLivros.getVenLivroQuantidade() + "'" + ");");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * recupera VendasProdutos
	 *
	 * @param pIdVendaLivro return VendasProdutosModel
	 * @return
	 */
	@Override
	public VendasLivroModel getVendasLivrosDAO(int pIdVendaLivro) {
		VendasLivroModel vendasLivroModel = new VendasLivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT " + "pk_id_venda_livro," + "fk_livro," + "fk_vendas," + "ven_livro_valor,"
					+ "ven_livro_quantidade" + " FROM" + " tbl_vendas_livro" + " WHERE" + " pk_id_venda_livro = '"
					+ pIdVendaLivro + "'" + ";");

			while (this.getResultSet().next()) {
				vendasLivroModel.setIdVendaLivro(this.getResultSet().getInt(1));
				vendasLivroModel.setLivro(this.getResultSet().getInt(2));
				vendasLivroModel.setVendas(this.getResultSet().getInt(3));
				vendasLivroModel.setVendasLivroValor(this.getResultSet().getDouble(4));
				vendasLivroModel.setVenLivroQuantidade(this.getResultSet().getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return vendasLivroModel;
	}

	/**
	 * recupera uma lista de VendasProdutos return ArrayList
	 *
	 * @return
	 */
	@Override
	public ArrayList<VendasLivroModel> getListaVendasLivrosDAO() {
		ArrayList<VendasLivroModel> listaVendasLivroModel = new ArrayList<>();
		VendasLivroModel vendasLivrosModel = new VendasLivroModel();
		try {
			this.conectar();
			this.executarSQL("SELECT " + "pk_id_venda_livro," + "fk_livro," + "fk_vendas," + "ven_livro_valor,"
					+ "ven_livro_quantidade" + " FROM" + " tbl_vendas_livro" + ";");

			while (this.getResultSet().next()) {
				vendasLivrosModel = new VendasLivroModel();
				vendasLivrosModel.setIdVendaLivro(this.getResultSet().getInt(1));
				vendasLivrosModel.setLivro(this.getResultSet().getInt(2));
				vendasLivrosModel.setVendas(this.getResultSet().getInt(3));
				vendasLivrosModel.setVendasLivroValor(this.getResultSet().getDouble(4));
				vendasLivrosModel.setVenLivroQuantidade(this.getResultSet().getInt(5));
				listaVendasLivroModel.add(vendasLivrosModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listaVendasLivroModel;
	}

	/**
	 * atualiza VendasProdutos
	 *
	 * @param pModelVendasLivros return boolean
	 * @return
	 */
	@Override
	public boolean atualizarVendasLivrosDAO(VendasLivroModel pModelVendasLivros) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE tbl_vendas_livro SET " + "pk_id_venda_livro = '"
					+ pModelVendasLivros.getIdVendaLivro() + "'," + "fk_livro= '" + pModelVendasLivros.getLivro() + "',"
					+ "fk_vendas = '" + pModelVendasLivros.getVendas() + "'," + "ven_livro_valor = '"
					+ pModelVendasLivros.getVendasLivroValor() + "'," + "ven_livro_quantidade = '"
					+ pModelVendasLivros.getVenLivroQuantidade() + "'" + " WHERE " + "pk_id_venda_livro = '"
					+ pModelVendasLivros.getIdVendaLivro() + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * exclui VendasProdutos
	 *
	 * @param pIdVendaLivro return boolean
	 * @return
	 */
	@Override
	public boolean excluirVendasLivrosDAO(int pIdVendaLivro) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL(
					"DELETE FROM tbl_vendas_livro " + " WHERE " + "fk_vendas = '" + pIdVendaLivro + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * Salva uma lista de produtos da venda
	 *
	 * @param plistaModelVendasLivro
	 * @return
	 */
	@Override
	public boolean salvarVendasLivrosDAO(ArrayList<VendasLivroModel> plistaModelVendasLivro) {
		try {
			this.conectar();
			int cont = plistaModelVendasLivro.size();
			for (int i = 0; i < cont; i++) {
				this.insertSQL("INSERT INTO tbl_vendas_livro (" + "fk_vendas," + "fk_livro," + "ven_livro_valor,"
						+ "ven_livro_quantidade" + ") VALUES (" + "'" + plistaModelVendasLivro.get(i).getVendas() + "',"
						+ "'" + plistaModelVendasLivro.get(i).getLivro() + "'," + "'"
						+ plistaModelVendasLivro.get(i).getVendasLivroValor() + "'," + "'"
						+ plistaModelVendasLivro.get(i).getVenLivroQuantidade() + "'" + ");");
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
