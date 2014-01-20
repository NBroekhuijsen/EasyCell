package MVCNieuw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.AbstractTableModel;

import EGGcel.Functions;

public class Model extends AbstractTableModel {
	
	 private ArrayList<ArrayList<String>> table;
	 
	 //constructor
	    Model() {
	        table = new ArrayList<ArrayList<String>>();
	    }
	    
	    /**
         * Method to get the content from a cell in the table
         * 
         * @param x
         *            - Variable that indicates the Row (x - axis) of the cell that
         *            content is to be read from
         * @param y
         *            - Variable that indicates the Column (y - axis) of the cell
         *            that content is to be read from
         * @return returns the content of the cell as an Object
         */
        public String getContent(int x, int y) {
                try {
                        if (this.getSizeRow() >= x) {
                                if (this.getSizeCol(x) >= y) {
                                        return (String) table.get(y).get(x);
                                }
                        }
                } catch (IndexOutOfBoundsException e) {
                        System.out.print("There is no such cell, so: ");
                }
                System.out.println(this.getSizeRow() + " " + this.getSizeCol(x) + " " + x + " " + y );
                return "";
        }

        /**
         * Method to add content to the end of a row
         * 
         * @param x
         * @param y
         * @param content
         */
        public void addContent(int y, String content) {
                this.hasRow(y);
                table.get(y).add(content);
        }

        /**
         * Method to set the content of a cell in the table
         * 
         * @param x
         *            - Variable that specifies the Row of the cell
         * @param y
         *            - Variable that specifies the Column of the cell
         * @param content
         *            - Content to be put in the cell
         */
        public void setContent(int x, int y, String content) {
                this.hasRow(y);
                this.hasCol(x, y);
                table.get(y).set(x, content);
        }

        /**
         * check if table has y rows, otherwise creates row till it has
         * 
         * @param y
         *            - number of rows to be checked
         */
        public void hasRow(int y) {
                while (table.size() <= y) {
                        table.add(new ArrayList<String>());
                }
        }

        /**
         * Checks if specified row has the number of columns, otherwise creates the
         * amount
         * 
         * @param x
         * @param y
         */
        public void hasCol(int x, int y) {
                while (table.get(y).size() <= x) {
                        table.get(y).add("");
                        
                }
        }

        /**
         * Method to get the size of the table (amount of rows)
         */
        public int getSizeRow() {
                return table.size();
        }

        /**
         * Method to get the size of the table (amount of columns)
         * 
         * @param i
         *            - number of the row you want the Column amount from
         */
        public int getSizeCol(int x) {
        	if(x > table.size()){
        		return table.get(x).size();
        	}
        	return 0;
        }
        
        /**
         * method CellReader
         * 
         * checks if cellcontent begins with "=" If so, calls methods to perform
         * conversions and calculations
         * 
         * @param cell
         * @return String (either with the calculation result or the original
         *         cellcontent
         */
        public String cellReader(String cell) {
                
        
                
                // trim cell from empty spaces at beginning and ending
                cell = cell.trim();
                // String where the content of cell will be kept while being processed
                // (until become the index)
                String nwcell;
                
                try {
                        // check if cellcontent starts with "="
                        if (cell.charAt(0) == ('=')) {
                                // cut "=", the remaining will be our index and operations
                                nwcell = cell.replaceFirst("=", "");
                                nwcell = nwcell.trim();
        
                                // remove brackets and function
                                String index = functionTrimmer(nwcell);
                                String function = getFunction(nwcell);
        
                                // Expand index (remove ":" and replace them with "," and the right
                                // indexes, than fetches all the contents and places them in a ArrayList<Object
//                                Should be framed in a huge try catch block
//                                catch: 
//                                catch(IllegalArgumentException e)
//                                {
//                                        JOptionPane.showMessageDialog(null, "Error: "+ex.getCause().getMessage());
//                                }

                                ArrayList<Object> result = this.indexExpander(index);
        
                                // Call the method to perform calculations
                                return callFunction(function, result);
        
                        }
                        else
                                return cell;
                } catch(IllegalArgumentException e)
                {
                        return "#ERROR";
                        
                        // TO DO: VERY IMPORTENT: This should be put in the separate bar for the error message!
                        // return JOptionPane.showMessageDialog(null, "Error: "+e.getCause().getMessage());
                }



        }

