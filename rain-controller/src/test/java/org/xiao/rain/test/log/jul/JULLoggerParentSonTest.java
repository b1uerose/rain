package org.xiao.rain.test.log.jul;

import org.junit.Test;

import java.util.logging.Logger;

/**
 * jul日志的父子关系
 * Author: xiaojl
 * Date: 2021/8/12 00:23
 */
public class JULLoggerParentSonTest {
    
    @Test
    public void test() {
        Logger logger1 = Logger.getLogger("org.xiao.rain.test.log.jul");
        Logger logger2 = Logger.getLogger("org.xiao.rain.test.log.jul.JULLoggerParentSonTest");

        System.out.println(logger1 == logger2.getParent());

        System.out.println("logger1的父级：" + logger1.getParent() +",父级名称" + logger1.getParent().getName() + ",当前名称：" + logger1.getName());
        System.out.println("logger2的父级：" + logger2.getParent() +",父级名称" + logger2.getParent().getName() + ",当前名称：" + logger2.getName());

    }
}
