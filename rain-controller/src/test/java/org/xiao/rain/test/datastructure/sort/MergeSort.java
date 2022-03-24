package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

/**
 * 归并排序
 * Author: xiaojl
 * Date: 2021/11/16 00:00
 */
public class MergeSort {

    @Test
    public void sort() {
        int[] array = new int[]{10,8,4,5,7,1,3,6,2,9};
        array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80_000);
        }
        int[] temp = new int[array.length];
        long startTime = System.currentTimeMillis();
        mergeSort(array, 0, array.length-1, temp);
        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime) +"ms");
//        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] array, int left, int right, int[] temp) {
//        merge(array, left, mid, temp);
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public void merge(int[] array, int left, int mid, int right, int[] temp) {
        int tempIndex = 0;
        int rightIndex = mid + 1;
        int leftIndex = left;
        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] < array[rightIndex]) {
                temp[tempIndex++] = array[leftIndex++];
            } else {
                temp[tempIndex++] = array[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            temp[tempIndex++] = array[leftIndex++];
        }

        while (rightIndex <= right) {
            temp[tempIndex++] = array[rightIndex++];
        }

        tempIndex = 0;
        while (left <= right) {
            array[left++] = temp[tempIndex++];
        }
    }

}
