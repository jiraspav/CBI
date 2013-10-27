/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.NumericOperand;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;

/**
 *
 * @author Pavel
 */
public class ExpressionDirector {

    
    
    public ArithmeticExpression buildExpression(StandartBuilder builder, String expression){
        
        builder.createNewExpression();
        
        String[] split = expression.split(" ");
        
        for (String input : split) {
            
            if(input.startsWith("(")){
                
                builder.createNewBinaryOperator();
                
                if(input.length() != 1){
                    builder.appendNumericOperand(input.substring(1, input.length()));
                }
                
            }
            else if(input.endsWith(")")){

                if(input.length() != 1){
                    builder.appendNumericOperand(input.substring(0, input.length()-1));
                }
                
                builder.endCurrentBinaryOperator();
                
            }
            else if(input.equals("+")){
                    
                builder.changeComponentTo(new AddOperator());
               
            }
            else if(input.equals("-")){
                
                builder.changeComponentTo(new SubstractOperator());
               
            }
            else if(isNumber(input)){
                
                builder.setUpRoot();
                builder.appendNumericOperand(input);
                
            }
            else{
                throw new IllegalArgumentException("Dont know how to do that: "+input);
            }
        }
        
        builder.eof();
        
        return builder.getArithmeticExpression();
    }
    
    

    public ArithmeticExpression buildRPNExpression(RPNExpressionBuilder builder, String string) {
        
        builder.createNewExpression();
        
        String[] split = string.split(" ");
        
        for(int i = split.length-1; i >= 0; i--){
            
            String input = split[i];
            
            if(isNumber(input)){
                
                builder.appendNumericOperand(input);
                
            }
            else {
                
                if(input.equals("+")){
                    
                    builder.createNewBinaryOperator();
                    builder.changeComponentTo(new AddOperator());
                    
                }
                else if(input.equals("-")){

                    builder.createNewBinaryOperator();
                    builder.changeComponentTo(new SubstractOperator());
                  
                }
                else{

                    throw new IllegalArgumentException("Dont know how to do that: "+input);

                }
                
            }
            
        }
        
        builder.eof();
        
        return builder.getArithmeticExpression();
    }
    
    private boolean isNumber(String string){
        
        boolean result = true;
        
        try{
            Integer.parseInt(string);
        }
        catch(NumberFormatException e){
            result = false;
        }
            
        return result;
        
    }
    
}
