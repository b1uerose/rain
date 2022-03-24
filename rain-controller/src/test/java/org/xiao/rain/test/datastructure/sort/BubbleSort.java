package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

/**
 * 冒泡排序
 * Author: xiaojl
 * Date: 2021/11/13 09:41
 */
public class BubbleSort {

    @Test
    public void sort() {
        int[] array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80_000);
        }
        bubbleSorting(array);
    }

    public void bubbleSorting(int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            boolean isSwap = false;
            for (int j = 1; j < array.length - i; j++) {
                int preIndex = j - 1;
                if (array[preIndex] > array[j]) {
                    int temp = array[j];
                    array[j] = array[preIndex];
                    array[preIndex] = temp;
                    isSwap = true;
                }
            }

            if (!isSwap) {
                break;
            }
        }
        System.out.println("排序花费的时间:" + (System.currentTimeMillis() - startTime)/1000 +"s");
    }
}
