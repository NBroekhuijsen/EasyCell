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

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		double counter = 0.0;
		//Loop for if the criteria has a logical operator
		if(input.get(input.size() - 1) instanceof String)
		{
			String expression =(String) input.get(input.size() - 1);
			input.remove(input.size() - 1);
			for(Object in : input)
			{
				if(in instanceof Double)
				{
					String temp = (double )in + expression;
					try {
						if ((boolean) engine.eval(temp)){
							counter++;
						}
					} catch (ScriptException e) {
						throw new IllegalArgumentException("Cant evaluate the countif");
					}
				}
			}
		}
		else if((input.get(input.size() - 1) instanceof Double))
		{
			double number = (double) (input.get(input.size() - 1));
			input.remove(input.size() - 1);
			for(Object in : input){
				if(in instanceof Double){
					if((double)in == number){
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