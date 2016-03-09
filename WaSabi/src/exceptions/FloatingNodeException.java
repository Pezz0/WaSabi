package exceptions;

/**
 * Class for a FloatingNodeException. Covers the case when a node is only used once.
 *
 */
@SuppressWarnings("serial")
public class FloatingNodeException extends SemanticException {

	/**
	 * Constructor for a FloatingNodeException class.
	 * @param node The name of the floating node.
	 */
	public FloatingNodeException(String node) {
		super(null, "The node '" + node + "' is used only one time, it should be used at least two times.");

	}

}
