package components;

/**
 * Base class for the passive bipoles such as resistances, capacitors or inductors.
 *
 */
public class PassiveBipole {
	/**
	 * Stores the value of the passive bipole.
	 */
	private String value;
	/**
	 * Stores the first node to which the passive bipole is connected.
	 */
	private int node1;
	/**
	 * Stores the second node to which the passive bipole is connected.
	 */
	private int node2;

	/**
	 * Getter function for the value.
	 * @return Returns the value of the passive bipole.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Getter function for the first node.
	 * @return Returns the first node to which the passive bipole is connected.
	 */
	public int getNode1() {
		return node1;
	}

	/**
	 * Getter function for the second node.
	 * @return Returns the second node to which the passive bipole is connected.
	 */
	public int getNode2() {
		return node2;
	}

	/**
	 * Constructor for the PassiveBipole class. Creates a new instance of a {@link PassiveBipole}.
	 * @param value The value of the passive bipole.
	 * @param node1 The first node to which the passive bipole is connected.
	 * @param node2 The second node to which the passive bipole is connected.
	 */
	public PassiveBipole(String value, int node1, int node2)
	{
		this.value = value;
		this.node1 = node1 + 1;
		this.node2 = node2 + 1;
	}
	
	/**
	 * Returns if this instance of passive bipole is parallel to a component connected to the nodes provided as arguments.
	 * @param n1 First node of the parallel connection.
	 * @param n2 Second node of the parallel connection.
	 * @return True if this instance is parallel to the nodes provided.
	 */
	public boolean isParallel(int n1, int n2) {
		return (node1 == (n1 + 1) && node2 == (n2 + 1) || node1 == (n2 + 1) && node2 == (n1 + 1));
	}

	/**
	 * Returns a SPICE-formatted string containing all the data about this instance.
	 * @param type The type of passive bipole (R,C or L).
	 * @param i The index that the passive bipole will have in SPICE.
	 * @return A SPICE-formatted passive bipole. 
	 */
	public String toSPICE(String type, int i)
	{
		return type.toUpperCase() + i + " " + node1 + " " + node2 + " " + value;
	}
	
	/**
	 * Returns a console-formatted string containing all the data about this instance.
	 * @param type The type of passive bipole (R,C or L).
	 * @return A console-formatted passive bipole. 
	 */
	public String toConsole(String type)
	{
		return type+ "\t\tat [" + node1 + ", " + node2 + "]\t" + value;
	}

}
