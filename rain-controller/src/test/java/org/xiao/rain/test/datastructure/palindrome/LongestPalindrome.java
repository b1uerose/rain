package org.xiao.rain.test.datastructure.palindrome;

import org.junit.Test;

/**
 * 最长回文子串
 * Author: xiaojl
 * Date:2022-04-10 15:17
 */
public class LongestPalindrome {

    @Test
    public void longestPalindrome() {

        String str = "cdefbaab";
        //回文子串一定是对称的
        //有两种对称方式， 一种是 bab 另一种是 baab。奇数位数的对称和偶数位数的对称

        //暴力解法
        String longestPalindrome = "";
        for (int i = 0; i < str.length(); i++) {
            int[] maxArray = new int[2];
            int[] arr1 = expandAroundCenter(str, i, i);
            maxArray = arr1;
            int[] arr2 = new int[2];
            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                arr2 = expandAroundCenter(str, i, i + 1);
                int arr1Length = arr1[1] - arr1[0] + 1;
                int arr2Length = arr2[1] - arr2[0] + 1;
                if (arr2Length > arr1Length) {
                    maxArray = arr2;
                }
            }
            String palindromeSubStr = "";
            if (maxArray[1] + 1 >= str.length()) {
                palindromeSubStr = str.substring(maxArray[0]);
            } else {
                palindromeSubStr = str.substring(maxArray[0], maxArray[1] + 1);
            }

            if (palindromeSubStr.length() > longestPalindrome.length()) {
                longestPalindrome = palindromeSubStr;
            }
        }

        System.out.println(longestPalindrome);


    }

    private int[] expandAroundCenter(String str, int leftIndex, int rightIndex) {
        while (leftIndex >= 0 && rightIndex < str.length() && str.charAt(leftIndex) == str.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return new int[]{++leftIndex, --rightIndex};
    }

    @Test
    public void manacherAlgorithm() {

        String str = "";
        //字符串的字符之间都加上#   abcabc->#a#b#c#a#b#c# 让字符都变成奇数位数的字符
        String newStr = addBoundaries(str);
        int length = newStr.length();
        int[] p = new int[length];
        //已经找到的最大回文子串的有边界
        int rightBoundary = 0;
        int center = 0;
        //最大回文子串长度
        int maxLength = 1;
        
        int maxPalindromStartIndex = 0;
        for (int i = 0; i < length; i++) {
            int i_mirror = getMirror(i, center);
            //判断当前i是否超过了边界
            if (rightBoundary > i) {
                //如果没有的话，可以获得当前i的的初始步长
                p[i] = Math.min(rightBoundary-i, p[i_mirror]);
            } else {
                p[i] = 0;
            }
            
            int left = i-1-p[i];
            int right = i+1+p[i];
            while (newStr.charAt(right) == newStr.charAt(left) && left >=0 && right < length) {
                left--;
                right++;
                p[i]++;
            }
            
            
            
            if (i+p[i] > rightBoundary) {
                rightBoundary = i+p[i];
                center = i;
            }
            
            if(p[i] > maxLength) {
                maxLength = p[i];
                maxPalindromStartIndex = (i-maxLength)/2;
            }
            
            
        }


    }

    public int getMirror(int i, int center) {
        return 2 * center - 1;
    }

    public String addBoundaries(String str) {

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i)).append("#");
        }
        return sb.toString();


    }


}
