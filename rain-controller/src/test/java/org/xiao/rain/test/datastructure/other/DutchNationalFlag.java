package org.xiao.rain.test.datastructure.other;

import java.util.Arrays;

import org.junit.Test;

/**
 * 荷兰国旗算法
 * Author: xiaojl
 * Date: 2021/11/15 00:18
 */
public class DutchNationalFlag {

    @Test
    public void sort() {

        int[] array = new int[]{5, 2, 6, 0, 3, 3, 3, 9, 1, 7, 4, 3, 3, 8, 3, 3, 10, 11, 3};

        int less = -1;
        int more = array.length;
        int cur = 0;
        int flag = 3;
        while (cur < more) {
            if (array[cur] < flag) {
                swap(array, ++less, cur++);
            } else if (array[cur] > flag) {
                swap(array, --more, cur);
            } else {
                cur++;
            }
        }
        System.out.println(less + 1);
        System.out.println(more - 1);
        System.out.println(Arrays.toString(array));

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
