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
			if(number instanceof Integer || number instanceof Double)
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
		// Initiating solution boolean
		boolean solution = false;
		String expression = "";
		if (input.size() != 3)
		{
			throw new IllegalArgumentException(
				"please use exactly 3 values for this function.");
		}
		if (input.get(0) instanceof String)
		{
			expression = (String) input.get(0);
		}
		else if(input.get(0) instanceof Double)
		{
			if(!((double) input.get(0) == 0))
			{
				solution = true;
			}
		}
		else
		{
			throw new IllegalArgumentException("Please use a valid expression");
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
}