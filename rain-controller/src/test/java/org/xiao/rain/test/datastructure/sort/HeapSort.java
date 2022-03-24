package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序
 * Author: xiaojl
 * Date: 2021/12/8 09:28
 */
public class HeapSort {
    
    @Test
    public void heapSort() {
        
        int[] array = new int[]{4, 6, 8, 5, 9,30};

        for (int j = array.length/2 - 1; j >=0 ; j--) {
            adjustHeap(array, j, array.length - 1);
        }
        swap(array, 0, array.length - 1);

        for (int i = 1; i < array.length; i++) {
            int maxIndex = array.length - 1 - i;
            adjustHeap(array, 0, maxIndex);
            swap(array, 0, maxIndex);
        }
//        for (int i = 0; i < array.length; i++) {
//            int length = array.length - 1 - i;
//            for (int j = array.length/2 - 1; j >=0 ; j--) {
//                adjustHeap(array, j, length);
//            }
//            swap(array, 0, length);
//        }

        System.out.println(Arrays.toString(array));
    }
    
    public void adjustHeap(int[] array, int index, int maxIndex) {
        int leftTreeNodeIndex = 2*index + 1;
        int rightTreeNodeIndex = 2*index + 2;
        
        int largerIndex = index;
        if(leftTreeNodeIndex <= maxIndex && array[largerIndex] < array[leftTreeNodeIndex]) {
            largerIndex = leftTreeNodeIndex;
        }
        
        if(rightTreeNodeIndex <= maxIndex && array[largerIndex] < array[rightTreeNodeIndex]) {
            largerIndex = rightTreeNodeIndex;
        }
        
        if(largerIndex != index) {
            //交换数据
            swap(array, index, largerIndex);
            adjustHeap(array, largerIndex, maxIndex);
        }
    }
    
    public void swap(int[] array, int curIndex, int largerIndex) {
        int temp = array[curIndex];
        array[curIndex] = array[largerIndex];
        array[largerIndex] = temp;
    }
    
}
