package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.ClienteModel;
import br.com.acervo.model.VendasClientesModel;
import br.com.acervo.model.VendasModel;

/**
 *
 * @author Jose Luiz
 */
public class VendasClientesDao extends AcervoConnectionMySql implements IVendasClientesDao {

	/**
	 * recupera uma lista de Vendas return ArrayList
	 *
	 * @return
	 */
	@Override
	public ArrayList<VendasClientesModel> getListaVendasClienteDAO() {
		ArrayList<VendasClientesModel> listaModelVendasCliente = new ArrayList<>();
		VendasModel vendasModel = new VendasModel();
		ClienteModel clienteModel = new ClienteModel();
		VendasClientesModel modelVendasCliente = new VendasClientesModel();

		try {
			this.conectar();
			this.executarSQL("SELECT " + "tbl_vendas.pk_id_vendas," + "tbl_vendas.fk_cliente,"
					+ "tbl_vendas.ven_data_venda," + "tbl_vendas.ven_valor_liquido," + "tbl_vendas.ven_valor_bruto,"
					+ "tbl_vendas.ven_desconto,"

					+ "tbl_cliente.pk_id_cliente," + "tbl_cliente.cli_nome," + "tbl_cliente.cli_endereco,"
					+ "tbl_cliente.cli_numero," + "tbl_cliente.cli_bairro," + "tbl_cliente.cli_cidade,"
					+ "tbl_cliente.cli_uf," + "tbl_cliente.cli_cep," + "tbl_cliente.cli_telefone,"
					+ "tbl_cliente.cli_email"

					+ " FROM "
					+ " tbl_vendas INNER JOIN tbl_cliente ON tbl_cliente.pk_id_cliente = tbl_vendas.fk_cliente;");
			while (this.getResultSet().next()) {
				vendasModel = new VendasModel();
				clienteModel = new ClienteModel();
				modelVendasCliente = new VendasClientesModel();

				// vendas
				vendasModel = new VendasModel();
				vendasModel.setIdVenda(this.getResultSet().getInt(1));
				vendasModel.setCliente(this.getResultSet().getInt(2));
				vendasModel.setVenDataVenda(this.getResultSet().getString(3));
				vendasModel.setVenValorLiquido(this.getResultSet().getDouble(4));
				vendasModel.setVenValorBruto(this.getResultSet().getDouble(5));
				vendasModel.setVenDesconto(this.getResultSet().getDouble(6));

				// cliente
				clienteModel = new ClienteModel();
				clienteModel.setIdCliente(this.getResultSet().getInt(1));
				clienteModel.setCliNome(this.getResultSet().getString(2));
				clienteModel.setCliRua(this.getResultSet().getString(3));
				clienteModel.setCliNumero(this.getResultSet().getString(4));
				clienteModel.setCliBairro(this.getResultSet().getString(5));
				clienteModel.setCliCidade(this.getResultSet().getString(6));
				clienteModel.setCliUf(this.getResultSet().getString(7));
				clienteModel.setCliCep(this.getResultSet().getString(8));
				clienteModel.setCliTelefone(this.getResultSet().getString(9));
				clienteModel.setCliEmail(this.getResultSet().getString(10));

				modelVendasCliente.setModelVendas(vendasModel);
				modelVendasCliente.setModelCliente(clienteModel);
				listaModelVendasCliente.add(modelVendasCliente);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listaModelVendasCliente;
	}
}
