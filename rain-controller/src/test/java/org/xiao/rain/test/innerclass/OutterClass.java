package org.xiao.rain.test.innerclass;

/**
 * Author: xiaojl
 * Date: 2021/6/27 10:20
 */
public class OutterClass {
    
    public class StartAddr {
        public StartAddr() {
            System.out.println("内部类" + this.getClass().getSimpleName());
        }
    }
    
    public class EndAddr {
        public EndAddr() {
            System.out.println("内部类" + this.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        
        OutterClass outterClass = new OutterClass();
        StartAddr startAddr = outterClass.new StartAddr();
        
        
    }
    
//    public void doSome() {
//        OutterClass.StartAddr startaddr = new OutterClass.StartAddr();
//        
//        OutterClass outClass = new OutterClass();
//        
//        StartAddr startAddr = outClass.new StartAddr();
//    }
}
