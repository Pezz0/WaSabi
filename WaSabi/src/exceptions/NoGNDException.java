package exceptions;

@SuppressWarnings("serial")
public class NoGNDException extends SemanticException {

	public NoGNDException() {
		super(null, "The circuit is missing a GND reference");
	}

}
