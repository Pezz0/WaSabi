package exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class ConstantNotDefineException extends SemanticException {

	public ConstantNotDefineException(Token token) {
		super(token, "The constant '" + token.getText() + "' used in line " + token.getLine() + " isn't defined");
	}

}
