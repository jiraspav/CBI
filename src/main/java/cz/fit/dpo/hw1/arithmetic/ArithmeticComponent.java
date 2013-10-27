/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.arithmetic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import main.java.cz.fit.dpo.hw1.arithmetic.iterator.InOrderIterator;
import main.java.cz.fit.dpo.hw1.arithmetic.iterator.PostOrderIterator;

/**
 *
 * @author Pavel
 */
public class ArithmeticComponent {
    
    private List<ArithmeticComponent> operands;
    private ArithmeticComponent parent;
    private Integer value;
    
    
    public ArithmeticComponent() {
        operands = new ArrayList<>();
    }
    public ArithmeticComponent(Integer value) {
        this();
        this.value = value;
    }
    
    public ArithmeticComponent(ArithmeticComponent copy) {
        this();
        
        if(copy != null){
        
            operands = copy.getOperands();
            setParent(copy.getParent());
            setParentForOperands();
            
        }
        
    }
    
    public ArithmeticComponent(ArithmeticComponent firstOperand, ArithmeticComponent secondOperand) {
        this();
        operands.add(firstOperand);
        operands.add(secondOperand);
        setParentForOperands();
    }
    private void setParentForOperands(){
        
        for (ArithmeticComponent arithmeticComponent : getOperands()) {
            arithmeticComponent.setParent(this);
        }
            
    }
    
    public boolean isBinaryOperator(){
        
        if(getFirstOperand() == null || getSecondOperand() == null){
            return false;
        }
        return true;
    }
    
    public boolean isNumericOperand(){
        return !isBinaryOperator();
    }
    
    public void addOperand(ArithmeticComponent comp){
        
        getOperands().add(comp);
        
    }
    
  
    public void setParent(ArithmeticComponent o)
    {
        parent =  o;
    }
    public void setValue(Integer value)
    {
            this.value = value;
    }
    public void setOperands(List<ArithmeticComponent> operands){
        this.operands = operands;
    }
    
    public ArithmeticComponent getParent()
    {
            return parent;
    }
    public Integer getValue()
    {
            return value;
    }
    public List<ArithmeticComponent> getOperands() {
        return operands;
    }
    public ArithmeticComponent getFirstOperand() {
        return (ArithmeticComponent) getOperands().toArray()[0];
    }

    public ArithmeticComponent getSecondOperand() {
        return (ArithmeticComponent) getOperands().toArray()[1];
    }

    public InOrderIterator inOrderIterator()
    {
            return new InOrderIterator(this);
    }

    public PostOrderIterator postOrderIterator()
    {
            return null;
    }

    

    
}
