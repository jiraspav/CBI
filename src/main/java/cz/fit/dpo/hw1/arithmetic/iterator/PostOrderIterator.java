package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.NumericOperand;

public class PostOrderIterator extends IteratorParent {

    public PostOrderIterator(ArithmeticComponent root) {  
        buildTree(root);
        arrayIterator = array.iterator();
    }

    @Override
    protected final void buildTree(ArithmeticComponent operator) {
        if(!(operator instanceof NumericOperand)){
            buildTree(operator.getFirstOperand());
            buildTree(operator.getSecondOperand());
        }
        array.add(operator.getComponentElement());
    }


}
