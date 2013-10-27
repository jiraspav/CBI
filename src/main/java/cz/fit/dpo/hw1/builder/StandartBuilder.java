/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder;

import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;

/**
 *
 * @author Pavel
 */
public interface StandartBuilder {
    
    
    public void createNewExpression();
    
    public ArithmeticExpression getArithmeticExpression();

    public void createNewBinaryComponent();
    
    public void endCurrentBinaryComponent();
    
    public void appendNumericOperand(String string);
    
    public void changeComponentTo(BinaryOperator operator);

    public void setUpRoot();
    
    public void eof();

    
}
