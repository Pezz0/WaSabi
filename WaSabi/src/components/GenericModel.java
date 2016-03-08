package components;

import java.util.Vector;

import constants.ModelType;

/**
 * Base class for the generic models.
 *
 */
public class GenericModel {
	/**
	 * Stores the model.
	 */
	private ModelType model;
	/**
	 * Stores the list of nodes to which the generic model is connected.
	 */
	private Vector<Integer> nodes;

	/**
	 * Getter function for the model.
	 * @return Returns the model of the generic model component.
	 */
	public ModelType getModel() {
		return model;
	}

	/**
	 * Getter function for the i-th node.
	 * @return Returns the i-th node to which the generic model is connected.
	 */
	public int getNode(int i) {
		return nodes.get(i);
	}

	/**
	 * Constructor for the GenericModel class. Creates a new instance of a {@link GenericModel}.
	 * @param model The model of the generic model component.
	 */
	public GenericModel(ModelType model) {
		this.model = model;
		nodes = new Vector<Integer>();
	}

	/**
	 * Adds a node the the nodes list.
	 * @param i The index to which the node will be added.
	 */
	public void addNode(int i) {
		nodes.addElement(i + 1);
	}
	/**
	 * Returns a SPICE-formatted string containing all the data about this instance.
	 * @param i The index that the generic model will have in SPICE.
	 * @return A SPICE-formatted generic model.  
	 */
	public String toSPICE(int i)
	{
		String s = "X" + i;
		for (Integer n : nodes)
			s = s + " " + n;

		return s + " " + model.getType();
	}

	/**
	 * Returns a console-formatted string containing all the data about this instance.
	 * @return A console-formatted generic model.  
	 */
	public String toConsole()
	{
		String s = "Model\t\t\tat [";
		for (Integer n : nodes)
			s = s + n + ", ";

		return s.substring(0, s.length() - 2) + "]\t" + model.getType();
	}
}
