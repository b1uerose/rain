package org.xiao.rain.test.spring.ioc.beaninit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 循环依赖2
 * Author: xiaojl
 * Date:2022-05-29 16:45
 */
@Component
public class DependencyBean {
    
    @Autowired
    private DependentBean dependentBean;
    
    
    
}
