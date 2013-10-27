package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;
import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.NumericOperand;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.CloseBracketOperation;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.Number;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.OpenBracketOperation;

/**
 *
 * @author jiresrad
 */
public abstract class IteratorParent implements Iterator<ExpressionElement> {

    protected Collection<ExpressionElement> array = new ArrayList<>();
    protected Iterator<ExpressionElement> arrayIterator;

    @Override
    public boolean hasNext() {
        return arrayIterator.hasNext();
    }

    @Override
    public ExpressionElement next() {
        return arrayIterator.next();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    protected void buildTree(Object operator) {
        if (operator instanceof NumericOperand) {
            buildTree((NumericOperand) operator);
        } else if (operator instanceof BinaryOperator) {
            buildTree((BinaryOperator) operator);
        } else {
            throw new IllegalArgumentException("Unknown argument");
        }
    }

    protected void buildTree(BinaryOperator operator) {
        if (operator instanceof AddOperator) {
            buildTree((AddOperator) operator);
        } else if (operator instanceof SubstractOperator) {
            buildTree((SubstractOperator) operator);
        } else {
            throw new IllegalArgumentException("Unknown argument");
        }
    }

    protected abstract void buildTree(AddOperator operator);

    protected abstract void buildTree(SubstractOperator operator);

    protected void buildTree(NumericOperand operand) {
        array.add(new Number(((NumericOperand) operand).getValue()));
    }

    protected void addOpenBracket() {
        array.add(new OpenBracketOperation());
    }

    protected void addCloseBracket() {
        array.add(new CloseBracketOperation());
    }
}
