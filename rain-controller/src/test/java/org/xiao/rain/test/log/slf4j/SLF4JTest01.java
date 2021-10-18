package org.xiao.rain.test.log.slf4j;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: xiaojl
 * Date: 2021/8/16 00:02
 */
public class SLF4JTest01 {
    
    @Test
    public void test() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.error("error信息");
        logger.warn("warn信息");
        logger.info("info信息");
        logger.debug("debug信息");
        logger.trace("trace信息");
    }
}
