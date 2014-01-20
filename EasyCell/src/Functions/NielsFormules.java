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
		Double maxvalue = (double) 0;
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

	public static String median(ArrayList<Object> input) {

		int i = 0;
		while (!(input.get(i) instanceof Double)) {
			i++;
			throw new IllegalArgumentException(
					"Please select a cell containing a number.");
		}

		int size = input.size();
		Double result = null;
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
		String result = null;
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
		if (input.get(0) instanceof Double) {
			if (input.get(1) instanceof Double) {
				Double number = (Double) input.get(0);
				Double divisor = (Double) input.get(1);

				if (number > 0 && divisor > 0) {
					while (number > divisor) {
						number = number - divisor;
					}
				}
				else if (number < 0 && divisor > 0) {
					while (number < divisor) {
						number = number + divisor;
					}
				}
				else if (number > 0 && divisor < 0) {
					divisor = divisor * -1;
					while (number > divisor) {
						number = number - divisor;
					}
				}
				else if (number < 0 && divisor < 0) {
					divisor = divisor * -1;
					number = number * -1;
					while (number > divisor) {
						number = number - divisor;
					}
				} else {
					throw new IllegalArgumentException(
							"Please enter two numbers not equal to 0");
				}
				result = number.toString();
			}
		}
		return result;
	}

}
