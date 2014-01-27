package PROJECTGEHEEL;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Functions {
	public static String not(ArrayList<Object> input) {
		String expression = "";
		if (input.size() > 1) {
			throw new IllegalArgumentException(
				"please use 1 Expression for this function");
		}
		if (input.get(0) instanceof String) {
			expression = (String) input.get(0);
		} else if(input.get(0) instanceof Double){
			if((double) input.get(0) == 0)
			{
				return "true";
			}
			return "false";
		}else{
			throw new IllegalArgumentException("Please use an expression");
		}
// Replace some String input to logical operators (To be sure)
		expression = expression.replaceAll("AND", "&&");
		expression = expression.replaceAll("OR", "||");
		expression = expression.replaceAll("=", "==");
// Initiating solution boolean
		String solution = "";

		try {

			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			solution = String.valueOf(!((boolean) engine.eval(expression)));

		} catch (Exception e) {

			throw new IllegalArgumentException("He, je faalt");

		}
		return solution;
	}

	public static String or(ArrayList<Object> input) {
		boolean solution = false;
		boolean numbersolution = false;
		boolean returnwaarde = false;
		String expression = "";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		for(int i = 0; i < input.size(); i++)	{
			if (input.get(i) instanceof String && !(input.get(i) instanceof Double))
			{
				expression = (String) input.get(i);
		// Replace some String input to logical operators (To be sure)
				expression = expression.replaceAll("AND", "&&");
				expression = expression.replaceAll("OR", "||");
				expression = expression.replaceAll("=", "==");
				try {
		// iterate trough every individual expression, setting 'solution'to
		// true if it finds a true one
					if (!solution) {
						if ((boolean) engine.eval(expression)) {
							solution = true;
						}
					}
				} catch (Exception e) {
					System.out.println("Not a valid Expression");
					e.printStackTrace();
				}
			}
		}
		// na alle mogelijke strings te hebben ge-evalueerd, ga je hierna de
		// doubles evalueren. Een 0 is false, elke andere returned true.
		for(int i = 0; i < input.size(); i++)	{
			if (input.get(i) instanceof Double) {
				if((double) input.get(i) != 0)
				{
					numbersolution = true;
				}
			}
		}
		//Oftewel, als hij nu bij de cijfers OF de strings een waarde heeft gevonden die
		//true is, zal hij dat hier in de returnwaarde zetten.
		if(numbersolution || solution)
		{
			returnwaarde = true;
		}
		return String.valueOf(returnwaarde);
	}

	public static String power(ArrayList<Object> input) {
		double base = 0;
		double power = 0;
		if (input.size() != 2) {
			throw new IllegalArgumentException(
				"Please use 2 numbers for this function");
		}
		if (input.get(0) instanceof Double) {
			base = (double) input.get(0);
		} else {
			throw new IllegalArgumentException("Please use a number as base");
		}
		if (input.get(1) instanceof Double) {
			power = (double) input.get(1);
		} else {
			throw new IllegalArgumentException("Please use a number as base");
		}
		return Double.toString(Math.pow(base, power));
	}

	public static String product(ArrayList<Object> input) {
		double solution = 1.0;
		double counter = input.size();
		for (Object number : input) {
			if (number instanceof Double) {
				solution *= (double) number;
				counter--;
			}
		}
		if(counter == input.size())
		{
			return "0.0";
		}
		return Double.toString(solution);
	}

	public static String proper(ArrayList<Object> input) {
		String solution = "";
		if (input.size() > 1) {
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if (input.get(0) instanceof String) {
			StringBuilder builder = new StringBuilder();
			String capsafter = " '-/";
			boolean captionnext = true;
// for loop that checks and captions letters
			for (char c : ((String) input.get(0)).toCharArray()) {
//turn Character into capital or not, based on captionnext 
				c = (captionnext) ? Character.toUpperCase(c) : Character
				.toLowerCase(c);
				builder.append(c);
				captionnext = (capsafter.indexOf((int) c) >= 0);
			}
			solution = builder.toString();
		}
		return solution;
	}
	
	public static String intFunction(ArrayList<Object> input)
	{
		if(input.size() >= 2)
		{
			throw new IllegalArgumentException("Please select only one cell.");
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
			throw new IllegalArgumentException("Please select a cell containing a number.");
		}
	}
	
	public static String islogical(ArrayList<Object> input)
	{
		if(input.size() > 1)
		{
			throw new IllegalArgumentException("Please select only one cell.");
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
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if(!(input.get(0) instanceof Double))
		{
			throw new IllegalArgumentException("Please select a cell containing a number.");
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
			throw new IllegalArgumentException("Please select only one cell.");
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
	public static String sumif(ArrayList<Object> input)
	{
		double result = 0;
		if(input.size() < 2)
		{
			throw new IllegalArgumentException("Please select at least two cells");
		}
		if(input.get(0) instanceof Double)
		{
			double criteria = (double)input.get(0);
			for(int i = 1; i<input.size(); i++)
			{	
//				if(!(input.get(i)instanceof Double))
//				{
//					throw new IllegalArgumentException("Please select cells containing only numbers!");
//				}
				if(input.get(i) instanceof Double)
				{
					if((double)input.get(i) == criteria)
						result = result + (double)input.get(i);
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("Your criteria must be a number!");
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
			throw new IllegalArgumentException("Please select one cell for the function SIGN");
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
				throw new IllegalArgumentException("Please select a cell containing a number");
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
			throw new IllegalArgumentException("Please select one cell for the function SQRT");
		}
		if(!(input.get(0) instanceof Double))
		{
			throw new IllegalArgumentException("Please select a cell containing a number");
		}
		else 
		{
			if((input.get(0) instanceof Integer || input.get(0) instanceof Double) && input.size() == 1)
			{
				if((double)input.get(0) < 0)
				{
					throw new IllegalArgumentException("Please select a cell containing a positive number");
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

//		throw exception if input does not contain 2 elements
		if(input.size() != 2)
		{
			throw new IllegalArgumentException("Please select just two elements");
		}
//		throw exception if the elements are something other than a number
		else if(!((input.get(0) instanceof Double) && (input.get(1) instanceof Double)))
		{
			throw new IllegalArgumentException("Please select only elements containing numbers");
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

//		throw exception if input contains more or less than 2 elements
		if(input.size() != 2)
		{
			throw new IllegalArgumentException("Please select just two elements");
		}
//		throw exception if the elements are something other than a number
		else if(!((input.get(0) instanceof Double) && (input.get(1) instanceof Double)))
		{
			throw new IllegalArgumentException("Please select only elements containing numbers");
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
			bd = bd.setScale(decimals, BigDecimal.ROUND_DOWN);
			double result =  bd.doubleValue();
			return (Double.toString(result));
		}
		return "Something went wrong in the ROUNDDOWN method. Trust me.";
	}

	
	public static String lower(ArrayList<Object> input) {
		if (input.size() > 1) {
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if (input.get(0) instanceof Double) {
			throw new IllegalArgumentException("Please don't enter numbers.");
		}
		if (input.get(0) instanceof String) {

			String inputtext = (String) input.get(0);
			return inputtext.toLowerCase();
		}

		return "This isn't supposed to happen.";
	}

	public static String max(ArrayList<Object> input) {
		double maxvalue = 0.0;
		double inputvalue = 0.0;
		String result = "0.0";
		for (int i = 0; i < input.size(); i++) {
			
			if(input.get(i) instanceof Double)
			{
				inputvalue = (Double) input.get(i);
				if (maxvalue <= inputvalue) {
					maxvalue =  inputvalue;
				}
				result = Double.toString(maxvalue);
			}
		}
		return result;
	}
	
	public static String median(ArrayList<Object> input) {

		for(int i = 0; i < input.size(); i++)
		{
			if(!(input.get(i) instanceof Double))
			{
				throw new IllegalArgumentException("Please select only cells containing numbers");
			}
		}
        int size = input.size();
        Double result = 0.0;
        if (size % 2 == 0) {
                int number1 = size / 2;
                int number2 = number1++;
                result = ((Double) input.get(number1) + (Double) input.get(number2)) / 2;
        } else {
                int number = (int) ((size/2) + 0.5);
                result = (Double) input.get(number);
        }
        return result.toString();
}
	
	public static String mod(ArrayList<Object> input) {
        String result = "";
        if (input.size() > 2) {
                throw new IllegalArgumentException("Please select only two cells.");
        }
        if (input.size() < 2) {
                throw new IllegalArgumentException("Please select two cells.");
        }
        if (!(input.get(0) instanceof Double)) {
                throw new IllegalArgumentException(
                                "Please two cells each containing a number.");
        }
        if (!(input.get(1) instanceof Double)) {
                throw new IllegalArgumentException(
                                "Please two cells each containing a number.");
        }
        if (input.get(0) instanceof Double)
        {
        	if (input.get(1) instanceof Double)
        	{
        		double number = (Double) input.get(0);
                double divisor = (Double) input.get(1);
                if(divisor == 0)
                {
                	throw new IllegalArgumentException("Please select a divisor that isn't zero.");
                }
                number = number%divisor;
                result = Double.toString(number);
                if(result.equals("-0.0"))
                {
                	result = "0.0";
                }
            }
        }
    	return result;
	}

	
	public static String average(ArrayList<Object> input){
		double result = 0;
		double deler = input.size();

		for(Object number: input)
		{
			if(number instanceof Double)
			{
				result = result + (double)number;
			}
		}
		for(int i=0; i<input.size(); i++)
		{
			if(input.get(i) instanceof String)
			{
				deler = deler - 1;
			}
		}
		if(deler == 0)
		{
			return (Double.toString(deler));
		}

		return Double.toString(result/deler);	
	}

	public static String count(ArrayList<Object> input){
		double desize = 0.0;
		for(int i=0; i<input.size(); i++)
		{
			if(input.get(i) instanceof Double)
			{
				desize = desize + 1;
			}
		}
		return Double.toString(desize);
	}

	public static String counta(ArrayList<Object> input){ 
		int desize = input.size();
		for(int i = 0; i<input.size(); i++)
		{
			if(input.get(i).equals(""))
			{
				desize = desize - 1;
			}
		}     	      	
		return Double.toString(desize);
	}



	public static String countif(ArrayList<Object> input) {
		double counter = 0.0;
		if(input.size() < 2)
		{
			throw new IllegalArgumentException("Please select at least 2 cells.");
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
									counter++;
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
									counter++;
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
									counter++;
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
									counter++;
								}
							}
						}
					}
				}
				// je moet ook strings die met > etc. beginnen coveren hier:
				// dus als wat er na > etc. komt geen double is:
				if(!(stringIsDouble))
				{
					for(int i = 1; i < input.size(); i++)
					{
						if(input.get(i) instanceof String)
						{
							if(((String) input.get(i)).equals(inputString))
							{
								counter++;
							}
						}
					}
				}
			}
			// als dit niet het geval is dan betekent het dat er of geen vergelijkings
			// teken is, of dat er geen double achter het vergelijkingsteken staat.
			// in dit geval dus kijken of je dezelfde strings kunt vinden.
			else
			{
				for(int i = 1; i < input.size(); i++)
				{
					if(input.get(i) instanceof String)
					{
						if(((String) input.get(i)).equals(inputString))
						{
							counter++;
						}
					}
				}
			}
		}
		//hier checkn of de input een double is
		if(input.get(0) instanceof Double)
		{
			for(int i = 1; i < input.size(); i++)
			{
				if(input.get(i) instanceof Double)
				{
					if((double) input.get(i) == (double) input.get(0))
					{
						counter++;
					}
				}
			} 
		}
		return Double.toString(counter);
	}

	public static String ifFunction(ArrayList<Object> input)
	{
		boolean solution = false;
		String expression = "";
		String returnwaarde = "";
		if (input.size() != 3)
		{
			throw new IllegalArgumentException(
				"please use exactly 3 values for this function.");
		}
		// voor elk cijfer wordt er true gereturned behalve voor 0.
		if(input.get(0) instanceof Double)
		{
			if(!((double) input.get(0) == 0))
			{
				solution = true;
			}
		}

		else if (input.get(0) instanceof String && !(input.get(0) instanceof Double))
		{
			expression = (String) input.get(0);
			// Replace some String input to logical operators (To be sure)
			expression = expression.replaceAll("AND", "&&");
			expression = expression.replaceAll("OR", "||");
			expression = expression.replaceAll("=", "==");
			try
			{
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("JavaScript");
				solution = ((boolean) engine.eval(expression));
			}
			catch (Exception e)
			{
				throw new IllegalArgumentException("He, je faalt");
			}
		}
		
		// als het false is returned hij de tweede waarde, als het true is returned hij de eerste waarde.
		int juistewaarde = 2;
		if(solution == true)
		{
			juistewaarde = 1;
		}
		// hier wordt er bepaald of de waarde die je wilt returnen een double of string is, vervolgens geparsed.
		if(input.get(juistewaarde) instanceof String)
		{
			returnwaarde = ( (String) input.get(juistewaarde) );
		}
		else if(input.get(juistewaarde) instanceof Double)
		{
			returnwaarde = Double.toString((double) input.get(juistewaarde));
		}
		return returnwaarde;
	}

	
		
		
		
		
		
		
		
	}
