package org.xiao.rain.service.test;

import java.util.ArrayList;
import java.util.List;

import org.xiao.rain.dao.test.TestDao;


/**
 * 测试service的代码
 * Author: xiaojl
 * Date: 2021/6/14 14:54
 */
public class TestService {

    public static void testService() {
        System.out.println("test service.....");
        TestDao.testDao();
        System.out.println("TestService.testService");
        System.out.println();
        List<String> list = new ArrayList<String>();
        list.add("String");
        for (String str : list) {
            System.out.println(str);
        }
        
        testHello();
    }
    
    public static void testHello() {
        System.out.println("TestService.testHello");
        
    }
    
}
