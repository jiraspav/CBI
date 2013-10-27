package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.AddOperation;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.SubstractOperation;

public class PostOrderIterator extends IteratorParent {

    public PostOrderIterator(ArithmeticComponent root) {  
        buildTree(root);
        arrayIterator = array.iterator();
    }

    @Override
    protected void buildTree(AddOperator operator) {
        buildTree(operator.getFirstOperand());
        buildTree(operator.getSecondOperand());
        array.add(new AddOperation());
    }

    @Override
    protected void buildTree(SubstractOperator operator) {
        buildTree(operator.getFirstOperand());
        buildTree(operator.getSecondOperand());
        array.add(new SubstractOperation());
    }


}
