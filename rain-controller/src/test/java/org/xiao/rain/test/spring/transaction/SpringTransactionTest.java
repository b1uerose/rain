package org.xiao.rain.test.spring.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiao.rain.exception.BusinessException;
import org.xiao.rain.service.itf.IBuyGoodBusiness;

/**
 * Author: xiaojl
 * Date: 2021/8/10 07:41
 */
public class SpringTransactionTest {
    
    @Test
    public void test01() {
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        //这个businss是个代理对象
        IBuyGoodBusiness business = (IBuyGoodBusiness) context.getBean("buyGoodService");
//        System.out.println(business);
//        System.out.println(business.getClass().getName());
        
        try {
            business.buy(300, 200);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }
}
