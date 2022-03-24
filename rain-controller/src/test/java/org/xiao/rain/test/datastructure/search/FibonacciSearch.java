package org.xiao.rain.test.datastructure.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 斐波那契查找
 * Author: xiaojl
 * Date: 2021/12/4 23:57
 */
public class FibonacciSearch {
    
    @Test
    public void search() {
        int[] array = new int[] {0,1,2,3,4,5,6,7,8,9,10};
        int searchValue = 10;
        System.out.println(fibonacciSearch(array, searchValue));
    }

    public int fibonacciSearch(int[] array, int searchValue) {
        List<Integer> fibonacciList = getFibonacciList(array.length);
        int lastFibonacciNum = fibonacciList.get(fibonacciList.size() - 1);
        int[] tempArray = Arrays.copyOf(array, lastFibonacciNum);
        if(array.length < lastFibonacciNum) {
            for (int i = array.length; i < lastFibonacciNum; i++) {
                tempArray[i] = array[array.length - 1];
            }
        }
        
        int left = 0;
        int right = array.length - 1;
        int fibonacciIndex = fibonacciList.size() - 1;
        while (left <= right) {
            int mid = left + fibonacciList.get(fibonacciIndex - 1) - 1;
            if(searchValue < tempArray[mid]) {
                right = mid - 1;
                fibonacciIndex--;
            } else if(searchValue > tempArray[mid]) {
                left = mid + 1;
                fibonacciIndex -= 2;
            } else {
                if(mid >= array.length) {
                    return array.length - 1;
                }
                
                return mid;
            }
        }
        

        return -1;
    }

    public List<Integer> getFibonacciList(int length) {
        List<Integer> fibonacciList = new ArrayList<Integer>();
        fibonacciList.add(0);
        fibonacciList.add(1);
        int startIndex = 2;
        do {
            fibonacciList.add(fibonacciList.get(startIndex - 1) + fibonacciList.get(startIndex - 2));
        } while (fibonacciList.get(startIndex++) < length);
        return fibonacciList;
    }
}
