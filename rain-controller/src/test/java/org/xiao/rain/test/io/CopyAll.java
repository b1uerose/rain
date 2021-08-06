package org.xiao.rain.test.io;

import java.io.*;

/**
 * Author: xiaojl
 * Date: 2021/7/4 22:17
 */
public class CopyAll {

    public static void main(String[] args) {
        //拷贝源
        File source = new File("/Users/xiao/Desktop/work/test/source");
        //拷贝目标路径
        File target = new File("/Users/xiao/Desktop/work/test/target");
        //拷贝

        try {
            copyDir(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void copyDir(File source, File target) throws IOException {
        if (!source.exists()) {
            System.out.println("不存在拷贝的路径");
            return;
        }

        File[] allFiles = source.listFiles();
        if (allFiles == null || allFiles.length == 0) {
            return;
        }
        for (int i = 0; i < allFiles.length; i++) {
            File childFile = allFiles[i];
            File newFile = new File(target, childFile.getName());
            if(newFile.exists()) {
                continue;
            }
            if (childFile.isDirectory()) {
                newFile.mkdir();
                copyDir(childFile, newFile);
            }

            if (childFile.isFile()) {
                newFile.createNewFile();
                copyFile(childFile, newFile);
            }
        }
    }

    private static void copyFile(File srcFile, File targetFile){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(targetFile);
            
            byte[] bytes = new byte[1024*1024];
            int readCount = 0;
            while((readCount=fis.read(bytes))!=-1) {
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
