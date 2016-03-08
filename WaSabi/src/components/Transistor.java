package components;

import constants.ModelType;

/**
 * Base class for the transistors (BJT, MOSFET, JFET).
 *
 */
public class Transistor {
	/**
	 * Stores the model of the transistor.
	 */
	private ModelType model;
	/**
	 * Stores the first node to which the transistor is connected.
	 * This node is the collector/drain.
	 */
	private int node1;
	/**
	 * Stores the second node to which the transistor is connected.
	 * This node is the base/gate.
	 */
	private int node2;
	/**
	 * Stores the third node to which the transistor is connected.
	 * This node is the emitter/source.
	 */
	private int node3;

	/**
	 * Getter function for model.
	 * @return The model of the transistor.
	 */
	public ModelType getModelType() {
		return model;
	}

	/**
	 * Getter function for first node.
	 * @return The node connected to the transistor's collector/drain.
	 */
	public int getNode1() {
		return node1;
	}

	/**
	 * Getter function for second node.
	 * @return The node connected to the transistor's base/gate.
	 */
	public int getNode2() {
		return node2;
	}
	
	/**
	 * Getter function for third node.
	 * @return The node connected to the transistor's emitter/source.
	 */
	public int getNode3(){
		return node3;
	}

	/**
	 * Constructor for the Transistor class. Creates a new instance of a {@link Transistor}.
	 * @param model The model of the transistor.
	 * @param node1 The node connected to the transistor's collector/drain.
	 * @param node2 The node connected to the transistor's base/gate.
	 * @param node3 The node connected to the transistor's emitter/source.
	 */
	public Transistor(ModelType model, int node1, int node2, int node3)
	{
		this.model = model;
		this.node1 = node1 + 1;
		this.node2 = node2 + 1;
		this.node3 = node3 + 1;
	}

	/**
	 * Returns a SPICE-formatted string containing all the data about this instance.
	 * @param type The type of the transistor (BJT, MOS or JFET).
	 * @param i The index that the transistor will have in SPICE.
	 * @return A SPICE-formatted transistor.
	 */
	public String toSPICE(String type, int i)
	{
		return type.toUpperCase() + i + " " + node1 + " " + node2 + " " + node3 + (type.toUpperCase() == "M" ? " " + node3 : "") + " "
				+ model.getType();
	}

	/**
	 * Returns a console-formatted string containing all the data about this instance.
	 * @param type The type of the transistor (BJT, MOS or JFET).
	 * @return A console-formatted transistor.
	 */
	public String toConsole(String type)
	{
		return type + "\t\t\tat [" + node1 + ", " + node2 + ", " + node3 + "]\t" + model.getType();
	}

}
