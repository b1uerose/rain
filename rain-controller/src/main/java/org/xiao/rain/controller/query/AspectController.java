package org.xiao.rain.controller.query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiao.rain.exception.BusinessException;
import org.xiao.rain.service.itf.IRainQueryService;

/**
 * Author: xiaojl
 * Date: 2021/7/25 15:46
 */
public class AspectController {

    public static void main(String[] args) {
        
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        IRainQueryService service = (IRainQueryService) context.getBean("queryService");
        try {
            String retmsg = service.doSome();
            System.out.println(retmsg);
            System.out.println("==============");
            String doOther = service.doOther();
            System.out.println(doOther);
            System.out.println("==============");
            String doAround = service.doAround();
            System.out.println("doAround的执行结果为：" + doAround);
            System.out.println("==============");
            String exception = service.doException();
            System.out.println("==============");
            service.doAfter();
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }
}
