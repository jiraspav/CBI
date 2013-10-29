package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.CloseBracketOperation;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;
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

    protected abstract void buildTree(ArithmeticComponent operator);

    
    
    protected void addOpenBracket() {
        array.add(new OpenBracketOperation());
    }

    protected void addCloseBracket() {
        array.add(new CloseBracketOperation());
    }
}
