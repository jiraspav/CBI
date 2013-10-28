/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder.strategy;

import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.builder.ExpressionBuilder;

/**
 *
 * @author Pavel
 */
public abstract class BuilderStrategy {

    protected ExpressionBuilder builder;
    
    public abstract void processInput(String input);

    public void init(){
        
        builder.createNewExpression();
        
    }

    public void end(){
        
        builder.eof();
        
    }

    public ArithmeticExpression getArithmeticExpression() {
        
        return builder.getArithmeticExpression();
        
    }
    
    protected boolean isNumber(String string){
        
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
