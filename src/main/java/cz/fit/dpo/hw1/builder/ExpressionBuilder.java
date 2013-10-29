package main.java.cz.fit.dpo.hw1.builder;

import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;

public interface ExpressionBuilder {
    
    
    public void createNewExpression();
    
    public ArithmeticExpression getArithmeticExpression();

    public void createNewBinaryOperator();
    
    public void endCurrentBinaryOperator();
    
    public void appendNumericOperand(String string);
    
    public void changeComponentTo(BinaryOperator operator);

    public void setUpRoot();
    
    public void eof();

    
}
