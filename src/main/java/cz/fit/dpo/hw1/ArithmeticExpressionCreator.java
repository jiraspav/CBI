package main.java.cz.fit.dpo.hw1;


import java.util.Iterator;
import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.NumericOperand;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;
import main.java.cz.fit.dpo.hw1.builder.ArithmeticExpressionBuilder;
import main.java.cz.fit.dpo.hw1.builder.ExpressionDirector;
import main.java.cz.fit.dpo.hw1.builder.RPNExpressionBuilder;


/**
 * Stupid class which can create some {@link ArithmeticExpression}s.
 * 
 * @author Jan Kurš
 *
 */
public class ArithmeticExpressionCreator
{
    
     public static void main(String[] args) {
        
         ArithmeticExpressionCreator creator = new ArithmeticExpressionCreator();
         
        ArithmeticExpression createExpression1 = creator.createExpressionFromRPN("1 2 3 + -");
        //ArithmeticExpression createExpression2 = creator.createExpression1();
        creator.soutInOrderTree(createExpression1.getRoot());
        
        /*Iterator<ExpressionElement> inOrderIterator = creator.createExpression1().getInOrderIterator();
        while (inOrderIterator.hasNext()) {
        ExpressionElement expressionElement = inOrderIterator.next();
        System.out.print(" "+expressionElement.stringValue());
        }*/
    }
     public void soutInOrderTree(ArithmeticComponent operand) {
        
        if(operand != null){
            //System.out.println(operand);
            if(operand instanceof AddOperator){
                ((AddOperator)operand).sout();
            }
            if(operand instanceof SubstractOperator){
                ((SubstractOperator)operand).sout();
            }
            if(operand instanceof NumericOperand){
                ((NumericOperand)operand).sout();
            }
            try{
                System.out.println("Delka "+operand.getOperands().toArray().length);
                if(operand.getOperands().toArray().length != 0){
                    System.out.println("Left");
                    soutInOrderTree((ArithmeticComponent)operand.getOperands().toArray()[0]);
                    System.out.println("Right");
                    soutInOrderTree((ArithmeticComponent)operand.getOperands().toArray()[1]);
                }
            }
            catch(NullPointerException e){}
            
        }
        
    }
     
	/**
	 * Creates 3 - (1 + 2)
	 * 
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression1()
	{
//		ArithmeticExpression e = new ArithmeticExpression();
//		
//		NumericOperand op1 = new NumericOperand(1);
//		NumericOperand op2 = new NumericOperand(2);
//		NumericOperand op3 = new NumericOperand(3);
//		
//		BinaryOperator o2 = new AddOperator(op1, op2);
//		BinaryOperator o1 = new SubstractOperator(op3, o2);
//		
//		e.setRoot(o1);
//		return e;
                ExpressionDirector director = new ExpressionDirector();
                //( ( (1 + 2) - 3) + 4) + 5
                ArithmeticExpression expression = director.buildExpression(new ArithmeticExpressionBuilder(), "3 - (1 + 2)");
                
                return expression;
                
	}

	/**
	 * Creates (3 - 1) + 2
	 *
	 * This is ugly. I don't like creating expressions in this
	 * 	form. I never know, what expression I have created...
	 */
	public ArithmeticExpression createExpression2()
	{
		/*ArithmeticExpression e = new ArithmeticExpression();
		
		NumericOperand op1 = new NumericOperand(1);
		NumericOperand op2 = new NumericOperand(2);
		NumericOperand op3 = new NumericOperand(3);
		
		BinaryOperator o1 = new SubstractOperator(op3, op1);
		BinaryOperator o2 = new AddOperator(o1, op2);
		
		e.setRoot(o2);
		return e;*/
                ExpressionDirector director = new ExpressionDirector();
                ArithmeticExpression expression = director.buildExpression(new ArithmeticExpressionBuilder(), "(3 - 1) + 2");
                
                return expression;
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
		// Good entry point for Builder :)
		//throw new UnsupportedOperationException("Don't know how to do it :(");
                ExpressionDirector director = new ExpressionDirector();
                ArithmeticExpression expression = director.buildRPNExpression(new RPNExpressionBuilder(), input);
                
                return expression;
            
	}
}
