package org.xiao.rain.test.designpattern.command;

/**
 * 命令接受者
 * Author: xiaojl
 * Date: 2021/8/29 23:43
 */
public class Receiver {
    
    public void action() {
        System.out.println("接受到了命令");
    }
    
    public void undo() {
        System.out.println("取消了命令");
    }
}