        /**
         * method functionTrimmer removes String function and brackets from
         * cellcontent Receives input as: "FUNCTION(X1,Y2)" (So "=" is already
         * removed) Returns input as: X1,Y2
         * 
         * @param input
         * @return String
         */
        public static String functionTrimmer(String input) {

                String function = getFunction(input);

                if (functionExist(function)) {
                        // remove String function and brackets
                        input = input.replace(function, "");
                        input = input.replace(" ", "");
                        input = input.replaceFirst("(", "");
                        if(!(input.substring(input.length()-1).equals(")"))){
                                input = input.substring(0, input.length()-1);
                        }
//                        for(int i = 0; i < input.length(i)){
//                                if(Character.isLetter(charar))
//                        }
                }

                return input;
        }

        /**
         * method getFunction returns the name of the function method which will
         * have to be used Receives input as: "FUNCTION(X1,Y1)" ("=" has already
         * been removed)
         * 
         * @param input
         * @return
         */
        public static String getFunction(String input) {
                String function = input.split("\\(")[0];

                return function;

        }

        /**
         * method indexExpander 
         * Cuts out the "," and puts the pieces in ArrayList<String>
         * 
         * Scans for ":", sorts the indexes out one by one
         * then fetches the contents and put them in ArrayList<String>
         * If 
         * 
         * @param index
         */
        public ArrayList<Object> indexExpander(String index) throws IllegalArgumentException {


                ArrayList<Object> result = new ArrayList<Object>();
//                Pattern for ONLY a coordinate
                String coordinate = "(^x{1})([0-9]{0,3})(y{1})([0-9]{0,3}$)";
                String containsCoor = ".*(x{1})([0-9]{0,3})(y{1})([0-9]{0,3}).*";         
                
//                Cut out white spaces
                index = index.replace(" ", "");
                
//                Get indexes separated by commas in an arraylist
                ArrayList<String> items = new ArrayList<String>(Arrays.asList(index.split(",")));
                
                for(String item: items)
                {
//                        check if stringpiece contains ":"
                        if(item.contains(":"))
                        {
                                String[] tempCoorSeperate = new String[2];
//                                
//                                separate by ":" into two stringpieces
                                tempCoorSeperate = item.split(":");
                                
//                                Check whether on the left and right of the ":" there are Coordinates
                                if(!(tempCoorSeperate[0].matches(coordinate)) || !(tempCoorSeperate[1].matches(coordinate)))
                                {
                                        throw new IllegalArgumentException("Please give two coordinates for a range");
                                }
                        
//                                Declare x's and y's for both coordinates
                                int xUnder = getCoorX(tempCoorSeperate[0]);
                                int yUnder = getCoorY(tempCoorSeperate[0]);
                                int xUpper = getCoorX(tempCoorSeperate[1]);
                                int yUpper = getCoorY(tempCoorSeperate[1]);
                                                        
//                                loop for 
                                for(int i = xUnder; i<=xUpper; i++)
                                {
//                                        loop for the y
                                        for(int j = yUnder; j<=yUpper; j++)
                                        {
                                                String coor = "x" + i + "y" + j; 
                                                result.add(this.replaceCoor(this.getCoorContent(coor)));
                                                
                                        }
                                }
                                
                        }        //end of ":"-case 
                        
//                        handle when String piece does not contain ":"
                        else 
                        {
//                                Check if String is a coordinate
                                if(item.matches(coordinate))
                                {
//                                        If so, fetch the content of the Coordinate
                                        item = getCoorContent(item);
                                        
//                                        If result is a new coordinate
                                        if(item.matches(coordinate))
                                        {
                                                result.add(this.replaceCoor(getCoorContent(item)));
                                        }
//                                        If item has coordinate
                                        else if(item.matches(containsCoor))
                                        {
                                                result.add(this.replaceCoor(item));
                                        }
                                        else
                                        {
                                                result.add(contentParser(item));
                                        }
                                        
                                }
                                
//                                Check if String contains a coordinate
                                else if(item.matches(containsCoor))
                                {
//                                        If so, replace all coordinates with their contents
                                        item = this.replaceCoor(item);
//                                        Add to result
                                        result.add(item);
                                } else 
                                {
                                        /*If item is not a coordinate and doesn't contain a coordinate,
                                         * call method to parse to right parameter type */
                                        
//                                        Call parser method and add to result
                                        result.add(contentParser(item));
                                }
                        }

                }        //help: this is the FOR bracket
                
                return result;

        }
        
        
        /**
         * method getCoorContent
         * input: A coor (not more then that!)
         * Output: A String with the coor's content
         */
        public String getCoorContent(String coor)
        {
                String[] temp = new String[2];
                int x;
                int y;
                
                // Under: get coordinations in the right parameters
                // to get Under:
                String temporary = coor.replace("x", "");
                temp = temporary.split("y");

                // Under: tempForUnder[0] is now the wanted Array for Under
                x = Integer.parseInt(temp[0]);
                y = Integer.parseInt(temp[1]);
                
                return  (this.getContent(x,y));
                
                
        }
        
