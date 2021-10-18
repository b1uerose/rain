package org.xiao.rain.test.log.jul;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 将日志文件输出到磁盘中
 * Author: xiaojl
 * Date: 2021/8/11 23:42
 */
public class JULLogFileTest {
    
    @Test
    public void logFile() {
        Logger logger = Logger.getLogger(this.getClass().getName());
        
        logger.setUseParentHandlers(false);

        try {
            FileHandler handler = new FileHandler("/Users/xiao/Desktop/logger01.log");
            SimpleFormatter formatter = new SimpleFormatter();
            handler.setFormatter(formatter);
            logger.addHandler(handler);
            //可以得出默认的日志级别是info
            logger.severe("severe信息");
            logger.warning("warning信息");
            logger.info("info信息");
            logger.config("config信息");
            logger.fine("fine信息");
            logger.finer("finer信息");
            logger.finest("finest信息");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
