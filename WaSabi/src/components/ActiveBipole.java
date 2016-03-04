package components;

import constants.Waveform;

public class ActiveBipole {
	private Waveform wave;
	private int node1;
	private int node2;

	public Waveform getWaveform() {
		return wave;
	}

	public int getNode1() {
		return node1;
	}

	public int getNode2() {
		return node2;
	}

	public ActiveBipole(Waveform wave, int node1, int node2)
	{
		this.wave = wave;
		this.node1 = node1 + 1;
		this.node2 = node2 + 1;
	}

	public boolean isParallel(int n1, int n2) {
		return (node1 == (n1 + 1) && node2 == (n2 + 1) || node1 == (n2 + 1) && node2 == (n1 + 1));
	}

	public String toSPICE(String type, int i)
	{
		return type.toUpperCase() + i + " " + node1 + " " + node2 + " " + wave.toSPICE();
	}
	
	public String toConsole(String type)
	{
		return type + "\tat [" + node1 + ", " + node2 + "]\t" + wave.toConsole();
	}

}
