package org.xiao.rain.test.jvm.heap;

/**
 * 逃逸分析，在栈上分配内存
 * -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 * Author: xiaojl
 * Date: 2021/7/22 19:29
 */
public class EscapeAnalysisTest01 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        System.out.println("创建对象的花费时间:" + (System.currentTimeMillis()-startTime) +"ms");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void alloc() {
        User user = new User();
    }
}

class User {}
