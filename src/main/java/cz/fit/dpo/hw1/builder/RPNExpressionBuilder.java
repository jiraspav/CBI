/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
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
    List<ArithmeticComponent> binaryOperatorsStack = new ArrayList<>();
    List<ArithmeticComponent> numericOperandStack = new ArrayList<>();
    ArithmeticComponent current = null;
    ArithmeticComponent root = null;
    boolean isRoot = false;
    
    
    @Override
    public ArithmeticExpression getArithmeticExpression() {
        return expression;
    }

    @Override
    public void createNewExpression() {
        expression = new ArithmeticExpression();
    }

    @Override
    public void createNewBinaryOperator() {
        
        ArithmeticComponent temp = new ArithmeticComponent();
        
        popAndSetChild(temp);
        
        numericOperandStack.add(temp);
        
        current = temp;
    }

    private ArithmeticComponent popAndSetChild(ArithmeticComponent comp){
    
        int positionLast = numericOperandStack.size() -1;
        
        comp.addOperand(numericOperandStack.get(positionLast-1));
        comp.addOperand(numericOperandStack.get(positionLast));
        numericOperandStack.get(positionLast).setParent(comp);
        numericOperandStack.get(positionLast-1).setParent(comp);
        numericOperandStack.remove(positionLast);
        numericOperandStack.remove(positionLast-1);
        
        return comp;
        
    }
    
    @Override
    public void endCurrentBinaryOperator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void appendNumericOperand(String string) {
        
        NumericOperand numericOperand = new NumericOperand(Integer.parseInt(string));
                
        numericOperandStack.add(numericOperand);
        
    }

    @Override
    public void changeComponentTo(BinaryOperator operator) {
        
        operator.copyAndSetChildrenAndParents(current);
        
        switchOperatorsInStack(operator, current);
        
        current = operator;
        
    }

    private void switchOperatorsInStack(BinaryOperator operator, ArithmeticComponent current) {
        
        for (ListIterator<ArithmeticComponent> it = numericOperandStack.listIterator(); it.hasNext();) {
            ArithmeticComponent arithmeticComponent = it.next();

            if(arithmeticComponent.equals(current)){
                it.set(operator);
                break;
            }
        }
    }
    
    @Override
    public void setUpRoot() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eof() {
        expression.setRoot(numericOperandStack.get(0));
    }

    
    
}
