package org.xiao.rain.test.singleton.hungry;

/**
 * 单例模式
 * 饿汉式-静态代码块
 * Author: xiaojl
 * Date: 2021/8/20 22:49
 */
public class SingletonHungryStaticBlock {
    
    //1、构造函数私有化，防止外部new
    private SingletonHungryStaticBlock() {
    }
    
    //2、静态常量
    private static SingletonHungryStaticBlock m_instance;
    static {
        m_instance = new SingletonHungryStaticBlock();
    }
    
    
    //3、提供外部调用的静态方法
    public static SingletonHungryStaticBlock getInstance() {
        return m_instance;
    }
    
}
