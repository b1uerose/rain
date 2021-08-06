package org.xiao.rain.test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件拷贝
 * Author: xiaojl
 * Date: 2021/7/4 16:52
 */
public class FileCopyTest01 {
    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        

        try {
            fis = new FileInputStream("/Users/xiao/Desktop/work/test/abcdef.txt");
            fos = new FileOutputStream("/Users/xiao/Desktop/work/test/copy/abcdef.txt");
            
            
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount=fis.read(bytes))!=-1) {
                fos.write(bytes, 0, readCount);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
