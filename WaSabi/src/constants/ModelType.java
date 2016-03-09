package constants;

/**
 * Base class for a model.
 *
 */
public class ModelType {
	/**
	 * Stores the name of the model.
	 */
	private String type;

	/**
	 * Constructor for the Model class.
	 * @param type The name of the model.
	 */
	public ModelType(String type)
	{
		// remove the < >
		this.type = type.substring(1, type.length() - 1);
	}

	/**
	 * Getter function for the model.
	 * @return The model.
	 */
	public String getType() {
		return type.toUpperCase();
	}
	
	
}
