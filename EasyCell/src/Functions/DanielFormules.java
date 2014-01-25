package Functions;

import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class DanielFormules {

	public static String not(ArrayList<Object> input) {
		String expression = "";
		if (input.size() > 1) {
			throw new IllegalArgumentException("please select one cell/string");
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

			throw new IllegalArgumentException("Please use a valid logical statement.");

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
					System.out.println("Please use a valid logical statement.");
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
			throw new IllegalArgumentException("Please use two cells/values.");
		}
		if (input.get(0) instanceof Double) {
			base = (double) input.get(0);
		} else {
			throw new IllegalArgumentException("Please use a number as base.");
		}
		if (input.get(1) instanceof Double) {
			power = (double) input.get(1);
		} else {
			throw new IllegalArgumentException("Please use a number as power.");
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

}
