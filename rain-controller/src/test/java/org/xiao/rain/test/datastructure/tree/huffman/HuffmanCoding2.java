package org.xiao.rain.test.datastructure.tree.huffman;

import org.junit.Test;
import org.xiao.rain.test.datastructure.tree.TreeNode;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 哈夫曼编码 使用byte方式编码
 * Author: xiaojl
 * Date: 2021/12/12 16:41
 */
public class HuffmanCoding2 {
    
    @Test
    public void testHuffmanCoding() {
//        String str = "i like like like java do you like a java";
        String str = "我是中国人";
        HuffmanData huffmanData = huffmanCoding(str);
        Map<Byte, String> bytePathMap = huffmanData.getBytePathMap();
        List<Byte> byteList = huffmanData.getBytes();
        String lastHuffmanBinaryString = huffmanData.getLastString();
        huffmanDeCoding(bytePathMap, byteList, lastHuffmanBinaryString);
        
    }
    
    public byte[] huffmanDeCoding(Map<Byte, String> bytePathMap, List<Byte> byteList, String lastHuffmanBinaryString) {
        StringBuilder huffmanBinaryString = new StringBuilder();
        for (int i = 0; i < byteList.size()-1; i++) {
            String binaryStr = byteToBinaryString(byteList.get(i), true);
            huffmanBinaryString.append(binaryStr);
        }

        huffmanBinaryString.append(lastHuffmanBinaryString);
        
        //key:binarycode  value:byte
        Map<String, Byte> pathByteMap = new HashMap<String, Byte>();
        for (Map.Entry<Byte, String> entry : bytePathMap.entrySet()) {
            Byte character = entry.getKey();
            String binaryCode = entry.getValue();
            pathByteMap.put(binaryCode, character);
        }

        int startIndex = 0;
        int endIndex = 0;
        List<Byte> resultByteList = new ArrayList<Byte>();
        while(startIndex < huffmanBinaryString.length()) {
            String path = "";
            do {
                endIndex ++;
                if(endIndex >= huffmanBinaryString.length()) {
                    path = huffmanBinaryString.substring(startIndex);
                    break;
                } else {
                    path = huffmanBinaryString.substring(startIndex, endIndex);
                }
            } while(!pathByteMap.containsKey(path));
            byte b = pathByteMap.get(path);
            startIndex = endIndex;
            resultByteList.add(b);
        }
        byte[] bytes = new byte[resultByteList.size()];
        for (int i = 0; i < resultByteList.size(); i++) {
            bytes[i] = resultByteList.get(i);
        }
        
        return bytes;
//        String originalString = new String(bytes);
//        System.out.println(originalString);
    }

    /**
     * byte 转成二进制字符串01010101
     * @param b
     * @param isPolishing
     * @return
     */
    private String byteToBinaryString(byte b, boolean isPolishing) {
        int temp = b;
        if(isPolishing) {
            //正数的话需要补齐八位
            temp |=256;
        }
        String binaryString = Integer.toBinaryString(temp);
        if(isPolishing) {
            return binaryString.substring(binaryString.length() - 8);
        }
        return binaryString;
    }

    /**
     * 霍夫曼编码
     * @param originalString 字符串
     * @return
     */
    public HuffmanData huffmanCoding(String originalString) {
        byte[] bytes = originalString.getBytes(StandardCharsets.UTF_8);
        return getHuffmanCodingData(bytes);
    }

    /**
     * 霍夫曼编码，获取霍夫曼的返回值
     * @param bytes
     * @return object[0]=压缩后的byte数组 object[1]=对照规则(map.key:byte map.value=字节对应霍夫曼二进制值)
     */
    public HuffmanData getHuffmanCodingData(byte[] bytes) {
        //1、计算每个byte出现的次数
        //key:byte value:byte的数量
        Map<Byte, Integer> byteCountMap = new HashMap<>();
        for (byte b : bytes) {
            if (!byteCountMap.containsKey(b)) {
                byteCountMap.put(b, 0);
            }
            byteCountMap.put(b, byteCountMap.get(b) + 1);
        }
        //2、创建huffman树
        TreeNode root = buildHuffmanTree(byteCountMap);
        //3、遍历huffmantree,并获得字符对应的path是多少
        //key:byte  value:路径
        Map<Byte, String> bytePathMap = new HashMap<Byte, String>();
        getCharPathMap(root, bytePathMap, "");

        //4、转换获得霍夫曼编码的一串二进制的字符串 01010100222222.。。。。。。。。。。。。
        StringBuilder codedStr = new StringBuilder();
        for (byte b : bytes) {
            codedStr.append(bytePathMap.get(b));
        }
        //这里的codedStr比原来的字符串还长。需要转换成byte数组
        HuffmanData huffmanData = getByteArryByCodedStr(codedStr);
        huffmanData.setBytePathMap(bytePathMap);
//        List<Byte> byteList = getByteArryByCodedStr(codedStr);
        return huffmanData;
    }

    public HuffmanData getByteArryByCodedStr(StringBuilder codedStr) {
        List<Byte> list = new ArrayList<Byte>();
        String lastStr = "";
        for (int i = 0; i < codedStr.length(); i = i + 8) {
            int end = i + 8;
            String str = "";
            if(end < codedStr.length()) {
                str = codedStr.substring(i, end);
            } else {
                str = codedStr.substring(i);
            }
            lastStr = str;
            byte value = (byte) Integer.parseInt(str, 2);
            list.add(value);
        }
        
        HuffmanData data = new HuffmanData();
        data.setBytes(list);
        data.setLastString(lastStr);
        
        return data;
    }

    public void getCharPathMap(TreeNode treeNode, Map<Byte, String> charPathMap, String path) {
        if (treeNode == null) {
            return;
        }
        TreeNode leftTreeNode = treeNode.getLeftTreeNode();
        TreeNode rightTreeNode = treeNode.getRightTreeNode();
        if (leftTreeNode == null && rightTreeNode == null) {
            charPathMap.put(treeNode.getByteValue(), path);
            return;
        }
        if (leftTreeNode != null) {
            getCharPathMap(leftTreeNode, charPathMap, path + "0");
        }
        if (rightTreeNode != null) {
            getCharPathMap(rightTreeNode, charPathMap, path + "1");
        }
    }


    public TreeNode buildHuffmanTree(Map<Byte, Integer> byteCountMap) {
        LinkedList<TreeNode> deque = new LinkedList<>();

        for (Map.Entry<Byte, Integer> entry : byteCountMap.entrySet()) {
            Byte byteValue = entry.getKey();
            Integer weighted = entry.getValue();
            TreeNode node = new TreeNode(weighted, byteValue, weighted);
            deque.add(node);
        }

        while (deque.size() > 1) {
            Collections.sort(deque);
            TreeNode leftTreeNode = deque.pollFirst();
            TreeNode rightTreeNode = deque.pollFirst();
            int id = leftTreeNode.getId() + rightTreeNode.getId();
            TreeNode parentNode = new TreeNode(id, null);
            parentNode.setLeftTreeNode(leftTreeNode);
            parentNode.setRightTreeNode(rightTreeNode);
            deque.add(parentNode);
        }
        return deque.pollLast();
    }
    
    
    
}
