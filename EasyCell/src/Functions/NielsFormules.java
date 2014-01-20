package Functions;

import java.util.ArrayList;

public class NielsFormules {

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
}
