package org.xiao.rain.test.io;

import org.xiao.rain.test.bean.UserVo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Author: xiaojl
 * Date: 2021/7/4 23:32
 */
public class ObjectInputStreamTest01 {

    public static void main(String[] args) {
        String filePath = "/Users/xiao/Desktop/work/test/student";
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(filePath));
            oos.writeObject(new UserVo(100, "xiaojl"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