        public static int getCoorX(String coor)
        {
//                Delete "x"
                coor = coor.replace("x", "");
                
//                Split on "y"
                String[] temp = new String[2];
//                Get int x
                int x = Integer.parseInt(temp[0]);
                
                return x;
        }
        
        public static int getCoorY(String coor)
        {
//                Delete "x"
                coor = coor.replace("x", "");
                
//                Split on "y"
                String[] temp = new String[2];
//                Get int y
                int y = Integer.parseInt(temp[1]);
                
                return y;
        }
        

        /**
         * Method replaceCoor
         * Method to replace all coordinates with their 
         * value when you have a String and you know it 
         * contains a coordinate
         * @param String hasCoor
         * @return String replaced
         */
        public String replaceCoor(String hasCoor)
        {
                Pattern patternCoor = Pattern.compile("(x{1})([0-9]{0,3})(y{1})([0-9]{0,3})");
                String containsCoor = ".*(x{1})([0-9]{0,3})(y{1})([0-9]{0,3}).*";
                
                while(hasCoor.matches(containsCoor)) {
                        
                        Matcher m = patternCoor.matcher(hasCoor);
                        
                        String toBeReplaced = m.find() ? m.group() : "";
                        
                        hasCoor = hasCoor.replaceFirst(toBeReplaced, this.getCoorContent(toBeReplaced));
                }
                
                return hasCoor;
        }
        
        /**
         * Method contentParser
         * Is to be called when an item in the content of
         * the arraylist containing the stringpieces between
         * "," is not a coordinate and does not contain a coordinate
         * Check whether input is a double or int
         * If so, parses item to double
         * If not, returns item as it was
         * @param String item
         * @return Object item
         */
        public static Object contentParser(String item)
        {
//                Pattern to match a double or an integer
                String isDouble = "[0-9]+" + "((\\.){1}([0-9])+)?";
                
//                check if item is a int/double
                if(item.matches(isDouble))
                {
//                        parse String to Double
                        double resultDouble = Double.valueOf(item).doubleValue();
                        return resultDouble;
                }
                
//                If item is not a double or an integer (which means it is a formula), return it as it was
                return item;
                
        }
        
        
        /**
         * method functionExist tests if the function, extracted from the input from
         * cell, is one of the implemented functions
         * 
         * @param function
         * @return
         */
        public static boolean functionExist(String function) {
                switch (function) {

                case "AVERAGE": {
                        return true;
                }
                case "COUNT": {
                        return true;
                }
                case "COUNTA": {
                        return true;
                }
                case "COUNTIF": {
                        return true;
                }
                case "IF": {
                        return true;
                }
                case "INT": {
                        return true;
                }
                case "ISLOGICAL": {
                        return true;
                }
                case "ISEVEN": {
                        return true;
                }
                case "ISNUMBER": {
                        return true;
                }
                case "LOWER": {
                        return true;
                }
                case "MAX": {
                        return true;
                }
                case "MEDIAN": {
                        return true;
                }
                case "MIN": {
                        return true;
                }
                case "MOD": {
                        return true;
                }
                case "NOT": {
                        return true;
                }
                case "OR": {
                        return true;
                }
                case "POWER": {
                        return true;
                }
                case "PRODUCT": {
                        return true;
                }
                case "PROPER": {
                        return true;
                }
                case "ROUNDDOWN": {
                        return true;
                }
                case "ROUNDUP": {
                        return true;
                }
                case "SIGN": {
                        return true;
                }
                case "SQRT": {
                        return true;
                }
                case "SUM": {
                        return true;
                }
                case "SUMIF": {
                        return true;
                }
                default:
                        return false;

                }
        }

