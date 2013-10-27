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
        
        for (String string : split) {
            
            if(string.startsWith("(")){
                
                builder.createNewBinaryComponent();
                
                if(string.length() != 1){
                    builder.appendNumericOperand(string.substring(1, string.length()));
                }
                
            }
            else if(string.endsWith(")")){

                if(string.length() != 1){
                    builder.appendNumericOperand(string.substring(0, string.length()-1));
                }
                
                builder.endCurrentBinaryComponent();
                
            }
            else if(string.equals("+")){
                    
                builder.changeComponentTo(new AddOperator());
               
            }
            else if(string.equals("-")){
                
                builder.changeComponentTo(new SubstractOperator());
               
            }
            else if(isNumber(string)){
                
                builder.setUpRoot();
                builder.appendNumericOperand(string);
                
            }
            else{
                throw new NumberFormatException("Dont know how to do it :(");
            }
        }
        
        builder.eof();
        
        return builder.getArithmeticExpression();
    }
    
    

    public ArithmeticExpression buildRPNExpression(RPNExpressionBuilder builder, String string) {
        
        builder.createNewExpression();
        
        String[] split = string.split(" ");
        
        List<ArithmeticComponent> binaryComponentStack = new ArrayList<>();
        ArithmeticComponent current = null;
        ArithmeticComponent root = null;
        
        for(int i = split.length-1; i >= 0; i--){
            
            String input = split[i];
            
            if(isNumber(input)){
                
                builder.appendNumericOperand(input);
                
            }
            else {
                
                
                
                if(input.equals("+")){
                    
                    builder.createNewBinaryComponent();
                    builder.changeComponentTo(new AddOperator());
                    
                }
                else if(input.equals("-")){

                    builder.createNewBinaryComponent();
                    builder.changeComponentTo(new SubstractOperator());
                    
                    ArithmeticComponent temp = new SubstractOperator();
                    if(current != null){
                        current.addOperand(temp);
                        temp.setParent(current);
                    }
                    current = temp;
                    
                    binaryComponentStack.add(current);
                    
                    if(root == null){
                        root = current;
                    }
                }
                else{

                    throw new IllegalArgumentException("Dont know how to do that: "+input);

                }
                
            }
            
        }
        
        ArithmeticExpression e = new ArithmeticExpression();
        e.setRoot((BinaryOperator)root);
        
        return e;
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
