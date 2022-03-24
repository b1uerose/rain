package org.xiao.rain.test.datastructure.recursion;

/**
 * 八皇后
 * 8x8的棋盘 任意两个皇后不能处于棋盘的同一行、同一列和同一条对角线上
 * Author: xiaojl
 * Date: 2021/11/11 22:41
 */
public class EightQueen2 {
    
    private static int count = 0;
    private static int[] array = new int[8];

    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }
    
    public static void check(int row) {
        if(row >= 8) {
            count ++;
            for (int result : array) {
                System.out.print(result + 1 +" ");
            }
            System.out.println(" ");
            return;
        }

        for (int columnNo = 0; columnNo < 8; columnNo++) {
            array[row] = columnNo;
            //是否在同一列或者对角线上
            if(judge(row, columnNo)) {
                check(row + 1);
            }
        }
    }

    /**
     * 是否在同一列或者对角线上
     * @param curRowNo
     * @param columnNo
     * @return
     */
    private static boolean judge(int curRowNo, int columnNo) {
        for (int preQueenRowNo = 0; preQueenRowNo < curRowNo; preQueenRowNo++) {
            if(array[preQueenRowNo] == columnNo || Math.abs(curRowNo-preQueenRowNo) == Math.abs(columnNo-array[preQueenRowNo])) {
                return false;
            }
        }
        return true;
    }
    
}
