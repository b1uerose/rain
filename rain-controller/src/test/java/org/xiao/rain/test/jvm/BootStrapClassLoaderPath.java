package org.xiao.rain.test.jvm;

import java.net.URL;

import lombok.extern.slf4j.Slf4j;
import sun.misc.Launcher;

/**
 * 
 * Author: xiaojl
 * Date: 2021/10/21 12:26
 */
@Slf4j
public class BootStrapClassLoaderPath {

    public static void main(String[] args) {
        log.debug("*******************启动类加载器加载类所在路径*******************");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            log.debug(url.getPath());
        }
    }
}
