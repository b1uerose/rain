package org.xiao.rain.test.spring.ioc.di.lazyinit;

import org.springframework.beans.factory.DisposableBean;

/**
 * 实时初始化的bean
 * Author: xiaojl
 * Date:2022-04-24 23:13
 */
public class PreInstantiated implements DisposableBean {
    
    public PreInstantiated() {
        System.out.println("实时初始化的bean");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("PreInstantiated destroy");
    }
}
