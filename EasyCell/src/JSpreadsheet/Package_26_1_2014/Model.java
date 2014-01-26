package JSpreadsheet.Package_26_1_2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.AbstractTableModel;


public class Model extends AbstractTableModel {
	
	
protected ArrayList<ArrayList<String>> table;

	public Model(){
		table = new ArrayList<ArrayList<String>>();
	}
	
	/**
	 * Method to check how many rows a table has
	 * @return - Number of rows the table has
	 */
	public int getRows(){
		return table.size();
	}
		
	/**
	 * Adds a row to the column
	 */
	public void addRow(){
		table.add(new ArrayList<String>());
	}
	
	/**
	 * Adds a column to the 
	 * @param row
	 */
	public void addColumn(int row){
		if(this.getRows() >= row){
			(table.get(row)).add(" ");
		}else{
			ensureRows(row);
		}
	}
	
	
	/**
	 * Method that returns the amount of columns on the specified row
	 * @param row - Number of the row where you want to check how many columns there are.
	 * @return - returns amount of colums
	 */
	public int getCols(int row){
		if(this.getRows() >= row){
			return (table.get(row)).size();
		}else{
			throw new IllegalArgumentException("The table doesn't have that many rows");
		}
	}
	
	/**
	 * Method to ensure that there are the number of rows the user specifies
	 * @param row - rows to be had
	 */
	public void ensureRows(int row){
		while(this.getRows() <= row){
			this.addRow();
		}
	}
	/**
	 * Method to ensure that there are the amount of columns on the row the user specifies, also creates rows if the row does not exist
	 * @param row - Rows to be had
	 * @param col - Columns to be had
	 */
	public void ensureCols(int row, int col){
		ensureRows(row);
		while(this.getCols(row) <= col){
			addColumn(row);
		}
	}
	
	/**
	 * Method to set the content of a specific tablecell, first ensures that it exist by using the EnsureCols() method
	 * @param row - Row of cell where the content needs to be set
	 * @param col - Column of the cell where the content needs to be set.
	 * @param content - Content to be set
	 */
	public void setContent(int row, int col, String content){
		ensureCols(row, col);
		(table.get(row)).set(col, content);
	}
	
