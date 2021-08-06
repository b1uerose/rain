package org.xiao.rain.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: xiaojl
 * Date: 2021/7/24 21:44
 */
public class RainQueryServiceHanlder implements InvocationHandler {
    
    private Object object;

    public RainQueryServiceHanlder(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));
        //输出日期
        Object result = null; 
        result = method.invoke(object, args);
        
        //事务处理
        System.out.println("正在处理事务");
        
        return result;
    }
}
