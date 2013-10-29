package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;

public class PostOrderIterator extends IteratorParent implements IteratorVisitor{

    public PostOrderIterator(ArithmeticComponent root) {  
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
        
        buildTree(operator.getFirstOperand());
        buildTree(operator.getSecondOperand());
        
        array.add(operator.getComponentElement());
    }


}
