package constants;

/**
 * Base class for a waveform.
 *
 */
public class Waveform {

	/**
	 * Stores the type of the waveform (DC or AC)
	 */
	private boolean type;
	/**
	 * Stores the magnitude of the waveform.
	 */
	private String mag;
	/**
	 * Stores the phase of the waveform.
	 */
	private String phase;

	/**
	 * Constructor for the waveform class.
	 * @param mag The magnitude of the waveform.
	 */
	public Waveform(String mag)
	{
		type = true;
		this.mag = mag;
	}

	/**
	 * Constructor for the waveform class.
	 * @param mag The magnitude of the waveform.
	 * @param phase The phase of the waveform.
	 */
	public Waveform(String mag, String phase)
	{
		type = false;
		this.mag = mag;
		this.phase = phase;
	}

	/**
	 * Checks if the instance is a DC waveform.
	 * @return True if this instance is a DC waveform.
	 */
	public boolean isDC() {
		return type;
	}

	/**
	 * Checks if the instance is an AC waveform.
	 * @return True if this instance is an AC waveform.
	 */
	public boolean isAC() {
		return !type;
	}

	/**
	 * Getter function for the magnitude.
	 * @return The magnitude of the waveform.
	 */
	public String getMagnitude() {
		return mag;
	}

	/**
	 * Getter function for the phase.
	 * @return The phase of the waveform.
	 */
	public String getPhase() {
		return phase;
	}

	/**
	 * Creates a SPICE-formatted waveform. 
	 * @return A SPICE-formatted waveform.
	 */
	public String toSPICE() {
		if (isDC())
			return "DC " + mag + "";
		else
			return "AC " + mag + " " + phase;

	}

	/**
	 * Creates a console-formatted waveform. 
	 * @return A SPICE-formatted waveform.
	 */
	public String toConsole() {
		if (isDC())
			return "DC waveform with magnitude " + mag;
		else
			return "AC waveform with magnitude " + mag + " and phase " + phase;
	}
}
