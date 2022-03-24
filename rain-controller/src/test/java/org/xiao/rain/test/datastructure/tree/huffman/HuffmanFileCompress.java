package org.xiao.rain.test.datastructure.tree.huffman;

import org.junit.Test;

import java.io.*;

/**
 * 哈夫曼压缩文件
 * Author: xiaojl
 * Date: 2021/12/12 22:00
 */
public class HuffmanFileCompress {
    
    @Test
    public void compress() {
        String srcFilePath = "/Users/xiao/Desktop/假勤申请.sql";
        String targetPath = "/Users/xiao/Desktop/假勤申请.zip";
        compressFile(srcFilePath, targetPath);
    }
    
    @Test
    public void unCompress() {
        String srcFilePath = "/Users/xiao/Desktop/假勤申请.zip";
        String targetPath = "/Users/xiao/Desktop/假勤申请2.sql";
        unCompressFile(srcFilePath, targetPath);
    }

    public void unCompressFile(String srcFilePath, String tarFilePath) {
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        try {
            fis= new FileInputStream(srcFilePath);
            ois = new ObjectInputStream(fis);
            HuffmanData huffmanData = (HuffmanData) ois.readObject();

            byte[] bytes = new HuffmanCoding2().huffmanDeCoding(huffmanData.getBytePathMap(), huffmanData.getBytes(),
                    huffmanData.getLastString());
            fos = new FileOutputStream(tarFilePath);
            fos.write(bytes);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void compressFile(String srcFilePath, String tarFilePath) {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fis = new FileInputStream(srcFilePath);
            
            byte[] bytes = new byte[fis.available()];

            fis.read(bytes);

            HuffmanData huffmanData = new HuffmanCoding2().getHuffmanCodingData(bytes);
            fos = new FileOutputStream(tarFilePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(huffmanData);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
