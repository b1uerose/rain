package org.xiao.rain.test.spring.ioc.di.lazyinit;

import org.springframework.beans.factory.DisposableBean;

/**
 * 懒加载的bean
 * Author: xiaojl
 * Date:2022-04-24 23:11
 */
public class LazyInit implements DisposableBean {
    
    public LazyInit() {
        System.out.println("LazyInit init");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("LazyInit destroy");
    }
}
