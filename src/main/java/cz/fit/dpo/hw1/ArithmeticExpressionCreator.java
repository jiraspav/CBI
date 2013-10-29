package main.java.cz.fit.dpo.hw1;


import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.builder.ExpressionDirector;
import main.java.cz.fit.dpo.hw1.builder.strategy.BuilderStrategy;
import main.java.cz.fit.dpo.hw1.builder.strategy.InOrderBuilderStrategy;
import main.java.cz.fit.dpo.hw1.builder.strategy.RPNBuilderStrategy;


/**
 * Stupid class which can create some {@link ArithmeticExpression}s.
 * 
 * @author Jan Kurš
 *
 */
public class ArithmeticExpressionCreator
{
	/**
	 * Creates 3 - (1 + 2)
	 * 
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression1()
	{
                return buildExpression(new InOrderBuilderStrategy(), "3 - (1 + 2)");
	}

	/**
	 * Creates (3 - 1) + 2
	 *
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression2()
	{
                return buildExpression(new InOrderBuilderStrategy(), "(3 - 1) + 2");
	}
	
	/**
	 * Creates any expression from the RPN input. This is nice and
	 * 	universal. 
	 * 
	 * @see http://en.wikipedia.org/wiki/Reverse_Polish_notation
	 * 	
	 * @param input in Reverse Polish Notation
	 * @return {@link ArithmeticExpression} equivalent to the RPN input.
	 */
	public ArithmeticExpression createExpressionFromRPN(String input)
	{
                return buildExpression(new RPNBuilderStrategy(), input);
	}
        
        private ArithmeticExpression buildExpression(BuilderStrategy strategy, String expression){
            
            return new ExpressionDirector(strategy).buildExpression(expression);
            
        }
        
}
