package org.xiao.rain.test.datastructure.dynamicprogramming;

import org.junit.Test;

/**
 * 数组中是否存在一组数字，使得这些数字之和，等于某个数组
 * array:[3,34,4,12,5,2]。是否存在数组中的人一个数字之和等于9
 * Author: xiaojl
 * Date:2022-03-22 12:54
 */
public class ExistsSubSet {
    
    @Test
    public void test() {
        System.out.println("1233");
        int[] array = new int[]{3,34,4,12,5,2};

        System.out.println(subset_recursive(array, array.length-1, 9));
        System.out.println(subset_dynamicProgramming(array, 9));
    }


    /**
     * 递归
     * @param array
     * @param i
     * @param subValue
     * @return
     */
    public boolean subset_recursive(int[] array, int i, int subValue) {
        if (array[i] == subValue) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        if (array[i] > subValue) {
            return subset_recursive(array, i-1, subValue);
        }
        boolean chooseCurrentIndex = subset_recursive(array, i-1, subValue-array[i]);
        boolean unChooseCurrentIndex = subset_recursive(array, i-1, subValue);
        return chooseCurrentIndex || unChooseCurrentIndex;
    }
    
    public boolean subset_dynamicProgramming(int[] array, int subValue) {
        boolean[][] chached = new boolean[array.length][subValue + 1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <= subValue; j++) {
                if (array[i] == j) {
                    chached[i][j] = true;
                } else if(i ==0) {
                    chached[i][j] = false;
                } else if(array[i] > j) {
                    chached[i][j] = chached[i-1][j];
                } else {
                    chached[i][j] = chached[i-1][j] || chached[i-1][j-array[i]];
                }
            }
        }
        return chached[array.length-1][subValue];
    }
}
