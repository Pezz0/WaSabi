package constants;

public class ModelType {
	private String type;

	public ModelType(String type)
	{
		// remove the < >
		this.type = type.substring(1, type.length() - 1);
	}

	public String getType() {
		return type.toUpperCase();
	}
	
	
}
