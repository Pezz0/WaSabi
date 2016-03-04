package exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class ConstSameNameException extends SemanticException {

	public String getName() {
		return getToken().getText();
	}

	public ConstSameNameException(Token token) {
		super(token, "Constant '" + token.getText() + "' at line " + token.getLine() + " is already defined");
	}

}
