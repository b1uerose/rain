package org.xiao.rain.test.spring.ioc.beaninit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 循环依赖1
 * Author: xiaojl
 * Date:2022-05-29 16:44
 */
@Component
public class DependentBean {
    
    @Autowired
    public DependencyBean dependencyBean;
    
    
    
}
