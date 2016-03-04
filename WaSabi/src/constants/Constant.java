package constants;

public class Constant {
	private String name;

	private ModelType mt;
	private Value v;
	private Waveform w;

	public boolean isModelType() {
		return mt != null;
	}

	public boolean isValue() {
		return v != null;
	}

	public boolean isWaveform() {
		return w != null;
	}

	public ModelType getModelType() {
		return mt;
	}

	public Value getValue() {
		return v;
	}

	public Waveform getWaveform() {
		return w;
	}

	public Constant(String name, ModelType mt)
	{
		this.name = name;
		this.mt = mt;
		this.v = null;
		this.w = null;
	}

	public Constant(String name, Value v)
	{
		this.name = name;
		this.mt = null;
		this.v = v;
		this.w = null;
	}

	public Constant(String name, Waveform w)
	{
		this.name = name;
		this.mt = null;
		this.v = null;
		this.w = w;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Constant)
			return equals((Constant) obj);
		if (obj instanceof String)
			return equals((String) obj);
		else
			return false;
	};

	public boolean equals(Constant c)
	{
		return c.getName().equalsIgnoreCase(this.name);
	}

	public boolean equals(String name)
	{
		return this.name.equalsIgnoreCase(name);
	}
}
