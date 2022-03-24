package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 计数排序
 * Author: xiaojl
 * Date: 2021/11/18 14:04
 */
public class CounttingSort {

    @Test
    public void sort() {
        int[] array = new int[]{1, -10, -9, -1, -3, 1, 3, 10, 9, 7, 8, 6, 5, 4, 2};
        countingSort(array);
        System.out.println(Arrays.toString(array));
    }

    public void countingSort(int[] array) {
        if (array.length == 1) {
            return;
        }
        int maxValue = array[0];
        int minValue = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            } else if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        //[10, -10]
        //桶的大小
        int bucketLength = maxValue - minValue + 1;
        int[] bucket = new int[bucketLength];

        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            int calcIndex = currentValue - minValue;
            bucket[calcIndex] = ++bucket[calcIndex];
        }

        int tempIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            int count = bucket[i];
            int realValue = i + minValue;
            for (int i1 = 0; i1 < count; i1++) {
                array[tempIndex++] = realValue;
            }
        }
    }
}
