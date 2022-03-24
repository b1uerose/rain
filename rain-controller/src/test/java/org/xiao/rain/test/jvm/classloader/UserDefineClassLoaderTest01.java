package org.xiao.rain.test.jvm.classloader;

/**
 * Author: xiaojl
 * Date: 2021/7/15 12:40
 */
public class UserDefineClassLoaderTest01 extends ClassLoader {

    public static void main(String[] args) {
        
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        
        byte[] classBytes = getClass(name);
        
        defineClass(name, classBytes, 0, classBytes.length);
        
        return defineClass(name, classBytes, 0, classBytes.length);
    }
    
    private byte[] getClass(String name)  {
        
        
        return null;
    }
}
