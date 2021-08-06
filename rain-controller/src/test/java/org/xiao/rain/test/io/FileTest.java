package org.xiao.rain.test.io;

import java.io.File;

/**
 * Author: xiaojl
 * Date: 2021/7/4 17:28
 */
public class FileTest {

    public static void main(String[] args) {
        File file1 = new File("/Users/xiao/Desktop/work/test/abcdef1.txt");
        
        if(file1.exists()) {
            System.out.println(file1.getParent());
            System.out.println(file1.getParentFile().getPath());
            System.out.println(file1.getParentFile().getAbsolutePath());
        } else {
//            try {
//                file1.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }
        
        
        
    }
}
