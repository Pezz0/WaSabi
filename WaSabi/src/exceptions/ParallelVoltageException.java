package exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class ParallelVoltageException extends SemanticException {

	public ParallelVoltageException(Token token) {
		super(token, "The generator at line " + token.getLine() + " is in parallel with another voltage generator");
	}

}
