package org.xiao.rain.test.array;

/**
 * 数组是对象，父类是Object
 * Author: xiaojl
 * Date: 2021/6/27 15:50
 */
public class ArrayTest01 implements Comparable {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6};
        int[] array2 = new int[5];
        System.arraycopy(array1, 1, array2, 0, 2);
        for (int i : array2) {
            System.out.println(i);
        }

        int[] array3 = new int[]{1, 23, 4, 5, 6, 1, 4};
        
    }

    private void dosome() {
        int[] array = {1, 2, 3};
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


