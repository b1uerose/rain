package org.xiao.rain.test.singleton.lazy;

/**
 * 单例-懒汉式 双重检查
 * Author: xiaojl
 * Date: 2021/8/20 23:08
 */
public class SingletonLazyLoadingThreadSafeDoubleCheck {
    
    //1、私有构造函数
    private SingletonLazyLoadingThreadSafeDoubleCheck() {
        
    }
    
    //2、静态变量 volatile禁止指令重排。并且保证对所有的线程可见
    private volatile static SingletonLazyLoadingThreadSafeDoubleCheck m_instance;
    
    //同步方法
    public static SingletonLazyLoadingThreadSafeDoubleCheck getInstance() {
        if(m_instance == null) {
            synchronized (SingletonLazyLoadingThreadSafeDoubleCheck.class) {
                if(m_instance == null) {
                    m_instance = new SingletonLazyLoadingThreadSafeDoubleCheck();
                }
            }
        }
        return m_instance;
    }
}
