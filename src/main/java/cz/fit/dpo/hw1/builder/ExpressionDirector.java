package main.java.cz.fit.dpo.hw1.builder;

import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.builder.strategy.BuilderStrategy;


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
