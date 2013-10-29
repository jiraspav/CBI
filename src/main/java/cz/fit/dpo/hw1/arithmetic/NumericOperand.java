package main.java.cz.fit.dpo.hw1.arithmetic;

import main.java.cz.fit.dpo.hw1.arithmetic.iterator.IteratorVisitor;


/**
 * Represents number in the arithmetic expression
 * 
 * @author Jan Kurš
 */
public class NumericOperand extends ArithmeticComponent{
	
    public NumericOperand(Integer value)
    {
            super(value);
    }

    public NumericOperand() {
        super();
    }
	
    @Override
    public Integer evaluate(){
        
        return value;
        
    }
    
    @Override
    public void createTree(IteratorVisitor visitor){
    
        visitor.buildTreeNumeric(this);
    
    }
    
}
