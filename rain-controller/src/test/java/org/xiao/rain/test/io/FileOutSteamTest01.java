package org.xiao.rain.test.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/7/4 15:17
 */
public class FileOutSteamTest01 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        String fileName = "/Users/xiao/Desktop/work/test/outputtest.txt";
        try {
            fos = new FileOutputStream(fileName);
            byte[] bytes = new byte[] {97, 98, 99, 100};
            fos.write(bytes);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
