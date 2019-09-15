package br.com.acervo.model;

/**
 *
 * @author joseluiz
 */
public class AulaModel {

	private int idAula;
	private String tema;
	private String textoBase;
	private String dinamicaUtilizada;
	private String dataAplicacao;
	private String status;
	private String rendimento;
	private String observacoesGerais;
	private String evangelizador;
	private String capituloEvangelho;
	private int quantidadeAula;

	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getTextoBase() {
		return textoBase;
	}

	public void setTextoBase(String textoBase) {
		this.textoBase = textoBase;
	}

	public String getDinamicaUtilizada() {
		return dinamicaUtilizada;
	}

	public void setDinamicaUtilizada(String dinamicaUtilizada) {
		this.dinamicaUtilizada = dinamicaUtilizada;
	}

	public String getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(String dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRendimento() {
		return rendimento;
	}

	public void setRendimento(String rendimento) {
		this.rendimento = rendimento;
	}

	public String getObservacoesGerais() {
		return observacoesGerais;
	}

	public void setObservacoesGerais(String observacoesGerais) {
		this.observacoesGerais = observacoesGerais;
	}

	public String getEvangelizador() {
		return evangelizador;
	}

	public void setEvangelizador(String evangelizador) {
		this.evangelizador = evangelizador;
	}

	public String getCapituloEvangelho() {
		return capituloEvangelho;
	}

	public void setCapituloEvangelho(String capituloEvangelho) {
		this.capituloEvangelho = capituloEvangelho;
	}

	public int getQuantidadeAula() {
		return quantidadeAula;
	}

	public void setQuantidadeAula(int quantidadeAula) {
		this.quantidadeAula = quantidadeAula;
	}

	@Override
	public String toString() {
		return "AulaModel{" + "idAula=" + idAula + ", tema=" + tema + ", textoBase=" + textoBase
				+ ", dinamicaUtilizada=" + dinamicaUtilizada + ", dataAplicacao=" + dataAplicacao + ", status=" + status
				+ ", rendimento=" + rendimento + ", observacoesGerais=" + observacoesGerais + ", evangelizador="
				+ evangelizador + ", capituloEvangelho=" + capituloEvangelho + ", quantidadeAula=" + quantidadeAula
				+ '}';
	}
}
