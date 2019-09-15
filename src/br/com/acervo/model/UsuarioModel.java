package br.com.acervo.model;

/**
 *
 * @author joseluiz
 */
public class UsuarioModel {

	private int idUsuario;
	private String usuNome;
	private String usuLogin;
	private String usuSenha;
	private String usuTipo;
	private int usuQuantidade;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuNome() {
		return usuNome;
	}

	public void setUsuNome(String usuNome) {
		this.usuNome = usuNome;
	}

	public String getUsuLogin() {
		return usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuSenha() {
		return usuSenha;
	}

	public void setUsuSenha(String usuSenha) {
		this.usuSenha = usuSenha;
	}

	public String getUsuTipo() {
		return usuTipo;
	}

	public void setUsuTipo(String usuTipo) {
		this.usuTipo = usuTipo;
	}

	public int getUsuQuantidade() {
		return usuQuantidade;
	}

	public void setUsuQuantidade(int usuQuantidade) {
		this.usuQuantidade = usuQuantidade;
	}

	@Override
	public String toString() {
		return "UsuarioModel{" + "idUsuario=" + idUsuario + ", usuNome=" + usuNome + ", usuLogin=" + usuLogin
				+ ", usuSenha=" + usuSenha + ", usuTipo=" + usuTipo + ", usuQuantidade=" + usuQuantidade + '}';
	}

}
