package br.com.acervo.exception;

@SuppressWarnings("serial")
public class VendasException extends Exception {

	public String clientNull() {
		String message = "Não há clientes cadastrados no sistema para serem exibidos!\n";
		return message;
	}

	public String bookNull() {
		String message = "Não há livros à venda disponíveis para serem exibidos!\n";
		return message;
	}

	public String messageDefault() {
		String message = "A janela não será exibida corretamente, enquanto o erro acima não for solucionado";
		return message;
	}

	public String bookItensNull() {
		String erro = "Você deve inserir a quantidade de livros!\n";
		return erro;
	}

	public String erroSaleBook() {
		String erro = "Erro ao salvar a venda!\n";
		return erro;
	}

	public String erroSaveBookSale() {
		String erro = "Erro ao salvar os livros da venda realizada!\n";
		return erro;
	}

	public String erroDeleteSale() {
		String erro = "Erro ao excluir a venda!\n";
		return erro;
	}
}
