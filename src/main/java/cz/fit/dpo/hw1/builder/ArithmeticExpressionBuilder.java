/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.NumericOperand;

/**
 *
 * @author Pavel
 */
public class ArithmeticExpressionBuilder implements StandartBuilder{

    private ArithmeticExpression expression;
    private List<ArithmeticComponent> binaryOperatorsStack = new ArrayList<>();
    private ArithmeticComponent current = null;
    private ArithmeticComponent root = null;
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
        
        ArithmeticComponent deeperComponent = new ArithmeticComponent();
        binaryOperatorsStack.add(deeperComponent);

        if(current != null){
            current.addOperand(deeperComponent);
            deeperComponent.setParent(current);
        }
        current = deeperComponent;

        isRoot = false;
        
    }

    @Override
    public void endCurrentBinaryOperator() {
        
        binaryOperatorsStack.remove(current);
                
                
        int positionOfLast = binaryOperatorsStack.size() - 1;

        if(positionOfLast < 0){
            if(root == null){
                root = new ArithmeticComponent();
            }

            root.addOperand(current);
            current.setParent(root);
            current = root;
            isRoot = true;
        }
        else{
            current = (ArithmeticComponent) binaryOperatorsStack.toArray()[positionOfLast];
            isRoot = false;
        }
        
    }
    
    @Override
    public void appendNumericOperand(String substring) {
        
        NumericOperand numericOperand = new NumericOperand(Integer.valueOf(substring));
        numericOperand.setParent(current);
        current.addOperand(numericOperand);
        
    }
    
    @Override
    public void setUpRoot(){
        
        if(root == null){
            root = new ArithmeticComponent();
            current = root;
        }
        isRoot = true;
        
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
    public void eof() {
        expression.setRoot(root);
    }
    
    
    
    
}
