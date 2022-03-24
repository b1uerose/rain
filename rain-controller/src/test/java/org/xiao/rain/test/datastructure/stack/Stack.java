package org.xiao.rain.test.datastructure.stack;

/**
 * 栈
 * Author: xiaojl
 * Date: 2021/11/6 13:30
 */
public class Stack<T> {
    
    private int top = -1;
    //        this.array = new T[initLength];
    private T[] array;
    
    public Stack(int initLength) {
        this.array = (T[])new Object[100];
    }
    
    public void push(T value) {
        array[++top] = value;
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public T pop() {
        if(isEmpty()) {
            throw new RuntimeException("栈是空的，无法出栈！！！！");
        }
        return array[top--];
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>(100);
        stack.push("hello");
        stack.push("world");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
    }
}
