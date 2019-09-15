package br.com.acervo.model;

/**
 *
 * @author joseluiz
 */
public class LivroModel {

	private int idLivro;
	private String titulo;
	private String autor;
	private int ano;
	private String categoria;
	private String dataCadastro;
	private String observacao;
	private int quantidadeLivro;
	private String tipoLivro;
	private Double livroValorUnitario;

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getQuantidadeLivro() {
		return quantidadeLivro;
	}

	public void setQuantidadeLivro(int quantidadeLivro) {
		this.quantidadeLivro = quantidadeLivro;
	}

	public String getTipoLivro() {
		return tipoLivro;
	}

	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}

	public Double getLivroValorUnitario() {
		return livroValorUnitario;
	}

	public void setLivroValorUnitario(Double livroValorUnitario) {
		this.livroValorUnitario = livroValorUnitario;
	}

	@Override
	public String toString() {
		return "LivroModel{" + "idLivro=" + idLivro + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano
				+ ", categoria=" + categoria + ", dataCadastro=" + dataCadastro + ", observacao=" + observacao
				+ ", quantidadeLivro=" + quantidadeLivro + ", tipoLivro=" + tipoLivro + ", livroValorUnitario="
				+ livroValorUnitario + '}';
	}
}
