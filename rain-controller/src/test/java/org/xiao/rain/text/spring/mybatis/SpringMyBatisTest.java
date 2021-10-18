package org.xiao.rain.text.spring.mybatis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiao.rain.service.itf.IRainQueryService;
import org.xiao.rain.vo.user.UserVo;

import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/8/9 00:05
 */
public class SpringMyBatisTest {
    
    @Test
    public void test01() {
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        String[] beanNames = context.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println("spring容器中的beanid = " + name);
        }

        IRainQueryService service = (IRainQueryService) context.getBean("queryService");

        List<UserVo> userVos = service.queryUserVos();
        for (UserVo userVo : userVos) {
            System.out.println(userVo);
        }

    }
}
