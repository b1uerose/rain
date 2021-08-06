package org.xiao.rain.test.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiao.rain.vo.user.UserVo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用spring配置文件给bean设置值
 * Author: xiaojl
 * Date: 2021/7/24 07:33
 */
public class SpringTest02 {

    /**
     * Spring容器来调用set方法给对象赋值 <property name="vcode" value="xiaojl"/>
     * @throws Exception
     */
//    @Test
    public void test01() throws Exception {
        String path = "testApplicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        UserVo user = (UserVo) context.getBean("user");
        System.out.println(user);

        Date mydate = (Date) context.getBean("myDate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(mydate));
        
        
        
    }
}
