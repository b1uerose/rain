package org.xiao.rain.test.datastructure.sparsearray;

/**
 * 稀疏数组
 * Author: xiaojl
 * Date: 2021/9/12 22:53
 */
public class SparseArray {


    public static void main(String[] args) {
        
        int[][] sparseArray = new int[11][11];
        sparseArray[0][1] = 1;
        sparseArray[1][2] = 2;
        printArray("二维数组", sparseArray);
//        
//        sparseArray[0] = new int[]{0,1,2,0,0,0,0,0,0,0,0};
//        sparseArray[1] = new int[]{0,0,2,0,0,0,0,0,0,0,0};
//        sparseArray[2] = new int[]{0,0,0,0,0,0,0,0,0,0,0};
//        sparseArray[3] = new int[]{0,0,0,0,0,0,0,1,0,0,0};
//        sparseArray[4] = new int[]{0,0,0,0,0,0,2,0,0,0,0};
//        sparseArray[5] = new int[]{0,0,0,0,0,0,0,0,0,1,0};
//        sparseArray[6] = new int[]{0,0,0,0,0,1,0,0,0,0,0};
//        sparseArray[7] = new int[]{0,0,0,2,0,0,0,0,0,0,0};
//        sparseArray[8] = new int[]{0,0,0,0,0,1,0,0,0,0,0};
//        sparseArray[9] = new int[]{0,0,0,0,0,0,2,0,0,0,0};
//        sparseArray[10] = new int[]{0,0,0,0,0,0,0,0,1,0,0};
        
        int count = 0;
        for (int i = 0; i < sparseArray.length; i++) {
            int[] ints = sparseArray[i];
            for (int anInt : ints) {
                if(anInt != 0) {
                    count++;
                }
            }
        }
        int index = 0;
        int[][] array = new int[count+1][3];
        array[index][0] = sparseArray[0].length;
        array[index][1] = sparseArray.length;
        array[index][2] = count;

        for (int i = 0; i < sparseArray.length; i++) {
            int[] ints = sparseArray[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if(anInt == 0) {
                    continue;
                }
                ++index;
                array[index][0] = i;
                array[index][1] = j;
                array[index][2] = anInt;
            }
        }

        printArray("转换后的数组", array);
        
        int[][] resultArray = new int[array[0][0]][array[0][1]];
        for (int i = 1; i < array.length; i++) {
            int[] ints = array[i];
            resultArray[ints[0]][ints[1]] = ints[2];
        }
        printArray("转回来的数组", resultArray);
        
    }
    
    private static void printArray(String message, int[][] array) {
        System.out.println("=================="+message +"==================");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }
            System.out.println();
        }
        
        
    }
    
    
    
    
    
}
