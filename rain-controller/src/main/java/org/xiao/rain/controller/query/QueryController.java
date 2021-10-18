package org.xiao.rain.controller.query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.xiao.rain.exception.BusinessException;
import org.xiao.rain.handler.RainQueryServiceHanlder;
import org.xiao.rain.service.itf.IRainQueryService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Author: xiaojl
 * Date: 2021/7/24 21:33
 */
@Controller
public class QueryController {
    public static void main(String[] args) {
        String path = "applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        IRainQueryService queryService3 = (IRainQueryService) context.getBean("queryService");
        InvocationHandler handler = new RainQueryServiceHanlder(queryService3);
        IRainQueryService proxyService = (IRainQueryService) Proxy.newProxyInstance(queryService3.getClass().getClassLoader(), queryService3.getClass().getInterfaces(), handler);
        try {
            proxyService.doSome();
        } catch (BusinessException e) {
            e.printStackTrace();
        }

    }
}
