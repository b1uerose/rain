package org.xiao.rain.test.jvm.jvmstack;

/**
 * -Xss设置虚拟机栈的大小
 * 默认为1024k
 * -Xss256k
 * Author: xiaojl
 * Date: 2021/7/17 00:14
 */
public class StackErrorTest01 {
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);

    }
}
