package org.xiao.rain.test.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Author: xiaojl
 * Date: 2021/7/5 12:43
 */
public class IoProperties {

    public static void main(String[] args) {

        InputStream input = null;
        try {
            Properties prop = new Properties();
            input = ClassLoader.getSystemClassLoader().getResourceAsStream("text.properties");
            prop.load(input);
            System.out.println(prop.getProperty("username"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
