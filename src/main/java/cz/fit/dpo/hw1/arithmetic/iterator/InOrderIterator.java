package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;

public class InOrderIterator extends IteratorParent implements IteratorVisitor{

    public InOrderIterator(ArithmeticComponent root) {
        
        buildTree(root);
        arrayIterator = array.iterator();
        
    }

    @Override
    protected final void buildTree(ArithmeticComponent operator) {
        
        operator.createTree(this);
 
    }

    @Override
    public void buildTreeNumeric(ArithmeticComponent operator) {
        array.add(operator.getComponentElement());
    }

    
    @Override
    public void buildTreeBinary(ArithmeticComponent operator) {
        
        addOpenBracket();
        buildTree(operator.getFirstOperand());
        
        array.add(operator.getComponentElement());
        
        buildTree(operator.getSecondOperand());
        addCloseBracket();
    }
    
    
    
}