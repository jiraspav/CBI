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
        binaryOperatorsStack.add(temp);
        
        if(current != null){
            current.addOperand(temp);
            temp.setParent(current);
        }
        current = temp;
        isRoot = false;
        
        if(root == null){
            root = current;
            isRoot = true;
        }
    }

    @Override
    public void endCurrentBinaryOperator() {
        
        binaryOperatorsStack.remove(binaryOperatorsStack.size()-1);
        current = binaryOperatorsStack.get(binaryOperatorsStack.size()-1);
        
    }
    
    @Override
    public void appendNumericOperand(String string) {
        
        NumericOperand child = new NumericOperand(Integer.parseInt(string));
                
        while(current.getOperands().size() == 2){

            endCurrentBinaryOperator();
            
        }

        current.addOperand(child);
    }

    @Override
    public void changeComponentTo(BinaryOperator operator) {
        
        operator.copyAndSetChildrenAndParents(current);
        
        switchOperatorsInStack(operator, current);
        
        current = operator;
        
        if(isRoot){
            root = current;
        }
        
    }

    private void switchOperatorsInStack(BinaryOperator operator, ArithmeticComponent current) {
        
        for (ListIterator<ArithmeticComponent> it = binaryOperatorsStack.listIterator(); it.hasNext();) {
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
        expression.setRoot(root);
    }

    
    
}
