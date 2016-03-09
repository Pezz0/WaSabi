package exceptions;

/**
 * Class for a NoComponentException. Covers the case when there is no component declared.
 *
 */
@SuppressWarnings("serial")
public class NoComponentException extends SemanticException {

	/**
	 * Constructor for a NoComponentException class.
	 * @param token The token containing all the info about the error (such as the line).
	 */
	public NoComponentException() {
		super(null, "The circuit must have at least a component.");
	}

}
