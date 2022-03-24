package org.xiao.rain.test.datastructure.sort;

import org.junit.Test;

import java.util.*;

/**
 * 基数排序
 * Author: xiaojl
 * Date: 2021/11/16 15:40
 */
public class RadixSort {

    @Test
    public void sort() {
        int[] array = new int[]{53, 3, 542, 748, 14, 214,250,777,100,1000};

        array = new int[80000];

        for (int i = 0; i < 80000; i++) {
            array[i] = (int) (Math.random() * 80_000);
        }
        Queue<Integer>[] bucket = new LinkedList[array.length];
        long startTime = System.currentTimeMillis();
        radixSort(array, bucket, 0);
        System.out.println("花费的时间:" + (System.currentTimeMillis() - startTime) +"ms");
//        System.out.println(Arrays.toString(array));
    }
    
    private int getIndex(int num, int dev) {
        int mod = (int) Math.pow(10, dev);
        return num/mod%10;
    }
    
    public void radixSort(int[] array, Queue<Integer>[] bucket, int dev) {
        for (int value : array) {
            int bucketNo = getIndex(value, dev);
            if (bucket[bucketNo] == null) {
                bucket[bucketNo] = new LinkedList<>();
            }
            bucket[bucketNo].add(value);
        }
        if(bucket[0]!= null && !bucket[0].isEmpty() && bucket[0].size() == array.length) {
            return;
        }
        int temp = 0;
        for (Queue<Integer> queue : bucket) {
            if(queue == null) {
                continue;
            }
            while(!queue.isEmpty()) {
                array[temp++]  = queue.poll();
            }
        }
        radixSort(array, bucket, dev+1);
        
    }
}
