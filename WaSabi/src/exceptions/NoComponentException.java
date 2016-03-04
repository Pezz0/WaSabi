package exceptions;

@SuppressWarnings("serial")
public class NoComponentException extends SemanticException {

	public NoComponentException() {
		super(null, "The circuit must have at least a component");
	}

}
