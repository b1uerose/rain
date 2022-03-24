package org.xiao.rain.test.datastructrue.dynamicprogramming;

import org.junit.Test;

/**
 * 一组数字不相邻之和的最大值
 * 动态规划 dynamic programming
 * Author: xiaojl
 * Date:2022-03-20 15:13
 */
public class NoAdjacentMaxSum {
    
    @Test
    public void test() {
        int[] array = new int[]{1,2,4,1,7,8,4};
        System.out.println( calc(array));
    }

    public int calc(int[] array) {
        int[] maxSumArray = new int[array.length];
        if (array == null || array.length == 0) {
            return 0;
        }
        int arrayLength = array.length;
        if (arrayLength == 1) {
            maxSumArray[0] = array[0];
        }
        if (arrayLength == 2) {
            maxSumArray[1] = Math.max(array[0], array[1]);
        }
        for (int j = 2; j < array.length; j++) {
            maxSumArray[j] = Math.max(maxSumArray[j-1], maxSumArray[j-2] + array[j]);
        }
        return maxSumArray[arrayLength - 1];
    }
}
