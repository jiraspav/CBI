package main.java.cz.fit.dpo.hw1.arithmetic;

import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.SubstractOperation;

/**
 * Represents - operation
 * 
 * @author Jan Kurš
 */
public class SubstractOperator extends BinaryOperator
{

	

        public SubstractOperator() {
            super();
        }
        
        public SubstractOperator(ArithmeticComponent operand)
	{
		super(operand);
	}
        
        public SubstractOperator(ArithmeticComponent firstOperand, ArithmeticComponent secondOperand)
	{
		super(firstOperand, secondOperand);
	}
        
	@Override
	protected Integer evaluate(Integer val1, Integer val2)
	{
		return val1 - val2;
	}

        @Override
        public ExpressionElement getComponentElement() {
            return new SubstractOperation();
        }
        
}
