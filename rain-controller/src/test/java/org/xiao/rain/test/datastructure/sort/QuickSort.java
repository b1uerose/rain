package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

/**
 * 快速排序
 * Author: xiaojl
 * Date: 2021/11/14 11:34
 */
public class QuickSort {

    @Test
    public void sort() {
        int[] array = new int[]{5, 5, 6, 0, 3, 9, 1, 7, 4, 8};
        
//        math.rando

        array = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            array[i] = (int) (Math.random() * 80_000);
        }
        
        long startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime) +"ms");
//        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }

    public int partition(int[] array, int low, int high) {
        int point = array[low];
        while (low < high) {
            while (array[high] >= point && low < high) {
                high--;
            }
            swap(array, low, high);

            while (array[low] <= point && low < high) {
                low++;
            }
            swap(array, low, high);
        }

        return low;
    }

    private void swap(int[] array, int low, int high) {
        if (low == high) {
            return;
        }

        int temp = array[high];
        array[high] = array[low];
        array[low] = temp;
    }
}
