package exceptions;

/**
 * Class for a FloatingNodeException. Covers the case when a node is only used once.
 *
 */
@SuppressWarnings("serial")
public class FloatingNodeException extends SemanticException {

	/**
	 * Constructor for a FloatingNodeException class.
	 * @param token The token containing all the info about the error (such as the line).
	 */
	public FloatingNodeException(String node) {
		super(null, "The node '" + node + "' is used only one time, it should be used at least two times.");

	}

}
