package exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Class for a ConstSameNameException. Covers the case when a constant is declared twice.
 *
 */
@SuppressWarnings("serial")
public class ConstSameNameException extends SemanticException {

	/**
	 * Getter function for the name of the constant declared twice.
	 * @return The name of the constant already declared.
	 */
	public String getName() {
		return getToken().getText();
	}

	/**
	 * Constructor for a ConstSameNameException class.
	 * @param token The token containing all the info about the error (such as the line).
	 */
	public ConstSameNameException(Token token) {
		super(token, "Constant '" + token.getText() + "' at line " + token.getLine() + " is already defined.");
	}

}
