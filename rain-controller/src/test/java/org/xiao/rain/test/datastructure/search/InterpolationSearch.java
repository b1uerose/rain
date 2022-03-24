package org.xiao.rain.test.datastructure.search;

import org.junit.Test;

/**
 * 插值查找算法
 * Author: xiaojl
 * Date: 2021/12/4 15:44
 */
public class InterpolationSearch {

    @Test
    public void search() {
        int[] array = new int[]{0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        int searchValue = 200;
        System.out.println(interpolationSearch(array, 0, array.length-1, searchValue));

    }

    public int interpolationSearch(int[] array, int left, int right, int searchValue) {
        if (left > right || searchValue < array[left] || searchValue > array[right]) {
            return -1;
        }
        int midIndex = left + (right - left) * (searchValue - array[left]) / (array[right] - array[left]);
        int midValue = array[midIndex];
        if (midValue > searchValue) {
            interpolationSearch(array, midIndex + 1, right, searchValue);
        } else if (midValue < searchValue) {
            interpolationSearch(array, left, midIndex - 1, searchValue);
        }
        return midIndex;
    }
}
