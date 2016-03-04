package exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class SemanticException extends Exception {

	private Token token;

	public Token getToken() {
		return token;
	}

	public SemanticException(Token token,String msg)
	{
		super(msg);
		this.token = token;
	}

}
