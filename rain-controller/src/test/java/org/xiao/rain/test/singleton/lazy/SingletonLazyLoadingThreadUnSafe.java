package org.xiao.rain.test.singleton.lazy;

/**
 * 单例-懒汉式 线程不安全
 * Author: xiaojl
 * Date: 2021/8/20 23:08
 */
public class SingletonLazyLoadingThreadUnSafe {
    
    //1、私有构造函数
    private SingletonLazyLoadingThreadUnSafe() {
        
    }
    
    //2、静态变量
    private static SingletonLazyLoadingThreadUnSafe m_instance;
    
    //3、提供公共方法
    public static SingletonLazyLoadingThreadUnSafe getInstance() {
        if(m_instance == null) {
            m_instance = new SingletonLazyLoadingThreadUnSafe();
        }
        return m_instance;
    }
}
