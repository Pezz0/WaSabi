package exceptions;

import org.antlr.v4.runtime.Token;

@SuppressWarnings("serial")
public class WrongTypeConstantException extends SemanticException {

	private static String intToType(int type) {
		if (type == 0)
			return "model type";
		else if (type == 1)
			return "value";
		else
			return "waveform";
	}

	private int wanted;
	private int used;

	public String getWanted() {
		return intToType(wanted);
	}

	public String getUsed() {
		return intToType(used);
	}

	public WrongTypeConstantException(Token token, int wanted, int used) {
		super(token, "The constant " + token.getText() + " at line " + token.getLine() + " is a " + intToType(used) + " but is used as a "
				+ intToType(wanted));
		this.wanted = wanted;
		this.used = used;
	}
}
