package org.xiao.rain.test.datastructure.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 * Author: xiaojl
 * Date: 2021/11/9 22:49
 */
public class InfixExpressionCovertToPostfixExpression {
    
    @Test
    public void covert() {
        String inFixExpression = "1+((2+3)*4)-5";
        
        char[] charDatas = inFixExpression.toCharArray();
        Stack<Character> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i < charDatas.length; i++) {
            char charData = charDatas[i];
            
            if(!isOperator(charData)) {
                numStack.push(charData);
            } else {
                if(operatorStack.isEmpty()) {
                    operatorStack.push(charData);
                    continue;
                }
                if(isRightParenthesis(charData)) {
                    char operator = operatorStack.pop();
                    while (!isLeftParenthesis(operator)) {
                        numStack.push(operator);
                        operator = operatorStack.pop();
                    }
                } else if(isLeftParenthesis(charData)) {
                    operatorStack.push(charData);
                } else {
                    
                    char topOperator = operatorStack.peek();
                    
                    while(getPriority(charData) <= getPriority(topOperator)) {
                        numStack.push(operatorStack.pop());
                        if(operatorStack.isEmpty()) {
                            break;
                        }
                        topOperator = operatorStack.peek();
                    }
                    operatorStack.push(charData);
                }
            }
        }
        
        while (!operatorStack.isEmpty()) {
            numStack.push(operatorStack.pop());
        }
        
        
        while(!numStack.isEmpty()) {
            operatorStack.push(numStack.pop());
        }

        while (!operatorStack.isEmpty()) {
            System.out.println(operatorStack.pop());
        }
        
        
    }

    private boolean isOperator(char charData) {
        if(charData == '+' || charData=='-' || charData == '*' || charData == '/'|| charData == '(' || charData == ')') {
            return true;
        }
        return false;
    }
    
    private int getPriority(char charData) {
        
        if(charData == '+' || charData=='-') {
            return 1;
        }
        
        if(charData == '*' || charData == '/') {
            return 0;
        }
        
        return -1;
    }
    
    private boolean isLeftParenthesis(char charData) {
        if(charData == '(') {
            return true;
        }
        return false;
    }
    private boolean isRightParenthesis(char charData) {
        if(charData == ')') {
            return true;
        }
        return false;
    }
    
    
    
}
