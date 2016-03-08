package components;

import constants.Waveform;

/**
 * Base class for the active bipoles, such as voltage or current source.
 *
 */
public class ActiveBipole {
	/**
	 * Stores the waveform of the active bipole.
	 */
	private Waveform wave;
	/**
	 * Stores the first node to which the active bipole is connected.
	 */
	private int node1;
	/**
	 * Stores the second node to which the active bipole is connected.
	 */
	private int node2;

	/**
	 * Getter function for the waveform.
	 * @return Returns the waveform of the active bipole.
	 */
	public Waveform getWaveform() {
		return wave;
	}

	/**
	 * Getter function for the first node.
	 * @return Returns the first node to which the active bipole is connected.
	 */
	public int getNode1() {
		return node1;
	}

	/**
	 * Getter function for the second node.
	 * @return Returns the second node to which the active bipole is connected.
	 */
	public int getNode2() {
		return node2;
	}

	/**
	 * Constructor for the ActiveBipole class. Creates a new instance of an {@link ActiveBipole}.
	 * @param wave The waveform of the active bipole.
	 * @param node1 The first node to which the active bipole is connected.
	 * @param node2 The second node to which the active bipole is connected.
	 */
	public ActiveBipole(Waveform wave, int node1, int node2)
	{
		this.wave = wave;
		this.node1 = node1 + 1;
		this.node2 = node2 + 1;
	}

	/**
	 * Returns if this instance of active bipole is parallel to a component connected to the nodes provided as arguments.
	 * @param n1 First node of the parallel connection.
	 * @param n2 Second node of the parallel connection.
	 * @return True if this instance is parallel to the nodes provided.
	 */
	public boolean isParallel(int n1, int n2) {
		return (node1 == (n1 + 1) && node2 == (n2 + 1) || node1 == (n2 + 1) && node2 == (n1 + 1));
	}

	/**
	 * Returns a SPICE-formatted string containing all the data about this instance.
	 * @param type The type of the active bipole (V or I). 
	 * @param i The index that the active bipole will have in SPICE.
	 * @return A SPICE-formatted active bipole.  
	 */
	public String toSPICE(String type, int i)
	{
		return type.toUpperCase() + i + " " + node1 + " " + node2 + " " + wave.toSPICE();
	}
	
	/**
	 * Returns a console-formatted string containing the active bipole informations.
	 * @param type The type of the active bipole (V or I). 
	 * @return A console-formatted active bipole. 
	 */
	public String toConsole(String type)
	{
		return type + "\tat [" + node1 + ", " + node2 + "]\t" + wave.toConsole();
	}

}
