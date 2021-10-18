package org.xiao.rain.test.thread.guardedsuspension;

import lombok.extern.slf4j.Slf4j;

/**
 * 发送者
 * Author: xiaojl
 * Date: 2021/9/20 22:32
 */
@Slf4j
public class Sender extends Thread {
    
    private int id;
    private String message;

    public Sender(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GuardedObject guardedObject = MessageContainer.getGuardById(id);
        log.debug("send "+message);
        guardedObject.Complete(message);

    }
}
