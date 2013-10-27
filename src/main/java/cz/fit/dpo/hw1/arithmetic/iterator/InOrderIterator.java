package main.java.cz.fit.dpo.hw1.arithmetic.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;


public class InOrderIterator implements Iterator<ExpressionElement>
{

    private ArithmeticComponent root;
    private ArithmeticComponent currentPosition;
    private ArithmeticComponent lastVisited;
    private int lastIndex = 0;
    
    private Collection<ArithmeticComponent> stack = new ArrayList<>();
    
    public InOrderIterator(ArithmeticComponent root) {
        this.root = root;
        currentPosition = root;
        buildInOrderTree(root);
    }

    private void buildInOrderTree(ArithmeticComponent operand) {
        
        if(operand != null){
            if(operand instanceof BinaryOperator){
                //operand.stringValue();
            }
            stack.add(operand);
            //buildInOrderTree(operand.getFirstOperand());
            //buildInOrderTree(operand.getSecondOperand());
        }
        
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
            
            return null;
            
            /*if(currentPosition.getFirstOperand().equals(lastVisited) && lastVisited != null){
                currentPosition = currentPosition.getSecondOperand();
            }
            else if(currentPosition.isBinaryOperator() && !currentPosition.getFirstOperand().equals(lastVisited)){
                lastVisited = currentPosition;
                currentPosition = currentPosition.getFirstOperand();
                return new OpenBracketOperation();
            }
            else{
                
                Number num = new Number(currentPosition.getValue());
                lastVisited = currentPosition;
                currentPosition = currentPosition.getParent();
                return num;
                
            }
		if (currentPosition.getFirstOperand() instanceof BinaryOperator){
                    currentPosition = (BinaryOperator) currentPosition.getFirstOperand();
                    return new OpenBracketOperation();
                }
                else if(currentPosition.getFirstOperand() instanceof NumericOperand){
                    
                    return new Number();
                }
		File a = new File("");*/
	}

	@Override
	public void remove()
	{
		// TODO Auto-generated method stub
		
	}

    

    

}
