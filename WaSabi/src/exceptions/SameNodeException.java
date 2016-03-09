package exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Class for a SameNodeException. Covers the case when the two ends of a bipole are connected to the same node.
 *
 */
@SuppressWarnings("serial")
public class SameNodeException extends SemanticException {

	/**
	 * Constructor for a SameNodeException class.
	 * @param token The token containing all the info about the error (such as the line).
	 */
	public SameNodeException(Token token) {
		super(token, "The bipole at line " + token.getLine() + " is ignored because is short circuited");
	}

}
