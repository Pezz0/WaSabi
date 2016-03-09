package exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Class for a ZeroValueException. Covers the case when a value is 0.
 *
 */
@SuppressWarnings("serial")
public class ZeroValueException extends SemanticException {

	/**
	 * Constructor for a ZeroValueException class.
	 * @param token The token containing all the info about the error (such as the line).
	 */
	public ZeroValueException(Token token) {
		super(token, "The value for the basic component at line " + token.getLine()+ " cannot be zero.");
	}

}
