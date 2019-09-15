package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.ClienteModel;

/**
 *
 * @author Jose Luiz
 */
public class ClienteDao extends AcervoConnectionMySql implements IClienteDao {

    /**
     * grava Cliente
     *
     * @param pClienteModel return int
     * @return
     */
    @Override
    public int salvarClienteDAO(ClienteModel pClienteModel) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_cliente (" + "cli_nome," + "cli_endereco," + "cli_numero,"
                    + "cli_bairro," + "cli_cidade," + "cli_uf," + "cli_cep," + "cli_telefone," + "cli_email"
                    + ") VALUES (" + "'" + pClienteModel.getCliNome() + "'," + "'" + pClienteModel.getCliRua() + "',"
                    + "'" + pClienteModel.getCliNumero() + "'," + "'" + pClienteModel.getCliBairro() + "'," + "'"
                    + pClienteModel.getCliCidade() + "'," + "'" + pClienteModel.getCliUf() + "'," + "'"
                    + pClienteModel.getCliCep() + "'," + "'" + pClienteModel.getCliTelefone() + "'," + "'"
                    + pClienteModel.getCliEmail() + "'" + ");");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Cliente
     *
     * @param pIdCliente return ModelCliente
     * @return
     */
    @Override
    public ClienteModel getClienteDAO(int pIdCliente) {
        ClienteModel clienteModel = new ClienteModel();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM tbl_cliente" + " WHERE" + " pk_id_cliente = '" + pIdCliente + "'" + ";");

            while (this.getResultSet().next()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return clienteModel;
    }

    /**
     * recupera Cliente
     *
     * @param pNomeCliente return ModelCliente
     * @return
     */
    @Override
    public ClienteModel getClienteDAO(String pNomeCliente) {
        ClienteModel clienteModel = new ClienteModel();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM tbl_cliente" + " WHERE" + " cli_nome = '" + pNomeCliente + "'" + ";");

            while (this.getResultSet().next()) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return clienteModel;
    }

    /**
     * recupera uma lista de Cliente return ArrayList
     *
     * @return
     */
    @Override
    public ArrayList<ClienteModel> getListaClienteDAO() {
        ArrayList<ClienteModel> listamodelCliente = new ArrayList<>();
        ClienteModel clienteModel = new ClienteModel();
        try {
            this.conectar();
            this.executarSQL("SELECT * FROM tbl_cliente;");

            while (this.getResultSet().next()) {
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

                listamodelCliente.add(clienteModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
     * atualiza Cliente
     *
     * @param pClienteModel return boolean
     * @return
     */
    @Override
    public boolean atualizarClienteDAO(ClienteModel pClienteModel) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_cliente SET " + "pk_id_cliente = '"
                    + pClienteModel.getIdCliente() + "'," + "cli_nome = '" + pClienteModel.getCliNome() + "',"
                    + "cli_endereco = '" + pClienteModel.getCliRua() + "'," + "cli_numero = '"
                    + pClienteModel.getCliNumero() + "'," + "cli_bairro = '" + pClienteModel.getCliBairro() + "',"
                    + "cli_cidade = '" + pClienteModel.getCliCidade() + "'," + "cli_uf = '" + pClienteModel.getCliUf()
                    + "'," + "cli_cep = '" + pClienteModel.getCliCep() + "'," + "cli_telefone = '"
                    + pClienteModel.getCliTelefone() + "'," + "cli_email = '" + pClienteModel.getCliEmail() + "'"
                    + " WHERE " + "pk_id_cliente = '" + pClienteModel.getIdCliente() + "'" + ";");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Cliente
     *
     * @param pIdCliente return boolean
     * @return
     */
    @Override
    public boolean excluirClienteDAO(int pIdCliente) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_cliente " + " WHERE " + "pk_id_cliente = '" + pIdCliente + "'" + ";");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    @Override
    public ClienteModel getQuantidadeCliente() {
        ClienteModel clienteModel = new ClienteModel();
        try {
            this.conectar();
            this.executarSQL("SELECT COUNT(*) FROM tbl_cliente;");

            while (this.getResultSet().next()) {
                clienteModel.setQuantidadeCliente(this.getResultSet().getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return clienteModel;
    }
}
