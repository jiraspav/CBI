package main.java.cz.fit.dpo.hw1.arithmetic;

import main.java.cz.fit.dpo.hw1.arithmetic.elements.AddOperation;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;

/**
 * Represents + operation
 * 
 * @author Jan Kurš
 * 
 */
public class AddOperator extends BinaryOperator
{
        public AddOperator() {
            super();
        }

        public AddOperator(ArithmeticComponent operand)
	{
		super(operand);
	}
        
	public AddOperator(ArithmeticComponent firstOperand, ArithmeticComponent secondOperand)
	{
		super(firstOperand, secondOperand);
	}

        
        
	@Override
	protected Integer evaluate(Integer val1, Integer val2)
	{
		return val1 + val2;
	}

        @Override
        public ExpressionElement getComponentElement() {
            return new AddOperation();
        }
}
