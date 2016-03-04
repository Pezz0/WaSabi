package constants;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Value {

	private double value;

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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Value)
			return equals((Value) obj);
		else if (obj instanceof Float)
			return equals((Float) obj);
		else
			return false;
	}

	public boolean equals(Float f) {
		return f == this.value;
	}

	public boolean equals(float f) {
		return f == this.value;
	}

	public boolean equals(Value v) {
		return v.value == this.value;
	}

}
