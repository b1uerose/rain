package org.xiao.rain.test.datastructure.stack;

import java.util.Stack;

/**
 * 用栈求表达式的值
 * Author: xiaojl
 * Date: 2021/11/8 00:06
 */
public class ExpressionStack {

    public static void main(String[] args) throws Exception {
        
        String expression = "5*2-8+5*3=?";
        
        new ExpressionStack().calc(expression);
        
        
    }
    
    public void calc(String expression) throws Exception {
        
        char[] charArray = expression.toCharArray();
        Stack<Number> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
//        Stack<Number> numStack = new Stack<>(100);
//        Stack<String> operatorStack = new Stack<>(100);
        String number= "";
        for (int i = 0; i < charArray.length; i++) {
            char charData = charArray[i];
            if(charData == '=') {
                break;
            }
            
            if(isOperator(charData)) {
                addOperator(charData, numStack, operatorStack);
            } else {
                numStack.push(Integer.valueOf(String.valueOf(charData)));
            }
        }
        
        while (numStack.size() > 1) {

            Number num2 = numStack.pop();
            Number num1 = numStack.pop();

            Character operator = operatorStack.pop();
            
            numStack.push(calc(num1, operator, num2));
        }

        System.out.println("计算的结果为" + numStack.pop());
        
        
        
        
        
    }
    
    private void addOperator(char operator, Stack<Number> numStack, Stack<Character> operatorStack) throws Exception {
        if(operatorStack.isEmpty()) {
            operatorStack.push(operator);
        } else {
            char lastStackOperator = operatorStack.peek();
            
            if(isGreadThan(operator, lastStackOperator)) {
                operatorStack.push(operator);
            } else {
                Number num2 = numStack.pop();
                Number num1 = numStack.pop();
                char calcOperator = operatorStack.pop();
                Number result = calc(num1, calcOperator, num2);
                numStack.push(result);
                addOperator(operator, numStack, operatorStack);
            }
        }
    }
    
    public Number calc(Number num1, char operator, Number num2) {
        int num = 0;
        switch (operator) {
            case '+' :
                num = num1.intValue() + num2.intValue();
                break;
                
            case '-' :
                num = num1.intValue() - num2.intValue();
                break;
                
            case '*' :
                num = num1.intValue() * num2.intValue();
                break;
                
            case '/' :
                num = num1.intValue() / num2.intValue();
                break;
            default:
                break;
        }
        return num;
    }
    
    
    private boolean isGreadThan(char charData, char comparedCharData) {
        
        if((charData == '*' || charData=='/') && (comparedCharData=='+' || comparedCharData=='-')) {
            return true;
        } 
        
        return false;
        
        
    }
    
    private boolean isOperator(char charData) {
        if(charData == '+' || charData=='-' || charData == '*' || charData == '/') {
            return true;
        }
        return false;
    }
    
}
