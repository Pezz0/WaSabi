package exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class ZeroValueException extends SemanticException {

	public ZeroValueException(Token token) {
		super(token, "The value for the basic component at line " + token.getLine()+ " is zero and that cannot be zero");
	}

}
