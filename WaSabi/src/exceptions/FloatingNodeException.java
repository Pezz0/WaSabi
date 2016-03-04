package exceptions;

@SuppressWarnings("serial")
public class FloatingNodeException extends SemanticException {

	public FloatingNodeException(String node) {
		super(null, "The node '" + node + "' is used only one time, it should be used at least two times");

	}

}
