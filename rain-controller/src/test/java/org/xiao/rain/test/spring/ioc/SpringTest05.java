package org.xiao.rain.test.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiao.rain.vo.user.UserVo;

import java.util.ResourceBundle;

/**
 * Author: xiaojl
 * Date: 2021/7/24 17:43
 */
public class SpringTest05 {
    
//    @Test
    public void test01() throws Exception {
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        Object uservo = context.getBean("uservo");
        System.out.println(uservo);

    }
    
//    @Test
    public void test02() throws Exception {
        ResourceBundle bundle = ResourceBundle.getBundle("dev/springdata");
        System.out.println(bundle.getString("username"));
        
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        UserVo uservo = (UserVo) context.getBean("uservo");
        
        System.out.println(uservo);

    }
}
