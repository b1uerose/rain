package org.xiao.rain.test.jvm.heap;

/**
 * 新生代中 eden和survivor0和survivor1的比例
 * 1、 -XX:-UseAdaptivePolicy 无效
 * 2、 -XX:SurvivorRatio=8 默认是8 虽然没有效果
 * Author: xiaojl
 * Date: 2021/7/19 22:47
 * 命令行查看 jps 查看进程
 * 然后 jinfo -flag SurviviorRatio <进程id>
 */
public class UseAdaptivePolicy {
    public static void main(String[] args) {
        System.out.println("测试eden、survivor中的比例");

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
