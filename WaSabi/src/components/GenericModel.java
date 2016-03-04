package components;

import java.util.Vector;

import constants.ModelType;

public class GenericModel {
	private ModelType model;
	private Vector<Integer> nodes;

	public ModelType getWaveform() {
		return model;
	}

	public int getNode(int i) {
		return nodes.get(i);
	}

	public GenericModel(ModelType model) {
		this.model = model;
		nodes = new Vector<Integer>();
	}

	public void addNode(int i) {
		nodes.addElement(i + 1);
	}

	public String toSPICE(int i)
	{
		String s = "X" + i;
		for (Integer n : nodes)
			s = s + " " + n;

		return s + " " + model.getType();
	}

	public String toConsole()
	{
		String s = "Model\t\t\tat [";
		for (Integer n : nodes)
			s = s + n + ", ";

		return s.substring(0, s.length() - 2) + "]\t" + model.getType();
	}
}
