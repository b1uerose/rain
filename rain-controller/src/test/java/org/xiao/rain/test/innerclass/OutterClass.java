package org.xiao.rain.test.innerclass;

/**
 * Author: xiaojl
 * Date: 2021/6/27 10:20
 */
public class OutterClass {
    
    class startAddr {
        public startAddr() {
        }
    }
    
    class endAddr {
        public endAddr() {
        }
    }

    public static void main(String[] args) {
    }
    
    public void doSome() {
        OutterClass.startAddr startaddr = new OutterClass.startAddr();
    }
}
