package org.xiao.rain.test.singleton.lazy;

/**
 * 单例-懒汉式 线程不安全
 * Author: xiaojl
 * Date: 2021/8/20 23:08
 */
public class SingletonLazyLoadingThreadSafeUseSynchronizedMethod {
    
    //1、私有构造函数
    private SingletonLazyLoadingThreadSafeUseSynchronizedMethod() {
        
    }
    
    //2、静态变量
    private static SingletonLazyLoadingThreadSafeUseSynchronizedMethod m_instance;
    
    //同步方法
    public synchronized static SingletonLazyLoadingThreadSafeUseSynchronizedMethod getInstance() {
        if(m_instance == null) {
            m_instance = new SingletonLazyLoadingThreadSafeUseSynchronizedMethod();
        }
        return m_instance;
    }
}
