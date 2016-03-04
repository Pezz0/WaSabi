package components;

import constants.ModelType;

public class Transistor {
	private ModelType model;
	private int node1;
	private int node2;
	private int node3;

	public ModelType getModelType() {
		return model;
	}

	public int getNode1() {
		return node1;
	}

	public int getNode2() {
		return node2;
	}

	public Transistor(ModelType model, int node1, int node2, int node3)
	{
		this.model = model;
		this.node1 = node1 + 1;
		this.node2 = node2 + 1;
		this.node3 = node3 + 1;
	}

	public String toSPICE(String type, int i)
	{
		return type.toUpperCase() + i + " " + node1 + " " + node2 + " " + node3 + (type.toUpperCase() == "M" ? " " + node3 : "") + " "
				+ model.getType();
	}

	public String toConsole(String type)
	{
		return type + "\t\t\tat [" + node1 + ", " + node2 + ", " + node3 + "]\t" + model.getType();
	}

}
