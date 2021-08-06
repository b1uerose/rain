package org.xiao.rain.test.jvm.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Author: xiaojl
 * Date: 2021/7/15 00:45
 */
public class ClassLoaderTest01 {

    public static void main(String[] args) {
        
        //获取系统类加载器 也就是AppClassLoader
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(appClassLoader);
        
        //扩展类加载器ExtClassLoader
        ClassLoader extClassLoader = appClassLoader.getParent();
        System.out.println(extClassLoader);
        //没有办法获取引用类加载器 也就是启动类加载器 bootstrap classloader
        System.out.println(extClassLoader.getParent());
        System.out.println(String.class.getClassLoader());
        
        
        //自定类的加载器也是appclassloader
        System.out.println(ClassLoaderTest01.class.getClassLoader());
        
        //通过当前线程来获取系统类加载器
        System.out.println(Thread.currentThread().getContextClassLoader());
        
        
        //drivermanager
//        DriverManager.g
        
        //获取bootstrap classloader可以加载的类的路径
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.getPath());
        }
        
        
    }
}
