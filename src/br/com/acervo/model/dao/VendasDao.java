package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.VendasModel;

/**
 *
 * @author joseluiz
 */
public class VendasDao extends AcervoConnectionMySql implements IVendasDao {

	/**
	 * grava Vendas
	 *
	 * @param pVendasModel return int
	 * @return
	 */
	@Override
	public int salvarVendasDAO(VendasModel pVendasModel) {
		try {
			this.conectar();
			return this.insertSQL("INSERT INTO tbl_vendas (" + "fk_cliente," + "ven_data_venda," + "ven_valor_liquido,"
					+ "ven_valor_bruto," + "ven_desconto" + ") VALUES (" + "'" + pVendasModel.getCliente() + "'," + "'"
					+ pVendasModel.getVenDataVenda() + "'," + "'" + pVendasModel.getVenValorLiquido() + "'," + "'"
					+ pVendasModel.getVenValorBruto() + "'," + "'" + pVendasModel.getVenDesconto() + "'" + ");");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * recupera Vendas
	 *
	 * @param pIdVendas return ModelVendas
	 * @return
	 */
	@Override
	public VendasModel getVendasDAO(int pIdVendas) {
		VendasModel modelVendas = new VendasModel();
		try {
			this.conectar();
			this.executarSQL("SELECT " + "pk_id_vendas," + "fk_cliente," + "ven_data_venda," + "ven_valor_liquido,"
					+ "ven_valor_bruto," + "ven_desconto" + " FROM" + " tbl_vendas" + " WHERE" + " pk_id_vendas = '"
					+ pIdVendas + "'" + ";");

			while (this.getResultSet().next()) {
				modelVendas.setIdVenda(this.getResultSet().getInt(1));
				modelVendas.setCliente(this.getResultSet().getInt(2));
				modelVendas.setVenDataVenda(this.getResultSet().getString(3));
				modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
				modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
				modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return modelVendas;
	}

	/**
	 * recupera uma lista de Vendas return ArrayList
	 *
	 * @return
	 */
	@Override
	public ArrayList<VendasModel> getListaVendasDAO() {
		ArrayList<VendasModel> listamodelVendas = new ArrayList<>();
		VendasModel modelVendas = new VendasModel();
		try {
			this.conectar();
			this.executarSQL("SELECT " + "pk_id_vendas," + "fk_cliente," + "ven_data_venda," + "ven_valor_liquido,"
					+ "ven_valor_bruto," + "ven_desconto," + " FROM" + " tbl_vendas" + ";");

			while (this.getResultSet().next()) {
				modelVendas = new VendasModel();
				modelVendas.setIdVenda(this.getResultSet().getInt(1));
				modelVendas.setCliente(this.getResultSet().getInt(2));
				modelVendas.setVenDataVenda(this.getResultSet().getString(3));
				modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
				modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
				modelVendas.setVenDesconto(this.getResultSet().getDouble(6));
				listamodelVendas.add(modelVendas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listamodelVendas;
	}

	/**
	 * atualiza Vendas
	 *
	 * @param pModelVendas return boolean
	 * @return
	 */
	@Override
	public boolean atualizarVendasDAO(VendasModel pModelVendas) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE tbl_vendas SET " + "pk_id_vendas = '"
					+ pModelVendas.getIdVenda() + "'," + "fk_cliente = '" + pModelVendas.getCliente() + "',"
					+ "ven_data_venda = '" + pModelVendas.getVenDataVenda() + "'," + "ven_valor_liquido = '"
					+ pModelVendas.getVenValorLiquido() + "'," + "ven_valor_bruto = '" + pModelVendas.getVenValorBruto()
					+ "'," + "ven_desconto = '" + pModelVendas.getVenDesconto() + "'" + " WHERE " + "pk_id_vendas = '"
					+ pModelVendas.getIdVenda() + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * exclui Vendas
	 *
	 * @param pIdVendas return boolean
	 * @return
	 */
	@Override
	public boolean excluirVendasDAO(int pIdVendas) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL(
					"DELETE FROM tbl_vendas " + " WHERE " + "pk_id_vendas = '" + pIdVendas + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	@Override
	public VendasModel getQuantidadeVendas() {
		VendasModel vendasModel = new VendasModel();
		try {
			this.conectar();
			this.executarSQL("SELECT COUNT(*) FROM tbl_vendas;");
			while (this.getResultSet().next()) {
				vendasModel.setQuantidadeVendas(this.getResultSet().getInt(1));
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return vendasModel;
	}

	/**
	 * calcula o valor de todas as vendas realizadas.
	 * 
	 */
	@Override
	public VendasModel getValorTotal() {
		VendasModel vendasModel = new VendasModel();
		try {
			this.conectar();
			this.executarSQL("SELECT SUM(ven_valor_liquido) FROM tbl_vendas;");
			while (this.getResultSet().next()) {
				vendasModel.setValorTotal(this.getResultSet().getDouble(1));
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return vendasModel;
	}

	@Override
	public VendasModel getQuantidadeLivroVendas() {
		VendasModel vendasModel = new VendasModel();
		try {
			this.conectar();
			this.executarSQL("SELECT SUM(ven_livro_quantidade) FROM tbl_vendas_livro;");
			while (this.getResultSet().next()) {
				vendasModel.setQuantidadeLivrosVendidos(this.getResultSet().getInt(1));
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return vendasModel;
	}
}
