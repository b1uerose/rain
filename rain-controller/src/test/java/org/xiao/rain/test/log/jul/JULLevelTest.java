package org.xiao.rain.test.log.jul;

import org.junit.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 设置jul日志的级别
 * Author: xiaojl
 * Date: 2021/8/11 23:22
 */
public class JULLevelTest {
    
    @Test
    public void testLevel() {

        Logger logger = Logger.getLogger(this.getClass().getName());
        
        //1、设置不使用父级的handler
        logger.setUseParentHandlers(false);
        //2、创建handler并设置formatter
        ConsoleHandler handler = new ConsoleHandler();
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        //3、添加handler到当前logger
        logger.addHandler(handler);
        //4、设置日志级别
        logger.setLevel(Level.FINER);
        handler.setLevel(Level.FINER);
        
        
        
        //可以得出默认的日志级别是info
        logger.severe("severe信息");
        logger.warning("warning信息");
        logger.info("info信息");
        logger.config("config信息");
        logger.fine("fine信息");
        logger.finer("finer信息");
        logger.finest("finest信息");
        
        
    }
}
