package main.java.cz.fit.dpo.hw1.arithmetic;


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
    public void sout(){
        System.out.println("---");
        System.out.println(this.getValue());
        System.out.println("parent: "+this.getParent());
        System.out.println("---");
    }
	
}
