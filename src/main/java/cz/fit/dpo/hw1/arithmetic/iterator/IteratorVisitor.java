package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;


public interface IteratorVisitor {
    
    public void buildTreeNumeric(ArithmeticComponent operator);
    public void buildTreeBinary(ArithmeticComponent operator);
    
}
