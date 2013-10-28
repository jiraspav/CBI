/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder.strategy;

import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;
import main.java.cz.fit.dpo.hw1.builder.InOrderExpressionBuilder;
import main.java.cz.fit.dpo.hw1.builder.ExpressionBuilder;

/**
 *
 * @author Pavel
 */
public class InOrderBuilderStrategy extends BuilderStrategy{
    

    public InOrderBuilderStrategy() {
        
        builder = new InOrderExpressionBuilder();
        
    }
    
    
    @Override
    public void processInput(String input){
        
        if(input.startsWith("(")){
                
            handleOpenBracket(builder, input);

        }
        else if(input.endsWith(")")){

            handleCloseBracket(builder, input);

        }
        else if(input.equals("+")){

            handleChangeOperator(builder, new AddOperator());
            
        }
        else if(input.equals("-")){
            
            handleChangeOperator(builder, new SubstractOperator());

        }
        else if(isNumber(input)){

            handleNumber(builder, input);

        }
        else{
            throw new IllegalArgumentException("Dont know how to do that: "+input);
        }
        
    }
    
    private void handleOpenBracket(ExpressionBuilder builder, String input){
    
        builder.createNewBinaryOperator();

        if(input.length() != 1){
            builder.appendNumericOperand(input.substring(1, input.length()));
        }
            
    }
    
    private void handleCloseBracket(ExpressionBuilder builder, String input){
    
        if(input.length() != 1){
            builder.appendNumericOperand(input.substring(0, input.length()-1));
        }

        builder.endCurrentBinaryOperator();
            
    }
    
    private void handleChangeOperator(ExpressionBuilder builder, BinaryOperator operator) {
        
        builder.changeComponentTo(operator);
        
    }
    
    private void handleNumber(ExpressionBuilder builder, String input){
    
        builder.setUpRoot();
        builder.appendNumericOperand(input);
        
    }
    
    

}
