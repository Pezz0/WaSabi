package constants;

public class Waveform {

	private boolean type;
	private String mag;
	private String phase;

	public Waveform(String mag)
	{
		type = true;
		this.mag = mag;
	}

	public Waveform(String mag, String phase)
	{
		type = false;
		this.mag = mag;
		this.phase = phase;
	}

	public boolean isDC() {
		return type;
	}

	public boolean isAC() {
		return !type;
	}

	public String getMagnitude() {
		return mag;
	}

	public String getPhase() {
		return phase;
	}

	public String toSPICE() {
		if (isDC())
			return "DC " + mag + "";
		else
			return "AC " + mag + " " + phase;

	}

	public String toConsole() {
		if (isDC())
			return "DC waveform with magnitude " + mag;
		else
			return "AC waveform with magnitude " + mag + " and phase " + phase;
	}
}
