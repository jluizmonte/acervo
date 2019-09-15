package br.com.acervo.model;

/**
 *
 * @author joseluiz
 */
public class EmprestimoLivroModel {

	private int idEmprestimoLivro;
	private int livro;
	private int emprestimo;
	private int quantidadeEmprestimo;

	public int getIdEmprestimoLivro() {
		return idEmprestimoLivro;
	}

	public void setIdEmprestimoLivro(int idEmprestimoLivro) {
		this.idEmprestimoLivro = idEmprestimoLivro;
	}

	public int getLivro() {
		return livro;
	}

	public void setLivro(int livro) {
		this.livro = livro;
	}

	public int getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(int emprestimo) {
		this.emprestimo = emprestimo;
	}

	public int getQuantidadeEmprestimo() {
		return quantidadeEmprestimo;
	}

	public void setQuantidadeEmprestimo(int quantidadeEmprestimo) {
		this.quantidadeEmprestimo = quantidadeEmprestimo;
	}

	@Override
	public String toString() {
		return "EmprestimoLivroModel{" + "idEmprestimoLivro=" + idEmprestimoLivro + ", livro=" + livro + ", emprestimo="
				+ emprestimo + ", quantidadeEmprestimo=" + quantidadeEmprestimo + '}';
	}

}
