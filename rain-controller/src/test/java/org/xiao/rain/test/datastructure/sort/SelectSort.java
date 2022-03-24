package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 * Author: xiaojl
 * Date: 2021/11/13 11:15
 */
public class SelectSort {
    
    @Test
    public void sort() {
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        
        selectSorting(array);
        System.out.println(Arrays.toString(array));

        array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80_000);
        }
        selectSorting(array);
        System.out.println(Arrays.toString(array));
        
    }
    
    public void selectSorting(int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int minValue = array[i];
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < minValue) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            
            if(i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
            
        }
        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime)/1000 +"s");
    }
}
