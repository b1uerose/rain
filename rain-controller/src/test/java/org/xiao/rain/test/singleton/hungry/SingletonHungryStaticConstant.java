package org.xiao.rain.test.singleton.hungry;

/**
 * 单例模式
 * 饿汉式-静态常量
 * Author: xiaojl
 * Date: 2021/8/20 22:49
 */
public class SingletonHungryStaticConstant {
    
    //1、构造函数私有化，防止外部new
    private SingletonHungryStaticConstant() {
    }
    
    //2、静态常量
    private final static SingletonHungryStaticConstant m_instance = new SingletonHungryStaticConstant();
    
    //3、提供外部调用的静态方法
    public static SingletonHungryStaticConstant getInstance() {
        return m_instance;
    }
    
}
