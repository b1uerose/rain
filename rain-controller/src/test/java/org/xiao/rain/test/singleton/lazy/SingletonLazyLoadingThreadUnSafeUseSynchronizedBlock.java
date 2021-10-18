package org.xiao.rain.test.singleton.lazy;

/**
 * 单例-懒汉式 线程不安全
 * Author: xiaojl
 * Date: 2021/8/20 23:08
 */
public class SingletonLazyLoadingThreadUnSafeUseSynchronizedBlock {
    
    //1、私有构造函数
    private SingletonLazyLoadingThreadUnSafeUseSynchronizedBlock() {
        
    }
    
    //2、静态变量
    private static SingletonLazyLoadingThreadUnSafeUseSynchronizedBlock m_instance;
    
    //同步方法
    public static SingletonLazyLoadingThreadUnSafeUseSynchronizedBlock getInstance() {
        if(m_instance == null) {
            synchronized (SingletonLazyLoadingThreadUnSafeUseSynchronizedBlock.class) {
                m_instance = new SingletonLazyLoadingThreadUnSafeUseSynchronizedBlock();
            }
        }
        return m_instance;
    }
}
