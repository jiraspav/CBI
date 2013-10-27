package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import java.util.Iterator;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;


public class PostOrderIterator implements Iterator<ExpressionElement>
{

    private BinaryOperator root;
    
    public PostOrderIterator(BinaryOperator root) {
        this.root = root;
    }
    
        
    
        
    
	@Override
	public boolean hasNext()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ExpressionElement next()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove()
	{
		// TODO Auto-generated method stub
		
	}

}
