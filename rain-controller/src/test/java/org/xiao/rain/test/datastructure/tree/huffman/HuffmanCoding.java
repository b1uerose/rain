package org.xiao.rain.test.datastructure.tree.huffman;

import org.junit.Test;
import org.xiao.rain.test.datastructure.tree.TreeNode;

import java.util.*;

/**
 * 哈夫曼编码 - char
 * Author: xiaojl
 * Date: 2021/12/11 22:23
 */
public class HuffmanCoding {
    
    public void huffmanDecode(Map<Character, String> charPathMap, List<Byte> byteList) {
        StringBuilder huffmanBinaryString = new StringBuilder();
        for (int i = 0; i < byteList.size(); i++) {
            boolean isPolishing = (i != byteList.size()-1);
            String binaryStr = byteToBinaryString(byteList.get(i), isPolishing);
//            System.out.println("byte" +byteList.get(i) +",binarystr:" + binaryStr);
            huffmanBinaryString.append(byteToBinaryString(byteList.get(i), isPolishing));
        }
        
        //key:binarycode  value:字符
        Map<String, Character> pathCharMap = new HashMap<String, Character>();

        for (Map.Entry<Character, String> entry : charPathMap.entrySet()) {
            Character character = entry.getKey();
            String binaryCode = entry.getValue();
            pathCharMap.put(binaryCode, character);
        }
        int startIndex = 0;
        int endIndex = 1;
        StringBuilder finalString = new StringBuilder();
        while(startIndex < huffmanBinaryString.length()) {
            while (!pathCharMap.containsKey(huffmanBinaryString.substring(startIndex, endIndex))) {
                endIndex ++;
            }

            finalString.append(pathCharMap.get(huffmanBinaryString.substring(startIndex, endIndex)));

            startIndex = endIndex;
            endIndex = startIndex + 1;
        }

        System.out.println(finalString);
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
    
    public List<Byte> getHuffmanCodeBytes(String originalData) {
        char[] chars = originalData.toCharArray();
        //1、计算每个字符的次数
        //key:字符  value:数量
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char character : chars) {
            if (!charCountMap.containsKey(character)) {
                charCountMap.put(character, 0);
            }
            charCountMap.put(character, charCountMap.get(character) + 1);
        }
        
        //2、构造一棵huffmantree
        TreeNode treeNode = buildHuffmanTree(charCountMap);
        //3、遍历huffmantree,并获得字符对应的path是多少
        //key:字符  value:路径
        Map<Character, String> charPathMap = new HashMap<Character, String>();
        getCharPathMap(treeNode, charPathMap, "");
        //4、转换获得霍夫曼编码的一串二进制的字符串 01010100222222.。。。。。。。。。。。。
        StringBuilder codedStr = new StringBuilder();
        for (char character : chars) {
            codedStr.append(charPathMap.get(character));
        }
//        System.out.println(codedStr.toString());
        //5、8个一组转换成byte
        //这里的codedStr比原来的字符串还长。需要转换成byte数组
        List<Byte> byteList = getByteArryByCodedStr(codedStr);

        
        //huffman编码 反编码
        huffmanDecode(charPathMap, byteList);
        
        return byteList;
    }

    @Test
    public void huffmanCoding() {
        String originalData = "i like like like java do you like a java";
//        char[] chars = originalData.toCharArray();
//        //key:字符  value:数量
//        Map<Character, Integer> charCountMap = new HashMap<>();
//        for (char character : chars) {
//            if (!charCountMap.containsKey(character)) {
//                charCountMap.put(character, 0);
//            }
//            charCountMap.put(character, charCountMap.get(character) + 1);
//        }
//
//        //构造一颗huffmantree
//        TreeNode treeNode = buildHuffmanTree(charCountMap);
//
//        //遍历huffmantree,并获得字符对应的code是什么
//        //key:字符  value:路径
//        Map<Character, String> charPathMap = new HashMap<Character, String>();
//        getCharPathMap(treeNode, charPathMap, "");
//
//        StringBuilder codedStr = new StringBuilder();
//        for (char character : chars) {
//            codedStr.append(charPathMap.get(character));
//        }
//        System.out.println(codedStr.toString());
//        //这里的codedStr比原来的字符串还长。需要转换成byte数组
        List<Byte> byteList = getHuffmanCodeBytes(originalData);

//        System.out.println(byteList);

    }

    public List<Byte> getByteArryByCodedStr(StringBuilder codedStr) {
        List<Byte> list = new ArrayList<Byte>();
        for (int i = 0; i < codedStr.length(); i = i + 8) {
            int end = i + 8;
            String str = "";
            if(end < codedStr.length()) {
                str = codedStr.substring(i, end);
            } else {
                str = codedStr.substring(i);
            }
            byte value = (byte) Integer.parseInt(str, 2);
            list.add(value);
        }

//        System.out.println(list);
        return list;
    }


    public void getCharPathMap(TreeNode treeNode, Map<Character, String> charPathMap, String path) {

        if (treeNode == null) {
            return;
        }

        TreeNode leftTreeNode = treeNode.getLeftTreeNode();
        TreeNode rightTreeNode = treeNode.getRightTreeNode();

        if (leftTreeNode == null && rightTreeNode == null) {
            charPathMap.put(treeNode.getCharacter(), path);
            return;
        }

        if (leftTreeNode != null) {
            getCharPathMap(leftTreeNode, charPathMap, path + "0");
        }

        if (rightTreeNode != null) {
            getCharPathMap(rightTreeNode, charPathMap, path + "1");
        }

    }

    public TreeNode buildHuffmanTree(Map<Character, Integer> charCountMap) {
        LinkedList<TreeNode> deque = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            Character character = entry.getKey();
            Integer countTime = entry.getValue();

            TreeNode node = new TreeNode(countTime, character);
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
    
    @Test
    public void test() {
        byte b = 1;
        System.out.println(Integer.toBinaryString(b));
    }
}
