package org.xiao.rain.test.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Author: xiaojl
 * Date: 2021/7/8 22:58
 */
public class RelectTest01 {

    public static void main(String[] args) {
        //1、获取绝对路径
        String path = Thread.currentThread().getContextClassLoader().getResource("text.properties").getPath();
        System.out.println(path);
        
        //2、用流的方式
        InputStream in = null;
        Properties prop = new Properties();
        try {
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream("text.properties");
            prop.load(in);
            System.out.println(prop.getProperty("username"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //3、资源绑定器
        ResourceBundle bundle = ResourceBundle.getBundle("text");
        String username = bundle.getString("username");
        System.out.println(username);
    }
}
