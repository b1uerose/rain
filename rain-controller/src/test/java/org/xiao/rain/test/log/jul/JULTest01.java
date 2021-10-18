package org.xiao.rain.test.log.jul;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Author: xiaojl
 * Date: 2021/8/11 22:54
 */
public class JULTest01 {
    
    @Test
    public void test01() {

        Logger logger = Logger.getLogger(this.getClass().getName());
        
        logger.info("输出了info信息1");
        logger.log(Level.INFO, "输出了info信息2");
        
        //链接字符串
        
        String name="肖金龙";
        int age = 33;
        
        logger.log(Level.INFO, "姓名为:{0},年龄为{1}", new Object[]{name, age});
        
        
    }
    
}
