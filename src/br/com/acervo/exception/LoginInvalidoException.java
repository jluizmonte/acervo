package br.com.acervo.exception;

@SuppressWarnings("serial")
public class LoginInvalidoException extends Exception {

	public LoginInvalidoException(String message) {
		super(message);
	}
}
