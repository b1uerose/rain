package org.xiao.rain.test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/7/4 13:38
 */
public class FileInputStreamTest01 {
    public static void main(String[] args) {
        
        String path = "/Users/xiao/Desktop/work/test/abcdef.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            int readcount = 0;
            byte[] bytes = new byte[4];
            while ((readcount = fis.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0 , readcount));
            }
            
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
            
        }


    }
}