	public String getContent(int row, int col){
		if(this.getRows() >= row){
			if(this.getCols(row) >= col){
				return (String) (table.get(row)).get(col);
			}else{
				throw new IllegalArgumentException("There aren't that many Columns!");
			}
		}else{
			throw new IllegalArgumentException("There aren't that many Rows!");
		}
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
        protected String[] cellReader(String cell) {
        	if(cell.equals("") || cell.equals(null)){
                    String[] arrayResult = {"", ""};
                    return arrayResult;
        	}
        	 // check if cellcontent starts with "="
            if (!(cell.charAt(0) == ('='))){
                String[] arrayResult = {cell, ""};
            	return arrayResult;
            }
            else {  
                // trim cell from empty spaces at beginning and ending
                cell = cell.trim();
                // String where the content of cell will be kept while being processed
                // (until become the index)
                String nwcell;
                
                try {
                        {
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
        
                                // Call the method to perform calculations and return
                                
                                String[] arrayResult = {callFunction(function, result), ""};
                                return arrayResult;
        
                        }
                        
                } catch(IllegalArgumentException e)
                {
                    String[] arrayResult = {"#ERROR", e.getMessage()};
                    return arrayResult; 
                        
                        // TO DO: VERY IMPORTENT: This should be put in the separate bar for the error message!
                        // return JOptionPane.showMessageDialog(null, "Error: "+e.getCause().getMessage());
                }
            }  



        }

        /**
         * method functionTrimmer removes String function and brackets from
         * cellcontent 
         * Receives input as: "FUNCTION(x1y1,x3y2)" (So "=" is already
         * removed) Returns input as: x1y1,x3y2
         * 
         * @param input
         * @return String
         */
        public static String functionTrimmer(String input) {

        	 String function = Model.getFunction(input);
    		 String regex = "(^[A-Z]+)\\({1}.+\\){1}$";

             if (Model.functionExist(function)) {
            	  	                 
    	                 if(input.matches(regex))
    	                 {
    	                	// remove String function and brackets
        	                 input = input.replace(function, "");
    	                	 
	    	                 input = input.replace(" ", "");
	    	                 input = input.replaceFirst("\\(", "");
	    	                 input = input.substring(0, input.length()-1);
	    	             }
    	                 else
    	                 {
    	                	 throw new IllegalArgumentException("Please insert a function matching this order: FUNCTION(xXyY,xXyY, etc)");
    	                 }
             }
             else
             {
            	 throw new IllegalArgumentException("This function does not exist");
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
         * Recieves input as x1y2,x5y3:x33y3 etc.
         * Cuts out the "," and puts the pieces in ArrayList<String>
         * 
         * Scans for ":", sorts the indexes out one by one
         * then fetches the contents and put them in ArrayList<String>
         * If 
         * 
         * @param index
         */
        protected ArrayList<Object> indexExpander(String index) throws IllegalArgumentException {

 
                ArrayList<Object> result = new ArrayList<Object>();
//                Pattern for ONLY a coordinate
                String coordinate = "(^x{1})([0-9]{0,3})(y{1})([0-9]{0,3}$)";
                String containsCoor = ".*(x{1})([0-9]{0,3})(y{1})([0-9]{0,3}).*";  
                String fitsRangeWithProperCoordinates = "(^x{1})([0-9]{0,3})(y{1})([0-9]{0,3})" + "\\:" + "(x{1})([0-9]{0,3})(y{1})([0-9]{0,3}$)";
                
//                Cut out white spaces
                index = index.replace(" ", "");
                
//                Get indexes separated by commas in an arraylist
                ArrayList<String> items = new ArrayList<String>(Arrays.asList(index.split(",")));
                
                for(String item: items)
                {
//                        check if stringpiece contains ":"
                        if(item.contains(":"))
                        {
//                          Check whether on the left and right of the ":" there are Coordinates
                          if(!(item.matches(fitsRangeWithProperCoordinates)))
                          {
                                  throw new IllegalArgumentException("Please give two coordinates for a range");
                          }
                                String[] tempCoorSeperate = new String[2];
//                                
//                                separate by ":" into two stringpieces
                                tempCoorSeperate = item.split(":");


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
                                                result.add(contentParser(this.getContent(j,i)));

                                        }
                                }
                                
                        }        //end of ":"-case 
                        
//                        handle when String piece does not contain ":"
                        else 
                        { 
//                                Check if String is a coordinate
                                if(item.matches(coordinate))
                                {
//                                        If so, fetch the content of the Coordinate and add's it to result
                                        result.add(contentParser(this.getCoorContent(item)));
                                        
                                }        
//                                        If item has coordinate
                                else if(item.matches(containsCoor))
                                {
//                                	If so, replaces the coordinate with it's content and add's it to result
                                       result.add(this.replaceCoor(item));
                                }
                                else 
                                {
//                                If item is not a coordinate and doesn't contain a coordinate,
//                                call method to parse to right parameter type 
                                        
//                                Call parser method and add to result
                                  result.add(contentParser(item));
                                }
                        }

                }
                
                return result;

        }


        /**
         * method getCoorContent
         * input: A coor (no more then that!)
         * Output: A String with the coor's content
         */
        protected String getCoorContent(String coor)
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
                
                return  (this.getContent(y,x));
                
                
        }
        
        public static int getCoorX(String coor)
        {
//                Delete "x"
                coor = coor.replace("x", "");
                
//                Split on "y"
                String[] temp = new String[2];
                
//                Get int x
                temp = coor.split("y");
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
                temp = coor.split("y");
                
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
        protected String replaceCoor(String hasCoor)
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
                    
                    throw new IllegalArgumentException("Please fill in a valid function");

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
			return this.getCols(getRows() - 1);
		}

		@Override
		public int getRowCount() {
			return this.getRows();
		}

		@Override
		public Object getValueAt(int row, int col) {
			if((this.getRows() > row) && (this.getCols(row) > col)){
				return this.getContent(row, col);
			}else {
				return null;
			}
		}
}
