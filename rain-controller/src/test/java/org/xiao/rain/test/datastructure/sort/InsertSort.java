package org.xiao.rain.test.datastructure.sort;

import java.util.Arrays;

import org.junit.Test;

/**
 * 插入排序
 * Author: xiaojl
 * Date: 2021/11/13 14:04
 */
public class InsertSort {
    
    @Test
    public void sort() {
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        insertSort2(array);
        System.out.println(Arrays.toString(array));

        array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80_000);
        }
        insertSort2(array);
    }

    /**
     * 推荐写法 平移法
     * @param array
     */
    public void insertSort2(int[] array) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < array.length; i++) {
            int index = i-1;
            int curValue = array[i];
            while(index >=0 && array[index]>curValue) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = curValue; 
        }
        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime)/1000 +"s");
    }
    
    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            for (int j = 0; j < i; j++) {
                if(array[i] <= array[j]) {
                    for (int k = i; k > j; k--) {
                        array[k] = array[k-1];
                    }
                    array[j] = value;
                }
            }
        }
    }
    
    private void swap(int[] array, int firstIndex, int secondeIndex) {
        
        
    }
}
