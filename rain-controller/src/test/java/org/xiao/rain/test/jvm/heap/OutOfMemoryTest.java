package org.xiao.rain.test.jvm.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * Author: xiaojl
 * Date: 2021/7/21 22:48
 */
public class OutOfMemoryTest {
    
    byte[] buffer = new byte[new Random().nextInt(1024*1024)];
    public static void main(String[] args) {
        List<OutOfMemoryTest> list = new ArrayList<OutOfMemoryTest>();
        while (true) {
            list.add(new OutOfMemoryTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
