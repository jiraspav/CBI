/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.cz.fit.dpo.hw1.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import main.java.cz.fit.dpo.hw1.arithmetic.AddOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticComponent;
import main.java.cz.fit.dpo.hw1.arithmetic.ArithmeticExpression;
import main.java.cz.fit.dpo.hw1.arithmetic.BinaryOperator;
import main.java.cz.fit.dpo.hw1.arithmetic.NumericOperand;
import main.java.cz.fit.dpo.hw1.arithmetic.SubstractOperator;

/**
 *
 * @author Pavel
 */
public class ExpressionDirector {

    
    
    public ArithmeticExpression buildExpression(StandartBuilder builder, String expression){
        
        String[] split = expression.split(" ");
        
        List<ArithmeticComponent> binaryOperatorsStack = new ArrayList<>();
        
        ArithmeticComponent current = null;
        ArithmeticComponent root = null;
        boolean isRoot = false;
        
        for (String string : split) {
            
            if(string.startsWith("(")){
                
                ArithmeticComponent deeperComponent = new ArithmeticComponent();
                binaryOperatorsStack.add(deeperComponent);
                
                if(current != null){
                    current.addOperand(deeperComponent);
                    deeperComponent.setParent(current);
                }
                current = deeperComponent;
                
                isRoot = false;
                
                if(string.length() != 1){
                    current = addNumericComponent(current, string, 1);
                }
                
            }
            else if(string.endsWith(")")){
                

                if(string.length() != 1){
                    current = addNumericComponent(current, string, 0);
                }
                binaryOperatorsStack.remove(current);
                
                
                int positionOfLast = binaryOperatorsStack.size() - 1;
                
                if(positionOfLast < 0){
                    if(root == null){
                        root = new ArithmeticComponent();
                    }
                    
                    root.addOperand(current);
                    current.setParent(root);
                    current = root;
                    isRoot = true;
                }
                else{
                    current = (ArithmeticComponent) binaryOperatorsStack.toArray()[positionOfLast];
                    isRoot = false;
                }
                
            }
            else if(string.equals("+")){
                    
                    ArithmeticComponent temp = new AddOperator(current);
                    if(current.getParent() != null){

                        List<ArithmeticComponent> operands = current.getParent().getOperands();

                        
                        for (ListIterator<ArithmeticComponent> it = operands.listIterator(); it.hasNext();) {
                            ArithmeticComponent arithmeticComponent = it.next();

                            if(arithmeticComponent.equals(current)){
                                it.set(temp);
                                break;
                            }
                        }

                    }
                    
                    for (ListIterator<ArithmeticComponent> it = binaryOperatorsStack.listIterator(); it.hasNext();) {
                        ArithmeticComponent arithmeticComponent = it.next();
                        
                        if(arithmeticComponent.equals(current)){
                            it.set(temp);
                            break;
                        }
                    }
                    
                    current = temp;

                    if(isRoot){
                        root = current;
                    }
               
            }
            else if(string.equals("-")){
                
                    ArithmeticComponent temp = new SubstractOperator(current);
                    if(current.getParent() != null){

                        List<ArithmeticComponent> operands = current.getParent().getOperands();

                        for (ListIterator<ArithmeticComponent> it = operands.listIterator(); it.hasNext();) {
                            ArithmeticComponent arithmeticComponent = it.next();

                            if(arithmeticComponent.equals(current)){
                                it.set(temp);
                                break;
                            }
                        }

                    }
                    
                    for (ListIterator<ArithmeticComponent> it = binaryOperatorsStack.listIterator(); it.hasNext();) {
                        ArithmeticComponent arithmeticComponent = it.next();
                        
                        if(arithmeticComponent.equals(current)){
                            it.set(temp);
                            break;
                        }
                    }

                    current = temp;

                    if(isRoot){
                        root = current;
                    }
               
            }
            else if(isNumber(string)){
                
                NumericOperand numericOperand = new NumericOperand(Integer.parseInt(string));
                
                if(root == null){
                    root = new ArithmeticComponent();
                    current = root;
                }
                
                root.addOperand(numericOperand);
                numericOperand.setParent(current);
                isRoot = true;
                
                
                
            }
            else{
                throw new NumberFormatException("Dont know how to do it :(");
            }
        }
        
        ArithmeticExpression e = new ArithmeticExpression();
        e.setRoot((BinaryOperator)root);
        
        
        return e;
    }
    
    private ArithmeticComponent addNumericComponent(ArithmeticComponent current, String string, int position){
        
        NumericOperand numericOperand = new NumericOperand(Integer.valueOf(string.substring(position, position+1)));
        numericOperand.setParent(current);
        current.addOperand(numericOperand);
        
        return current;
        
    }

    public ArithmeticExpression buildRPNExpression(RPNExpressionBuilder rpnExpressionBuilder, String string) {
        
        String[] split = string.split(" ");
        
        List<ArithmeticComponent> arithmeticComponentStack = new ArrayList<>();
        ArithmeticComponent current = null;
        ArithmeticComponent root = null;
        
        for(int i = split.length-1; i >= 0; i--){
            
            String input = split[i];
            System.out.println(input);
            
            if(isNumber(input)){
                
                NumericOperand child = new NumericOperand(Integer.parseInt(input));
                
                while(current.getOperands().size() == 2){
                    
                    System.out.println("Both operands full switching curr = "+current);
                    arithmeticComponentStack.remove(arithmeticComponentStack.size()-1);
                    current = arithmeticComponentStack.get(arithmeticComponentStack.size()-1);
                    System.out.println(current);
                }
                
                current.addOperand(child);
                
            }
            else {
                
                
                
                if(input.equals("+")){
                    
                    ArithmeticComponent temp = new AddOperator();
                    if(current != null){
                        current.addOperand(temp);
                        temp.setParent(current);
                    }
                    current = temp;
                    
                    arithmeticComponentStack.add(current);
                    
                    
                    
                    if(root == null){
                        root = current;
                    }
                    
                }
                else if(input.equals("-")){

                    
                    ArithmeticComponent temp = new SubstractOperator();
                    if(current != null){
                        current.addOperand(temp);
                        temp.setParent(current);
                    }
                    current = temp;
                    
                    arithmeticComponentStack.add(current);
                    
                    if(root == null){
                        root = current;
                    }
                }
                else{

                    throw new IllegalArgumentException("Dont know how to do that: "+input);

                }
                
            }
            
        }
        
        ArithmeticExpression e = new ArithmeticExpression();
        e.setRoot((BinaryOperator)root);
        
        return e;
    }
    
    private boolean isNumber(String string){
        
        boolean result = true;
        
        try{
            Integer.parseInt(string);
        }
        catch(NumberFormatException e){
            result = false;
        }
            
        return result;
        
    }
    
}
