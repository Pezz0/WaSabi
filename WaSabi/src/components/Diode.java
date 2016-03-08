package components;

import constants.ModelType;
/**
 * Base class for the diodes.
 *
 */
public class Diode {
	/**
	 * Stores the model of the diode.
	 */
	private ModelType model;
	/**
	 * Stores the first node to which the diode is connected.
	 * This node is the anode.
	 */
	private int node1;
	/**
	 * Stores the second node to which the diode is connected.
	 * This node is the cathode.
	 */
	private int node2;

	/**
	 * Getter function for the model.
	 * @return Returns the model of the diode.
	 */
	public ModelType getModelType() {
		return model;
	}

	/**
	 * Getter function for the first node.
	 * @return Returns the first node to which the diode is connected.
	 */
	public int getNode1() {
		return node1;
	}

	/**
	 * Getter function for the second node.
	 * @return Returns the second node to which the diode is connected.
	 */
	public int getNode2() {
		return node2;
	}

	/**
	 * Constructor for the Diode class. Creates a new instance of a {@link Diode}.
	 * @param model The model of the diode.
	 * @param node1 The first node to which the diode is connected.
	 * @param node2 The second node to which the diode is connected.
	 */
	public Diode(ModelType model, int node1, int node2)
	{
		this.model = model;
		this.node1 = node1 + 1;
		this.node2 = node2 + 1;
	}

	/**
	 * Returns if this instance of diode is parallel to a component connected to the nodes provided as arguments.
	 * @param n1 First node of the parallel connection.
	 * @param n2 Second node of the parallel connection.
	 * @return True if this instance is parallel to the nodes provided.
	 */
	public boolean isParallel(int n1, int n2) {
		return (node1 == (n1 + 1) && node2 == (n2 + 1) || node1 == (n2 + 1) && node2 == (n1 + 1));
	}
	
	/**
	 * Returns a SPICE-formatted string containing all the data about this instance.
	 * @param i The index that the diode will have in SPICE.
	 * @return A SPICE-formatted diode.  
	 */
	public String toSPICE(int i)
	{
		return "D" + i + " " + node1 + " " + node2 + " " + model.getType();
	}
	
	/**
	 * Returns a console-formatted string containing the diode informations.
	 * @return A console-formatted diode.
	 */
	public String toConsole()
	{
		return "Diode\t\t\tat [" + node1 + ", " + node2 + "]\t" + model.getType();
	}
}
