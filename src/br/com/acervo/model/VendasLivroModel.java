package br.com.acervo.model;

/**
 *
 * @author Jose Luiz
 */
public class VendasLivroModel {

	private int idVendaLivro;
	private int livro;
	private int vendas;
	private double vendasLivroValor;
	private int venLivroQuantidade;

	/**
	 * Construtor
	 */
	public VendasLivroModel() {
	}

	/**
	 * seta o valor de idVendaLivro
	 *
	 * @param pIdVendaProduto
	 */
	public void setIdVendaLivro(int pIdVendaProduto) {
		this.idVendaLivro = pIdVendaProduto;
	}

	/**
	 * return idVendaLivro
	 * 
	 * @return
	 */
	public int getIdVendaLivro() {
		return this.idVendaLivro;
	}

	/**
	 * seta o valor de livro
	 *
	 * @param pProduto
	 */
	public void setLivro(int pProduto) {
		this.livro = pProduto;
	}

	/**
	 * return livro
	 * 
	 * @return
	 */
	public int getLivro() {
		return this.livro;
	}

	/**
	 * seta o valor de vendas
	 *
	 * @param pVendas
	 */
	public void setVendas(int pVendas) {
		this.vendas = pVendas;
	}

	/**
	 * return vendas
	 * 
	 * @return
	 */
	public int getVendas() {
		return this.vendas;
	}

	/**
	 * seta o valor de vendasLivroValor
	 *
	 * @param pVendasProValor
	 */
	public void setVendasLivroValor(double pVendasProValor) {
		this.vendasLivroValor = pVendasProValor;
	}

	/**
	 * return vendasLivroValor
	 * 
	 * @return
	 */
	public double getVendasLivroValor() {
		return this.vendasLivroValor;
	}

	/**
	 * seta o valor de venLivroQuantidade
	 *
	 * @param pVenProQuantidade
	 */
	public void setVenLivroQuantidade(int pVenProQuantidade) {
		this.venLivroQuantidade = pVenProQuantidade;
	}

	/**
	 * return venLivroQuantidade
	 * 
	 * @return
	 */
	public int getVenLivroQuantidade() {
		return this.venLivroQuantidade;
	}

	@Override
	public String toString() {
		return "ModelVendasProdutos {" + "::idVendaProduto = " + this.idVendaLivro + "::produto = " + this.livro
				+ "::vendas = " + this.vendas + "::vendasProValor = " + this.vendasLivroValor + "::venProQuantidade = "
				+ this.venLivroQuantidade + "}";
	}
}
