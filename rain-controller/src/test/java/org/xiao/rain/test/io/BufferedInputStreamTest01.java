package org.xiao.rain.test.io;

import java.io.*;

/**
 * Author: xiaojl
 * Date: 2021/7/4 17:03
 */
public class BufferedInputStreamTest01 {

    public static void main(String[] args) {
        BufferedInputStream bis = null;
        FileInputStream fis;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(""));
            String line = br.readLine();
            
            

            fis = new FileInputStream("/Users/xiao/Desktop/work/test/abcdef.txt");
            bis = new BufferedInputStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
