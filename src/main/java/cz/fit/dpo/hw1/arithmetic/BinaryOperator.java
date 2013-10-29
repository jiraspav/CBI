package main.java.cz.fit.dpo.hw1.arithmetic;

import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;
import main.java.cz.fit.dpo.hw1.arithmetic.iterator.IteratorVisitor;


/**
 * Represents the Binary operations like + - etc.
 * 
 * @author Jan Kurš
 *
 */
public abstract class BinaryOperator extends ArithmeticComponent
{
	

    protected abstract Integer evaluate(Integer val1, Integer val2);
    @Override
    public abstract ExpressionElement getComponentElement();
    
    
    public BinaryOperator() {
        super();
    }

    public BinaryOperator(ArithmeticComponent operand)
    {
            super(operand);
    }

    public BinaryOperator(ArithmeticComponent firstOperand, ArithmeticComponent secondOperand)
    {
            super(firstOperand, secondOperand);
    }
	
    
    @Override
    public void createTree(IteratorVisitor visitor){
    
        visitor.buildTreeBinary(this);
    
    }
        
	
    @Override
    public Integer evaluate()
    {
            int val1 = getOperandValue(getFirstOperand());
            int val2 = getOperandValue(getSecondOperand());

            return evaluate(val1, val2);
    }

    private Integer getOperandValue(Object o)
    {
            if (o instanceof NumericOperand)
            {
                    return ((NumericOperand)o).getValue();
            }

            if (o instanceof BinaryOperator)
            {
                    return ((BinaryOperator)o).evaluate();
            }

            throw new IllegalArgumentException("Unsuported operand type!");
    }
	
}
