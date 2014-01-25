/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Functions;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 *    AVERAGE/COUNT/COUNTA/COUNTIF/IF	
 * 
 *   IF -> ifFunction
 */
public class RemkoFormules {

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
			throw new IllegalArgumentException("Please use at least two cells/values.");
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
			throw new IllegalArgumentException("Please select three cells/values.");
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
				throw new IllegalArgumentException("Please use a valid logical statement.");
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