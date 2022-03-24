package org.xiao.rain.test.base64;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2022/2/16 18:15
 */
public class Base64ToFile {

    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            String fileName = "/Users/xiao/Desktop/银行回单.pdf";
            fis = new FileInputStream("/Users/xiao/Desktop/回单base64.txt");
            StringBuilder sb = new StringBuilder();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fis.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            fos = new FileOutputStream(fileName);
            byte[] bytes = Base64.getDecoder().decode(sb.toString());
            fos.write(bytes);
            fos.flush();
        } catch (IOException e) {
            
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                }
            }

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
