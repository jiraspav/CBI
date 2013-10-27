/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder;

import java.util.ArrayList;
import java.util.List;
import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.NumericOperand;

/**
 *
 * @author Pavel
 */
public class RPNExpressionBuilder implements StandartBuilder{
    
    private ArithmeticExpression expression;
    List<ArithmeticComponent> binaryComponentStack = new ArrayList<>();
    ArithmeticComponent current = null;
    ArithmeticComponent root = null;
    
    
    @Override
    public ArithmeticExpression getArithmeticExpression() {
        return expression;
    }

    @Override
    public void createNewExpression() {
        expression = new ArithmeticExpression();
    }

    @Override
    public void createNewBinaryComponent() {
        
        ArithmeticComponent temp = new AddOperator();
        
        if(current != null){
            current.addOperand(temp);
            temp.setParent(current);
        }
        current = temp;

        binaryComponentStack.add(current);



        if(root == null){
            root = current;
        }
    }

    @Override
    public void endCurrentBinaryComponent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void appendNumericOperand(String string) {
        
        NumericOperand child = new NumericOperand(Integer.parseInt(string));
                
        while(current.getOperands().size() == 2){

            System.out.println("Both operands full switching curr = "+current);
            binaryComponentStack.remove(binaryComponentStack.size()-1);
            current = binaryComponentStack.get(binaryComponentStack.size()-1);
            System.out.println(current);
        }

        current.addOperand(child);
    }

    @Override
    public void changeComponentTo(BinaryOperator operator) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setUpRoot() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eof() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
