package br.com.acervo.model;

/**
 *
 * @author joseluiz
 */
public class VendasModel {

	private int idVenda;
	private int cliente;
	private String venDataVenda;
	private double venValorLiquido;
	private double venValorBruto;
	private double venDesconto;
	private int quantidadeVendas;
	private int quantidadeLivrosVendidos;
	private double valorTotal;

	/**
	 * seta o valor de idVenda
	 *
	 * @param pIdVenda
	 */
	public void setIdVenda(int pIdVenda) {
		this.idVenda = pIdVenda;
	}

	/**
	 * return pk_idVenda
	 *
	 * @return
	 */
	public int getIdVenda() {
		return this.idVenda;
	}

	/**
	 * seta o valor de cliente
	 *
	 * @param pCliente
	 */
	public void setCliente(int pCliente) {
		this.cliente = pCliente;
	}

	/**
	 * return fk_cliente
	 *
	 * @return
	 */
	public int getCliente() {
		return this.cliente;
	}

	/**
	 * seta o valor de venDataVenda
	 *
	 * @param pVenDataVenda
	 */
	public void setVenDataVenda(String pVenDataVenda) {
		this.venDataVenda = pVenDataVenda;
	}

	/**
	 * return venDataVenda
	 *
	 * @return
	 */
	public String getVenDataVenda() {
		return this.venDataVenda;
	}

	/**
	 * seta o valor de venValorLiquido
	 *
	 * @param pVenValorLiquido
	 */
	public void setVenValorLiquido(double pVenValorLiquido) {
		this.venValorLiquido = pVenValorLiquido;
	}

	/**
	 * return venValorLiquido
	 *
	 * @return
	 */
	public double getVenValorLiquido() {
		return this.venValorLiquido;
	}

	/**
	 * seta o valor de venValorBruto
	 *
	 * @param pVenValorBruto
	 */
	public void setVenValorBruto(double pVenValorBruto) {
		this.venValorBruto = pVenValorBruto;
	}

	/**
	 * return venValorBruto
	 *
	 * @return
	 */
	public double getVenValorBruto() {
		return this.venValorBruto;
	}

	/**
	 * seta o valor de venDesconto
	 *
	 * @param pVenDesconto
	 */
	public void setVenDesconto(double pVenDesconto) {
		this.venDesconto = pVenDesconto;
	}

	/**
	 * return venDesconto
	 *
	 * @return
	 */
	public double getVenDesconto() {
		return this.venDesconto;
	}

	/**
	 * 
	 * @return
	 */
	public int getQuantidadeVendas() {
		return quantidadeVendas;
	}

	/**
	 * 
	 * @param quantidadeVendas
	 */
	public void setQuantidadeVendas(int quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	/**
	 * 
	 * @return
	 */
	public int getQuantidadeLivrosVendidos() {
		return quantidadeLivrosVendidos;
	}

	/**
	 * 
	 * @param quantidadeLivrosVendidos
	 */
	public void setQuantidadeLivrosVendidos(int quantidadeLivrosVendidos) {
		this.quantidadeLivrosVendidos = quantidadeLivrosVendidos;
	}

	/**
	 * 
	 * @return
	 */
	public double getValorTotal() {
		return valorTotal;
	}

	/**
	 * 
	 * @param valorTotal
	 */
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "VendasModel [idVenda=" + idVenda + ", cliente=" + cliente + ", venDataVenda=" + venDataVenda
				+ ", venValorLiquido=" + venValorLiquido + ", venValorBruto=" + venValorBruto + ", venDesconto="
				+ venDesconto + ", quantidadeVendas=" + quantidadeVendas + ", quantidadeLivrosVendidos="
				+ quantidadeLivrosVendidos + ", valorTotal=" + valorTotal + "]";
	}

}
