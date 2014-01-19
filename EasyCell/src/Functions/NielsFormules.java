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

	public static String upper(ArrayList<Object> input) {
		if (input.size() > 1) {
			throw new IllegalArgumentException("Please select only one cell.");
		}
		if (input.get(0) instanceof Double) {
			throw new IllegalArgumentException("Please don't enter numbers.");
		}
		if (input.get(0) instanceof String) {

			String inputtext = (String) input.get(0);
			return inputtext.toUpperCase();
		}

		return "This isn't supposed to happen.";
	}

	public static String max(ArrayList<Object> input) {
		double maxvalue = 0.0;
		String result = null;
		for (int i = 0; i < input.size(); i++) {

			if (maxvalue <= (Double) input.get(i)) {
				maxvalue = (Double) input.get(i);
			}
			result = Double.toString(maxvalue);

		}

		return result;
	}
	public static String min(ArrayList<Object> input) {
		Double maxvalue = (double) 0;
		String result = null;
		for (int i = 0; i < input.size(); i++) {

			if (maxvalue >= (Double) input.get(i)) {
				maxvalue = (Double) input.get(i);
			}
			result = Double.toString(maxvalue);

		}

		return result;
	}
	
	

}
