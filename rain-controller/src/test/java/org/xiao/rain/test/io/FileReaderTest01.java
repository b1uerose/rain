package org.xiao.rain.test.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author: xiaojl
 * Date: 2021/7/4 16:57
 */
public class FileReaderTest01 {

    public static void main(String[] args) {
        FileReader fd = null;
        FileWriter fw  = null;
        try {
            fd = new FileReader("/Users/xiao/Desktop/work/test/abcdef.txt");
            fw = new FileWriter("/Users/xiao/Desktop/work/test/copy/copyabcdef.txt");
            
            char[] chars = new char[512*1024];
            int readCount = 0;
            while ((readCount = fd.read(chars))!=-1) {
                fw.write(chars, 0, readCount);
            }
            fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fd != null) {
                try {
                    fd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
