package org.xiao.rain.test.thread.guardedsuspension;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Author: xiaojl
 * Date: 2021/9/20 23:03
 */
public class GuardedSuspensionTest {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Receiver().start();
        }
        Set<Integer> ids = MessageContainer.getIds();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Integer id : ids) {
            new Sender(id, "内容"+id).start();
        }
        
    }
}
