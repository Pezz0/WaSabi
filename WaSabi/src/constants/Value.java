package constants;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Base class for a value.
 *
 */
public class Value {

	/**
	 * Stores the value.
	 */
	private double value;

	/**
	 * Constructor for the Value class. The number is stored as (base)^exponent
	 * @param n The base of the number.
	 * @param exp The exponent of the number.
	 */
	public Value(double n, String exp)
	{
		int e = 0;

		if (exp.equalsIgnoreCase("f"))
			e = -15;
		else if (exp.equalsIgnoreCase("p"))
			e = -12;
		else if (exp.equalsIgnoreCase("n"))
			e = -9;
		else if (exp.equalsIgnoreCase("u"))
			e = -6;
		else if (exp.equalsIgnoreCase("mill"))
			e = -3;
		else if (exp.equalsIgnoreCase("k"))
			e = 3;
		else if (exp.equalsIgnoreCase("meg"))
			e = 6;
		else if (exp.equalsIgnoreCase("g"))
			e = 9;
		else if (exp.equalsIgnoreCase("t"))
			e = 12;

		this.value = n * Math.pow(10, e);
	}

	/**
	 * Creates a SPICE-formatted value. SPICE uses SI prefixes to indicate exponents (such as milli, k, G, M...), so the value is constructed converting the exponent into prefix.
	 * @return A SPICE-formatted value.
	 */
	public String toSPICE()
	{
		if (value == 0)
			return "0";

		double v = value;
		DecimalFormat formatter = new DecimalFormat("###.###E0",new DecimalFormatSymbols(Locale.ENGLISH));
		
		
		String[] ordini = new String[]{"f","p","n","u","mill","","k", "Meg", "G", "T"};
		String temp= formatter.format(v);
		temp = temp.replaceAll("E(-)?[0-9]+", ordini[((Integer.parseInt(temp.split("E")[1])+15) / 3)]);
		  
		return temp;
	}
	
	/**
	 * Creates a console-formatted value. 
	 * @return A SPICE-formatted value.
	 */
	public String toConsole()
	{
		if (value == 0)
			return "0";

		double v = value;
		DecimalFormat formatter = new DecimalFormat("###.###E0",new DecimalFormatSymbols(Locale.ENGLISH));
		
		
		String[] ordini = new String[]{"f","p","n","u","m","","k", "M", "G", "T"};
		String temp= formatter.format(v);
		temp = temp.replaceAll("E(-)?[0-9]+", ordini[((Integer.parseInt(temp.split("E")[1])+15) / 3)]);
		  
		return temp;
	}
	/**
	 * Override for equals; checks if the value is the same as the value of the one provided as argument.
	 * @param obj Object to check for equality.
	 * @return True if the value of this instance is equals to the value of the one provided as argument.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Value)
			return equals((Value) obj);
		else if (obj instanceof Float)
			return equals((Float) obj);
		else
			return false;
	}

	/**
	 * Checks if the value of the constant is the same as the one provided as argument.
	 * @param f Value to check for equality.
	 * @return True if the value of this instance is equals to the value provided as argument.
	 */
	public boolean equals(Float f) {
		return f == this.value;
	}

	/**
	 * Checks if the value of the constant is the same as the one provided as argument.
	 * @param f Value to check for equality.
	 * @return True if the value of this instance is equals to the value provided as argument.
	 */
	public boolean equals(float f) {
		return f == this.value;
	}

	/**
	 * Checks if the value of the constant is the same as the value of the one provided as argument.
	 * @param f Value to check for equality.
	 * @return True if the value of this instance is equals to the value of the one provided as argument.
	 */
	public boolean equals(Value v) {
		return v.value == this.value;
	}

}
