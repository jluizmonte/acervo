package br.com.acervo.model;

/**
 *
 * @author Jose Luiz
 */
public class ClienteModel {

	private int idCliente;
	private String cliNome;
	private String cliRua;
	private String cliNumero;
	private String cliBairro;
	private String cliCidade;
	private String cliUf;
	private String cliCep;
	private String cliTelefone;
	private String cliEmail;
	private int quantidadeCliente;

	/**
	 * Construtor
	 */
	public ClienteModel() {
	}

	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * @return the cliNome
	 */
	public String getCliNome() {
		return cliNome;
	}

	/**
	 * @param cliNome the cliNome to set
	 */
	public void setCliNome(String cliNome) {
		this.cliNome = cliNome;
	}

	/**
	 * @return the cliRua
	 */
	public String getCliRua() {
		return cliRua;
	}

	/**
	 * @param cliRua the cliRua to set
	 */
	public void setCliRua(String cliRua) {
		this.cliRua = cliRua;
	}

	/**
	 * @return the cliNumero
	 */
	public String getCliNumero() {
		return cliNumero;
	}

	/**
	 * @param cliNumero the cliNumero to set
	 */
	public void setCliNumero(String cliNumero) {
		this.cliNumero = cliNumero;
	}

	/**
	 * @return the cliBairro
	 */
	public String getCliBairro() {
		return cliBairro;
	}

	/**
	 * @param cliBairro the cliBairro to set
	 */
	public void setCliBairro(String cliBairro) {
		this.cliBairro = cliBairro;
	}

	/**
	 * @return the cliCidade
	 */
	public String getCliCidade() {
		return cliCidade;
	}

	/**
	 * @param cliCidade the cliCidade to set
	 */
	public void setCliCidade(String cliCidade) {
		this.cliCidade = cliCidade;
	}

	/**
	 * @return the cliUf
	 */
	public String getCliUf() {
		return cliUf;
	}

	/**
	 * @param cliUf the cliUf to set
	 */
	public void setCliUf(String cliUf) {
		this.cliUf = cliUf;
	}

	/**
	 * @return the cliCep
	 */
	public String getCliCep() {
		return cliCep;
	}

	/**
	 * @param cliCep the cliCep to set
	 */
	public void setCliCep(String cliCep) {
		this.cliCep = cliCep;
	}

	/**
	 * @return the cliTelefone
	 */
	public String getCliTelefone() {
		return cliTelefone;
	}

	/**
	 * @param cliTelefone the cliTelefone to set
	 */
	public void setCliTelefone(String cliTelefone) {
		this.cliTelefone = cliTelefone;
	}

	/**
	 * @return the cliEmail
	 */
	public String getCliEmail() {
		return cliEmail;
	}

	/**
	 * @param cliEmail the cliEmail to set
	 */
	public void setCliEmail(String cliEmail) {
		this.cliEmail = cliEmail;
	}

	public int getQuantidadeCliente() {
		return quantidadeCliente;
	}

	public void setQuantidadeCliente(int quantidadeCliente) {
		this.quantidadeCliente = quantidadeCliente;
	}

	@Override
	public String toString() {
		return "ClienteModel{" + "idCliente=" + idCliente + ", cliNome=" + cliNome + ", cliRua=" + cliRua
				+ ", cliNumero=" + cliNumero + ", cliBairro=" + cliBairro + ", cliCidade=" + cliCidade + ", cliUf="
				+ cliUf + ", cliCep=" + cliCep + ", cliTelefone=" + cliTelefone + ", cliEmail=" + cliEmail
				+ ", quantidadeCliente=" + quantidadeCliente + '}';
	}

}
