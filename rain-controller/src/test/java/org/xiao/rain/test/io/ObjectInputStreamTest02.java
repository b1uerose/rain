package org.xiao.rain.test.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Author: xiaojl
 * Date: 2021/7/4 23:38
 */
public class ObjectInputStreamTest02 {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("/Users/xiao/Desktop/work/test/student"));
            Object obj = ois.readObject();
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
