package org.xiao.rain.test.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiao.rain.vo.user.UserVo;

/**
 * 自动绑定引用类型
 * 
 * Author: xiaojl
 * Date: 2021/7/24 15:01
 */
public class SpringTest04 {
    
//    @Test
    public void test01() throws Exception {
        String path = "testApplicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        UserVo user = (UserVo) context.getBean("user");
        System.out.println(user);
    }
    
//    @Test
    public void test02() throws Exception {
       String path = "applicationContext.xml";
       ApplicationContext context = new ClassPathXmlApplicationContext(path);
       UserVo userVo = (UserVo) context.getBean("user");
        System.out.println(userVo);
    }
}
