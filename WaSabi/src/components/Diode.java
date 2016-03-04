package components;

import constants.ModelType;

public class Diode {
	private ModelType model;
	private int node1;
	private int node2;

	public ModelType getModelType() {
		return model;
	}

	public int getNode1() {
		return node1;
	}

	public int getNode2() {
		return node2;
	}

	public Diode(ModelType model, int node1, int node2)
	{
		this.model = model;
		this.node1 = node1 + 1;
		this.node2 = node2 + 1;
	}

	public boolean isParallel(int n1, int n2) {
		return (node1 == (n1 + 1) && node2 == (n2 + 1) || node1 == (n2 + 1) && node2 == (n1 + 1));
	}
	
	public String toSPICE(int i)
	{
		return "D" + i + " " + node1 + " " + node2 + " " + model.getType();
	}
	
	public String toConsole()
	{
		return "Diode\t\t\tat [" + node1 + ", " + node2 + "]\t" + model.getType();
	}
}
