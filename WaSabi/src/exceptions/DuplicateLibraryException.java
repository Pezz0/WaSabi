package exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Class for a DuplicateLibraryException. Covers the case when a library is declared twice.
 *
 */
@SuppressWarnings("serial")
public class DuplicateLibraryException extends SemanticException {

	/**
	 * Getter function for the path of the library declared twice.
	 * @return The path of the library already declared.
	 */
	public String getPath() {
		return getToken().getText();
	}

	/**
	 * Constructor for a DuplicateLibraryException class.
	 * @param token The token containing all the info about the error (such as the line).
	 */
	public DuplicateLibraryException(Token token, String path) {
		super(token, "The library '" + token.getText() + "' at line " + token.getLine() + " is already imported.");
	
	}

}
