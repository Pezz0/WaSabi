package exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Base class for all the semantic errors exceptions.
 *
 */
@SuppressWarnings("serial")
public class SemanticException extends Exception {

	/**
	 * Stores the error message and all the data from the error (such as the line where the error occurred).
	 */
	private Token token;

	/**
	 * Getter function for the token.
	 * @return The token of the exception.
	 */
	public Token getToken() {
		return token;
	}

	/**
	 * Constructor for a SemanticException class.
	 * @param token The token containing all the info about the error (such as the line).
	 * @param msg The error message displayed when the exception is thrown.
	 */
	public SemanticException(Token token,String msg)
	{
		super(msg);
		this.token = token;
	}

}
