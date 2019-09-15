package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.LocadorModel;

/**
 *
 * @author joseluiz
 */
public class LocadorDao extends AcervoConnectionMySql implements ILocadorDao {

	@Override
	public int salvarLocadorDAO(LocadorModel pLocadorModel) {
		try {
			this.conectar();
			return this.insertSQL("INSERT INTO tbl_locador (" + "locador_nome," + "locador_rua," + "locador_numero,"
					+ "locador_bairro," + "locador_cidade," + "locador_uf," + "locador_cep," + "locador_telefone,"
					+ "locador_email" + ") VALUES (" + "'" + pLocadorModel.getNome() + "'," + "'"
					+ pLocadorModel.getRua() + "'," + "'" + pLocadorModel.getNumero() + "'," + "'"
					+ pLocadorModel.getBairro() + "'," + "'" + pLocadorModel.getCidade() + "'," + "'"
					+ pLocadorModel.getUf() + "'," + "'" + pLocadorModel.getCep() + "'," + "'"
					+ pLocadorModel.getTelefone() + "'," + "'" + pLocadorModel.getEmail() + "'" + ");");
		} catch (Exception e) {
			return 0;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 *
	 * @param pIdLocador
	 * @return
	 */
	@Override
	public LocadorModel getLocadorDAO(int pIdLocador) {
		LocadorModel locadorModel = new LocadorModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM tbl_locador" + " WHERE" + " pk_id_locador = '" + pIdLocador + "'" + ";");

			while (this.getResultSet().next()) {
				locadorModel.setIdLocador(this.getResultSet().getInt(1));
				locadorModel.setNome(this.getResultSet().getString(2));
				locadorModel.setRua(this.getResultSet().getString(3));
				locadorModel.setNumero(this.getResultSet().getString(4));
				locadorModel.setBairro(this.getResultSet().getString(5));
				locadorModel.setCidade(this.getResultSet().getString(6));
				locadorModel.setUf(this.getResultSet().getString(7));
				locadorModel.setCep(this.getResultSet().getString(8));
				locadorModel.setTelefone(this.getResultSet().getString(9));
				locadorModel.setEmail(this.getResultSet().getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return locadorModel;
	}

	@Override
	public LocadorModel getLocadorDAO(String pLocadorModel) {
		LocadorModel locadorModel = new LocadorModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM tbl_locador" + " WHERE" + " locador_nome = '" + pLocadorModel + "'" + ";");

			while (this.getResultSet().next()) {
				locadorModel.setIdLocador(this.getResultSet().getInt(1));
				locadorModel.setNome(this.getResultSet().getString(2));
				locadorModel.setRua(this.getResultSet().getString(3));
				locadorModel.setNumero(this.getResultSet().getString(4));
				locadorModel.setBairro(this.getResultSet().getString(5));
				locadorModel.setCidade(this.getResultSet().getString(6));
				locadorModel.setUf(this.getResultSet().getString(7));
				locadorModel.setCep(this.getResultSet().getString(8));
				locadorModel.setTelefone(this.getResultSet().getString(9));
				locadorModel.setEmail(this.getResultSet().getString(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return locadorModel;
	}

	@Override
	public ArrayList<LocadorModel> getListaLocadorDAO() {
		ArrayList<LocadorModel> listaLocadorModel = new ArrayList<>();
		LocadorModel locadorModel = new LocadorModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM tbl_locador;");

			while (this.getResultSet().next()) {
				locadorModel = new LocadorModel();
				locadorModel.setIdLocador(this.getResultSet().getInt(1));
				locadorModel.setNome(this.getResultSet().getString(2));
				locadorModel.setRua(this.getResultSet().getString(3));
				locadorModel.setNumero(this.getResultSet().getString(4));
				locadorModel.setBairro(this.getResultSet().getString(5));
				locadorModel.setCidade(this.getResultSet().getString(6));
				locadorModel.setUf(this.getResultSet().getString(7));
				locadorModel.setCep(this.getResultSet().getString(8));
				locadorModel.setTelefone(this.getResultSet().getString(9));
				locadorModel.setEmail(this.getResultSet().getString(10));
				listaLocadorModel.add(locadorModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.fecharConexao();
		}
		return listaLocadorModel;
	}

	@Override
	public boolean atualizarLocadorDAO(LocadorModel pLocadorModel) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE tbl_locador SET " + "pk_id_locador = '"
					+ pLocadorModel.getIdLocador() + "'," + "locador_nome = '" + pLocadorModel.getNome() + "',"
					+ "locador_rua = '" + pLocadorModel.getRua() + "'," + "locador_numero = '"
					+ pLocadorModel.getNumero() + "'," + "locador_bairro = '" + pLocadorModel.getBairro() + "',"
					+ "locador_cidade = '" + pLocadorModel.getCidade() + "'," + "locador_uf = '" + pLocadorModel.getUf()
					+ "'," + "locador_cep = '" + pLocadorModel.getCep() + "'," + "locador_telefone = '"
					+ pLocadorModel.getTelefone() + "'," + "locador_email ='" + pLocadorModel.getEmail() + "'"
					+ " WHERE " + "pk_id_locador = '" + pLocadorModel.getIdLocador() + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	@Override
	public boolean excluirLocadorDAO(int idLocadorModel) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL(
					"DELETE FROM tbl_locador " + " WHERE " + "pk_id_locador = '" + idLocadorModel + "'" + ";");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			this.fecharConexao();
		}
	}

}
