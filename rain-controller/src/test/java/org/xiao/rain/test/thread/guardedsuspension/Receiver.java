package org.xiao.rain.test.thread.guardedsuspension;

import lombok.extern.slf4j.Slf4j;

/**
 * 接受者
 * Author: xiaojl
 * Date: 2021/9/20 22:32
 */
@Slf4j
public class Receiver extends Thread {

    @Override
    public void run() {
        GuardedObject guardedObject = MessageContainer.createGuardObject();
        log.debug("开始接受消息");
        Object o = guardedObject.get(5000);
        log.debug("接受到的内容{}", o);
    }
}
