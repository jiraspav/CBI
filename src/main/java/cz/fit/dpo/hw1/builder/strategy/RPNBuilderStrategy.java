/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder.strategy;

import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;
import main.java.cz.fit.dpo.hw1.builder.RPNExpressionBuilder;

/**
 *
 * @author Pavel
 */
public class RPNBuilderStrategy extends BuilderStrategy{
    
    public RPNBuilderStrategy() {
        
        builder = new RPNExpressionBuilder();
        
    }
    
    @Override
    public void processInput(String input){
    
        if(isNumber(input)){
                
            handleNumber(input);

        }
        else {

            if(input.equals("+")){

                handleNewBinary(new AddOperator());

            }
            else if(input.equals("-")){

                handleNewBinary(new SubstractOperator());

            }
            else{

                throw new IllegalArgumentException("Dont know how to do that: "+input);

            }

        }
        
    }
    
    private void handleNumber(String input){
        
        builder.appendNumericOperand(input);
        
    }
    
    private void handleNewBinary(BinaryOperator operator){
    
        builder.createNewBinaryOperator();
        builder.changeComponentTo(operator);
        
    }
    
    
}
