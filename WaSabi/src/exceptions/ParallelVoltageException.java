package exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Class for a ParallelVoltageException. Covers the case when two voltage sources are connected in parallel.
 *
 */
@SuppressWarnings("serial")
public class ParallelVoltageException extends SemanticException {

	/**
	 * Constructor for a ParallelVoltageException class.
	 * @param token The token containing all the info about the error (such as the line).
	 */
	public ParallelVoltageException(Token token) {
		super(token, "The generator at line " + token.getLine() + " is in parallel with another voltage generator");
	}

}
