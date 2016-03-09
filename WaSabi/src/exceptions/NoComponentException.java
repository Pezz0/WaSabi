package exceptions;

/**
 * Class for a NoComponentException. Covers the case when there is no component declared.
 *
 */
@SuppressWarnings("serial")
public class NoComponentException extends SemanticException {

	/**
	 * Constructor for a NoComponentException class.
	 */
	public NoComponentException() {
		super(null, "The circuit must have at least a component.");
	}

}
