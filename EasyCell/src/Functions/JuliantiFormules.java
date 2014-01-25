package Functions;

import java.util.ArrayList;

public class JuliantiFormules {
	
	//TODO: JAVADOCCEN
	
	// Input is een arraylist van objecten (doubles en strings enzo)...
	public static String intFunction(ArrayList<Object> input)
	{
		if(input.size() >= 2)
		{
			throw new IllegalArgumentException("Please select one cell/value.");
		}
		
		if(input.get(0) instanceof Double)
		{
			double inputdouble = (double) input.get(0);
			double outputdouble = Math.floor(inputdouble);
			//Math.floor rond het altijd af naar een lager geheel getal
			//Dus moet je nu nog kijken of je hem naar boven moet afronden:
			if((outputdouble + 0.5) < inputdouble)
			{
				outputdouble++;
			}
			
			String outputstring = Double.toString(outputdouble);
			
			return outputstring;
		}
		else
		{
			throw new IllegalArgumentException("Please select a cell/value containing a number.");
		}
	}
	
	public static String islogical(ArrayList<Object> input)
	{
		if(input.size() > 1)
		{
			throw new IllegalArgumentException("Please select one cell/value.");
		}
		
		if(input.get(0) instanceof String)
		{
			String inputstring = (String) input.get(0);
			if(inputstring.equalsIgnoreCase("true")||inputstring.equalsIgnoreCase("false"))
			{
				return "true";
			}
		}
		return "false";
	}	
		
	
	public static String iseven(ArrayList<Object> input)
	{
		if(input.size() > 1)
		{
			throw new IllegalArgumentException("Please select one cell/value.");
		}
		if(!(input.get(0) instanceof Double))
		{
			throw new IllegalArgumentException("Please select a cell/value containing a number.");
		}
		double inputdouble = (double) input.get(0);
		if(inputdouble%2 == 0)
		{
			return "true";
		}
		return "false";
	}
	
	public static String isnumber(ArrayList<Object> input)
	{
		if(input.size() > 1)
		{
			throw new IllegalArgumentException("Please select one cell/value.");
		}
		if(input.get(0) instanceof Double)
		{
			return "true";
		}
		return "false";
	}
	
	public static String min(ArrayList<Object> input) {
		double minvalue = Double.MAX_VALUE;
		double inputvalue = 0.0;
		String result = "0.0";
		for (int i = 0; i < input.size(); i++) {
			
			if(input.get(i) instanceof Double)
			{
				inputvalue = (Double) input.get(i);
				if (inputvalue <= minvalue) {
					minvalue =  inputvalue;
				}
				result = Double.toString(minvalue);
			}
		}
		return result;
	}
}