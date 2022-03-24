package org.xiao.rain.test.jvm.gc;

/**
 * 查看使用的垃圾回收器
 * -XX:+PrintComandLineFlags
 * -XX:+UseSerialGC 新生代使用串行的垃圾回收器，老年代使用serialoldgc
 * Author: xiaojl
 * Date: 2021/11/4 23:44
 */
public class GCUseTest {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
