package org.xiao.rain.test.datastructure.search;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 二分查找。需要一个有序的数组
 * Author: xiaojl
 * Date: 2021/11/17 23:25
 */
public class BinarySearch {
    @Test
    public void search() {
        int[] array = new int[]{-1, 9, 50, 60, 87, 102, 102, 520, 600};

//        List<Integer> list = binarySearch(array, 0, array.length - 1, 102);

//        System.out.println(list.toString());
        
       List<String> list = new ArrayList<String>();
        

        System.out.println(binarySearch(array, 87));
    }


    public List<Integer> binarySearch(int[] array, int left, int right, int searchValue) {
        if (left > right) {
            return new ArrayList<>();
        }
        //中间的索引
        int mid = (left + right) / 2;

        if (array[mid] < searchValue) {
            return binarySearch(array, mid + 1, right, searchValue);
        } else if (array[mid] > searchValue) {
            return binarySearch(array, left, mid - 1, searchValue);
        } else {
            List<Integer> resultList = new ArrayList<Integer>();
            int leftIndex = mid - 1;
            int rightIndex = mid + 1;
            while (leftIndex >= 0 && array[leftIndex] == array[mid]) {
                resultList.add(leftIndex--);
            }

            resultList.add(mid);
            while (right < array.length && array[rightIndex] == array[mid]) {
                resultList.add(rightIndex++);
            }

            return resultList;
        }
    }
    
    public int binarySearch(int[] array, int searchValue) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {

            int mid = (left + right) / 2;

            if (array[mid] == searchValue) {
                return mid;
            } else if (array[mid] > searchValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}
