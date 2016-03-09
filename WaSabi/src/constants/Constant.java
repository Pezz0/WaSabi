package constants;

/**
 * Base class for constants.
 *
 */
public class Constant {
	/**
	 * Stores the name of the constant declared.
	 */
	private String name;

	/**
	 * Stores the model. Null is this instance is not a model constant.
	 */
	private ModelType mt;
	/**
	 * Stores the value. Null if this instance is not a value constant.
	 */
	private Value v;
	/**
	 * Stores the waveform. Null if this instance is not a waveform constant.
	 */
	private Waveform w;

	/**
	 * Checks if the instance is a model.
	 * @return True if the instance is a model.
	 */
	public boolean isModelType() {
		return mt != null;
	}

	/**
	 * Checks if the instance is a value.
	 * @return True if the instance is a value.
	 */
	public boolean isValue() {
		return v != null;
	}

	/**
	 * Checks if the instance is a waveform.
	 * @return True if the instance is a waveform.
	 */
	public boolean isWaveform() {
		return w != null;
	}

	/**
	 * Getter function for the model. 
	 * @return Returns a {@link ModelType} if the instance is a model. Null otherwise.
	 */
	public ModelType getModelType() {
		return mt;
	}

	/**
	 * Getter function for the value. 
	 * @return Returns a {@link Value} if the instance is a value. Null otherwise.
	 */
	public Value getValue() {
		return v;
	}

	/**
	 * Getter function for the waveform. 
	 * @return Returns a {@link Waveform} if the instance is a waveform. Null otherwise.
	 */
	public Waveform getWaveform() {
		return w;
	}

	/**
	 * Constructor for a model constant.
	 * @param name The name of the constant.
	 * @param mt The model.
	 */
	public Constant(String name, ModelType mt)
	{
		this.name = name;
		this.mt = mt;
		this.v = null;
		this.w = null;
	}

	/**
	 * Constructor for a value constant.
	 * @param name The name of the constant.
	 * @param v The value.
	 */
	public Constant(String name, Value v)
	{
		this.name = name;
		this.mt = null;
		this.v = v;
		this.w = null;
	}

	/**
	 * Constructor for a waveform constant.
	 * @param name The name of the constant.
	 * @param w The waveform.
	 */
	public Constant(String name, Waveform w)
	{
		this.name = name;
		this.mt = null;
		this.v = null;
		this.w = w;
	}

	/**
	 * Getter function for the name of the constant.
	 * @return The name of the constant.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Override for equals; checks if the name of the constant is the same as the name of the one provided as argument.
	 * @param obj Object to check for equality.
	 * @return True if the name of this instance is equals to the name of the one provided as argument.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Constant)
			return equals((Constant) obj);
		if (obj instanceof String)
			return equals((String) obj);
		else
			return false;
	};

	/**
	 * Checks if the name of the constant is the same as the name of the one provided as argument.
	 * @param c Constant to check for equality.
	 * @return True if the name of this instance is equals to the name of the one provided as argument.
	 */
	public boolean equals(Constant c)
	{
		return c.getName().equalsIgnoreCase(this.name);
	}

	/**
	 * Checks if the name of the constant is the same as the one provided as argument.
	 * @param c Name to check for equality.
	 * @return True if the name of this instance is equals to the name provided as argument.
	 */
	public boolean equals(String name)
	{
		return this.name.equalsIgnoreCase(name);
	}
}
