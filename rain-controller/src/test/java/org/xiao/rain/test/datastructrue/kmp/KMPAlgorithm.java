package org.xiao.rain.test.datastructrue.kmp;

import java.util.Arrays;

import org.junit.Test;

/**
 * KMP算法
 * Author: xiaojl
 * Date:2022-04-05 22:44
 */
public class KMPAlgorithm {

    @Test
    public void kmpAlgorithm() {

        String oriStr = "BBC ABCDAB ABCDABCDABDE";
        String searchStr = "ABCDABD";
        int[] next = getNextArray(searchStr);
        System.out.println("数组：" + Arrays.toString(next));

        int result = kmpSearch(oriStr, searchStr, next);

        System.out.println(result);

    }

    /**
     * 
     * @param oriStr
     * @param searchStr
     * @param next
     * @return
     */
    public int kmpSearch(String oriStr, String searchStr, int[] next) {
        int oriStrLength = oriStr.length();
        int searchStrLength = searchStr.length();
        int searchStrIndex = 0;
        for (int i = 0; i < oriStrLength; i++) {

            while (searchStrIndex > 0 && oriStr.charAt(i) != searchStr.charAt(searchStrIndex)) {
                searchStrIndex = next[searchStrIndex - 1];
            }

            if (oriStr.charAt(i) == searchStr.charAt(searchStrIndex)) {
                searchStrIndex++;
            }

            if (searchStrIndex == searchStrLength) {
                return i - searchStrIndex + 1;
            }
        }

        return -1;
    }

    public int[] getNextArray(String searchStr) {
        int[] next = new int[searchStr.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < searchStr.length(); i++) {
            while (j > 0 && searchStr.charAt(i) != searchStr.charAt(j)) {
                j = next[j - 1];
            }
            if (searchStr.charAt(i) == searchStr.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
