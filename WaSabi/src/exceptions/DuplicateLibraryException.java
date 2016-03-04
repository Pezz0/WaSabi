package exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class DuplicateLibraryException extends SemanticException {

	public String getPath() {
		return getToken().getText();
	}

	public DuplicateLibraryException(Token token, String path) {
		super(token, "The library '" + token.getText() + "' at line " + token.getLine() + " is already imported");
	
	}

}
