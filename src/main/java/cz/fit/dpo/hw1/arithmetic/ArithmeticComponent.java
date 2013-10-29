package main.java.cz.fit.dpo.hw1.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.Number;
import main.java.cz.fit.dpo.hw1.arithmetic.iterator.IteratorVisitor;


public class ArithmeticComponent {
    
    private List<ArithmeticComponent> operands;
    private ArithmeticComponent parent;
    protected Integer value;
    
    
    public ArithmeticComponent() {
        operands = new ArrayList<>();
    }
    public ArithmeticComponent(Integer value) {
        this();
        this.value = value;
    }
    
    public ArithmeticComponent(ArithmeticComponent copyFrom) {
        this();
        
        if(copyFrom != null){
        
            copyAndSetChildrenAndParents(copyFrom);
            
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
    
    private void setChildForParent(ArithmeticComponent parent, ArithmeticComponent child){
        
        if(parent != null){

            List<ArithmeticComponent> children = parent.getOperands();


            for (ListIterator<ArithmeticComponent> it = children.listIterator(); it.hasNext();) {
                ArithmeticComponent arithmeticComponent = it.next();

                if(arithmeticComponent.equals(child)){
                    it.set(this);
                    break;
                }
            }

        }
        
    }
    
    public final void copyAndSetChildrenAndParents(ArithmeticComponent copyFrom){
        
        this.setOperands(copyFrom.getOperands());
        this.setParentForOperands();
        this.setParent(copyFrom.getParent());
        this.setChildForParent(copyFrom.getParent(), copyFrom);
        
    }
    
    public void addOperand(ArithmeticComponent comp){
        
        getOperands().add(comp);
        
    }
    
    public Integer evaluate(){
        
        return null;
        
    }
    
    public ExpressionElement getComponentElement(){
        
        return new Number(value);
        
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

    public void createTree(IteratorVisitor visitor) {}

    

    
}
