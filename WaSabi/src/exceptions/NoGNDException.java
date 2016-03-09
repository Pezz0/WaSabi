package exceptions;

/**
 * Class for a NoGNDException. Covers the case when there is no GND reference in the circuit.
 *
 */
@SuppressWarnings("serial")
public class NoGNDException extends SemanticException {

	/**
	 * Constructor for a NoGNDException class.
	 */
	public NoGNDException() {
		super(null, "The circuit is missing a GND reference");
	}

}
