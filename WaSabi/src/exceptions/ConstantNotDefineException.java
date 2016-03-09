package exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Class for a ConstantNotDefinedException. Covers the case when a constant is used but not declared.
 *
 */
@SuppressWarnings("serial")
public class ConstantNotDefineException extends SemanticException {

	/**
	 * Constructor for a ConstantNotDefinedException class.
	 * @param token The token containing all the info about the error (such as the line).
	 */
	public ConstantNotDefineException(Token token) {
		super(token, "The constant '" + token.getText() + "' used in line " + token.getLine() + " isn't defined.");
	}

}
