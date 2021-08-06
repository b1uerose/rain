package org.xiao.rain.test.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiao.rain.vo.user.UserVo;

/**
 * 通过构造函数来初始化对象
 * Author: xiaojl
 * Date: 2021/7/24 08:30
 */
public class SpringTest03 {
    
//    @Test
    public void test01() throws Exception {
        String path = "testApplicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        UserVo user2 = (UserVo) context.getBean("user2");
        System.out.println(user2);
    }
    
}
