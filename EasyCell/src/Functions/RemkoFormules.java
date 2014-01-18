/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Functions;

import java.util.ArrayList;

/**
 *
 *    AVERAGE/COUNT/COUNTA/COUNTIF/IF	
 * 
 *   IF -> ifFunction
 */
public class RemkoFormules {
    
    	public static String average(ArrayList<Object> input){
		double result = 0;
                
			for(Object number: input)
			{
				if(number instanceof Integer || number instanceof Double)
				{
					result = result + (double)number;
				}
			}
		
		return Double.toString(result/input.size());	
	}
        
        public static String count(ArrayList<Object> input){
                return Double.toString(input.size());
	}
                
        public static String counta(ArrayList<Object> input){
                          
                int i = 0;     
                
                while (input.contains(null)){
                    
                    if (input.get(i) == null){
                    input.remove(i);
                
                    }
                        else 
                        i++;
                    }
                
                       
                 return Double.toString(input.size());
        }		
      
        public static String countif(ArrayList<Object> input){
           
            
            int initial = input.size();
            String criteria = input.get(0).toString();
            String temp1 = "";
            String temp2 = "";
            String temp3 = "";
            
            
            for (int i = 1; i < input.size();){
                
                temp2 = temp1 + criteria;
                temp2 =  criteria + temp1 ;
                
                
                // here i need to take 2 cases for temp2 and temp3 because i have no idea of know what the positioning of the operator is 
                // for example it could be <3 but also 3< would we have to make one of these an invalid input? eg only 3< and 3> is allowed.   
                
                if (boolean.valueOf(temp2)){
                    input.remove(i);
                
                    }
                        else 
                        i++;
        }
            
            
        return Double.toString(input.size());

        }
