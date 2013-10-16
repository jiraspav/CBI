package cz.fit.dpo.hw1.arithmetic;

import java.util.Iterator;

import cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;

public class ArithmeticExpression
{
	private BinaryOperator root;
	
	public Integer evaluate()
	{
		return root.evaluate();
	}
	
	public void setRoot(BinaryOperator root)
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
		return root;
	}
	
	/**
	 * Should be implemented.
	 * 
	 * @return
	 */
	public Iterator<ExpressionElement> getInOrderIterator()
	{
		throw new UnsupportedOperationException("Not yet implemented...");
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
		throw new UnsupportedOperationException("Not yet implemented...");
	}

}
