package org.xiao.rain.test.innerclass;

/**
 * Author: xiaojl
 * Date: 2021/7/3 18:58
 */
public class InnerClassTest {
    private int number = 100;
    private class InnerClass {
        int number = 200;
        public void test() {
            System.out.println(this.number);
            System.out.println(InnerClassTest.this.number);
        }
    }
    
    private static class staticInnnerClass {
        public void test() {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        InnerClassTest test = new InnerClassTest();
        InnerClassTest.InnerClass inner = test.new InnerClass();
        inner.test();
        
        InnerClassTest.staticInnnerClass xxx = new InnerClassTest.staticInnnerClass();
    }
}
