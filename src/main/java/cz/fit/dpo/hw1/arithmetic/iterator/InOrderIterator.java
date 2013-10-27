package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.AddOperation;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.SubstractOperation;

public class InOrderIterator extends IteratorParent {

    public InOrderIterator(ArithmeticComponent root) {
        buildTree(root);
        arrayIterator = array.iterator();
    }

    @Override
    protected void buildTree(AddOperator operator) {
        addOpenBracket();
        buildTree(operator.getFirstOperand());
        array.add(new AddOperation());
        buildTree(operator.getSecondOperand());
        addCloseBracket();
    }

    @Override
    protected void buildTree(SubstractOperator operator) {
        addOpenBracket();
        buildTree(operator.getFirstOperand());
        array.add(new SubstractOperation());
        buildTree(operator.getSecondOperand());
        addCloseBracket();
    }
}