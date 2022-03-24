package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * Author: xiaojl
 * Date: 2021/11/14 11:34
 */
public class QuickSort2 {

    @Test
    public void sort() {
        int[] array = new int[]{5, 5, 6, 0, 3, 9, 1, 7, 4, 8};

        array = new int[8000000];

        for (int i = 0; i < 8000000; i++) {
            array[i] = (int) (Math.random() * 80_000);
        }

        long startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println(Arrays.toString(array));
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int[] p = partition(array, low, high);
            quickSort(array, low, p[0] - 1);
            quickSort(array, p[1] + 1, high);
        }
    }

    public int[] partition(int[] array, int low, int high) {
        //low和high之间随机找一个数字
        int randomIndex = new Random().nextInt(high  - low + 1) + low;
        int cur = low;
        int less = low - 1;
        int more = high + 1;
        int pivot = array[randomIndex];
        while (cur < more) {
            if (array[cur] < pivot) {
                swap(array, ++less, cur++);
            } else if (array[cur] > pivot) {
                swap(array, --more, cur);
            } else {
                cur++;
            }
        }

        return new int[]{less + 1, more - 1};
    }

    private void swap(int[] array, int low, int high) {
        if (low == high) {
            return;
        }

        int temp = array[high];
        array[high] = array[low];
        array[low] = temp;
    }
    
    @Test
    public void testRandom() {
        int low = 0;
        int high = 9;

        for (int i = 0; i < 10000; i++) {
            int randomIndex = new Random().nextInt(high  - low + 1) + low;
            System.out.print(randomIndex +" ");
            
        }
        
        
    }
}
