/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder;

import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;
import main.java.cz.fit.dpo.hw1.builder.strategy.BuilderStrategy;

/**
 *
 * @author Pavel
 */
public class ExpressionDirector {

    private BuilderStrategy strategy;

    public ExpressionDirector(BuilderStrategy strategy) {
        this.strategy = strategy;
    }
    
    public ArithmeticExpression buildExpression(String expression){
        
        strategy.init();
        
        String[] split = expression.split(" ");
        
        for (String input : split) {
            
            strategy.processInput(input);
            
        }
        
        strategy.end();
        
        return strategy.getArithmeticExpression();
    }
    
}
