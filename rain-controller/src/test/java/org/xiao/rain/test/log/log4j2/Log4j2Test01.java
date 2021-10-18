package org.xiao.rain.test.log.log4j2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: xiaojl
 * Date: 2021/8/17 22:20
 */
public class Log4j2Test01 {
    
    @Test
    public void test() throws Exception {

        Logger logger = LoggerFactory.getLogger(this.getClass());
        for (int i = 0; i < 4000; i++) {
            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");  
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println("------------------------");
        }
//        Logger logger = LogManager.getLogger(this.getClass());
        
    }
}
