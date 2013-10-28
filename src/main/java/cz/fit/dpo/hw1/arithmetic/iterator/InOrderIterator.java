package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.NumericOperand;

public class InOrderIterator extends IteratorParent {

    public InOrderIterator(ArithmeticComponent root) {
        buildTree(root);
        arrayIterator = array.iterator();
    }

    @Override
    protected final void buildTree(ArithmeticComponent operator) {
        if(!(operator instanceof NumericOperand)){
            addOpenBracket();
            buildTree(operator.getFirstOperand());
        }
        array.add(operator.getComponentElement());
        
        if(!(operator instanceof NumericOperand)){
            buildTree(operator.getSecondOperand());
            addCloseBracket();
        }
    }

}