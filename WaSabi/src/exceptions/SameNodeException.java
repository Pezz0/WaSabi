package exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class SameNodeException extends SemanticException {

	public SameNodeException(Token token) {
		super(token, "The bipole at line " + token.getLine() + " is ignored because is short circuited");
	}

}
