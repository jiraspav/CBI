package main.java.cz.fit.dpo.hw1.arithmetic;

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
        public void sout(){
            System.out.println("---");
            System.out.println(this);
            System.out.println("parent: "+this.getParent());
            System.out.println("---");
        }
}
