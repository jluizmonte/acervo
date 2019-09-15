package br.com.acervo.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.acervo.connection.AcervoConnectionMySql;
import br.com.acervo.model.UsuarioModel;

/**
 * implementação da interface I*DAO extensão da classe de conexão com o Banco de
 * dados
 *
 * @author Jose Luiz
 */
public class UsuarioDao extends AcervoConnectionMySql implements IUsuarioDao {

	/**
	 * salva Usuario
	 *
	 * @param pUsuarioModel
	 * @return
	 */
	@Override
	public int salvarUsuarioDAO(UsuarioModel pUsuarioModel) {
		try {
			this.conectar();
			return this.insertSQL("INSERT INTO tbl_usuario (" + "usu_nome," + "usu_login," + "usu_senha ," + "usu_tipo"
					+ ") VALUES (" + "'" + pUsuarioModel.getUsuNome() + "'," + "'" + pUsuarioModel.getUsuLogin() + "',"
					+ "'" + pUsuarioModel.getUsuSenha() + "'," + "'" + pUsuarioModel.getUsuTipo() + "'" + ");");
		} catch (Exception e) {
			return 0;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * recupera Usuario
	 *
	 * @param pIdUsuario return ModelUsuario
	 * @return
	 */
	@Override
	public UsuarioModel getUsuarioDAO(int pIdUsuario) {
		UsuarioModel usuarioModel = new UsuarioModel();
		try {
			this.conectar();
			this.executarSQL("SELECT " + "pk_id_usuario," + "usu_nome," + "usu_login," + "usu_senha," + "usu_tipo"
					+ " FROM" + " tbl_usuario" + " WHERE" + " pk_id_usuario = '" + pIdUsuario + "'" + ";");

			while (this.getResultSet().next()) {
				usuarioModel.setIdUsuario(this.getResultSet().getInt(1));
				usuarioModel.setUsuNome(this.getResultSet().getString(2));
				usuarioModel.setUsuLogin(this.getResultSet().getString(3));
				usuarioModel.setUsuSenha(this.getResultSet().getString(4));
				usuarioModel.setUsuTipo(this.getResultSet().getString(5));
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return usuarioModel;
	}

	/**
	 * recupera Usuario
	 *
	 * @param pLogin return ModelUsuario
	 * @return
	 */
	@Override
	public UsuarioModel getUsuarioDAO(String pLogin) {
		UsuarioModel usuarioModel = new UsuarioModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM" + " tbl_usuario" + " WHERE" + " usu_login = '" + pLogin + "'" + ";");

			while (this.getResultSet().next()) {
				usuarioModel.setIdUsuario(this.getResultSet().getInt(1));
				usuarioModel.setUsuNome(this.getResultSet().getString(2));
				usuarioModel.setUsuLogin(this.getResultSet().getString(3));
				usuarioModel.setUsuSenha(this.getResultSet().getString(4));
				usuarioModel.setUsuTipo(this.getResultSet().getString(5));
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return usuarioModel;
	}

	/**
	 * recupera uma lista de Usuario return ArrayList
	 *
	 * @return
	 */
	@Override
	public ArrayList<UsuarioModel> getListaUsuarioDAO() {
		ArrayList<UsuarioModel> listaUsuarioModel = new ArrayList<>();
		UsuarioModel usuarioModel = new UsuarioModel();
		try {
			this.conectar();
			this.executarSQL("SELECT * FROM tbl_usuario;");

			while (this.getResultSet().next()) {
				usuarioModel = new UsuarioModel();
				usuarioModel.setIdUsuario(this.getResultSet().getInt(1));
				usuarioModel.setUsuNome(this.getResultSet().getString(2));
				usuarioModel.setUsuLogin(this.getResultSet().getString(3));
				usuarioModel.setUsuSenha(this.getResultSet().getString(4));
				usuarioModel.setUsuTipo(this.getResultSet().getString(5));
				listaUsuarioModel.add(usuarioModel);
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return listaUsuarioModel;
	}

	/**
	 * atualiza Usuario
	 *
	 * @param pUsuarioModel return boolean
	 * @return
	 */
	@Override
	public boolean atualizarUsuarioDAO(UsuarioModel pUsuarioModel) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL("UPDATE tbl_usuario SET " + "pk_id_usuario = '"
					+ pUsuarioModel.getIdUsuario() + "'," + "usu_nome = '" + pUsuarioModel.getUsuNome() + "',"
					+ "usu_login = '" + pUsuarioModel.getUsuLogin() + "'," + "usu_senha = '"
					+ pUsuarioModel.getUsuSenha() + "," + "usu_tipo = '" + pUsuarioModel.getUsuTipo() + "'" + " WHERE "
					+ "pk_id_usuario = '" + pUsuarioModel.getIdUsuario() + "'" + ";");
		} catch (Exception e) {
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * exclui Usuario
	 *
	 * @param pIdUsuario return boolean
	 * @return
	 */
	@Override
	public boolean excluirUsuarioDAO(int pIdUsuario) {
		try {
			this.conectar();
			return this.executarUpdateDeleteSQL(
					"DELETE FROM tbl_usuario " + " WHERE " + "pk_id_usuario = '" + pIdUsuario + "'" + ";");
		} catch (Exception e) {
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * Validar login e senha do usuário
	 *
	 * @param pUsuarioModel
	 * @return
	 */
	@Override
	public boolean getValidarUsuarioDAO(UsuarioModel pUsuarioModel) {
		try {
			this.conectar();
			this.executarSQL("SELECT *" + " FROM" + " tbl_usuario" + " WHERE" + " usu_login = '"
					+ pUsuarioModel.getUsuLogin() + "' AND usu_senha = '" + pUsuarioModel.getUsuSenha() + "'" + ";");

			if (getResultSet().next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		} finally {
			this.fecharConexao();
		}
	}

	/**
	 * busca a quantidade de usuarios cadastrados
	 *
	 * @return
	 */
	@Override
	public UsuarioModel getQuantidadeUsuariosCadastrados() {
		UsuarioModel usuarioModel = new UsuarioModel();
		try {
			this.conectar();
			this.executarSQL("SELECT COUNT(*) FROM tbl_usuario;");

			while (this.getResultSet().next()) {
				usuarioModel.setUsuQuantidade(this.getResultSet().getInt(1));
			}
		} catch (SQLException e) {
		} finally {
			this.fecharConexao();
		}
		return usuarioModel;
	}
}
