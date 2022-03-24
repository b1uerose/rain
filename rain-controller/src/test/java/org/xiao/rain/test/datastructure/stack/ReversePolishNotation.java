package org.xiao.rain.test.datastructure.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 逆波兰表达式 也叫做后缀表达是 postfix notation
 * Author: xiaojl
 * Date: 2021/11/9 22:17
 */
public class ReversePolishNotation {

    
    @Test
    public void calc() {
//        (3+4)*5-6
        String reversePolishNotation = "3 4 + 5 * 6 -";
        
        String[] arrays = reversePolishNotation.split(" ");
        Stack<Integer> numberStack = new Stack<>();
        for (String data : arrays) {
            char chardata = data.charAt(0);
           if (isOperator(chardata)) {
               Integer num2 = numberStack.pop();
               Integer num1 = numberStack.pop();
               
               Integer calcResult = (Integer) calc(num1, chardata, num2);
               numberStack.push(calcResult);
           } else {
               numberStack.push(Integer.valueOf(data));
           }
        }
        System.out.println(numberStack.peek());
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

    private boolean isOperator(char charData) {
        if(charData == '+' || charData=='-' || charData == '*' || charData == '/') {
            return true;
        }
        return false;
    }

    private boolean isGreadThan(char charData, char comparedCharData) {
        if((charData == '*' || charData=='/') && (comparedCharData=='+' || comparedCharData=='-')) {
            return true;
        }
        return false;
    }
}
