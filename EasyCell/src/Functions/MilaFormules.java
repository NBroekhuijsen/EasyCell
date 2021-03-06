package Functions;

import java.math.BigDecimal;
import java.util.ArrayList;

//WE CALL THE FUNCTION "IF"-METHOD: ifFunction, because a method cannot be called "if" 
//WE CALL THE FUNCTION "INT"-METHOD: intFunction, because a method cannot be called "int" 

public class MilaFormules {
/**
* Method SUM
* returns String with all the cells summed up
* @return String result
*/
public static String sum(ArrayList<Object> input)  throws IllegalArgumentException
{
	double result = 0.0;
	for(Object number: input)
	{
		if(number instanceof Double)
		{
			result = result + (double)number;
		}
	}
	return Double.toString(result);
}

/**Method SUMIF
* Returns String with all the cells that meet the criteria
* summed up.
* criteria = input.get(0)
* range = the rest of ArrayList Object
* @return String
*/
public static String sumif(ArrayList<Object> input) {
	double result = 0.0;
	if(input.size() < 2)
	{
		throw new IllegalArgumentException("Please select at least 2 cells/values.");
	}
	if(input.get(0) instanceof String && !(input.get(0) instanceof Double))
	{
		Double criteriaDouble = 0.0;
		String inputString = (String) input.get(0);
		String eersteTeken = inputString.substring(0,1);
		String restVanDeString = inputString.substring(1);
		boolean stringIsDouble = true;
		//hier checken of het > of < is (eerste teken)
		if(eersteTeken.equals(">") || eersteTeken.equals("<"))
		{
			//checken of er een '=' acther de > of < staat:
			if(restVanDeString.substring(0,1).equals("="))
			{
				eersteTeken = eersteTeken + "=";
				restVanDeString = inputString.substring(2);
			}
			//checken of de rest van de string ook daadwerkelijk een double is.
			try
			{
			  criteriaDouble = Double.parseDouble(restVanDeString);
			}
			catch(NumberFormatException e)
			{
			  stringIsDouble = false;
			}
			
			//vervolgens elke 4 mogelijkheden afgaan, alleen als de string ook
			//daadwerkelijk een double is.
			if(stringIsDouble)
			{
				if(eersteTeken.equals(">"))
				{
					// begin op 1 om de controlewaarde over te slaan
					for(int i = 1; i < input.size(); i++)
					{
						if(input.get(i) instanceof Double)
						{
							if((double) input.get(i) > criteriaDouble)
							{
								result = result + (double) input.get(i);
							}
						}
					}
				}
				if(eersteTeken.equals(">="))
				{
					for(int i = 1; i < input.size(); i++)
					{
						if(input.get(i) instanceof Double)
						{
							if((double) input.get(i) >= criteriaDouble)
							{
								result = result + (double) input.get(i);
							}
						}
					}
				}
				if(eersteTeken.equals("<"))
				{
					for(int i = 1; i < input.size(); i++)
					{
						if(input.get(i) instanceof Double)
						{
							if((double) input.get(i) < criteriaDouble)
							{
								result = result + (double) input.get(i);
							}
						}
					}
				}
				if(eersteTeken.equals("<="))
				{
					for(int i = 1; i < input.size(); i++)
					{
						if(input.get(i) instanceof Double)
						{
							if((double) input.get(i) <= criteriaDouble)
							{
								result = result + (double) input.get(i);
							}
						}
					}
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("Please don't use a string as a criteria");
		}
	}
	//hier checken of de input een double is
	if(input.get(0) instanceof Double)
	{
		for(int i = 1; i < input.size(); i++)
		{
			if(input.get(i) instanceof Double)
			{
				if((double) input.get(i) == (double) input.get(0))
				{
					result = result + (double) input.get(i);
				}
			}
		} 
	}
	return Double.toString(result);
}
/**
* Method  sign
* Takes just one cell in
* returns a String with "isNegative", "isZero", or "isPositive"
* depending on whether the input was a negative, equal to 
* zero or positive number
* @param input
* @return String "isNegative", "isZero", or "isPositive"
*/
public static String sign(ArrayList<Object> input) throws IllegalArgumentException
{
	if(!(input.size() ==1))
	{
		throw new IllegalArgumentException("Please select one cell/value.");
	}
	else 
	{
		if(input.get(0) instanceof Double)
		{
			if((double)input.get(0)<0)
			{
				return "isNegative";
			}
			if((double)input.get(0)==0)
			{
				return "isZero";
			}
			if((double)input.get(0)>0)
			{
				return "isPositive";
			}
		}
		else
		{
			throw new IllegalArgumentException("Please select a cell/value containing a number.");
		}
	}	
	return "Something went wrong in the SIGN method. Trust me.";
}
/**
* Method SQRT
* Returns 
*/
public static String sqrt(ArrayList<Object> input)
{
	double result;
	if(!(input.size() ==1))
	{
		throw new IllegalArgumentException("Please select one cell/value.");
	}
	if(!(input.get(0) instanceof Double))
	{
		throw new IllegalArgumentException("Please select a cell/value containing a number.");
	}
	else 
	{
		if((input.get(0) instanceof Integer || input.get(0) instanceof Double) && input.size() == 1)
		{
			if((double)input.get(0) < 0)
			{
				throw new IllegalArgumentException("Please select a cell/value containing a positive number.");
			}
			result = Math.sqrt((double)input.get(0));
			return Double.toString(result);
		}
	}
	return "Something went wrong in the SQRT method. Trust me.";
}	
/**
* Method ROUNDUP
* Input: (number to be rounded up, number of decimals)
* 
*/
public static String roundup(ArrayList<Object> input)
{
	String regex = "^[0-9]+" + "((\\.){1}([0]+))?";

//	throw exception if input does not contain 2 elements
	if(input.size() != 2)
	{
		throw new IllegalArgumentException("Please select two cells/values.");
	}
//	throw exception if the elements are something other than a number
	else if(!((input.get(0) instanceof Double) && (input.get(1) instanceof Double)))
	{
		throw new IllegalArgumentException("Please select cells/values containing numbers only");
	}
	else if(!(Double.toString((double)input.get(1)).matches(regex)))
	{
		throw new IllegalArgumentException("Please select a natural number as the criteria");
	}
	else if((double)input.get(1) < 0)
	{
		throw new IllegalArgumentException("The number of decimals cannot be smaller then 0");
	}
	else if(Double.toString((double)input.get(1)).matches(regex))
	{
		int decimals = (int)((double)input.get(1));
		BigDecimal bd = new BigDecimal((double)input.get(0));
		bd = bd.setScale(decimals, BigDecimal.ROUND_UP);
		double result =  bd.doubleValue();
		return (Double.toString(result));
	}
	return "Something went wrong in the ROUNDUP method. Trust me.";
}
/**
* Method ROUNDDOWN
* Input: (number to be rounded down, number of decimals)
* 
*/
public static String rounddown(ArrayList<Object> input)
{
	String regex = "^[0-9]+" + "((\\.){1}([0]+))?";

//	throw exception if input contains more or less than 2 elements
	if(input.size() != 2)
	{
		throw new IllegalArgumentException("Please select two cells/values.");
	}
//	throw exception if the elements are something other than a number
	else if(!((input.get(0) instanceof Double) && (input.get(1) instanceof Double)))
	{
		throw new IllegalArgumentException("Please select cells/values containing numbers only.");
	}
	else if(!(Double.toString((double)input.get(1)).matches(regex)))
	{
		throw new IllegalArgumentException("Please select a natural number as the criteria.");
	}
	else if((double)input.get(1) < 0)
	{
		throw new IllegalArgumentException("The number of decimals cannot be smaller then 0.");
	}
	else if(Double.toString((double)input.get(1)).matches(regex))
	{
		int decimals = (int)((double)input.get(1));
		BigDecimal bd = new BigDecimal((double)input.get(0));
		bd = bd.setScale(decimals, BigDecimal.ROUND_DOWN);
		double result =  bd.doubleValue();
		return (Double.toString(result));
	}
	return "Something went wrong in the ROUNDDOWN method. Trust me.";
}
}