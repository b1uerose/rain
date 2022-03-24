package org.xiao.rain.test.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: xiaojl
 * Date: 2021/10/21 12:30
 */
@Slf4j
public class ExtClassLoaderPath {

    public static void main(String[] args) {
        String extDir = System.getProperty("java.ext.dirs");
        String[] dirs = extDir.split(";");
        for (String dir : dirs) {
        }
    }
    
}
