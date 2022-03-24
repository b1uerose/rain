package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 希尔排序
 * Author: xiaojl
 * Date: 2021/11/13 15:31
 */
public class ShellSort {

    @Test
    public void sort() {
//        int[] array = {10, 1, 4, 2, 7, 9, 8, 3, 6, 5};
        int[] array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80_000);
        }
        shellSort3(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 希尔排序-交换法
     *
     * @param array
     */
    public void shellSort(int[] array) {
        long startTime = System.currentTimeMillis();
        int gap = array.length;
        while (gap > 0) {
            gap = gap / 2;
            for (int i = gap; i < array.length; i++) {
                int j = i;
                while (j - gap >= 0 && array[j] < array[j - gap]) {
                    int temp = array[j];
                    array[j] = array[j - gap];
                    array[j - gap] = temp;
                    j = j - gap;
                }
            }
        }
        System.out.println("花费的时间为:" + (System.currentTimeMillis() - startTime) +"ms");
    }

    /**
     * 平移法
     * @param array
     */
    public void shellSort2(int[] array) {
        long startTime = System.currentTimeMillis();
        int gap = array.length;
        while (gap > 0) {
            gap = gap / 2;
            for (int i = gap; i < array.length; i++) {
                int j = i-gap;
                int temp = array[i];
                while (j >= 0 && temp < array[j]) {
                    array[j+gap] = array[j];
                    j = j-gap;
                }
                
                if(j+gap != i) {
                    array[j+gap] = temp;
                }
            }
        }
        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime) +"ms");
    }
    /**
     * 平移法
     * @param array
     */
    public void shellSort3(int[] array) {
        long startTime = System.currentTimeMillis();
        int gap = array.length;
        while (gap > 0) {
            gap = gap / 2;
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[i];
                if(temp < array[j-gap]) {
                    while (j-gap >= 0 && temp < array[j-gap]) {
                        array[j] = array[j-gap];
                        j = j-gap;
                    }
                    array[j] = temp;
                }
            }
        }
        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime) +"ms");
    }

    private void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int index = i - 1;
            int currentValue = array[i];

            while (index >= 0 && array[index] > currentValue) {
                array[index + 1] = array[index];
                index--;
            }

            array[index + 1] = currentValue;
        }


    }


}