        /**
         * method callFunction calls the right method of the right function, returns
         * the result of that function
         * 
         * @param function
         * @return String resultOfFunction
         */
        public static String callFunction(String function, ArrayList<Object> cellContents) throws IllegalArgumentException {
                
                // I count on the fact that the functions return strings
                switch (function) {

                case "AVERAGE": {
                        return Functions.average(cellContents);
                }
                case "COUNT": {
                        return Functions.count(cellContents);
                }
                case "COUNTA": {
                        return Functions.counta(cellContents);
                }
                case "COUNTIF": {
                        return Functions.countif(cellContents);
                }
                case "IF": {
                        // WE CALL THE FUNCTION "IF"-METHOD: ifFunction, because a method
                        // cannot be called "if"
                        return Functions.ifFunction(cellContents);
                }
                case "INT": {
                        return Functions.intFunction(cellContents);
                        // WE CALL THE FUNCTION "INT"-METHOD: intFunction, because a method
                        // cannot be called "int"
                }
                case "ISLOGICAL": {
                        return Functions.islogical(cellContents);
                }
                case "ISEVEN": {
                        return Functions.iseven(cellContents);
                }
                case "ISNUMBER": {
                        return Functions.isnumber(cellContents);
                }
                case "LOWER": {
                        return Functions.lower(cellContents);
                }
                case "MAX": {
                        return Functions.max(cellContents);
                }
                case "MEDIAN": {
                        return Functions.median(cellContents);
                }
                case "MIN": {
                        return Functions.min(cellContents);
                }
                case "MOD": {
                        return Functions.mod(cellContents);
                }
                case "NOT": {
                        return Functions.not(cellContents);
                }
                case "OR": {
                        return Functions.or(cellContents);
                }
                case "POWER": {
                        return Functions.power(cellContents);
                }
                case "PRODUCT": {
                        return Functions.product(cellContents);
                }
                case "PROPER": {
                        return Functions.proper(cellContents);
                }
                case "ROUNDDOWN": {
                        return Functions.rounddown(cellContents);
                }
                case "ROUNDUP": {
                        return Functions.roundup(cellContents);
                }
                case "SIGN": {
                        return Functions.sign(cellContents);
                }
                case "SQRT": {
                        return Functions.sqrt(cellContents);
                }
                case "SUM": {
                        return Functions.sum(cellContents);
                }
                case "SUMIF": {
                        return Functions.sumif(cellContents);
                }
                default:
                        throw new IllegalArgumentException("Please fill in a valid function");

                }
        }

		@Override
		public int getColumnCount() {
			this.hasCol(1, 1);
			return this.getSizeCol(1);
		}

		@Override
		public int getRowCount() {
			int a = this.getSizeRow();
			return this.getSizeRow();
		}

		@Override
		public Object getValueAt(int y, int x) {
			this.getContent(x, y);
			return null;
		}
	
	
	
	
	
	
	
	
	
	
	
}
