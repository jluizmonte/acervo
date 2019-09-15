package br.com.acervo.model;

/**
 *
 * @author joseluiz
 */
public class EmprestimoModel {

	private int idEmprestimo;
	private int idLocatario;
	private int idLocador;
	private int idLivro;
	private String dataEmprestimo;
	private String dataDevolucao;
	private String status;
	private int quantidadeEmprestimo;

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public int getIdLocatario() {
		return idLocatario;
	}

	public void setIdLocatario(int idLocatario) {
		this.idLocatario = idLocatario;
	}

	public int getIdLocador() {
		return idLocador;
	}

	public void setIdLocador(int idLocador) {
		this.idLocador = idLocador;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantidadeEmprestimo() {
		return quantidadeEmprestimo;
	}

	public void setQuantidadeEmprestimo(int quantidadeEmprestimo) {
		this.quantidadeEmprestimo = quantidadeEmprestimo;
	}

	@Override
	public String toString() {
		return "EmprestimoModel{" + "idEmprestimo=" + idEmprestimo + ", idLocatario=" + idLocatario + ", idLocador="
				+ idLocador + ", idLivro=" + idLivro + ", dataEmprestimo=" + dataEmprestimo
				+ ", dataDevolu\u00e7\u00e3o=" + dataDevolucao + ", status=" + status + ", quantidadeEmprestimo="
				+ quantidadeEmprestimo + '}';
	}

}
