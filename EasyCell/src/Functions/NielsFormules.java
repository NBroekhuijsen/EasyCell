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
}
