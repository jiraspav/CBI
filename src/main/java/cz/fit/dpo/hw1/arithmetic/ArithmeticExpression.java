package main.java.cz.fit.dpo.hw1.arithmetic;

import java.util.Iterator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;
import main.java.cz.fit.dpo.hw1.arithmetic.iterator.InOrderIterator;
import main.java.cz.fit.dpo.hw1.arithmetic.iterator.PostOrderIterator;

public class ArithmeticExpression
{
	private ArithmeticComponent root;
	
	public Integer evaluate()
	{
		return root.evaluate();
	}
	
	public void setRoot(ArithmeticComponent root)
	{
		this.root = root;
	}

	/**
	 * {@link #root} field getter.
	 * 
	 * @deprecated Do not provide access to the inner representation
	 */
	public BinaryOperator getRoot()
	{
            throw new UnsupportedOperationException("");
            //return (BinaryOperator) root;
	}
	
	/**
	 * Should be implemented.
	 * 
	 * @return
	 */
	public Iterator<ExpressionElement> getInOrderIterator()
	{
		return new InOrderIterator(root);
	}

	/**
	 * Should be implemented
	 * 
	 * TODO
	 * 
	 * @return
	 */
	public Iterator<ExpressionElement> getPostOrderIterator()
	{
		return new PostOrderIterator(root);
	}

}
