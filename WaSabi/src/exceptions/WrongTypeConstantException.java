package exceptions;

import org.antlr.v4.runtime.Token;

/**
 * Class for a WrongTypeConstantException. Covers the case when the wrong type of constant is used (for example using a model in a voltage source declaration).
 *
 */
@SuppressWarnings("serial")
public class WrongTypeConstantException extends SemanticException {

	/**
	 * Support function to translate the ID of the type into a string.
	 * @param type The type ID of the constant. 
	 * @return The string describing the type of the constant.
	 */
	private static String intToType(int type) {
		if (type == 0)
			return "model type";
		else if (type == 1)
			return "value";
		else
			return "waveform";
	}

	/**
	 * Stores the ID of the type that needed to be used.
	 */
	private int wanted;
	/**
	 * Stores the ID of the type that has actually been used.
	 */
	private int used;

	/**
	 * Getter function for the wanted type.
	 * @return The ID of the type that needed to be used.
	 */
	public String getWanted() {
		return intToType(wanted);
	}

	/**
	 * Getter function for the used type.
	 * @return The ID of the type that has actually been used.
	 */
	public String getUsed() {
		return intToType(used);
	}

	/**
	 * Constructor for a WrongTypeConstantException class
	 * @param token The token containing all the info about the error (such as the line).
	 * @param wanted The ID of the type that needed to be used.
	 * @param used The ID of the type that has actually been used.
	 */
	public WrongTypeConstantException(Token token, int wanted, int used) {
		super(token, "The constant " + token.getText() + " at line " + token.getLine() + " is a " + intToType(used) + " but is used as a "
				+ intToType(wanted));
		this.wanted = wanted;
		this.used = used;
	}
}
