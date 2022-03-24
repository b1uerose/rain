package org.xiao.rain.test.jvm.gcroots;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Author: xiaojl
 * Date: 2021/10/30 21:12
 */
public class GCRootsTest01 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        Date date = new Date();

        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("添加数据完毕，请操作");
        
        new Scanner(System.in).next();
        
        list = null;
        date = null;

        System.out.println("数据已清空");

        new Scanner(System.in).next();

        System.out.println("结束");
        
    }
}
