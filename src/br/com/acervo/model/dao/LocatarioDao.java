package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.LocatarioModel;

/**
 *
 * @author joseluiz
 */
public class LocatarioDao extends AcervoConnectionMySql implements ILocatarioDao {

	/**
	 *
	 * @param pLocatarioModel
	 * @return
	 */
	@Override
	public int salvarLocatarioDAO(LocatarioModel pLocatarioModel) {
		try {
			this.conectar();
			return this.insertSQL("INSERT INTO tbl_locatario (" + "locatario_nome," + "locatario_rua,"
					+ "locatario_numero," + "locatario_bairro," + "locatario_cidade," + "locatario_uf,"
					+ "locatario_cep," + "locatario_telefone," + "locatario_email," + "locatario_status" + ") VALUES ("
					+ "'" + pLocatarioModel.getNome() + "'," + "'" + pLocatarioModel.getRua() + "'," + "'"
					+ pLocatarioModel.getNumero() + "'," + "'" + pLocatarioModel.getBairro() + "'," + "'"
					+ pLocatarioModel.getCidade() + "'," + "'" + pLocatarioModel.getUf() + "'," + "'"
					+ pLocatarioModel.getCep() + "'," + "'" + pLocatarioModel.getTelefone() + "'," + "'"
					+ pLocatarioModel.getEmail() + "'," + "'" + pLocatarioModel.getStatus() + "'" + ");");
		} catch (Exception e) {
			return 0;
		} finally {
			this.fecharConexao();
		}
	}

	@Override
	public LocatarioModel getLocatarioDAO(int pIdLocatario) {
		LocatarioModel locatarioModel = new LocatarioModel();
		try {
			this.conectar();
			this.executarSQL(
					"SELECT * FROM tbl_locatario" + " WHERE" + " pk_id_locatario = '" + pIdLocatario + "'" + ";");

			while (this.getResultSet().next()) {
				locatarioModel.setIdLocatario(this.getResultSet().getInt(1));
				locatarioModel.setNome(this.getResultSet().getString(2));
				locatarioModel.setRua(this.getResultSet().getString(3));
				locatarioModel.setNumero(this.getResultSet().getString(4));
				locatarioModel.setBairro(this.getResultSet().getString(5));
				locatarioModel.setCidade(this.getResultSet().getString(6));
				locatarioModel.setUf(this.getResultSet().getString(7));
				locatarioModel.setCep(this.getResultSet().getString(8));
				locatarioModel.setTelefone(this.getResultSet().getString(9));
				locatarioModel.setEmail(this.getResultSet().getString(10));
				locatarioModel.setStatus(this.getResultSet().getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return locatarioModel;
	}

	@Override
	public LocatarioModel getLocatarioDAO(String pLocatarioModel) {
		LocatarioModel locatarioModel = new LocatarioModel();
		try {
			this.conectar();
			this.executarSQL(
					"SELECT * FROM tbl_locatario" + " WHERE" + " locatario_nome = '" + pLocatarioModel + "'" + ";");

			while (this.getResultSet().next()) {
				locatarioModel.setIdLocatario(this.getResultSet().getInt(1));
				locatarioModel.setNome(this.getResultSet().getString(2));
				locatarioModel.setRua(this.getResultSet().getString(3));
				locatarioModel.setNumero(this.getResultSet().getString(4));
				locatarioModel.setBairro(this.getResultSet().getString(5));
				locatarioModel.setCidade(this.getResultSet().getString(6));
				locatarioModel.setUf(this.getResultSet().getString(7));
				locatarioModel.setCep(this.getResultSet().getString(8));
				locatarioModel.setTelefone(this.getResultSet().getString(9));
				locatarioModel.setEmail(this.getResultSet().getString(10));
				locatarioModel.setStatus(this.getResultSet().getString(11));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return locatarioModel;
	}

	@Override
	public ArrayList<LocatarioModel> getListaLocatarioDAO() {
		ArrayList<LocatarioModel> listaLocatarioModel = new ArrayList<>();
		LocatarioModel locatarioModel = new LocatarioModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM tbl_locatario");

			while (this.getResultSet().next()) {
				locatarioModel = new LocatarioModel();
				locatarioModel.setIdLocatario(this.getResultSet().getInt(1));
				locatarioModel.setNome(this.getResultSet().getString(2));
				locatarioModel.setRua(this.getResultSet().getString(3));
				locatarioModel.setNumero(this.getResultSet().getString(4));
				locatarioModel.setBairro(this.getResultSet().getString(5));
				locatarioModel.setCidade(this.getResultSet().getString(6));
				locatarioModel.setUf(this.getResultSet().getString(7));
				locatarioModel.setCep(this.getResultSet().getString(8));
				locatarioModel.setTelefone(this.getResultSet().getString(9));
				locatarioModel.setEmail(this.getResultSet().getString(10));
				locatarioModel.setStatus(this.getResultSet().getString(11));
				listaLocatarioModel.add(locatarioModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listaLocatarioModel;
	}

	@Override
	public boolean atualizarLocatarioDAO(LocatarioModel pLocatarioModel) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE tbl_locatario SET " + "pk_id_locatario = '"
					+ pLocatarioModel.getIdLocatario() + "'," + "locatario_nome = '" + pLocatarioModel.getNome() + "',"
					+ "locatario_rua = '" + pLocatarioModel.getRua() + "'," + "locatario_numero = '"
					+ pLocatarioModel.getNumero() + "'," + "locatario_bairro = '" + pLocatarioModel.getBairro() + "',"
					+ "locatario_cidade = '" + pLocatarioModel.getCidade() + "'," + "locatario_uf = '"
					+ pLocatarioModel.getUf() + "'," + "locatario_cep = '" + pLocatarioModel.getCep() + "',"
					+ "locatario_telefone = '" + pLocatarioModel.getTelefone() + "'," + "locatario_email ='"
					+ pLocatarioModel.getEmail() + "'," + "locatario_status ='" + pLocatarioModel.getStatus() + "'"
					+ " WHERE " + "pk_id_locatario = '" + pLocatarioModel.getIdLocatario() + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	@Override
	public boolean excluirLocatarioDAO(int idLocatarioModel) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL(
					"DELETE FROM tbl_locatario " + " WHERE " + "pk_id_locatario = '" + idLocatarioModel + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

}
