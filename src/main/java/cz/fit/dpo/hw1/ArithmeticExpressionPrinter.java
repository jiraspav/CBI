package main.java.cz.fit.dpo.hw1;

import java.util.Iterator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.elements.ExpressionElement;

/**
 * Printer for {@link ArithmeticExpression}s. It can print inOrder notation (3 +
 * 1) or postOrder notation (3 1 +).
 *
 * PostOrder is RPN (Reverse Polish Notation) in fact. See wiki for more
 * information.
 *
 * @author Jan Kurš
 *
 */
public class ArithmeticExpressionPrinter {

    private ArithmeticExpression expression;

    public ArithmeticExpressionPrinter(ArithmeticExpression expression) {
        setExpression(expression);
    }

    private void setExpression(ArithmeticExpression expression) {
        this.expression = expression;
    }

    /**
     * Print an expression in classical notation, e.g. (3+1).
     *
     * The "(" and ")" is used to preserve priorities.
     *
     * @return String in classical "inOrder" format.
     */
    public String printInOrder() {
       
        StringBuilder buffer = new StringBuilder();

        Iterator<ExpressionElement> it = expression.getInOrderIterator();
        while (it.hasNext()) {
            buffer.append(it.next().stringValue());
        }
        return buffer.toString();
    }

    /**
     * Print an expression in RPN notation, e.g. 3 1 +.
     *
     * Please note, the "(" and ")" is no longer necessary, because RPN does not
     * need them :)
     *
     * @return string in "postOrder" (RPN) format.
     */
    public String printPostOrder() {
        
        StringBuilder buffer = new StringBuilder();

        Iterator<ExpressionElement> it = expression.getPostOrderIterator();
        while (it.hasNext()) {
            buffer.append(it.next().stringValue());
            if(it.hasNext()){
                buffer.append(" ");
            }
        }
        return buffer.toString();

    }

}
