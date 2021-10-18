package org.xiao.rain.test.singleton.lazy;

/**
 * 单例-懒汉式 静态内部类
 * 1、外部类加载的时候，静态内部类是不会被加载的
 * 2、类加载是线程安全的。
 * jvm类的加载的时候是线程安全的
 * Author: xiaojl
 * Date: 2021/8/20 23:08
 */
public class SingletonLazyLoadingThreadSafeInnerClass {
    
    //1、私有构造函数
    private SingletonLazyLoadingThreadSafeInnerClass() {
        
    }
    
    private static class SingletonInstance {
        public final static SingletonLazyLoadingThreadSafeInnerClass INSTANCE = new SingletonLazyLoadingThreadSafeInnerClass();
    }
    
    //同步方法
    public static SingletonLazyLoadingThreadSafeInnerClass getInstance() {
        return  SingletonInstance.INSTANCE;
    }
}
