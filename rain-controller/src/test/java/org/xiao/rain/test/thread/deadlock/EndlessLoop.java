package org.xiao.rain.test.thread.deadlock;

/**
 * 无限循环，导致cpu占用过高
 * 使用工具查看进程、线程cpu占用情况
 * 1、top
 * 2、ps H -eo pid,tid,%cpu |grep pid
 * 3、jstack 进程id
 * Author: xiaojl
 * Date: 2021/10/3 11:04
 */
public class EndlessLoop {

    public static void main(String[] args) {
        
        while (true) {
            
            
            
        }
        
    }
}
