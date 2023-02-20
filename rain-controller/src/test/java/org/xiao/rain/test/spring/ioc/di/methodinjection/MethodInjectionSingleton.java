package org.xiao.rain.test.spring.ioc.di.methodinjection;


import org.springframework.beans.factory.annotation.Lookup;

/**
 * Author: xiaojl
 * Date:2022-04-25 19:03
 */
public abstract class MethodInjectionSingleton {
    
    public void say() {
        getPrototype().say();
    }

    @Lookup
    public abstract MethodInjectionPrototype getPrototype();
}
